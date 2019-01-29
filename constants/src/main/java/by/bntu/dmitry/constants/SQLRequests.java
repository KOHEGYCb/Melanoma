package by.bntu.dmitry.constants;

/**
 *
 * @author dmitry
 */
public class SQLRequests {

    public static final String GET_ALL_USERS = "SELECT * FROM melanoma.user;";
    public static final String GET_USER_BY_ID = "SELECT * FROM melanoma.user WHERE id=?;";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM melanoma.user WHERE login=?;";
    public static final String CREATE_USER = "INSERT INTO melanoma.user (login, password, role, active, authorization) VALUES (?, ?, ?, ?, ?);";
    public static final String UPDATE_USER = "UPDATE melanoma.user SET login=?, password=?, role=?, active=?, authorization=? WHERE id=?;";
    public static final String DELETE_USER = "";
    public static final String GET_AMOUNT_FAKE_USER_BY_DOCTOR = "SELECT COUNT(*) as \"amount\" FROM melanoma.user where login=?;";
    public static final String GET_FAKE_USER = "SELECT * FROM melanoma.user WHERE login=? and password=?;";

    public static final String GET_ALL_PACIENTS = "SELECT * FROM melanoma.pacient;";
    public static final String GET_PACIENT_BY_ID = "SELECT * FROM melanoma.pacient WHERE id=?;";
    public static final String CREATE_PACIENT = "INSERT INTO melanoma.pacient (user_id_pacient, user_id_doctor, direction_of_histology) VALUES (?, ?, ?);";
    public static final String UPDATE_PACIENT = "UPDATE melanoma.pacient SET user_id_pacient = ?, user_id_doctor = ?, direction_of_histology = ? WHERE id = ?;";
    public static final String DELETE_PACIENT = "DELETE FROM melanoma.pacient WHERE pacient.id = ?;";
    public static final String GET_PACIENT_BY_DOCTOR_AND_PATIENT = "SELECT * FROM melanoma.pacient WHERE user_id_doctor=? AND user_id_pacient=?;";

    public static final String GET_ALL_FOTOS = "SELECT * FROM melanoma.foto;";
    public static final String GET_FOTOS_BY_USER = "SELECT * FROM melanoma.foto WHERE user_id = ?;";
    public static final String GET_FOTO_BY_ID = "SELECT * FROM melanoma.foto WHERE id=?;";
    public static final String GET_FOTO_BY_DIR = "SELECT * FROM melanoma.foto WHERE directory=?;";
    public static final String CREATE_FOTO = "INSERT INTO melanoma.foto ("
            + "user_id,"
            + "id_tumor,"
            + "origin_illness,"
            + "duration_illness,"
            + "change_form,"
            + "change_size,"
            + "change_color,"
            + "change_sensitivity,"
            + "crusts_and_bleeding,"
            + "tumor_pain,"
            + "satellite,"
            + "inflammations,"
            + "uniform_coloring,"
            + "skin_type,"
            + "tumor_diameter,"
            + "tumor_form,"
            + "tumor_surface,"
            + "tumor_outline,"
            + "tumor_localization,"
            + "device,"
            + "date,"
            + "comments,"
            + "preliminary_diagnosis,"
            + "final diagnosis,"
            + "result_computer_analysis_probability,"
            + "result_computer_analysis_similar,"
            + "placed_in_database,"
            + "directory"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String CREATE_FOTO_ = "INSERT INTO melanoma.foto ("
            + "user_id,"
            + "directory"
            + ") VALUES (?, ?);";

    public static final String UPDATE_FOTO = "UPDATE melanoma.foto SET "
            + "user_id = ?,"
            + "id_tumor = ?,"
            + "origin_illness = ?,"
            + "duration_illness = ?,"
            + "change_form = ?,"
            + "change_size = ?,"
            + "change_color = ?,"
            + "change_sensitivity = ?,"
            + "crusts_and_bleeding = ?,"
            + "tumor_pain = ?,"
            + "satellite = ?,"
            + "inflammations = ?,"
            + "uniform_coloring = ?,"
            + "skin_type = ?,"
            + "tumor_diameter = ?,"
            + "tumor_form = ?,"
            + "tumor_surface = ?,"
            + "tumor_outline = ?,"
            + "tumor_localization = ?,"
            + "device = ?,"
            + "date = ?,"
            + "comments = ?,"
            + "preliminary_diagnosis = ?,"
            + "final diagnosis = ?,"
            + "result_computer_analysis_probability = ?,"
            + "result_computer_analysis_similar = ?,"
            + "placed_in_database = ?,"
            + "directory = ? "
            + "WHERE id = ?;";

