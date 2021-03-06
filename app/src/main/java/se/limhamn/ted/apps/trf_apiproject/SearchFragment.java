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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SearchFragment extends Fragment {
    private se.limhamn.ted.apps.trf_apiproject.recipeAdapter recipeAdapter;
    private ListView recipeListView;
    private Context ctex;
    private Button btnSearch;
    private EditText etRecipeSearch;
    private Controller controller;
    private View view;
    private ArrayList<RecipeBase> recipeArray;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        controller = ControllerDispenser.getController();   //Gain access to the instantiated controller.
        view = inflater.inflate(R.layout.fragment_search, container, false);
        recipeListView = (ListView)view.findViewById(R.id.lvRecipeList);    //List view from XML;
        initList(); //Initiate list

        etRecipeSearch = (EditText)view.findViewById(R.id.etSearch);    //EditText to enter serach term into
        btnSearch = (Button)view.findViewById(R.id.btnSearchRecipe);    //Button to start the search.
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recipeArray = null;
                controller.searchRecipe(etRecipeSearch.getText().toString());
                int i = 0;
                while(recipeArray == null && i < 10){   //Wait until something has been received or if it takes to long...break.
                    recipeArray = controller.getRecipeArray();  //Search results in ArrayList form.
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
                initList();

            }
        });
        ctex = this.getActivity();
        return view;
    }

    public void initList() {
        recipeArray = controller.getRecipeArray();
        if(recipeArray != null) {
            recipeAdapter = new se.limhamn.ted.apps.trf_apiproject.recipeAdapter(ctex, recipeArray);
            recipeListView.setAdapter(recipeAdapter);

            recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    controller.getRecipeIngredient(recipeArray.get(i).getId());
                }
            });
        }
    }

}

