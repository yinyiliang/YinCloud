package yyl.yincloud.helpers;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 日期工具类
 * 
 * @author ShengWu
 * 
 */
@SuppressLint("SimpleDateFormat")
public class DateUtils {
	public static final String Y = "yyyy";
	public static final String M = "MM";
	public static final String D = "dd";
	public static final String Y_Ms = "yyyy-MM";
	public static final String Y_M = "yyyy 年 MM 月";
	public static final String Y_M_D = "yyyy-MM-dd";
	public static final String YMD = "yyyyMMdd";
	public static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";
	public static final String Y_M_D_H_M_Ss = "yyyy年MM月dd日HH时mm分ss秒";
	public static final String Y_M_D_H_M = "yyyy-MM-dd HH:mm";
	public static final String M_D_H_M_S = "MM-dd HH:mm:ss";
	public static final String H_M_S = "HH:mm:ss";
	public static final String H_M = "HH:mm";
	public static final String Y_M_Ds = "yyyy年MM月dd日";
	public static final String M_Ds = "MM月dd日";
	public static final String M_D = "MM-dd";
	public static final String H_Ms = "HH时mm分";
	public static final String Y_M_D_H_Ms = "yyyy年MM月dd日HH时mm分";
	public static final String Y_M_D_H_Mss = "yyyy年MM月dd日HH:mm";
	public static final String YMDHMMS = "yyyyMMddHHmmss";
	public static final String YMDHMMSSSS = "yyyyMMddHHmmssSSS";

	/**
	 * 通过缩写月份英文查找月份数字
	 * 
	 * @param mothEng
	 * @return
	 */
	public static String getmonthBymap(String mothEng) {

		// 一月：Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec
		Map<String, String> mMap = new HashMap<String, String>();
		mMap.put("Jan", "01");
		mMap.put("Feb", "02");
		mMap.put("Mar", "03");
		mMap.put("Apr", "04");
		mMap.put("May", "05");
		mMap.put("Jun", "06");
		mMap.put("Jul", "07");
		mMap.put("Aug", "08");
		mMap.put("Sep", "09");
		mMap.put("Oct", "10");
		mMap.put("Nov", "11");
		mMap.put("Dec", "12");
		Set<String> keys = mMap.keySet();
		for (String key : keys) {
			if (key.equals(mothEng)) {
				return mMap.get(key);
			}
		}
		return null;
	}

	/**
	 * 通过月份数字查找缩写月份英文
	 * 
	 * @param map
	 * @return
	 */
	public static String getmapBymonth(String map) {

		// 一月：Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec
		Map<String, String> mMap = new HashMap<String, String>();
		mMap.put("01", "Jan");
		mMap.put("02", "Feb");
		mMap.put("03", "Mar");
		mMap.put("04", "Apr");
		mMap.put("05", "May");
		mMap.put("06", "Jun");
		mMap.put("07", "Jul");
		mMap.put("08", "Aug");
		mMap.put("09", "Sep");
		mMap.put("10", "Oct");
		mMap.put("11", "Nov");
		mMap.put("12", "Dec");
		Set<String> keys = mMap.keySet();
		for (String key : keys) {
			if (key.equals(map)) {
				return mMap.get(key);
			}
		}
		return null;
	}

	/**
	 * 修改正确的当前月份
	 * 
	 * @param x
	 * @return
	 */
	public static String format(int x) {
		Log.i("5", "5");
		if (x < 10) {
			x = x + 1;
			if (Integer.toString(x).length() == 1) {
				return "0" + Integer.toString(x);
			} else {
				return Integer.toString(x);
			}
		}
		if (x == 10) {
			return 11 + "";
		}

		if (x == 11) {
			return 12 + "";
		}
		if (x == 12) {
			return 0 + "1";
		}
		return x + "";
	}

	/**
	 * 通过date获取星座
	 * 
	 * @param month
	 * @return
	 */
	public static String getAstro(int month, int day) {
		String[] astro = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座",
				"双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
		int[] arr = new int[] { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };// 两个星座分割日
		int index = month;
		// 所查询日期在分割日之前，索引-1，否则不变
		if (day < arr[month - 1]) {
			index = index - 1;
		}
		// 返回索引指向的星座string
		return astro[index];
	}


	/**
	 * 获取 比如 1月 则01 2月则02 12月则12
	 * 
	 * @param date
	 * @return
	 */
	public static String getgoodDay(int date) {
		String dateS = date + "";
		if (dateS.length() == 1) {
			dateS = "0" + date;
		}
		return dateS;

	}

