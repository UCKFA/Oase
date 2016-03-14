/*Transition for Domains*/
var cur = '#new';
var activeChatWindow = '';
var openChatWindows = [
];
function change(x, cur) {
    if (x != cur) {
        $(cur).fadeOut('slow');
        $(x).fadeIn('slow');
        return x;
    } else
    return cur;
};
function windowIsOpened(wId) {
    for (var window in openChatWindows) {
        if (openChatWindows[window] == wId)
        	return true;
    }
    return false;
}
function appendChatWindow(active, win, userid) {
	openChatWindows.push(userid);
    if (active)
    $('#myTabContent').append('<div class="tab-pane fade in active display" id="' + win
    + '" data-userid=' + userid + '></div>');
     else
    $('#myTabContent').append('<div class="tab-pane fade display" id="' + win
    + '"data-userid=' + userid + '></div>');
}
function appendChatWindowTab(active, win) {
    if (active)
    $('#chat>ul').append($('<li class="active"><a id="' + win + 'Tab" href="#' + win
    + '" data-toggle="tab">' + win + '</a></li>'));
     else
    $('#chat>ul').append($('<li class=""><a id="' + win + 'Tab" href="#' + win
    + '" data-toggle="tab">' + win + '</a></li>'));
}
$(document).ready(function () {
	
	
    $(cur).show();
    $('#changeCars').click(function () {
        cur = change('#cars', cur);
    });
    $('#changeNew').click(function () {
        cur = change('#new', cur);
    });
    $(document).on('click', '#registerButton', function () {
        change('#register', '#login');
    });
    $(document).on('click', '#topic', function () {
        
        $("#"+$(this).attr('data-comments')).slideDown();
    });
    $(document).on('click', '#slideUpButton', function () {
        
        $("#"+$(this).attr('data-comments')).slideUp();
    });
    
    $(document).on("click", "#PostTopic", function() {
    	$("#postTopicForm").fadeIn();
    });

    $(document).on("click", "#cancelPost", function() {
    	$("#postTopicForm").fadeOut();
    });


});
