package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.Destinations;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.enums.Role;
import by.bntu.dmitry.services.logsServices.LogServices;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
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
@WebServlet("/login")
public class LoginServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String namePattern = "^([A-Za-z0-9_]{6,})$"; //regular expression for login/password
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher;

        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        boolean log_in = jo.get("log_in").getAsBoolean();
        boolean sign_in = jo.get("sign_in").getAsBoolean();
        String login = jo.get("login").getAsString();
        String password = jo.get("password").getAsString();
        
        System.out.println(login);
        System.out.println(password);
//        String login = req.getParameter("login");
//        String password = req.getParameter("password");

        String _a = "";
        String _login = "";

        boolean isValid = true;

        matcher = pattern.matcher(login);
        if (!matcher.matches()) {
            _login = login;
            _a = "Login is not valid";
            isValid = false;
        } else {
            matcher = pattern.matcher(password);
            if (!matcher.matches()) {
                _login = login;
                _a = "Pass is not valid";
                isValid = false;
            }
        }

        if (isValid) {
            if (log_in) {
                if (!login.equals("")) {
                    if (!password.equals("")) {
                        User user = UserDAO.INSTANCE.getEntityByLogin(login);
                        if (user != null) {
                            if (password.equals(user.getPassword())) {
                                _a = "all right";
                                HttpSession session = req.getSession();
                                session.setAttribute("user", user);
                                LogServices.INSTANCE.LogInLog(user);
                            } else {
                                _login = login;
                                _a = "Pass is not valid";
                            }
                        } else {
                            _login = login;
                            _a = "User not found";
                        }
                    } else {
                        _login = login;
                        _a = "Password is empty";
                    }
                } else {
                    _a = "Login is empty";
                }
            }
            if (sign_in) {
                if (!login.equals("")) {
                    if (!password.equals("")) {
                        if (UserDAO.INSTANCE.getEntityByLogin(login) == null) {
                            User newUser = new User(login, password, Role.USER, true, false);
                            UserDAO.INSTANCE.createEntity(newUser);
                            newUser = UserDAO.INSTANCE.getEntityByLogin(login);
                            LogServices.INSTANCE.SignInLog(newUser);
                            HttpSession session = req.getSession();
                            session.setAttribute("user", newUser);
                            LogServices.INSTANCE.LogInLog(newUser);
                        } else {
                            _a = "Login is used";
                        }
                    }
                }
            }
        }
        req.setAttribute("login", _login);
        req.setAttribute("a", _a);
        forward("/body.jsp", req, resp);
    }

}
