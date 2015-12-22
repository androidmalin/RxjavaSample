package com.malin.rengwuxianrxjava.factory;

import java.util.ArrayList;

/**
 * 类描述:获取图片文件夹类
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-11-10.
 * 备注:
 */
public class ImageNameFactory {

    private static final String FOLDER_NAME_ONE = "guangtouge";
    private static final String FOLDER_NAME_TWO = "paowuxian";
    private static final String FOLDER_NAME_THREE = "rengwuxian";
    private static final String FOLDER_NAME_FOUR = "thisisdaimajiagirlfriends";

    /**
     * 获取asset目录下的文件夹的名称集合
     *
     * @return
     */
    public static ArrayList<String> getAssetImageFolderName() {
        ArrayList<String> assetsFolderNameList = new ArrayList<String>();
        assetsFolderNameList.add(FOLDER_NAME_ONE);
        assetsFolderNameList.add(FOLDER_NAME_TWO);
        assetsFolderNameList.add(FOLDER_NAME_THREE);
        assetsFolderNameList.add(FOLDER_NAME_FOUR);
        return assetsFolderNameList;
    }
}
