package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.dao.PacientDAO;
import by.bntu.dmitry.dao.UserDAO;
import by.bntu.dmitry.dao.UserFormDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.entities.UserForm;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet("/LoadUserInfoServlet")
public class LoadUserInfoServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoadUserInfoServlet");
        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = jo.get("id").getAsInt();
        
        User user = UserDAO.INSTANCE.getEntityById(id);
        UserForm form = UserFormDAO.INSTANCE.getEntityByUser(user);
        ArrayList<Foto> fotos = FotoDAO.INSTANCE.getEntitiesByUser(user);
        
        Map <String, String> map = new HashMap<String, String>();
//        map.put("", user.getId() + "");
        map.put("Имя", form.getName());
        map.put("Фамилия", form.getSurname());
        map.put("Отчество", form.getPatronymic());
        map.put("Дата рождения", form.getBirthday() + "");
        map.put("Пол", form.getSex().name());
//        map.put("relativeMelanoma", form.getRelativeMelanoma() + "");
//        map.put("anamnesisMelanoma", form.getAnamnesisMelanoma() + "");
//        map.put("dyspasticNevusSyndrome", form.getDyspasticNevusSyndrome() + "");
//        map.put("dyspasticNevusSyndromeRelatives", form.getDyspasticNevusSyndromeRelatives() + "");
//        map.put("immunosuppressiveTherapy", form.getImmunosuppressiveTherapy() + "");
//        map.put("presenceUlceration", form.getPresenceUlceration() + "");
//        map.put("hospital", form.getHospital());
        for (int i = 0; i < fotos.size(); i++){
            map.put("foto_"+i, fotos.get(i).getDirectory());
            map.put("fotoId_"+i, fotos.get(i).getId()+"");
        }
        if (PacientDAO.INSTANCE.GetPacientByUser(user) == null){
            map.put("doctor", "free");
        }else{
            map.put("doctor", "accept");
        }
        
        
        String json = new Gson().toJson(map);
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }   
}
