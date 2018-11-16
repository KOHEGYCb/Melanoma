$(window).on('resize', function () {
    resizeGallery();
});
$(window).on('load', function () {
    resizeGallery();
});

function resizeGallery() {
    window.resizedFinished = setTimeout(function () {
        console.log('Resized finished.');

        var elemSize = 236;
        var block = document.getElementById('gallery');
        var width = block.offsetWidth;
        var elems_row = parseInt((width - 25) / elemSize);
        var freePlace = width - elems_row * elemSize;
        var elems_col = Math.ceil(document.getElementsByClassName('element').length/elems_row);
        
        console.log('width: ' + width);
        console.log('elements: ' + elems_row);
        console.log('free place: ' + freePlace);

        document.getElementById('place').style.width = freePlace / 2 + "px";
        document.getElementById('place').style.height = elems_col*elemSize + "px";
    }, 500);
}

