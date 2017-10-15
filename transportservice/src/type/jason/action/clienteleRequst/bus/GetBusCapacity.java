package type.jason.action.clienteleRequst.bus;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.AllData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2017/6/27.
 * @author 郭小浪
 * @version 1.0
 * @since 本来用于请求公交载人数量
 */
public class GetBusCapacity extends BaseServlet {
    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        return AllData.getAllData().getDistanceSystemData().getBusCapacty(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String data=getData();
        String respData;
        try {
            respData=getLoactionSystemData(data);
            sendDataPost(resp,respData);
            System.out.println(String.format("公交载人:%s \n数据:：",respData));
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("获取公交载人数据是发生JSON错误："+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取公交载人数据是发生IO错误："+e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String data=getData();
        String respData;
        try {
            respData=getLoactionSystemData(data);
            sendDataGet(resp,respData);
            System.out.println(String.format("公交载人:%s数据:"+respData));
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("获取公交载人数据是发生JSON错误："+e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("获取公交载人数据是发生IO错误："+e.getMessage());
        }
    }
}
