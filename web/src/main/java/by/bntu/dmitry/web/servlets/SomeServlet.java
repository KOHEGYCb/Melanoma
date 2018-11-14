package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dmitry
 */
@WebServlet("/someservlet")
public class SomeServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        id
        name
        surname
        patronomic
        age
        gender
        relativeMelanoma
        anamnesisMelanoma
        dyspasticNevusSyndrome
        dyspasticNevusSyndromeRelatives
        immunosuppressiveTherapy
        presenceUlceration
        hospital
        
        gallery
        
        doctor (if need)
        */
        
        System.out.println("SomeServlet");
        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = jo.get("id").getAsInt();
        
        User user = UserDAO.INSTANCE.getEntityById(id);
        UserForm form = UserFormDAO.INSTANCE.getEntityByUser(user);
        ArrayList<Foto> fotos = FotoDAO.INSTANCE.getEntityByUser(user);
        
        Map <String, String> map = new LinkedHashMap<String, String>();
        map.put("id", user.getId() + "");
        map.put("name", form.getName());
        map.put("surname", form.getSurname());
        map.put("patronymic", form.getPatronymic());
        map.put("birthday", form.getBirthday() + "");
        map.put("gender", form.getSex().name());
        map.put("relativeMelanoma", form.getRelativeMelanoma() + "");
        map.put("anamnesisMelanoma", form.getAnamnesisMelanoma() + "");
        map.put("dyspasticNevusSyndrome", form.getDyspasticNevusSyndrome() + "");
        map.put("dyspasticNevusSyndromeRelatives", form.getDyspasticNevusSyndromeRelatives() + "");
        map.put("immunosuppressiveTherapy", form.getImmunosuppressiveTherapy() + "");
        map.put("presenceUlceration", form.getPresenceUlceration() + "");
        map.put("hospital", form.getHospital());
        
        String json = new Gson().toJson(map);
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }   
}
