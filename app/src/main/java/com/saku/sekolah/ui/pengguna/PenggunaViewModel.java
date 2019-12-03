package com.saku.sekolah.ui.pengguna;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PenggunaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PenggunaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pengguna fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}