package se.limhamn.ted.apps.trf_apiproject;

/**
 * Created by Ted on 2014-10-21.
 */
public class Controller {
    private AsyncQueryEngine asyncQueryEngine;

    public Controller(){

        asyncQueryEngine = new AsyncQueryEngine();
//        asyncQueryEngine.setAndSearchRecipe("lasagna");
    }

    public void searchRecipe(String str) {
        asyncQueryEngine.setAndSearchRecipe(str);
    }
}
