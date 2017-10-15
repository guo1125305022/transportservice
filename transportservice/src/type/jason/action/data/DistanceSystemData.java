package type.jason.action.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;
import type.jason.action.dal.UserInfoService;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 2017/3/26.
 */
public class DistanceSystemData extends BaseData {
    private Random random = new Random();
    private ArrayList<Distance> distances = new ArrayList<>();
    private ArrayList<BusInfo> busInfos = new ArrayList<>();


    @Override
    protected void init() {
        distances.add(new Distance());
        distances.add(new Distance());
        distances.add(new Distance());

        for (int i = 0; i < distances.size(); i++) {
            distances.get(i).setDistance(i);
        }
        busInfos.add(new BusInfo());
        busInfos.add(new BusInfo());
    }

    @Override
    protected void logic() {
        for (BusInfo info : busInfos) {
            info.logic();
        }
    }

    @Override
    protected String getData(Object object) throws JSONException {
        return null;
    }


    /**
     * 获取公交当前乘坐人数
     * @param request 请求数据
     * @return 返回 JSONObject.toString 数据
     * @throws JSONException
     */
    public String getBusCapacty(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        int busId=jsonObject.getInt(Cantast.KEY_BUS_ID)-1;
        BusInfo busInfo = busInfos.get(busId);
        jsonObject=new JSONObject();
        //{"RESULT":"S","ERRMSG":"成功","BusCapacity":20}
        jsonObject.put(Cantast.KEY_BUS_CAPACITY,busInfo.getCapacity());
        return jsonObject.toString();
    }

    /**
     * 获取所有公交距离站台数据
     * @param request
     * @return SONObject.toString 数据
     * @throws JSONException
     */
    public String getAllDistanceInfo(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        String userName = jsonObject.getString(Cantast.UserInfoKey.KEY_USER_NAME);
        if (!UserInfoService.UserIsAdmin(userName)) {
            jsonObject = new JSONObject();
            jsonObject.put(Cantast.KEY_MSG, String.format("%s用户不是管理员用户无权限查看数据"));
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            return jsonObject.toString();
        }
        for (Distance d : distances) {
            JSONArray jsonArray = new JSONArray();
            int busId = 0;
            for (BusInfo info : busInfos) {
                busId++;
            }
            return jsonArray.toString();
        }
        return "";
    }

    /**
     * 获取公交距离站台距离
     * @param request 请求数据
     * @return SONObject.toString 数据
     * @throws JSONException
     */
    public String getDistanceInfo(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        int disId = jsonObject.getInt(Cantast.KEY_BUS_STATION_ID);
        Distance distance = distances.get(disId - 1);
        int busId = 0;
        JSONArray jsonArray = new JSONArray();
        for (BusInfo info : busInfos) {
            int d = Math.abs(info.currD - distance.getDistance());
            JSONObject json = new JSONObject();
            json.put(Cantast.KEY_BUS_ID, busId + 1);
            json.put(Cantast.KEY_DISTANCE, d);
            jsonArray.put(json);
            busId++;
        }
        return jsonArray.toString();
    }

    @Override
    public int sleep() {
        return 0;
    }

    /**
     * 公交站
     */
    private class Distance {
        private int Distance = 0;

        public void setDistance(int distance) {
            Distance = distance * 10000;
        }

        public int getDistance() {
            return Distance;
        }
    }

    // http://ip:port/transportservice/action/GetBusCapacity.do

    /**
     * 公交车信息
     */
    private class BusInfo {
        private int currD = 0;
        private static final int MAX = 3 * 100000;
        private static final int ACTION_NEXT = 0x55f;//公交向前行驶标记
        private static final int ACTION_LOAST = 0x55e;//公交返回行驶标记

        private int speed = 300;//公交速度
        private int capacity = 0;//公交载人数量
        private int action = ACTION_NEXT;//公交行驶状态

        public int getCapacity() {
            return capacity;
        }

        public BusInfo() {
            init();
        }

        private void init() {
            currD = random.nextInt(50) * 1000;
        }

        public void logic() {
            capacity = random.nextInt(60);//随机计算当前公交人数
            switch (action) {
                case ACTION_NEXT:
                    currD = currD + speed;
                    break;
                case ACTION_LOAST:
                    currD = currD - speed;
                    break;
            }
            if (currD <= 0) {
                action = ACTION_NEXT;
            }
            if (currD > MAX) {
                action = ACTION_LOAST;
            }

        }
    }
}
