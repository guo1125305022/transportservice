package type.jason.action.data;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/3/26.
 */
public class AllData extends Thread {

    private static AllData allData;//所有数据
    private ArrayList<BaseData> list=new ArrayList<>();//数据集合
    private static final long sleep=2*1000;
    private CarData carData;
    private ParkSystemData parkSystemData;
    private SensorSystemData sensorSystemData;
    private TrafficLightSystem trafficLightSystem;
    private DistanceSystemData distanceSystemData;
    private RoadStatusSystemData roadStatusSystemData;
    private RoadLightStatusSystem roadLightStatusSystem;
    private boolean run=true;

    public ArrayList<BaseData> getList() {
        return list;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public static AllData getAllData(){
        if(allData==null){
            allData=new AllData();
            System.out.println("数据线程启动");
        }
        return  allData;
    }
    private AllData(){
        init();
        this.start();
    }

    public CarData getCarData() {
        return carData;
    }

    public ParkSystemData getParkSystemData() {
        return parkSystemData;
    }

    public SensorSystemData getSensorSystemData() {
        return sensorSystemData;
    }

    public TrafficLightSystem getTrafficLightSystem() {
        return trafficLightSystem;
    }

    public DistanceSystemData getDistanceSystemData() {
        return distanceSystemData;
    }

    public RoadStatusSystemData getRoadStatusSystemData() {
        return roadStatusSystemData;
    }

    public RoadLightStatusSystem getRoadLightStatusSystem() {
        return roadLightStatusSystem;
    }

    private void init() {
        carData =new CarData();
        parkSystemData=new ParkSystemData();
        sensorSystemData=new SensorSystemData();
        trafficLightSystem=new TrafficLightSystem();
        distanceSystemData=new DistanceSystemData();
        roadStatusSystemData=new RoadStatusSystemData();
        roadLightStatusSystem=new RoadLightStatusSystem();
        list.add(carData);//小车相关数据
        list.add(parkSystemData);//停车场相关数据
        list.add(sensorSystemData);//传感器相关数据
        list.add(trafficLightSystem);//红绿灯系统相关数据
        list.add( distanceSystemData);//公交信息系统数据
        list.add(roadStatusSystemData);//道路系统数据
        list.add(roadLightStatusSystem);//路灯系统数据
        for (BaseData data:list) {
            data.init();
        }

    }

    @Override
    public void run() {
        System.out.println("数据线程启动");
        long time;
        while (run){
            time=System.currentTimeMillis();
            for (BaseData data:list) {
                data.logic();
            }
            time=System.currentTimeMillis()-time;
            if(time<sleep){
                try {
                    sleep(sleep-time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        super.run();
    }
}
