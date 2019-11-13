package com.example.bikashproject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AddTodoViewModel extends ViewModel {

    private LiveData<Todo> todo;

    public AddTodoViewModel(TodoDatabase database, int todoId){
        todo = database.todoDao().loadTodoById(todoId);
    }

    public LiveData<Todo> getTodo() {
        return todo;
    }


}
