/* global computer_type */

function logOut() {
    var data = {};
    $.ajax({
        type: "POST",
        url: "logout",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            window.location.href = "";
            document.getElementById('root').innerHTML = "";
            document.getElementById('root').innerHTML = response;
        }
    });
}

function logIn(id) {

    if (id === 1) {
        var data = {
            log_in: true,
            sign_in: false,
            login: document.loginForm.login.value,
            password: document.loginForm.password.value
        };
    } else {
        var data = {
            log_in: false,
            sign_in: true,
            login: document.loginForm.login.value,
            password: document.loginForm.password.value
        };
    }

    $.ajax({
        type: "POST",
        url: "login",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            document.getElementById('root').innerHTML = "";
            document.getElementById('root').innerHTML = response;
        }
    });
}

function createUserF() {
    var data = {
        name: document.createUserForm.name.value,
        surname: document.createUserForm.surname.value,
        patronymic: document.createUserForm.patronymic.value,
        birthday: document.createUserForm.birthday.value,
        gender: document.createUserForm.gender.options.selectedIndex
    };
    $.ajax({
        type: "POST",
        url: "createUserForm",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            document.getElementById('root').innerHTML = "";
            document.getElementById('root').innerHTML = response;
        }
    });
}

function createFakeUserF() {
    var data = {
        name: document.createUserForm.name.value,
        surname: document.createUserForm.surname.value,
        patronymic: document.createUserForm.patronymic.value,
        birthday: document.createUserForm.birthday.value,
        gender: document.createUserForm.gender.options.selectedIndex
    };
    $.ajax({
        type: "POST",
        url: "createFakeUserForm",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            document.getElementById('root').innerHTML = "";
            document.getElementById('root').innerHTML = response;
        }
    });
}

