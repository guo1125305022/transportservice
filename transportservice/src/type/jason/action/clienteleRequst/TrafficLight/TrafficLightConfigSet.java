package type.jason.action.clienteleRequst.TrafficLight;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2017/6/29.
 * @author 郭小浪
 * @version 1.0
 * @since 本类主要设置单个红绿灯的配置信息（红灯绿灯黄灯三个灯信息）
 */
public class TrafficLightConfigSet extends BaseServlet {
    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        return getAllData().getTrafficLightSystem().setIdTrafficLightInfo(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataPost(resp, respData);
            System.out.println("红绿灯数据灯配置："+respData);
        } catch (JSONException e) {
            SystemGet("红绿灯数据灯配置", e.getMessage());
        } catch (IOException e) {
            SystemOut("红绿灯数据灯配置", e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataGet(resp, respData);
            System.out.println("红绿灯数据灯配置："+respData);
        } catch (JSONException e) {
            SystemGet("红绿灯数据灯配置", e.getMessage());
        } catch (IOException e) {
            SystemOut("红绿灯数据灯配置", e.getMessage());
        }
    }
}
