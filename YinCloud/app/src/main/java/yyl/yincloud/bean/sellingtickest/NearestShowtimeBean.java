package yyl.yincloud.bean.sellingtickest;

/**
 * Created by yyl on 2017/3/19.
 */

public class NearestShowtimeBean {

    /**
     * isTicket : true
     * nearestCinemaCount : 172
     * nearestShowDay : 1489046400
     * nearestShowtimeCount : 2138
     */

    private boolean isTicket;
    private int nearestCinemaCount;
    private int nearestShowDay;
    private int nearestShowtimeCount;

    public boolean isIsTicket() {
        return isTicket;
    }

    public void setIsTicket(boolean isTicket) {
        this.isTicket = isTicket;
    }

    public int getNearestCinemaCount() {
        return nearestCinemaCount;
    }

    public void setNearestCinemaCount(int nearestCinemaCount) {
        this.nearestCinemaCount = nearestCinemaCount;
    }

    public int getNearestShowDay() {
        return nearestShowDay;
    }

    public void setNearestShowDay(int nearestShowDay) {
        this.nearestShowDay = nearestShowDay;
    }

    public int getNearestShowtimeCount() {
        return nearestShowtimeCount;
    }

    public void setNearestShowtimeCount(int nearestShowtimeCount) {
        this.nearestShowtimeCount = nearestShowtimeCount;
    }

}
