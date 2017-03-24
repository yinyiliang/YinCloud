package yyl.yincloud.bean.movie_detail;

import java.util.List;

/**
 * Created by yyl on 2017/3/19.
 */

public class MovieAdvertisementBean {

    /**
     * advList : [{"advTag":"","endDate":1514649599,"isHorizontalScreen":false,
     * "isOpenH5":false,"startDate":1451577600,"tag":"商城模玩+商城新奇特","type":"203",
     * "typeName":"影片详情页banner2","url":"https://static4da.mtime
     * .cn/feature/mobile/banner/2017/0306/xqtmw750210m.html"}]
     * count : 1
     * error :
     * success : true
     */

    private int count;
    private String error;
    private boolean success;
    private List<MovieAdvListBean> advList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<MovieAdvListBean> getAdvList() {
        return advList;
    }

    public void setAdvList(List<MovieAdvListBean> advList) {
        this.advList = advList;
    }

}
