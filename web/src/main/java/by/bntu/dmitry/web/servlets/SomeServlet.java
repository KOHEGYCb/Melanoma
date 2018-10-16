package by.bntu.dmitry.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmitry
 */
@WebServlet("/someservlet/*")
public class SomeServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = "text";
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String a = "";
        req.setAttribute("a", "ajlab;vbjs");
        PrintWriter out = resp.getWriter();
        out.write("<hr><p>hello</p>");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(text+"|"+login);
    }
    
    
    
}
