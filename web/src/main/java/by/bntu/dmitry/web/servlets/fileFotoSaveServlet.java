package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.constants.ConfigConstants;
import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.User;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author user
 */
@WebServlet("/fileFotoSave")
@MultipartConfig
public class fileFotoSaveServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("fileFotoSaveServlet");
        Part filePart = req.getPart("file");

        User user = (User) req.getSession().getAttribute("user");

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String dir = user.getId() + "/";
        File file = new File(ConfigConstants.IMAGE_FOLDER + dir);
        dir = dir + (file.listFiles().length) + ".png";
        InputStream fileContent = filePart.getInputStream();

        FileOutputStream fos = new FileOutputStream(ConfigConstants.IMAGE_FOLDER + dir);
        byte[] b = new byte[fileContent.available()];
        fileContent.read(b);
        fos.write(b);
        fos.close();
        fileContent.close();

        Foto foto = new Foto();
        foto.setDirectory(dir);
        foto.setUser((User) req.getSession().getAttribute("user"));
        FotoDAO.INSTANCE.createEntity(foto);
        Foto n_foto = FotoDAO.INSTANCE.getEntityByDirectory(foto.getDirectory());

        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("id", n_foto.getId() + "");
        map.put("dir", n_foto.getDirectory());

        String json = new Gson().toJson(map);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }

}
