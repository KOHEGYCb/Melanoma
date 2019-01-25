package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.Result;
import by.bntu.dmitry.services.logsServices.ParseResultsServices;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmitry
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

        Map<String, String> map = new LinkedHashMap<>();
        map.put("id", foto.getId() + "");
        map.put("origin_illness", foto.getOriginIllness().getName());
        map.put("duration_illness", foto.getDurationIllness().getName());
        map.put("change_form", foto.getChangeFormName());
        map.put("change_size", foto.getChangeSizeName());
        map.put("change_color", foto.getChangeColorName());
        map.put("change_sensitivity", foto.getChangeSensivityName());
        map.put("crusts_and_bleeding", foto.getCrustsAndBleedingName());
        map.put("tumor_pain", foto.getTumorPainName());
        map.put("satellite", foto.getSatelliteName());
        map.put("inflammations", foto.getInflammationsName());
        map.put("uniform_coloring", foto.getUniformColoringName());
        if (foto.getSkinType() == 0) {
            map.put("skin_type", "Нет данных");
        } else {
            map.put("skin_type", foto.getSkinType() + "");
        }
        map.put("tumor_diameter", foto.getTumor_diameter() + "");
        map.put("tumor_form", foto.getTumorForm().getName());
        map.put("tumor_surface", foto.getTumorSurface().getName());
        map.put("tumor_outline", foto.getTumorOutline().getName());
        map.put("tumor_localization", foto.getTumorLocalization().getName());
        map.put("device", foto.getDevice().getName());
        map.put("date", foto.getDate() + "");
        map.put("comments", foto.getComments() + "");
        map.put("directory", foto.getDirectory() + "");

        if (result != null) {
            map.put("ABCDE", result.getAbcde().getDesc());
            map.put("Similarity", result.getSimilarity().getDesc());
            map.put("Probability", result.getProbability().getDesc());
            map.put("a_foto", result.getDirectory());
        }

        String json = new Gson().toJson(map);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

}
