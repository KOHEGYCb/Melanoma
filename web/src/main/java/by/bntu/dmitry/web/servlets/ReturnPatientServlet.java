package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.dao.PacientDAO;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.entities.Pacient;
import by.bntu.dmitry.entities.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet("/returnPatientServlet")
public class ReturnPatientServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ReturnPatientServlet");

        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = jo.get("id").getAsInt();

        User doctor = (User) req.getSession().getAttribute("user");
        User patient = UserDAO.INSTANCE.getEntityById(id);
        Pacient pacient = PacientDAO.INSTANCE.getEntityByPatientAndDoctor(doctor, patient);
        PacientDAO.INSTANCE.deleteEntity(pacient);
        forward("/body.jsp", req, resp);
    }

}