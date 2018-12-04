package by.bsac.contoller.filtres.authentication;

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

public class MailFinder implements Filter {

    /** account_finder used to find accounts in database.    */
    private AccountFinder account_finder = new AccountFinder();


    /**
     * Method detect, what kind of request is coming (login or registration request).
     * @param servletRequest - coming request.
     * @param servletResponse - app response.
     * @param filterChain - next filter in chain (default: Go to servlet).
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String user_mail = servletRequest.getParameter("user_mail"); //Get user mail;



        filterChain.doFilter(servletRequest,servletResponse);

    }
}
