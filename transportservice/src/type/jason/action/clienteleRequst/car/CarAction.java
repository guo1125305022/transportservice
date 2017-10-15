package type.jason.action.clienteleRequst.car;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.CarData;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/3/27.
 * 设置小车起停状态
 */
public class CarAction extends BaseServlet {


    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        CarData data=getAllData().getCarData();
        return data.setCarAction(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataPost(resp,respData);
            System.out.println("小车动作数据为："+respData);
        } catch (JSONException e) {
            SystemGet("设置小车动作",e.getMessage());
        } catch (IOException e) {
            SystemOut("设置小车动作",e.getMessage());
        }

    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {

            respData=getLoactionSystemData(requestData);
            sendDataGet(resp,respData);
            System.out.println("小车动作数据为："+respData);
        } catch (JSONException e) {
            SystemGet("设置小车动作",e.getMessage());
        } catch (IOException e) {
            SystemOut("设置小车动作",e.getMessage());
        }

    }


}
