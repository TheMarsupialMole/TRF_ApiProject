package se.limhamn.ted.apps.trf_apiproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Custom ArrayAdapter for listing recipes
 */
public class recipeAdapter<T> extends ArrayAdapter {
    private Context context;
    private View view;
   // private MainActivity context;
    private ArrayList<T> recipeArray;

    /**
     * Constructor with a MainActivity parameter and an ArrayList-parameter with recipes
     * @param context
     * @param recipeArray
     */
    public recipeAdapter(Context context, ArrayList<T> recipeArray) {
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
        LayoutInflater inflater = LayoutInflater.from(context);
        if (itemView == null) {
            itemView = inflater.inflate(R.layout.recipe_layout, parent, false);
        }

        RecipeBase currentRecipe = (RecipeBase)recipeArray.get(position);

        TextView recipeText = (TextView)itemView.findViewById(R.id.tvAdapterRecipe);
        recipeText.setText(currentRecipe.getTitle() + "   " + currentRecipe.getCategory());

        return itemView;
    }
}
