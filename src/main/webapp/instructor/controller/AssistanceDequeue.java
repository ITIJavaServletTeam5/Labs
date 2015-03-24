/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor.controller;

import dao.AssistancequeueDao;
import dao.InstructorDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Assistancequeue;
import pojo.AssistancequeueId;
import pojo.User;

/**
 *
 * @author root
 */
@WebServlet(name = "Dequeue", urlPatterns = {"/instructor/view/assistancedequeue"})
public class AssistanceDequeue extends HttpServlet {

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
        
        //dequeue
        String traineeId = request.getParameter("traineeid");
        Long traineeIdLong = Long.parseLong(traineeId);
        String labId = request.getParameter("labid");
        Long labIdLong = Long.parseLong(labId);

        AssistancequeueId aqi = new AssistancequeueId(labIdLong, traineeIdLong);

        DAOFactory daof = DAOFactory.instance(DAOFactory.HIBERNATE);
        AssistancequeueDao ihd = daof.getAssistancequeueDAO();
        Assistancequeue assistancequeue = ihd.findById(aqi, true);
        ihd.makeTransient(assistancequeue);
        //resetting the same lab before leaving 
        response.sendRedirect(request.getContextPath()+"/instructor/view/QueuesList?labid="+labId);
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
