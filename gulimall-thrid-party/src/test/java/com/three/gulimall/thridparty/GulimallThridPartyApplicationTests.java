package com.three.gulimall.thridparty;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThridPartyApplicationTests {

    @Autowired
    OSSClient ossClient;

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
        System.out.println(ossClient);
        FileInputStream inputStream = new FileInputStream("C:\\Users\\three\\Desktop\\SQLjson.jpg");
        ossClient.putObject(bucketName,"json2.jpg",inputStream);
        // 关闭资源
        ossClient.shutdown();
        System.out.println("上传完成");
    }

}
