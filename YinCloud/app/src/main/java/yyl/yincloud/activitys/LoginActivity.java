package yyl.yincloud.activitys;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.gson.reflect.TypeToken;
import com.jackie.greendao.CityInfoBeanDao;
import com.jackie.greendao.DaoSession;
import com.orhanobut.logger.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yyl.yincloud.R;
import yyl.yincloud.base.BaseActivity;
import yyl.yincloud.base.BaseApplication;
import yyl.yincloud.bean.cityid.CityInfoBean;
import yyl.yincloud.helpers.RenderScriptHelper;
import yyl.yincloud.http.CustomSubscriber;
import yyl.yincloud.publics.YinCloudValues;
import yyl.yincloud.widget.LoginButton;

/**
 * Created by yyl on 2017/3/20.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.btn_login)
    LoginButton btn_login;
    @BindView(R.id.login_content)
    RelativeLayout login_content;
    @BindView(R.id.img_login_bg)
    ImageView img_login_bg;

    @BindView(R.id.color_view)
    View color_view;

    private static final int[] SPLASH_ARRAY = {
            R.drawable.splash0,
            R.drawable.splash2,
            R.drawable.splash3,
            R.drawable.splash4,
            R.drawable.splash6,
            R.drawable.splash7,
            R.drawable.splash8,
            R.drawable.splash9,
            R.drawable.splash10,
            R.drawable.splash11,
            R.drawable.splash13,
            R.drawable.splash14,
            R.drawable.splash15,
            R.drawable.splash16,
            R.drawable.meinv
    };

    private CityInfoBeanDao mCityInfoBeanDao;

    @Override
    protected void setLayout() {
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void initListener() {

    }

    private void findCity() {
        mCloudLoad.findCityId()
                .subscribe(new CustomSubscriber<JSONObject>(
                        YinCloudValues.CITY_ID,this));
    }

    @Override
    protected void initData() {
        Random r = new Random(SystemClock.elapsedRealtime());
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(),
                SPLASH_ARRAY[r.nextInt(SPLASH_ARRAY.length)]);
        img_login_bg.setImageBitmap(RenderScriptHelper.rsBlur(this, myBitmap, 14));

        DaoSession daoSession = ((BaseApplication)getApplication()).getDaoSession();
        mCityInfoBeanDao = daoSession.getCityInfoBeanDao();

        findCity();
    }

    @Override
    protected void initUi() {
        // 缺少权限时, 进入权限配置页面
        if (mChecker.lacksPermissions(YinCloudValues.PHONE_AND_STORAGE)) {
            checkPermissions(YinCloudValues.PHONE_AND_STORAGE, "MainActivity");
        }
    }


    @OnClick({R.id.btn_login})
    void click(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (btn_login.isRuning()) {
                    btn_login.setState(LoginButton.STATUS_SUCCESS);
                } else {
                    btn_login.startOk();
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            startAnimate();

                        }

                    }, 500);
                }
                break;
        }
    }


    private void startAnimate() {
        int[] location = new int[2];
        btn_login.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(color_view,
                x + btn_login.getMeasuredWidth()/2,
                y + btn_login.getMeasuredHeight()/2,
                btn_login.getWidth()/2, login_content.getHeight());
        mAnimator.setDuration(400);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //加上finish当前界面，在跳转时会看到手机桌面
//                startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(
//                        LoginActivity.this).toBundle());
                startActivity(intent);
                finishThis();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                color_view.setVisibility(View.VISIBLE);
            }
        });
        mAnimator.start();
    }


    @Override
    public void onNext(JSONObject jsonObject, String method) {
        switch (method) {
            case YinCloudValues.CITY_ID:
                JSONArray cityArray = jsonObject.optJSONArray("p");
                Type cityToken = new TypeToken<List<CityInfoBean>>(){}.getType();
                List<CityInfoBean> mCitys = mGson.fromJson(cityArray.toString(),cityToken);

                List<CityInfoBean> cityFromDB = mCityInfoBeanDao.queryBuilder().list();

                for (CityInfoBean mCity : mCitys) {
                    if (cityFromDB.isEmpty()) {
                        mCityInfoBeanDao.insert(mCity);
                    } else {
                        mCityInfoBeanDao.insertOrReplace(mCity);
                    }
                }

                break;
        }

    }

    @Override
    public void OnError(Throwable e) {
        e.printStackTrace();
    }
}
