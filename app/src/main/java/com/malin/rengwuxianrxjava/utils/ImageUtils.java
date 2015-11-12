package com.malin.rengwuxianrxjava.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author malin
 * @data 15-11-11.
 */
public class ImageUtils {

    /**
     * 从assets文件夹中获取制定路径的图片的Bitmap
     * @param context:上下文
     * @param imagePathName:图片路径的名称:例如: paowuxian/04.jpg
     * @return
     */
    public static Bitmap getImageBitmapFromAssetsFolderThroughImagePathName(Context context, String imagePathName) {
        Bitmap bitmap = null;
        AssetManager assetManager = context.getResources().getAssets();
        InputStream is = null;
        try {
            is = assetManager.open(imagePathName);
            if (is!=null){
                bitmap = BitmapFactory.decodeStream(is);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            try {
                if (is!=null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmap.createScaledBitmap(bitmap,DeviceInfo.screenWidthForPortrait/12,DeviceInfo.screenWidthForPortrait/12,true);
    }


    /**
     * 获取asset下某个文件夹中所有图片路径的集合
     *
     * 例如:assets/paowuxian 这个目录下的图片路径的集合
     * {
     *      paowuxian/04.jpg,
     *      paowuxian/05.jpg,
     *      paowuxian/06.jpg,
     *      paowuxian/07.jpg,
     *
     * }
     *
     * @param context:上下文
     * @param folderName:文件夹名称
     * @return
     */
    public static ArrayList<String> getAssetsImageNamePathList(Context context, String folderName) {

        ArrayList<String> imagePathList = new ArrayList<String>();

        String[] imageNameArray = getAssetsImageNameArray(context, folderName);

            if (imageNameArray != null && imageNameArray.length > 0 && folderName != null && !folderName.replaceAll(" ", "").trim().equals("")) {
                for (String imageName : imageNameArray) {
                    imagePathList.add(new StringBuffer(folderName).append(File.separator).append(imageName).toString());
                }
            }

        return imagePathList;
    }


    /**
     * 得到assets文件夹下--某个文件夹下--所有文件的文件名
     * 例如:assets/paowuxian 这个目录下的图片名称(包含后缀)集合
     * {
     *      04.jpg,
     *      05.jpg,
     *      06.jpg,
     *      07.jpg,
     * }
     *
     * @param context:上下文
     * @param folderName:文件夹名称
     * @return
     */
    private static String[] getAssetsImageNameArray(Context context, String folderName) {
        String[] imageNameArray = null;
        try {
            imageNameArray = context.getAssets().list(folderName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageNameArray;
    }
}
