/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor.controller;

import dao.InstructorDao;
import dao.InstructorHibernateDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Course;
import pojo.MyGroup;
import pojo.Instructor;
import pojo.Lab;
import pojo.User;

/**
 *
 * @author root
 */
@WebServlet(name = "Navigation", urlPatterns = {"/instructor/view/navigation"})
public class Navigation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            /* TODO output your page here. You may use following sample code. */
            DAOFactory daof = DAOFactory.instance(DAOFactory.HIBERNATE);
            InstructorDao ihd = daof.getInstructorDAO();
            User u = (User) request.getSession().getAttribute("user");
            Instructor i = ihd.findById(u.getId(), true);
            
            System.out.println(i.getEmail());
            //build the list of lists to be viewed
            Set<Course> dtoCourses = new LinkedHashSet<Course>();
            Set<Course> hisCourses = new LinkedHashSet<Course>();
            for (Object lab : i.getLabs()){
                // getting all his courses
                hisCourses.add(((Lab)lab).getCourse());
            }
            
            for (Object course : hisCourses) {
            System.out.println("test to see if /instructor/view/navigation is accessible");
                System.out.println(((Course)course).getName());
                Set<Lab> labs = new LinkedHashSet<Lab>();
                //get the labs of each of his courses
                for(Object lab : ((Course)course).getLabs()){
                    //check if he has that lab or don't include the lab
                    if (i.getLabs().contains(lab)){
                        labs.add((Lab)lab);
                        System.out.println(((Lab)lab).getName());
                    }
                }
                ((Course)course).setLabs(labs);
                //finally add the course to the render list
                dtoCourses.add((Course)course);
            }
            
            
            request.setAttribute("courses", dtoCourses);
            
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/instructor/view/common/navigation.jsp");
//            rd.forward(request, response);
            
        } finally {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
