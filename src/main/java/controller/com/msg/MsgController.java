package controller.com.msg;

import com.utils.MsdSendUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mengxi on 2019/1/17.
 */
@WebServlet(name = "MsgController", urlPatterns = "/msg/save", loadOnStartup = 1)
public class MsgController extends HttpServlet {

    private Log logger = LogFactory.getLog(MsgController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNum = req.getParameter("phoneNum");
        String nameValue = req.getParameter("name");

        logger.debug("phoneNum=" + phoneNum);
        logger.debug("nameValue=" + nameValue);

        MsdSendUtil.sendMsgForDefaultTemplate(phoneNum, nameValue);

        logger.debug("send msg successfully");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
