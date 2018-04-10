package com.gmanuel.doggydetective;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Olivia on 2018-04-09.
 */

public class PhysicalController {

    // size, color, tail length, tail shape, muzzle length, coat length, coat pattern, ear shape
    //{"Large","Gray", "Long", "Curved", "Long", "Long", "Bicolor", "Upright"}
    private String[] physicalInput;
    private ArrayList<DogBreed> results;
    private Context context;

    public PhysicalController(Context context, String[] physicalInput) {
        this.physicalInput = physicalInput;
        this.context = context;
        this.results = new ArrayList<DogBreed>();
        determineBreeds(context);
    }

    public void determineBreeds(Context context) {
        BreedList breedList = new BreedList(context);

        for (int i = 0; i < breedList.size(); i++) {
            DogBreed breed = breedList.get(i);
            // Check size.
            if (!physicalInput[0].equals(breed.getSize())) { continue; }
            // Check color.
            String[] colors = breed.getColors();
            if ((!physicalInput[1].equals(colors[0])) && (!physicalInput[1].equals(colors[1])) && (!physicalInput[1].equals(colors[2]))) { continue; }
            // Check tail length.
            if (!physicalInput[2].equals(breed.getTailLength())) { continue; }
            // Check tail shape.
            if (!physicalInput[3].equals(breed.getTailShape())) { continue; }
            // Check muzzle length.
            if (!physicalInput[4].equals(breed.getMuzzleLength())) { continue; }
            // Check coat length.
            if (!physicalInput[5].equals(breed.getCoatLength())) { continue; }
            // Check coat pattern
            if (!physicalInput[6].equals(breed.getCoatPattern())) { continue; }
            // Check ear shape.
            if (!physicalInput[7].equals(breed.getEarShape())) { continue; }
            // Add to results list if physical characteristics match.
            results.add(breed);
        }
    }

    public ArrayList<DogBreed> getResults() {
        return results;
    }
}
