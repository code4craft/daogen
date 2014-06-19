function transformInverse(x, y, out, width, height, factor) {
    var cycle = Math.min(width * 1.0, height * 1.0);
    var centerX = width / 2.0
    var centerY = height / 2.0;
    var xCentered = Math.round(x - centerX);
    var yCentered = Math.round(y - centerY);
    var radius = Math.sqrt((xCentered * xCentered + yCentered * yCentered));
    if (radius == 0) {
        return;
    }
    if (radius > centerX || radius > centerY) {
        out[0] = x;
        out[1] = y;
        return;
    }
    transformInverseCentered(xCentered, yCentered, out, radius, cycle,
        factor);
    out[0] += centerX;
    out[1] += centerY;
}

function transformInverseCentered(x, y, out, radius, cycle, factor) {
    var offset = Math.sin(radius / cycle * Math.PI * 2) * factor;
    var angleOld = Math.acos(x / radius);
    if (y < 0) {
        angleOld = 2 * Math.PI - angleOld;
    }
    var angleNew = angleOld + offset * 1.0 / radius;
    out[0] = Math.round(Math.cos(angleNew) * radius);
    out[1] = Math.round(Math.sin(angleNew) * radius);
}

addEventListener('load', function () {
    var img1 = new Image();
    var answer = Math.round(Math.random() * 100);
    console.log("answer is "+answer)
    img1.src = "/testImage?token=111&answer="+answer;
    img1.addEventListener('load', eventLoaded, false);
    function eventLoaded() {
        var width = img1.width;
        var height = img1.height;
        var cnv = document.getElementById('q');
        var ctx = cnv.getContext('2d');
        var buttonWidth = 50;
        var buttonHeight = 50;
        cnv.width = img1.width;
        cnv.height = img1.height + buttonHeight;
        ctx.drawImage(img1, 0, 0);
        ctx.fillStyle = '#d2691e';
        ctx.fillRect(0, height, buttonWidth, buttonHeight);
        ctx.fillStyle = '#fff8dc';
        ctx.font = 'italic bold 25px sans-serif';
        ctx.textBaseline = 'top';
        ctx.fillText('拖我', 0, height);
        var lastX = -1;
        var lastY = -1;
        var responseRange = 10;
        var level = 0;
        var levelMin = 50;
        var levelMax = 150;
        var levelRange = levelMax;
        var imageData = ctx.getImageData(0, 0, width, height);
        var canvasWidth = 300;
        var calc = function (ev) {
            //prevent change too frequent
            if (Math.abs(ev.clientX - lastX) + Math.abs(ev.clientY - lastY) < responseRange) {
                return;
            }
            var changed = ev.clientX - lastX + ev.clientY - lastY;
            lastX = ev.clientX;
            lastY = ev.clientY;
            level += changed / 2.0;
            var imageDataNew = ctx.createImageData(width, height);
            for (var i = 0; i < imageData.data.length; i += 4) {
                var x = i / 4 % width;
                var y = i / 4 / width;
                var out = []
                transformInverse(x, y, out, width, height, level)
                var number = Math.round((out[0] + Math.round(out[1]) * width) * 4);
                imageDataNew.data[number] = imageData.data[i]
                imageDataNew.data[number + 1] = imageData.data[i + 1]
                imageDataNew.data[number + 2] = imageData.data[i + 2]
                imageDataNew.data[number + 3] = imageData.data[i + 3]
            }
            for (var i = 0; i < imageDataNew.data.length; i += 4) {
                if (imageDataNew.data[i] == 0) {
                    imageDataNew.data[i] = imageDataNew.data[i - 4]
                    imageDataNew.data[i + 1] = imageDataNew.data[i - 3]
                    imageDataNew.data[i + 2] = imageDataNew.data[i - 2]
                    imageDataNew.data[i + 3] = imageDataNew.data[i - 1]
                }
            }
            ctx.clearRect(0, height, canvasWidth, buttonHeight);
            ctx.fillStyle = '#d2691e';
            ctx.fillRect(0, height, buttonWidth + level / levelRange * (width - buttonWidth), buttonHeight);
            ctx.fillStyle = '#fff8dc';
            ctx.font = 'italic bold 25px sans-serif';
            ctx.textBaseline = 'top';
            ctx.fillText('拖我', 0, height);
            console.log(level);
            ctx.putImageData(imageDataNew, 0, 0);
        }
        cnv.addEventListener('mousedown', function (ev) {
            cnv.addEventListener('mousemove', calc);
            this.style.cursor = 'crosshair';
            lastX = ev.clientX;
            lastY = ev.clientY;
        });
        cnv.addEventListener('mouseup', function (ev) {
            cnv.removeEventListener('mousemove', calc);
            this.style.cursor = 'normal'
            if (Math.abs(answer - level)/level < 0.08 || Math.abs(answer - level) < 5) {
                ctx.clearRect(0, height, canvasWidth, buttonHeight);
                ctx.fillStyle = '#7cfc00';
                ctx.fillRect(0, height, buttonWidth + level / levelRange * (width - buttonWidth), buttonHeight);
                ctx.fillStyle = '#fff8dc';
                ctx.font = 'italic bold 25px sans-serif';
                ctx.textBaseline = 'top';
                ctx.fillText('搞定！', 0, height);
                var div = document.getElementById("captcha-tip");
                div.style.display="block"
                console.log(level);
            } else {
                ctx.clearRect(0, height, canvasWidth, buttonHeight);
                ctx.fillStyle = '#d2691e';
                ctx.fillRect(0, height, buttonWidth + level / levelRange * (width - buttonWidth), buttonHeight);
                ctx.fillStyle = '#fff8dc';
                ctx.font = 'italic bold 25px sans-serif';
                ctx.textBaseline = 'top';
                ctx.fillText('拖我', 0, height);
                console.log(level);
            }
        });

    }
});

