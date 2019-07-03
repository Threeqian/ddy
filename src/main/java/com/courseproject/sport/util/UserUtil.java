package com.courseproject.sport.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UserUtil {
    public static String getOpenid(String code){
        String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=CODE&grant_type=authorization_code";
        String requestUrl = WX_URL.replace("APPID", "wx424a278ef6813b98").
                replace("SECRET", "32eaf5a7c7a7286ccc81249319764dd7").
                replace("CODE", code);
        BufferedReader in = null;
        String openId = null;
        try {
            URL weChatUrl = new URL(requestUrl);
            // 打开和URL之间的连接
            URLConnection connection = weChatUrl.openConnection();
            // 设置通用的请求属性
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                builder.append(line);
            }
            //从带有openid、session_key的json字符串获取openid
            JSONObject jsonObject = JSONObject.parseObject(builder.toString());
            openId = jsonObject.getString("openid");
            return openId;
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }// 使用finally块来关闭输入流
    }
}
