package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.ConfigConstants;
import by.bntu.dmitry.dao.FotoDAO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet("/updateRSA")
public class UpdateRSAServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = jo.get("id").getAsInt();
        String rsa_text = jo.get("new_rsa").getAsString();
        String directory = jo.get("directory").getAsString();
        rsa_text = rsa_text.replace(",", ".");
        double rsa = Double.parseDouble(rsa_text);

        try {
            FotoDAO.INSTANCE.updateRSA(id, rsa);

            String fileName = "";
            boolean isDotFind = false;
            for (int i = directory.length() - 1; i >= 0; i--) {
                if (isDotFind) {
                    fileName = directory.charAt(i) + fileName;
                } else {
                    if (directory.charAt(i) == '.') {
                        isDotFind = true;
                    }
                }
            }
            String path = ConfigConstants.IMAGE_OUTPUT_FOLDER + fileName;
            File file = new File(path + ".txt");
            file.delete();
//            file = new File(path + ".png");
//            file.delete();
            System.out.println(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
