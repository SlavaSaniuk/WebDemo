package by.bsac.contoller.filtres.authentication;

import by.bsac.aaa.authentication.AccountFinder;

import javax.servlet.*;
import java.io.IOException;

/**
 * NameFinder filter used to find accounts in database by name.
 * NameFinder search accounts by name.
 * Used to authenticate registered user;
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
     * @param servletResponse - filter response.
     * @param filterChain - next filter in chain (default: MailFinder filter).
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
