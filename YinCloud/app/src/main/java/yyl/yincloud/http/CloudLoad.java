package yyl.yincloud.http;

import org.json.JSONObject;

import rx.Observable;

/**
 * Created by yyl on 2017/3/9.
 * 网络请求
 */

public class CloudLoad extends ObjectLoader {

    private ApiService apiService;

    public CloudLoad(String type) {
        apiService = RetrofitServiceManager.getInstance(type).create(ApiService.class);
    }

    //查找城市对应id
    public Observable<JSONObject> findCityId() {
        return observe(apiService.findCityId());
    }

    //正在售票
    public Observable<JSONObject> findSellingTickets(int locationId) {
        return observe(apiService.findSellingTickets(locationId));
    }

    //正在热映
    public Observable<JSONObject> findIsRehearsing(int locationId) {
        return observe(apiService.findIsRehearsing(locationId));
    }

    //即将上映
    public Observable<JSONObject> findComingSoon(int locationId) {
        return observe(apiService.findComingSoon(locationId));
    }

    //影片详情 使用TICKET_URL_TYPE
    public Observable<JSONObject> findMovieDetail(int locationId, String movieId) {
        return observe(apiService.findMovieDetail(locationId, movieId));
    }

    //演员列表
    public Observable<JSONObject> findActorList(String movieId) {
        return observe(apiService.findActorList(movieId));
    }

    //影片评论 使用TICKET_URL_TYPE
    public Observable<JSONObject> findFilmCommentary(String movieId) {
        return observe(apiService.findFilmCommentary(movieId));
    }

    //预告片&花絮
    public Observable<JSONObject> findMovieTrailer(int pageIndex, String movieId) {
        return observe(apiService.findMovieTrailer(pageIndex, movieId));
    }

    //剧照
    public Observable<JSONObject> findMovieStills(String movieId) {
        return observe(apiService.findMovieStills(movieId));
    }
}
