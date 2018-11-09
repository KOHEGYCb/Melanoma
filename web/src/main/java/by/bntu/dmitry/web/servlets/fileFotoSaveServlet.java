/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bntu.dmitry.web.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
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
        System.out.println("qwerrewqqrq");
        Part filePart = req.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        FileOutputStream fos = new FileOutputStream("C://dir//file.png");
        byte [] b = new byte[fileContent.available()];
        fileContent.read(b);
        fos.write(b);
        fos.close();
        fileContent.close();
    }

}
