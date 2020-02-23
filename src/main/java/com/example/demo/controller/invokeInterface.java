package com.example.demo.controller;


import com.example.demo.pojo.user;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;


@Controller
public class invokeInterface {


    @GetMapping("/zsxq/yecheng")
    @ResponseBody
    public String doGetJson () throws IOException {
        String response=doPost();
        return  response;    //需要返回json串给前端调用

    }

    public static String doPost( ) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        String url="http://120.24.90.17:8088/zsxq/query/origin/detail?id=824511824552";
        HttpGet httpGet =new HttpGet(url);
        JSONObject jsonObject =null;
        HttpResponse response = httpClient.execute(httpGet);
        String res=EntityUtils.toString(response.getEntity());
//       jsonObject=JSONObject.parseObject(EntityUtils.toString(response.getEntity(),"UTF-8")) ;
//       return jsonObject.toString();

        return res;

    }
}
