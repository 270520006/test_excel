package com.zsp.test_excel.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

public class RestClient {
    private final static Logger Log = LoggerFactory.getLogger(RestClient.class);

    /**
     * @param url 请求url
     * @param parms 请求参数
     * @param method 请求方法
     * @return
     */
    public static JSONObject send(String url, String parms,String method) {
        if (method.equalsIgnoreCase("post")){
            return post(url,parms);
        }
        return get(url,parms);
    }


    public static JSONObject get(String url, String parms) {

        String result=null;
        JSONObject responseObject = JSON.parseObject(result);
        //System.out.println("response: "+responseObject);
        return responseObject;
    }




        /**
         * 带json参数的post请求
         * @param url
         * @param parms
         * @return
         */
    public static JSONObject post(String url, String parms) {
 
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
 
        post.addHeader("content-type", "application/json;charset=utf-8");
        post.setEntity(new StringEntity(parms, Charset.forName("utf-8")));
        HttpResponse response = null;
        String result = null;
        try {
            Log.info("开始发送post请求，请求的URL: " + url);
            Log.info("开始发送post请求，请求的参数: " + parms);
            response = httpClient.execute(post);
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (HttpStatus.SC_OK != response.getStatusLine().getStatusCode()) {
            System.out.println("请求不正确");
        }

        JSONObject responseObject = JSON.parseObject(result);
        //System.out.println("response: "+responseObject);
        return responseObject;
    }
}