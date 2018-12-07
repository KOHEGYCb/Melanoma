package by.bntu.dmitry.web.servlets;

import by.bntu.dmitry.dao.FotoDAO;
import by.bntu.dmitry.entities.Foto;
import by.bntu.dmitry.entities.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.webkit.ThemeClient;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet("/sendForAnalysisServlet")
public class SendForAnalysisServlet extends ManagerServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Send For Analysis Servlet");
        JsonObject jo = new Gson().fromJson(req.getReader(), JsonObject.class);
        int id = jo.get("id").getAsInt();

        Foto foto = FotoDAO.INSTANCE.getEntityById(id);
        User user = (User) req.getSession().getAttribute("user");

        String imageName = "";
        for (int i = foto.getDirectory().length() - 1; i >= 0; i--) {
            if (foto.getDirectory().charAt(i) == '/') {
                break;
            } else {
                imageName = foto.getDirectory().charAt(i) + imageName;
            }
        }
        System.out.println("Image Name: " + imageName);

        String cmd = "/usr/local/bin/melaserach"    + " "
                + user.getId()                      + " " 
                + imageName                         + " "
                + foto.getChangeSize()              + " "
                +"-0.02";
//        Runtime.getRuntime().exec(cmd);
//        String cmd = "bash /usr/local/MATLAB/R2018a/bin/matlab";
        new MyThred("my thread", cmd);

        //  /usr/local/bin/melaserach <id user> <image name> <evolution> <pca>
//        
//        System.out.println("*******");
//        PrintStream printStream;
//        printStream = new PrintStream(Runtime.getRuntime().exec(cmd).getOutputStream());
//        printStream.println();

    }

}

class RunThread extends Thread {

    String cmd;

    public RunThread(String name, String cmd) {
        super(name);
        System.out.println("Start");
        this.cmd = cmd;
    }

    @Override
    public void run() {
        try {
            Runtime.getRuntime().exec(cmd);
//            System.out.println("*******");
//            PrintStream printStream;
//            printStream = new PrintStream(Runtime.getRuntime().exec(cmd).getOutputStream());
//            printStream.println();
        } catch (IOException ex) {
            Logger.getLogger(RunThread.class.getName()).log(Level.SEVERE, null, ex);
        }

//        System.out.printf("%s started... \n", Thread.currentThread().getName());
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            System.out.println("Thread has been interrupted");
//        }
//        System.out.printf("%s fiished... \n", Thread.currentThread().getName());

    }

}
