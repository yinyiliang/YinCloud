package yyl.yincloud.exception;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.SystemClock;

import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;

import yyl.yincloud.AppActivityManager;
import yyl.yincloud.activitys.MainActivity;
import yyl.yincloud.helpers.ClientUtils;
import yyl.yincloud.helpers.DateUtils;
import yyl.yincloud.publics.YinCloudValues;

/**
 * 异常处理类
 * 
 * @author wangxg
 * 
 */
public class ExceptionHandler implements UncaughtExceptionHandler {

	private static final String TAG = ExceptionHandler.class.getSimpleName();

	/** 本类实例 **/
	private static ExceptionHandler instance;

	/** 系统默认的UncaughtException处理类 */
	// private Thread.UncaughtExceptionHandler mDefaultHandler;

	/** 程序的Context对象 */
	private Context mContext;

	/** 私有化构造方法 **/
	private ExceptionHandler() {
	}

	/**
	 * 获取本类实例
	 * 
	 * @return
	 */
	public synchronized static ExceptionHandler getInstance() {
		if (instance == null) {
			instance = new ExceptionHandler();
		}
		return instance;
	}

	/**
	 * 初始化
	 */
	public void init(Context context) {
		mContext = context;
		// mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
	}

	/**
	 * 当UncaughtException发生时会转入该函数来处理
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (ex == null) {
			// 异常信息为null,直接关闭应用
			closeApplication(3000);
		} else {
			// 处理异常,收集异常信息
			handleException(ex);
		}
	}

	/**
	 * 异常处理
	 * 
	 * @param e
	 *            异常信息
	 */
	public void handleException(Throwable e) {
		showMessage("");
		Logger.t(TAG).e("<----------- Exception start --------->");
		e.printStackTrace();
		Throwable cause = e.getCause();
		if (cause != null) {
			cause.printStackTrace();
		}
		Logger.t(TAG).e("<----------- Exception end  --------->");

		//
		if (ClientUtils.existSDCard()) {
			// saveJsonToFile(e);
			saveToFile(e);
		}
		closeApplication(3000);
	}

	/**
	 * 异常处理
	 * 
	 * @param e
	 *            异常信息
	 */
	public void handleExceptionByMySelef(Throwable e) {
		showMessage("");
		Logger.t(TAG).e("<----------- Exception start --------->");
		e.printStackTrace();
		Throwable cause = e.getCause();
		if (cause != null) {
			cause.printStackTrace();
		}
		Logger.t(TAG).e("<----------- Exception end  --------->");

		//
		if (ClientUtils.existSDCard()) {
			// saveJsonToFile(e);
			saveToFile(e);
		}
 
	}
	/**
	 * 异常处理
	 * 
	 * @param e
	 *            异常信息
	 */
	public void handleExceptionByMySelef(String e) {
		showMessage("");
//		Log.e(TAG, "<----------- Exception start --------->");
//		e.printStackTrace();
//		Throwable cause = e.getCause();
//		if (cause != null) {
//			cause.printStackTrace();
//		}
//		Log.e(TAG, "<----------- Exception end  --------->");

		//
		if (ClientUtils.existSDCard()) {
			// saveJsonToFile(e);
			saveToFile(e);
		}
 
	}
	/**
	 * 按照json格式保存到文件中
	 * 
	 * @param e
	 */
	protected void saveJsonToFile(Throwable e) {

		try {
			JSONObject content = new JSONObject();
			// 系统
			content.put("os", "android");
			// 用户名
			// content.put("userCode", mUserName);
			// 信息
			content.put("msg", e.toString());
			// 1.处理类
			content.put("className", ExceptionHandler.class.getName());
			// 2.时间
			long time = System.currentTimeMillis();
			String date = DateUtils.DateToString(new Date(time),
					DateUtils.Y_M_D_H_M_S);
			content.put("date", date);
			// 3.设备imei号
			content.put("imei", ClientUtils.getIMEI(mContext));
			// 4.当前应用版本
			content.put("version", ClientUtils.getAppVersion(mContext));
			// 5.堆栈信息
			StringBuilder sb = new StringBuilder();
			StackTraceElement[] stackTrace = e.getStackTrace();
			for (int i = 0; i < stackTrace.length; i++) {
				String line = i + "-->" + stackTrace[i].toString()
						+ System.getProperty("line.separator");
				sb.append(line);
			}
			content.put("stack", sb.toString());

			// 6.CauseBy
			Throwable cause = e.getCause();
			if (cause != null) {
				StringBuilder sb1 = new StringBuilder();
				StackTraceElement[] trace1 = cause.getStackTrace();
				for (int j = 0; j < trace1.length; j++) {
					String line = j + "-->" + trace1[j].toString()
							+ System.getProperty("line.separator");
					sb1.append(line);
				}
				content.put("cause", sb1.toString());
			} else {
				content.put("cause", "");
			}

			// 7.保存到文件
			String fileName = DateUtils.DateToString(new Date(time),
					DateUtils.Y_M_D_H_M_Ss) + "_" + time + ".txt";

			String dirPath = YinCloudValues.LOG_PATH;
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File file = new File(dirPath, fileName);
			FileOutputStream fos = new FileOutputStream(file);

			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
					fos, "utf-8"));
			bufw.write(content.toString());
			bufw.flush();
			bufw.close();
			fos.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * 保存到文件中
	 * 
	 * @param e
	 * @return
	 */
    private void saveToFile(String e) {

		try {
			long time = System.currentTimeMillis();
			String version = "版本:-->" + ClientUtils.getAppVersion(mContext);
			String imei = "IMEI:-->" + ClientUtils.getIMEI(mContext);
			String msg = "原因:-->" + e.toString();
			String date = "时间:-->"
					+ DateUtils.DateToString(new Date(time),
							DateUtils.Y_M_D_H_M_S);
			String details = "StackTrace:-------开始------->";
			String fileName = DateUtils.DateToString(new Date(time),
					DateUtils.Y_M_D_H_M_S) + ".txt";

			String dirPath = YinCloudValues.LOG_PATH;
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File file = new File(dirPath, fileName);
			FileOutputStream fos = new FileOutputStream(file);

			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
					fos, "utf-8"));
			bufw.write(date);
			bufw.newLine();
			bufw.write(version);
			bufw.newLine();
			bufw.write(imei);
			bufw.newLine();
			bufw.write(msg);
			bufw.newLine();
			bufw.write(details);
			bufw.newLine();

//			StackTraceElement[] stackTrace = e.getStackTrace();
//			for (int i = 0; i < stackTrace.length; i++) {
//				String line = i + "-->" + stackTrace[i].toString();
//				bufw.write(line);
//				bufw.newLine();
//			}
//			// bufw.flush();
//
//			String causeInfo = "CauseBy:-------开始------->";
//			bufw.write(causeInfo);
//			bufw.newLine();

//			Throwable cause = e.getCause();
//			if (cause != null) {
//				StackTraceElement[] trace1 = cause.getStackTrace();
//				for (int j = 0; j < trace1.length; j++) {
//					String line = j + "-->" + trace1[j].toString();
//					bufw.write(line);
//					bufw.newLine();
//				}
//			} else {
//				bufw.write("无");
//				bufw.newLine();
//			}

