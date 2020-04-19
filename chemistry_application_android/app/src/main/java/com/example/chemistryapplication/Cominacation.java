package com.example.chemistryapplication;

import android.view.View;


import net.sf.json.JSONArray;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


public class Cominacation {
    public void TestServlet(){
        //public void TestServlet(View v){
        //构建URL的格式为:    http://IP地址:监听的端口号/Servlet的路径
        final String strUrl = "http://129.211.96.93:8080/server";
        final URL[] url = {null};
        Thread th=new Thread(new Runnable() {
            @Override
            public void run() {
                try{

                    //第一步：访问网站，进行连接
                    url[0] =new URL(strUrl);
                    HttpURLConnection urlConn=(HttpURLConnection) url[0].openConnection();
                    urlConn.setDoInput(true);       //setting inputstream using bytestream
                    urlConn.setDoOutput(true);
                    urlConn.setRequestMethod("POST");
                    urlConn.setUseCaches(false);
                    urlConn.setRequestProperty("Content-Type","application/x-ww-form-urlencoded");  //
                    urlConn.setRequestProperty("Charset","utf-8");
                    urlConn.connect();

                    //第二步：准备好发送的数据
                    Map<String ,String> map=new HashMap<>();
                    String test=Data.name;
                    map.put("name",test);
                    //map.put("password","123456");
                    JSONArray jsonarray= JSONArray.fromObject(map);

                    //第三步：打开数据通道
                    DataOutputStream dop=new DataOutputStream(urlConn.getOutputStream());
                    dop.writeUTF(String.valueOf(jsonarray));

                    //第四步：将准备的数据发送给服务器
                    dop.flush();
                    dop.close();

                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    String result="";
                    String readLine=null;
                    while ((readLine=bufferedReader.readLine())!=null){
                        result+=readLine;
                    }
                    bufferedReader.close();
                    urlConn.disconnect();
                    //调试返回的数据
                    System.out.println("从服务端获得的返回数据为:  "+ URLDecoder.decode(result,"utf-8"));

                }catch (MalformedURLException e){
                    System.out.println("出现了异常："+e.getMessage());
                } catch (IOException e) {
                    System.out.println("出现了异常："+e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        th.start();
    }
}
