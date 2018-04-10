package com.gmanuel.doggydetective;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Olivia on 2018-04-09.
 */

public class BehaviourController {

    // Only 1 behaviour input from user.
    private String behaviourInput;
    private ArrayList<DogBreed> results;
    private Context context;

    public BehaviourController(Context context) {
        behaviourInput = "Playful";
        this.context = context;
        this.results = new ArrayList<DogBreed>();
        determineBreeds(context);
    }

    public ArrayList<DogBreed> determineBreeds(Context context) {
        BreedList breedList = new BreedList(context);

        for (int i = 0; i < breedList.size(); i++) {
            DogBreed breed = breedList.get(i);
            // Check color.
            String[] behaviours = breed.getBehaviours();
            if ((behaviourInput.equals(behaviours[0])) || (behaviourInput.equals(behaviours[1])) || (behaviourInput.equals(behaviours[2]))) {
                // Add to results list if behaviour characteristic matches.
                results.add(breed);
            }
        }
        return results;
    }

    public ArrayList<DogBreed> getResults() {
        return results;
    }
}
