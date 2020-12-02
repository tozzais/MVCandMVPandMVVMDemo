package com.xmm.architecture.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {

    /**
     * 无参 构造函数的情况
     * 在Activity中直接使用
     * viewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory())
     *                 .get(TestViewModel.class);
     */
    private MutableLiveData<String> mNameEvent = new MutableLiveData<>();


    public MutableLiveData<String> getNameEvent() {
        return mNameEvent;
    }
}
