package se.limhamn.ted.apps.trf_apiproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends Activity {

    private Controller controller;
    private FragmentManager fragmentManager;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        controller = new Controller(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Add first fragment to the activity
        fragmentManager = getFragmentManager();
        searchFragment = (SearchFragment)fragmentManager.findFragmentById(R.id.fragSearch);
        if(searchFragment == null)
            searchFragment = new SearchFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragContain, searchFragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        controller.stop();
    }
}
