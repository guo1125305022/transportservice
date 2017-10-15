package type.jason.action.data;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by JKX_GXL on 2017/5/14.
 */
public class StreetLampData extends BaseData {
    private ArrayList<StreetLampInfo> arrayList = new ArrayList<>();
    private SensorSystemData sensorSystemData;

    public void setSensorSystemData(SensorSystemData sensorSystemData) {
        this.sensorSystemData = sensorSystemData;
    }

    @Override
    protected void init() {
        arrayList.add(new StreetLampInfo());
        arrayList.add(new StreetLampInfo());
        arrayList.add(new StreetLampInfo());
    }

    @Override
    protected void logic() {
        if (sensorSystemData == null) {
            return;
        }
        SensorSystemData.SensorKongQi sensorKongQi = sensorSystemData.getSensorKongQi();
        for (StreetLampInfo streetLampInfo : arrayList) {
            if (sensorKongQi.getLightIntensity() > 100 && streetLampInfo.isModle()) {

            }
        }

    }

    @Override
    protected String getData(Object object) throws JSONException {
        return null;
    }

    @Override
    public int sleep() {
        return 0;
    }

    private class StreetLampInfo {
        private boolean state;
        private boolean modle;//自动模式为true 手动模式为false

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public boolean isModle() {
            return modle;
        }

        public void setModle(boolean modle) {
            this.modle = modle;
        }
    }


}
