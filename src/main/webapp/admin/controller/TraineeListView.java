package admin.controller;

import pojo.Trainee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Created by sharno on 3/16/15.
 */
public class TraineeListView extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainee = request.getParameter("trainee");
        System.out.println("creating trainee " + trainee);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Trainee> trainees = new Vector<Trainee>();
        Trainee t1 = new Trainee();
        t1.setUsername("sharno");
        t1.setEmail("sharnoby3@gmail.com");
        trainees.add(t1);

        request.setAttribute("trainees", trainees);
        getServletContext().getRequestDispatcher("/admin/view/trainee_list.jsp").forward(request, response);
    }
}
