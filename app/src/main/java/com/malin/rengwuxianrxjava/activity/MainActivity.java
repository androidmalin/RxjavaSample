package com.malin.rengwuxianrxjava.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jakewharton.scalpel.ScalpelFrameLayout;
import com.malin.rengwuxianrxjava.R;
import com.malin.rengwuxianrxjava.constant.Constant;
import com.malin.rengwuxianrxjava.data.Course;
import com.malin.rengwuxianrxjava.data.DataFactory;
import com.malin.rengwuxianrxjava.data.ImageNameFactory;
import com.malin.rengwuxianrxjava.data.Student;
import com.malin.rengwuxianrxjava.utils.DeviceInfo;
import com.malin.rengwuxianrxjava.utils.ImageUtils;
import com.malin.rengwuxianrxjava.utils.RecycleBitmap;
import com.malin.rengwuxianrxjava.view.AvoidRecoveredAppearErrorImageView;
import com.orhanobut.logger.LogLevel;
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


/**
 * 类描述:活动主页面
 * 创建人:malin.myemail@gmail.com
 * 创建时间:15-11-10.
 * 备注:
 */
public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private static final String TAG_FOR_LOGGER = "MainActivity_I_LOVE_RXJAVA";
    private static final String JPG = ".jpg";
    private int mCounter;//循环的计数器
    private AvoidRecoveredAppearErrorImageView mImageView;
    private Bitmap mManyBitmapSuperposition = null;
    private Canvas mCanvas = null;
    private ProgressBar mProgressBar;
    private ScalpelFrameLayout mScalpelFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewLayout(true);
        initializeLogAndDeviceInfo();
//        miZhiSuoJinAndNestedLoopAndCallbackHell();//演示谜之缩进--嵌套循环--回调地狱
        rxJavaSolveMiZhiSuoJinAndNestedLoopAndCallbackHell();//使用RxJava解决问题
