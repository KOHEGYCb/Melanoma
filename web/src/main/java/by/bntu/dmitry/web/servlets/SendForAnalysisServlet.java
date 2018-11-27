package by.bntu.dmitry.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet("/sendForAnalysisServlet")
public class SendForAnalysisServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
//        int id = jo.get("id").getAsInt();
//
//        Foto foto = FotoDAO.INSTANCE.getEntityById(id);
    }

}
