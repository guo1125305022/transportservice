package type.jason.action.clienteleRequst.bus;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.data.DistanceSystemData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/27.
 * @author 郭小浪
 * @version 2.0
 * @since   查询公交信息
 */
public class BusstationInfoGet extends BaseServlet {


    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        DistanceSystemData distanceSystemData=getAllData().getDistanceSystemData();
        return distanceSystemData.getDistanceInfo(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataPost(resp,respData);
            System.out.println("公交数据为："+respData);
        } catch (JSONException e) {
            System.out.println("获取公交相关数据是发生JSON错误："+e.getMessage());
        } catch (IOException e) {
            System.out.println("发送公交相关数据是发生IO错误："+e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData=getData();
        String respData;
        try {
            respData=getLoactionSystemData(requestData);
            sendDataGet(resp,respData);
            System.out.println("公交数据为："+respData);
        } catch (JSONException e) {
            System.out.println("获取公交相关数据是发生JSON错误："+e.getMessage());
        } catch (IOException e) {
            System.out.println("发送公交相关数据是发生IO错误："+e.getMessage());
        }

    }
}
