package yyl.yincloud.activitys;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.google.gson.reflect.TypeToken;
import com.jackie.greendao.CityInfoBeanDao;
import com.jackie.greendao.DaoSession;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.BindView;
import yyl.yincloud.R;
import yyl.yincloud.base.BaseActivity;
import yyl.yincloud.base.BaseApplication;
import yyl.yincloud.bean.cityid.CityInfoBean;
import yyl.yincloud.bean.is_rehearsing.IsRehearsingMsBean;
import yyl.yincloud.bean.movie_detail.MovieAdvListBean;
import yyl.yincloud.bean.sellingtickest.SellingTicketsMoviesBean;
import yyl.yincloud.http.CloudLoad;
import yyl.yincloud.http.CustomSubscriber;
import yyl.yincloud.publics.YinCloudValues;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_content)
    LinearLayout main_content;
    @BindView(R.id.tool_bar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.main_tablayout)
    TabLayout main_tablayout;
    @BindView(R.id.main_viewpager)
    ViewPager main_viewpager;

    private LocationClient mLocationClient = null;
    private BDLocationListener myListener = new MyLocationListener();

    private CityInfoBeanDao mCityInfoBeanDao;

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Fade());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocationClient.start();
    }

    @Override
    protected void initData() {
        DaoSession daoSession = ((BaseApplication)getApplication()).getDaoSession();
        mCityInfoBeanDao = daoSession.getCityInfoBeanDao();


        mLocationClient = new LocationClient(BaseApplication.mContext);
        initLocation();
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbarTitle.setText("主页");


    }

    @Override
    protected void initUi() {

    }



    private void initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备

        option.setCoorType("bd09ll");
        //可选，默认gcj02，设置返回的定位结果坐标系

//        int span=1000;
//        option.setScanSpan(span);
        //可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的

        option.setIsNeedAddress(true);
        //可选，设置是否需要地址信息，默认不需要

        option.setOpenGps(true);
        //可选，默认false,设置是否使用gps

        option.setLocationNotify(true);
        //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果

        option.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”

        option.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到

        option.setIgnoreKillProcess(false);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死

        option.SetIgnoreCacheException(false);
        //可选，默认false，设置是否收集CRASH信息，默认收集

        option.setEnableSimulateGps(false);
        //可选，默认false，设置是否需要过滤GPS仿真结果，默认需要

        mLocationClient.setLocOption(option);
    }

    @Override
    protected void initListener() {

    }

    private class MyLocationListener implements BDLocationListener  {

        @Override
        public void onReceiveLocation(BDLocation location) {

            String city = location.getCity();
            if (city != null) {
                city = city.replace("市", "")
                        .replace("省", "")
                        .replace("自治区", "")
                        .replace("特别行政区", "")
                        .replace("地区", "")
                        .replace("盟", "");

                CityInfoBean cityInfoBean = mCityInfoBeanDao.queryBuilder().where
                        (CityInfoBeanDao.Properties.N.eq(city)).unique();
                findIsRehearsing(cityInfoBean.getId());
                mLocationClient.stop();
            }


        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }

    private void findComingSoon(String locationId) {
        mCloudLoad.findComingSoon(locationId);
    }

    private void findIsRehearsing(String locationId) {
        mCloudLoad.findIsRehearsing(locationId)
                .subscribe(new CustomSubscriber<JSONObject>(
                        YinCloudValues.IS_REHEARSING,this));


    }

    private void findSellingTickets(String locationId) {
        mCloudLoad.findSellingTickets(locationId)
                .subscribe(new CustomSubscriber<JSONObject>(
                        YinCloudValues.SELLING_TICKETS, this));
    }

    private void findMovieDetail(String locationId) {
        new CloudLoad("ticket").findMovieDetail(locationId, "125805")
                .subscribe(new CustomSubscriber<JSONObject>(
                        YinCloudValues.MOVIE_DETAIL,this));
    }

    @Override
    protected void doSomething(int status, String content) {
        switch (status) {
            case YinCloudValues.DoSomething_CAMERA_OR_MICROPHONE:
                mLocationClient.start();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
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
                        for (IsRehearsingMsBean.VersionsBean version : mM.versions) {

                        }
                    }

                    String bImg = jsonObject.optString("bImg");
                    String date = jsonObject.optString("date");
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
