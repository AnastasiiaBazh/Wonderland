package com.app.wonderland;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class OptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getColor(R.color.primary)));
        getSupportActionBar().setTitle(R.string.options_name);
    }
}

