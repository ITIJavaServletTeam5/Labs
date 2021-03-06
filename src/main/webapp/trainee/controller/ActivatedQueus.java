/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainee.controller;

import dao.AssistancequeueDao;
import dao.DeliveryqueueDao;
import hibernate.DAOFactory;
import pojo.Assistancequeue;
import pojo.Deliveryqueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * @author Mai Rostom
 */
@WebServlet(urlPatterns = {"/trainee/view/ActivatedQueus"})
public class ActivatedQueus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long labId = Long.parseLong(request.getParameter("labId"));

        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);

        AssistancequeueDao assistanceDao = daoFactory.getAssistancequeueDAO();
        List<Assistancequeue> assistanceQueues = assistanceDao.findAssistanceQueueOfLab(labId);

        DeliveryqueueDao deliveryDao = daoFactory.getDeliveryqueueDAO();
        List<Deliveryqueue> deliveryQueues = deliveryDao.findDeliveryQueueOfLab(labId);

        Collections.sort(deliveryQueues);
        Collections.sort(assistanceQueues);

        request.setAttribute("DeliveryQueues", deliveryQueues);
        request.setAttribute("AssistenceQueues", assistanceQueues);
        request.setAttribute("labId", labId);

        getServletContext().getRequestDispatcher("/trainee/view/Activated Queues.jsp").forward(request, response);
    }
}

