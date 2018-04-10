package com.gmanuel.doggydetective;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Olivia on 2018-04-08.
 */

public class ReadFile {

    public static ArrayList<DogBreed> read(Context context) {

        ArrayList<DogBreed> breedsList = new ArrayList<DogBreed>();
        InputStream is = context.getResources().openRawResource(R.raw.dogbreeddata);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";
        boolean firstline = true;
        try {
            while ((line = reader.readLine()) != null) {
                // Skip the row of fields.
                if (firstline) {
                    firstline = false;
                    continue;
                }
                String[] row = line.split(",");
                // Read the data.
                DogBreed breed = new DogBreed();
                // Set breed name.
                breed.setBreed(row[0]);
                // Set coat length.
                breed.setCoatLength(row[1]);
                // Set coat pattern.
                breed.setCoatPattern(row[2]);
                // Set colors.
                String[] colors = {row[3], row[4], row[5]};
                breed.setColors(colors);
                // Set description.
                breed.setDescription(row[6]);
                // Set ear shape.
                breed.setEarShape(row[7]);
                // Set muzzle length.
                breed.setMuzzleLength(row[8]);
                // Set size.
                breed.setSize(row[9]);
                // Set tail length.
                breed.setTailLength(row[10]);
                // Set tail shape.
                breed.setTailShape(row[11]);
                // Set behaviours.
                String[] behaviours = {row[12], row[13], row[14]};
                breed.setBehaviours(behaviours);
                // Add to list of breeds.
                breedsList.add(breed);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }

        return breedsList;
    }

}
