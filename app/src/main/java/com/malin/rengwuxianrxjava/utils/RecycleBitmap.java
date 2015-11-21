package com.malin.rengwuxianrxjava.utils;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * @description 回收ImageView占用的图像内存;
 * @author malin.myemail@gmail.com
 * @since 15-11-21.
 * @link http://blog.csdn.net/intbird/article/details/19905549
 */

public class RecycleBitmap {
    /**
     * 回收ImageView占用的图像内存;
     * @param imageView
     */
    public static void recycleImageView(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap= ((BitmapDrawable) drawable).getBitmap();
            if (bitmap != null && !bitmap.isRecycled()) {
                imageView.setImageBitmap(null);
                bitmap.recycle();
                bitmap = null;
            }
        }
    }
}