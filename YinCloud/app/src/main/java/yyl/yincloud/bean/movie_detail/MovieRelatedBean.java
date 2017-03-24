package yyl.yincloud.bean.movie_detail;

import java.util.List;

/**
 * Created by yyl on 2017/3/19.
 */

public class MovieRelatedBean {

    /**
     * goodsCount : 0
     * goodsList : []
     * relateId : 0
     * relatedUrl : https://mall-wv.mtime.cn/#!/commerce/list/
     * type : 0
     */

    private int goodsCount;
    private int relateId;
    private String relatedUrl;
    private int type;
    private List<?> goodsList;

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getRelateId() {
        return relateId;
    }

    public void setRelateId(int relateId) {
        this.relateId = relateId;
    }

    public String getRelatedUrl() {
        return relatedUrl;
    }

    public void setRelatedUrl(String relatedUrl) {
        this.relatedUrl = relatedUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<?> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<?> goodsList) {
        this.goodsList = goodsList;
    }

}
