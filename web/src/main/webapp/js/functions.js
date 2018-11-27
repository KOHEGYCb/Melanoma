$(window).on('resize', function () {
    resizeGallery();
});
$(window).on('load', function () {
    resizeGallery();
    checkPage();
    checkResults();
});

function resizeGallery() {
    window.resizedFinished = setTimeout(function () {
        console.log('Resized finished.');

        var elemSize = 236;
        var block = document.getElementById('gallery');
        var width = block.offsetWidth;
        var elems_row = parseInt((width - 25) / elemSize);
        var freePlace = width - elems_row * elemSize;
        var elems_col = Math.ceil(document.getElementsByClassName('element').length / elems_row);

        console.log('width: ' + width);
        console.log('elements: ' + elems_row);
        console.log('free place: ' + freePlace);

        document.getElementById('place').style.width = freePlace / 2 + "px";
        document.getElementById('place').style.height = elems_col * elemSize + "px";
    }, 500);
}

function checkPage() {
    switch (window.location.href.substr(window.location.href.indexOf("#"))) {
        case "#pacient":
            window.location.href = "#tables";
            break;
        case "#curent_foto":
            window.location.href = "#foto";
            break;
    }
}

function setMaxDate() {
    console.log("setMaxDate");
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd;
    }
    if (mm < 10) {
        mm = '0' + mm;
    }

    today = yyyy + '-' + mm + '-' + dd;
    document.getElementById("foto_date").setAttribute("max", today);
}