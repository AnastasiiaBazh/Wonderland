package com.app.wonderland;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class OptionsActivity extends AppCompatActivity {

    RecyclerView recycler;
    private List<Option> someOptions = Arrays.asList(
            new Option("Ахуительная рулетка!!"),
            new Option("Рулетка богов просто!"),
            new Option("Ультра нано S3000 гипер рулетка!"),
            new Option("Мама сказала, что ей нравится"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.primary)));
        getSupportActionBar().setTitle(R.string.options_name);

        recycler = findViewById(R.id.recycler);

        OptionsAdapter adapter = new OptionsAdapter(someOptions);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
    }
}

