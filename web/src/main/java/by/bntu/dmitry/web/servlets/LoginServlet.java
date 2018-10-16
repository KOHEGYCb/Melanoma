package by.bntu.dmitry.web.servlets;

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
        String a = "";

        System.out.println("\n\n" + req.getParameter("log_in"));
        if (req.getParameter("log_in") != null) {
            User user = UserDAO.INSTANCE.getEntityByLogin(login);
            if (user != null) {
                if (password.equals(user.getPassword())) {
                    a = "all right";
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    LogServices.INSTANCE.LogInLog(user);
                } else {
                    a = "pass not valid";
                }
            } else {
                a = "User not found";
            }
        }
        if (req.getParameter("sign_in") != null) {
            if (!login.equals("")) {
                if (!password.equals("")) {
                    User newUser = new User(login, password, Role.USER, true, false);
                    UserDAO.INSTANCE.createEntity(newUser);
                    LogServices.INSTANCE.SignInLog(newUser);
                }
            }
        }

        req.setAttribute("a", a);
        forward("/", req, resp);
    }

}
