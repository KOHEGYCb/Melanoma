package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.ConfigConstants;
import by.bntu.dmitry.constants.Destinations;
import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.enums.Device;
import by.bntu.dmitry.enums.DurationIllness;
import by.bntu.dmitry.enums.OriginIllness;
import by.bntu.dmitry.enums.TumorForm;
import by.bntu.dmitry.enums.TumorLocalization;
import by.bntu.dmitry.enums.TumorOutline;
import by.bntu.dmitry.enums.TumorSurface;
import by.bntu.dmitry.services.charsets.CyrillicMethods;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmitry
 */
@WebServlet("/createFoto")
public class CreateFotoFormServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Strat Servlet Foto");

        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        int origin_illness = jo.get("origin_illness").getAsInt();
        int duration_illness = jo.get("duration_illness").getAsInt();
        int change_form = jo.get("change_form").getAsInt();
        int change_size = jo.get("change_size").getAsInt();
        int change_color = jo.get("change_color").getAsInt();
        int change_sensitivity = jo.get("change_sensitivity").getAsInt();
        int crusts_and_bleeding = jo.get("crusts_and_bleeding").getAsInt();
        int tumor_pain = jo.get("tumor_pain").getAsInt();
        int satellite = jo.get("satellite").getAsInt();
        int inflammations = jo.get("inflammations").getAsInt();
        int uniform_coloring = jo.get("uniform_coloring").getAsInt();
        int skin_type = jo.get("skin_type").getAsInt();
        int tumor_diameter = jo.get("tumor_diameter").getAsInt();
        int tumor_form = jo.get("tumor_form").getAsInt();
        int tumor_surface = jo.get("tumor_surface").getAsInt();
        int tumor_outline = jo.get("tumor_outline").getAsInt();
        int tumor_localization = jo.get("tumor_localization").getAsInt();
        int device = jo.get("device").getAsInt();
        String date = jo.get("date").getAsString();
        String comments = CyrillicMethods.setToCyrillic(jo.get("comments").getAsString());
        int id = jo.get("id").getAsInt();
        String rsa_text = jo.get("rsa").getAsString();
        rsa_text = rsa_text.replace(",", ".");
        double rsa = Double.parseDouble(rsa_text);
        String directory = jo.get("dir").getAsString();

        Foto foto = new Foto();
        foto.setOriginIllness(OriginIllness.setOriginIllness(origin_illness));
        foto.setDurationIllness(DurationIllness.setDurationIllness(duration_illness));
        foto.setChangeForm(change_form);
        foto.setChangeSize(change_size);
        foto.setChangeColor(change_color);
        foto.setChangeSensivity(change_sensitivity);
        foto.setCrustsAndBleeding(crusts_and_bleeding);
        foto.setTumorPain(tumor_pain);
        foto.setSatellite(satellite);
        foto.setInflammations(inflammations);
        foto.setUniformColoring(uniform_coloring);
        foto.setSkinType(skin_type);
        foto.setTumor_diameter(tumor_diameter);
        foto.setTumorForm(TumorForm.setTumorForm(tumor_form));
        foto.setTumorSurface(TumorSurface.setTumorSurface(tumor_surface));
        foto.setTumorOutline(TumorOutline.setTumorOutline(tumor_outline));
        foto.setTumorLocalization(TumorLocalization.setTumorLocalization(tumor_localization));
        foto.setDevice(Device.setDevice(device));
        foto.setDate(Date.valueOf(date));
        foto.setComments(comments);
        foto.setDirectory(directory);
        foto.setRsa(rsa);
        foto.setId(id);
        foto.setUser((User) req.getSession().getAttribute("user"));
        FotoDAO.INSTANCE.updateEntity(foto);

        String fileName = "";
        boolean isDotFind = false;
        for (int i = foto.getDirectory().length() - 1; i >= 0; i--) {
            if (isDotFind) {
                fileName = foto.getDirectory().charAt(i) + fileName;
            } else {
                if (foto.getDirectory().charAt(i) == '.') {
                    isDotFind = true;
                }
            }
        }
        String path = ConfigConstants.IMAGE_FOLDER + fileName + ".txt";
        FileOutputStream fos = new FileOutputStream(path);
        String params = foto.getChangeSize() + "\n" + rsa;
        byte[] b = params.getBytes();
        fos.write(b);
        fos.close();

        forward("/", req, resp);
    }
    
}
