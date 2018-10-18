package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.Destinations;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import java.io.IOException;
import java.sql.Date;
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
public class CreateUserFormServlet extends ManagerServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("name"));
        
        User user = (User) req.getSession().getAttribute("user");
        UserForm form = new UserForm();
        form.setUser(user);
        form.setName(req.getParameter("name"));
        form.setSurname(req.getParameter("surname"));
        form.setPatronymic(req.getParameter("patronymic"));
        form.setBirthday(Date.valueOf(req.getParameter("birthday")));
        form.setSex(req.getParameter("gender"));
        
        UserFormDAO.INSTANCE.createEntity(form);
        
        forward(Destinations.MAIN_PAGE, req, resp);
    }
        
}
