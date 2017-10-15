package type.jason.action.clienteleRequst.road;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2017/6/29.
 * 设置路灯数据
 * 设置单个路灯数据
 */
public class RoadLightStatusActionSet extends BaseServlet {
    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        return getAllData().getRoadLightStatusSystem().setRoadLightStatusAction(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataPost(resp, respData);
            System.out.println("单个路灯设置数据为："+respData);
        } catch (JSONException e) {
            SystemGet("单个路灯设置", e.getMessage());
        } catch (IOException e) {
            SystemOut("单个路灯设置", e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataGet(resp, respData);
            System.out.println("单个路灯设置数据为："+respData);
        } catch (JSONException e) {
            SystemGet("单个路灯设置", e.getMessage());
        } catch (IOException e) {
            SystemOut("单个路灯设置", e.getMessage());
        }
    }
}
