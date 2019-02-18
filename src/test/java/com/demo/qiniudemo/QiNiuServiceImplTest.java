package com.demo.qiniudemo;

import com.demo.qiniudemo.Service.Impl.QiNiuServiceImpl;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.model.DefaultPutRet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QiNiuServiceImplTest {

    @Autowired
    private QiNiuServiceImpl qiNiuService;
    @Test
    public void uploadFile() throws QiniuException {
        String fileName = "C:\\Users\\EZ\\Desktop\\TestTwo.jpg";
        File file = new File(fileName);
        assertTrue(file.exists());
        Response response = qiNiuService.uploadFile(file);
        assertTrue(response.isOK());
        //解析上传成功的结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        System.out.println("http://pn3xtu38n.bkt.clouddn.com/"+putRet.key);//根据 http://域名/key 就能访问文件
    }

}