function clickOnElement(action, id) {
    var data = {
        id: id
    };
//    alert(data.id);
    switch (action) {
        case "loadFoto":
            var req = getElement("LoadFotoInfoServlet", data);

            document.getElementById('element').innerHTML = "";

            var $ul = $("<ul>").appendTo($("#element"));

            switch (computer_type) {
                case 0:
                    $("<li class='foto'>").html("<img src='http://80.94.168.91:8080/melanoma/images/dir/" + req['directory'] + "'>").appendTo($ul);
                    break;

                case 1:
                    break;

                case 2:
                    $("<li class='foto'>").html("<img src='images/dir/" + req['directory'] + "'>").appendTo($ul);
                    break;
                default:

                    break;
            }

            if (!(req['a_foto'] === undefined)) {
                switch (computer_type) {
                    case 0:
                        $("<li class='foto'>").html("<img src='http://80.94.168.91:8080/melanoma/images_out/dir/" + req['a_foto'] + "'>").appendTo($ul);
                        break;

                    case 1:
                        break;

                    case 2:
                        $("<li class='a_foto' id='a_foto'>").html("<img src='images_out/dir/" + req['a_foto'] + "'>").appendTo($ul);
                        break;
                    default:

                        break;
                }

            }
//            $("<li>").html("<b>" + "ID" + "</b>: " + req['id']).appendTo($ul);
//            $("<li>").html("<b>" + "Происхождение болезни" + "</b>: " + req['origin_illness']).appendTo($ul);
            if (req['ABCDE'] !== undefined) {
                var $show_btn = $("<div class='show_btn' id='show_btn' onclick='showAFoto()'>").html("Показать").appendTo($ul);
            }
            var $block;
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Происхождение болезни" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['origin_illness']).appendTo($block);
//            $("<li>").html("<b>" + "Длительность болезни" + "</b>: " + req['duration_illness']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Длительность болезни" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['duration_illness']).appendTo($block);
//            $("<li>").html("<b>" + "Изменение формы" + "</b>: " + req['change_form']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Изменение формы" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['change_form']).appendTo($block);
//            $("<li>").html("<b>" + "Изменение размера" + "</b>: " + req['change_size']).appendTo($block);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Изменение размера" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['change_size']).appendTo($block);
//            $("<li>").html("<b>" + "Изменение цвета" + "</b>: " + req['change_color']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Изменение цвета" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['change_color']).appendTo($block);
//            $("<li>").html("<b>" + "Изменение чувствительности" + "</b>: " + req['change_sensitivity']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Изменение чувствительности" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['change_sensitivity']).appendTo($block);
//            $("<li>").html("<b>" + "Наличие корок и кровоточивости" + "</b>: " + req['crusts_and_bleeding']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Наличие корок и кровоточивости" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['crusts_and_bleeding']).appendTo($block);
//            $("<li>").html("<b>" + "Болезненность опухоли" + "</b>: " + req['tumor_pain']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Болезненность опухоли" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['tumor_pain']).appendTo($block);
//            $("<li>").html("<b>" + "Сателлиты" + "</b>: " + req['satellite']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Сателлиты" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['satellite']).appendTo($block);
//            $("<li>").html("<b>" + "Наличие воспаления" + "</b>: " + req['inflammations']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Наличие воспаления" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['inflammations']).appendTo($block);
//            $("<li>").html("<b>" + "Равномерная окраска" + "</b>: " + req['uniform_coloring']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Равномерная окраска" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['uniform_coloring']).appendTo($block);
//            $("<li>").html("<b>" + "Тип кожи" + "</b>: " + req['skin_type']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Тип кожи" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['skin_type']).appendTo($block);
//            $("<li>").html("<b>" + "Диаметр опухоли" + "</b>: " + req['tumor_diameter'] + " мм").appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Диаметр опухоли" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['tumor_diameter']).appendTo($block);
//            $("<li>").html("<b>" + "Форма опухоли" + "</b>: " + req['tumor_form']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Форма опухоли" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['tumor_form']).appendTo($block);
//            $("<li>").html("<b>" + "Поверхность опухоли" + "</b>: " + req['tumor_surface']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Поверхность опухоли" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['tumor_surface']).appendTo($block);
//            $("<li>").html("<b>" + "Очертания опухоли" + "</b>: " + req['tumor_outline']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Очертания опухоли" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['tumor_outline']).appendTo($block);
//            $("<li>").html("<b>" + "Локализация опухоли" + "</b>: " + req['tumor_localization']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Локализация опухоли" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['tumor_localization']).appendTo($block);
//            $("<li>").html("<b>" + "Устройство" + "</b>: " + req['device']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Устройство" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['device']).appendTo($block);
//            $("<li>").html("<b>" + "Дата создания" + "</b>: " + req['date']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Дата создания" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['date']).appendTo($block);
//            $("<li>").html("<b>" + "Комментарий" + "</b>: " + req['comments']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "Комментарий" + "</b>: ").appendTo($block);
            $("<li class='answer'>").html(req['comments']).appendTo($block);
//            $("<li>").html("<b>" + "RSA" + "</b>: " + req['rsa']).appendTo($ul);
            $block = $("<div class='block_list'>").html("").appendTo($ul);
            $("<li class='parameter'>").html("<b>" + "RSA" + "</b>: ").appendTo($block);
            $("<li class='answer' id='rsa'>").html(req['rsa']).appendTo($block);
//            $block = $("<div class='block_list'>").html("").appendTo($ul);
//            $("<li class='parameter'>").html("<b>" + "RSA" + "</b>: ").appendTo($block);
//            $("<li class='answer'>").html("<input type='text' name='rsa' pattern='([0]{1}){1}|((([0]{1}[.,]{1}){1}|([-]{1}[0]{1}[.,]{1}){1})(([0]{1}[0-9]{1}){1}|([1]{1}){1}){1}){1}' required/>").appendTo($block);
//            console.log('ABCDE: ' + req['ABCDE']);
            if (req['ABCDE'] !== undefined) {

            

                var $rsa_btn = $("<div class='rsa_btn' id='rsa_btn' onclick='changeRsa()'>").html("Изменить").appendTo($ul);

//                $("<li>").html("<b>" + "ABCDE" + "</b>: " + req['ABCDE']).appendTo($ul);
                $block = $("<div class='block_list'>").html("").appendTo($ul);
                $("<li class='parameter'>").html("<b>" + "ABCDE" + "</b>: ").appendTo($block);
                $("<li class='answer'>").html(req['ABCDE']).appendTo($block);
//                $("<li>").html("<b>" + "Similarity" + "</b>: " + req['Similarity']).appendTo($ul);
                $block = $("<div class='block_list'>").html("").appendTo($ul);
                $("<li class='parameter'>").html("<b>" + "Similarity" + "</b>: ").appendTo($block);
                $("<li class='answer'>").html(req['Similarity']).appendTo($block);
//                $("<li>").html("<b>" + "Probability" + "</b>: " + req['Probability']).appendTo($ul);
                $block = $("<div class='block_list'>").html("").appendTo($ul);
                $("<li class='parameter'>").html("<b>" + "Probability" + "</b>: ").appendTo($block);
                $("<li class='answer'>").html(req['Probability']).appendTo($block);
            }

            window.location.href = "#curent_foto";

            break;
        case "loadUser":
            var req = getElement("LoadUserInfoServlet", data);

            document.getElementById('element').innerHTML = "";

            var $ul = $("<ul>").appendTo($("#element"));
            var $gallary = $("<div id='gallery'>").appendTo($("#element"));
            $("<div id='place'>").appendTo($("#gallery"));
            $.each(req, function (index, item) {
//                console.log(index + " : " + item);
                if (index.indexOf("foto_") === -1) {
                    if (index.indexOf("doctor") === -1) {
                        if (index.indexOf("fotoId_") === -1) {
                            $("<li>").html("<b>" + index + "</b>: " + item).appendTo($ul);
                        } else {
                        }
                    } else {
                        switch (item) {
                            case "accept":
                                var $button = $("<div class='button' onclick='workWithPatients(\"returnPatientServlet\"," + req['id'] + ")'>").appendTo($("#element"));
                                $button.text("Return patient");
                                break;
                            case "free":
                                var $button = $("<div class='button' onclick='workWithPatients(\"takePatientServlet\"," + req['id'] + ")'>").appendTo($("#element"));
                                $button.text("Take patient");
                                break;
                        }

                    }
                } else {
//                    $("<div class='element'>").html("<img src='http://80.94.168.91:8080/melanoma/images/dir/" + item + "'>").appendTo($gallary);
//                    console.log("ITEM: " + index.substr(5));
//                    console.log(req['fotoId_'+index.substr(5)]);


                    switch (computer_type) {
                        case 0:
                            $("<div class='element'>").html("<img src='http://80.94.168.91:8080/melanoma/images/dir/" + item + "' onclick='clickOnElement(\"loadFoto\"," + req['fotoId_' + index.substr(5)] + ")'>").appendTo($gallary);
                            break;

                        case 1:
                            break;

                        case 2:
                            $("<div class='element'>").html("<img src='http://192.168.221.66:8080/web/images/dir/" + item + "' onclick='clickOnElement(\"loadFoto\"," + req['fotoId_' + index.substr(5)] + ")'>").appendTo($gallary);
                            break;
                        default:

                            break;
                    }
                }
            });
            var elemSize = 236;
            var block = document.getElementById('gallery');
            var width = block.offsetWidth;
            var elems_row = parseInt((width - 25) / elemSize);
            var freePlace = width - elems_row * elemSize;
            var elems_col = Math.ceil(document.getElementsByClassName('element').length / elems_row);
            document.getElementById('place').style.width = freePlace / 2 + "px";
            document.getElementById('place').style.height = elems_col * elemSize + "px";
            block.style.height = elems_col * elemSize + "px";

            window.location.href = "#pacient";
            break;
    }
}

