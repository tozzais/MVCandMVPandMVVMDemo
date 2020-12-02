package com.xmm.architecture.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TestViewModel1 extends ViewModel {

    /**
     * 有参数 构造函数的情况
     * 在Activity中直接使用
     * viewModel = new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory())
     *                 .get(TestViewModel.class);
     */
    private  String mKey;

    private MutableLiveData<String> mNameEvent = new MutableLiveData<>();

    public MutableLiveData<String> getNameEvent() {
        return mNameEvent;
    }

    public TestViewModel1(String key) {
        mKey = key;
    }

    public static class Factory implements ViewModelProvider.Factory {
        private String mKey;

        public Factory(String key) {
            mKey = key;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new TestViewModel1(mKey);
        }
    }

    public String getKey() {
        return mKey;
    }
}
