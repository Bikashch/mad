package com.example.bikashproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<Todo>> mTodos;
    TodoRepos mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TodoRepos(application);
        mTodos = mRepository.getAllWords();
    }

    public LiveData<List<Todo>> getTodos(){
        return mTodos;
    }

    public void insert(Todo todo) { mRepository.insert(todo); }

    public void delete(Todo todo) { mRepository.delete(todo); }

    public void update(Todo todo) { mRepository.update(todo); }
}