	/**
	 * 移走前面多余的0
	 * 
	 * @param str
	 * @return
	 */
	public static String removeZero(String str) {
		String newStr = str.replaceAll("^(0+)", "");
		return newStr;
	}

	/**
	 * 如果是当天 则只返回时分 如果是昨天则返回昨天 前天 返回当天的日期
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @param time
	 *            HH:mm:ss
	 * @return
	 */
	public static String getgoodTime(String date, String time) {
		String currentDay = getCurDateStr("yyyy-MM-dd");
		if (currentDay.equals(date)) {
			return time;
		}
		if (getTwoDay(currentDay, date) == 1) {

			return "昨天";
		}

		return date;

	}

	/**
	 * 获取当前格式时间 某个格式 to String如 yyyy
	 * 
	 * @param format
	 * @return String
	 */
	public static String getCurDateStr(String format) {
		Calendar c = Calendar.getInstance();
		return date2Str(c, format);
	}

	public static String date2Str(Calendar c, String format) {
		if (c == null) {
			return null;
		}
		return date2Str(c.getTime(), format);
	}

	public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
		if (d == null) {
			return null;
		}
		if (format == null || format.length() == 0) {
			format = Y_M_D_H_M_S;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String s = sdf.format(d);
		return s;
	}

	public static Date str2Date(String str, String format) {
		if (str == null || str.length() == 0) {
			return null;
		}
		if (format == null || format.length() == 0) {
			format = Y_M_D_H_M_S;
		}
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;

	}

	/**
	 * 以友好的方式显示时间 中文
	 * 
	 * @param sdate
	 * @return
	 */
	public static String friendly_time(String sdate) {
		Date time = StringToDate(sdate, "yyyy-MM-dd HH:mm:ss");
		if (time == null) {
			return "Unknown";
		}
		String ftime = "";
		Calendar cal = Calendar.getInstance();

		// 判断是否是同一天
		String curDate = dateFormater2.get().format(cal.getTime());
		String paramDate = dateFormater2.get().format(time);
		if (curDate.equals(paramDate)) {
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0) {
				ftime = Math.max(
						(cal.getTimeInMillis() - time.getTime()) / 60000, 1)
						+ "分钟前";
			}else {
				ftime = hour + "小时前";
			}
			return ftime;
		}

