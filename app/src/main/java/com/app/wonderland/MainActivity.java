package com.app.wonderland;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView buttonGenerate;
    private TextView optionsButton;
    private TextView result;
    private List<Option> someOptionsList = Arrays.asList(
            new Option("Ахуительная рулетка!!"),
            new Option("Рулетка богов просто!"),
            new Option("Ультра нано S3000 гипер рулетка!"),
            new Option("Мама сказала, что ей нравится"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //noinspection DataFlowIssue
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.primary)));

        buttonGenerate = findViewById(R.id.buttonGenerate);
        result = findViewById(R.id.result);
        optionsButton = findViewById(R.id.optionsButton);

        View.OnClickListener oclButtonGenerate = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(random());
            }
        };
        buttonGenerate.setOnClickListener(oclButtonGenerate);

        View.OnClickListener oclOptionsButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        };
        optionsButton.setOnClickListener(oclOptionsButton);
    }

    private String random() {
        Random rand = new Random();
        int i = rand.nextInt(someOptionsList.size());
        return someOptionsList.get(i).getOption();
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, OptionsActivity.class);

        ArrayList<Option> array = new ArrayList<>(someOptionsList);
        intent.putExtra("option", array);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        ArrayList<Option> option = data.getParcelableArrayListExtra("option");
        someOptionsList = option;
    }
}