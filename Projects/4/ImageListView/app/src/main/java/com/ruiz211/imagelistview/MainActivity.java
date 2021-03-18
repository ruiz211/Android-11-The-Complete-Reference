package com.ruiz211.imagelistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.ruiz211.imagelistview.data.People;
import com.ruiz211.imagelistview.util.ListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recycler_view);
        ListAdapter adapter = new ListAdapter(People.getPeople());
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

    }
}