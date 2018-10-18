package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.Destinations;
import by.bntu.dmitry.constants.JspAttributes;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import java.io.IOException;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dmitry
 */
@WebServlet("/createUserForm")
public class CreateUserFormServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namePattern = "^([A-Za-z]{1})([a-z]{1,})"; //regular expression for name/surname/patronymic
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher;

        boolean _name = true;
        boolean _surname = true;
        boolean _patronymic = true;
        boolean _birthday = true;

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String patronymic = req.getParameter("patronymic");
        String birthday = req.getParameter("birthday");
        String gender = req.getParameter("gender");

        boolean isValid = true;

        if ("".equals(name)) {
            _name = !_name;
            isValid = false;
        } else {
            matcher = pattern.matcher(name);
            if (matcher.matches()) {
                if ((char) name.charAt(0) == (char)'a' )
                System.out.println("Name is Valid");
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
                System.out.println("Surname is Valid");
            } else {
                isValid = false;
            }
        }

        matcher = pattern.matcher(patronymic);
        if (matcher.matches()) {
            System.out.println("Patronymic is Valid");
        } else {
            isValid = false;
        }

        if ("".equals(birthday)) {
            _birthday = !_birthday;
            isValid = false;
        } else {

        }

        if (isValid) {
//            User user = (User) req.getSession().getAttribute("user");
            UserForm form = new UserForm();
//            form.setUser(user);
            form.setName(name);
            form.setSurname(surname);
            form.setPatronymic(patronymic);
            form.setBirthday(Date.valueOf(birthday));
            form.setSex(gender);
//            UserFormDAO.INSTANCE.createEntity(form);
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

//        UserFormDAO.INSTANCE.createEntity(form);
        forward(Destinations.MAIN_PAGE, req, resp);
    }

}
