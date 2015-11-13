package com.malin.rengwuxianrxjava.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.malin.rengwuxianrxjava.R;
import com.malin.rengwuxianrxjava.constant.Constant;
import com.malin.rengwuxianrxjava.data.Course;
import com.malin.rengwuxianrxjava.data.DataFactory;
import com.malin.rengwuxianrxjava.data.ImageNameFactory;
import com.malin.rengwuxianrxjava.data.Student;
import com.malin.rengwuxianrxjava.utils.DeviceInfo;
import com.malin.rengwuxianrxjava.utils.ImageUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class MainActivity extends Activity {
    private static final String TAG = "Reng_wu_xian";
    private static final String TAG_FOR_LOGGER = "I_LOVE_RXJAVA";
    private int counter;
    private ImageView mImageView;
    private Bitmap manyBitmapSuperposition = null;
    private Canvas canvas = null;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.init(TAG_FOR_LOGGER);
        setContentView(R.layout.activity_main);
        DeviceInfo.getInstance().initScreenInfo(this);
        miZhiSuoJin();
//        rxJavaVeryCool();
//        show();
//        fun0();
//        fun1();
//        fun2();
//        fun3();
//        fun4();
//        fun5();
//        fun6();
//        fun7();
//        fun8();
//        fun9();
//        fun10();
//        fun11();
//        fun12();
//        fun13();
//        fun14();
    }

    //-----------------------------------TODO:谜之缩进--嵌套循环--回调地狱 -----------------------------------------------------------
    /**
     * 实现的功能:输出asset文件夹下所有文件夹中的png图片的信息,没有实际的用处,只是为了说明问题--- 谜之缩进--嵌套循环--回调地狱
     * RxJava 初体验
     * 不使用RxJava的写法-- 谜之缩进--回调地狱
     */

    private void miZhiSuoJin() {
        initView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> assetsFolderNameList = ImageNameFactory.getAssetImageFolderName();
                for (String folderName : assetsFolderNameList) {
                    ArrayList<String> imagePathList = ImageUtils.getAssetsImageNamePathList(getApplicationContext(), folderName);
                    for (final String imagePathName : imagePathList) {
                        if (imagePathName.endsWith(".jpg")) {
                            final Bitmap bitmap = ImageUtils.getImageBitmapFromAssetsFolderThroughImagePathName(getApplicationContext(), imagePathName);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Logger.d(counter + ":" + bitmap.toString());
                                    Logger.d(counter+":"+imagePathName);
                                    createSingleImageFromMultipleImages(bitmap, counter);
                                    counter++;

                                }
                            });
                        }
                    }
                }


                //TODO:循环结束后
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.setImageBitmap(manyBitmapSuperposition);
                        mProgressBar.setVisibility(View.GONE);
                    }
                });

            }
        }).start();
    }


    /**
     * 就是循环在画布上画图,呈现一种整齐的线性分布:像方格
     * @param bitmap:每张图片对应的Bitamp
     * @param counter:一个自增的整数从0开始
     */
    private void createSingleImageFromMultipleImages(Bitmap bitmap,int counter){
        if (counter==0){
            manyBitmapSuperposition = Bitmap.createBitmap(DeviceInfo.screenWidthForPortrait, DeviceInfo.screenHeightForPortrait, bitmap.getConfig());
            canvas = new Canvas(manyBitmapSuperposition);
        }
        if (canvas!=null){
            int left;//距离左边的距离
            int top;//距离顶部的距离
            int imageWidth = Constant.imageWith;
            int imageHeight = Constant.imageHeight;
            int number = DeviceInfo.screenHeightForPortrait/imageWidth;//10
            if (counter>=(counter/number)*number&&counter<(((counter/number)+1)*number)){//[0,10)
                left = (counter/number)*imageWidth;
                top =(counter%number)*imageHeight;
                Log.d(TAG,""+counter+" left="+left+" top="+top);
                canvas.drawBitmap(bitmap, left, top, null);
            }
        }
    }


    /**
     * 用于测试除法和取余
     */
    private void showMath(){
        String TAG = "Math";
        for (int i = 0;i<100;i++){
            int ss = i/10;
            int ww = i%10;
            Log.d("gggg",i+"/10 =="+ss);
            Log.d("wwww",i+"%10 =="+ww);
        }
    }


    /**
     * 这个方法是对createSingleImageFromMultipleImages()方法的分部解释
     * @param bitmap
     * @param counter
     */
    private void createSingleImageFromMultipleImagesDetail(Bitmap bitmap,int counter){
        if (counter==0){
            manyBitmapSuperposition = Bitmap.createBitmap(DeviceInfo.screenWidthForPortrait, DeviceInfo.screenHeightForPortrait, bitmap.getConfig());
            canvas = new Canvas(manyBitmapSuperposition);
        }
        if (canvas!=null){
            int left = 0;
            int top = 0;
            int imageWidth = 192;
            int number = DeviceInfo.screenHeightForPortrait/imageWidth;//10
            if (counter>=0&&counter<number){//[0,10)
                //TODO:0:
                left = 0;
                top = counter*imageWidth;

            }else if (counter>=number&&counter<2*number){//[10,19]
                //TODO:1:
                left = imageWidth;
                top = (counter-number)*imageWidth;

            }else if (counter>=2*number&&counter<3*number){//[20,29]
                //TODO:2:
                left = 2*imageWidth;
                top = (counter-2*number)*imageWidth;

            }else if (counter>=3*number&&counter<4*number){//[30,49]
                //TODO:3:
                left = 3*imageWidth;
                top = (counter-3*number)*imageWidth;

            }else if (counter>=4*number&&counter<5*number){//[40,59]
                //TODO:4:
                left = 4*imageWidth;
                top = (counter-4*number)*imageWidth;

            }else if (counter>=5*number&&counter<6*number){//[60,69]
                //TODO:5:
                left = 5*imageWidth;
                top = (counter-5*number)*imageWidth;

            }else if (counter>=6*number&&counter<7*number){//[70,79]
                //TODO:6:
                left = 6*imageWidth;
                top = (counter-6*number)*imageWidth;

            }else if (counter>=7*number&&counter<8*number){//[80,89]
                //TODO:7:
                left = 7*imageWidth;
                top = (counter-7*number)*imageWidth;

            }else if (counter>=8*number&&counter<9*number){//[90,99]
                //TODO:8:
                left = 8*imageWidth;
                top = (counter-8*number)*imageWidth;
            }
            canvas.drawBitmap(bitmap, left, top, null);
        }
    }



    //-----------------------------------TODO:RxJava的实现--链式调用--十分简洁 -----------------------------------------------------------
    /**
     * fun000():使用RxJava实现
     */
    private void rxJavaVeryCool0(){
        //TODO:1:被观察者:

        //TODO:2:数据转换

        //TODO:3:设置事件的产生发生在IO线程

        //TODO:4:设置事件的消费发生在主线程

        //TODO:5:观察者

        //TODO:6:订阅:被观察者被观察者订阅

        initView();
        Observable.from(ImageNameFactory.getAssetImageFolderName())
                //asset下一个文件夹的名称,asset下一个文件夹中一张图片的路径
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String folderName) {
                        return Observable.from(ImageUtils.getAssetsImageNamePathList(getApplicationContext(), folderName));
                    }
                })
                        //过滤,筛选出png图片
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String imagePathNameAll) {
                        return imagePathNameAll.endsWith(".jpg")||imagePathNameAll.endsWith(".png");
                    }
                })
                        //将图片路径转换为对应图片的Bitmap
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String imagePathName) {
                        return ImageUtils.getImageBitmapFromAssetsFolderThroughImagePathName(getApplicationContext(), imagePathName);
                    }
                })
                .subscribeOn(Schedulers.io())//设置事件的产生发生在IO线程
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        //TODO:显示进度条


                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//设置事件的消费发生在主线程
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {
                        mImageView.setImageBitmap(manyBitmapSuperposition);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "Error:"+e.getMessage(), Toast.LENGTH_SHORT).show();
                        Logger.d("Error:"+e.getMessage());
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        // Logger.d("观察者:onNext(Bitmap bitmap) " + counter + ":" + bitmap.toString());
                        createSingleImageFromMultipleImages(bitmap, counter);
                        counter++;
                    }
                });
    }

    private void rxJavaVeryCool(){
        //TODO:1:被观察者:

        //TODO:2:数据转换

        //TODO:3:设置事件的产生发生在IO线程

        //TODO:4:设置事件的消费发生在主线程

        //TODO:5:观察者

        //TODO:6:订阅:被观察者被观察者订阅

        initView();
        Observable.from(ImageNameFactory.getAssetImageFolderName())
                //asset下一个文件夹的名称,asset下一个文件夹中一张图片的路径
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String folderName) {
                        return Observable.from(ImageUtils.getAssetsImageNamePathList(getApplicationContext(), folderName));
                    }
                })
                //过滤,筛选出png图片
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String imagePathNameAll) {
                        return imagePathNameAll.endsWith(".jpg")||imagePathNameAll.endsWith(".png");
                    }
                })
                //将图片路径转换为对应图片的Bitmap
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String imagePathName) {
                        return ImageUtils.getImageBitmapFromAssetsFolderThroughImagePathName(getApplicationContext(), imagePathName);
                    }
                })
                .map(new Func1<Bitmap, Void>() {
                    @Override
                    public Void call(Bitmap bitmap) {
                        createSingleImageFromMultipleImages(bitmap, counter);
                        counter++;
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())//设置事件的产生发生在IO线程
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//设置事件的消费发生在主线程
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        mImageView.setImageBitmap(manyBitmapSuperposition);
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }
                });
    }


