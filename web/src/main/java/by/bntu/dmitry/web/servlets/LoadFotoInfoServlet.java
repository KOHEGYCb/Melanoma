package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.Result;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import by.bntu.dmitry.services.logsServices.ParseResultsServices;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet(name = "LoadFotoInfoServlet", urlPatterns = {"/LoadFotoInfoServlet"})
public class LoadFotoInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoadFotoInfoServlet");
        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = jo.get("id").getAsInt();

        Foto foto = FotoDAO.INSTANCE.getEntityById(id);

        Result result = ParseResultsServices.getResult(foto);

        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("id", foto.getId() + "");
        map.put("origin_illness", foto.getOriginIllness() + "");
        map.put("duration_illness", foto.getDurationIllness() + "");
        map.put("change_form", foto.getChangeForm() + "");
        map.put("change_size", foto.getChangeSize() + "");
        map.put("change_color", foto.getChangeColor() + "");
        map.put("change_sensitivity", foto.getChangeSensivity() + "");
        map.put("crusts_and_bleeding", foto.getCrustsAndBleeding() + "");
        map.put("tumor_pain", foto.getTumorPain() + "");
        map.put("satellite", foto.getSatellite() + "");
        map.put("inflammations", foto.getInflammations() + "");
        map.put("uniform_coloring", foto.getUniformColoring() + "");
        map.put("skin_type", foto.getSkinType() + "");
        map.put("tumor_diameter", foto.getTumor_diameter() + "");
        map.put("tumor_form", foto.getTumorForm() + "");
        map.put("tumor_surface", foto.getTumorSurface() + "");
        map.put("tumor_outline", foto.getTumorOutline() + "");
        map.put("tumor_localization", foto.getTumorLocalization() + "");
        map.put("device", foto.getDevice() + "");
        map.put("date", foto.getDate() + "");
        map.put("comments", foto.getComments() + "");
        map.put("directory", foto.getDirectory() + "");

        if (result != null) {
            map.put("ABCDE", result.getAbcde().getDesc());
            map.put("Similarity", result.getSimilarity().getDesc());
            map.put("Probability", result.getProbability().getDesc());
        }

        String json = new Gson().toJson(map);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

}
