package yyl.yincloud.bean.coming_soon;

import java.util.List;

/**
 * Created by yyl on 2017/3/9.
 */

public class MovieAttentionBean {

    /**
     * actor1 : 亚伦·保尔
     * actor2 : 琳娜·海蒂
     * director : 野末武志
     * id : 235579
     * image : http://img5.mtime.cn/mt/2017/03/03/142143.30945524_1280X720X2.jpg
     * isFilter : false
     * isTicket : true
     * isVideo : true
     * locationName : 日本
     * rDay : 10
     * rMonth : 3
     * rYear : 2017
     * releaseDate : 3月10日上映
     * title : 最终幻想15：王者之剑
     * type : 动画 / 冒险 / 剧情
     * videoCount : 3
     * videos : [{"hightUrl":"","image":"http://img5.mtime
     * .cn/mg/2017/02/28/085845.31050275.jpg","length":94,"title":"最终幻想15：王者之剑 中文终极版预告",
     * "url":"http://vfx.mtime.cn/Video/2017/02/28/mp4/170228085919661324.mp4",
     * "videoId":64748},{"hightUrl":"","image":"http://img5.mtime
     * .cn/mg/2017/02/16/155645.92104973.jpg","length":101,"title":"最终幻想15 中文定档预告",
     * "url":"http://vfx.mtime.cn/Video/2017/02/16/mp4/170216155114652598.mp4",
     * "videoId":64624},{"hightUrl":"","image":"http://img5.mtime
     * .cn/mg/2017/01/04/125757.58962292.jpg","length":124,"title":"最终幻想15：王者之剑 中文剧情版预告",
     * "url":"http://vfx.mtime.cn/Video/2017/01/04/mp4/170104125907195567.mp4","videoId":64089}]
     * wantedCount : 940
     */

    private String actor1;
    private String actor2;
    private String director;
    private int id;
    private String image;
    private boolean isFilter;
    private boolean isTicket;
    private boolean isVideo;
    private String locationName;
    private int rDay;
    private int rMonth;
    private int rYear;
    private String releaseDate;
    private String title;
    private String type;
    private int videoCount;
    private int wantedCount;
    public List<ComingSoonVideosBean> videos;

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIsFilter() {
        return isFilter;
    }

    public void setIsFilter(boolean isFilter) {
        this.isFilter = isFilter;
    }

    public boolean isIsTicket() {
        return isTicket;
    }

    public void setIsTicket(boolean isTicket) {
        this.isTicket = isTicket;
    }

    public boolean isIsVideo() {
        return isVideo;
    }

    public void setIsVideo(boolean isVideo) {
        this.isVideo = isVideo;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public int getWantedCount() {
        return wantedCount;
    }

    public void setWantedCount(int wantedCount) {
        this.wantedCount = wantedCount;
    }

}
