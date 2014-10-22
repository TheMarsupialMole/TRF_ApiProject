package se.limhamn.ted.apps.trf_apiproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom ArrayAdapter for listing recipes
 */
public class recipeAdapter extends ArrayAdapter {
    private MainActivity context;
    private ArrayList<String> recipeArray;

    /**
     * Constructor with a MainActivity parameter and an ArrayList-parameter with recipes
     * @param context
     * @param recipeArray
     */
    public recipeAdapter(MainActivity context, ArrayList<String> recipeArray) {
        super(context, R.layout.recipe_layout, recipeArray);
        this.context = context;
        this.recipeArray = recipeArray;
    }

    /**
     * Overridden method for a custom layout and sets the text in the textView
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
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
