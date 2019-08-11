package controller.com.msg;

import com.utils.MsdSendUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

/**
 * Created by mengxiangli on 2019/8/11.
 */
@WebServlet(name = "QueryController", urlPatterns = "/query/wangwang", loadOnStartup = 1)
public class QueryController extends HttpServlet {
    private Log logger = LogFactory.getLog(MsgController.class);
    private static final String DOMAIN = "https://www.chadianshang.com";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String wangwang = req.getParameter("wangwang");
        //get session id
        CloseableHttpClient httpClient = null;
        URI uri = null;
        try {
            httpClient = HttpClients.createDefault();
            uri = new URIBuilder()
                    .setScheme("https")
                    .setHost("www.chadianshang.com")
                    .setPath("/c/check/singleSubmit")
                    .setParameter("wangwang", wangwang)
                    .build();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader("Cookie", "SESSION=d1113bfb-c734-4f8e-9ab3-b66b5a5c1692");
            httpGet.addHeader("Accept", "application/json, text/javascript, */*; q=0.01");
            httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");

            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                logger.debug("the request is success !");
                String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                logger.debug("the result is :" + result);
                System.out.println("the result is:" + result);
                resp.setContentType("application/json;charset=UTF-8");
                resp.getWriter().write(result);
            }
        } catch (Exception ex) {

        } finally {
            httpClient.close();
        }

    }

}
