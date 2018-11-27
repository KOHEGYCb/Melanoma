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
        gender: document.createUserForm.gender.value
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
        gender: document.createUserForm.gender.value
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
    switch (action) {
        case "loadFoto":
            var req = getElement("LoadFotoInfoServlet", data);

            document.getElementById('element').innerHTML = "";

            var $ul = $("<ul>").appendTo($("#element"));
            $("<li class='foto'>").html("<img src='http://80.94.168.91:8080/melanoma/images/dir/" + req['directory'] + "'>").appendTo($ul);
            $.each(req, function (index, item) {
                $("<li>").html("<b>" + index + "</b>: " + item).appendTo($ul);
            });
            console.log('ABCDE: ' + req['ABCDE']);
            if (req['ABCDE'] === undefined) {
                var $button = $("<div class='button' onclick='sendForAnalysis(" + req['id'] + ")'>").appendTo($("#element"));
                $button.text("Send for analysis");
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
                if (index.indexOf("foto_") === -1) {
                    if (index.indexOf("doctor") === -1) {
                        $("<li>").html("<b>" + index + "</b>: " + item).appendTo($ul);
                    } else {
                        var $button = $("<div class='button' onclick='getPatient(" + req['id'] + ")'>").appendTo($("#element"));
                        $button.text("Get User");
                    }
                } else {
                    $("<div class='element'>").html("<img src='http://80.94.168.91:8080/melanoma/images/dir/" + item + "'>").appendTo($gallary);
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

function clickOnBackButton() {
    switch (window.location.href.substr(window.location.href.indexOf("#"))) {
        case "#pacient":
            window.location.href = "#tables";
            break;
        case "#curent_foto":
            window.location.href = "#foto";
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
                var data = {
                    origin_illness: document.fotoForm.origin_illness.value,
                    duration_illness: document.fotoForm.duration_illness.value,
                    change_form: document.fotoForm.change_form.value,
                    change_size: document.fotoForm.change_size.value,
                    change_color: document.fotoForm.change_color.value,
                    change_sensitivity: document.fotoForm.change_sensitivity.value,
                    crusts_and_bleeding: document.fotoForm.crusts_and_bleeding.value,
                    tumor_pain: document.fotoForm.tumor_pain.value,
                    satellite: document.fotoForm.satellite.value,
                    inflammations: document.fotoForm.inflammations.value,
                    uniform_coloring: document.fotoForm.uniform_coloring.value,
                    skin_type: document.fotoForm.skin_type.value,
                    tumor_diameter: document.fotoForm.tumor_diameter.value,
                    tumor_form: document.fotoForm.tumor_form.value,
                    tumor_surface: document.fotoForm.tumor_surface.value,
                    tumor_outline: document.fotoForm.tumor_outline.value,
                    tumor_localization: document.fotoForm.tumor_localization.value,
                    device: document.fotoForm.device.value,
                    date: document.fotoForm.date.value,
                    comments: document.fotoForm.comments.value,
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
    alert(id);
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
    }, 10000);
}