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
        Log.d("CREATION", "onCreate() is being executed1");

    button = findViewById(R.id.start_button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openInput();
        }
    });
    }

    public void openInput(){
        //BreedList breedList = new BreedList(this);
        //DogBreed breed = breedList.get(0);
        //String msg = breed.getBreed();
        //Log.d("ACTIVITY", msg);


        PhysicalController pc = new PhysicalController(this);
        ArrayList<DogBreed> results = pc.getResults();
        Log.d("ACTIVITY", Integer.toString(results.size()));
        for (int i = 0; i < results.size(); i++) {
            String msg = results.get(i).getBreed();
            Log.d("ACTIVITY", msg);
        }


        Intent intent = new Intent(this, PictureInput.class);
        startActivity(intent);
    }
}
