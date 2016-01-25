
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

package com.malin.rengwuxianrxjava.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 类描述:防止Toast显示多次
 * 创建人:malin.myemail@gmail.com
 * 创建时间:16-01-20.下午17:50
 * 备注:
 */
public class ToastUtil {


    private static String mOldMessage = "";
    protected static Toast mToast = null;
    private static long mFirstTime = 0L;
    private static long mSecondTime = 0L;


    private volatile static ToastUtil instance;

    /**
     * Returns singleton class instance
     */
    public static ToastUtil getInstance() {
        if (instance == null) {
            synchronized (ToastUtil.class) {
                if (instance == null) {
                    instance = new ToastUtil();
                }
            }
        }
        return instance;
    }

    protected ToastUtil() {

    }


    public void showToast(Context context, String message) {
        if (mToast == null) {
            synchronized (ToastUtil.class) {
                if (mToast == null) {
                    mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
                    mToast.show();
                    mFirstTime = System.currentTimeMillis();
                }
            }

        } else {
            mSecondTime = System.currentTimeMillis();
            if (message.equals(mOldMessage)) {
                if (mSecondTime - mFirstTime > Toast.LENGTH_SHORT) {
                    mToast.show();
                }
            } else {
                mOldMessage = message;
                mToast.setText(message);
                mToast.show();
            }
        }
        mFirstTime = mSecondTime;
    }


    public void showToast(Context context, int resId) {
        showToast(context, context.getString(resId));
    }


}