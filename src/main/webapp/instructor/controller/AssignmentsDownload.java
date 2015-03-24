/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor.controller;

import dao.AssignmentDao;
import dao.UserDao;
import hibernate.DAOFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Assignment;
import pojo.Lab;
import pojo.Trainee;
import pojo.User;

/**
 *
 * @author engy
 */
@WebServlet(urlPatterns = {"/instructor/controller/DownLoadAssignment"})
public class AssignmentsDownload extends HttpServlet {

    
    
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
//        List<Assignment> Assignments = new Vector<Assignment>();
//        Assignment assignment1 = new Assignment();
//        assignment1.setAssignmentData(new byte[100]);
//        Assignments.add(assignment1);
//        Assignment assignment2 = new Assignment();
//        assignment2.setAssignmentData(new byte[100]);
//        Assignments.add(assignment2);
//        request.setAttribute("Assignments", Assignments);
//        
//        RequestDispatcher rd = request.getRequestDispatcher("/instructor/view/Assignments_list.jsp");
//        rd.forward(request, response);
        
//        request.setAttribute("labId", 1);
//        request.setAttribute("traineeId", 2);
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        AssignmentDao assignmentDao = daoFactory.getAssignmentDAO();
       List<Assignment> obj = assignmentDao.findByNameAndAssignment();
      
        
        request.setAttribute("userList",obj);
       // request.setAttribute("assignmentList", (Assignment)obj);
        getServletContext().getRequestDispatcher("/instructor/view/Assignments_list.jsp").forward(request, response);

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
//        int traineeID = Integer.parseInt(request.getParameter("traineeId"));
//        int labID = Integer.parseInt(request.getParameter("labId"));
//        request.setAttribute("labId", request.getParameter("labId"));
//        request.setAttribute("traineeId", request.getParameter("traineeId"));
//        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
//        AssignmentDao assignmentDao = daoFactory.getAssignmentDAO();
//        Assignment assignment = assignmentDao.findByLabIdAndTraineeId(traineeID, labID);
//        String uname = assignmentDao.findByName(traineeID);
//        request.setAttribute(uname, uname);
        
        
//        byte[] fileData = assignment.getAssignmentData();
//        File someFile = new File("java2.pdf");
//        FileOutputStream fos = new FileOutputStream(someFile);
//        fos.write(fileData);
//        fos.flush();
//        fos.close();
        //request.setAttribute("link", link);
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
