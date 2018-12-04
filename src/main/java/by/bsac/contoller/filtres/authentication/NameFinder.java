package by.bsac.contoller.filtres.authentication;

import by.bsac.security.authentication.AccountFinder;
import by.bsac.model.Account;

import javax.servlet.*;
import java.io.IOException;

/**
 * NameFinder filter used to find accounts in database by name.
 * NameFinder search accounts by name.
 * Used to authenticate registered user(login request);
 * Or for ASYNC request by registration form;
 * @author SlavaSaniuk - saniuk.vyacheslav.97@gmail.com
 * @version 1.0
 */
public class NameFinder implements Filter {

    /** account_finder used to find accounts in database.    */
    private AccountFinder account_finder = new AccountFinder();

    /**
     * Method detect, what kind of request is coming (login or registration request).
     * @param servletRequest - coming request.
     * @param servletResponse - app response.
     * @param filterChain - next filter in chain (default: MailFinder filter).
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //Get user name
        String user_name = servletRequest.getParameter("user_name");

        //Find accounts in database by user name
        Account[] accounts = this.account_finder.findByName(user_name);




        filterChain.doFilter(servletRequest, servletResponse);

    }
}
