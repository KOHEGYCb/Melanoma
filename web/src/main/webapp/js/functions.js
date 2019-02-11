/* global foto_directory, foto_id */

$(window).on('resize', function () {
    resizeGallery();
});
$(window).on('load', function () {
    resizeGallery();
    checkPage();
    checkResults();
    printSettings();
//    document.getElementById('pre').classList.remove('pre');
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

function toggleHelp(id) {
    var elName = "help_" + id;
    console.log(window.getComputedStyle(document.getElementById(elName)).getPropertyValue('left'));
//transition-delay: .3s;
    if (window.getComputedStyle(document.getElementById(elName)).getPropertyValue('left') === "-1000px") {
//        document.getElementById(elName).style.display = "block";
        document.getElementById(elName).style.opacity = "1";
        document.getElementById(elName).style.left = "-4%";
    } else {
        document.getElementById(elName).style.opacity = "0";
        document.getElementById(elName).style.left = "-1000px";
    }
}

function showAFoto() {
    var a_foto = document.getElementById('a_foto');
    var btn = document.getElementById('show_btn');
    if (window.getComputedStyle(a_foto).getPropertyValue('display') === 'block') {
        a_foto.style.display = 'none';
        btn.textContent = "Показать";
    } else {
        a_foto.style.display = 'block';
        btn.textContent = "Оригинал";
    }
}
function changeRsa() {
    var rsa_btn = document.getElementById('rsa_btn');
    var elem = document.getElementById('rsa');
    if (rsa_btn.childNodes[0].wholeText === "Изменить") {
        var old_rsa = elem.childNodes[0].wholeText;
        rsa_btn.textContent = "Сохранить";
        elem.innerHTML = "\
<form id='newRSA' method='Post' name='newRSA' enctype='multipart/form-data'>\
<input type='text' name='rsa' value='" + old_rsa + "' pattern='([0]{1}){1}|((([0]{1}[.,]{1}){1}|([-]{1}[0]{1}[.,]{1}){1})(([0]{1}[0-9]{1}){1}|([1]{1}){1}){1}){1}' required/>\
</form>";
        return;
    }
    if (rsa_btn.childNodes[0].wholeText === "Сохранить") {
        var new_rsa = document.newRSA.rsa.value;
        var data = {
            id: foto_id,
            new_rsa: new_rsa,
            directory: foto_directory
        };
        $.ajax({
            type: "POST",
            url: "updateRSA",
            contentType: "application/json",
            async: true,
            data: JSON.stringify(data),
            success: function (response) {
//                alert("All right");
                elem.innerHTML = new_rsa;
                document.getElementById('abcde__b').remove();
                document.getElementById('similarity_b').remove();
                document.getElementById('probability_b').remove();
                rsa_btn.textContent = "Изменить";
                if (document.getElementById('show_btn').childNodes[0].wholeText === "Оригинал") {
                    showAFoto();
                    document.getElementById('show_btn').remove();
                }
            },
            error: function (msg) {
                alert("Some Error");
            }
        });
//        console.log(new_rsa);
    }

}

function toogleSettings() {
    settings = !settings;
    printSettings();
}

function printSettings() {
    if (document.getElementsByClassName('header').length === 1)
        if (settings) {
            document.getElementById('settings_panel').style.display = 'block';
        } else {
            document.getElementById('settings_panel').style.display = 'none';
        }
}

function changeLang(id) {
    prev_lang = cur_lang;
    cur_lang = id;
    translatePage();

    if (document.getElementsByClassName('reg').length === 1)
        switch (cur_lang) {
            case 0:
                document.getElementById('lang_en').classList.add("lang_current");
                document.getElementById('lang_ru').classList.remove("lang_current");
                break;
            case 1:
                document.getElementById('lang_en').classList.remove("lang_current");
                document.getElementById('lang_ru').classList.add("lang_current");
                break;
        }

    if (document.getElementsByClassName('header').length === 1)
        switch (cur_lang) {
            case 0:
                document.getElementById('lang_en').classList.add("lang_current");
                document.getElementById('lang_ru').classList.remove("lang_current");
                break;
            case 1:
                document.getElementById('lang_en').classList.remove("lang_current");
                document.getElementById('lang_ru').classList.add("lang_current");
                break;
        }

}