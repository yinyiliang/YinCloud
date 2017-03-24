package yyl.yincloud.bean.is_rehearsing;

import java.util.List;

import yyl.yincloud.bean.is_rehearsing.IsRehearsingMsBean;

/**
 * Created by yyl on 2017/3/9.
 *
 * 正在热映
 */

public class IsRehearsingBean {


    /**
     * bImg : http://img5.mtime.cn/mg/2017/03/09/102927.91822415.jpg
     * date : 2017-03-09
     * lid : 366
     * ms : [{}]
     * newActivitiesTime : 0
     * totalComingMovie : 50
     * voucherMsg :
     */

    private String bImg;
    private String date;
    private int lid;
    private int newActivitiesTime;
    private int totalComingMovie;
    private String voucherMsg;
    public List<IsRehearsingMsBean> ms;

    public String getBImg() {
        return bImg;
    }

    public void setBImg(String bImg) {
        this.bImg = bImg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getNewActivitiesTime() {
        return newActivitiesTime;
    }

    public void setNewActivitiesTime(int newActivitiesTime) {
        this.newActivitiesTime = newActivitiesTime;
    }

    public int getTotalComingMovie() {
        return totalComingMovie;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public String getVoucherMsg() {
        return voucherMsg;
    }

    public void setVoucherMsg(String voucherMsg) {
        this.voucherMsg = voucherMsg;
    }

}
