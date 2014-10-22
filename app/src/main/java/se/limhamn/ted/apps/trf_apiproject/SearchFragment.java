package se.limhamn.ted.apps.trf_apiproject;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SearchFragment extends Fragment {
    private ListView recipeListView;
    private Button btnSearch;
    private EditText etRecipeSearch;
    private Controller controller;

    public SearchFragment() {
        // Required empty public constructor
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recipeListView = (ListView)view.findViewById(R.id.lvRecipeList);
        etRecipeSearch = (EditText)view.findViewById(R.id.etSearch);
        btnSearch = (Button)view.findViewById(R.id.btnSearchRecipe);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.searchRecipe(etRecipeSearch.getText().toString());
            }
        });
        return view;
    }
}
