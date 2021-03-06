package se.limhamn.ted.apps.trf_apiproject;



import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class IngredientsSearchFragment extends Fragment {
    private Controller controller;
    private ListView listview;
    private Context ctex;
    private IngredientsAdapter ingredientsAdapter;
    private ArrayList<IngredientsDetail> ingredientsDetail;
    private String nutritionString = "";


    public IngredientsSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        controller = ControllerDispenser.getController();

        View view = inflater.inflate(R.layout.fragment_ingredients_search, container, false);
        listview = (ListView)view.findViewById(R.id.listIngredientSearch);
        ctex = getActivity();
        initList();

        return view;
    }

    /** Fyller ingredientsBaseArr med ingred från API
     * Därefter skickas den in i adaptern och adaptern returnerar en vy med ett objekt
     * "String" som visas på listan
     */


    public void initList() {
        ingredientsDetail = controller.getIngredientsDetailArray(); //fetch ingredients array list from controller
        if(ingredientsDetail != null) {
            ingredientsAdapter = new IngredientsAdapter(ctex, ingredientsDetail); //if nut null pass it to the adapter to populate the list.
            listview.setAdapter(ingredientsAdapter);
            /** Vid klick på listan hämtas nutritionfacts
             *
             */

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    controller.getNutritionFacts(ingredientsDetail.get(i).getId()); //get nutrition string from api
                    while(controller.getNutritionString().equals("") || i < 10){    //wait for api to send a reply
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        i++;
                    }
                    nutritionString = controller.getNutritionString();  //get nutrition string from api

                    if(!nutritionString.equals("")){//if a string has arrived
                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity()); //show nutrition facts in an alert view.

                        alert.setTitle("Ingredient result");
                        alert.setMessage(nutritionString);

                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                            }
                        });

                        alert.show();

                    }
                }
            });
        }
    }


}
