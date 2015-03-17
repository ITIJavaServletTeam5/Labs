package common.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by sharno on 3/17/15.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
//        if (! (Boolean)request.getAttribute("loggedin")) {
//            request.getRequestDispatcher("Login").forward(request, response);
//        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
