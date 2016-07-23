
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

package com.malin.rxjava.utils;

import android.os.SystemClock;
import android.util.Log;

/**
 * 类描述:手机设备的信息
 * 创建人:malin.myemail@gmail.com
 * 创建时间:16-01-20.下午17:50
 * 备注:
 */
public class ClickUtils {

    private static final String TAG = ClickUtils.class.getSimpleName();
    private static long lastClickTime = 0L;
    private static final boolean isDebug = true;
    private static final String BLANK_LOG = "\t";

    private ClickUtils() {
    }

    /**
     * 用于处理频繁点击问题, 如果两次点击小于500毫秒则不予以响应
     *
     * @return true:是连续的快速点击
     */
    public static boolean isFastDoubleClick() {
        long nowTime = SystemClock.elapsedRealtime();//从开机到现在的毫秒数（手机睡眠(sleep)的时间也包括在内）

        if (isDebug){
            Log.d(TAG,"nowTime:" + nowTime);
            Log.d(TAG,"lastClickTime:" + lastClickTime);
            Log.d(TAG,"时间间隔:"+(nowTime - lastClickTime));
        }
        if ((nowTime - lastClickTime) < 100000) {

            if (isDebug){
                Log.d(TAG,"快速点击");
                Log.d(TAG, BLANK_LOG);
            }
            return true;
        } else {
            lastClickTime = nowTime;

            if (isDebug){
                Log.d(TAG,"lastClickTime:" + lastClickTime);
                Log.d(TAG,"不是快速点击");
                Log.d(TAG,BLANK_LOG);
            }
            return false;
        }
    }
}
