package gymkhana.iitb.ac.in.fragmentexample;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {

    private static final String TAG = TextFragment.class.getSimpleName();



    private TextView textView;

    public TextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_text, container, false);
        textView = (TextView) rootView.findViewById(R.id.text_view);
        return rootView;
    }

    public void changeTextColor(int red,int green,int blue){
        Log.i(TAG, "changeTextColor called with color:" + red+","+green+","+blue);
        textView.setTextColor(Color.rgb(red,green,blue));
    }
}