    public static final String UPDATE_FOTO_ = "UPDATE melanoma.foto SET "
            + "user_id = ?,"
            //            + "id_tumor = ?,"
            + "origin_illness = ?,"
            + "duration_illness = ?,"
            + "change_form = ?,"
            + "change_size = ?,"
            + "change_color = ?,"
            + "change_sensitivity = ?,"
            + "crusts_and_bleeding = ?,"
            + "tumor_pain = ?,"
            + "satellite = ?,"
            + "inflammations = ?,"
            + "uniform_coloring = ?,"
            + "skin_type = ?,"
            + "tumor_diameter = ?,"
            + "tumor_form = ?,"
            + "tumor_surface = ?,"
            + "tumor_outline = ?,"
            + "tumor_localization = ?,"
            + "device = ?,"
            + "date = ?,"
            + "comments = ?,"
            //            + "preliminary_diagnosis = ?,"
            //            + "final diagnosis = ?,"
            //            + "result_computer_analysis_probability = ?,"
            //            + "result_computer_analysis_similar = ?,"
            //            + "placed_in_database = ?,"
            + "directory = ? ,"
            + "rsa = ?"
            + "WHERE id = ?;";
    public static final String UPDATE_FOTO_RSA = "UPDATE melanoma.foto SET "
            + "rsa = ?"
            + "WHERE id = ?;";
    public static final String DELETE_FOTO = "";

    public static final String GET_AMOUNT_FOTO_BY_USER_ID = "SELECT count(*) as \"amount\" FROM melanoma.foto where user_id=?;";

    public static final String GET_ALL_USER_FORMS = "SELECT * FROM melanoma.user_form;";
    public static final String GET_USER_FORM_BY_ID = "SELECT * FROM melanoma.user_form WHERE id=?;";
    public static final String GET_USER_FORM_BY_USER = "SELECT * FROM melanoma.user_form WHERE user_id=?;";
    public static final String CREATE_USER_FORM = "INSERT INTO melanoma.user_form ("
            + "user_id,"
            + "name,"
            + "surname,"
            + "patronymic,"
            + "birthday,"
            + "sex,"
            + "relative_melanoma,"
            + "melanoma_in_anamnesis,"
            + "dysplastic_nevus_syndrome_in_relatives,"
            + "dysplastic_nevus_syndrome,"
            + "immunosuppressive_therapy,"
            + "presence_of_ulceration,"
            + "hospital"
            + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String CREATE_START_USER_FORM = "INSERT INTO melanoma.user_form ("
            + "user_id,"
            + "name,"
            + "surname,"
            + "patronymic,"
            + "birthday,"
            + "sex,"
            + ") VALUES (?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_USER_FORM = "UPDATE melanoma.user_form SET "
            + "user_id = ?,"
            + "name = ?,"
            + "surname = ?,"
            + "patronymic = ?,"
            + "birthday = ?,"
            + "sex = ?,"
            + "relative_melanoma = ?,"
            + "melanoma_in_anamnesis = ?,"
            + "dysplastic_nevus_syndrome_in_relatives = ?,"
            + "dysplastic_nevus_syndrome = ?,"
            + "immunosuppressive_therapy = ?,"
            + "presence_of_ulceration = ?,"
            + "hospital = ?"
            + "WHERE id = ?;";
    public static final String DELETE_USER_FORM = "";

    public static final String GET_ALL_LOGS = "SELECT * FROM melanoma.logs;";
    public static final String GET_LOG_BY_ID = "SELECT * FROM melanoma.logs WHERE id=?;";
    public static final String GET_LOG_BY_USER = "SELECT * FROM melanoma.logs WHERE user_id=?;";
    public static final String CREATE_LOG = "INSERT INTO melanoma.logs (action, date, user_id) VALUES (?, NOW(), ?);";
    public static final String UPDATE_LOG = "UPDATE melanoma.logs SET action=?, date=?, user_id=? WHERE id=?;";
    public static final String DELETE_LOG = "";

}
