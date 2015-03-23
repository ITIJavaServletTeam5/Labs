/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainee.controller;

import dao.AssignmentHibernateDao;
import dao.AssistancequeueDao;
import dao.DeliveryqueueDao;
import dao.GroupDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Assistancequeue;
import pojo.Deliveryqueue;
//import pojo.Group;
import pojo.Lab;
import pojo.Trainee;
import pojo.User;

/**
 *
 * @author Mai Rostom
 *
 */
@WebServlet(urlPatterns = {"/trainee/view/ActivatedQueus"})
public class ActivatedQueus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
        long labId=Long.parseLong(request.getParameter("labId"));
        
        
        
        
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        AssistancequeueDao assistanceDao = daoFactory.getAssistancequeueDAO();
        
        List<Assistancequeue> assistanceQueues = assistanceDao.findAssistanceQueueOfLab(labId);
        List<Deliveryqueue> DeliveryQueues = new Vector<Deliveryqueue>();
        
        
        
     //   AssistancequeueDao assistanceDao = daoFactory.getAssistancequeueDAO();
        DeliveryqueueDao  deliveryDao=daoFactory.getDeliveryqueueDAO();
        
        assistanceQueues = assistanceDao.findAll();
        DeliveryQueues = deliveryDao.findAll();

        request.setAttribute("DeliveryQueues", DeliveryQueues);
        request.setAttribute("AssistenceQueues", assistanceQueues);
        getServletContext().getRequestDispatcher("/trainee/view/Activated Queues.jsp").forward(request, response);
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
          
        
        
        
        
    }

   
}