//-----------------------------------------------//TODO:RxJava基础练习-----------------------------------------------------------
    //TODO:概念解释
    //TODO:被观察者,事件源:它决定什么时候触发事件以及触发怎样的事件
    //TODO:观察者:它决定事件触发的时候将有怎样的行为
    //TODO:订阅
    private void fun0() {

        //TODO:1:被观察者,事件源
        // Observable 即被观察者，它决定什么时候触发事件以及触发怎样的事件。 RxJava 使用 create() 方法来创建一个 Observable ，并为它定义事件触发规则：
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("World");
                subscriber.onNext("!");
                subscriber.onCompleted();
                subscriber.onError(new Throwable());
            }
        });


        //TODO:2:观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "观察者-observer:onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "观察者-observer:onError" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "观察者-observer:onNext():" + s);

            }
        };

        //TODO:3:订阅--被观察者被观察者订阅
        observable.subscribe(observer);
    }


    //---------------------------------------TODO:1:快捷创建事件队列 Observable.just(T...)--------------------------------------------------------------
    private void fun1() {


        //TODO:1:被观察者:
        //TODO:2:观察者:
        //TODO:3:订阅-被观察者被观察者订阅


        //TODO:1:被观察者:
        //just(T...): 将传入的参数依次发送出来
        Observable<String> observable = Observable.just("Hello", "World", "!");
        // 将会依次调用：
        // onNext("Hello");
        // onNext("World");
        // onNext("!");
        // onCompleted();


        //TODO:2:观察者:
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "观察者-observer:onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "观察者-observer:onError()");
            }

            @Override
            public void onNext(String s) {

                Log.d(TAG, "观察者-observer:onNext():" + s);
            }
        };

        //TODO:3:订阅:被观察者被观察者订阅
        observable.subscribe(observer);
    }

    //---------------------------------------TODO:2:快捷创建事件队列 Observable.from(T[]) / from(Iterable<? extends T>--------------------------------------------------------------
    private void fun2() {

        //TODO:1:被观察者
        //TODO:2:观察者
        //TODO:3:订阅-被观察者被观察者订阅


        String[] array = new String[]{"Hello", "World", "!"};
        //TODO:1:被观察者:
        //just(String[] array) 将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
        Observable observable = Observable.from(array);
        // 将会依次调用：
        // onNext("Hello");
        // onNext("World");
        // onNext("!");
        // onCompleted();


        //TODO:2:观察者
        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "观察者-observer:onCompleted()");
            }

            @Override
            public void onError(Throwable e) {

                Log.d(TAG, "观察者-observer:onError()");
            }

            @Override
            public void onNext(Object o) {
//                Log.d(TAG,"观察者-observer:onNext():"+o.toString());


                String str = (String) o;
                Log.d(TAG, "观察者-observer:onNext():" + str);
            }
        };

        //TODO:3:订阅: 被观察者被观察者订阅
        observable.subscribe(observer);

    }

    //---------------------------------------TODO:3: subscribe()支持不完整定义的回调--------------------------------------------------------------
    /**
     * 对fun2()的简化
     * subscribe一个参数的不完整定义的回调
     * subscribe(final Action1<? super T> onNext)
     */
    private void fun3() {
        String[] array = new String[]{"Hello", "World", "!"};
        //TODO:1:被观察者
        Observable observable = Observable.from(array);

        //TODO:2:观察者
        Action1 onNextAction = new Action1() {
            @Override
            public void call(Object o) {

                String str = (String) o;
                Log.d(TAG, "观察者:call(Object o):" + str);
            }
        };


        //TODO:3:订阅-被观察者被观察者订阅
        //subscribe(final Action1<? super T> onNext)
        //自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        observable.subscribe(onNextAction);

    }


    /**
     * subscribe两个参数的不完整定义的回调
     * subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError)
     */
    private void fun4() {

        //TODO:1:被观察者
        Observable observable = Observable.from(new String[]{"Hello", "World", "!"});

        //TODO:2:观察者
        Action1 onNextAction = new Action1() {
            @Override
            public void call(Object o) {

                String str = (String) o;

                Log.d(TAG, "观察者:onNextAction:call(Object o):o:" + str);
            }
        };


        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {

                Log.d(TAG, "观察者:onErrorAction:call(Throwable throwable):" + throwable.getMessage());
            }
        };


        //TODO:3:订阅
        //subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError)
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable.subscribe(onNextAction, onErrorAction);


    }

    /**
     * subscribe三个参数的不完整定义的回调
     * subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError, final Action0 onComplete)
     */
    private void fun5() {
        //TODO:1:被观察者
        Observable observable = Observable.from(new String[]{"Hello", "World", "!"});


        //TODO:2:观察者
        Action1 onNextAction = new Action1() {
            @Override
            public void call(Object o) {

                String str = (String) o;
                Log.d(TAG, "观察者:onNextAction:call():s:" + str);
            }
        };


        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "观察者:onErrorAction:call(Throwable throwable):" + throwable.getMessage());
            }
        };


        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                Log.d(TAG, "观察者:onCompletedAction:call()");
            }
        };


        //TODO:3:订阅:被观察者被观察者订阅

        //subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError, final Action0 onComplete)
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

    }


    /**
     * 显示图片
     * 后台线程取数据，主线程显示
     */

    /**
     * 使用com.github.orhanobut:logger 库可以查看当前的线程
     *  ╔════════════════════════════════════════════════════════════════════════════════════════
     D  ║ Thread: main
     D  ╟────────────────────────────────────────────────────────────────────────────────────────
     D  ║ MainActivity$11.onNext  (MainActivity.java:338)
     D  ║    MainActivity$11.onNext  (MainActivity.java:354)
     D  ╟────────────────────────────────────────────────────────────────────────────────────────
     D  ║ 观察者 onNext()
     D  ╚════════════════════════════════════════════════════════════════════════════════════════
     D  ╔════════════════════════════════════════════════════════════════════════════════════════
     D  ║ Thread: main
     D  ╟────────────────────────────────────────────────────────────────────────────────────────
     D  ║ SafeSubscriber.onCompleted  (SafeSubscriber.java:83)
     D  ║    MainActivity$11.onCompleted  (MainActivity.java:341)
     D  ╟────────────────────────────────────────────────────────────────────────────────────────
     D  ║ 观察者 onCompleted()
     D  ╚════════════════════════════════════════════════════════════════════════════════════════

     */

    //---------------------------------------TODO:3: 线程控制-Scheduler-------------------------------------------------------------
    /**
     * 加载图片将会发生在 IO 线程，而设置图片则被设定在了主线程。这就意味着，即使加载图片耗费了几十甚至几百毫秒的时间，也不会造成丝毫界面的卡顿。
     */
    private void fun6() {

        final int drawableRes = R.mipmap.rengwuxian;
        initView();
        Observable.create(new Observable.OnSubscribe<Drawable>() { //TODO:1:被观察者
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Logger.d("被观察者");
                Drawable drawable = getResources().getDrawable(drawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())//事件产生的线程。指定 subscribe() 发生在 IO 线程
                .observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 所运行在的线程。或者叫做事件消费的线程
                .subscribe(new Subscriber<Drawable>() {   //TODO:3:订阅 //TODO:2:观察者
                    @Override
                    public void onCompleted() {
                        Logger.d("观察者 onCompleted()");
                        Toast.makeText(MainActivity.this, "观察者 onCompleted()", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("观察者 onError()");
                        Toast.makeText(MainActivity.this, "观察者 onError() " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        Toast.makeText(MainActivity.this, "观察者 onNext()", Toast.LENGTH_SHORT).show();
                        Logger.d("观察者 onNext()");
                        mImageView.setImageDrawable(drawable);
                    }
                });

    }

    //---------------------------------------TODO:4: 变换 map()-------------------------------------------------------------
    private void fun7() {
        final int drawableRes = R.mipmap.rengwuxian;
        initView();

        //TODO:1:被观察者
        Observable.just(drawableRes)//输入类型 int
                .map(new Func1<Integer, Drawable>() {

                    @Override
                    public Drawable call(Integer integer) {// 参数类型 String
                        Logger.d("integer:" + integer);
                        return getResources().getDrawable(drawableRes);
                    }
                })

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Drawable>() {  //TODO:3:订阅 //TODO:2:观察者
                    @Override
                    public void onCompleted() {
                        Logger.d("观察者:onCompleted()");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        Logger.d("观察者:onError(Throwable e):" + e.getMessage());
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        Logger.d("观察者:onNext(Drawable drawable):" + drawable.toString());
                        mImageView.setImageDrawable(drawable);
                    }
                });
    }

    //---------------------------------------TODO:5: 练习 中途休息一下-------------------------------------------------------------
    private void fun8() {
        ArrayList<Student> stu = DataFactory.getData();
        for (int i = 0; i < stu.size(); i++) {
            Logger.d("学生:" + stu.get(i).name);
            for (int j = 0; j < stu.get(i).courses.size(); j++) {
                Logger.d(stu.get(i).courses.get(j).name);
            }
        }
    }


    private void fun9() {

        Observable.from(DataFactory.getData())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Student>() {
                    @Override
                    public void call(Student student) {
                        Logger.d("观察者:" + student.name);
                    }
                });
    }


    private void fun10() {

        //TODO:1:被观察者

        //TODO:2:数据转换

        //TODO:3:事件产生的线程。

        //TODO:4:事件消费的线程。

        //TODO:5:被观察者被观察者订阅

        //TODO:6:观察者

        Observable.from(DataFactory.getData())

                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.name;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("观察者:onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("观察者:onError(Throwable e)  " + e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {

                        Logger.d("观察者:onNext(String s) " + s);
                    }
                });

    }


    private void fun11() {
        Observable.from(DataFactory.getData())
                .map(new Func1<Student, String>() {
                    @Override
                    public String call(Student student) {
                        return student.name;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Logger.d("观察者:" + s);
                    }
                });

    }

    //---------------------------------------TODO:6: 引入flatmap()-------------------------------------------------------------
    private void fun12() {

        //TODO:1:被观察者

        //TODO:2:被观察者被观察者订阅

        //TODO:3:观察者

        Observable.from(DataFactory.getData())
                .subscribe(new Subscriber<Student>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("观察者:onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.d("观察者:onError(Throwable e)" + e.getMessage());
                    }

                    @Override
                    public void onNext(Student student) {
                        ArrayList<Course> courses = student.courses;
                        for (Course course : courses) {
                            Logger.d("观察者:" + course.name);
                        }
                    }
                });

    }


    private void fun13() {

        Observable.from(DataFactory.getData())

                .map(new Func1<Student, ArrayList<Course>>() {

                    @Override
                    public ArrayList<Course> call(Student student) {
                        return student.courses;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArrayList<Course>>() {
                    @Override
                    public void call(ArrayList<Course> courses) {

                        for (int i = 0; i < courses.size(); i++) {
                            Logger.d("观察者:" + courses.get(i).name);
                        }
                    }
                });
    }

    //---------------------------------------TODO:6: flatMap()的使用-------------------------------------------------------------
    private void fun14() {

        //TODO:1:被观察者

        //TODO:2:数据转换

        //TODO:3:事件产生的线程。

        //TODO:4:事件消费的线程。

        //TODO:5:被观察者被观察者订阅

        //TODO:6:观察者

        Observable.from(DataFactory.getData())
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        return Observable.from(student.courses);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Course>() {
                    @Override
                    public void call(Course course) {
                        Logger.d("观察者:" + course.name);
                    }
                });
    }



    /**
     * 用于显示图片的初始化
     */
    private void initView() {
        mImageView = (ImageView) findViewById(R.id.iv_image);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
    }


    /**
     * 故意让程序出现异常,可以用来测试
     */
    private void getException() {
        int errorCode = Integer.valueOf("故意让程序保存的");
    }
}
