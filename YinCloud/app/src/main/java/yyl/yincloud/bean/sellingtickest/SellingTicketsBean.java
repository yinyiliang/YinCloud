package yyl.yincloud.bean.sellingtickest;

import java.util.List;

import yyl.yincloud.bean.sellingtickest.SellingTicketsMoviesBean;

/**
 * Created by yyl on 2017/3/9.
 * <p>
 * 正在售票
 */

public class SellingTicketsBean {


    /**
     * count : 15
     * movies : [{.....}]
     * totalCinemaCount : 200
     * totalComingMovie : 52
     * totalHotMovie : 36
     */

    private int count;
    private int totalCinemaCount;
    private int totalComingMovie;
    private int totalHotMovie;
    public List<SellingTicketsMoviesBean> movies;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCinemaCount() {
        return totalCinemaCount;
    }

    public void setTotalCinemaCount(int totalCinemaCount) {
        this.totalCinemaCount = totalCinemaCount;
    }

    public int getTotalComingMovie() {
        return totalComingMovie;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public int getTotalHotMovie() {
        return totalHotMovie;
    }

    public void setTotalHotMovie(int totalHotMovie) {
        this.totalHotMovie = totalHotMovie;
    }

}
