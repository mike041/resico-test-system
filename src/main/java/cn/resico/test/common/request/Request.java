package cn.resico.test.common.request;

import cn.resico.test.common.PropertiesUtils;
import com.alibaba.fastjson.JSON;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.util.List;


public class Request {
    public String result;
    static String path = new PropertiesUtils().getProperties("path");
    RequestConfig config;
    public static String token = new PropertiesUtils().getProperties("token");

    public Request() {
        config = RequestConfig.custom().
                setConnectTimeout(20000).
                setSocketTimeout(20000)
                .build();

    }

    public void setRequestConfig(RequestConfig config) {
        this.config = config;
    }


    public String sendRequest(String type, String url, String json) {
        String response = "";
        if ("post".equalsIgnoreCase(type)) {
            response = this.post(url, json);
        } else {
            response = this.get(url, json);
        }
        return response;
    }


    public String post(String url, String json) {
        CloseableHttpClient httpClient;
        HttpPost post = null;
        //HttpHost proxy = new HttpHost("127.0.0.1", 8888);

        try {
            httpClient = HttpClients.createDefault();
            post = new HttpPost(url);
            post.setConfig(config);
            post.addHeader("Authorization", "Bearer " + token);
            post.addHeader("Content-Type", "application/json;charset=UTF-8");

            StringEntity stringEntity = new StringEntity(json, "UTF-8");
            //logger.info("请求：" + EntityUtils.toString(stringEntity));
            post.setEntity(stringEntity);
            CloseableHttpResponse response = httpClient.execute(/*proxy,*/ post);
            HttpEntity httpEntity = response.getEntity();//获取响应正文对象
            String myResult = EntityUtils.toString(httpEntity, "UTF-8");

            //logger.info("返回：" + myResult);
            return myResult;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String url) {
        return this.get(url, null);
    }

    public String get(String url, String json) {
        return this.get(url, json, null);
    }

    public String get(String url, String json, List<Header> headers) {
        CloseableHttpClient httpClient;
        MyGet get = null;
        //HttpHost proxy = new HttpHost("127.0.0.1", 8888);

        try {
            httpClient = HttpClients.createDefault();
            get = new MyGet(url);
            get.setConfig(config);
            if (null != headers && !headers.isEmpty()) {
                for (Header h : headers
                ) {
                    get.addHeader(h);
                }
            }

           /* get.addHeader("Authorization", "Bearer " + token);
            get.addHeader("Content-Type", "application/json;charset=UTF-8");*/
            if (null != json) {
                StringEntity stringEntity = new StringEntity(json, "UTF-8");
                //logger.info("请求：" + EntityUtils.toString(stringEntity));
                get.setEntity(stringEntity);
            }
            CloseableHttpResponse response = httpClient.execute(/*proxy,*/ get);
            HttpEntity httpEntity = response.getEntity();//获取响应正文对象
            String myResult = EntityUtils.toString(httpEntity, "UTF-8");
            //logger.info("返回：" + myResult);
            return myResult;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getWithoutParam(String url, List<Header> headers) {
        CloseableHttpClient httpClient;
        HttpGet get = null;
        //HttpHost proxy = new HttpHost("127.0.0.1", 8888);

        try {
            httpClient = HttpClients.createDefault();
            get = new HttpGet(url);
            get.setConfig(config);
            if (null != headers && !headers.isEmpty()) {
                for (Header h : headers
                ) {
                    get.addHeader(h);
                }
            }
            CloseableHttpResponse response = httpClient.execute(/*proxy,*/ get);
            HttpEntity httpEntity = response.getEntity();//获取响应正文对象
            String myResult = EntityUtils.toString(httpEntity, "UTF-8");
            //logger.info("返回：" + myResult);
            return myResult;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
