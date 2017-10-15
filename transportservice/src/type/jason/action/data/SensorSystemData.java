package type.jason.action.data;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;

import java.util.Random;

/**
 * Created by Admin on 2017/3/26.
 */
public class SensorSystemData extends BaseData {
    public SensorKongQi getSensorKongQi() {
        return sensorKongQi;
    }

    private SensorKongQi sensorKongQi;
    private Random random = new Random();
    private LightSensor lightSensor;

    @Override
    protected void init() {
        sensorKongQi = new SensorKongQi();
        lightSensor = new LightSensor();
    }

    @Override
    protected void logic() {
//        System.out.println("传感器数据变化");
        sensorKongQi.setCo2(random.nextInt(100));
        sensorKongQi.setLightIntensity(random.nextInt(2000));
        sensorKongQi.setPm(random.nextInt(700));
        sensorKongQi.setTemperature(random.nextInt(50));
        sensorKongQi.setHumidity(random.nextInt(1000));
        lightSensor.setDown(random.nextInt(500));
        lightSensor.setUp(random.nextInt(1000));
    }

    @Override
    protected String getData(Object object) throws JSONException {
        return null;
    }

    @Override
    public int sleep() {
        return 0;
    }

    //{"Down":" xxxx","Up":" xxxx "}
    public String getLight(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        jsonObject.put(Cantast.KEY_DOWN, lightSensor.getDown());
        jsonObject.put(Cantast.KEY_UP, lightSensor.getUp());
        return jsonObject.toString();
    }

    public String getSensor(String request) throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Cantast.KEY_SENEOR_PM, sensorKongQi.getPm());
        jsonObject.put(Cantast.KEY_SENEOR_CO2, sensorKongQi.getCo2());
        jsonObject.put(Cantast.KEY_SENEOR_HUMIDITY, sensorKongQi.getHumidity());
        jsonObject.put(Cantast.KEY_SENEOR_TEMPERATURE, sensorKongQi.getTemperature());
        jsonObject.put(Cantast.KEY_SENEOR_LIGHT_INTENSITY, sensorKongQi.getLightIntensity());
        return jsonObject.toString();
    }

    public String getSensorByName(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        String sensorName = jsonObject.getString("SenseName");

        switch (sensorName) {
            case Cantast.KEY_SENEOR_CO2:
                jsonObject.put("xxx", sensorKongQi.getCo2());
                break;
            case Cantast.KEY_SENEOR_HUMIDITY:
                jsonObject.put("xxx", sensorKongQi.getHumidity());
                break;
            case Cantast.KEY_SENEOR_LIGHT_INTENSITY:
                jsonObject.put("xxx", sensorKongQi.getLightIntensity());
                break;
            case Cantast.KEY_SENEOR_PM:
                jsonObject.put("xxx", sensorKongQi.getPm());
                break;
            case Cantast.KEY_SENEOR_TEMPERATURE:
                jsonObject.put("xxx", sensorKongQi.getTemperature());
                break;
        }
        return jsonObject.toString();
    }

    public class LightSensor {
        private int up = 0;
        private int down = 0;

        public int getUp() {
            return up;
        }

        public void setUp(int up) {
            this.up = up;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }
    }

    public class SensorKongQi {
        //{"pm2.5":4,"co2":813,"temperature":19,"LightIntensity":0,"humidity":40}
        private int pm = 0;
        private int co2 = 0;
        private int LightIntensity = 0;
        private int humidity = 0;
        private int Temperature = 0;

        public int getPm() {
            return pm;
        }

        public void setPm(int pm) {
            this.pm = pm;
        }

        public int getCo2() {
            return co2;
        }

        public void setCo2(int co2) {
            this.co2 = co2;
        }

        public int getLightIntensity() {
            return LightIntensity;
        }

        public void setLightIntensity(int lightIntensity) {
            LightIntensity = lightIntensity;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public int getTemperature() {
            return Temperature;
        }

        public void setTemperature(int temperature) {
            Temperature = temperature;
        }
    }
}
