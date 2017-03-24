package yyl.yincloud.activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.gson.reflect.TypeToken;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yyl.yincloud.R;
import yyl.yincloud.base.BaseActivity;
import yyl.yincloud.bean.is_rehearsing.IsRehearsingMsBean;
import yyl.yincloud.bean.movie_detail.MovieAdvListBean;
import yyl.yincloud.bean.sellingtickest.SellingTicketsMoviesBean;
import yyl.yincloud.http.CloudLoad;
import yyl.yincloud.http.CustomSubscriber;
import yyl.yincloud.publics.YinCloudValues;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_content)
    LinearLayout main_content;

    @BindView(R.id.get_selling_tickets)
    Button get_data;
    @BindView(R.id.get_Is_rehearsing)
    Button get_Is_rehearsing;
    @BindView(R.id.get_coming_soon)
    Button get_coming_soon;
    @BindView(R.id.get_movie_detail)
    Button get_movie_detail;
    @BindView(R.id.get_actor_list)
    Button get_actor_list;
    @BindView(R.id.get_film_commentary)
    Button get_film_commentary;
    @BindView(R.id.get_movie_trailer)
    Button get_movie_trailer;
    @BindView(R.id.get_movie_stills)
    Button get_movie_stills;

    private CloudLoad mCloudLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Fade());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCloudLoad = new CloudLoad("movie");

    }


    @OnClick({R.id.get_selling_tickets, R.id.get_Is_rehearsing,R.id.get_coming_soon,
            R.id.get_actor_list, R.id.get_film_commentary,
            R.id.get_movie_detail, R.id.get_movie_trailer, R.id.get_movie_stills})
    void click(View view) {
        switch (view.getId()) {
            case R.id.get_selling_tickets:
                //正在售票
                findSellingTickets();
                break;
            case R.id.get_Is_rehearsing:
                //正在热映
                findIsRehearsing();
                break;
            case R.id.get_coming_soon:
                //即将上映
                findComingSoon();
                break;
            case R.id.get_movie_detail:
                //电影详情
                findMovieDetail();
                break;
            case R.id.get_actor_list:

                break;
            case R.id.get_film_commentary:

                break;
            case R.id.get_movie_trailer:

                break;
            case R.id.get_movie_stills:

                break;
        }
    }

    private void findComingSoon() {
        mCloudLoad.findComingSoon(366);
    }

    private void findIsRehearsing() {
        mCloudLoad.findIsRehearsing(366)
                .subscribe(new CustomSubscriber<JSONObject>(
                        YinCloudValues.IS_REHEARSING,this));


    }

    private void findSellingTickets() {
        mCloudLoad.findSellingTickets(366)
                .subscribe(new CustomSubscriber<JSONObject>(
                        YinCloudValues.SELLING_TICKETS, this));
    }

    private void findMovieDetail() {
        new CloudLoad("ticket").findMovieDetail(366, "125805")
                .subscribe(new CustomSubscriber<JSONObject>(
                        YinCloudValues.MOVIE_DETAIL,this));
    }

    @Override
    public boolean supportSlideBack() {
        return false;
    }

    @Override
    public void onNext(JSONObject jsonObject, String method) {

        try {
            switch (method) {
                case YinCloudValues.SELLING_TICKETS:
                    JSONArray movies = jsonObject.optJSONArray("movies");
                    Type token1 = new TypeToken<List<SellingTicketsMoviesBean>>(){}.getType();
                    List<SellingTicketsMoviesBean> mMovies = mGson.fromJson(movies.toString(),
                            token1);
                    for (SellingTicketsMoviesBean mMovy : mMovies) {
                        Logger.e(mMovy.getActorName1() + mMovy.getImg()
                                + mMovy.getNearestShowtime().getNearestShowDay());
                    }
                    String count = jsonObject.optString("count");
                    String totalCinemaCount = jsonObject.optString("totalCinemaCount");
                    Logger.e(count + totalCinemaCount + "咯咯咯");
                    break;
                case YinCloudValues.IS_REHEARSING:
                    JSONArray ms = jsonObject.optJSONArray("ms");
                    Type token2 = new TypeToken<List<IsRehearsingMsBean>>(){}.getType();
                    List<IsRehearsingMsBean> mMs = mGson.fromJson(ms.toString(), token2);
                    for (IsRehearsingMsBean mM : mMs) {
                        Logger.e(mM.getAN1() + "和" + mM.getAN2());
                        for (IsRehearsingMsBean.VersionsBean version : mM.versions) {
                            Logger.e(version.getEnumX() + "--" + version.getVersion());
                        }
                    }

                    String bImg = jsonObject.optString("bImg");
                    String date = jsonObject.optString("date");
                    Logger.e(bImg + "--" + date);
                    break;
                case YinCloudValues.MOVIE_DETAIL:
                    JSONObject json_result = new JSONObject(jsonObject.optString("data"));
                    JSONObject advertisement = new JSONObject(json_result.optString
                            ("advertisement"));
                    JSONObject basic = new JSONObject(json_result.optString("basic"));
                    JSONObject boxOffice = new JSONObject(json_result.optString("boxOffice"));
                    JSONObject live = new JSONObject(json_result.optString("live"));
                    JSONObject related = new JSONObject(json_result.optString("related"));

                    JSONArray dvList = advertisement.optJSONArray("advList");
                    Type token3 = new TypeToken<List<MovieAdvListBean>>(){}.getType();
                    List<MovieAdvListBean> advListBeanList = mGson.fromJson(dvList.toString(),
                            token3);
                    for (MovieAdvListBean bean : advListBeanList) {
                        Logger.e(bean.getAdvTag() + bean.getUrl() + bean.getTag());
                    }
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void OnError(Throwable e) {

    }
}
