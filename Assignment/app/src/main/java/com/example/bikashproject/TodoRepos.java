package com.example.bikashproject;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoRepos {

    private TodoDao todoDao;
    private LiveData<List<Todo>> mAllTodos;

    TodoRepos(Application application) {
        TodoDatabase db = TodoDatabase.getInstance(application);
        todoDao = db.todoDao();
        mAllTodos = todoDao.getAllTodos();
    }

    LiveData<List<Todo>> getAllWords() {
        return mAllTodos;
    }

    public void insert (final Todo todo) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.insertTodo(todo);
            }
        });
    }
    public void delete(final Todo todo)  {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.deleteTodo(todo);
            }
        });
    }

    public void update(final Todo todo)  {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.update(todo);
            }
        });
    }
}
