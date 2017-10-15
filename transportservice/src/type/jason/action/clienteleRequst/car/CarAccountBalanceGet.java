package type.jason.action.clienteleRequst.car;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.CarData;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Administrator on 2017/3/27.
 * 获取小车余额
 */
public class CarAccountBalanceGet extends BaseServlet {
    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        CarData carData = getAllData().getCarData();
        return carData.getAccountBalance(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataPost(resp, respData);
            System.out.println("小车金额数据为：" + respData);
        } catch (JSONException e) {
            SystemGet("小车金额", e.getMessage());
        } catch (IOException e) {
            SystemOut("小车金额", e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getLoactionSystemData(requestData);
            sendDataGet(resp, respData);
            System.out.println("小车金额数据为：" + respData);
        } catch (JSONException e) {
            SystemGet("小车金额", e.getMessage());
        } catch (IOException e) {
            SystemOut("小车金额", e.getMessage());
        }
    }


}
