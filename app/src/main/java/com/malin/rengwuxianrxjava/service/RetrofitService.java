
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

package com.malin.rengwuxianrxjava.service;


import com.malin.rengwuxianrxjava.githubapi.GitHubApi;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * 类描述:RetrofitService
 * 创建人:malin.myemail@gmail.com
 * 创建时间:16-1-24
 * 备注:{@link https://github.com/basil2style/Retrofit-Android-Basic} Thanks for  ,Her code is very good ! I made reference to his code,It saves me a lot of time!
 * 修改人:
 * 修改时间:
 * 修改备注:
 */
public class RetrofitService {
    private static final String API = "https://api.github.com";

    protected RetrofitService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private volatile static RetrofitService instance = null;

    private Retrofit retrofit;

    public static RetrofitService getInstance() {
        if (instance == null) {
            synchronized (RetrofitService.class) {
                if (instance == null) {
                    instance = new RetrofitService();
                }
            }
        }
        return instance;
    }

    public <T> T createService(Class<T> clz){
        return retrofit.create(clz);
    }

}
