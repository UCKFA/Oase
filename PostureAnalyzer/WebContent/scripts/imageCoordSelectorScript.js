/**
 *  Written by Brinzoiu Bogdan
 */
var getImageCoordinates = function() {
	var filesSelected = document.getElementById("inputFileToLoad").files;
    if (filesSelected.length > 0)
    {
        var fileToLoad = filesSelected[0];

        if (fileToLoad.type.match("image.*"))
        {
            var fileReader = new FileReader();
            fileReader.onload = function(fileLoadedEvent) 
            {
                var imageLoaded 	=	 document.createElement("canvas");
                var imageClickMode  =    document.createElement("div");
                
                imageClickMode.id	= "image_click_mode"; 
                imageLoaded.id 		= "image_window";
               
                console.log("here");
                document.body.appendChild(imageClickMode);
                imageClickMode.appendChild(imageLoaded);
                
            };
            fileReader.readAsDataURL(fileToLoad);
            return true;
        }
    } else {
    	console.log("here");
    	return false;
    }
	
}