package type.jason.action.dal;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;
import type.jason.action.entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by JKX_GXL on 2017/5/12.
 * 用户信息服务
 */
public class UserInfoService {

    /**
     * 用户登录
     *
     * @param josn
     * @return
     * @throws JSONException
     */
    public static String login(String josn) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        UserInfo userInfo = new UserInfo(josn);
        jsonObject.put(Cantast.UserInfoKey.KEY_USER_NAME, userInfo.getUserName());
        if (login(userInfo)) {
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            jsonObject.put(Cantast.KEY_MSG, "用户登陆成功");
        } else {
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            jsonObject.put(Cantast.KEY_MSG, "用户登陆失败");
        }

        return jsonObject.toString();
    }


    /**
     * 用户登陆
     *
     * @param userInfo
     * @return
     */
    public static boolean login(UserInfo userInfo) {
        if (userInfo == null) {
            return false;
        }

        String sql = String.format("select %s,%s,%s from %s where %s='%s' and %s='%s'",
                Cantast.UserInfoKey.KEY_USER_NAME,
                Cantast.UserInfoKey.KEY_USER_PWD,
                Cantast.UserInfoKey.KEY_PHONE_NUMBER,
                Cantast.UserInfoKey.TABLE_NAME,
                Cantast.UserInfoKey.KEY_USER_NAME,
                userInfo.getUserName(),
                Cantast.UserInfoKey.KEY_USER_PWD,
                userInfo.getUserPwd());
        boolean b = false;
        try {
            ResultSet resultSet = SQLHelper.executeQuery(sql);
            b = resultSet.next();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return b;
    }


    /**
     * 添加用户
     *
     * @param json
     * @return
     * @throws JSONException
     */
    public static String InserUserInfo(String json) throws JSONException {
        UserInfo userInfo = new UserInfo(json);
        return InserUserInfo(userInfo);
    }

    /**
     * 添加用户
     *
     * @param userInfo
     * @return
     * @throws JSONException
     */
    public static String InserUserInfo(UserInfo userInfo) throws JSONException {
        String sql = String.format("insert into %s values('%s','%s','%s',%d)",
                Cantast.UserInfoKey.TABLE_NAME,
                userInfo.getUserName(),
                userInfo.getUserPwd(),
                userInfo.getPhoneNumber(),
                userInfo.isUserAuthority() ? 0 : 1);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cantast.UserInfoKey.KEY_USER_NAME, userInfo.getUserName());
        try {
            SQLHelper.execute(sql);
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            jsonObject.put(Cantast.KEY_MSG, "用户注册成功");
        } catch (SQLException e) {
            e.printStackTrace();

            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            jsonObject.put(Cantast.KEY_MSG, "用户注册失败");
        }
        return jsonObject.toString();
    }

    /**
     * 获取所有用户数据
     *
     * @return
     */
    public static ArrayList<UserInfo> getAllUser() {
        String sql = String.format("select %s,%s,%s,%s from %s",
                Cantast.UserInfoKey.KEY_USER_NAME,
                Cantast.UserInfoKey.KEY_USER_PWD,
                Cantast.UserInfoKey.KEY_PHONE_NUMBER,
                Cantast.UserInfoKey.KEY_EMAIL,
                Cantast.UserInfoKey.TABLE_NAME
        );

        ArrayList<UserInfo> userInfos = new ArrayList<>();
        try {
            ResultSet resultSet = SQLHelper.executeQuery(sql);
            do {
                String name = resultSet.getString(Cantast.UserInfoKey.KEY_USER_NAME);
                String pwd = resultSet.getString(Cantast.UserInfoKey.KEY_USER_PWD);
                String number = resultSet.getString(Cantast.UserInfoKey.KEY_PHONE_NUMBER);
                boolean b = resultSet.getBoolean(Cantast.UserInfoKey.KEY_EMAIL);
                UserInfo userInfo = new UserInfo(name, pwd, number, b);
                userInfos.add(userInfo);
            } while (resultSet.next());
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfos;
    }

    /**
     * 检查用户是否是管理员
     *
     * @param userName
     * @return
     */
    public static boolean UserIsAdmin(String userName) {
        String sql = String.format("select %s from %s where %s='%s'",
                Cantast.UserInfoKey.KEY_EMAIL,
                Cantast.UserInfoKey.TABLE_NAME,
                Cantast.UserInfoKey.KEY_USER_NAME,
                userName
        );
        boolean b = false;
        ResultSet resultSet = null;
        try {
            resultSet = SQLHelper.executeQuery(sql);
            b = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return b;
    }


    /**
     * 检查是否存在用户
     *
     * @param json
     * @return  用户存在返回null 不存在 返回 jsonObject
     * @throws JSONException
     */
    public static String checkUser(String json) throws JSONException {
        JSONObject jsonObject=new JSONObject(json);
        if (jsonObject.has(Cantast.UserInfoKey.KEY_PHONE_NUMBER)) {
            return null;
        }
        try {
            if (UserInfoService.hastUser(json)) {//用户是否存在
                return null;//用户存在
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        jsonObject = new JSONObject();
        jsonObject.put(Cantast.KEY_MSG, "用户不存在操作取消！");
        jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    /**
     * 检查是否存在是否存在
     *
     * @param json
     * @return
     */
    public static boolean hastUser(String json) throws JSONException, SQLException {
        JSONObject jsonObject = new JSONObject(json);
        if (!jsonObject.has(Cantast.UserInfoKey.KEY_USER_NAME)) {
            return false;
        }
        String sql = String.format("select %s from %s where %s='%s'",
                Cantast.UserInfoKey.KEY_USER_NAME,
                Cantast.UserInfoKey.TABLE_NAME,
                Cantast.UserInfoKey.KEY_USER_NAME,
                jsonObject.getString(Cantast.UserInfoKey.KEY_USER_NAME));

        ResultSet resultSet = SQLHelper.executeQuery(sql);
        if (resultSet.next()) {
            resultSet.close();
            return true;
        }
        resultSet.close();
        return false;
    }

}
