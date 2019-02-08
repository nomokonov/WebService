package servlets;

import accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListUsers extends HttpServlet {
    private AccountService accountService;

    public ListUsers(AccountService accountService) {
        this.accountService = accountService;
    }

    //get public user profile
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Authorized: ");
        response.setStatus(HttpServletResponse.SC_OK);
    }

}
