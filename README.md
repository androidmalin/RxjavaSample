# 用Rxjava实现代码家和他的男女闺蜜
扔物线[给Android开发者的RxJava详解](http://gank.io/post/560e15be2dca930e00da1083)文章中的例子
<!--<div><img src='https://github.com/androidmalin/RengwuxianRxjava/blob/master/app/src/main/res/mipmap-xhdpi/rengwuxian.jpg' width="80px" style='border: #f1f1f1 solid 1px'/></div>-->

###说明
最近正好有时间,边读文章,边将文章中的例子敲成代码.因为接触时间不长,代码中难免有些问题,希望大家可以给予指导和帮助.<br/>

### 特别致谢
[扔物线](https://github.com/rengwuxian)在百忙之中的周末给Review代码,以及对我的鼓励<br/>
[汤涛](http://mp.weixin.qq.com/s?__biz=MzA4MjU5NTY0NA==&mid=400871360&idx=1&sn=ed438babc92bcca912f0f097f46fcf70&scene=1&srcid=1201fX7dBmzWopPQwaue5OKg&from=groupmessage&isappinstalled=0#wechat_redirect)在百忙之中的傍晚给Review代码,提了很多代码规范上的建议,以及对我的夸奖<br/>
[秋百万](https://github.com/liaohuqiu)对我的鼓励,使我坚持不断的修改代码<br/>

###APK下载

二维码下载
<div><img src='https://github.com/androidmalin/RengwuxianRxjava/blob/master/qrcode/dowload_qrcode.png' width="300px" style='border: #f1f1f1 solid 1px'/></div>

[APK备用下载地址](http://fir.im/rengwuxianrxjava)

### 截图--代码家和他的男女闺蜜们

<div><img src='https://github.com/androidmalin/RengwuxianRxjava/blob/master/screenshots/daimajia_girl_friends_team.png' width="300px" style='border: #f1f1f1 solid 1px'/></div>

### 视频演示

[视频在线播放地址](http://video.weibo.com/show?fid=1034:a6434cc89dc75f1444dac67ff22c1153)<br/>



<!--### 链接-->
<!--[扔物线 给Android开发者的RxJava详解](http://gank.io/post/560e15be2dca930e00da1083)<br/>-->
<!--[扔物线Github主页](https://github.com/rengwuxian)<br/>-->
<!--[扔物线博客](http://www.rengwuxian.com)<br/>-->
<!--[扔物线Dagger源码解析](http://a.codekk.com/detail/Android/%E6%89%94%E7%89%A9%E7%BA%BF/Dagger%20%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90)<br/>-->
<!--[扔物线《埋头苦干的一年》](https://github.com/aosp-exchange-group/fuck-2014-flirt-2015/blob/master/1/rengwuxian.md)<br/>-->
<!--[秋百万诗歌欣赏](http://weibo.com/p/1001603907193945642719)<br/>-->
<!--[效果视频在线播放地址](http://video.weibo.com/show?fid=1034:a6434cc89dc75f1444dac67ff22c1153)<br/>-->


### 项目依赖

项目名称 | 项目信息
------- | -------
[android.support.*](https://developer.android.com/tools/support-library/index.html) | Android Support Library
[RxJava](https://github.com/ReactiveX/RxJava) | 一个在 Java VM 上使用可观测的序列来组成异步的、基于事件的程序的库
[RxAndroid](https://github.com/ReactiveX/RxAndroid) | RxAndroid 是 RxJava 的一个针对 Android 平台的扩展
[logger](https://github.com/orhanobut/logger) | 一个简洁,优雅,功能强大的Android日志输出工具
[scalpel](https://github.com/JakeWharton/scalpel) | JakeWharton布局层次结构的三维效果展示

### 使用到的开源项目
项目名称 | 项目信息| 参考的地方
------- | -------| -------
[Android-Universal-Image-Loader](https://github.com/nostra13/Android-Universal-Image-Loader) | Powerful and flexible library for loading, caching and displaying images on Android | singleton class
[pidcat](https://github.com/JakeWharton/pidcat)|JakeWharton项目一个简洁,优雅的,彩色日志终端查看库|在终端过滤日志信息
[phphub-android](https://github.com/CycloneAxe/phphub-android/blob/master/README.md)| [PHPHub](https://phphub.org/) Android 客户端|参考了README.md的写法

### 参考的文章
作者 | 文章| 参考的地方
------- | -------| -------
[扔物线](https://github.com/rengwuxian) | [给Android开发者的RxJava详解](http://gank.io/post/560e15be2dca930e00da1083) | 示例代码
[胡凯](https://github.com/kesenhoo) | [ 高效加载大图](http://hukai.me/android-training-course-in-chinese/graphics/displaying-bitmaps/load-bitmap.html) | Bitmap压缩算法
[intbird](http://blog.csdn.net/intbird) | [Android OOM ,回收布局文件中ImageView占用的内存.Bitmap OOM回收解决.](http://blog.csdn.net/intbird/article/details/19905549) | Bitmap回收
[汤涛](http://mp.weixin.qq.com/s?__biz=MzA4MjU5NTY0NA==&mid=400871360&idx=1&sn=ed438babc92bcca912f0f097f46fcf70&scene=1&srcid=1201fX7dBmzWopPQwaue5OKg&from=groupmessage&isappinstalled=0#wechat_redirect) | [Scalpel: Jake大神的第三把刀](http://mp.weixin.qq.com/s?__biz=MzA4MjU5NTY0NA==&mid=400871360&idx=1&sn=ed438babc92bcca912f0f097f46fcf70&scene=1&srcid=1201fX7dBmzWopPQwaue5OKg&from=groupmessage&isappinstalled=0#wechat_redirect) | scalpel的使用
[任玉刚](https://github.com/singwhatiwanna)|[Android开发艺术探索](https://item.jd.com/11760209.html) | BitmapFactory解析的配置
[徐宜生](https://github.com/xuyisheng)|[Android群英传](https://item.jd.com/11758334.html)| Canvas的使用


### 致谢
[JakeWharton](https://github.com/JakeWharton)<br/>
[nostra13](https://github.com/nostra13)<br/>
[扔物线](https://github.com/rengwuxian)<br/>
[代码家](https://github.com/daimajia)<br/>
[秋百万](https://github.com/liaohuqiu)<br/>
[大头鬼](https://github.com/lzyzsd)<br/>
[胡凯](https://github.com/kesenhoo)<br/>
[任玉刚](https://github.com/singwhatiwanna)<br/>
[徐宜生](https://github.com/xuyisheng)<br/>
[Ailurus](https://github.com/liangzhitao)<br/>
[汤涛](http://mp.weixin.qq.com/s?__biz=MzA4MjU5NTY0NA==&mid=400871360&idx=1&sn=ed438babc92bcca912f0f097f46fcf70&scene=1&srcid=1201fX7dBmzWopPQwaue5OKg&from=groupmessage&isappinstalled=0#wechat_redirect)<br/>
[intbird](http://blog.csdn.net/intbird)<br/>

<!--### [秋百万诗歌欣赏](http://weibo.com/p/1001603907193945642719)-->
<!-->代码情诗(一)<br/>-->
<!-->旧金山的下着雨的星期天<br/>-->
<!-->我检出了多年前的老项目<br/>-->
<!-->看到了代码片段中的注释里<br/>-->
<!-->多年前的我对你的思念<br/>-->
<!--[诗歌出处,链接](http://weibo.com/p/1001603907193945642719)-->

###About me

人人网Android开发工程师<br/>
[我的CSDN博客](http://blog.csdn.net/androidmalin):http://blog.csdn.net/androidmalin<br/>
[我的微博](http://weibo.com/androidmalin):http://weibo.com/androidmalin<br/>


###License
<pre>
The MIT License (MIT)

Copyright (c) 2015 malin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

</pre>