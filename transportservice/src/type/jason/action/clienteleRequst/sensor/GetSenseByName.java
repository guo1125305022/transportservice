package type.jason.action.clienteleRequst.sensor;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.SensorSystemData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JKX_GXL on 2017/5/28.
 * @author 郭小浪
 * @version 2.0
 * @since 主要用于请求环境传感器中的指定传感器数据
 */
public class GetSenseByName extends BaseServlet {
    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        SensorSystemData sensorSystemData=getAllData().getSensorSystemData();
        return  sensorSystemData.getSensorByName(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String data=getData();
        String respData;
        try {
            respData=getLoactionSystemData(data);
            sendDataPost(resp,respData);
            System.out.println(String.format("传感器:%s \n数据:：",respData));
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
            System.out.println(String.format("传感器:%s数据:"+respData));
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("获取传感器数据是发生JSON错误："+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取传感器数据是发生IO错误："+e.getMessage());
        }
    }
}
