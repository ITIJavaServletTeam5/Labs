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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import pojo.Assignment;
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

        request.setAttribute("labId", 2);
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

        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        //System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" + savePath);

        User user = (User) request.getSession().getAttribute("user");
        System.out.println(user.getId());
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        TraineeDao traineeDao = daoFactory.getTraineeDAO();
     //   Trainee t= traineeDao.findByRole(user);


//        request.setAttribute("labId", request.getParameter("LabId"));
        int labId = Integer.parseInt(request.getParameter("LabId"));
        LabDao labDao = daoFactory.getLabDAO();
       Lab l= labDao.findById((long)labId,true);
       Trainee t= traineeDao.findById((long)user.getId(), true);
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
//            InputStream fileContent = part.getInputStream();
//            //byte[] bytes = IOUtils.toByteArray(fileContent);
        }
        byte[] data = Files.readAllBytes(Paths.get(savePath + File.separator + fileName));

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(savePath + File.separator + fileName));
            fileInputStream.read(data);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assignment assignment = new Assignment();
        //Lab lab = new Lab();
        //Trainee trainee = new Trainee();
        assignment.setLab(l);
        assignment.setTrainee(t);
        assignment.setAssignmentData(data);
//        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        AssignmentDao assignmentDao = daoFactory.getAssignmentDAO();
       // assignmentDao.makeTransient(assignment);
        assignmentDao.makePersistent(assignment);
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
