package com.three.gulimall.thridparty;

import com.aliyun.oss.OSSClient;
import com.three.common.utils.HttpUtils;
import com.three.gulimall.thridparty.component.SmsComponent;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThridPartyApplicationTests {

    @Autowired
    OSSClient ossClient;

    @Resource
    SmsComponent smsComponent;

    @Test
    public void testUpload() throws FileNotFoundException {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        // String endpoint = "oss-cn-hangzhou.aliyuncs.com";
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。

        // String accessKeyId = "LTAI5t6c5FzR3umWd8aUvChj";
        // String accessKeySecret = "oHkVaJLXBHvZMF5mNNi5DZr3mNdjvH";
        // 填写Bucket名称，例如examplebucket。
        String bucketName = "gulimall-three220802";

        // 创建OSSClient实例。
        // OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件流
        FileInputStream inputStream = new FileInputStream("C:\\Users\\three\\Desktop\\SQLjson.jpg");
        ossClient.putObject(bucketName, "json3.jpg", inputStream);
        // 关闭资源
        ossClient.shutdown();
        System.out.println("上传完成");
    }

    @Test
    public void sendSmsCode() {
        smsComponent.sendCode("18070596153", "134531");
    }

    @Test
    public void sendSms() {
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";
        String appcode = "90c8a0876ed4406f86dea2424776e5d8";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", "18070596153");
        querys.put("param", "**code**:123456,**minute**:5");
        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");
        Map<String, String> bodys = new HashMap<String, String>();


        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