//        testFuncation(0);//RxJava基础概念的练习
    }

    /**
     * 初始化Logger日志输出配置和获取手机尺寸信息
     */
    private void initializeLogAndDeviceInfo() {
        Logger.init(TAG_FOR_LOGGER).logLevel(LogLevel.FULL);//Use LogLevel.NONE for the release versions.
        DeviceInfo.getInstance().initializeScreenInfo(this);
    }

    /**
     * 给Activity设置布局
     *
     * @param isOpenScalpe:是否开启使用Scalpel查看三维模式的层次结构
     */
    private void setContentViewLayout(boolean isOpenScalpe) {
        getWindow().setBackgroundDrawable(null);
        View view = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        if (isOpenScalpe) {
            mScalpelFrameLayout = new ScalpelFrameLayout(this);
            mScalpelFrameLayout.setLayerInteractionEnabled(true);//Enable the 3D interaction
            mScalpelFrameLayout.setDrawIds(true);//Toggle wireframe display
            mScalpelFrameLayout.setDrawIds(true);// Toggle view ID display
            mScalpelFrameLayout.addView(view);
            setContentView(mScalpelFrameLayout);
        } else {
            setContentView(view);
        }
    }


    /**
     * 用于显示图片的初始化
     */
    private void initView() {
        mImageView = (AvoidRecoveredAppearErrorImageView) findViewById(R.id.iv_image);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
    }


    /**
     * 故意让程序出现异常,可以用来测试
     */
    private void getException() {
        int errorCode = Integer.valueOf("故意让程序出错");
    }


    //-----------------------------------谜之缩进--嵌套循环--回调地狱 -----------------------------------------------------------

    /**
     * 实现的功能:获取assets文件夹下所有文件夹中的jpg图片,并且将所有的图片画到一个ImageView上,没有实际的用处,只是为了说明问题--- 谜之缩进--嵌套循环--回调地狱
     * 不使用RxJava的写法-- 谜之缩进--回调地狱
     */
    //思路:需要以下6个步骤完成
    //1:遍历获取assets文件夹下所有的文件夹的名称
    //2:遍历获取获取assets文件夹下某个文件夹中所有图片路径的集合
    //3:过滤掉非JPG格式的图片
    //4:获取某个路径下图片的bitmap
    //5:将Bitmap绘制到画布上
    //6:循环结束后更新UI,给ImageView设置最后绘制完成后的Bitmap,隐藏ProgressBar
    private void miZhiSuoJinAndNestedLoopAndCallbackHell() {
        initView();
        new Thread(new Runnable() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }
                });
                //1:遍历获取assets文件夹下所有的文件夹的名称
                ArrayList<String> assetsFolderNameList = ImageNameFactory.getAssetImageFolderName();

                for (String folderName : assetsFolderNameList) {

                    //2:遍历获取获取assets文件夹下某个文件夹中所有图片路径的集合
                    ArrayList<String> imagePathList = ImageUtils.getAssetsImageNamePathList(getApplicationContext(), folderName);

                    for (final String imagePathName : imagePathList) {
                        //3:过滤掉非JPG格式的图片
                        if (imagePathName.endsWith(JPG)) {

                            //4:获取某个路径下图片的bitmap
                            final Bitmap bitmap = ImageUtils.getImageBitmapFromAssetsFolderThroughImagePathName(getApplicationContext(), imagePathName, Constant.IMAGE_WITH, Constant.IMAGE_HEIGHT);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //Logger.d(mCounter + ":" + imagePathName);

                                    //5:将Bitmap绘制到画布上
                                    createSingleImageFromMultipleImages(bitmap, mCounter);
                                    mCounter++;

                                }
                            });
                        }
                    }
                }


                //6:循环结束后更新UI,给ImageView设置最后绘制完成后的Bitmap,隐藏ProgressBar
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.setImageBitmap(mManyBitmapSuperposition);
                        mProgressBar.setVisibility(View.GONE);
                    }
                });

            }
        }).start();
    }


    /**
     * 就是循环在画布上画图,呈现一种整齐的线性分布:像方格
     * 所有绘制都绘制到了创建Canvas时传入的Bitmap上面
     *
     * @param bitmap:每张图片对应的Bitamp
     * @param mCounter:一个自增的整数从0开始
     */
    //实现思路:
    //1:产生和手机屏幕尺寸同样大小的Bitmap
    //2:以Bitmap对象创建一个画布，将内容都绘制在Bitmap上,这个Bitmap用来存储所有绘制在Canvas上的像素信息.
    //3:这里将所有图片压缩成了相同的尺寸均为正方形图(64px*64px)
    //4:计算获取绘制每个Bitmap的坐标,距离屏幕左边和上边的距离,距离左边的距离不断自增,距离顶部的距离循环自增
    //5:将Bitmap画到指定坐标
    private void createSingleImageFromMultipleImages(Bitmap bitmap, int mCounter) {
        if (mCounter == 0) {
            //1:产生和手机屏幕尺寸同样大小的Bitmap
            mManyBitmapSuperposition = Bitmap.createBitmap(DeviceInfo.screenWidthForPortrait, DeviceInfo.screenHeightForPortrait, bitmap.getConfig());

            //2:以Bitmap对象创建一个画布，则将内容都绘制在Bitmap上
            mCanvas = new Canvas(mManyBitmapSuperposition);
        }
        if (mCanvas != null) {
            int left;//距离左边的距离
            int top;//距离顶部的距离

            //3:这里将所有图片压缩成了相同的尺寸均为正方形图(64px*64px)
            int imageWidth = Constant.IMAGE_WITH;
            int imageHeight = Constant.IMAGE_HEIGHT;
            int number = DeviceInfo.screenHeightForPortrait / imageHeight;//手机竖屏模式下,垂直方向上绘制图片的个数

            //4:计算获取绘制每个Bitmap的坐标,距离屏幕左边和上边的距离,距离左边的距离不断自增,距离顶部的距离循环自增
            if (mCounter >= (mCounter / number) * number && mCounter < (((mCounter / number) + 1) * number)) {//[0,number)
                left = (mCounter / number) * imageWidth;
                top = (mCounter % number) * imageHeight;
                // Log.d(TAG,""+mCounter+" left="+left+" top="+top);

                //5:将Bitmap画到指定坐标
                mCanvas.drawBitmap(bitmap, left, top, null);
            }
        }
    }


    /**
     * 用于测试除法和取余
     */
    private void showMath() {
        String TAG = "Math";
        for (int i = 0; i < 100; i++) {
            int ss = i / 10;
            int ww = i % 10;
            Log.d(TAG, i + "/10 ==" + ss);
            Log.d(TAG, i + "%10 ==" + ww);
        }
    }


    //-----------------------------------RxJava的实现--链式调用--十分简洁 -----------------------------------------------------------


    private void rxJavaSolveMiZhiSuoJinAndNestedLoopAndCallbackHell() {
        //1:被观察者:

        //2:数据转换

        //3:设置事件的产生发生在IO线程

        //4:设置事件的消费发生在主线程

        //5:观察者

        //6:订阅:被观察者被观察者订阅

        initView();
        mGoToRecycleImageView = false;
        Observable.from(ImageNameFactory.getAssetImageFolderName())
                //assets下一个文件夹的名称,assets下一个文件夹中一张图片的路径
                .flatMap(new Func1<String, Observable<String>>() {
                    @Override
                    public Observable<String> call(String folderName) {
                        return Observable.from(ImageUtils.getAssetsImageNamePathList(getApplicationContext(), folderName));
                    }
                })
                        //过滤,筛选出jpg图片
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String imagePathNameAll) {
                        return imagePathNameAll.endsWith(JPG);
                    }
                })
                        //将图片路径转换为对应图片的Bitmap
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String imagePathName) {
                        return ImageUtils.getImageBitmapFromAssetsFolderThroughImagePathName(getApplicationContext(), imagePathName, Constant.IMAGE_WITH, Constant.IMAGE_HEIGHT);
                    }
                })
                .map(new Func1<Bitmap, Void>() {
                    @Override
                    public Void call(Bitmap bitmap) {
                        createSingleImageFromMultipleImages(bitmap, mCounter);
                        mCounter++;
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
                        mImageView.setImageBitmap(mManyBitmapSuperposition);
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }
                });
    }


    //-----------------------------------------------0:RxJava基础练习-----------------------------------------------------------
    //概念解释
    //1:被观察者,事件源:它决定什么时候触发事件以及触发怎样的事件
    //2:观察者:它决定事件触发的时候将有怎样的行为
    //3:订阅
    private void method0() {

        //1:被观察者,事件源
        //概念解释:RxJava 使用 Observable.create() 方法来创建一个 Observable ，并为它定义事件触发规则
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("World");
                subscriber.onNext("!");
                subscriber.onCompleted();
                subscriber.onError(new Throwable());
                Logger.d("被观察者-observable->call()->onCompleted()之后是否还有输出");
            }
        });


        //2:观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Logger.d("观察者-observer:onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("观察者-observer:onError" + e.getMessage());
            }

            @Override
            public void onNext(String s) {
                Logger.d("观察者-observer:onNext():" + s);
            }
        };

        //3:订阅--被观察者被观察者订阅
        observable.subscribe(observer);
    }


    //---------------------------------------1:快捷创建事件队列 Observable.just(T...)--------------------------------------------------------------

    //简化:观察者的创建

    /**
     * 简化:观察者的创建
     * {@link #method0()}
     */
    private void method1() {


        //实现步骤
        //1:被观察者:
        //2:观察者:
        //3:订阅-被观察者被观察者订阅


        //1:被观察者:
        //just(T...): 将传入的参数依次发送出来
        Observable<String> observable = Observable.just("Hello", "World", "!");
        // 将会依次调用：
        // onNext("Hello");
        // onNext("World");
        // onNext("!");
        // onCompleted();


        //2:观察者:
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Logger.d("观察者-observer:onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("观察者-observer:onError()");
            }

            @Override
            public void onNext(String s) {
                Logger.d("观察者-observer:onNext():" + s);
            }
        };

        //3:订阅:被观察者被观察者订阅
        observable.subscribe(observer);
    }


    //---------------------------------------2:快捷创建事件队列 Observable.from(T[]) / from(Iterable<? extends T>--------------------------------------------------------------

    /**
     * 简化:观察者的创建
     * {@link #method1()}
     */
    private void method2() {

        //{@link #method()1}
        //实现步骤{@link #method()1}
        //1:被观察者
        //2:观察者
        //3:订阅-被观察者被观察者订阅


        String[] array = new String[]{"Hello", "World", "!"};
        //1:被观察者:
        //just(String[] array) 将传入的数组或 Iterable 拆分成具体对象后，依次发送出来。
        Observable observable = Observable.from(array);
        // 将会依次调用：
        // onNext("Hello");
        // onNext("World");
        // onNext("!");
        // onCompleted();


        //2:观察者
        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                Logger.d("观察者-observer:onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("观察者-observer:onError()");
            }

            @Override
            public void onNext(Object o) {
                String str = (String) o;
                Logger.d("观察者-observer:onNext():" + str);
            }
        };

        //3:订阅: 被观察者被观察者订阅
        observable.subscribe(observer);

    }

    //---------------------------------------3: subscribe()支持不完整定义的回调--------------------------------------------------------------

    /**
     * 对观察者的简化
     * {@link #method2()}
     * subscribe一个参数的不完整定义的回调
     * subscribe(final Action1<? super T> onNext)
     */
    private void method3() {

        String[] array = new String[]{"Hello", "World", "!"};
        //1:被观察者
        Observable observable = Observable.from(array);

        //2:观察者
        Action1 onNextAction = new Action1() {
            @Override
            public void call(Object o) {
                String str = (String) o;
                Logger.d("观察者:call(Object o):" + str);
            }
        };

        //3:订阅-被观察者被观察者订阅
        //subscribe(final Action1<? super T> onNext)
        //自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        observable.subscribe(onNextAction);
    }

    /**
     * 对观察者的简化
     * subscribe两个参数的不完整定义的回调
     * {@link #method3()}
     * subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError)
     */
    private void method4() {

        //1:被观察者
        Observable observable = Observable.from(new String[]{"Hello", "World", "!"});

        //2:观察者
        Action1 onNextAction = new Action1() {
            @Override
            public void call(Object o) {
                String str = (String) o;
                Logger.d("观察者:onNextAction:call(Object o):o:" + str);
            }
        };


        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.d("观察者:onErrorAction:call(Throwable throwable):" + throwable.getMessage());
            }
        };


        //3:订阅
        //subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError)
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable.subscribe(onNextAction, onErrorAction);


    }

    /**
     * subscribe三个参数的不完整定义的回调
     * subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError, final Action0 onComplete)
     */
    private void method5() {
        //1:被观察者
        Observable observable = Observable.from(new String[]{"Hello", "World", "!"});


        //2:观察者
        Action1 onNextAction = new Action1() {
            @Override
            public void call(Object o) {
                String str = (String) o;
                Logger.d("观察者:onNextAction:call():s:" + str);
            }
        };


        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Logger.d("观察者:onErrorAction:call(Throwable throwable):" + throwable.getMessage());
            }
        };


        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                Logger.d("观察者:onCompletedAction:call()");
            }
        };


        //3:订阅:被观察者被观察者订阅

        //subscribe(final Action1<? super T> onNext, final Action1<Throwable> onError, final Action0 onComplete)
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

    }

    //---------------------------------------4: Action0和Action1 讲解--------------------------------------------------------------
    /**
     * 肯定有同学对Action0和Action1很困惑,就像当初我刚看到那样子;
     * 那就听听仍物线给大家讲一下:
     *
     * MaLin:仍物线大哥,你能够给我们讲解一下Action0和Action1是什么,以及他们之间的区别吗?
     *
     * 扔物线:大家好,我简单的解释一下:
     * Action0 是 RxJava 的一个接口，它只有一个方法 call()，这个方法是无参无返回值的；
     * 由于 onCompleted() 方法也是无参无返回值的，因此 Action0 可以被当成一个包装对象，
     * 将 onCompleted() 的内容打包起来将自己作为一个参数传入 subscribe() 以实现不完整定义的回调。
     * 这样其实也可以看做将 onCompleted() 方法作为参数传进了 subscribe()，相当于其他某些语言中的『闭包』。
     *
     * Action1 也是一个接口，它同样只有一个方法 call(T param)，这个方法也无返回值，但有一个参数；
     * 与 Action0 同理，由于 onNext(T obj) 和 onError(Throwable error) 也是单参数无返回值的，
     * 因此 Action1 可以将 onNext(obj) 和 onError(error) 打包起来传入 subscribe() 以实现不完整定义的回调。
     * 事实上，虽然 Action0 和 Action1 在 API 中使用最广泛，但 RxJava 是提供了多个 ActionX 形式的接口 (例如 Action2, Action3) 的，
     * 它们可以被用以包装不同的无返回值的方法。
     */


    //---------------------------------------5: 休息一下!推荐两个好用的日志查看工具-------------------------------------------------------------

    //1.[logger](https://github.com/orhanobut/logger) | 一个简洁,优雅,功能强大的Android日志输出工具
    //2.[pidcat](https://github.com/JakeWharton/pidcat)|JakeWharton项目一个简洁,优雅的,彩色日志终端查看库|在终端过滤日志信息

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

    //---------------------------------------6 线程控制-Scheduler-------------------------------------------------------------

    /**
     * 显示图片
     * 后台线程取数据，主线程显示
     * 加载图片将会发生在 IO 线程，而设置图片则被设定在了主线程。这就意味着，即使加载图片耗费了几十甚至几百毫秒的时间，也不会造成丝毫界面的卡顿。
     */
    private void method6() {

        final int drawableRes = R.mipmap.malin;
        initView();
        Observable.create(new Observable.OnSubscribe<Drawable>() { //1:被观察者
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Logger.d("被观察者");
                Drawable drawable = getResources().getDrawable(drawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        })
                .subscribeOn(Schedulers.io())//事件产生的线程。指定 subscribe() 发生在 IO 线程
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//指定 Subscriber 所运行在的线程。或者叫做事件消费的线程
                .subscribe(new Subscriber<Drawable>() {   //3:订阅 //2:观察者
                    @Override
                    public void onCompleted() {
                        Logger.d("观察者 onCompleted()");
                        mProgressBar.setVisibility(View.GONE);
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

    //---------------------------------------7: 变换 map()-------------------------------------------------------------
    private void method7() {
        final int drawableRes = R.mipmap.malin;
        initView();

        //1:被观察者
        Observable.just(drawableRes)//输入类型 int
                .map(new Func1<Integer, Drawable>() {

                    @Override
                    public Drawable call(Integer integer) {// 参数类型 String
                        Logger.d("integer:" + integer);
                        return getResources().getDrawable(drawableRes);
                    }
                })

                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Drawable>() {  //3:订阅 //2:观察者
                    @Override
                    public void onCompleted() {
                        Logger.d("观察者:onCompleted()");
                        mProgressBar.setVisibility(View.GONE);
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

    //---------------------------------------8: 练习 中途休息一下-------------------------------------------------------------

    //演示嵌套循环
    private void method8() {
        ArrayList<Student> students = DataFactory.getData();
        int size = students.size();
        for (int i = 0; i < size; i++) {
            Logger.d("学生:" + students.get(i).name);
            for (int j = 0; j < students.get(i).courses.size(); j++) {
                Logger.d(students.get(i).courses.get(j).name);
            }
        }
    }


    /**
     * 嵌套循环的RxJava解决方案:
     * 输入学生的姓名
     * {@link #method8()}
     */
    private void method9() {

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


    /**
     * 嵌套循环的RxJava解决方案
     * 输出学生的课程
     * {@link #method8()}
     */
    private void method10() {

        //1:被观察者

        //2:数据转换

        //3:事件产生的线程。

        //4:事件消费的线程。

        //5:被观察者被观察者订阅

        //6:观察者

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


    private void method11() {
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

    //---------------------------------------9: 引入flatmap()-------------------------------------------------------------
    private void method12() {

        //1:被观察者

        //2:被观察者被观察者订阅

        //3:观察者

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


    private void method13() {

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

    //---------------------------------------10: flatMap()的使用-------------------------------------------------------------
    private void method14() {

        //1:被观察者

        //2:数据转换

        //3:事件产生的线程。

        //4:事件消费的线程。

        //5:被观察者被观察者订阅

        //6:观察者

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
     * 测试这些每个知识点的功能
     * @param number
     */
    private void testFuncation(int number) {
        switch (number) {
            case 0: {
                method0();
                break;
            }

            case 1: {
                method1();
                break;
            }

            case 2: {
                method2();
                break;
            }

            case 3: {
                method3();
                break;
            }

            case 4: {
                method4();
                break;
            }

            case 5: {
                method5();
                break;
            }

            case 6: {
                method6();
                break;
            }

            case 7: {
                method7();
                break;
            }

            case 8: {
                method8();
                break;
            }

            case 9: {
                method9();
                break;
            }

            case 10: {
                method10();
                break;
            }

            case 11: {
                method11();
                break;
            }

            case 12: {
                method12();
                break;
            }

            case 13: {
                method13();
                break;
            }

            case 14: {
                method14();
                break;
            }

            default: {

                break;
            }
        }
    }


    private boolean mGoToRecycleImageView = false;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d("onDestroy");
        //回收ImageView占用的图像内存
        if (mGoToRecycleImageView) {
            Logger.d("onDestroy()-> RecycleBitmap.recycleImageView(mImageView)");
            RecycleBitmap.recycleImageView(mImageView);
            mImageView.setImageBitmap(null);
        }

        if (mManyBitmapSuperposition != null && !mManyBitmapSuperposition.isRecycled()) {
            mManyBitmapSuperposition.recycle();
            mManyBitmapSuperposition = null;
        }

        //@link http://blog.csdn.net/yanzi1225627/article/details/8236309
        if (mCanvas != null) {
            //清屏
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            mCanvas.drawPaint(paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            mCanvas = null;
        }
        unBingListener(findViewById(R.id.rl_root_layout));
        unBindDrawables(findViewById(R.id.rl_root_layout));
    }


    /**
     * 做法也非常简单，在Activity onDestory时候从view的rootview开始，
     * 递归释放所有子view涉及的图片，背景，DrawingCache，监听器等等资源，
     * 让Activity成为一个不占资源的空壳，泄露了也不会导致图片资源被持有。
     *
     * @description Unbind the rootView
     * @param view:the root view of the layout
     * @author malin.myemail@gmail.com
     * @link http://stackoverflow.com/questions/9461364/exception-in-unbinddrawables
     * http://mp.weixin.qq.com/s?__biz=MzAwNDY1ODY2OQ==&mid=400656149&idx=1&sn=122b4f4965fafebf78ec0b4fce2ef62a&3rd=MzA3MDU4NTYzMw==&scene=6#rd
     * @since 2015.12.16
     */
    private void unBindDrawables(View view) {
        if (view != null) {
            Drawable drawable = view.getBackground();
            if (drawable != null) {
                drawable.setCallback(null);
            }else{
            }
            if (view instanceof ViewGroup && !(view instanceof AdapterView)) {
                ViewGroup viewGroup = (ViewGroup) view;
                int viewGroupChildCount = viewGroup.getChildCount();
                for (int j = 0; j < viewGroupChildCount; j++) {
                    unBindDrawables(viewGroup.getChildAt(j));
                }
                viewGroup.removeAllViews();
            }
        }
    }

    /**
     * 解除绑定
     * @param view
     */
    private void unBingListener(View view) {
        if (view != null) {
            view.setOnClickListener(null);
            if (view instanceof ViewGroup && !(view instanceof AdapterView)) {
                ViewGroup viewGroup = (ViewGroup) view;
                int viewGroupChildCount = viewGroup.getChildCount();
                for (int i = 0; i < viewGroupChildCount; i++) {
                    unBingListener(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
