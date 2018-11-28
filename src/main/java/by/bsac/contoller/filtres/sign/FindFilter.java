package by.bsac.contoller.filtres.sign;

import javax.servlet.*;
import java.io.IOException;

public class FindFilter implements Filter {

    /*
    --------------------------------------
    ---------- Class variables -----------
    --------------------------------------
     */
    private String find_by_name_syntax = "SELECT * FROM account WHERE user_name = ?";
    private String find_by_mail_syntax = "SELECT * FROM account WHERE user_mail = ?";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
