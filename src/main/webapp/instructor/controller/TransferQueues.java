/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor.controller;

import dao.AssistancequeueDao;
import dao.DeliveryqueueDao;
import dao.LabDao;
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
import pojo.Deliveryqueue;
import pojo.DeliveryqueueId;
import pojo.Lab;

/**
 *
 * @author root
 */
@WebServlet(name = "TransferQueues", urlPatterns = {"/instructor/view/transferqueues"})
public class TransferQueues extends HttpServlet {

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
//get the new lab id to transfer q to 
        String labId = request.getParameter("labid");
        if (labId != null) {
            Long labIdLong = Long.parseLong(labId);

            DAOFactory daof = DAOFactory.instance(DAOFactory.HIBERNATE);
            LabDao dao = daof.getLabDAO();
            Lab newLab = dao.findById(labIdLong, true);
//get the old lab id from the session
            Lab oldLab = (Lab) request.getSession().getAttribute("ilab");

            //get the assistance & delivery queue dao 
            AssistancequeueDao assistancequeueDao = daof.getAssistancequeueDAO();
            DeliveryqueueDao deliveryqueueDao = daof.getDeliveryqueueDAO();

            for (Object assistancequeue : oldLab.getAssistancequeues()) {
                Assistancequeue aq = (Assistancequeue) assistancequeue;
                assistancequeueDao.makeTransient(aq);
                AssistancequeueId aqId = new AssistancequeueId(newLab.getId(), aq.getTrainee().getId());
                System.out.println("test new lab Id " + newLab.getId());
                aq.setId(aqId);
                aq.setLab(newLab);
                assistancequeueDao.makePersistent(aq);
            }

            for (Object deliveryqueue : oldLab.getDeliveryqueues()) {
                Deliveryqueue dq = (Deliveryqueue) deliveryqueue;
                deliveryqueueDao.makeTransient(dq);
                System.out.println("test old Lab Id " + oldLab.getId());
                DeliveryqueueId dqId = new DeliveryqueueId(newLab.getId(), dq.getTrainee().getId());
                dq.setId(dqId);
                dq.setLab(newLab);
                deliveryqueueDao.makePersistent(dq);
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/instructor/view/Queues_list.jsp");
        rd.include(request, response);
        //test if lab is choosed
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
