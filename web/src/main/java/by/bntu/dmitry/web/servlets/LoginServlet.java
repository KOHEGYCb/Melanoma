package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.Destinations;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.enums.Role;
import by.bntu.dmitry.services.logsServices.LogServices;
import java.io.IOException;
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
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String _a = "";
        String _login = "";

        System.out.println("\n\n" + req.getParameter("log_in"));
        if (req.getParameter("log_in") != null) {
            if (!login.equals("")){
                if (!password.equals("")){
                    User user = UserDAO.INSTANCE.getEntityByLogin(login);
                    if (user != null) {
                        if (password.equals(user.getPassword())) {
                            _a = "all right";
                            HttpSession session = req.getSession();
                            session.setAttribute("user", user);
                            LogServices.INSTANCE.LogInLog(user);
                        } else {
                            _login = login;
                            _a = "pass not valid";
                        }
                    } else {
                        _login = login;
                        _a = "User not found";
                    }
                }else{
                    _login = login;
                    _a = "Password is empty";
                }
            }else{
                _a = "Login is empty";
            }
        }
        if (req.getParameter("sign_in") != null) {
            if (!login.equals("")) {
                if (!password.equals("")) {
                    if (UserDAO.INSTANCE.getEntityByLogin(login) == null){
                        User newUser = new User(login, password, Role.USER, true, false);
                        UserDAO.INSTANCE.createEntity(newUser);
                        newUser = UserDAO.INSTANCE.getEntityByLogin(login);
                        LogServices.INSTANCE.SignInLog(newUser);
                        HttpSession session = req.getSession();
                        session.setAttribute("user", newUser);
                        LogServices.INSTANCE.LogInLog(newUser);
                    }else {
                _a = "Login is used";
            }
                }
            }
        }
        req.setAttribute("login", _login);
        req.setAttribute("a", _a);
        forward(Destinations.MAIN_PAGE, req, resp);
    }

}
