package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.Destinations;
import by.bntu.dmitry.constants.JspAttributes;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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

        System.out.println(surname);
        for (int i = 0; i < surname.length(); i++) {
            if (((int) surname.charAt(i) >= 65) && ((int) surname.charAt(i) <= 90) || ((int) surname.charAt(i) >= 97) && ((int) surname.charAt(i) <= 122)) {
                continue;
            }else{
                if (((int) surname.charAt(i) == 208) || ((int) surname.charAt(i) == 209)){
                    
                }
            }
            System.out.println((int) surname.charAt(i) + "  " + (int) surname.charAt(i + 1));
        }
        int a = (int) surname.length();
        System.out.println("" + a);

        boolean isValid = true;

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
//                req.setAttribute(JspAttributes.CREATE_USER_FORM_JSP_SURNAME, surname);
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

    private String setUpperFirstLeter(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        return str;
    }

}
