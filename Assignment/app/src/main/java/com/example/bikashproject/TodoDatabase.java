package com.example.bikashproject;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
@TypeConverters(DateConverter.class)

public abstract class  TodoDatabase extends RoomDatabase {
    private static final String LOG_TAG = TodoDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static String DATABASE_NAME = "todoList";
    private static TodoDatabase sInstance;

    public static TodoDatabase getInstance(Context context){
        if(sInstance == null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        TodoDatabase.class, TodoDatabase.DATABASE_NAME)
                        //.allowMainThreadQueries()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract TodoDao todoDao();

}

