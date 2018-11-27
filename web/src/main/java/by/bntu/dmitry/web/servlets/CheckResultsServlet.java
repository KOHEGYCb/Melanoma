package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.Result;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.services.logsServices.ParseResultsServices;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */
@WebServlet("/checkResultServlet")
public class CheckResultsServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Integer, Integer> map = new HashMap<>();
        if (req.getSession().getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
//            ParseResultsServices.getResults(user);
            ArrayList<Foto> fotos = FotoDAO.INSTANCE.getEntitiesByUser(user);
//            ArrayList<Result> results = new ArrayList<>();

            for (int i = 0; i < fotos.size(); i++) {
                Result result = ParseResultsServices.getResult(fotos.get(i));
                if (result != null) {
                    map.put(map.size() + 1, fotos.get(i).getId());
//                    results.add(result);

                }
            }
        }
        String json = new Gson().toJson(map);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }

}
