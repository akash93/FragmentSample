package gymkhana.iitb.ac.in.fragmentexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ColorChooserFragment.TextColorListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextFragment textFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Initialise the fragment
         * Using {@link getSupportFragmentManager} instead
         * of {@link getFragmentManager} since we are using the support
         * library for showing fragments till API 10
         */
        textFragment = (TextFragment) getSupportFragmentManager().findFragmentById(R.id.text_fragment);
    }


    /**
     * Callback used for transferring data across fragments
     */
    @Override
    public void onSliderChange(int red, int green, int blue) {
        Log.i(TAG, "onSliderChange called");
        textFragment.changeTextColor(red,green,blue);
    }
}
