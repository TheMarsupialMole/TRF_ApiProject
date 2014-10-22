package se.limhamn.ted.apps.trf_apiproject;

import android.app.FragmentManager;

/**
 * Created by Ted on 2014-10-21.
 */
public class Controller {
    private AsyncQueryEngine asyncQueryEngine;
    private MainActivity main;
    private SearchFragment frSearch;

    public Controller(MainActivity main){
        this.main = main;
        asyncQueryEngine = new AsyncQueryEngine();
        FragmentManager fm = main.getFragmentManager();
        frSearch = (SearchFragment)fm.findFragmentById(R.id.fragSearch);
        frSearch.setController(this);
//        asyncQueryEngine.setAndSearchRecipe("lasagna");
    }

    public void searchRecipe(String str) {
        asyncQueryEngine.setAndSearchRecipe(str);
    }
}
