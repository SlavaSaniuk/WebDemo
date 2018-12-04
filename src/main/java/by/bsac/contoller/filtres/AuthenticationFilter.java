package by.bsac.contoller.filtres;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;


@WebFilter(
        urlPatterns = "/content/*"
)
public class AuthenticationFilter implements Filter {

    /** Identified path to login page (index.jsp) */
    private String login_page_path;


    /**
     * Initialization class fields.
     * @param filterConfig - filters configuration.
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        //Init path to login path
        this.login_page_path = filterConfig.getServletContext().getContextPath() +"/index.jsp";
    }

    /**
     * Method check session attribute
     * @param servletRequest - HttpRequest to jsp page
     * @param servletResponse - HttpResponse to user
     * @param filterChain - filters chain (default - requested page)
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //Parse parameters
        HttpServletRequest request = (HttpServletRequest) servletRequest; //Parse request
        HttpServletResponse response = (HttpServletResponse) servletResponse; //Parse response

        HttpSession user_session = request.getSession(false); // Get session object

        //Check at 'null'
        if (user_session == null) response.sendRedirect(login_page_path); //If session not created - redirect to login page

        //Check session attribute 'authenticated' on false
        boolean authenticated = Boolean.valueOf(user_session.getAttribute("authenticated").toString()); //Get 'authenticated' attribute
        if (authenticated == false) response.sendRedirect(login_page_path); //If user not authenticated - redirect to login page

        //If 'OK' - redirect to requested page
        filterChain.doFilter(request, response);

    }

}
