package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private ArrayList<String> wordList;
    private WordListAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordList = new ArrayList<>();
        for (int i =0; i < 30; i++){
            wordList.add("WordList"+ i);
        }

        mRecycleView = findViewById(R.id.word_list);
        adapter = new WordListAdapter(wordList, this);
        mRecycleView.setAdapter(adapter);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int worldListSize = wordList.size();
                wordList.add("+ word" + worldListSize);
                mRecycleView.getAdapter().notifyItemInserted(worldListSize);
                mRecycleView.smoothScrollToPosition(worldListSize);

    }
}
        );
    }
}