		long lt = time.getTime() / 86400000;
		long ct = cal.getTimeInMillis() / 86400000;
		int days = (int) (ct - lt);
		if (days == 0) {
			int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
			if (hour == 0)
				ftime = Math.max(
						(cal.getTimeInMillis() - time.getTime()) / 60000, 1)
						+ "分钟前";
			else
				ftime = hour + "小时前";
		} else if (days == 1) {
			ftime = "昨天";
		} else if (days == 2) {
			ftime = "前天";
		} else if (days > 2 && days <= 10) {
			ftime = days + "天前";
		} else if (days > 10) {
			ftime = dateFormater3.get().format(time);
		}
		return ftime;
	}

    /**
     * 以友好的方式显示时间 英文
     *
     * @param sdate
     * @return
     */
    public static String friendly_time_en(String sdate) {
        Date time = StringToDate(sdate, "yyyy-MM-dd HH:mm:ss");
        if (time == null) {
            return "Unknown";
        }
        String ftime = "";
        Calendar cal = Calendar.getInstance();

        // 判断是否是同一天
        String curDate = dateFormater2.get().format(cal.getTime());
        String paramDate = dateFormater2.get().format(time);
        if (curDate.equals(paramDate)) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0) {
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "min ago";
            }else {
                ftime = hour + "h ago";
            }
            return ftime;
        }

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        if (days == 0) {
            int hour = (int) ((cal.getTimeInMillis() - time.getTime()) / 3600000);
            if (hour == 0)
                ftime = Math.max(
                        (cal.getTimeInMillis() - time.getTime()) / 60000, 1)
                        + "min ago";
            else
                ftime = hour + "h ago";
        } else if (days == 1) {
            ftime = "yesterday";
        } else if (days == 2) {
            ftime = "DBY";
        } else if (days > 2 && days <= 10) {
            ftime = days + "days ago";
        } else if (days > 10) {
            ftime = dateFormater3.get().format(time);
        }
        return ftime;
    }

	/**
	 * 以友好的方式显示时间（第几天。。。。。9999+天）
	 * 
	 * @param sdate
	 * @return
	 */
	public static String getFriendDay(String sdate, String sdate2) {
		String[] dayString = new String[] { "第一天", "第二天", "第三天", "第四天", "第五天",
				"第六天", "第七天", "第八天", "第九天", "第十天" };
		int twoday = getTwoDay(sdate, sdate2);
		if (twoday < 10 && twoday >= 0) {
			return dayString[twoday];
		} else if (twoday >= 10 && twoday < 9999) {
			return (twoday + 1) + "天";
		} else if (twoday > 9999) {
			return "9999+天";
		}
		// 再转换为时间
		Date date = StringToDate(sdate, Y_M_D);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	/**
	 * 将字符串转位日期类型
	 * 
	 * @param sdate
	 * @return
	 */
	public static Date toDate(String sdate) {
		try {
			return dateFormater.get().parse(sdate);
		} catch (ParseException e) {
			return null;
		}
	}

	private final static ThreadLocal<SimpleDateFormat> dateFormater = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			// TODO 中间有个T
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	private final static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};
	private final static ThreadLocal<SimpleDateFormat> dateFormater3 = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("MM-dd");
		}
	};

	/**
	 * 得到二个日期间的间隔天数
	 */
	public static int getTwoDay(String sj1, String sj2) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		int day = 0;
		try {
			Date date = myFormatter.parse(sj1);
			Date mydate = myFormatter.parse(sj2);
			day = (int) ((date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000));
		} catch (Exception e) {
			return 0;
		}
		return day;
	}

	/**
	 * 得到二个日期间的间隔天数 得到间隔n天后的日期"yyyy-MM-dd"
	 */
	public static String getwillDay(String date, int n) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(StringToDate(date, Y_M_D));
		cal.add(Calendar.DAY_OF_MONTH, n); // 第2天，第x天，照加。如果是负数，表示前n天。

		Date willday = cal.getTime();
		return DateToString(willday, Y_M_D);
	}

	/**
	 * 
	 * @param date
	 *            string类型的日期 例如:1970-01-01 23:23:23
	 * @param format
	 *            传入类型的格式 例如:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String DateToString(Date date, String format) {
		if (date == null) {
			return null;
		} else if (TextUtils.isEmpty(format)) {
			return new SimpleDateFormat(Y_M_D_H_M_S).format(date);
		} else {
			return new SimpleDateFormat(format).format(date);
		}
	}

	/**
	 * 
	 * @param date
	 *            string类型的日期 例如:1970-01-01 23:23:23
	 * @param format
	 *            传入类型的格式 例如:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date StringToDate(String date, String format) {
		try {
			if (TextUtils.isEmpty(date)) {
				return null;
			} else if (TextUtils.isEmpty(format)) {
				return new SimpleDateFormat(Y_M_D_H_M_S).parse(date);
			} else {
				return new SimpleDateFormat(format).parse(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get one date type in a fixed format.
	 * 
	 * @param pattern
	 * @return
	 */
	public static DateFormat getCnDateFormat(String pattern) {
		return new SimpleDateFormat(pattern);
	}

	/**
	 * 是否是今天
	 * 
	 * @return true是 false不是
	 */
	public static boolean isToday(String mills) {
		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		curCalendar.add(Calendar.DATE, 0);

		int year = curCalendar.get(Calendar.YEAR);
		int month = curCalendar.get(Calendar.MONTH);
		int day = curCalendar.get(Calendar.DAY_OF_MONTH);

		// 把时间移动到当天的00:00
		curCalendar.set(year, month, day, 0, 0, 0);

		// 得到00:00的毫秒值
		long curMills = curCalendar.getTimeInMillis();

		// 比较二个毫秒值
		long time = Long.parseLong(mills);

		// 如果传进来的时间，比当天的00:00的毫秒值要小
		if (time < curMills) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 拿到今天偏移后的某天的00:00的毫秒值
	 * 
	 * @param value
	 *            0代表当前 -1往前一天
	 * @return
	 */
	public static long getTimeInMillisForStart(int value) {

		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		// 移动时间
		curCalendar.add(Calendar.DATE, value);

		int year = curCalendar.get(Calendar.YEAR);
		int month = curCalendar.get(Calendar.MONTH);
		int day = curCalendar.get(Calendar.DAY_OF_MONTH);

		// 把时间移动到当天的00:00
		curCalendar.set(year, month, day, 0, 0, 0);

		// 得到00:00的毫秒值
		long curMills = curCalendar.getTimeInMillis();

		return curMills;
	}

	/**
	 * 拿到今天偏移后的某天的日期
	 * 
	 * @param value
	 *            0代表当前 -1往前一天
	 * @return 格式yyyyMMdd
	 */
	public static String getOffsetsDay(int value, String format) {

		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		// 移动时间
		curCalendar.add(Calendar.DATE, value);

		int year = curCalendar.get(Calendar.YEAR);
		int month = curCalendar.get(Calendar.MONTH);
		int day = curCalendar.get(Calendar.DAY_OF_MONTH);

		// 把时间移动到当天的00:00
		curCalendar.set(year, month, day, 0, 0, 0);

		// 得到00:00的毫秒值
		long curMills = curCalendar.getTimeInMillis();

		return getDay(curMills, format);
	}

	/**
	 * 拿到今天偏移后的某天的日期
	 * 
	 * @param value
	 *            0代表当前 -1往前一天
	 * @return 格式yyyy-MM-dd
	 */
	public static String getOffsetsDay2(int value) {

		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		// 移动时间
		curCalendar.add(Calendar.DATE, value);

		int year = curCalendar.get(Calendar.YEAR);
		int month = curCalendar.get(Calendar.MONTH);
		int day = curCalendar.get(Calendar.DAY_OF_MONTH);

		// 把时间移动到当天的00:00
		curCalendar.set(year, month, day, 0, 0, 0);

		// 得到00:00的毫秒值
		long curMills = curCalendar.getTimeInMillis();

		return getDay2(curMills);
	}

	/**
	 * 
	 * @param time
	 * @return yyyy-MM-dd
	 */
	private static String getDay2(long time) {

		return new SimpleDateFormat("yyyy-MM-dd").format(time);

	}

	private static String getDay(long time, String format) {

		return new SimpleDateFormat(format).format(time);

	}

	/**
	 * 拿到今天偏移后的某天的23:59的毫秒值
	 * 
	 * @param value
	 *            0代表当前 -1往前一天
	 * @return
	 */
	public static long getTimeInMillisForEnd(int value) {

		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		// 移动时间
		curCalendar.add(Calendar.DATE, value);

		int year = curCalendar.get(Calendar.YEAR);
		int month = curCalendar.get(Calendar.MONTH);
		int day = curCalendar.get(Calendar.DAY_OF_MONTH);

		// 把时间移动到当天的00:00
		curCalendar.set(year, month, day, 23, 59, 59);

		// 得到00:00的毫秒值
		long curMills = curCalendar.getTimeInMillis();

		return curMills;
	}

	public static String getTimeFomat(String year, String month, String day,
			String hour, String minute, String format) {
		Calendar curCalendar = Calendar.getInstance();
		int year_ = 0;
		if (TextUtils.isEmpty(year)) {
			year_ = curCalendar.get(Calendar.YEAR);
		} else {
			year_ = Integer.parseInt(year);
		}
		int month_ = 0;
		if (TextUtils.isEmpty(month)) {
			month_ = curCalendar.get(Calendar.MONTH);
		} else {
			month_ = Integer.parseInt(month);
		}
		int day_ = 0;
		if (TextUtils.isEmpty(day)) {
			day_ = curCalendar.get(Calendar.DAY_OF_MONTH);
		} else {
			day_ = Integer.parseInt(day);
		}
		int hour_ = 0;
		if ("0".equals(hour)) {
			hour_ = 0;
		} else {
			hour_ = Integer.parseInt(hour);
		}
		int minute_ = 0;
		if ("0".equals(minute)) {
			minute_ = 0;
		} else {
			minute_ = Integer.parseInt(minute);
		}
		int second = curCalendar.get(Calendar.SECOND);
		curCalendar.set(year_, month_, day_, hour_, minute_, second);

		return DateToString(new Date(curCalendar.getTimeInMillis()), format);

	}

	/**
	 * 返回今天是星期
	 *
	 * @return
	 * @throws Exception
	 */
	public static String dayForWeek(String str) {
		Calendar c = Calendar.getInstance();
		c.setTime(toDate(str));
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}

        String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期天"};


		return weekDays[dayForWeek-1];
	}

	/**
	 * 拿到某天的00:00的毫秒值
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static long getTimeInMillisForStart(Date date) {

		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		// 移动时间
		curCalendar.setTime(date);

		int year = curCalendar.get(Calendar.YEAR);
		int month = curCalendar.get(Calendar.MONTH);
		int day = curCalendar.get(Calendar.DAY_OF_MONTH);

		// 把时间移动到当天的00:00
		curCalendar.set(year, month, day, 0, 0, 0);

		// 得到00:00的毫秒值
		long curMills = curCalendar.getTimeInMillis();

		return curMills;
	}

	/**
	 * 拿到某天的23:59的毫秒值
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static long getTimeInMillisForEnd(Date date) {

		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		// 移动时间
		curCalendar.setTime(date);

		int year = curCalendar.get(Calendar.YEAR);
		int month = curCalendar.get(Calendar.MONTH);
		int day = curCalendar.get(Calendar.DAY_OF_MONTH);

		// 把时间移动到当天的00:00
		curCalendar.set(year, month, day, 23, 59, 59);

		// 得到00:00的毫秒值
		long curMills = curCalendar.getTimeInMillis();

		return curMills;
	}

	public static Calendar StringtoCalendar(String str) {
		Date mdate = StringToDate(str, Y_M_D);
		// 当前时间
		Calendar curCalendar = Calendar.getInstance();

		// 移动时间
		curCalendar.setTime(mdate);

		return curCalendar;
	}

	/**
	 * 判断两个日期间的 年月日 之差
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int[] getNeturalAge(String date1, String date2) {
		Calendar calendarBirth = StringtoCalendar(date1);
		Calendar calendarNow = StringtoCalendar(date2);

		int diffYears = 0, diffMonths, diffDays;
		int dayOfBirth = calendarBirth.get(Calendar.DAY_OF_MONTH);
		int dayOfNow = calendarNow.get(Calendar.DAY_OF_MONTH);
		if (dayOfBirth <= dayOfNow) {
			diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
			diffDays = dayOfNow - dayOfBirth;
			if (diffMonths == 0)
				diffDays++;
		} else {
			if (isEndOfMonth(calendarBirth)) {
				if (isEndOfMonth(calendarNow)) {
					diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
					diffDays = 0;
				} else {
					calendarNow.add(Calendar.MONTH, -1);
					diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
					diffDays = dayOfNow + 1;
				}
			} else {
				if (isEndOfMonth(calendarNow)) {
					diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
					diffDays = 0;
				} else {
					calendarNow.add(Calendar.MONTH, -1);// 上个月
					diffMonths = getMonthsOfAge(calendarBirth, calendarNow);
					// 获取上个月最大的一天
					int maxDayOfLastMonth = calendarNow
							.getActualMaximum(Calendar.DAY_OF_MONTH);
					if (maxDayOfLastMonth > dayOfBirth) {
						diffDays = maxDayOfLastMonth - dayOfBirth + dayOfNow;
					} else {
						diffDays = dayOfNow;
					}
				}
			}
		}
		// 计算月份时，没有考虑年
		diffYears = diffMonths / 12;
		diffMonths = diffMonths % 12;
		return new int[] { diffYears, diffMonths, diffDays };
	}

	/**
	 * 获取两个日历的月份之差
	 * 
	 * @param calendarBirth
	 * @param calendarNow
	 * @return
	 */
	public static int getMonthsOfAge(Calendar calendarBirth,
			Calendar calendarNow) {
		return (calendarNow.get(Calendar.YEAR) - calendarBirth
				.get(Calendar.YEAR))
				* 12
				+ calendarNow.get(Calendar.MONTH)
				- calendarBirth.get(Calendar.MONTH);
	}

	/**
	 * 判断这一天是否是月底
	 * 
	 * @param calendar
	 * @return
	 */
	public static boolean isEndOfMonth(Calendar calendar) {
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dayOfMonth == calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
			return true;
		return false;
	}

	/**
	 * 日期转换为毫秒
	 * 
	 * @param str
	 *            2015-07-02 13：22：59
	 * @param format
	 *            YY-MM-DD HH:MM:SS
	 * @return
	 */
	public static long StringdateToMil(String str, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		long millionSeconds = 0;
		try {
			millionSeconds = sdf.parse(str).getTime();
		} catch (ParseException e) {
			// e.printStackTrace();
		}// 毫秒
		return millionSeconds;
	}

	/**
	 * 当前String日期格式转换成其它格式的String日期格式
	 * 
	 * @param needFormat
	 * @param curFormat
	 * @param curString
	 * @return
	 */
	public static String StringToStringFormat(String needFormat,
			String curFormat, String curString) {
		String needString = "";
		try {
			SimpleDateFormat curformat = new SimpleDateFormat(curFormat);
			SimpleDateFormat needformat = new SimpleDateFormat(needFormat);
			needString = needformat.format(curformat.parse(curString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return needString;
	}

	/**
	 * 判断是上午还是下午
	 * 
	 * @param str
	 * @return
	 */
	public static String getAMOrPM(String str) {

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(DateUtils.toDate(str));
		int iString = calendar.get(GregorianCalendar.AM_PM);
		if (iString == 0) {
			return " 上午";
		} else {
			return " 下午";
		}
	}
}
