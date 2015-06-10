package gymkhana.iitb.ac.in.fragmentexample;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Check the import statement for fragment was from
 * the support library
 */
public class ColorChooserFragment extends Fragment {

    /**
     * Log tag used for filtering log
     * statements of this class
     */
    private static final String TAG = ColorChooserFragment.class.getSimpleName();

    /**
     * Define all views in layout
     */
    private SeekBar redLevelSlider;
    private SeekBar greenLevelSlider;
    private SeekBar blueLevelSlider;
    private TextView redLevelTextView;
    private TextView greenLevelTextView;
    private TextView blueLevelTextView;

    /**
     * Variables indicating rgb levels
     */
    private int redValue,greenValue,blueValue;

    /**
     * Call back object
     */
    private TextColorListener textColorListener;

    public ColorChooserFragment() {
        // Required empty public constructor
    }

    /**
     * Called when the fragment is first attached to the
     * parent activity
     * @param activity to initialize the listener so that
     * we can communicate with it
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /**
         * The following code can also be encapsulated in
         * a try/catch block with a {@link ClassCastException}
         * but usually it is best practice to
         * not let you apps/projects get an exception
         */
        if ((activity instanceof TextColorListener)){
            textColorListener = (TextColorListener) activity;
        }else{
            Log.e(TAG, "Activity must implement TextColorListener");
        }
    }

    /**
     *
     * @param inflater to inflate the fragment xml
     * @param container parent
     * @param savedInstanceState Bundle to pass optional configuration data
     * @return the view for the fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_color_chooser, container, false);;

        /**
         * Initialise all views
         */
        redLevelSlider = (SeekBar) rootView.findViewById(R.id.red_slider);
        greenLevelSlider = (SeekBar) rootView.findViewById(R.id.green_slider);
        blueLevelSlider = (SeekBar) rootView.findViewById(R.id.blue_slider);
        redLevelTextView = (TextView) rootView.findViewById(R.id.red_value);
        greenLevelTextView = (TextView) rootView.findViewById(R.id.green_value);
        blueLevelTextView = (TextView) rootView.findViewById(R.id.blue_value);

        /**
         * Set max values for sliders
         */
        redLevelSlider.setMax(255);
        greenLevelSlider.setMax(255);
        blueLevelSlider.setMax(255);
        redLevelSlider.setProgress(0);
        greenLevelSlider.setProgress(0);
        blueLevelSlider.setProgress(0);

        /**
         * Add listeners for sliders to have
         * callbacks to update text
         * {@link android.widget.SeekBar.OnSeekBarChangeListener}
         * is an interface defined for {@link SeekBar} to track progress
         * just like  {@link android.view.View.OnClickListener}
         * for {@link android.widget.Button}
         */
        redLevelSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redValue = progress;
                /**
                 * need to cast it to String otherwise
                 * you'll get an exception
                 */
                redLevelTextView.setText(String.valueOf(redValue));
                textColorListener.onSliderChange(redValue, greenValue, blueValue);
            }

            /**
             *We don't need to do anything on the following callbacks
             * so just left blank
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        greenLevelSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenValue = progress;
                greenLevelTextView.setText(String.valueOf(greenValue));
                textColorListener.onSliderChange(redValue, greenValue, blueValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        blueLevelSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueValue = progress;
                blueLevelTextView.setText(String.valueOf(blueValue));
                textColorListener.onSliderChange(redValue,greenValue,blueValue);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        return rootView;
    }

    /**
     * Interface for listening to progress updates
     */
    public interface TextColorListener{
        void onSliderChange(int red,int green,int blue);
    }

}
