package se.limhamn.ted.apps.trf_apiproject;

import android.app.FragmentManager;

import java.util.ArrayList;

/**
 * Created by Ted on 2014-10-21.
 */
public class Controller {
    private AsyncQueryEngine asyncQueryEngine;
    private MainActivity main;
    private SearchFragment frSearch;
    private ArrayList<RecipeBase> arrList;

    public Controller(MainActivity main){
        this.main = main;

        new ControllerDispenser(this);

        asyncQueryEngine = new AsyncQueryEngine(this);
        FragmentManager fm = main.getFragmentManager();
        frSearch = (SearchFragment)fm.findFragmentById(R.id.fragSearch);
//        asyncQueryEngine.setAndSearchRecipe("lasagna");
    }

    public void searchRecipe(String str) {
        asyncQueryEngine.setAndSearchRecipe(str);
    }

    public void setRecipeArray(ArrayList<RecipeBase> arrList) {
        this.arrList = arrList;
    }

    public ArrayList<RecipeBase> getRecipeArray(){
        return arrList;
    }

    public void getRecipeIngredient(String id) {
        asyncQueryEngine.getAndSetIngredients(id);
    }
}
