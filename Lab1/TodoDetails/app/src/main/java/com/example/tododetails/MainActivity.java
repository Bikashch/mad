package com.example.tododetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] tasks ;
    private TextView textView;
    private Button detailsButton;
    public static String Todoindex;
    int currentIndex=0;
    Resources res;

    @Override
    protected void onSaveInstanceState(Bundle SavedInstanceState) {
        super.onSaveInstanceState(SavedInstanceState);
        SavedInstanceState.putInt("tasks", currentIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null){
            currentIndex = savedInstanceState.getInt("tasks", 0);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();
        tasks = res.getStringArray(R.array.todo_first);
        textView=findViewById(R.id.textView);
        textView.setText(tasks[currentIndex]);
        detailsButton = findViewById(R.id.viewbtn);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent((MainActivity.this),TodoDetailActivity.class);
                intent.putExtra(Todoindex, currentIndex);
                startActivity(intent);
            }
        });
        textView.setText(tasks[currentIndex]);
        Log.d("MainActivity", "onSave()");
        //totalLength = tasks.length;
    }
    public void btnprev (View view){
        if (currentIndex > 0 )
        {
            currentIndex= currentIndex % tasks.length;
        }
        else
        {
            currentIndex = tasks.length;
        }
        currentIndex =--currentIndex%tasks.length;
        Log.d("MainActivity", "This is android class");
        textView.setText(tasks[currentIndex]);
    }
    public void btnnext (View view){
        currentIndex = ++currentIndex %tasks.length;
        Log.d("MainActivity", "This is android class");
        textView.setText(tasks[currentIndex]);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("MainActivity", "onPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }
}
