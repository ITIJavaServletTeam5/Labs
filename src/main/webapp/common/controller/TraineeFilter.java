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
//@WebFilter(filterName = "TraineeFilter", urlPatterns = "/trainee/*")
public class TraineeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (((User)session.getAttribute("user")).getRole().equals("TRAINEE")) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendRedirect("/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
