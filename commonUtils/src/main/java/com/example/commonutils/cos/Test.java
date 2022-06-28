package com.example.commonutils.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.COSObject;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;

/**
 * @author fuhua
 **/
public class Test implements CommandLineRunner {
    @Autowired
    COSClientConfig clientConfig;
    @Autowired
    COSAuthConfig cosAuthConfig;

    @Override
    public void run(String... args) throws Exception {
        COSClient cosClient = clientConfig.initClient();
        COSObject object = cosClient.getObject("examplebucket-1308679746", "exampleobject");
        // 处理下载到的流
        // 这里是直接读取，按实际情况来处理
        byte[] bytes = null;
        try {
            bytes = IOUtils.toByteArray(object.getObjectContent());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 用完流之后一定要调用 close()
            object.close();
        }
        // 在流没有处理完之前，不能关闭 cosClient
        // 确认本进程不再使用 cosClient 实例之后，关闭之
        // 使用完成之后销毁 Client，建议 Client 保持为单例
        System.out.println(bytes);
        cosClient.shutdown();
    }
}
