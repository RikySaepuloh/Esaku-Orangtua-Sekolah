package com.saku.sekolah.ui.keuangan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KeuanganViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KeuanganViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}