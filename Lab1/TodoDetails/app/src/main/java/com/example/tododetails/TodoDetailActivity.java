package com.example.tododetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

public class TodoDetailActivity extends AppCompatActivity {
private TextView textoutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        Intent intent= getIntent();
        int todo_index= intent.getIntExtra(MainActivity.Todoindex, 0);
        textoutput=findViewById(R.id.textView3);
        textoutput.setText(""+todo_index);
        CheckBox checkBoxIsComplete = (CheckBox)findViewById(R.id.checkBoxIsComplete);
        checkBoxIsComplete.setOnClickListener();

    }
}
