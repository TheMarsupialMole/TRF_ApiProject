package se.limhamn.ted.apps.trf_apiproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ted on 2014-10-21.
 */
public class Controller {
    private AsyncQueryEngine asyncQueryEngine;
    private MainActivity main;
    private SearchFragment frSearch;
    private ArrayList<RecipeBase> arrList;
    private ArrayList<IngredientsBase> ingredientsArray;
    private ArrayList<IngredientsDetail> ingredientsDetail;
    private FragmentManager fm;
    private String nutritionInformation = "";

    public Controller(MainActivity main){
        this.main = main;

        new ControllerDispenser(this);

        asyncQueryEngine = new AsyncQueryEngine(this);
        fm = main.getFragmentManager();
        frSearch = (SearchFragment)fm.findFragmentById(R.id.fragSearch);
//        asyncQueryEngine.setAndSearchRecipe("lasagna");
    }

    //request to api
    public void searchRecipe(String str) {
        asyncQueryEngine.setAndSearchRecipe(str);
    }

    public void setRecipeArray(ArrayList<RecipeBase> arrList) {
        this.arrList = arrList;
    }

    public ArrayList<RecipeBase> getRecipeArray(){
        return arrList;
    }

    public ArrayList<IngredientsBase> getIngredientsArray(){
        return ingredientsArray;
    }

    //request to api
    public void getRecipeIngredient(String id) {
        asyncQueryEngine.getAndSetIngredients(id);
    }

    //request to api

    public void getChoices(String ingredientName) {
        asyncQueryEngine.getAndSetChoices(ingredientName);
    }

    //request to api
    public void getNutritionFacts(String id) {
        asyncQueryEngine.getAndSetNutritionFacts(id);
    }

    //-----------------------------------change fragment methods-----------------------------------
    public void setIngredientsArray(ArrayList arrList) {
        ingredientsArray = arrList;
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragContain, new FragmentIngredients());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void setIngredientsSearchArray(ArrayList arrList) {
        ingredientsDetail = arrList;
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragContain, new IngredientsSearchFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
//-------------------------------------------------------------------------------------------------
    
    public ArrayList<IngredientsDetail> getIngredientsDetailArray() {
        return ingredientsDetail;
    }

    public void setNutritionString(String nutritionInformation) {
        this.nutritionInformation = nutritionInformation;
    }

    public void resetNutritionString() {
        nutritionInformation = "";
    }

    public String getNutritionString() {
        return nutritionInformation;
    }

    public void stop() {
        asyncQueryEngine.stop();
    }
}
