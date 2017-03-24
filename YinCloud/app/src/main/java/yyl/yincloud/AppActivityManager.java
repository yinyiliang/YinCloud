package yyl.yincloud;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * App的Activity管理类
 * 
 */
public class AppActivityManager {

	private static Map<String, Activity> activityMap;

	private static Stack<Activity> activityStack;

	private static AppActivityManager mInstance;

	private AppActivityManager() {
	}

	public synchronized static AppActivityManager getInstance() {
		if (mInstance == null) {
			mInstance = new AppActivityManager();
		}
		return mInstance;
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (activityMap == null) {
			activityMap = new HashMap<String, Activity>();
		}
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		if (activityMap.containsKey(activity.getClass().getName())) {
			Activity oldActivity = activityMap.get(activity.getClass()
					.getName());
			if (oldActivity == activity) {
				activityStack.remove(activity);
			} else {
				// 结束掉以前的
				finishActivity(oldActivity);
			}
		}
		activityMap.put(activity.getClass().getName(), activity);
		activityStack.add(activity);
	}

	public Activity getCurrActivity() {
		return activityStack.lastElement();
	}

	public Activity getActivity(String key) {
		return activityMap.get(key);
	}

	public boolean containsActivity(String key) {
		return activityMap.get(key) != null;
	}

	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishActivity(Activity activity) {
		activityStack.remove(activity);
		activityMap.remove(activity.getClass().getName());
		activity.finish();
		activity = null;
	}

	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishActivity(String key) {
		Activity activity = getActivity(key);
		activityStack.remove(activity);
		activityMap.remove(activity.getClass().getName());
		activity.finish();
		activity = null;
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity() {
		for (String key : activityMap.keySet()) {
			if (null != activityMap.get(key)) {
				activityMap.get(key).finish();
			}
		}
		activityMap.clear();
		activityStack.clear();
	}

	/**
	 * 退出应用程序
	 */
	public void appExit(Context context, boolean isclearAccount) {
		try {

			finishAllActivity();
			// 销毁所有服务
//			stopService(context);

			ActivityManager activityMgr = (ActivityManager) context
					.getSystemService(Context.ACTIVITY_SERVICE);
			activityMgr.killBackgroundProcesses(context.getPackageName());
			int nPid = android.os.Process.myPid();
			android.os.Process.killProcess(nPid);
			System.exit(0);
		} catch (Exception e) {
		}
	}

	/**
	 * 退出应用程序重新登录
	 */
//	public void appExitGoLogin(Context context) {
//		try {
//			Intent intent = new Intent(context, LoginActivity.class);
//			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
//					| Intent.FLAG_ACTIVITY_NEW_TASK);
//			intent.putExtra("isFrom", "reLogin");
//			context.startActivity(intent);
//			// 销毁所有服务
//			stopService(context);
//		} catch (Exception e) {
//            e.printStackTrace();
//		}
//	}

	/**
	 * 
	 * 销毁服务.
	 * 
	 * @author shimiso
	 * @update 2012-5-16 下午12:16:08
	 */
//	protected void stopService(Context context) {
//        PinStaticValue.STOPPING_SERVICE = true;
//		// 聊天服务
//		Intent chatServer = new Intent(context, IMChatService.class);
//		context.stopService(chatServer);
//
//		// 自动恢复连接服务
//		Intent reConnectService = new Intent(context, ReConnectService.class);
//		context.stopService(reConnectService);
//
//		Intent mReLoginService = new Intent(context, ReLoginService.class);
//		context.stopService(mReLoginService);
//	}

}
