package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.JspAttributes;
import by.bntu.dmitry.dao.PacientDAO;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.Pacient;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import by.bntu.dmitry.enums.Role;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmitry
 */
@WebServlet("/createFakeUserForm")
public class CreateFakeUserFormServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namePattern = "^([A-Za-z]{1})([a-z]{1,})"; //regular expression for name/surname/patronymic
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher;

        boolean _name = true;
        boolean _surname = true;
        boolean _patronymic = true;
        boolean _birthday = true;

        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        String name = jo.get("name").getAsString();
        String surname = jo.get("surname").getAsString();
        String patronymic = jo.get("patronymic").getAsString();
        String birthday = jo.get("birthday").getAsString();
        int gender = jo.get("gender").getAsInt();
        
//        String name = req.getParameter("name");
//        String surname = req.getParameter("surname");
//        String patronymic = req.getParameter("patronymic");
//        String birthday = req.getParameter("birthday");
//        String gender = req.getParameter("gender");

        boolean isValid = true;
        
        name = setToCyrillic(name);
        surname = setToCyrillic(surname);
        patronymic = setToCyrillic(patronymic);

        if ("".equals(name)) {
            _name = !_name;
            isValid = false;
        } else {
            matcher = pattern.matcher(name);
            if (matcher.matches()) {
                name = setUpperFirstLeter(name);
            } else {
                isValid = false;
            }
        }

        if ("".equals(surname)) {
            _surname = !_surname;
            isValid = false;
        } else {
            matcher = pattern.matcher(surname);
            if (matcher.matches()) {
                surname = setUpperFirstLeter(surname);
            } else {
                isValid = false;
            }
        }

        if (!"".equals(patronymic)) {
            matcher = pattern.matcher(patronymic);
            if (matcher.matches()) {
                patronymic = setUpperFirstLeter(patronymic);
            } else {
                isValid = false;
            }
        } else {
            _patronymic = !_patronymic;
        }

        if ("".equals(birthday)) {
            _birthday = !_birthday;
            isValid = false;
        }

        if (isValid) {
            User doctor = (User) req.getSession().getAttribute("user");
            String login = "-" + doctor.getId();
            String password = UserDAO.INSTANCE.getAmountFakeUserByDoctor(doctor) + "";
            User user = new User(login, password, Role.USER, true, false);
            UserDAO.INSTANCE.createEntity(user);
            user = UserDAO.INSTANCE.getFakeUser(user);
            
            UserForm form = new UserForm();
            form.setUser(user);
            form.setName(name);
            form.setSurname(surname);
            form.setPatronymic(patronymic);
            form.setBirthday(Date.valueOf(birthday));
            form.setSex(gender);
            UserFormDAO.INSTANCE.createEntity(form);
            
            Pacient pacient = new Pacient();
            pacient.setDoctor(doctor);
            pacient.setPacient(user);
            PacientDAO.INSTANCE.createEntity(pacient);
        } else {
            if (_name) {
                req.setAttribute(JspAttributes.CREATE_USER_FORM_JSP_NAME, name);
            }
            if (_surname) {
                req.setAttribute(JspAttributes.CREATE_USER_FORM_JSP_SURNAME, surname);
            }
            if (_patronymic) {
                req.setAttribute(JspAttributes.CREATE_USER_FORM_JSP_PATRONYMIC, patronymic);
            }
            if (_birthday) {
                req.setAttribute(JspAttributes.CREATE_USER_FORM_JSP_BIRTHDAY, birthday);
            }
            req.setAttribute(JspAttributes.CREATE_USER_FORM_JSP_GENDER, gender);
        }

        forward("/body.jsp", req, resp);
    }

    private String setUpperFirstLeter(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }

    private String setToCyrillic (String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (((int) str.charAt(i) >= 65) && ((int) str.charAt(i) <= 90) || ((int) str.charAt(i) >= 97) && ((int) str.charAt(i) <= 122)) {
                newStr = newStr + str.charAt(i);
            } else {
                if ((int) str.charAt(i) == 208) {
                    int ch = (int) str.charAt(i + 1) + 896;
                    newStr = newStr + (char) ch;
                }
                if ((int) str.charAt(i) == 209) {
                    int ch = (int) str.charAt(i + 1) + 960;
                    newStr = newStr + (char) ch;
                }
            }
        }
        return newStr;
    }

}