function getElement(servlet, data) {
    var obj = "";
    $.ajax({
        type: "POST",
        url: servlet,
        contentType: "application/json",
        async: false,
        data: JSON.stringify(data),
        success: function (response) {
            obj = response;
        }
    });
    return obj;
}

function workWithPatients(servlet, id) {
    var data = {
        id: id
    };
    $.ajax({
        type: "POST",
        url: servlet,
        contentType: "application/json",
        async: false,
        data: JSON.stringify(data),
        success: function (response) {
            document.getElementById('root').innerHTML = "";
            document.getElementById('root').innerHTML = response;
            window.location.href = "#tables";
            var radiobtn = document.getElementById("tab_free_pacient");
            radiobtn.checked = false;
            radiobtn = document.getElementById("tab_all_pacient");
            radiobtn.checked = false;
            radiobtn = document.getElementById("tab_foto");
            radiobtn.checked = false;
            radiobtn = document.getElementById("tab_my_pacient");
            radiobtn.checked = true;
        }
    });
//    alert(servlet);
}

function clickOnBackButton() {
    switch (window.location.href.substr(window.location.href.indexOf("#"))) {
        case "#pacient":
            window.location.href = "#tables";
            break;
        case "#curent_foto":
            window.location.href = "#foto";
            break;
        case "#curent_patient_foto":
            window.location.href = "#pacient";
            break;
    }
}

