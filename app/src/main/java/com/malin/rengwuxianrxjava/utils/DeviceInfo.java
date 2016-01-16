package com.malin.rengwuxianrxjava.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * 类描述:手机设备的信息
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-11-10.下午3:26
 * 备注:
 * 参考项目:Android-Universal-Image-Loader
 */
public class DeviceInfo {

    public static int screenWidthForPortrait;   // 屏幕宽度
    public static int screenHeightForPortrait;  // 屏幕高度
    public static float mDensity;
    public static int mDensityDpi;


    private volatile static DeviceInfo instance;

    /**
     * Returns singleton class instance
     */
    public static DeviceInfo getInstance() {
        if (instance == null) {
            synchronized (DeviceInfo.class) {
                if (instance == null) {
                    instance = new DeviceInfo();
                }
            }
        }
        return instance;
    }

    protected DeviceInfo() {

    }


    /**
     * init get device information
     *
     * @param activity
     */
    public void initializeScreenInfo(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        mDensity = metric.density;
        mDensityDpi = metric.densityDpi;
        if (metric.heightPixels >= metric.widthPixels) {
            screenWidthForPortrait = metric.widthPixels;
            screenHeightForPortrait = metric.heightPixels;
        } else {
            screenWidthForPortrait = metric.heightPixels;
            screenHeightForPortrait = metric.widthPixels;
        }
    }
}
