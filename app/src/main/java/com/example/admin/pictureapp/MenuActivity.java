package com.example.admin.pictureapp;

import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    public void goToPictures(View view){
        Intent intent = new Intent(this, PictureActivity.class);
        startActivity(intent);
    }

    public void goToInterest(View view){
        Intent intent = new Intent(this, EMIActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }
}
