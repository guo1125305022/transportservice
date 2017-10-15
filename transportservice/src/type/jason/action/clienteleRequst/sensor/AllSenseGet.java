package type.jason.action.clienteleRequst.sensor;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.SensorSystemData;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/3/27.
 * 获取所有环境传感器信息
 */
public class AllSenseGet extends BaseServlet {


    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        SensorSystemData sensorSystemData=getAllData().getSensorSystemData();
        return  sensorSystemData.getSensor(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String data=getData();
        String respData;
        try {
            respData=getLoactionSystemData(data);
            sendDataPost(resp,respData);
            System.out.println("传感器数据为："+respData);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("获取传感器数据是发生JSON错误："+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取传感器数据是发生IO错误："+e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String data=getData();
        String respData;
        try {
            respData=getLoactionSystemData(data);
            sendDataGet(resp,respData);
            System.out.println("传感器数据为："+respData);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("获取传感器数据是发生JSON错误："+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取传感器数据是发生IO错误："+e.getMessage());
        }
    }

}
