package yyl.yincloud.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.aitangba.swipeback.SwipeBackActivity;
import com.google.gson.Gson;

import yyl.yincloud.AppActivityManager;
import yyl.yincloud.http.HttpOnNextListener;

/**
 * Created by yyl on 2017/3/9.
 */

public abstract class BaseActivity extends SwipeBackActivity implements HttpOnNextListener {

    protected Gson mGson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppActivityManager.getInstance().addActivity(this);
        mGson = new Gson();
    }

    /**
     * 关闭当前页面
     */
    protected void finishThis() {
        AppActivityManager.getInstance().finishActivity(this);
    }
}
