package com.gmanuel.doggydetective;


import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Olivia on 2018-04-09.
 */

public class BreedList {

    private Context context;
    private ArrayList<DogBreed> breedsList;

    public BreedList(Context current) {
        this.context = current;
        this.breedsList = ReadFile.read(context);
    }

    public DogBreed get(int i) {
        return breedsList.get(i);
    }

    public void add(DogBreed breed) {
        breedsList.add(breed);
    }

    public int size() {
        return breedsList.size();
    }
}