			bufw.flush();
			bufw.close();
			fos.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * 保存到文件中
	 * 
	 * @param e
	 * @return
	 */
    private void saveToFile(Throwable e) {

		try {
			long time = System.currentTimeMillis();
			String version = "版本:-->" + ClientUtils.getAppVersion(mContext);
			String imei = "IMEI:-->" + ClientUtils.getIMEI(mContext);
			String msg = "原因:-->" + e.toString();
			String date = "时间:-->"
					+ DateUtils.DateToString(new Date(time),
							DateUtils.Y_M_D_H_M_S);
			String details = "StackTrace:-------开始------->";
			String fileName = DateUtils.DateToString(new Date(time),
					DateUtils.Y_M_D_H_M_S) + ".txt";

			String dirPath = YinCloudValues.LOG_PATH;
			File dir = new File(dirPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File file = new File(dirPath, fileName);
			FileOutputStream fos = new FileOutputStream(file);

			BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(
					fos, "utf-8"));
			bufw.write(date);
			bufw.newLine();
			bufw.write(version);
			bufw.newLine();
			bufw.write(imei);
			bufw.newLine();
			bufw.write(msg);
			bufw.newLine();
			bufw.write(details);
			bufw.newLine();

			StackTraceElement[] stackTrace = e.getStackTrace();
			for (int i = 0; i < stackTrace.length; i++) {
				String line = i + "-->" + stackTrace[i].toString();
				bufw.write(line);
				bufw.newLine();
			}
			// bufw.flush();

			String causeInfo = "CauseBy:-------开始------->";
			bufw.write(causeInfo);
			bufw.newLine();

			Throwable cause = e.getCause();
			if (cause != null) {
				StackTraceElement[] trace1 = cause.getStackTrace();
				for (int j = 0; j < trace1.length; j++) {
					String line = j + "-->" + trace1[j].toString();
					bufw.write(line);
					bufw.newLine();
				}
			} else {
				bufw.write("无");
				bufw.newLine();
			}

			bufw.flush();
			bufw.close();
			fos.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 显示提示消息
	 */
    private void showMessage(final String msg) {
		new Thread() {
			@Override
			public void run() {
				// Toast 显示需要出现在一个线程的消息队列中
				Looper.prepare();
				// Toast.makeText(mContext, "程序出错:" + msg, Toast.LENGTH_LONG)
				// .show();
				// Toast.makeText(mContext, "应用出错,即将重启.", Toast.LENGTH_LONG)
				// .show();
				Logger.e("应用出错,即将重启.");
				Looper.loop();
			}
		}.start();
	}

	/**
	 * 延时多久关闭应用
	 * 
	 * @param delayTime
	 */
    private void closeApplication(long delayTime) {
		// Sleep一会后结束程序
		SystemClock.sleep(delayTime);

		Intent intent = new Intent(mContext, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(intent);

		AppActivityManager.getInstance().appExit(mContext,false);
	}

}
