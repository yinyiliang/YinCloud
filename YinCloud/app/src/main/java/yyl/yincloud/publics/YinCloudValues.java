package yyl.yincloud.publics;

import android.os.Environment;

import java.io.File;

/**
 * Created by yyl on 2017/3/9.
 */

public class YinCloudValues {

    /**
     * 应用名
     **/
    public final static String APP_NAME = "yincloud";

    /**
     * SD卡路径
     **/
    private final static String SD_PATH = Environment
            .getExternalStorageDirectory().getAbsolutePath();

    /**
     * 日志存放路径
     **/
    public final static String LOG_PATH = SD_PATH + File.separator + APP_NAME
            + File.separator + "Log";

    public static final String TICKET_URL_TYPE = "ticket";

    //对应城市Id
    public static final String CITY_ID = "https://api-m.mtime.cn/Showtime/HotCitiesByCinema.api";
    public static final String SELLING_TICKETS = "PageSubArea/HotPlayMovies.api";//正在售票
    public static final String IS_REHEARSING = "Showtime/LocationMovies.api"; //正在热映
    public static final String COMING_SOON = "Movie/MovieComingNew.api";//即将上映
    public static final String MOVIE_DETAIL = "detail.api";//影片详情
    public static final String ACTOR_LIST = "Movie/MovieCreditsWithTypes.api";//演员列表
    public static final String FILM_COMMENTARY = "hotComment.api";//影片评论 FilmCommentary
    public static final String MOVIE_TRAILER = "Movie/Video.api";//预告片&花絮 MovieTrailer
    public static final String MOVIE_STILLS = "Movie/ImageAll.api";//剧照
}
