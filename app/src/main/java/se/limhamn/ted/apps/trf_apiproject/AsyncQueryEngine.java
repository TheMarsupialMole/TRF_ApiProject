package se.limhamn.ted.apps.trf_apiproject;

import android.os.AsyncTask;
import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Ted on 2014-10-21.
 */
public class AsyncQueryEngine extends AsyncTask {

    private Socket socket;
    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;

    private Controller controller;

    private JSONArray jArr = null;

    private final String USER_AGENT = "Mozilla/5.0";

    private boolean x = true;//vilkor för whilesats nödvändig för att return ska fungera

    private String recipe = "";
    private String url = "";
    private String apiKey = "dvx7j5VyCichI8al74FY5T3iy62TT4fk";

    public AsyncQueryEngine(Controller controller){
        this.controller = controller;
        this.execute();
    } //startar tråden

    public void setAndSearchRecipe(String recipe){ //skapar en url med önskat recept//sökvägen
        this.recipe = recipe;
        url = "http://api.bigoven.com/recipes?pg=1&rpp=25&title_kw=" + recipe  + "&api_key="+apiKey;

    }


    public void getAndSetIngredients(String id) {
        url = "http://api.bigoven.com/recipe/" + id + "?api_key="+apiKey;
    }

    @Override
    protected Object doInBackground(Object[] objects) { //en tråd som används för att hämta info från APIerna

        while(x = true) {
            if(!url.equals("")) { //om url inte är tom genomför if satsen
                URL obj = null;
                try {
                    obj = new URL(url);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection con = null;

                try {
                    con = (HttpURLConnection) obj.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // optional default is GET
                try {
                    con.setRequestMethod("GET");
                } catch (ProtocolException e) {
                    e.printStackTrace();
                }

                //add request header
                con.setRequestProperty("accept", "application/json");

                int responseCode = 0;
                try {
                    responseCode = con.getResponseCode();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                BufferedReader in = null;
                try {
                    in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String inputLine;
                StringBuffer response = new StringBuffer();

                try {
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String s = String.valueOf(response);
                try {
                    JSONObject jsonObject = new JSONObject(s);

                    if(jsonObject.has("Results")){
                        jArr = jsonObject.getJSONArray("Results");
                        ArrayList<RecipeBase> recipeList = new ArrayList<RecipeBase>();

                        for (int i = 0; i < jArr.length(); i++) {
                            recipeList.add(new RecipeBase(jArr.getJSONObject(i).getString("Title"), jArr.getJSONObject(i).getString("Category"),
                                    jArr.getJSONObject(i).getString("RecipeID")));
                        }
                        publishProgress(recipeList);
                        jArr = null;
                    }
                    else if(jsonObject.has("Ingredients")){
                        JSONArray jArr = jsonObject.getJSONArray("Ingredients");
                        ArrayList<IngredientsBase> ingredientsList = new ArrayList<IngredientsBase>();

                        for (int i = 0; i < jArr.length(); i++) {
                            ingredientsList.add(new RecipeBase(jArr.getJSONObject(i).getString("Name"), jArr.getJSONObject(i).getString("Quantity"),
                                    jArr.getJSONObject(i).getString("MetricUnit")));
                        }
                        jArr = null;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                url = "";
            }
        }

        return null;

    }


    /**
     *
     * @param arrList
     */
    protected final void publishProgress(ArrayList<RecipeBase> arrList){//synkar med gui tråden
        controller.setRecipeArray(arrList);
    }

}
