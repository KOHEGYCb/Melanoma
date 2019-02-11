/* global lang, reg_login, reg_password, reg_log_in, reg_sign_in, foto_id, foto_directory, reg_error_login_not_valid, reg_error_user_not_found, reg_error_login_used, reg_error_login_empty, reg_error_password_empty, reg_error_password_not_valid, header_logout, header_hello, header_lang, user_menu_foto, user_gallery, user_add_foto, user_foto_parameter, user_back, user_add_foto_form_header, user_add_foto_form_origin, user_add_foto_form_duration, user_add_foto_form_form, user_add_foto_form_size, user_add_foto_form_color, user_add_foto_form_sensitivity, user_add_foto_form_pain, user_add_foto_form_crusts, user_add_foto_form_inflammat, user_add_foto_form_uniform_color, user_add_foto_form_skiningions, use, user_add_foto_form_diameterr_add_foto_form_satellite, user_add_foto_form_satellite, user_add_foto_form_inflammations, user_add_foto_form_uniform_coloring, user_add_foto_form_skin, user_add_foto_form_diameter, user_add_foto_form_surface, user_add_foto_form_localiz, user_add_foto_form_deviceation,, user_add_foto_form_date u, user_add_foto_form_commentser_add_foto_form_outline, user_add_foto_form_outline, user_add_foto_form_localization, user_add_foto_form_device, user_add_foto_form_date, user_add_foto_form_comment, user_add_foto_form_foto, user_add_foto_form_add, user_add_foto_form_help_rsa, user_add_foto_form_yes, user_add_foto_form_no, user_add_foto_form_not_know, user_add_foto_form_camera, user_add_foto_form_dermatoscop, user_add_foto_form_scalp, user_add_foto_form_face, user_add_foto_form_organ_of_vision, user_add_foto_form_oral_mucosa, user_add_foto_form_nasal_mucosa, user_add_foto_form_mucosa_of_the_paranasal_sinuses, user_add_foto_form_neck, user_add_foto_form_shoulder_girdle, user_add_foto_form_axillary_region, user_add_foto_form_upper_extremity, user_add_foto_form_palm, user_add_foto_form_finger_nall_plate_of_the_upper_limb, user_add_foto_form_back, user_add_foto_form_anterior_thorax, user_add_foto_form_lumbar_region, user_add_foto_form_ante, user_add_foto_form_groinrior_surface_of_the_abdominal_wall, user_add_foto_form_vulva, user_add_foto_form_groin, user_add_foto_form_anterior_surface_of_the_abdominal_wall, user_add_foto_form_gluteal_region, user_add_foto_form_perineum, user_add_foto_form_lower_limb, user_add_foto_form_thigh_area, user_add_foto_form_shin, user_add_foto_form_plantar_surface_of_the_foot, user_add_foto_form_finger_nail_plate_of_the_lower_limb, user_add_foto_form_fuzzy, user_add_foto_form_clear, user_add_foto_form_smooth, user_add_foto_form_tuberosity, user_add_foto_form_fine_grained, user_add_foto_form_with_keratosis, user_add_foto_form_moist, user_add_foto_form_mushroom_shaped, user_add_foto_form_hemispherical, user_add_foto_form_nodular, user_add_foto_form_tuberous, user_add_foto_form_flat, user_add_foto_form_no_changes_during_3_month, user_add_foto_form_changes_in_clinical_picture, user_add_foto_form_no_info_about_changes, user_add_foto_form_origin_illness_obtained, user_add_foto_form_origin_illness_innate, user_add_foto_form_form_change, prev_lang, prev_lang, cur_lang, doctor_menu_profile, doctor_menu_create_patient, doctor_menu_tables, doctor_my_patient, doctor_my_patient, doctor_fotos, doctor_all_patient, doctor_empty_patient, user_form_header, user_form_header, user_form_birthd, user_form_birthday, user_form_birthdayay, user_form_header, user_form_surname, user_form_gender_female, user_form_gender_female, user_form_gender, user_form_gender_male, user_form_gender_male, user_form_btn_save, user_form_name, user_form_patronymic */

