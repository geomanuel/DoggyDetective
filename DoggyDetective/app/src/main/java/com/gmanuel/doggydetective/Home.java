package com.gmanuel.doggydetective;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //Log.d("CREATION", "onCreate() is being executed1");

    button = findViewById(R.id.start_button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openInput();
        }
    });
    }

    public void openInput(){
        Intent intent = new Intent(this, PictureInput.class);
        startActivity(intent);
    }
}
