package com.app.wonderland;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView buttonGenerate;
    private TextView optionsButton;
    private TextView result;
    private String[] someOptions = {"Ахуительная рулетка!!","Рулетка богов просто!","Ультра нано S3000 гипер рулетка!","Мама сказала, что ей нравится"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        int i = rand.nextInt(someOptions.length);
        return someOptions[i];
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }
}