package common.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sharno on 3/17/15.
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute("loggedin") == null &&
                (httpRequest.getRequestURI().contains("/admin") ||
                        httpRequest.getRequestURI().contains("/trainee") ||
                        httpRequest.getRequestURI().contains("/instructor"))) {
//            chain.doFilter(request, response);
         httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
//            request.getRequestDispatcher("login").forward(request, response);
//            chain.doFilter(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
