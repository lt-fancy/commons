package com.sawallianc.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.List;

@Slf4j
public class HttpClientUtil {

    private HttpClientUtil(){

    }

    public static String postByForm(String url,List<NameValuePair> list){
        HttpPost post = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try{
            post = new HttpPost(url);
            post.addHeader("Content-type","application/x-www-form-urlencoded;charset=gbk");
            RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();
            post.setConfig(config);
            post.setEntity(new UrlEncodedFormEntity(list,"UTF-8"));
            response = httpClient.execute(post);
            if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
                String string = EntityUtils.toString(response.getEntity());
                return string;
            } else {
                log.error("invoke http post form return code is not 200. detail response:{}", JSONObject.toJSONString(response));
                return null;
            }
        } catch (Exception e){
            log.error("error to invoke http post form, detail:{}",e);
            return null;
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                if (null != post) {
                    post.releaseConnection();
                }
                if (null != httpClient) {
                    httpClient.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String postByJson(String url,String json){
        HttpPost post = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try{
            post = new HttpPost(url);
            post.addHeader("Content-type","application/json; charset=utf-8");
            RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();
            post.setConfig(config);
            // 构建消息实体
            StringEntity entity = new StringEntity(json, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);
            response = httpClient.execute(post);
            if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
                return EntityUtils.toString(response.getEntity());
            } else {
                log.error("invoke http post json return code is not 200. detail response:{}", JSONObject.toJSONString(response));
                return null;
            }
        } catch (Exception e){
            log.error("error to invoke http post json, detail:{}",e);
            return null;
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                if (null != post) {
                    post.releaseConnection();
                }
                if (null != httpClient) {
                    httpClient.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String get(String url){
        HttpGet get = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try{
            get = new HttpGet(url);
            RequestConfig config = RequestConfig.custom().setSocketTimeout(10000).setConnectTimeout(10000).build();
            get.setConfig(config);
            response = httpClient.execute(get);
            if(HttpStatus.SC_OK == response.getStatusLine().getStatusCode()){
                return EntityUtils.toString(response.getEntity());
            } else {
                log.error("invoke http get code is not 200. detail response:{}", JSONObject.toJSONString(response));
                return null;
            }
        } catch (Exception e){
            log.error("error to invoke http get, detail:{}",e);
            return null;
        } finally {
            try {
                if (null != response) {
                    response.close();
                }
                if (null != get) {
                    get.releaseConnection();
                }
                if (null != httpClient) {
                    httpClient.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
