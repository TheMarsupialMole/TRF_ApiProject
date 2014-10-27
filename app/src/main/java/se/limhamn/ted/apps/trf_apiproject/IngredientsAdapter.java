package se.limhamn.ted.apps.trf_apiproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ted on 2014-10-27.
 */
public class IngredientsAdapter extends ArrayAdapter {
    private Context context;
    private View view;
    // private MainActivity context;
    private ArrayList ingredientsArray;

    /**
     * Constructor with a MainActivity parameter and an ArrayList-parameter with recipes
     * @param context
     * @param ingredientsArray
     */
    public IngredientsAdapter(Context context, ArrayList ingredientsArray) {
        super(context, R.layout.ingredients_list, ingredientsArray);
        this.context = context;
        this.ingredientsArray = ingredientsArray;
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
            itemView = inflater.inflate(R.layout.ingredients_list, parent, false);
        }

        IngredientsBase currentIngredient = (IngredientsBase)ingredientsArray.get(position);

        TextView ingredientsText = (TextView)itemView.findViewById(R.id.ingredientsText);
        ingredientsText.setText(currentIngredient.getName() + "   " + currentIngredient.getQuantity() + "   " + currentIngredient.getMetricUnit());

        return itemView;
    }
}
