package com.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * Created by mengxi on 2019/1/17.
 */
public class MsdSendUtil {

    private static final String SEND_MSG_DOMAIN = "dysmsapi.aliyuncs.com";
    private static final String ACTION = "SendSms";
    private static final String ACCESS_KEY_ID = "LTAIMbftl02yQbDA";
    private static final String ACCESS_KEY_SECRET = "RuYlM0yFSvxYoJZwbDqx3DjgDmsmCC";
    private static final String SIGN_NAME = "小孟";
    private static final String TEMPLATE_CODE = "SMS_68170109";

    /**
     * send msg by give the phone number and template param
     *
     * @param phoneNum
     * @param nameValue
     * @return
     */
    public static Boolean sendMsgForDefaultTemplate(String phoneNum, String nameValue) {

        return sendMsg(SIGN_NAME, TEMPLATE_CODE, phoneNum, "{\"name\":\"" + nameValue + "\"}");
    }

    /**
     * send msg by give the template code
     *
     * @param templateCode
     * @param phoneNum
     * @param jsonContent
     * @return
     */
    public static Boolean sendMsg(String templateCode, String phoneNum, String jsonContent) {

        return sendMsg(SIGN_NAME, templateCode, phoneNum, jsonContent);
    }

    /**
     * send message across to the model
     *
     * @param signName
     * @param templateCode
     * @param phoneNums
     * @param templateParam
     * @return
     */
    private static Boolean sendMsg(String signName, String templateCode, String phoneNums, String templateParam) {
        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3");
        DefaultProfile profile = DefaultProfile.getProfile("default", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain(SEND_MSG_DOMAIN);
        request.setVersion("2017-05-25");
        request.setAction(ACTION);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("PhoneNumbers", phoneNums);
        request.putQueryParameter("TemplateParam", templateParam);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return false;
    }

}
