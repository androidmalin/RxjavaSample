package com.malin.rengwuxianrxjava.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;

/**
 * 类描述:
 * 创建人:lin.ma@renren-inc.com
 * 创建时间:15-12-11 下午4:48
 * 备注:
 */
public class AvoidRecoveredAppearErrorImageView extends ImageView {
    public AvoidRecoveredAppearErrorImageView(Context context) {
        super(context);
    }

    public AvoidRecoveredAppearErrorImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AvoidRecoveredAppearErrorImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            //避免主动回收Bitmap导致的错误
            Logger.d("AvoidRecoveredAppearErrorImageView  -> Exception Message:" + e.getMessage());
        }
    }

}
