package trainee.controller;

import dao.AssistancequeueDao;
import dao.DeliveryqueueDao;
import hibernate.DAOFactory;
import org.json.simple.JSONObject;
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

/**
 * Created by sharno on 3/24/15.
 */
@WebServlet(urlPatterns = "/trainee/view/updateQueues")
public class UpdateQueuesJson extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long labId = Long.parseLong(request.getParameter("labId"));

        DAOFactory daoFactory = DAOFactory.instance(DAOFactory.HIBERNATE);

        AssistancequeueDao assistanceDao = daoFactory.getAssistancequeueDAO();
        List<Assistancequeue> assistanceQueues = assistanceDao.findAssistanceQueueOfLab(labId);

        DeliveryqueueDao deliveryDao = daoFactory.getDeliveryqueueDAO();
        List<Deliveryqueue> deliveryQueues = deliveryDao.findDeliveryQueueOfLab(labId);

        Collections.sort(deliveryQueues);
        Collections.sort(assistanceQueues);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("AssistanceQueues", assistanceQueues);
        jsonObject.put("DeliveryQueues", deliveryQueues);

        jsonObject.writeJSONString(response.getWriter());
    }

//    public static String toJson (List list) {
//        for ()
//    }
}
