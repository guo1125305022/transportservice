package type.jason.action.data;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Admin on 2017/6/27.
 * RoadLightStatusSystem
 */
public class RoadLightStatusSystem extends BaseData {
    private ArrayList<RoadLightStatusInfo> list = new ArrayList<>();
    private boolean contrelModel=false;

    @Override
    protected void init() {
        for (int i = 0; i < 3; i++) {
            list.add(new RoadLightStatusInfo());
        }
    }

    @Override
    protected void logic() {

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
     * 获取路灯打开状态
     *
     * @param request 请求参数
     * @return
     * @throws JSONException
     */
    public String getRoadLightStatus(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        int roadListhId = jsonObject.getInt(Cantast.KEY_ROAD_LIGHT_ID) - 1;
        RoadLightStatusInfo roadLightStatusInfo = list.get(roadListhId);
        jsonObject = new JSONObject();
        jsonObject.put(Cantast.KEY_ROAD_LIGHT_STATUS, (roadLightStatusInfo.isStatu() ? Cantast.ROAD_STATE_OPEN : Cantast.ROAD_STATE_CLOSE));
        return jsonObject.toString();
    }

    /**
     * 设置路灯控制模式
     * @param reques
     * @return
     * @throws JSONException
     */
    public String setRoadLightControMode(String reques) throws JSONException {
        JSONObject jsonObject=new JSONObject(reques);
        String contrelModel=jsonObject.getString(Cantast.KEY_CONTREL_MODE);
        this.contrelModel= Objects.equals(contrelModel, Cantast.CONTREL_MODE_AUTO);
        jsonObject=new JSONObject();
        jsonObject.put(Cantast.KEY_RESULT,Cantast.KEY_OK);
        return jsonObject.toString();
    }

    /**
     * 设置路灯状态
     *
     * @param request
     * @return
     * @throws JSONException
     */
    public String setRoadLightStatusAction(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject(request);
        int roadListhId = jsonObject.getInt(Cantast.KEY_ROAD_LIGHT_ID) - 1;
        boolean state = (Objects.equals(jsonObject.getString(Cantast.ROAD_SET_STATE), Cantast.ROAD_STATE_OPEN));
        RoadLightStatusInfo roadLightStatusInfo = list.get(roadListhId);
        roadLightStatusInfo.setStatu(state);
        jsonObject = new JSONObject();
        jsonObject.put(Cantast.KEY_RESULT, (!this.contrelModel?Cantast.KEY_OK:Cantast.KEY_FAILED));
        return jsonObject.toString();
    }

    private class RoadLightStatusInfo {
        private boolean statu = false;

        public void setStatu(boolean statu) {
            this.statu = statu;
        }

        public boolean isStatu() {
            return statu;
        }

    }
}
