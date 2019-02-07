package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class hello extends HttpServlet {
    public void doGet(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("<H1>Hello!</H1><br>");
        response.getWriter().println("<p>Jetty based WebApp!</p><br>");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
