package yyl.yincloud.bean.movie_trailer;

import java.util.List;

/**
 * Created by yyl on 2017/3/9.
 *
 * 预告片&花絮
 */

public class MovieTrailerBean {

    private int totalPageCount;
    private int totalCount;
    public List<MovieTrailerVideoListBean> videoList;

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
