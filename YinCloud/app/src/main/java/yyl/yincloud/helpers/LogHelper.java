package yyl.yincloud.helpers;

import com.orhanobut.logger.Logger;

/**
 * Created by yyl on 2017/3/25.
 */

public class LogHelper {

    public static void logD(String message) {
        Logger.d(message);
    }

    public static void logError(String message) {
        Logger.e(message);
    }

    public static void logInfo(String message) {
        Logger.i(message);
    }

    public static void logV(String message) {
        Logger.v(message);
    }

    public static void logW(String message) {
        Logger.w(message);
    }

    public static void logT(String message) {
        Logger.t(message);
    }
}
