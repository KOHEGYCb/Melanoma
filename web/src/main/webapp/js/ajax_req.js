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
//                alert(response);
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

function loadImageInfo(id){
    var data = {
        id: id
    };
    console.log('id: ' + id);
    var s = window.location.href;
    if (s.substr(s.indexOf("#")) === "#foto") {
    $.ajax({
            type: "POST",
            url: "LoadFotoInfoServlet",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                var $ul = $("<ul>").appendTo($("#bl1"));
                $.each(response, function (index, item) {
                    $("<li>").text(index + ": " + item).appendTo($ul);
                });
            }
        });
        window.location.href = "#curent_foto";
    } else {
        document.getElementById('bl1').innerHTML = "";
        window.location.href = "#foto";
    }
}

function pushMe(id) {

    var data = {
        id: id
    };

    var s = window.location.href;
//        location.replace(s.substr(0,s.indexOf("#")+1) + "pacient"); 
//        alert(s.substr(s.indexOf("#")));
    if (s.substr(s.indexOf("#")) === "#tables") {
        $.ajax({
            type: "POST",
            url: "someservlet",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                var $ul = $("<ul>").appendTo($("#bl1"));
                $.each(response, function (index, item) {
                    $("<li>").text(index + ": " + item).appendTo($ul);
                });
//                    "id"
//                    "name"
//                    "surname"
//                    "patronymic"
//                    "birthday"
//                    "gender"
//                    "relativeMelanoma"
//                    "anamnesisMelanoma"
//                    "dyspasticNevusSyndrome"
//                    "dyspasticNevusSyndromeRelatives"
//                    "immunosuppressiveTherapy"
//                    "presenceUlceration"
//                    "hospital"
//                    $("#bl1").text(response["name"]);
            }
        });
        window.location.href = "#pacient";
    } else {
        document.getElementById('bl1').innerHTML = "";
        window.location.href = "#tables";
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

function test() {
    $('#fotoForm').ajaxForm({
        success: function (resp) {
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
        },
        error: function (msg) {
            alert("File has not been uploaded successfully");
        }
    });
}