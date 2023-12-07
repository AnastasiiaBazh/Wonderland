package com.app.wonderland;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OptionsActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<Option> options = getIntent().getParcelableArrayListExtra("option");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.primary)));
        getSupportActionBar().setTitle(R.string.options_name);

        recycler = findViewById(R.id.recycler);

        OptionsAdapter adapter = new OptionsAdapter(options);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}

