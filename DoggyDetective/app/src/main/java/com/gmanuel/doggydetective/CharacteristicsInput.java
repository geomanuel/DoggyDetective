package com.gmanuel.doggydetective;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CharacteristicsInput extends AppCompatActivity {
    private Button next;
    private Button back;
    private Button yes;
    private Button no;
    ArrayList<DogBreed> results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characteristics_input);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBreedDescription();
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPictureInput();
            }
        });
    }

    public void openBreedDescription(){
        Spinner size =(Spinner) findViewById(R.id.physical_size);
        Spinner color =(Spinner) findViewById(R.id.physical_color);
        Spinner tailLength =(Spinner) findViewById(R.id.physical_tailLength);
        Spinner tailShape =(Spinner) findViewById(R.id.physical_tailShape);
        Spinner muzzleLength =(Spinner) findViewById(R.id.physical_muzzleLength);
        Spinner coatLength =(Spinner) findViewById(R.id.physical_lengthOfCoat);
        Spinner coatPattern =(Spinner) findViewById(R.id.physical_coatPattern);
        Spinner earShape =(Spinner) findViewById(R.id.physical_earShape);
        Spinner behaviour =(Spinner) findViewById(R.id.physical_behaviour);
        String[] physicalInput = new String[8];
        String behaviourInput;
        physicalInput[0] = size.getSelectedItem().toString();
        physicalInput[1] = color.getSelectedItem().toString();
        physicalInput[2] = tailLength.getSelectedItem().toString();
        physicalInput[3] = tailShape.getSelectedItem().toString();
        physicalInput[4] = muzzleLength.getSelectedItem().toString();
        physicalInput[5] = coatLength.getSelectedItem().toString();
        physicalInput[6] = coatPattern.getSelectedItem().toString();
        physicalInput[7] = earShape.getSelectedItem().toString();
        behaviourInput = behaviour.getSelectedItem().toString();

        Blackboard blackboard = new Blackboard(physicalInput, behaviourInput, this);
        results = blackboard.determineBreeds();
        //setContentView(R.layout.activity_breed_description);
        //TextView textView = (TextView) findViewById(R.id.breedName);
        //textView.setText(results.get(0).getBreed());


        
        setContentView(R.layout.activity_breed_description);
        TextView textView = (TextView) findViewById(R.id.breedName);
        textView.setText(results.get(0).getBreed());

        TextView textDescription = (TextView) findViewById(R.id.breedDescription);
        textDescription.setText(results.get(0).getDescription());

        yes = findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
        no = findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPictureInput();
            }
        });







        //Intent next = new Intent(this, BreedDescription.class);
        //startActivity(next);
    }

    public void openPictureInput(){
        Intent back = new Intent(this, PictureInput.class);
        startActivity(back);
    }

    public void openHome(){
        Intent yes = new Intent(this, Home.class);
        startActivity(yes);
    }

}