package com.malin.rengwuxianrxjava.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * 手机设备的信息
 * @author malin
 *
 */
public class DeviceInfo {

    public static int screenWidthForPortrait;   // 屏幕宽度
    public static int screenHeightForPortrait;  // 屏幕高度


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
     * 初始化手机设备信息
     * @param activity
     */
    public void initScreenInfo(Activity activity) {

        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        if (metric.heightPixels >= metric.widthPixels) {
            screenWidthForPortrait = metric.widthPixels;
            screenHeightForPortrait = metric.heightPixels;
        } else {
            screenWidthForPortrait = metric.heightPixels;
            screenHeightForPortrait = metric.widthPixels;
        }
    }
}
