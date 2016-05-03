/**
 * Created by Brinzoiu on 3/22/2016.
 */
'use strict';

 // global variable used for saving one user uploaded image.
var fileToLoad;
var interestPoints;
var ImageLoad = function() {
 interestPoints = [];
  var ctx = null;
  var filesSelected = document.getElementById("inputFileToLoad").files;
  if (filesSelected.length > 0) {
    fileToLoad = filesSelected[0];

    if (fileToLoad.type.match("image.*")) {
      var fileReader = new FileReader();

      fileReader.onload = function (fileLoadedEvent) {
        var imageHolder = document.createElement("canvas");
        var drawArea = document.getElementById("modal-body");
        var __user_image__ = new Image();


        imageHolder.id = "current_image";

        __user_image__.src = fileLoadedEvent.target.result;
        ctx = imageHolder.getContext("2d");
        console.log(drawArea);
        drawArea.appendChild(imageHolder);

        drawArea.style.display = "block";


        __user_image__.onload = function () {
          imageHolder.setAttribute("height", __user_image__.height + "px");
          imageHolder.setAttribute("width", __user_image__.width + "px");
          ctx.drawImage(__user_image__, 0, 0);

          imageHolder.addEventListener("click", function (evt) {
            drawMark(evt);
          });
        };
      };
      fileReader.readAsDataURL(fileToLoad);
      return true;
    }
  } else {
    return false;
  }
};
