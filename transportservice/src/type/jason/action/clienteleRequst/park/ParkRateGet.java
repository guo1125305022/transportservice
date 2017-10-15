package type.jason.action.clienteleRequst.park;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.ParkSystemData;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/3/27.
 * 获取停车费率
 */
public class ParkRateGet extends BaseServlet {

    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        ParkSystemData data=getAllData().getParkSystemData();
        return data.getParkRate(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataPost(resp,respData);
            System.out.println("停车场停车费率强度数据为："+respData);
        } catch (JSONException e) {
            SystemGet("停车场停车费率强度",e.getMessage());
        } catch (IOException e) {
            SystemOut("停车场停车费率强度",e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataGet(resp,respData);
            System.out.println("停车场停车费率强度数据为："+respData);
        } catch (JSONException e) {
            SystemGet("停车场停车费率强度",e.getMessage());
        } catch (IOException e) {
            SystemOut("停车场停车费率强度",e.getMessage());
        }
    }

}
