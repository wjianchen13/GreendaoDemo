package com.example.greendaodemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodemo.relate.RelateActivity;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStudent(View v) {
        startActivity(new Intent(this, StudentActivity.class));
    }

    public void onEvent(View v) {
        startActivity(new Intent(this, EventActivity.class));
    }

    public void onHangup(View v) {
        startActivity(new Intent(this, HangupActivity.class));
    }

    public void onZip(View v) {
        startActivity(new Intent(this, ZipActivity.class));
    }

    public void onTest1(View v) {
        startActivity(new Intent(this, RelateActivity.class));
    }

}