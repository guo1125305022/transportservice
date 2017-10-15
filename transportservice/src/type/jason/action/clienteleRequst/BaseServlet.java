package type.jason.action.clienteleRequst;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;
import type.jason.action.dal.UserInfoService;
import type.jason.action.data.AllData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Administrator on 2017/3/27.
 * @author 郭小浪
 * @version 1.0
 *
 */
public abstract class BaseServlet extends HttpServlet {
    private AllData allData;

    public AllData getAllData() {
        return allData;
    }

    @Override
    public void init() throws ServletException {
        super.init();
        allData = AllData.getAllData();//获取服务器的上所有数据
    }

    private String Data = null;//用于临时存储用户请求的数据

    public void setData(String data) {
        Data = data;
    }

    public String getData() {
        return Data;
    }

    public abstract String getLoactionSystemData(String requestData) throws JSONException;//获取本地系统上的数据

    /**
     * 发送POST数据到客服端
     * @param resp
     */
    public abstract void sendPost(HttpServletResponse resp);//

    /**
     * 发送GET数据
     * @param resp
     */
    public abstract void sendGet(HttpServletResponse resp);//发送GET数据

    @Override
    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) {
        String add = req.getRemoteAddr();
        System.out.println(String.format("\n发生数据访问doPost:\n客服端：%s  时间%s\n",
                add, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())));
        try {
            setData(getRequestData(req));//获取请求的数据
            String s = UserInfoService.checkUser(getData());//检查用户是否存在
            if (s == null&&getData().contains(Cantast.UserInfoKey.KEY_USER_PWD)) {//判断用户为登录
                sendPost(resp);//调用子方法处理 服务器数据
            }else if(s!=null&&getData().contains(Cantast.UserInfoKey.KEY_PHONE_NUMBER)){
                sendPost(resp);//调用子方法处理 服务器数据
            }else if(s!=null){
                sendDataPost(resp, s);//用户不存在
            }else{
                sendPost(resp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) {
        String add = req.getLocalAddr();
        System.out.println("\n" + add + "发生数据访问doGet");
        try {
            setData(getRequestData(req));//获取请求的数据
            sendGet(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void SystemGet(String title, String text) {
        System.out.println(String.format("获取%s数据是发生JONS错误：%s", title, text));
    }


    public void SystemOut(String title, String text) {
        System.out.println(String.format("发送%s数据是发生IO错误：%s", title, text));
    }

    /**
     * 获取请求的数据
     *
     * @param req
     * @return
     * @throws IOException
     */
    private String getRequestData(HttpServletRequest req) throws IOException {
        InputStream inputStream = req.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        System.out.println("访问数据为：" + stringBuilder.toString());
        bufferedReader.close();
        inputStream.close();


        return stringBuilder.toString();
    }


    /**
     * 通过POST方式发送系统数据
     *
     * @param resp
     * @param data
     * @throws IOException
     */
    public void sendDataPost(HttpServletResponse resp, String data) throws IOException, JSONException {
        OutputStream outputStream = resp.getOutputStream();
        byte[] bytes = data.getBytes("UTF-8");
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 通过GET方式发送系统数据
     *
     * @param resp
     * @param data
     * @throws IOException
     */
    public void sendDataGet(HttpServletResponse resp, String data) throws IOException {
        resp.setContentType("text/html");
        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + data + "</h1>");

    }
}
