package com.gmanuel.doggydetective;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Olivia on 2018-04-09.
 */

public class Blackboard {

    private String[] physicalInput;
    private String behaviourInput;
    private PhysicalController physicalController;
    private BehaviourController behaviourController;
    private ArrayList<DogBreed> results;
    private Context context;

    public Blackboard(String[] physicalInput, String behaviourInput, Context context) {
        this.physicalInput = physicalInput;
        this.behaviourInput = behaviourInput;
        this.context = context;
        this.results = new ArrayList<DogBreed>();
    }

    public ArrayList<DogBreed> determineBreeds() {
        // Get results from physical characteristics expert.
        physicalController = new PhysicalController(context, physicalInput);
        ArrayList<DogBreed> physicalResults = physicalController.getResults();
        // Get results from behaviour characteristics expert.
        behaviourController = new BehaviourController(context, behaviourInput);
        ArrayList<DogBreed> behaviourResults = behaviourController.getResults();

        //Find intersection between the two sets of results.
        for (int i = 0; i < physicalResults.size(); i++) {
            for (int j = 0; j < behaviourResults.size(); j++) {
                if (physicalResults.get(i).getBreed().equals(behaviourResults.get(i).getBreed())) {
                    results.add(physicalResults.get(i));
                }
            }
        }

        return results;
    }
}
