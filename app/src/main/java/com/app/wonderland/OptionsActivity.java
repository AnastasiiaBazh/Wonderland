package com.app.wonderland;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsActivity extends AppCompatActivity {

    RecyclerView recycler;
    TextView buttonSave;

    private final List<Option> newOptionsList = Arrays.asList(
            new Option("Новый набор данных"),
            new Option("Намного лучше, чем предыдущий!"),
            new Option("Работает!!!"),
            new Option("Четвертый вариант"),
            new Option("Пятый вариант"),
            new Option("Явно больше опций, чем раньше"),
            new Option("Снова новый вариант"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        //noinspection DataFlowIssue
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.primary)));
        getSupportActionBar().setTitle(R.string.options_name);

        recycler = findViewById(R.id.recycler);
        buttonSave = findViewById(R.id.buttonSave);

        ArrayList<Option> options = getIntent().getParcelableArrayListExtra("option");

        OptionsAdapter adapter = new OptionsAdapter(options);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        View.OnClickListener oclButtonSave = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Option> array = new ArrayList<>(newOptionsList);
                    Intent intent = new Intent();
                    intent.putExtra("option", array);
                    setResult(RESULT_OK, intent);
            }
        };

        buttonSave.setOnClickListener(oclButtonSave);
    }
}

