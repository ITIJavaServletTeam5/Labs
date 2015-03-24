/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor.controller;

import dao.AssistancequeueDao;
import dao.DeliveryqueueDao;
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
import pojo.Deliveryqueue;
import pojo.Lab;

/**
 *
 * @author root
 */
@WebServlet(name = "CancelQueues", urlPatterns = {"/instructor/view/cancelqueues"})
public class CancelQueues extends HttpServlet {

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
        RequestDispatcher rd1 = request.getRequestDispatcher("/instructor/view/navigation");
        rd1.include(request, response);
        
        DAOFactory daof = DAOFactory.instance(DAOFactory.HIBERNATE);
        AssistancequeueDao aq = daof.getAssistancequeueDAO();
        DeliveryqueueDao dq = daof.getDeliveryqueueDAO();

        Long labId = ((Lab) request.getSession().getAttribute("ilab")).getId();
        
        for(Object assObject : aq.findAssistanceQueueOfLab(labId)){
            aq.makeTransient((Assistancequeue)assObject);
        }
        
        for(Object delObject : dq.findDeliveryQueueOfLab(labId)){
            dq.makeTransient((Deliveryqueue)delObject);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("/instructor/view/Queues_list.jsp");
        rd.include(request, response);
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
