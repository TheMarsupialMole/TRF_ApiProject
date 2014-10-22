package se.limhamn.ted.apps.trf_apiproject;

import android.os.AsyncTask;
import android.util.JsonReader;

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

/**
 * Created by Ted on 2014-10-21.
 */
public class AsyncQueryEngine extends AsyncTask {

    private Socket socket;
    private InputStream is;
    private DataInputStream dis;
    private OutputStream os;
    private DataOutputStream dos;

    private final String USER_AGENT = "Mozilla/5.0";

    private boolean x = true;

    private String recipe = "";
    private String url = "";
    private String apiKey = "dvx7j5VyCichI8al74FY5T3iy62TT4fk";

    public AsyncQueryEngine(){
        this.execute();
    }

    public void setAndSearchRecipe(String recipe){
        this.recipe = recipe;
        url = "http://api.bigoven.com/recipes?pg=1&rpp=25&title_kw="
                + recipe
                + "&api_key="+apiKey;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        while(x = true) {
            if(!url.equals("")) {
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
                con.setRequestProperty("User-Agent", USER_AGENT);

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
                    String nisse = "sdf";
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                url = "";
            }
        }

        return null;

    }


}
