package com.example.bikashproject;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AddTodoViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final TodoDatabase mdb;
    private final int mTodoId;


    public AddTodoViewModelFactory(TodoDatabase mdb, int mTodoId) {
        this.mdb = mdb;
        this.mTodoId = mTodoId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddTodoViewModel(mdb, mTodoId);
    }
}
