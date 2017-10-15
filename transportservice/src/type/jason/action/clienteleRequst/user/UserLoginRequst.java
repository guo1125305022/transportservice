package type.jason.action.clienteleRequst.user;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.dal.UserInfoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JKX_GXL on 2017/5/12.
 * 用户登录
 */
public class UserLoginRequst extends BaseServlet {

    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        return requestData;
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String data = getData();
        try {
            String login = UserInfoService.login(data);//用户登录
            sendDataPost(resp, login);
            System.out.println("用户登陆出成功：" + login);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("用户登陆出现错误：" + e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("用户登陆出现错误：" + e);
        }

    }

    @Override
    public void sendGet(HttpServletResponse resp) {

    }
}
