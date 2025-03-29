<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Viewer</title>

    <script type="text/javascript" language="JavaScript">

        document.addEventListener ("DOMContentLoaded",
            function (e) {
                var x1, y1, x2, y2;
                var clicked = false;

                var element = document.getElementById("launch");
                element.style.cursor = "crosshair";

                //var canvas = document.createElement("canvas");
                //canvas.width = element.width;
                //canvas.height = element.height;

                //const container = document.createElement("div");
                //container.className = "container";

                //element.parentNode.replaceChild (container, element);
                //container.appendChild (element);
                //container.appendChild (canvas);

                //const ctx = canvas.getContext("2d");

                //
                //event button mouse down
                //
                element.addEventListener("mousedown", function (e) {
                    clicked = true;

                    //const rect = canvas.getBoundingClientRect();
                    x1 = e.clientX; // - rect.left;
                    y1 = e.clientY; // - rect.top;
                    console.log("Started point ", "X: " + x1 + ", Y:" + y1);

                    e.preventDefault();
                }, false);


                //
                //event button mouse up
                //
                element.addEventListener("mouseup", function (e) {
                    clicked = false;

                    //const rect = canvas.getBoundingClientRect ();
                    x2 = e.clientX; // - rect.left;
                    y2 = e.clientY; // - rect.top;
                    console.log("Ended point ", "X: " + x2 + ", Y:" + y2);

                    cut (x1, y1, x2, y2, element);
                    //ctx.clearRect (0, 0, canvas.width, canvas.height);

                    e.preventDefault();
                }, false);

                //
                //event button mouse move
                //
                element.addEventListener("mousemove", function (e) {
                    if (clicked) {
                        //const rect = canvas.getBoundingClientRect();
                        x2 = e.clientX; // - rect.left - rect.left;
                        y2 = e.clientY; // - rect.top - rect.top;

                        //ctx.clearRect(0, 0, canvas.width, canvas.height);
                        //ctx.strokeStyle = "red";
                        //ctx.lineWidth = 2;
                        //ctx.strokeRect (
                        //    Math.min (x1, x2),
                        //    Math.min (y1, y2),
                        //    Math.abs (x2 - x1),
                        //    Math.abs (y2 - y1)
                        //);
                    }

                    e.preventDefault();
                }, false);
            });

        // Sends an AJAX request to the CutterServlet with the coordinates of the selected area.
        // Updates the image source with the cropped image returned by the server.
        function cut (x1, y1, x2, y2, img) {
            console.log ("Calling cutter function with params", "x1=" + x1, "y1=" + y1, "x2=" + x2, "y2=" + y2);
            var ajax = new XMLHttpRequest();
            ajax.responseType = "blob";

            ajax.onreadystatechange = function (data) {
                if (ajax.readyState === 4) {
                    if (ajax.status === 200) {
                        var urlCreator = window.URL || window.webkitURL;
                        var base64Image = urlCreator.createObjectURL(ajax.response);
                        img.src = base64Image;
                    }
                }
            };

            ajax.open("GET", "Cutter?x1=" + x1 + "&y1=" + y1 + "&x2=" + x2 + "&y2=" + y2, true);
            ajax.send();
        }

    </script>

</head>
<body>
    <img src="images/launch.jpg" alt="launch.jpg" id="launch" />
</body>
</html>