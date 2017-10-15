package type.jason.action.data;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;
import type.jason.action.dal.UserInfoService;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Admin on 2017/3/26.
 */
public class TrafficLightSystem extends BaseData {
    private ArrayList<TrafficLightInfo> list = new ArrayList<>();
    private Random random = new Random();

    @Override
    protected void init() {
        list.add(new TrafficLightInfo());
        list.add(new TrafficLightInfo());
        list.add(new TrafficLightInfo());
        list.add(new TrafficLightInfo());
        list.add(new TrafficLightInfo());
        list.add(new TrafficLightInfo());
        list.add(new TrafficLightInfo());
    }

    @Override
    protected void logic() {
        for (TrafficLightInfo info : list) {
            info.logic();
        }
    }


    /**
     * 根据红绿灯ID获取红绿灯指定等时间
     *
     * @param request
     * @return
     * @throws JSONException
     */
    public String getIdTrafficLightInfoByLightName(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        if (!UserInfoService.UserIsAdmin(jsonObject.getString(Cantast.UserInfoKey.KEY_USER_NAME))) {//检查用户是否是管理员
            jsonObject = new JSONObject();
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            jsonObject.put(Cantast.KEY_MSG, "该用户不是管理员用户");
            return jsonObject.toString();
        }
        int index = jsonObject.getInt(Cantast.KEY_TRAFFIC_LIGHT_ID);
        String type = jsonObject.getString(Cantast.KEY_TRAFFIC_TYPE);
        TrafficLightInfo info = list.get(
                (index > list.size() - 1 ?
                        list.size() - 1 :
                        (index < 0 ? 0 :
                                index)));
        int time = 0;
        jsonObject=new JSONObject();
        if (Objects.equals(type, Cantast.KEY_RED_TIME)) {
            time = info.getRed();
            jsonObject.put(Cantast.KEY_TIME, time);
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            return jsonObject.toString();
        } else if (Objects.equals(type, Cantast.KEY_GREEN_TIME)) {
            time = info.getGreen();
            jsonObject.put(Cantast.KEY_TIME, time);
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            return jsonObject.toString();
        } else if (Objects.equals(type, Cantast.KEY_YELLOW_TIME)) {
            time = info.getYellow();
            jsonObject.put(Cantast.KEY_TIME, time);
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            return jsonObject.toString();
        }
        jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);

        return jsonObject.toString();
    }

    /**
     * 设置单个红绿灯中的指定灯信息
     *
     * @param request
     * @return
     * @throws JSONException
     */
    public String setTrafficLightInfo(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        if (!UserInfoService.UserIsAdmin(jsonObject.getString(Cantast.UserInfoKey.KEY_USER_NAME))) {//检查用户是否是管理员用户
            jsonObject = new JSONObject();
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            return jsonObject.toString();
        }

        int index = jsonObject.getInt(Cantast.KEY_TRAFFIC_LIGHT_ID);
        int time = jsonObject.getInt(Cantast.KEY_TRAFFIC_TIME);
        String type = jsonObject.getString(Cantast.KEY_TRAFFIC_TYPE);
        TrafficLightInfo info = list.get(
                (index > list.size() - 1 ?
                        list.size() - 1 :
                        (index < 0 ? 0 :
                                index)));

        jsonObject = new JSONObject();
        if (type == Cantast.KEY_RED_TIME) {
            info.setRed(time);
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            return jsonObject.toString();
        } else if (type == Cantast.KEY_GREEN_TIME) {
            info.setGreen(time);
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            return jsonObject.toString();
        } else if (type == Cantast.KEY_YELLOW_TIME) {
            info.setYellow(time);
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
            return jsonObject.toString();
        }
        jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
        return jsonObject.toString();
    }

    /**
     * 设置单个红绿灯配置信息信息
     *
     * @param request
     * @return
     * @throws JSONException
     */
    public String setIdTrafficLightInfo(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        if (!UserInfoService.UserIsAdmin(jsonObject.getString(Cantast.UserInfoKey.KEY_USER_NAME))) {
            jsonObject = new JSONObject();
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            return jsonObject.toString();
        }

        int index = jsonObject.getInt(Cantast.KEY_TRAFFIC_LIGHT_ID);
        int red = jsonObject.getInt(Cantast.KEY_RED_TIME);
        int green = jsonObject.getInt(Cantast.KEY_GREEN_TIME);
        int yellow = jsonObject.getInt(Cantast.KEY_YELLOW_TIME);
        TrafficLightInfo info = list.get(
                (index > list.size() - 1 ?
                        list.size() - 1 :
                        (index < 0 ? 0 :
                                index)));

        jsonObject = new JSONObject();
        info.setYellow(yellow);
        info.setRed(red);
        info.setGreen(green);

        jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
        return jsonObject.toString();

    }

    /**
     * 根据红绿灯ID获取红绿灯时间
     *
     * @param request
     * @return
     * @throws JSONException
     */
    public String getIdAllTrafficLightInfo(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        int index = jsonObject.getInt(Cantast.KEY_TRAFFIC_LIGHT_ID);
        TrafficLightInfo info = list.get(index - 1);
        jsonObject = new JSONObject();
        jsonObject.put(Cantast.KEY_RED_TIME, info.getRed());
        jsonObject.put(Cantast.KEY_GREEN_TIME, info.getGreen());
        jsonObject.put(Cantast.KEY_YELLOW_TIME, info.getYellow());
        return jsonObject.toString();
    }

    @Override
    protected String getData(Object object) throws JSONException {
        return null;
    }

    @Override
    public int sleep() {
        return 0;
    }

    /**
     * 红绿灯实体对象
     */
    private class TrafficLightInfo {
        private int red = 0;
        private int yellow = 0;
        private int green = 0;
        private int count = 80;
        private static final int baseRed = 30;
        private static final int baseYellow = 3;
        private static final int baseGreen = 47;
        private static final int baseCount = 80;

        public TrafficLightInfo() {
            init();
        }


        public void init() {
            count = random.nextInt(80);
            logic();
        }


        public void logic() {
            count--;
            if (count < 0) {
                count = baseCount;
            }
            red = count < (baseGreen + baseYellow) ? (baseGreen + baseYellow) - count : baseCount - (baseGreen + baseYellow);//计算红灯
            green = count < (baseYellow + baseRed) ? (baseYellow + baseRed) - count : count - (baseYellow + baseRed);//计算绿灯
            yellow = count < (baseRed + baseGreen) ? (baseRed + baseGreen) - count : count - (baseRed + baseGreen);//计算黄灯
        }


        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

        public int getYellow() {
            return yellow;
        }

        public void setYellow(int yellow) {
            this.yellow = yellow;
        }

        public int getGreen() {
            return green;
        }

        public void setGreen(int green) {
            this.green = green;
        }
    }
}
