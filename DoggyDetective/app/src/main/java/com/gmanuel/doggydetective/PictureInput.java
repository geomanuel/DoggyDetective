package com.gmanuel.doggydetective;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.net.Uri;
import java.io.InputStream;
import android.graphics.BitmapFactory;
import 	java.io.FileNotFoundException;
import java.net.URL;

public class PictureInput extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_input);

        Button cameraButton = findViewById(R.id.take_picture);
        imageView = findViewById(R.id.dog_photo);
        Button choosePhoto = findViewById(R.id.choose_photo);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, 0);
            }
        });
        choosePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickPhoto.setType("image/*");
                startActivityForResult(pickPhoto , 1);//one can be replaced with any action code
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        //imageView.setImageBitmap(bitmap);
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    imageView.setImageBitmap(bitmap);
                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Uri pickedImage = data.getData();
                   imageView.setImageURI(pickedImage);
                }
                break;
        }
        nextInput();
    }

    public void nextInput(){
        Intent intent = new Intent(this, CharacteristicsInput.class);
        startActivity(intent);
    }
}
