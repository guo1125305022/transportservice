package type.jason.action.clienteleRequst.TrafficLight;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.TrafficLightSystem;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/3/27.
 * 根据红绿灯Id获取红绿灯配置信息
 */
public class TrafficLightConfigAciton extends BaseServlet {

    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        TrafficLightSystem data=getAllData().getTrafficLightSystem();
        return data.getIdAllTrafficLightInfo(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataPost(resp, respData);
            System.out.println("红绿灯查询数据为："+respData);
        } catch (JSONException e) {
            SystemGet("红绿灯查询", e.getMessage());
        } catch (IOException e) {
            SystemOut("红绿灯查询", e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataGet(resp, respData);
            System.out.println("红绿灯查询数据为："+respData);
        } catch (JSONException e) {
            SystemGet("红绿灯查询", e.getMessage());
        } catch (IOException e) {
            SystemOut("红绿灯查询", e.getMessage());
        }
    }

}
