package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.JspAttributes;
import by.bntu.dmitry.constants.NamePatterns;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import charsets.CyrillicMethods;
import charsets.WorkWithStrings;
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
@WebServlet("/createUserForm")
public class CreateUserFormServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pattern pattern = Pattern.compile(NamePatterns.NAMES);
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

        name = CyrillicMethods.setToCyrillic(name);
        surname = CyrillicMethods.setToCyrillic(surname);
        patronymic = CyrillicMethods.setToCyrillic(patronymic);

        if ("".equals(name)) {
            _name = !_name;
            isValid = false;
        } else {
            matcher = pattern.matcher(name);
            if (matcher.matches()) {
                name = WorkWithStrings.setUpperFirstLeter(name);
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
                surname = WorkWithStrings.setUpperFirstLeter(surname);
            } else {
                isValid = false;
            }
        }

        if (!"".equals(patronymic)) {
            matcher = pattern.matcher(patronymic);
            if (matcher.matches()) {
                patronymic = WorkWithStrings.setUpperFirstLeter(patronymic);
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
            User user = (User) req.getSession().getAttribute("user");
            UserForm form = new UserForm();
            form.setUser(user);
            form.setName(name);
            form.setSurname(surname);
            form.setPatronymic(patronymic);
            form.setBirthday(Date.valueOf(birthday));
            form.setSex(gender);
            UserFormDAO.INSTANCE.createEntity(form);
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

}
