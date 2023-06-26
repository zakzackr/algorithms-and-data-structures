import java.util.Arrays;
import java.util.ArrayList;

class Animal{
    public String species;
    public double weightKg;
    public double heightM;
    public boolean predator;

    public Animal(String species, double weightKg, double heightM, boolean predator){
        this.species = species;
        this.weightKg = weightKg;
        this.heightM = heightM;
        this.predator = predator;
    }

    public void domesticate(){
        this.predator = false;
    }
}

class Hunter{
    public String name;
    public double weightKg;
    public double heightM;
    public double strength;
    public double cageCubicMeters;

    public Hunter(String name, double weightKg, double heightM, double strength, double cageCubicMeters){
        this.name = name;
        this.weightKg = weightKg;
        this.heightM = heightM;
        this.strength = strength;
        this.cageCubicMeters = cageCubicMeters;
    }

    public double strengthKg(){
        return this.strength * weightKg;
    }

    public boolean canCaptureAnimal(Animal animal){
        return this.strengthKg() > animal.weightKg && this.cageCubicMeters >= animal.heightM && !animal.predator;
    }

    public boolean attemptToDomesticate(Animal animal){
        if (this.strengthKg() <= this.weightKg * 2) return false;

        animal.domesticate();
        return true;
    }
}

class Main{
    public static Animal[] capturedAnimals(Hunter hunter, Animal[] animals){
        ArrayList<Animal> dArr = new ArrayList<>();

        for (Animal animal: animals){
            if (hunter.canCaptureAnimal(animal)) dArr.add(animal);
        }

        return toArray(dArr);
    }

    public static void domesticateTheAnimals(Hunter hunter, Animal[] animals){
        for (Animal animal: animals){
            hunter.attemptToDomesticate(animal);
        }
    }

    public static Animal[] toArray(ArrayList<Animal> dArr){
        Animal[] fixedArr = new Animal[dArr.size()];
        for (int i = 0; i < dArr.size(); i++){
            fixedArr[i] = dArr.get(i);
        }

        return fixedArr;
    }

    public static void printArr(Animal[] animals){
        for (Animal animal: animals) System.out.println(animal.species);
    }

    public static void main(String[] args){
        Animal tiger = new Animal("Tiger", 290, 2.6, true);
        Animal cow = new Animal("Cow", 1134, 1.5, false);
        Animal snake = new Animal("Snake", 100, 1.2, true);
        Animal cat = new Animal("Cat", 10, 0.5, false);
        Hunter hunternator = new Hunter("Hunternator", 124.73, 1.85, 15, 3);
        Animal[] animals = {tiger, cow, snake, cat};
        
        printArr(capturedAnimals(hunternator, animals));
        domesticateTheAnimals(hunternator, animals);
        printArr(capturedAnimals(hunternator, animals));
    }
}
