package servlets;

import accounts.AccountService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
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
//        UsersDataSet profile = new UsersDataSet(-1,login,pass);
        accountService.addNewUser(login, pass );
//        accountService.addSession(request.getSession().getId(), profile);
        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println("Register:" + profile.getLogin());
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
