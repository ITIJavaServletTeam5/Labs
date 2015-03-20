package admin.controller.instructor;

import pojo.Instructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Created by sharno on 3/16/15.
 */
public class InstructorListView extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Instructor> instructors = new Vector<Instructor>();
        Instructor i1 = new Instructor();
        i1.setUsername("sharno");
        i1.setEmail("sharnoby3@gmail.com");
        instructors.add(i1);

        request.setAttribute("instructors", instructors);
        getServletContext().getRequestDispatcher("/admin/view/instructor_list.jsp").forward(request, response);
    }
}
