package yyl.yincloud.bean.film_commentary;

import java.util.List;

/**
 * Created by yyl on 2017/3/19.
 */

public class CommentaryDataBean {
    /**
     * mini : {"list":[{"commentDate":1488874555,"commentId":41813818,
     * "content":"七里咔嚓一顿乱打，爆米花！","headImg":"http://img22.mtime
     * .cn/up/2010/07/13/090124.98180776_128X128.jpg","img":"","isHot":false,
     * "isPraise":false,"locationName":"沈阳","nickname":"花太狼","praiseCount":1,"rating":6,
     * "replyCount":0},{"commentDate":1488797522,"commentId":41808238,
     * "content":"一贯的故事套路，故事实在经不起一点儿的推敲，但是热热闹闹的，也可以吧。","headImg":"http://img2.mtime
     * .cn/u/1923/1359923/597da37a-f25f-4287-98a8-6f2ceea47b22/128X128.jpg","img":"",
     * "isHot":false,"isPraise":false,"locationName":"北京","nickname":"zada1359923",
     * "praiseCount":1,"rating":6.6,"replyCount":0},{"commentDate":1488769048,
     * "commentId":41805281,"content":"爆米花电影，老了老了","headImg":"http://img32.mtime
     * .cn/up/2014/08/14/100949.76880820_128X128.jpg","img":"","isHot":false,
     * "isPraise":false,"locationName":"温州","nickname":"MIMI1490212","praiseCount":0,
     * "rating":7,"replyCount":0}],"total":1470}
     * plus : {"list":[{"commentDate":1486743960,"commentId":7996250,
     * "content":" \n\n\n\n《极限特工3
     * 》上映了，在国内接下了春节档的大旗，首日票房破亿，全是赢了开门红。不过，论电影质量嘛，马马虎虎，热闹有余，故事不足，花拳绣腿而已。\n \n
     * 这片没什么可说的，也没必要费劲巴拉地写评论，枉费精力也浪费读者的时间。不开玩笑，大家都很忙。所以，今天直接上干货，咱来聊聊主演那个光头，那个叫范迪塞尔的家伙。不聊八卦，咱聊聊梦想的那些事。\n \n话说，很多演员，能够有一个以自己主打的电影系列...","headImg":"http://img2.mtime.cn/u/1139/691139/cd202651-559b-42d7-92be-565c7f6e35c0/128X128.jpg","isWantSee":false,"locationName":"","nickname":"邑人","rating":6.9,"replyCount":14,"title":"范·迪塞尔，一个光头不同寻常的电影宇宙"}],"total":45}
     */

    private MiniBean mini;
    private PlusBean plus;

    public MiniBean getMini() {
        return mini;
    }

    public void setMini(MiniBean mini) {
        this.mini = mini;
    }

    public PlusBean getPlus() {
        return plus;
    }

    public void setPlus(PlusBean plus) {
        this.plus = plus;
    }

    public static class MiniBean {
        /**
         * list : [{"commentDate":1488874555,"commentId":41813818,"content":"七里咔嚓一顿乱打，爆米花！",
         * "headImg":"http://img22.mtime.cn/up/2010/07/13/090124.98180776_128X128.jpg",
         * "img":"","isHot":false,"isPraise":false,"locationName":"沈阳","nickname":"花太狼",
         * "praiseCount":1,"rating":6,"replyCount":0},{"commentDate":1488797522,
         * "commentId":41808238,"content":"一贯的故事套路，故事实在经不起一点儿的推敲，但是热热闹闹的，也可以吧。",
         * "headImg":"http://img2.mtime
         * .cn/u/1923/1359923/597da37a-f25f-4287-98a8-6f2ceea47b22/128X128.jpg","img":"",
         * "isHot":false,"isPraise":false,"locationName":"北京","nickname":"zada1359923",
         * "praiseCount":1,"rating":6.6,"replyCount":0},{"commentDate":1488769048,
         * "commentId":41805281,"content":"爆米花电影，老了老了","headImg":"http://img32.mtime
         * .cn/up/2014/08/14/100949.76880820_128X128.jpg","img":"","isHot":false,
         * "isPraise":false,"locationName":"温州","nickname":"MIMI1490212","praiseCount":0,
         * "rating":7,"replyCount":0}]
         * total : 1470
         */

