package type.jason.action.entity;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;

/**
 * Created by JKX_GXL on 2017/5/12.
 * 用户信息对象
 */
public class UserInfo {
    private String userName;
    private String userPwd;
    private String phoneNumber="";
    private boolean userAuthority=false;

    public boolean isUserAuthority() {
        return userAuthority;
    }

    private String userInfoJsonString;



    public UserInfo(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        this.userName = jsonObject.getString(Cantast.UserInfoKey.KEY_USER_NAME);
        this.userPwd = jsonObject.getString(Cantast.UserInfoKey.KEY_USER_PWD);
        if(jsonObject.has(Cantast.UserInfoKey.KEY_PHONE_NUMBER)){
            this.phoneNumber = jsonObject.getString(Cantast.UserInfoKey.KEY_PHONE_NUMBER);
        }

        if(jsonObject.has(Cantast.UserInfoKey.KEY_EMAIL)){
            this.userAuthority=jsonObject.getBoolean(Cantast.UserInfoKey.KEY_EMAIL);
        }

        this.userInfoJsonString = json;
    }


    public UserInfo(String userName, String userPwd, String phoneNumber,boolean userAuthority) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.phoneNumber = phoneNumber;
        this.userAuthority=userAuthority;
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put(Cantast.UserInfoKey.KEY_USER_NAME, userName);
            jsonObject.put(Cantast.UserInfoKey.KEY_USER_PWD, userPwd);
            jsonObject.put(Cantast.UserInfoKey.KEY_PHONE_NUMBER, phoneNumber);
            jsonObject.put(Cantast.UserInfoKey.KEY_EMAIL,userAuthority);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            userInfoJsonString = jsonObject.toString();

        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

}
