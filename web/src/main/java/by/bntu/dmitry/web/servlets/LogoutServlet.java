package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.entities.User;
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
@WebServlet("/logout")
public class LogoutServlet extends ManagerServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        LogServices.INSTANCE.LogOut((User) session.getAttribute("user"));
        session.setAttribute("user", null);
        forward("/", req, resp);
    }
    
}