        private int total;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * commentDate : 1488874555
             * commentId : 41813818
             * content : 七里咔嚓一顿乱打，爆米花！
             * headImg : http://img22.mtime.cn/up/2010/07/13/090124.98180776_128X128.jpg
             * img :
             * isHot : false
             * isPraise : false
             * locationName : 沈阳
             * nickname : 花太狼
             * praiseCount : 1
             * rating : 6
             * replyCount : 0
             */

            private int commentDate;
            private int commentId;
            private String content;
            private String headImg;
            private String img;
            private boolean isHot;
            private boolean isPraise;
            private String locationName;
            private String nickname;
            private int praiseCount;
            private int rating;
            private int replyCount;

            public int getCommentDate() {
                return commentDate;
            }

            public void setCommentDate(int commentDate) {
                this.commentDate = commentDate;
            }

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public boolean isIsHot() {
                return isHot;
            }

            public void setIsHot(boolean isHot) {
                this.isHot = isHot;
            }

            public boolean isIsPraise() {
                return isPraise;
            }

            public void setIsPraise(boolean isPraise) {
                this.isPraise = isPraise;
            }

            public String getLocationName() {
                return locationName;
            }

            public void setLocationName(String locationName) {
                this.locationName = locationName;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPraiseCount() {
                return praiseCount;
            }

            public void setPraiseCount(int praiseCount) {
                this.praiseCount = praiseCount;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }
        }
    }

    public static class PlusBean {
        /**
         * list : [{"commentDate":1486743960,"commentId":7996250,
         * "content":" \n\n\n\n《极限特工3
         * 》上映了，在国内接下了春节档的大旗，首日票房破亿，全是赢了开门红。不过，论电影质量嘛，马马虎虎，热闹有余，故事不足，花拳绣腿而已。\n \n
         * 这片没什么可说的，也没必要费劲巴拉地写评论，枉费精力也浪费读者的时间。不开玩笑，大家都很忙。所以，今天直接上干货，咱来聊聊主演那个光头，那个叫范迪塞尔的家伙。不聊八卦，咱聊聊梦想的那些事。\n \n话说，很多演员，能够有一个以自己主打的电影系列...","headImg":"http://img2.mtime.cn/u/1139/691139/cd202651-559b-42d7-92be-565c7f6e35c0/128X128.jpg","isWantSee":false,"locationName":"","nickname":"邑人","rating":6.9,"replyCount":14,"title":"范·迪塞尔，一个光头不同寻常的电影宇宙"}]
         * total : 45
         */

        private int total;
        private List<ListBeanX> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public static class ListBeanX {
            /**
             * commentDate : 1486743960
             * commentId : 7996250
             * content :  



             《极限特工3》上映了，在国内接下了春节档的大旗，首日票房破亿，全是赢了开门红。不过，论电影质量嘛，马马虎虎，热闹有余，故事不足，花拳绣腿而已。
              
             这片没什么可说的，也没必要费劲巴拉地写评论，枉费精力也浪费读者的时间。不开玩笑，大家都很忙。所以，今天直接上干货，咱来聊聊主演那个光头，那个叫范迪塞尔的家伙。不聊八卦，咱聊聊梦想的那些事。
              
             话说，很多演员，能够有一个以自己主打的电影系列...
             * headImg : http://img2.mtime.cn/u/1139/691139/cd202651-559b-42d7-92be-565c7f6e35c0/128X128.jpg
             * isWantSee : false
             * locationName :
             * nickname : 邑人
             * rating : 6.9
             * replyCount : 14
             * title : 范·迪塞尔，一个光头不同寻常的电影宇宙
             */

            private int commentDate;
            private int commentId;
            private String content;
            private String headImg;
            private boolean isWantSee;
            private String locationName;
            private String nickname;
            private double rating;
            private int replyCount;
            private String title;

            public int getCommentDate() {
                return commentDate;
            }

            public void setCommentDate(int commentDate) {
                this.commentDate = commentDate;
            }

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHeadImg() {
                return headImg;
            }

            public void setHeadImg(String headImg) {
                this.headImg = headImg;
            }

            public boolean isIsWantSee() {
                return isWantSee;
            }

            public void setIsWantSee(boolean isWantSee) {
                this.isWantSee = isWantSee;
            }

            public String getLocationName() {
                return locationName;
            }

            public void setLocationName(String locationName) {
                this.locationName = locationName;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public double getRating() {
                return rating;
            }

            public void setRating(double rating) {
                this.rating = rating;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
