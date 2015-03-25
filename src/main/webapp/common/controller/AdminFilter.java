package common.controller;

import pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by sharno on 3/25/15.
 */
@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (((User)session.getAttribute("user")).getRole().equals("ADMIN")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendRedirect("/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
