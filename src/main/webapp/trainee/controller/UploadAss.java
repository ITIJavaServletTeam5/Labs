/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainee.controller;

import dao.AssignmentDao;
import dao.GroupDao;
import dao.LabDao;
import dao.TraineeDao;
import hibernate.DAOFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import pojo.Assignment;
import pojo.AssignmentId;
import pojo.Lab;
import pojo.MyGroup;
import pojo.Trainee;
import pojo.User;
import sun.misc.IOUtils;

/**
 *
 * @author engy
 */
@WebServlet(urlPatterns = {"/trainee/controller/UploadAssignment"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   //50MB
public class UploadAss extends HttpServlet {

    private static final String SAVE_DIR = "uploadFiles";
    String fileName;

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
        long labId = Long.parseLong(request.getParameter("labId"));
        request.setAttribute("labId", labId);
//        System.out.println(request.getAttribute("labId"));
        getServletContext().getRequestDispatcher("/trainee/view/UploadAssignment.jsp").forward(request, response);

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

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        PrintWriter out = response.getWriter();
        User user = (User) request.getSession().getAttribute("user");

        System.out.println(user.getId());
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        TraineeDao traineeDao = daoFactory.getTraineeDAO();

        Trainee t = traineeDao.findById((long) user.getId(), true);
        out.println(t.getId());
//        System.out.println("jhhgygy"+t.getId());
        traineeDao.makePersistent(t);

        int labId = Integer.parseInt(request.getParameter("LabId"));
        request.setAttribute("labId", request.getParameter("LabId"));

        LabDao labDao = daoFactory.getLabDAO();
        Lab l = labDao.findById((long) labId, true);
        out.println(l.getId());
//        System.out.println("hg"+l.getId());
        labDao.makePersistent(l);              //!!??

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">

        String fileName = filePart.getSubmittedFileName();
        InputStream fileContent = filePart.getInputStream();
        byte[] fileData = new byte[fileContent.available()];
        fileContent.read(fileData);

        Date endUpLoad = l.getEndTimeFileUpload();

        Assignment assignment = new Assignment();
        assignment.setLab(l);
        assignment.setTrainee(t);
        assignment.setId(new AssignmentId(l.getId(), t.getId()));
        assignment.setUploadTime(new Date());

        assignment.setAssignmentData(fileData);
//        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        AssignmentDao assignmentDao = daoFactory.getAssignmentDAO();
        // assignmentDao.makeTransient(assignment);
        if (new Date().before(endUpLoad)) {
            assignmentDao.makePersistent(assignment);
        }
        request.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/trainee/view/message.jsp").forward(
                request, response);
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
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
