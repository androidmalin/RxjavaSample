
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

package com.malin.rxjava.application;

import android.app.Application;


/**
 * 类描述:Application
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-12-16 上午11:00
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class RxJavaApplication extends Application {

    private static RxJavaApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static RxJavaApplication getApplication(){
        return application;
    }
}
