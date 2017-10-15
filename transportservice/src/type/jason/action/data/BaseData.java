package type.jason.action.data;

import org.json.JSONException;

/**
 * Created by Admin on 2017/3/26.
 */
public abstract class BaseData {
    protected abstract void init();

    protected abstract void logic();

    protected abstract String getData(Object object) throws JSONException;

    public abstract int sleep();
}
