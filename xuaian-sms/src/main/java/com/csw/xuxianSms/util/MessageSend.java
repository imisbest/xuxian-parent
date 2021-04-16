package com.csw.xuxianSms.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.stereotype.Component;

/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
@Component
public class MessageSend {


    public static void send(String phone, String code, String signName, String templateCode, String accessKeyId, String accessSecret) {
        System.out.println("phone]" + phone);
        System.out.println("code]" + code);
        System.out.println("signName]" + signName);
        System.out.println("templateCode]" + templateCode);
        System.out.println("accessKeyId]" + accessKeyId);
        System.out.println("accessSecret]" + accessSecret);
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        //{"Message":"OK","RequestId":"BC392F95-EAF5-4E21-9DF7-20CCDB911B52","BizId":"448810875447501385^0","Code":"OK"}
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone + "");
        request.putQueryParameter("SignName", signName + "");
        request.putQueryParameter("TemplateCode", templateCode + "");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
