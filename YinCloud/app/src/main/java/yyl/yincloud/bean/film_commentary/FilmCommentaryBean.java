package yyl.yincloud.bean.film_commentary;

/**
 * Created by yyl on 2017/3/9.
 *
 * 电影评论
 */

public class FilmCommentaryBean {


    /**
     * code : 1
     * data : {"mini":{"list":[{"commentDate":1488874555,"commentId":41813818,
     * "content":"七里咔嚓一顿乱打，爆米花！","headImg":"http://img22.mtime
     * .cn/up/2010/07/13/090124.98180776_128X128.jpg","img":"","isHot":false,"isPraise":false,
     * "locationName":"沈阳","nickname":"花太狼","praiseCount":1,"rating":6,"replyCount":0},
     * {"commentDate":1488797522,"commentId":41808238,
     * "content":"一贯的故事套路，故事实在经不起一点儿的推敲，但是热热闹闹的，也可以吧。","headImg":"http://img2.mtime
     * .cn/u/1923/1359923/597da37a-f25f-4287-98a8-6f2ceea47b22/128X128.jpg","img":"",
     * "isHot":false,"isPraise":false,"locationName":"北京","nickname":"zada1359923",
     * "praiseCount":1,"rating":6.6,"replyCount":0},{"commentDate":1488769048,
     * "commentId":41805281,"content":"爆米花电影，老了老了","headImg":"http://img32.mtime
     * .cn/up/2014/08/14/100949.76880820_128X128.jpg","img":"","isHot":false,"isPraise":false,
     * "locationName":"温州","nickname":"MIMI1490212","praiseCount":0,"rating":7,"replyCount":0}],
     * "total":1470},"plus":{"list":[{"commentDate":1486743960,"commentId":7996250,
     * "content":" \n\n\n\n《极限特工3
     * 》上映了，在国内接下了春节档的大旗，首日票房破亿，全是赢了开门红。不过，论电影质量嘛，马马虎虎，热闹有余，故事不足，花拳绣腿而已。\n \n
     * 这片没什么可说的，也没必要费劲巴拉地写评论，枉费精力也浪费读者的时间。不开玩笑，大家都很忙。所以，今天直接上干货，咱来聊聊主演那个光头，那个叫范迪塞尔的家伙。不聊八卦，咱聊聊梦想的那些事。\n \n话说，很多演员，能够有一个以自己主打的电影系列...","headImg":"http://img2.mtime.cn/u/1139/691139/cd202651-559b-42d7-92be-565c7f6e35c0/128X128.jpg","isWantSee":false,"locationName":"","nickname":"邑人","rating":6.9,"replyCount":14,"title":"范·迪塞尔，一个光头不同寻常的电影宇宙"}],"total":45}}
     * msg :
     * showMsg :
     */

    private String code;
    private CommentaryDataBean data;
    private String msg;
    private String showMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CommentaryDataBean getData() {
        return data;
    }

    public void setData(CommentaryDataBean data) {
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
