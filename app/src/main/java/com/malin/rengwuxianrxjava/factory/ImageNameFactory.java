
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

package com.malin.rengwuxianrxjava.factory;

import java.util.ArrayList;

/**
 * 类描述:获取图片文件夹类
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-11-10.
 * 备注:
 */
public class ImageNameFactory {

    private static final String FOLDER_NAME_ONE = "one";
    private static final String FOLDER_NAME_TWO = "two";
    private static final String FOLDER_NAME_THREE = "three";
    private static final String FOLDER_NAME_FOUR = "four";

    private ImageNameFactory() {
    }

    /**
     * 获取asset目录下的文件夹的名称集合
     *
     * @return
     */
    public static ArrayList<String> getAssetImageFolderName() {
        ArrayList<String> assetsFolderNameList = new ArrayList<>();
        assetsFolderNameList.add(FOLDER_NAME_ONE);
        assetsFolderNameList.add(FOLDER_NAME_TWO);
        assetsFolderNameList.add(FOLDER_NAME_THREE);
        assetsFolderNameList.add(FOLDER_NAME_FOUR);
        return assetsFolderNameList;
    }
}
