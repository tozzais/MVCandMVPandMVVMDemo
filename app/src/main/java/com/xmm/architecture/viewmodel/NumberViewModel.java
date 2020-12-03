package com.xmm.architecture.viewmodel;

import androidx.lifecycle.ViewModel;

public class NumberViewModel extends ViewModel {


    private int number = 100;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
