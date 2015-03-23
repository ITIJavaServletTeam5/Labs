/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainee.controller;

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
import pojo.Lab;
import pojo.Trainee;

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
        Lab lab=new Lab();
        lab.setName("Java");
        lab.setId(new Long(1));
        
        Trainee trainee=new Trainee();
        trainee.setUsername("Mooki");
        trainee.setId(new Long(2));
        
        
        
        List<Assistancequeue> AssistanceQueues = new Vector<Assistancequeue>();
        Assistancequeue assQueue=new Assistancequeue();
      
        assQueue.setLab(lab);
        
        assQueue.setTrainee(trainee);
        
        assQueue.setActivated(Boolean.TRUE);
        
        assQueue.setRequestDate(new Date(2015, 12,14));
        

        request.setAttribute("AssistenceQueues", AssistanceQueues);
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
        System.out.println("Hello All");
        
    }

   
}

