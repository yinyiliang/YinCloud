package yyl.yincloud.bean.movie_detail;

/**
 * Created by yyl on 2017/3/19.
 */

public class MovieBoxOfficeBean {

    /**
     * movieId : 125805
     * ranking : 7
     * todayBox : 46683812
     * todayBoxDes : 46.68
     * todayBoxDesUnit : 今日实时(万)
     * totalBox : 108664800558
     * totalBoxDes : 10.87
     * totalBoxUnit : 累计票房(亿)
     */

    private int movieId;
    private int ranking;
    private int todayBox;
    private String todayBoxDes;
    private String todayBoxDesUnit;
    private long totalBox;
    private String totalBoxDes;
    private String totalBoxUnit;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getTodayBox() {
        return todayBox;
    }

    public void setTodayBox(int todayBox) {
        this.todayBox = todayBox;
    }

    public String getTodayBoxDes() {
        return todayBoxDes;
    }

    public void setTodayBoxDes(String todayBoxDes) {
        this.todayBoxDes = todayBoxDes;
    }

    public String getTodayBoxDesUnit() {
        return todayBoxDesUnit;
    }

    public void setTodayBoxDesUnit(String todayBoxDesUnit) {
        this.todayBoxDesUnit = todayBoxDesUnit;
    }

    public long getTotalBox() {
        return totalBox;
    }

    public void setTotalBox(long totalBox) {
        this.totalBox = totalBox;
    }

    public String getTotalBoxDes() {
        return totalBoxDes;
    }

    public void setTotalBoxDes(String totalBoxDes) {
        this.totalBoxDes = totalBoxDes;
    }

    public String getTotalBoxUnit() {
        return totalBoxUnit;
    }

    public void setTotalBoxUnit(String totalBoxUnit) {
        this.totalBoxUnit = totalBoxUnit;
    }

}
