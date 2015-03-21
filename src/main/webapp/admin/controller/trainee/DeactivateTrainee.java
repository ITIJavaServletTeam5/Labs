package admin.controller.trainee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sharno on 3/20/15.
 */
@WebServlet (urlPatterns = "/admin/trainee/deactivate")
public class DeactivateTrainee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getParameter("trainee");
        // TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // this actually does nothing for now
        response.sendRedirect(request.getContextPath()+"/admin/trainee");
    }
}
