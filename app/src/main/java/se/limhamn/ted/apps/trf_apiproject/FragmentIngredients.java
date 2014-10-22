package se.limhamn.ted.apps.trf_apiproject;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class FragmentIngredients extends Fragment {
    private ListView listview;


    public FragmentIngredients() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ingredients_list, container, false);
        listview = (ListView)view.findViewById(R.id.listIngredients);
        return view;
    }


}
