package type.jason.action;

/**
 * Created by Admin on 2017/3/26.
 * @author 郭小浪
 * @version 2.0
 * 全局静态常量
 */
public class Cantast {

    public static final String KEY_CAR_ID = "CarId";//小车ID
    public static final String KEY_CAR_SPEED = "CarSpeed";//小车速度
    public static final String KEY_MONEY = "Money";//金额
    public static final String KEY_RESULT = "Result";//返回
    public static final String KEY_OK = "Ok";//成功
    public static final String KEY_FAILED = "Failed";//失败
    public static final String KEY_MSG = "Msg";//返回的消息
    public static final String KEY_BANLANCE = "Balance";//金额
    public static final String KEY_CAR_ACTION = "CarAction";//小车动作
    public static final String KEY_RATE_TYPE = "RateType";//停车场费用类型
    public static final String KEY_PARK_FREE_ID = "ParkFreeId";//停车场停车为ID
    //环境键值对KEY
    public static final String KEY_SENEOR_PM = "pm2.5";//PM2.5
    public static final String KEY_SENEOR_CO2 = "co2";//二氧化碳
    public static final String KEY_SENEOR_HUMIDITY = "humidity";//湿度
    public static final String KEY_SENEOR_TEMPERATURE = "temperature";//温度
    public static final String KEY_SENEOR_LIGHT_INTENSITY = "LightIntensity";//光线强度

    /**
     * 红绿灯键值对KEY
     */
    public static final String KEY_TRAFFIC_LIGHT_ID = "TrafficLightId";//红绿灯Id
    public static final String KEY_TRAFFIC_TIME = "traffictime";
    public static final String KEY_TRAFFIC_TYPE = "traffic_type";//
    public static final String KEY_RED_TIME = "RedTime";//红灯时间
    public static final String KEY_YELLOW_TIME = "YellowTime";//黄时间
    public static final String KEY_GREEN_TIME = "GreenTime";//绿灯时间
    public static final String KEY_TIME="Time";

    public static final String KEY_UP = "Up";
    public static final String KEY_DOWN = "Down";

    /**
     * 公交键值对键
     */
    public static final String KEY_BUS_STATION_ID = "BusStationId";//公交站台Id
    public static final String KEY_BUS_ID = "BusId";//公交id
    public static final String KEY_DISTANCE = "Distance";//距离
    public static final String KEY_BUS_CAPACITY="BusCapacity";//公交容量
    /**
     * 小车数量
     */
    public static final String KEY_CAR_COUNT = "CarCount";//


    public static final String RATE_TYPE_COUNT = "Count";//停车类型次
    public static final String RATE_TYPE_HOUR = "Hour";//停车类型小时


    public static final String KEY_ROAD_ID="RoadId";
    public static final String KEY_ROAD_STATUS="Status";//道路状态


    public static final String KEY_ROAD_LIGHT_ID ="RoadLightId ";//路灯ID
    public static final String KEY_ROAD_LIGHT_STATUS="Status";//路灯状态
    public static final String ROAD_STATE_OPEN="Open";//路灯打开状态
    public static final String ROAD_STATE_CLOSE="Close";//路灯关闭状态
    public static final String ROAD_SET_STATE="Action";//路灯关闭状态
    public static final String KEY_CONTREL_MODE="ControlMode";//路灯控制模式
    public static final String CONTREL_MODE_AUTO="Auto";//路灯自动控制模式




    /**
     *用户信息KEY
     */
    public class UserInfoKey {
        public static final String TABLE_NAME = "userInfo";//数据库表名
        public static final String KEY_USER_NAME = "userName";//用户名
        public static final String KEY_USER_PWD = "userPassword";//用户密码
        public static final String KEY_PHONE_NUMBER = "userPhone";//用户电话
        public static final String KEY_EMAIL = "userAuthority";//用户邮件
    }


}
