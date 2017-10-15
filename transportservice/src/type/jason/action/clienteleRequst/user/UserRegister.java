package type.jason.action.clienteleRequst.user;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;
import type.jason.action.dal.UserInfoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JKX_GXL on 2017/5/12.
 * 用户注册
 */
public class UserRegister extends BaseServlet {
    @Override
    public String getLoactionSystemData(String requestData) throws JSONException {
        return null;
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String data = getData();
        try {
            String login = UserInfoService.InserUserInfo(data);
            sendDataPost(resp, login);
            System.out.println("用户注册：" + login);
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("用户用户注册出现错误：" + e);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("用户用户注册出现错误：" + e);
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {

    }
}
