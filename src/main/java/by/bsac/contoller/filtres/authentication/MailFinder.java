package by.bsac.contoller.filtres.authentication;

import by.bsac.exceptions.authentication.AccountAlreadyExistException;
import by.bsac.model.Account;
import by.bsac.model.filtres.Finder;
import by.bsac.security.authentication.AccountFinder;

import javax.servlet.*;
import java.io.IOException;

/**
 * MailFinder filter used to find accounts in database by mail.
 * MailFinder search accounts by mail.
 * Used to authenticate registered user(login request);
 * Or for ASYNC request by registration form;
 * @author SlavaSaniuk - saniuk.vyacheslav.97@gmail.com
 * @version 1.0
 */

public class MailFinder implements Filter, Finder {

    /** account_finder used to find accounts in database.    */
    private AccountFinder account_finder = new AccountFinder();


    /**
     * Method detect, what kind of request is coming (login or registration request).
     * @param servletRequest - coming request.
     * @param servletResponse - app response.
     * @param filterChain - next filter in chain (default: Go to servlet).
     * @throws IOException - exception.
     * @throws ServletException - exception.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {



        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void processLoginRequest(ServletRequest a_req) {

        //Get user name parameter from ServletRequest
        String user_mail = a_req.getParameter("user_mail");

        //Get founded by name accounts from servlet request
        Account[] accounts = (Account[]) a_req.getAttribute("accounts");

        //Remove old attribute
        a_req.removeAttribute("accounts");

        //Find accounts in database by mail
        Account[] founded_by_mail = this.account_finder.findByMail(user_mail);

        //Concatenate arrays:
        System.arraycopy(founded_by_mail,0, accounts, accounts.length, founded_by_mail.length);


        //Set new attribute with accounts object
        a_req.setAttribute("accounts", accounts);
    }

    @Override
    public void processRegistrationRequest(ServletRequest a_req) throws AccountAlreadyExistException {
        throw  new AccountAlreadyExistException("sdf");
    }
}
