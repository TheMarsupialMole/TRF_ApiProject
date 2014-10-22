package se.limhamn.ted.apps.trf_apiproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by radde on 14-10-22.
 */
public class recipeAdapter extends ArrayAdapter {
    private MainActivity context;
    private ArrayList<String> recipeArray;

    public recipeAdapter(MainActivity context, ArrayList<String> recipeArray) {
        super(context, R.layout.recipe_layout, recipeArray);
        this.context = context;
        this.recipeArray = recipeArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = context.getLayoutInflater().inflate(R.layout.recipe_layout, parent, false);
        }

        String CurrentRecipe = recipeArray.get(position);

        TextView recipeText = (TextView)itemView.findViewById(R.id.tvAdapterRecipe);
        recipeText.setText(CurrentRecipe);

        return itemView;
    }
}
