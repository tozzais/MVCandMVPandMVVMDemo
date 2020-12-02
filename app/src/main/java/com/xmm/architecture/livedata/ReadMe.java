package com.xmm.architecture.livedata;

public class ReadMe {
    /*
     LiveData 是一个可以被观察的数据持有类，它可以感知 Activity、Fragment或Service 等组件的生命周期。简单来说，他主要有一下优点。

    1:它可以做到在组件处于激活状态的时候才会回调相应的方法，从而刷新相应的 UI。
    2:不用担心发生内存泄漏
    3:当 config 导致 activity 重新创建的时候，不需要手动取处理数据的储存和恢复。它已经帮我们封装好了。
    4:当 Actiivty 不是处于激活状态的时候，如果你想 livedata setValue 之后立即回调 obsever 的 onChange 方法，
        而不是等到 Activity 处于激活状态的时候才回调 obsever 的 onChange 方法，你可以使用 observeForever 方法，但是你必须在 onDestroy 的时候 removeObserver。

     */
}
