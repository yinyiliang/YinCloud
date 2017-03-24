package yyl.yincloud.bean.sellingtickest;

/**
 * Created by yyl on 2017/3/9.
 */

public class SellingTicketsMoviesBean {

    /**
     * actorName1 : 休·杰克曼
     * actorName2 : 达芙妮·基恩
     * btnText :
     * commonSpecial : 狼叔的最后一战，一个时代的落幕
     * directorName : 詹姆斯·曼高德
     * img : http://img5.mtime.cn/mt/2017/02/28/112612.39246709_1280X720X2.jpg
     * is3D : false
     * isDMAX : true
     * isFilter : false
     * isHot : true
     * isIMAX : true
     * isIMAX3D : false
     * isNew : false
     * length : 123
     * movieId : 209688
     * nearestShowtime : {"isTicket":true,"nearestCinemaCount":172,
     * "nearestShowDay":1489046400,"nearestShowtimeCount":2138}
     * rDay : 3
     * rMonth : 3
     * rYear : 2017
     * ratingFinal : 8.1
     * titleCn : 金刚狼3：殊死一战
     * titleEn : Logan
     * type : 动作 / 剧情 / 科幻
     * wantedCount : 2028
     */

    private String actorName1;
    private String actorName2;
    private String btnText;
    private String commonSpecial;
    private String directorName;
    private String img;
    private boolean is3D;
    private boolean isDMAX;
    private boolean isFilter;
    private boolean isHot;
    private boolean isIMAX;
    private boolean isIMAX3D;
    private boolean isNew;
    private int length;
    private int movieId;
    private NearestShowtimeBean nearestShowtime;
    private int rDay;
    private int rMonth;
    private int rYear;
    private double ratingFinal;
    private String titleCn;
    private String titleEn;
    private String type;
    private int wantedCount;

    public String getActorName1() {
        return actorName1;
    }

    public void setActorName1(String actorName1) {
        this.actorName1 = actorName1;
    }

    public String getActorName2() {
        return actorName2;
    }

    public void setActorName2(String actorName2) {
        this.actorName2 = actorName2;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public String getCommonSpecial() {
        return commonSpecial;
    }

    public void setCommonSpecial(String commonSpecial) {
        this.commonSpecial = commonSpecial;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public boolean isIsDMAX() {
        return isDMAX;
    }

    public void setIsDMAX(boolean isDMAX) {
        this.isDMAX = isDMAX;
    }

    public boolean isIsFilter() {
        return isFilter;
    }

    public void setIsFilter(boolean isFilter) {
        this.isFilter = isFilter;
    }

    public boolean isIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public boolean isIsIMAX() {
        return isIMAX;
    }

    public void setIsIMAX(boolean isIMAX) {
        this.isIMAX = isIMAX;
    }

    public boolean isIsIMAX3D() {
        return isIMAX3D;
    }

    public void setIsIMAX3D(boolean isIMAX3D) {
        this.isIMAX3D = isIMAX3D;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public NearestShowtimeBean getNearestShowtime() {
        return nearestShowtime;
    }

    public void setNearestShowtime(NearestShowtimeBean nearestShowtime) {
        this.nearestShowtime = nearestShowtime;
    }

    public int getRDay() {
        return rDay;
    }

    public void setRDay(int rDay) {
        this.rDay = rDay;
    }

    public int getRMonth() {
        return rMonth;
    }

    public void setRMonth(int rMonth) {
        this.rMonth = rMonth;
    }

    public int getRYear() {
        return rYear;
    }

    public void setRYear(int rYear) {
        this.rYear = rYear;
    }

    public double getRatingFinal() {
        return ratingFinal;
    }

    public void setRatingFinal(double ratingFinal) {
        this.ratingFinal = ratingFinal;
    }

    public String getTitleCn() {
        return titleCn;
    }

    public void setTitleCn(String titleCn) {
        this.titleCn = titleCn;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWantedCount() {
        return wantedCount;
    }

    public void setWantedCount(int wantedCount) {
        this.wantedCount = wantedCount;
    }

}
