<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Async Uploader</title>

    <script type="text/javascript" language="JavaScript ">

        function requestThumbnail () {
            var fileInput = document.getElementById("fileInput");
            if (fileInput.files.length === 0) {
                alert("choose a file!");
                return;
            }

            // packing composite form
             var fieldName = document.getElementById("username");
             if (fieldName.value === "") {
                 alert("Username empty!");
                 fieldName.focus ();
                 return;
             }

             var passwordField = document.getElementById("password");

             var myFormData = new FormData ();
             myFormData.append("username", fieldName.value);
             myFormData.append("password", passwordField.value);

             for (var i = 0; i < fileInput.files.length; i++) {
                 var filename = fileInput.files[i].name;
                 myFormData.append(filename, fileInput.files[i]);
             }

            var progressBar = document.getElementById("progressBar");
            var ajax = new XMLHttpRequest();
            ajax.responseType = "blob";
            ajax.upload.onprogress = function (e) {
                var percent = (e.loaded / e.total) * 100;
                progressBar.value = percent;
            };

            ajax.onload = function () {
                if (ajax.status === 200) {
                    var urlCreator = window.URL || window.webkitURL;
                    var base64Image = urlCreator.createObjectURL(ajax.response);

                    var img = document.createElement("IMG");
                    //img.style.margin = "5px";
                    img.src = base64Image;

                    progressBar.value = 0;

                    var thumbsContainer = document.getElementById("thumbsContainer");
                    thumbsContainer.appendChild(img);
                } else {
                    console.log("Error");
                }
            }

            ajax.onerror = function () {
                console.log("Error connecting backend...");
            }

            progressBar.value = 0;

            ajax.open("POST", "uploadAsync", true);
            //sending simple form
            //ajax.setRequestHeader("Content-Type", fileInput.files[0].type);
            //ajax.send(fileInput.files[0]);

            //sending composite form
            ajax.send(myFormData);
        }

    </script>

</head>
<body>
    <!-- simple form -->
    <!--<form>
        <input type = "file" id = "fileInput" accept =".jpeg,.jpg,.png" />
        <button onclick = "requestThumbnail();" type="button">Upload</button><br />
        <progress id = "progressBar" max = "100" value = "0"></progress>
    </form>-->

    <div style="border: 1px solid red" id="thumbsContainer"></div>

    <!-- composite form -->
    <form>
        Username: <input type="text" id="username" name="username" /><br />
        Password: <input type="password" id="password" name="password" /><br />
        <input type = "file" id = "fileInput" accept =".jpeg,.jpg,.png" multiple />
        <button onclick = "requestThumbnail();" type="button">Upload</button><br />
        <progress id = "progressBar" max = "100" value = "0"></progress>
    </form>

</body>
</html>