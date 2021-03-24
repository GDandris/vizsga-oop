package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Pig;

import java.util.ArrayList;
import java.util.List;

class Farm {

    List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void feedAnimals(){
        for(Animal animal : animals){
            animal.feed();
        }
    }

    public void butcher(Butcher butcher){
        animals.removeIf(butcher::canButcher);
    }

    public boolean isEmpty(){
        return animals.isEmpty();
    }

    public List<String> getStatus(){
        List<String> statuses = new ArrayList<>();
        for(Animal animal : animals) {
            String animalName = animal instanceof Pig ? "pig" : "cattle";
            statuses.add("There is a " + animal.getSize() +" sized "+ animalName +" in the farm.");
        }
        return statuses;

    }
}
