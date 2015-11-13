# RxJavaPaoWuXianArticleSample
扔物线[给Android开发者的RxJava详解](http://gank.io/post/560e15be2dca930e00da1083)文章中的例子

### 链接
[扔物线 给Android开发者的RxJava详解](http://gank.io/post/560e15be2dca930e00da1083)<br/>
[扔物线Github主页](https://github.com/rengwuxian)<br/>
[扔物线博客](http://www.rengwuxian.com)<br/>
[扔物线Dagger源码解析](http://a.codekk.com/detail/Android/%E6%89%94%E7%89%A9%E7%BA%BF/Dagger%20%E6%BA%90%E7%A0%81%E8%A7%A3%E6%9E%90)<br/>
[扔物线<<埋头苦干的一年>>](https://github.com/aosp-exchange-group/fuck-2014-flirt-2015/blob/master/1/rengwuxian.md)<br/>

### 说明

感谢扔物线写出如此认真的作品!
<div><img src='https://github.com/androidmalin/RengwuxianRxjava/blob/master/app/src/main/res/mipmap-xhdpi/rengwuxian.jpg' width="80px" style='border: #f1f1f1 solid 1px'/></div>

最近正好有时间,边读文章,边将文章中的例子敲成代码.因为接触时间不长,代码中难免有些问题,希望大家可以给予指导和帮助.

### 截图

<div><img src='https://github.com/androidmalin/RengwuxianRxjava/blob/master/screenshots/ganhuoqun.png' width="300px" style='border: #f1f1f1 solid 1px'/></div>

### APK
[APK下载](https://raw.githubusercontent.com/androidmalin/RengwuxianRxjava/master/apk/rengwuxianrxjava.apk)<br/>
### <<给Android开发者的RxJava详解>> 文章预览
我从去年开始使用 RxJava ，到现在一年多了。今年加入了 Flipboard 后，看到 Flipboard 的 Android 项目也在使用 RxJava ，并且使用的场景越来越多 。而最近这几个月，我也发现国内越来越多的人开始提及 RxJava 。有人说『RxJava 真是太好用了』，有人说『RxJava 真是太难用了』，另外更多的人表示：我真的百度了也谷歌了，但我还是想问： RxJava 到底是什么？
鉴于 RxJava 目前这种既火爆又神秘的现状，而我又在一年的使用过程中对 RxJava 有了一些理解，我决定写下这篇文章来对 RxJava 做一个相对详细的、针对 Android 开发者的介绍。

这篇文章的目的有两个：

    给对 RxJava 感兴趣的人一些入门的指引
    给正在使用 RxJava 但仍然心存疑惑的人一些更深入的解析