function createFoto(data) {
    $.ajax({
        type: "POST",
        url: "createFoto",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            document.getElementById('root').innerHTML = "";
            document.getElementById('root').innerHTML = response;
            window.location.href = "#foto";
            var radiobtn = document.getElementById("user_new_foto");
            radiobtn.checked = false;
            radiobtn = document.getElementById("user_fotos");
            radiobtn.checked = true;
        }
    });
}

function add_foto() {
    $('#fotoForm').ajaxForm({
        success: function (resp) {
            if (resp["error"] === "no") {
                alert("File has been uploaded successfully");
                console.log("value: " + document.fotoForm.origin_illness.value);
                console.log("ззз value: " + document.fotoForm.origin_illness.options.name);
                console.log("ззз value: " + document.fotoForm.origin_illness.options.selectedIndex);
                var data = {
                    origin_illness: document.fotoForm.origin_illness.options.selectedIndex,
                    duration_illness: document.fotoForm.duration_illness.options.selectedIndex,
                    change_form: document.fotoForm.change_form.options.selectedIndex,
                    change_size: document.fotoForm.change_size.options.selectedIndex,
                    change_color: document.fotoForm.change_color.options.selectedIndex,
                    change_sensitivity: document.fotoForm.change_sensitivity.options.selectedIndex,
                    crusts_and_bleeding: document.fotoForm.crusts_and_bleeding.options.selectedIndex,
                    tumor_pain: document.fotoForm.tumor_pain.options.selectedIndex,
                    satellite: document.fotoForm.satellite.options.selectedIndex,
                    inflammations: document.fotoForm.inflammations.options.selectedIndex,
                    uniform_coloring: document.fotoForm.uniform_coloring.options.selectedIndex,
                    skin_type: document.fotoForm.skin_type.options.selectedIndex,
                    tumor_diameter: document.fotoForm.tumor_diameter.value,
                    tumor_form: document.fotoForm.tumor_form.options.selectedIndex,
                    tumor_surface: document.fotoForm.tumor_surface.options.selectedIndex,
                    tumor_outline: document.fotoForm.tumor_outline.options.selectedIndex,
                    tumor_localization: document.fotoForm.tumor_localization.options.selectedIndex,
                    device: document.fotoForm.device.options.selectedIndex,
                    date: document.fotoForm.date.value,
                    comments: document.fotoForm.comments.value,
                    rsa: document.fotoForm.rsa.value,
                    id: resp["id"],
                    dir: resp["dir"]
                };
                createFoto(data);
            } else {
                alert("File bad type");
            }
        },
        error: function (msg) {
            alert("File has not been uploaded successfully");
        }
    });
}

function sendForAnalysis(id) {
//    alert(id);
    var data = {
        id: id
    };
//    var obj = "";
    $.ajax({
        type: "POST",
        url: "sendForAnalysisServlet",
        contentType: "application/json",
        async: true,
        data: JSON.stringify(data)
//        success: function (response) {
////            obj = response;
//        }
    });
//    return obj;
}

//function getPatient(id) {
////    alert(id);
//    var data = {
//        id: id
//    };
////    var obj = "";
//    $.ajax({
//        type: "POST",
//        url: "getPatientServlet",
//        contentType: "application/json",
//        async: true,
//        data: JSON.stringify(data)
////        success: function (response) {
//////            obj = response;
////        }
//    });
////    return obj;
//}

function checkResults() {
    setInterval(function () {
        console.log("check");
        $.ajax({
            type: "POST",
            url: "checkResultServlet",
            contentType: "application/json",
            async: true,
            data: JSON.stringify(),
            success: function (response) {
                if (!response === null) {
                    $.each(response, function (index, item) {
                        var n = [];
                        var element = document.getElementById('image_' + item);
                        if (!element.classList.contains('done')) {
                            element.classList.add('done');
                            alert("photo was processed");
                        }
                    });
                }
            }
        });
    }, 1000);
}