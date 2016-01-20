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
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            mToast.show();
            mFirstTime = System.currentTimeMillis();
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