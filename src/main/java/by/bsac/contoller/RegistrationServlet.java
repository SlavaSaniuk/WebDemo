package by.bsac.contoller;

import by.bsac.aaa.accounting.AccountDAOImpl;
import by.bsac.database.ConnectionPoolImpl;
import by.bsac.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    /*
        Servlet global variables:
    */
    private AccountDAOImpl account_mng;


    @Override
    public void init() throws ServletException {

        //Initialize account manager for 'account' table;
        this.account_mng = new AccountDAOImpl("account");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Getting parameters from request:
        String user_name = req.getParameter("user_name");
        String user_pass = req.getParameter("user_pass");
        String user_mail = req.getParameter("user_mail");

        //Create new account in database:
        try {
            this.account_mng.create(ConnectionPoolImpl.getConnection(), new Account(user_name,user_mail,user_pass));
        } catch (SQLException exc) {
            exc.printStackTrace();
        }

        //I true - redirect to user page.
        resp.sendRedirect(getServletContext().getContextPath() +"/content/user/user_page.jsp");

    }
}
