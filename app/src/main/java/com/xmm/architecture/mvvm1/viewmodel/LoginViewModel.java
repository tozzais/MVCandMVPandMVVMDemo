package com.xmm.architecture.mvvm1.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xmm.architecture.mvvm1.model.LoginRepository;

public class LoginViewModel extends ViewModel {


    public MutableLiveData<String> userName;
    public MutableLiveData<String> password;
    public MutableLiveData<String> uid;

    private LoginRepository repository;

    public LoginViewModel() {
        repository = new LoginRepository();
        userName = new MutableLiveData<>();
        userName.postValue(repository.getUserNameFromCache());
        password = new MutableLiveData<>();
        password.postValue("");
        uid = new MutableLiveData<>();
        uid.postValue("0");
    }

    public void login() {
        String userId = repository.login(userName.getValue(), password.getValue());
        uid.postValue(userId);
    }



}
