package yyl.yincloud.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.aitangba.swipeback.SwipeBackActivity;
import com.google.gson.Gson;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import yyl.yincloud.AppActivityManager;
import yyl.yincloud.R;
import yyl.yincloud.helpers.PermissionsChecker;
import yyl.yincloud.http.CloudLoad;
import yyl.yincloud.http.HttpOnNextListener;
import yyl.yincloud.publics.YinCloudValues;

/**
 * Created by yyl on 2017/3/9.
 */

public abstract class BaseActivity extends SwipeBackActivity implements HttpOnNextListener {

    public static final int PERMISSIONS_DENIED = 1; // 权限拒绝

    private static final int PERMISSION_REQUEST_CODE = 0; // 系统权限管理页面的参数
    private static final String PACKAGE_URL_SCHEME = "package:"; // 方案

    protected PermissionsChecker mChecker; // 权限检测器
    private String currentActivity;
    private String permissionStatus = "";

    protected Gson mGson;
    protected CloudLoad mCloudLoad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //透明状态栏
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){//4.4 全透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);//calculateStatusColor(Color.WHITE, (int) alphaValue)
        }

        setLayout();
        AppActivityManager.getInstance().addActivity(this);
        ButterKnife.bind(this);
        mChecker = new PermissionsChecker(this);
        mGson = new Gson();
        mCloudLoad = new CloudLoad("movie");
        initUi();
        initData();
        initListener();

    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initUi();

    protected abstract void setLayout();

    /**
     * 检查权限是否获取
     * @param permissions
     */
    protected void checkPermissions(String[] permissions, String activityString) {
        this.currentActivity = activityString;
        //请求相机和麦克风权限单独做判断
        if (Arrays.equals(permissions, YinCloudValues.CAMERA)) {
            permissionStatus = "camera";
        } else if (Arrays.equals(permissions, YinCloudValues.MICROPHONE)) {
            permissionStatus = "microphone";
        }
        requestPermissions(permissions); // 请求权限
    }

    // 请求权限兼容低版本
    private void requestPermissions(String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
    }

    /**
     * 用户权限处理,
     * 如果全部获取, 则直接过.
     * 如果权限缺失, 则提示Dialog.
     *
     * @param requestCode  请求码
     * @param permissions  权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE && hasAllPermissionsGranted(grantResults)) {
            //获取到权限后 做自己的处理
            doSomething(YinCloudValues.DoSomething_CAMERA_OR_MICROPHONE, permissionStatus);
        } else {
            showMissingPermissionDialog();
        }
    }

    // 含有全部的权限
    private boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
        for (int grantResult : grantResults) {
            if (grantResult == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

    // 显示缺失权限提示
    private void showMissingPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.help);
        builder.setMessage(R.string.string_help_text);
        if (currentActivity.equals("ChatActivity") | currentActivity.equals("PersonInforActivity")) {
            builder.setCancelable(true);
        } else {
            builder.setCancelable(false);
        }
        if (currentActivity.equals("MainActivity")) {
            // 拒绝, 退出应用
            builder.setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setResult(PERMISSIONS_DENIED);
                    AppActivityManager.getInstance().finishAllActivity();
                }
            });
        }

        builder.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
            }
        });

        builder.show();
    }

    // 启动应用的设置
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse(PACKAGE_URL_SCHEME + getPackageName()));
        startActivity(intent);
    }

    /**
     * 让子类做些什么
     *
     * @param status
     * @param content
     */
    protected void doSomething(int status, String content) {

    }

    /**
     * 关闭当前页面
     */
    protected void finishThis() {
        AppActivityManager.getInstance().finishActivity(this);
    }
}
