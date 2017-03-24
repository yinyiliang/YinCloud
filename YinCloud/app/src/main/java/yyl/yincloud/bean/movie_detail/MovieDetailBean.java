package yyl.yincloud.bean.movie_detail;

import java.util.List;

/**
 * Created by yyl on 2017/3/9.
 *
 * 影片详情
 */

public class MovieDetailBean {

    private String code;
    private MovieDataBean data;
    private String msg;
    private String showMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MovieDataBean getData() {
        return data;
    }

    public void setData(MovieDataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

}
