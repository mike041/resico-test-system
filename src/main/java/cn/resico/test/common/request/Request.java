package cn.resico.test.common.request;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Request {
    RequestConfig config;

    public Request() {
        config = RequestConfig.custom().
                setConnectTimeout(20000).
                setSocketTimeout(20000)
                .build();

    }


    public void setRequestConfig(RequestConfig config) {
        this.config = config;
    }


    public String sendRequest(String type, String url, String json, Map<String, Object> param, List<Header> headers) {
        String response = ("post".equalsIgnoreCase(type))
                ? this.post(url, json, param, headers)
                : this.get(url, json, param, headers);
        return response;
    }

    public String post(String url, String json, Map<String, Object> param, List<Header> headers) {
        CloseableHttpClient httpClient;
        HttpPost post = null;
        //HttpHost proxy = new HttpHost("127.0.0.1", 8888);

        try {
            httpClient = HttpClients.createDefault();
            post = new HttpPost(url);
            post.setConfig(config);
            if (null != headers && !headers.isEmpty()) {
                for (Header h : headers
                ) {
                    post.addHeader(h);
                }
            }


            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key).toString()));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);

                post.setEntity(entity);
            }

            if (null != json) {
                StringEntity stringEntity = new StringEntity(json, "UTF-8");
                //logger.info("请求：" + EntityUtils.toString(stringEntity));
                post.setEntity(stringEntity);
            }

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

    public String get(String url, String json, Map<String, Object> param, List<Header> headers) {
        CloseableHttpClient httpClient;
        MyGet get = null;
        //HttpHost proxy = new HttpHost("127.0.0.1", 8888);

        try {

            URIBuilder builder = new URIBuilder(url);
            if (null != param && !param.isEmpty()) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key).toString());
                }
            }
            URI uri = builder.build();


            httpClient = HttpClients.createDefault();
            get = new MyGet(uri);
            get.setConfig(config);
            if (null != headers && !headers.isEmpty()) {
                for (Header h : headers
                ) {
                    get.addHeader(h);
                }
            }

            StringEntity stringEntity;
           /* get.addHeader("Authorization", "Bearer " + token);
            get.addHeader("Content-Type", "application/json;charset=UTF-8");*/
            if (null != json) {
                stringEntity = new StringEntity(json, "UTF-8");
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
        } catch (URISyntaxException e) {
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
