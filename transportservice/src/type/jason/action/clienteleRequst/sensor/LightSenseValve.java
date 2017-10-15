package type.jason.action.clienteleRequst.sensor;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.SensorSystemData;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/3/27.
 * 获取光线传感器数据
 */
public class LightSenseValve extends BaseServlet {

    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        SensorSystemData data=getAllData().getSensorSystemData();
        return data.getLight(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataPost(resp,respData);
            System.out.println("小车光线强度数据为："+respData);
        } catch (JSONException e) {
            SystemGet("光线强度",e.getMessage());
        } catch (IOException e) {
            SystemOut("光线强度",e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataGet(resp,respData);
            System.out.println("小车光线强度数据为："+respData);
        } catch (JSONException e) {
            SystemGet("光线强度",e.getMessage());
        } catch (IOException e) {
            SystemOut("光线强度",e.getMessage());
        }
    }

}
