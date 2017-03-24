package yyl.yincloud.http;

import org.json.JSONObject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yyl on 2017/3/9.
 */

public interface ApiService {

    //查找城市对应id
    @GET("https://api-m.mtime.cn/Showtime/HotCitiesByCinema.api")
    Observable<JSONObject> findCityId();

    //正在售票
    @GET("PageSubArea/HotPlayMovies.api")
    Observable<JSONObject> findSellingTickets(@Query("locationId") int locationId);

    //正在热映
    @GET("Showtime/LocationMovies.api")
    Observable<JSONObject> findIsRehearsing(@Query("locationId") int locationId);

    //即将上映
    @GET("Movie/MovieComingNew.api")
    Observable<JSONObject> findComingSoon(@Query("locationId") int locationId);

    //影片详情 使用TICKET_URL
    @GET("detail.api")
    Observable<JSONObject> findMovieDetail(@Query("locationId") int locationId,
                                           @Query("movieId") String movieId);

    //演员列表
    @GET("Movie/MovieCreditsWithTypes.api")
    Observable<JSONObject> findActorList(@Query("movieId") String movieId);

    //影片评论 使用TICKET_URL
    @GET("hotComment.api")
    Observable<JSONObject> findFilmCommentary(@Query("movieId") String movieId);

    //预告片&花絮
    @GET("Movie/Video.api")
    Observable<JSONObject> findMovieTrailer(@Query("pageIndex") int pageIndex,
                                                  @Query("movieId") String movieId);

    //剧照
    @GET("Movie/ImageAll.api")
    Observable<JSONObject> findMovieStills(@Query("movieId") String movieId);


}
