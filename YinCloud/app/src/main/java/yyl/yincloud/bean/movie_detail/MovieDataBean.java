package yyl.yincloud.bean.movie_detail;

import java.util.List;

/**
 * Created by yyl on 2017/3/19.
 */

public class MovieDataBean {

    private MovieAdvertisementBean advertisement;
    private MovieBasicBean basic;
    private MovieBoxOfficeBean boxOffice;
    private MovieLiveBean live;
    private MovieRelatedBean related;

    public MovieAdvertisementBean getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(MovieAdvertisementBean advertisement) {
        this.advertisement = advertisement;
    }

    public MovieBasicBean getBasic() {
        return basic;
    }

    public void setBasic(MovieBasicBean basic) {
        this.basic = basic;
    }

    public MovieBoxOfficeBean getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(MovieBoxOfficeBean boxOffice) {
        this.boxOffice = boxOffice;
    }

    public MovieLiveBean getLive() {
        return live;
    }

    public void setLive(MovieLiveBean live) {
        this.live = live;
    }

    public MovieRelatedBean getRelated() {
        return related;
    }

    public void setRelated(MovieRelatedBean related) {
        this.related = related;
    }

}
