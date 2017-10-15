package type.jason.action.data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;

import java.util.ArrayList;
import java.util.Random;

import static type.jason.action.Cantast.RATE_TYPE_COUNT;
import static type.jason.action.Cantast.RATE_TYPE_HOUR;

/**
 * Created by Admin on 2017/3/26.
 */
public class ParkSystemData extends BaseData {
    private ParkMoneyInfo parkMoneyInfo = new ParkMoneyInfo();
    private ArrayList<ParkLoactionInfo> parkLoactionInfos=new ArrayList<>();
    private Random random=null;
    @Override
    protected void init() {
        parkMoneyInfo.setRateType(Cantast.KEY_RATE_TYPE);
        parkLoactionInfos.add(new ParkLoactionInfo());
        parkLoactionInfos.add(new ParkLoactionInfo());
        random=new Random();
    }

    @Override
    protected void logic() {
        //更新停车场停车位置信息
        for (ParkLoactionInfo info:parkLoactionInfos){
            info.setLocationType((random.nextInt(2)==0?ParkLoactionInfo.LOACTION:ParkLoactionInfo.LOACTION_FREE));
//            (random.nextInt(2)==0?ParkLoactionInfo.LOACTION:ParkLoactionInfo.LOACTION_FREE)
//                    （1==1？1:1）
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


    public String getParkRate(String request) throws JSONException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(Cantast.KEY_RATE_TYPE,parkMoneyInfo.getRateType());//获取停车收费类型
        jsonObject.put(Cantast.KEY_MONEY,parkMoneyInfo.getMoney());//获取停车费用
        return  jsonObject.toString();
    }

    public  String setParkRate(String requestData) throws JSONException {
        JSONObject jsonObject=new JSONObject(requestData);
        int money=jsonObject.getInt(Cantast.KEY_MONEY);
        String rate=jsonObject.getString(Cantast.KEY_RATE_TYPE);
        if(!rate.equals(RATE_TYPE_COUNT)&&!rate.equals(RATE_TYPE_HOUR)){
            jsonObject=new JSONObject();
            jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_FAILED);
            return jsonObject.toString();
        }
        parkMoneyInfo.setRateType(rate);
        parkMoneyInfo.setMoney(money);
        jsonObject=new JSONObject();
        jsonObject.put(Cantast.KEY_RESULT, Cantast.KEY_OK);
        return  jsonObject.toString();
    }

    /**
     * 获取停车场停车位id
     * @return
     * @throws JSONException
     */
    public String getParkLoaction(String request) throws JSONException {
        JSONArray jsonArray=new JSONArray();
        int index=0;

        for (ParkLoactionInfo info:parkLoactionInfos){
            if(info.getLocationType()==ParkLoactionInfo.LOACTION_FREE){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put(Cantast.KEY_PARK_FREE_ID,index+1);
                jsonArray.put(jsonObject);
            }
            index++;
        }
        return  jsonArray.toString();
    }

    private class ParkLoactionInfo {
        public static final int LOACTION_FREE = 0x22;
        public static final int LOACTION = 0xff;
        private int locationType = LOACTION_FREE;

        public void setLocationType(int locationType) {
            this.locationType = locationType;
        }
        public int getLocationType() {
            return locationType;
        }
    }

    private class ParkMoneyInfo {
        private int money;

        private String rateType=RATE_TYPE_COUNT;

        public void setMoney(int money) {
            this.money = money;
        }

        public void setRateType(String rateType) {
            this.rateType = rateType;
        }

        public int getMoney() {
            return money;
        }

        public String getRateType() {
            return rateType;
        }
    }
}
