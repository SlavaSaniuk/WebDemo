package by.bsac.contoller.filtres.authentication;

import by.bsac.exceptions.authentication.AccountAlreadyExistException;
import by.bsac.model.RequestType;
import by.bsac.model.filtres.Finder;
import by.bsac.security.authentication.AccountFinder;
import by.bsac.model.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * NameFinder filter used to find accounts in database by name.
 * NameFinder search accounts by name.
 * Used to authenticate registered user(login request);
 * Or for ASYNC request by registration form;
 * @author SlavaSaniuk - saniuk.vyacheslav.97@gmail.com
 * @version 1.0
 */
public class NameFinder implements Filter, Finder {

    /** account_finder used to find accounts in database.    */
    private AccountFinder account_finder = new AccountFinder();

    /** Path to context ("/") */
    private String context_path;

    /**
     * Init WebFilter fields.
     * @param filterConfig - filter configuration.
     */
    @Override
    public void init(FilterConfig filterConfig) {

        this.context_path = filterConfig.getServletContext().getContextPath(); //Init context path.
    }

    /**
     * Method detect, what kind of request is coming (login or registration request) and process it.
     * @param servletRequest - coming request.
     * @param servletResponse - app response.
     * @param filterChain - next filter in chain (default: MailFinder filter).
     * @throws IOException - input/output exception.
     * @throws ServletException - servlet exception.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //Detect, which type of request
        RequestType req_type = detectRequest(servletRequest);

        //If request type is login:
        if (req_type == RequestType.LOGIN) this.processLoginRequest(servletRequest);
        //If request type is registration:
        else {

            try {
                this.processRegistrationRequest(servletRequest);
            } catch (AccountAlreadyExistException exc) {

                //Set error:
                ((HttpServletRequest) servletRequest).getSession(false).setAttribute("erorr", "user_name");

                //Print stack trace:
                exc.printStackTrace();

                //Redirect to index jsp:
                ((HttpServletResponse) servletResponse).sendRedirect(this.context_path +"/index.jsp");

                //Exit from method:
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public synchronized void processLoginRequest(ServletRequest a_req) {

        //Get user name parameter from ServletRequest
        String user_name = a_req.getParameter("user_name");

        //Find accounts in database by name
        Account[] accounts = this.account_finder.findByName(user_name);

        //Set attribute with accounts object to request
        a_req.setAttribute("accounts", accounts);

    }

    @Override
    public synchronized void processRegistrationRequest(ServletRequest a_req)  throws AccountAlreadyExistException {

        //Get user name parameter from ServletRequest
        String user_name = a_req.getParameter("user_name");

        //Find accounts in database by name
        Account[] accounts = this.account_finder.findByName(user_name);

        //If accounts != null
        if (accounts != null) throw new AccountAlreadyExistException(user_name);

    }

}
