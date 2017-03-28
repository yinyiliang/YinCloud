package yyl.yincloud.bean.cityid;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by yyl on 2017/3/9.
 *
 * 城市信息
 */

@Entity
public class CityInfoBean {
    /**
     * count : 230
     * id : 292
     * n : 上海
     * pinyinFull : Shanghai
     * pinyinShort : sh
     */

    @Id
    private String count;
    private String id;
    private String n;
    private String pinyinFull;
    private String pinyinShort;
    @Generated(hash = 868380019)
    public CityInfoBean(String count, String id, String n, String pinyinFull,
            String pinyinShort) {
        this.count = count;
        this.id = id;
        this.n = n;
        this.pinyinFull = pinyinFull;
        this.pinyinShort = pinyinShort;
    }
    @Generated(hash = 759316132)
    public CityInfoBean() {
    }
    public String getCount() {
        return this.count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getN() {
        return this.n;
    }
    public void setN(String n) {
        this.n = n;
    }
    public String getPinyinFull() {
        return this.pinyinFull;
    }
    public void setPinyinFull(String pinyinFull) {
        this.pinyinFull = pinyinFull;
    }
    public String getPinyinShort() {
        return this.pinyinShort;
    }
    public void setPinyinShort(String pinyinShort) {
        this.pinyinShort = pinyinShort;
    }

}
