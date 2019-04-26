package by.bntu.dmitry.services;

import by.bntu.dmitry.dao.PacientDAO;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.Pacient;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import java.sql.Date;

/**
 *
 * @author dmitry
 */
public enum UserServices {

    INSTANCE;

    public static String getStringFIO(User user) {
        String fio = "";
        UserForm userForm = UserFormDAO.INSTANCE.getEntityByUser(user);
        if (userForm != null) {
            fio = fio + userForm.getSurname() + " " + userForm.getName() + " " + userForm.getPatronymic();
        }
        return fio;
    }

    /*    to do    */
    public static int getUserAge(User user) {
        int age = 0;
//        UserForm userForm = UserFormDAO.INSTANCE.getEntityByUser(user);
//        Date date = new Date(System.currentTimeMillis());

        return age;
    }

    public static String getUserGender(User user) {
        UserForm userForm = UserFormDAO.INSTANCE.getEntityByUser(user);
        if (userForm != null) {
            return userForm.getSex().getName();
        }
        return "";
    }

    public static String getUser_sDoctorFIO(User user) {
        Pacient p = PacientDAO.INSTANCE.GetPacientByUser(user);
        if (p != null) {
            User doctor = UserDAO.INSTANCE.getEntityById(p.getDoctor().getId());
            return getStringFIO(doctor);
        }
        return "";
    }
}
