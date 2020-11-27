package com.dataforest.COIS4000;

import android.content.ClipData.Item;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {
    private final MutableLiveData<String> selectedItem = new MutableLiveData<>();
    public void selectItem(String item){
        selectedItem.setValue(item);
    }
    public LiveData<String> getSelectedItem(){
        return selectedItem;
    }
}
