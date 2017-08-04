package com.example.admin.pictureapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PictureActivity extends AppCompatActivity {
    private static final int CAMERA_PIC_REQUEST = 2;
    static final int ACTION_IMAGE_CAPTURE = 2;


    ImageView Image;

    //Take a Picture
    //Save the Data
    //Open with ImageView

    Button picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Image = (ImageView) findViewById(R.id.Picture);
        picture = (Button) findViewById(R.id.TakePicture);
    }


    public void takePicture(View view) {
        Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, CAMERA_PIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTION_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Image.setImageBitmap(imageBitmap);
        }
    }
}
