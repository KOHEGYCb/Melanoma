package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.Destinations;
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
@WebServlet("/createFoto")
public class CreateFotoFormServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Strat Servlet Foto");

        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        String origin_illness = jo.get("origin_illness").getAsString();
        String duration_illness = jo.get("duration_illness").getAsString();
        String change_form = jo.get("change_form").getAsString();
        String change_size = jo.get("change_size").getAsString();
        String change_color = jo.get("change_color").getAsString();
        String change_sensitivity = jo.get("change_sensitivity").getAsString();
        String crusts_and_bleeding = jo.get("crusts_and_bleeding").getAsString();
        String tumor_pain = jo.get("tumor_pain").getAsString();
        String satellite = jo.get("satellite").getAsString();
        String inflammations = jo.get("inflammations").getAsString();
        String uniform_coloring = jo.get("uniform_coloring").getAsString();
        String skin_type = jo.get("skin_type").getAsString();
        int tumor_diameter = jo.get("tumor_diameter").getAsInt();
        String tumor_form = jo.get("tumor_form").getAsString();
        String tumor_surface = jo.get("tumor_surface").getAsString();
        String tumor_outline = jo.get("tumor_outline").getAsString();
        String tumor_localization = jo.get("tumor_localization").getAsString();
        String device = jo.get("device").getAsString();
        String date = jo.get("date").getAsString();
        String comments = jo.get("comments").getAsString();
        

//        String origin_illness = req.getParameter("origin_illness");
//        String duration_illness = req.getParameter("duration_illness");
//        String change_form = req.getParameter("change_form");
//        String change_size = req.getParameter("change_size");
//        String change_color = req.getParameter("change_color");
//        String change_sensitivity = req.getParameter("change_sensitivity");
//        String crusts_and_bleeding = req.getParameter("crusts_and_bleeding");
//        String tumor_pain = req.getParameter("tumor_pain");
//        String satellite = req.getParameter("satellite");
//        String inflammations = req.getParameter("inflammations");
//        String uniform_coloring = req.getParameter("uniform_coloring");
//        String skin_type = req.getParameter("skin_type");
//        int tumor_diameter = Integer.parseInt(req.getParameter("tumor_diameter"));
//        String tumor_form = req.getParameter("tumor_form");
//        String tumor_surface = req.getParameter("tumor_surface");
//        String tumor_outline = req.getParameter("tumor_outline");
//        String tumor_localization = req.getParameter("tumor_localization");
//        String device = req.getParameter("device");
//        String date = req.getParameter("date");
//        String comments = req.getParameter("comments");
//
//        boolean isValid = true;
//
//        String _date = "please write date";
//
//        if ("".equals(date)) {
//            isValid = false;
//        }
//
//        if (isValid){
//            
//        }else{
//            req.setAttribute("err", _date);
//        }
//        
//        forward(Destinations.MAIN_PAGE, req, resp);
    }
}
