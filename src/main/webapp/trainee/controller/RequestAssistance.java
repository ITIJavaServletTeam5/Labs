/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainee.controller;

import dao.AssistancequeueDao;
import dao.LabDao;
import dao.TraineeDao;
import hibernate.DAOFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.*;

/**
 * @author Mai Rostom
 */
@WebServlet(urlPatterns = {"/trainee/view/RequestAssistance"})
public class RequestAssistance extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);

        User user = (User) request.getSession().getAttribute("user");
        long userId = user.getId();
        TraineeDao traineeDao = daoFactory.getTraineeDAO();
        Trainee trainee = traineeDao.findById(userId, false);

        long labId = Long.parseLong(request.getParameter("labId"));
        LabDao labDao = daoFactory.getLabDAO();
        Lab lab = labDao.findById(labId, false);

        AssistancequeueDao assistancequeueDao = daoFactory.getAssistancequeueDAO();
        Assistancequeue assistancequeue = assistancequeueDao.findById(new AssistancequeueId(lab.getId(), trainee.getId()), true);

        if (assistancequeue != null) {
            assistancequeueDao.makeTransient(assistancequeue);
        } else {
            assistancequeue = new Assistancequeue();
            assistancequeue.setTrainee(trainee);
            assistancequeue.setLab(lab);
            assistancequeue.setRequestDate(new Date());
            // activated here is being served
            assistancequeue.setActivated(false);
            assistancequeue.setId(new AssistancequeueId(lab.getId(), trainee.getId()));
            assistancequeueDao.makePersistent(assistancequeue);
        }

        response.sendRedirect(request.getContextPath() + "/trainee/view/ActivatedQueus?labId=" + labId);
    }
}
