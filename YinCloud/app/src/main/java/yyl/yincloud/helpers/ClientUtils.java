package yyl.yincloud.helpers;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.AudioManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TypedValue;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取当前手机的部分信息
 */
public class ClientUtils {

	/**
	 * 判断当前服务是否还在工作
	 * 
	 * @param context
	 * @param serviceName
	 * @return
	 */
	public static boolean isMyServiceRunning(Context context, String serviceName) {
		ActivityManager manager = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager
				.getRunningServices(Integer.MAX_VALUE)) {
			if (serviceName.equals(service.service.getClassName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取当前应用程序的版本号
	 * 
	 * @return 版本号
	 */
	public static String getAppVersion(Context context) {
		// 获取手机的包管理者
		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo packInfo = pm.getPackageInfo(context.getPackageName(),
					0);
			return packInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 获取当前应用名称
	 * 
	 * @param context
	 * @return
	 */
	public static String getAppName(Context context) {
		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo packInfo = pm.getPackageInfo(context.getPackageName(),
					0);
			String appName = packInfo.applicationInfo.loadLabel(pm).toString();
			return appName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 获取imei号
	 * 
	 * @param context
	 * @return
	 */
	public static String getIMEI(Context context) {
		TelephonyManager mTelephonyMgr = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return mTelephonyMgr.getDeviceId();
	}

	/**
	 * 获取电话号(有可能为空)
	 * 
	 * @param context
	 * @return
	 */
	public static String getPhone(Context context) {
		TelephonyManager mTelephonyMgr = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String num = mTelephonyMgr.getLine1Number();

		if (TextUtils.isEmpty(num)) {
			return "";
		} else {
			return num;
		}
	}

	/**
	 * 获取手机制造商
	 * 
	 * @return
	 */
	public static String getManufacturers() {
		return Build.MANUFACTURER;
	}

	/**
	 * 获取手机品牌
	 *
	 * @return
	 */
	public static String getBrand() {
		return Build.BRAND;
	}

	/**
	 * 获取手机型号
	 *
	 * @return
	 */
	public static String getModel() {
		return Build.MODEL;
	}

	/**
	 * 获取手机操作系统
	 *
	 * @return
	 */
	public static String getOs() {
		return "Android " + Build.VERSION.INCREMENTAL;
	}

	/**
	 * 获取操作系统版本
	 *
	 * @return
	 */
	public static String getOsVersion() {
		return Build.VERSION.RELEASE;
	}

	/**
	 * 获得屏幕分辨率x(宽)
	 * 
	 * @return
	 */
	public static int getScreenX(Context context) {
		return context.getResources().getDisplayMetrics().widthPixels;
	}

	/**
	 * 获得屏幕分辨率y(高)
	 * 
	 * @return
	 */
	public static int getScreenY(Context context) {
		return context.getResources().getDisplayMetrics().heightPixels;
	}

	/**
	 * 是否有蓝牙
	 * 
	 * @return
	 */
	public static boolean getBluetooth() {
		BluetoothAdapter bluetoothadapter = BluetoothAdapter
				.getDefaultAdapter();
		if (bluetoothadapter == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断某文件是否存在
	 * 
	 * @param fileString
	 *            "/storage/sdcard0/Manual/test.pdf"
	 * @return
	 */

	public static boolean fileIsExists(String fileString) {
		try {
			File f = new File(fileString);
			if (!f.exists()) {
				return false;
			}

			FileInputStream fis = new FileInputStream(f);
			int fileLen = fis.available();
			if (fileLen == 0) {
				f.delete();
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	/**
	 * 是否用听筒播放
	 * 
	 * @return isfromcall
	 */
	public static void setisFromCall(Context context, boolean isfromcall) {

		AudioManager audioManager = (AudioManager) context
				.getSystemService(Context.AUDIO_SERVICE);
		if (isfromcall) {
			audioManager.setSpeakerphoneOn(false);// 关闭扬声器
			audioManager.setRouting(AudioManager.MODE_NORMAL,
					AudioManager.ROUTE_EARPIECE, AudioManager.ROUTE_ALL);
			// setVolumeControlStream(AudioManager.STREAM_VOICE_CALL);
			// 把声音设定成Earpiece（听筒）出来，设定为正在通话中
			audioManager.setMode(AudioManager.MODE_IN_CALL);
			return;
		}
		audioManager.setSpeakerphoneOn(true);

	}

	/**
	 * 正则匹配
	 * 
	 * @param patternCoder
	 *            正则code
	 * @param patternContent
	 *            要匹配的string
	 * @return
	 */
	public static boolean patternCode(String patternCoder, String patternContent) {
		if (TextUtils.isEmpty(patternContent)) {
			return false;
		}
		Pattern p = Pattern.compile(patternCoder);
		Matcher matcher = p.matcher(patternContent);
		if (matcher.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 修改文件名字 （相同路径）
	 * 
	 * @param FromNamePath
	 *            要修改的文件路径（路径+文件名）
	 * @param tofileName
	 *            修改目的的的文件名(不要路径)
	 */
	public static void ChangeFileName(String FromNamePath, String tofileName) {
		File file = new File(FromNamePath);
		if (fileIsExists(FromNamePath)) {
			String parentPaht = file.getParent();
			file.renameTo(new File(parentPaht, tofileName));
		}

	}
	
	// 获取手机状态栏高度  
	public static int getStatusBarHeight(Context context) {  
	    Class<?> c = null;  
	    Object obj = null;  
	    Field field = null;  
	    int x = 0, statusBarHeight = 0;  
	    try {  
	        c = Class.forName("com.android.internal.R$dimen");  
	        obj = c.newInstance();  
	        field = c.getField("status_bar_height");  
	        x = Integer.parseInt(field.get(obj).toString());  
	        statusBarHeight = context.getResources().getDimensionPixelSize(x);  
	    } catch (Exception e1) {  
	        e1.printStackTrace();  
	    }  
	    return statusBarHeight;  
	}  
	  
	// 获取ActionBar的高度  
	public static int getActionBarHeight(Context context) {  
	    TypedValue tv = new TypedValue();  
	    int actionBarHeight = 0;  
	    if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))// 如果资源是存在的、有效的  
	    {  
	        actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());  
	    }  
	    return actionBarHeight;  
	}

    /**
     * sd卡是否可用
     *
     * @return
     */
    public static boolean existSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment
                .MEDIA_MOUNTED);
    }
	
}
