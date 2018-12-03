package by.bsac.contoller;

import by.bsac.aaa.accounting.AccountRegistrar;
import by.bsac.model.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {

    /*
        Servlet global variables:
    */
    private AccountRegistrar registrar; //Object used to register accounts in database;


    @Override
    public void init() throws ServletException {

        //Initialize account manager for 'account' table;
        this.registrar = new AccountRegistrar();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Getting parameters from request:
        String user_name = req.getParameter("user_name");
        String user_pass = req.getParameter("user_pass");
        String user_mail = req.getParameter("user_mail");

        //Create new account in database:
        try {
            this.registrar.create(new Account(user_name,user_mail,user_pass));
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        //If true - redirect to user page.
        resp.sendRedirect(getServletContext().getContextPath() +"/content/user/user_page.jsp");

    }

}
