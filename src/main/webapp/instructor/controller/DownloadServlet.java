/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instructor.controller;

import dao.AssignmentDao;
import hibernate.DAOFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Assignment;
import pojo.Trainee;

/**
 *
 * @author engy
 */
@WebServlet(urlPatterns = {"/instructor/controller/DownLoadServlet"})
public class DownloadServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int traineeId = Integer.parseInt(request.getParameter("test"));
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        AssignmentDao assignmentDao = daoFactory.getAssignmentDAO();
        Assignment b = assignmentDao.findByteById(traineeId);
        byte[] content = b.getAssignmentData();
        String filePath = "D:\\";
        FileInputStream fileToDownload = new FileInputStream(filePath);
        ServletOutputStream output = response.getOutputStream();
        int readBytes = 0;
        while ((readBytes = fileToDownload.read(content, 0, 10000)) != -1) {
            output.write(readBytes);
        }

        output.close();
        fileToDownload.close();
//        while ((readBytes = fileToDownload.read(buffer, 0, 10000)) != -1) {
//            output.write(readBytes);
//        }
//
//        output.close();
//        fileToDownload.close();
//        fileToDownload.close();
//        Assignment b = assignmentDao.findById((long) "traineeId", true);
//        Assignment b = assignmentDao.findById("traineeId", true);
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