function translatePage() {
    //translate login page
    if (document.getElementsByClassName('reg').length === 1) {
        var html = document.getElementsByClassName('reg')[0].innerHTML;
        var texts = [reg_login, reg_password, reg_log_in, reg_sign_in, reg_error_password_not_valid, reg_error_password_empty, reg_error_login_empty, reg_error_login_used, reg_error_user_not_found, reg_error_login_not_valid];
        html = translateBlock(html, texts);
        document.getElementsByClassName('reg')[0].innerHTML = html;
    }
    //translate header
    if (document.getElementsByClassName('header').length === 1) {
        var html = document.getElementsByClassName('header')[0].innerHTML;
        html = translateBlock(html, [header_logout, header_hello, header_lang]);
        document.getElementsByClassName('header')[0].innerHTML = html;
    }
    //translate menu
    if (document.getElementsByClassName('menu').length === 1) {
        var html = document.getElementsByClassName('menu')[0].innerHTML;
        html = translateBlock(html, [user_menu_foto, doctor_menu_profile, doctor_menu_create_patient, doctor_menu_tables]);
        document.getElementsByClassName('menu')[0].innerHTML = html;
    }
    //translate page (horizontal menu)
    if (document.getElementsByClassName('page').length > 0) {
        var html = document.getElementsByClassName('page')[0].innerHTML;
        html = translateBlock(html, [user_gallery, user_add_foto, doctor_my_patient, doctor_empty_patient, doctor_all_patient, doctor_fotos]);
        document.getElementsByClassName('page')[0].innerHTML = html;
    }
    //translate page curent foto
    if (document.getElementsByClassName('page').length > 1) {
        var html = document.getElementsByClassName('page')[1].innerHTML;
        html = translateBlock(html, [user_foto_parameter, user_back]);
        document.getElementsByClassName('page')[1].innerHTML = html;
        translateFotoInfo();
    }
    //translate foto adding form
    if (document.getElementsByClassName('createFotoForm').length > 0) {
        for (var i = 0, max = document.getElementsByClassName('block').length; i < max; i++) {
            var html = document.getElementsByClassName('block')[i].innerHTML;
            switch (i) {
                case 0:
                    var texts = [user_add_foto_form_origin, user_add_foto_form_not_know, user_add_foto_form_origin_illness_obtained, user_add_foto_form_origin_illness_innate];
                    html = translateBlock(html, texts);
                    break;
                case 1:
                    var texts = [user_add_foto_form_duration, user_add_foto_form_no_info_about_changes, user_add_foto_form_no_changes_during_3_month, user_add_foto_form_changes_in_clinical_picture];
                    html = translateBlock(html, texts);
                    break;
                case 2:
                    html = translateBlock(html, [user_add_foto_form_form_change]);
                    html = translate_yes_no_dont(html);
                    break;
                case 3:
                    html = translateBlock(html, [user_add_foto_form_size]);
                    html = translate_yes_no_dont(html);
                    break;
                case 4:
                    html = translateBlock(html, [user_add_foto_form_color]);
                    html = translate_yes_no_dont(html);
                    break;
                case 5:
                    html = translateBlock(html, [user_add_foto_form_sensitivity]);
                    html = translate_yes_no_dont(html);
                    break;
                case 6:
                    html = translateBlock(html, [user_add_foto_form_crusts]);
                    html = translate_yes_no_dont(html);
                    break;
                case 7:
                    html = translateBlock(html, [user_add_foto_form_pain]);
                    html = translate_yes_no_dont(html);
                    break;
                case 8:
                    html = translateBlock(html, [user_add_foto_form_satellite]);
                    html = translate_yes_no_dont(html);
                    break;
                case 9:
                    html = translateBlock(html, [user_add_foto_form_inflammations]);
                    html = translate_yes_no_dont(html);
                    break;
                case 10:
                    html = translateBlock(html, [user_add_foto_form_uniform_coloring]);
                    html = translate_yes_no_dont(html);
                    break;
                case 11:
                    html = translateBlock(html, [user_add_foto_form_skin, user_add_foto_form_not_know]);
                    break;
                case 12:
                    html = translateBlock(html, [user_add_foto_form_diameter]);
                    break;
                case 13:
                    var texts = [user_add_foto_form_form, user_add_foto_form_mushroom_shaped, user_add_foto_form_hemispherical, user_add_foto_form_nodular, user_add_foto_form_tuberous, user_add_foto_form_flat];
                    html = translateBlock(html, texts);
                    break;
                case 14:
                    var texts = [user_add_foto_form_surface, user_add_foto_form_smooth, user_add_foto_form_tuberosity, user_add_foto_form_fine_grained, user_add_foto_form_with_keratosis, user_add_foto_form_moist];
                    html = translateBlock(html, texts);
                    break;
                case 15:
                    html = translateBlock(html, [user_add_foto_form_outline, user_add_foto_form_fuzzy, user_add_foto_form_clear]);
                    break;
                case 16:
                    var texts = [user_add_foto_form_localization, user_add_foto_form_scalp, user_add_foto_form_face, user_add_foto_form_organ_of_vision, user_add_foto_form_oral_mucosa, user_add_foto_form_nasal_mucosa, user_add_foto_form_mucosa_of_the_paranasal_sinuses, user_add_foto_form_neck, user_add_foto_form_shoulder_girdle, user_add_foto_form_axillary_region, user_add_foto_form_upper_extremity, user_add_foto_form_palm, user_add_foto_form_finger_nall_plate_of_the_upper_limb, user_add_foto_form_anterior_thorax, user_add_foto_form_back, user_add_foto_form_anterior_surface_of_the_abdominal_wall, user_add_foto_form_lumbar_region, user_add_foto_form_groin, user_add_foto_form_vulva, user_add_foto_form_gluteal_region, user_add_foto_form_perineum, user_add_foto_form_lower_limb, user_add_foto_form_thigh_area, user_add_foto_form_shin, user_add_foto_form_plantar_surface_of_the_foot, user_add_foto_form_finger_nail_plate_of_the_lower_limb];
                    html = translateBlock(html, texts);
                    break;
                case 17:
                    html = translateBlock(html, [user_add_foto_form_device, user_add_foto_form_camera, user_add_foto_form_dermatoscop]);
                    break;
                case 18:
                    html = translateBlock(html, [user_add_foto_form_date]);
                    break;
                case 19:
                    html = translateBlock(html, [user_add_foto_form_comment]);
                    break;
                case 20:
                    html = translateBlock(html, [user_add_foto_form_help_rsa]);
                    break;
                case 21:
                    html = translateBlock(html, [user_add_foto_form_foto]);
                    break;
            }
            document.getElementsByClassName('block')[i].innerHTML = html;
        }

        var html = document.getElementsByClassName('createFotoForm')[0].innerHTML;
        var texts = [user_add_foto_form_header, user_add_foto_form_add];
        html = translateBlock(html, texts);
        document.getElementsByClassName('createFotoForm')[0].innerHTML = html;

    }
    //translate user_form and fake_user_form
    if (document.getElementsByClassName('createUserForm').length === 1) {
        var html = document.getElementsByClassName('createUserForm')[0].innerHTML;
        var texts = [user_form_name, user_form_surname, user_form_patronymic, user_form_birthday, user_form_gender, user_form_gender_male, user_form_gender_female, user_form_btn_save, user_form_header];
        html = translateBlock(html, texts);
        document.getElementsByClassName('createUserForm')[0].innerHTML = html;
        translateFotoInfo();
    }

}
function translateFotoInfo() {
    for (var i = 0, max = document.getElementsByClassName('block_list').length; i < max; i++) {
        var html = document.getElementsByClassName('block_list')[i].innerHTML;
        switch (i) {
            case 0:
                var texts = [user_add_foto_form_origin, user_add_foto_form_not_know, user_add_foto_form_origin_illness_obtained, user_add_foto_form_origin_illness_innate];
                html = translateBlock(html, texts);
                break;
            case 1:
                var texts = [user_add_foto_form_duration, user_add_foto_form_no_info_about_changes, user_add_foto_form_no_changes_during_3_month, user_add_foto_form_changes_in_clinical_picture];
                html = translateBlock(html, texts);
                break;
            case 2:
                html = translateBlock(html, [user_add_foto_form_form_change]);
                break;
            case 3:
                html = translateBlock(html, [user_add_foto_form_size]);
                html = translate_yes_no_dont(html);
                break;
            case 4:
                html = translateBlock(html, [user_add_foto_form_color]);
                html = translate_yes_no_dont(html);
                break;
            case 5:
                html = translateBlock(html, [user_add_foto_form_sensitivity]);
                html = translate_yes_no_dont(html);
                break;
            case 6:
                html = translateBlock(html, [user_add_foto_form_crusts]);
                html = translate_yes_no_dont(html);
                break;
            case 7:
                html = translateBlock(html, [user_add_foto_form_pain]);
                html = translate_yes_no_dont(html);
                break;
            case 8:
                html = translateBlock(html, [user_add_foto_form_satellite]);
                html = translate_yes_no_dont(html);
                break;
            case 9:
                html = translateBlock(html, [user_add_foto_form_inflammations]);
                html = translate_yes_no_dont(html);
                break;
            case 10:
                html = translateBlock(html, [user_add_foto_form_uniform_coloring]);
                html = translate_yes_no_dont(html);
                break;
            case 11:
                html = translateBlock(html, [user_add_foto_form_skin, user_add_foto_form_not_know]);
                break;
            case 12:
                html = translateBlock(html, [user_add_foto_form_diameter]);
                break;
            case 13:
                var texts = [user_add_foto_form_form, user_add_foto_form_mushroom_shaped, user_add_foto_form_hemispherical, user_add_foto_form_nodular, user_add_foto_form_tuberous, user_add_foto_form_flat];
                html = translateBlock(html, texts);
                break;
            case 14:
                var texts = [user_add_foto_form_surface, user_add_foto_form_smooth, user_add_foto_form_tuberosity, user_add_foto_form_fine_grained, user_add_foto_form_with_keratosis, user_add_foto_form_moist];
                html = translateBlock(html, texts);
                break;
            case 15:
                var texts = [user_add_foto_form_outline, user_add_foto_form_fuzzy, user_add_foto_form_clear];
                html = translateBlock(html, texts);
                break;
            case 16:
                var texts = [user_add_foto_form_localization, user_add_foto_form_scalp, user_add_foto_form_face, user_add_foto_form_organ_of_vision, user_add_foto_form_oral_mucosa, user_add_foto_form_nasal_mucosa, user_add_foto_form_mucosa_of_the_paranasal_sinuses, user_add_foto_form_neck, user_add_foto_form_shoulder_girdle, user_add_foto_form_axillary_region, user_add_foto_form_upper_extremity, user_add_foto_form_palm, user_add_foto_form_finger_nall_plate_of_the_upper_limb, user_add_foto_form_anterior_thorax, user_add_foto_form_back, user_add_foto_form_anterior_surface_of_the_abdominal_wall, user_add_foto_form_lumbar_region, user_add_foto_form_groin, user_add_foto_form_vulva, user_add_foto_form_gluteal_region, user_add_foto_form_perineum, user_add_foto_form_lower_limb, user_add_foto_form_thigh_area, user_add_foto_form_shin, user_add_foto_form_plantar_surface_of_the_foot, user_add_foto_form_finger_nail_plate_of_the_lower_limb];
                html = translateBlock(html, texts);
                break;
            case 17:
                var texts = [user_add_foto_form_device, user_add_foto_form_dermatoscop, user_add_foto_form_camera];
                html = translateBlock(html, texts);
                break;
            case 18:
                html = translateBlock(html, [user_add_foto_form_date]);
                break;
            case 19:
                html = translateBlock(html, [user_add_foto_form_comment]);
                break;
        }
        document.getElementsByClassName('block_list')[i].innerHTML = html;
    }
}

function translate_yes_no_dont(html) {
    var texts = [user_add_foto_form_not_know, user_add_foto_form_yes, user_add_foto_form_no];
    html = translateBlock(html, texts);
    return html;
}

function translateBlock(html, arr) {
    for (var i = 0; i < arr.length; i++) {
        if (html.indexOf(arr[i][prev_lang]) > 0)
            html = html.substring(0, html.indexOf(arr[i][prev_lang])) + arr[i][cur_lang] + html.substring(html.indexOf(arr[i][prev_lang]) + arr[i][prev_lang].length);
    }
    return html;
}