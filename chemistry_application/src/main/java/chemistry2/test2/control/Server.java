package chemistry2.test2.control;

import chemistry2.test2.Search;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet(name = "Server",urlPatterns = "/server")

public class Server extends HttpServlet {
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] buffer=new byte[1024];
        InputStream inputStream=request.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        int length;
        while ((length=inputStream.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,length);
        }
        String str= URLDecoder.decode(String.valueOf(byteArrayOutputStream),"UTF-8");
        String str_result=str.substring(3,str.length()-1);
        JSONObject jsonObject=JSONObject.fromObject(str_result);

        try {
            System.out.println("从客户端收到的消息为：\n用户名："+jsonObject.getString("username")+"\n密码为:"+jsonObject.getString("password"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String str_response="服务器已经收到客户端的消息";
        response.getWriter().write(URLEncoder.encode(str_response,"UTF-8"));
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] buffer=new byte[1024];
        InputStream inputStream=request.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        int length;
        while ((length=inputStream.read(buffer))!=-1){
            byteArrayOutputStream.write(buffer,0,length);
        }
        String str= URLDecoder.decode(String.valueOf(byteArrayOutputStream),"UTF-8");
        String str_result=str.substring(3,str.length()-1);
        JSONObject jsonObject=JSONObject.fromObject(str_result);

        Search se=new Search();

        String str1=jsonObject.getString("name");

        String str_response=se.serch(str1);//返回的消息
        response.getWriter().write(URLEncoder.encode(str_response,"UTF-8"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------doGet----------------");
        doPost(request, response);
    }
}
