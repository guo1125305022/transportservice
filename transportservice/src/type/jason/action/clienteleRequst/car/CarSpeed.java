package type.jason.action.clienteleRequst.car;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.CarData;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/3/27
 * 获取小车速度.
 */
public class CarSpeed extends BaseServlet {
    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        CarData data=getAllData().getCarData();
        return data.getCarSpeed(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataPost(resp,respData);
            System.out.println("小车速度数据为："+respData);
        } catch (JSONException e) {
            SystemGet("小车速度",e.getMessage());
        } catch (IOException e) {
            SystemOut("小车速度",e.getMessage());
        }

    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData=getData();
            String respData;
            try {
                respData=getLoactionSystemData(requestData);
                sendDataGet(resp,respData);
                System.out.println("小车速度数据为："+respData);
            } catch (JSONException e) {
                SystemGet("小车速度",e.getMessage());
            } catch (IOException e) {
            SystemOut("小车速度",e.getMessage());
        }
    }


}
