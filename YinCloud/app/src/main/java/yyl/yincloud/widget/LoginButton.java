package yyl.yincloud.widget;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yyl on 2017/3/20.
 */

public class LoginButton extends android.support.v7.widget.AppCompatTextView {

    private int DEFAULTVALUE = 150;

    private Paint mPaint;
    private int height = DEFAULTVALUE;

    public LoginButton(Context context) {
        this(context, null);
    }

    public LoginButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //抗锯齿
        mPaint.setStyle(Paint.Style.FILL); //填充方式
    }

    private int measureViewWidth(int spec) {
        int width = 500;
        int mode = MeasureSpec.getMode(spec);
        int size = MeasureSpec.getSize(spec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                width = size;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                width = Math.min(size, width);
                break;
        }
        return width;
    }

    private int measureHeight(int spec) {
        int mode = MeasureSpec.getMode(spec);
        int size = MeasureSpec.getSize(spec);
        switch (mode) {
            case MeasureSpec.EXACTLY:
                height = size;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                height = Math.min(size, height);
                break;
        }
        return height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureViewWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }


}
