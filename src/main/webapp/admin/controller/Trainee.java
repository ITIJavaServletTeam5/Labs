package admin.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Created by sharno on 3/16/15.
 */
public class Trainee extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainee = request.getParameter("trainee");
        System.out.println("creating trainee " + trainee);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> trainees = new Vector<String>();
        trainees.add("Mohamed");
        trainees.add("Bishoy");
        trainees.add("Marwa");
        trainees.add("Engy");
        trainees.add("May");

        request.setAttribute("trainees", trainees);
        getServletContext().getRequestDispatcher("/admin/view/Trainee.jsp").forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainee = request.getParameter("trainee");
        System.out.println("editing trainee " + trainee);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainee = request.getParameter("trainee");
        System.out.println("deleting trainee " + trainee);
    }
}
