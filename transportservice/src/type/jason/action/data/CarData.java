package type.jason.action.data;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;
import type.jason.action.dal.UserInfoService;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 2017/3/26.
 */
public class CarData extends BaseData {

    private Random random = new Random();
    private ArrayList<CarInfo> carInfos = new ArrayList<>();
    private static final String CAR_ACTION_START = "Start";
    private static final String CAR_ACTION_STOP = "Stop";

    /**
     * 添加小车
     *
     * @param count 添加的数量
     */
    public void addCar(int count) {
        for (int i = 0; i < count; i++) {
            CarInfo info = new CarInfo();
            info.init();
            carInfos.add(info);
        }
    }

//    public String getAllCarInfo(String json){
//        try {
//            JSONObject jsonObject=new JSONObject(json);
//            jsonObject.getString(Cantast.UserInfoKey.KEY_USER_NAME);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    protected void init() {
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        carInfos.add(new CarInfo());
        for (CarInfo info : carInfos) {
            info.init();
        }
    }

    @Override
    protected void logic() {
        for (CarInfo info : carInfos) {

            if (info.getMoney() <= 0) {
                info.setMoney(0);
            }
            if (info.getMoney() > 0) {
                info.setMoney((!info.action ? info.getMoney() : info.getMoney() - 5));
            }
            int action = random.nextInt(2);
            int speed = random.nextInt(20) + 5;
            if (!info.action) {//小车是否启动
                speed = 0;
            }
            switch (action) {
                case 0://加速度
                    if ((info.speed + speed) > Integer.MAX_VALUE) {
                        info.speed = info.speed - speed;
                        break;
                    }
                    info.speed = info.speed + speed;
                    break;
                case 1://减速度
                    if ((info.speed - speed) <= 0) {
                        info.speed = info.speed + speed;
                        break;
                    }
                    info.speed = info.speed - speed;
                    break;
            }
        }
    }

    public String getCarCount(String res) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cantast.KEY_CAR_COUNT, carInfos.size());
        return jsonObject.toString();
    }

    /**
     * { 'result':'ok'}
     *
     * @param res
     * @return
     */
    public String setCarAction(final String res) throws JSONException {

        int carId = 0;
        String action = "";
        JSONObject request = new JSONObject(res);
        carId = request.getInt(Cantast.KEY_CAR_ID);
        action = request.getString(Cantast.KEY_CAR_ACTION);
        JSONObject json = new JSONObject();
        if (carId > carInfos.size() || carId <= 0) {
            json.put(Cantast.KEY_MSG, "操作的小车看不存在！");
            json.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            return json.toString();
        }
//        if (!action.equals(CAR_ACTION_START) || !action.equals(CAR_ACTION_STOP)) {
//            json.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
//            return json.toString();
//        }
        carInfos.get(carId - 1).setAction((action.equals(CAR_ACTION_START)));//设置小车动作成功
        json.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
        json.put(Cantast.KEY_MSG, "设置成功");
        return json.toString();
    }


    /**
     * { 'CarSpeed':****}成功
     * { 'result':'failed'}失败
     *
     * @param object
     * @return
     */
    @Override
    protected String getData(Object object) {
        return null;
    }

    @Override
    public int sleep() {
        return 0;
    }

    /**
     * 小车速度请求
     *
     * @param request
     * @return
     * @throws JSONException
     */
    public String getCarSpeed(String request) throws JSONException {

        JSONObject requestJson = new JSONObject(request);
        int carId = requestJson.getInt(Cantast.KEY_CAR_ID);//小车
        JSONObject jsonObject = new JSONObject();
        if (carId > carInfos.size() || carId <= 0) {//访问失败
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            return jsonObject.toString();
        }
        //访问成功
        jsonObject.put(Cantast.KEY_CAR_SPEED, carInfos.get(carId - 1).getSpeed());//获取小车速度
        return jsonObject.toString();
    }

    /**
     * 查询小车充值余额
     *
     * @param request
     * @return
     * @throws JSONException
     */
    public String getAccountBalance(String request) throws JSONException {
        JSONObject requestJson = new JSONObject(request);
        int carId = requestJson.getInt(Cantast.KEY_CAR_ID);
        JSONObject result = new JSONObject();
        result.put(Cantast.KEY_BANLANCE, carInfos.get(carId - 1).money);//获取小车充值余额
        return result.toString();
    }

    /**
     * 小车余额充值
     * {'CarID':4, ' Money ':200}
     *
     * @param request
     * @return
     */
    public String setAccountBalance(String request) throws JSONException {
        JSONObject requestJson = new JSONObject(request);
        int carId = requestJson.getInt(Cantast.KEY_CAR_ID);
        int money = requestJson.getInt(Cantast.KEY_MONEY);
        CarInfo info = carInfos.get(carId - 1);
        info.setMoney(info.getMoney() + money);
        requestJson = new JSONObject();
        requestJson.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
        return requestJson.toString();
    }


    private class CarInfo {
        private int id = 0;//小车编号
        private int speed = 0;//小车速度
        private boolean action = true;//小车动作
        private int money = 0;//小车充值金额

        public int getSpeed() {
            return speed;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public void init() {
            speed = random.nextInt(100);
        }

        public void setAction(boolean action) {
            this.action = action;
        }
    }
}
