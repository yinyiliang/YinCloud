package yyl.yincloud.base;

import android.app.Application;
import android.content.Context;

import com.aitangba.swipeback.ActivityLifecycleHelper;
import com.jackie.greendao.DaoMaster;
import com.jackie.greendao.DaoSession;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.database.Database;

import yyl.yincloud.BuildConfig;
import yyl.yincloud.exception.ExceptionHandler;

/**
 * Created by yyl on 2017/3/9.
 */

public class BaseApplication extends Application {

    public static Context mContext;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());
        mContext = getApplicationContext();

        // 全局异常处理
        ExceptionHandler.getInstance().init(mContext);

        if (BuildConfig.DEBUG) {
            Logger.init("YIN").methodCount(3).hideThreadInfo();
        } else {
            Logger.init("YIN").logLevel(LogLevel.NONE);
        }

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "city-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
