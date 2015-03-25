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
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Assignment;
import pojo.Assistancequeue;
import pojo.Deliveryqueue;
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
        if (labId != null) {
            Long labIdLong = Long.parseLong(labId);

            DAOFactory daof = DAOFactory.instance(DAOFactory.HIBERNATE);
            LabDao dao = daof.getLabDAO();
            Lab lab = dao.findById(labIdLong, true);

            //sort queues
            List<Assistancequeue> assL = (fromSetToList(lab.getAssistancequeues()));
            Collections.sort(assL);

            List<Deliveryqueue> delL = (fromSetToList(lab.getDeliveryqueues()));
            Collections.sort(delL);

            lab.setAssistancequeuesList(assL);
            lab.setDeliveryqueuesList(delL);
            for (Deliveryqueue a : delL) {
                System.out.println("this to check on queue order in servlet" + a.getRequestDate());
            }

            request.getSession().setAttribute("ilab", lab);
            System.out.println("the selected lab id =" + labId);
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
        DAOFactory dAOFactory = DAOFactory.instance(DAOFactory.HIBERNATE);
        LabDao labDao = dAOFactory.getLabDAO();

        String labId = request.getParameter("labid");
        Long labIdLong = Long.parseLong(labId);

        Lab lab = labDao.findById(labIdLong, true);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String startDate = request.getParameter("dateStart");
        String endDate = request.getParameter("dateEnd");

        System.out.println(startDate + "       " + endDate);
        Date startD = formatter.parse(startDate, new ParsePosition(0));
        Date endD = formatter.parse(endDate, new ParsePosition(0));

        lab.setStartTimeFileUpload(startD);
        lab.setEndTimeFileUpload(endD);
        labDao.makePersistent(lab);

        List<Assistancequeue> assL = (fromSetToList(lab.getAssistancequeues()));
        Collections.sort(assL);

        List<Deliveryqueue> delL = (fromSetToList(lab.getDeliveryqueues()));
        Collections.sort(delL);

        lab.setAssistancequeuesList(assL);
        lab.setDeliveryqueuesList(delL);

        if ((startD.before(endD))) {
            request.setAttribute("created", true);
        } else {
            request.setAttribute("nameError", true);
        }

        request.getSession().setAttribute("ilab", lab);

        RequestDispatcher rd = request.getRequestDispatcher("/instructor/view/Queues_list.jsp");
        rd.include(request, response);
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

    public <T> List<T> fromSetToList(Set<T> set) {
        List<T> list = new ArrayList<T>();
        for (T o : set) {
            list.add(o);
        }
        return list;
    }

}
