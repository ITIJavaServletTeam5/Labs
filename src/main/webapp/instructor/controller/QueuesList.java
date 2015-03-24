/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor.controller;

import dao.LabDao;
import dao.LabHibernateDao;
import hibernate.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Assignment;
import pojo.Assistancequeue;
import pojo.Lab;

/**
 *
 * @author engy
 */
//@WebServlet(name = "QueuesList", urlPatterns = {"/QueuesList"})
@WebServlet(name = "QueuesList", urlPatterns = {"/instructor/view/QueuesList"})
public class QueuesList extends HttpServlet {

    
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
//        List<Assistancequeue> Assistancequeues = new Vector<Assistancequeue>();
//        Assistancequeue assistancequeue1 = new Assistancequeue();
//        assistancequeue1.setRequestDate(new Date());
//        Assistancequeues.add(assistancequeue1);
//        Assistancequeue assistancequeue2 = new Assistancequeue();
//        assistancequeue2.setRequestDate(new Date());
//        Assistancequeues.add(assistancequeue2);
//        request.setAttribute("lab", Assistancequeues);
        RequestDispatcher rd1 = request.getRequestDispatcher("/instructor/view/navigation");
        rd1.include(request, response);
        
        String labId = request.getParameter("labid");
        if (labId != null){
        Long labIdLong = Long.parseLong(labId);
        
        DAOFactory daof = DAOFactory.instance(DAOFactory.HIBERNATE);
        LabDao dao = daof.getLabDAO();
        Lab lab = dao.findById(labIdLong, true);
        request.getSession().setAttribute("lab", lab);
        System.out.println("the selected lab id ="+labId);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/instructor/view/Queues_list.jsp");
        rd.include(request, response);
        //test if lab is choosed
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
