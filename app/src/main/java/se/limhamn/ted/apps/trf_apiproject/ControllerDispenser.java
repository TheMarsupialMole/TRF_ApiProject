package se.limhamn.ted.apps.trf_apiproject;

/**
 * The class always has a controller reference ready for any calling method/class/fragment
 * Created by Ted on 2014-10-25.
 */
public class ControllerDispenser {

    private static Controller controller;

    public ControllerDispenser(Controller controller){
        this.controller = controller;
    }

    public static Controller getController(){
        return controller;
    }
}
