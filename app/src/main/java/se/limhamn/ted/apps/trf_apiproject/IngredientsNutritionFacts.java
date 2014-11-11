package se.limhamn.ted.apps.trf_apiproject;

/**
 * Created by radde on 14-10-28.
 */
public class IngredientsNutritionFacts {
    private double energy; //       Energi-innehåll     id 5
    private double protein; //      Protein-innehåll    id 1
    private double fat; //          Fett-innehåll       id 2
    private double carbohydrate; // Kolhydrat-innehåll  id 3
    private double sugars; //       Socker-innehåll     id 18

    public IngredientsNutritionFacts(double energy, double protein, double fat, double carbohydrate, double sugars) {
        this.energy = energy;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
        this.sugars = sugars;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }
}
