package se.limhamn.ted.apps.trf_apiproject;



import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentIngredients extends Fragment {
    private Controller controller;
    private ListView listview;
    private Context ctex;
    private IngredientsAdapter ingredientsAdapter;
    private ArrayList<IngredientsBase> ingredientsBaseArrayList;



    public FragmentIngredients() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        controller = ControllerDispenser.getController();

        View view = inflater.inflate(R.layout.ingredients_list, container, false);
        listview = (ListView)view.findViewById(R.id.listIngredients);
        ctex = getActivity();
        initList();

        return view;
    }

    public void initList() {
        ingredientsBaseArrayList = controller.getIngredientsArray();
        if(ingredientsBaseArrayList != null) {
            ingredientsAdapter = new IngredientsAdapter(ctex, ingredientsBaseArrayList);
            listview.setAdapter(ingredientsAdapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //controller.getRecipeIngredient(ingredientsBaseArrayList.get(i).getName());
                }
            });
        }
    }

}
