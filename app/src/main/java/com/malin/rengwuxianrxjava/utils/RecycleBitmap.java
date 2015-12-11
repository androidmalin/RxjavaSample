package com.malin.rengwuxianrxjava.utils;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * 类描述:回收ImageView占用的图像内存
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-11-21.
 * 版本:1.0.0
 * 备注:
 * 修改人:
 * 修改时间:
 * 修改备注:
 * 参考内容:http://blog.csdn.net/intbird/article/details/19905549
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
        if (drawable !=null &&drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable!=null){
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                    bitmap = null;
                    imageView.setImageBitmap(null);
                }
            }
        }
    }
}