package common.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sharno on 3/17/15.
 */
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpSession session = httpRequest.getSession(false);
//        if (session == null) {
//            request.getRequestDispatcher("/Login").forward(request, response);
//        } else {
            chain.doFilter(request, response);
//        }
//        if (! (Boolean)request.getAttribute("loggedin")) {
//            request.getRequestDispatcher("Login").forward(request, response);
//        }
    }

    @Override
    public void destroy() {

    }
}
