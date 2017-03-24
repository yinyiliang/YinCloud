package yyl.yincloud.base;

import android.app.Application;
import android.content.Context;

import com.aitangba.swipeback.ActivityLifecycleHelper;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import yyl.yincloud.BuildConfig;
import yyl.yincloud.exception.ExceptionHandler;

/**
 * Created by yyl on 2017/3/9.
 */

public class BaseApplication extends Application {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());
        this.mContext = this;

        // 全局异常处理
        ExceptionHandler.getInstance().init(mContext);

        if (BuildConfig.DEBUG) {
            Logger.init("YIN").methodCount(3).hideThreadInfo();
        } else {
            Logger.init("YIN").logLevel(LogLevel.NONE);
        }
    }

    public Context getContext() {
        return mContext;
    }
}
