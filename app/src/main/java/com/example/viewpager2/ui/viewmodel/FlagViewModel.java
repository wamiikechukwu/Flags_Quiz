package com.example.viewpager2.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewpager2.data.FlagDataSet;
import com.example.viewpager2.model.Flag;

import java.util.List;

public class FlagViewModel extends ViewModel {
    private MutableLiveData<List<Flag>> _flagData = new MutableLiveData<>();
    private FlagDataSet _dataSet;
    private MutableLiveData<Flag> _flag = new MutableLiveData<>();
    public LiveData<List<Flag>> flagData = _flagData;


    public void init() {
        _dataSet = new FlagDataSet();
        _flagData.setValue(_dataSet.getFlags());
    }

    public LiveData<Flag> getFlagById(int flagId) {
        _flag.setValue(_dataSet.getFlags().get(flagId));
        return _flag;
    }
}
