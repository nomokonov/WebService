package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final UserService userService;

    public SignUpServlet(UserService userService) {
        this.userService = userService;
    }

    //sign UP
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (login == null || pass == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        userService.addUser(login );
        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println("Register:" + profile.getLogin());
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
