package yyl.yincloud.bean.actor;

import java.util.List;

/**
 * Created by yyl on 2017/3/9.
 * 演员类型Bean类
 */

public class ActorTypesBean {

    /**
     * typeName : 导演
     * typeNameEn : Director
     * persons : [{"id":892951,"name":"唐季礼","nameEn":"Stanley Tong",
     * "image":"http://img31.mtime.cn/ph/2014/02/22/192821.88623670_1280X720X2.jpg"}]
     */

    private String typeName;
    private String typeNameEn;
    private List<ActorPersonsBean> persons;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeNameEn() {
        return typeNameEn;
    }

    public void setTypeNameEn(String typeNameEn) {
        this.typeNameEn = typeNameEn;
    }

    public List<ActorPersonsBean> getPersons() {
        return persons;
    }

    public void setPersons(List<ActorPersonsBean> persons) {
        this.persons = persons;
    }

}
