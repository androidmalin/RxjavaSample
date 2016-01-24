
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 malin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.malin.rengwuxianrxjava.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;

/**
 * 类描述:判断ImageView
 * 创建人:malin.myemail@gmail.com
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
