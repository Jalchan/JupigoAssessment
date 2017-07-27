package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SubTab1Fragment extends RootFragment {


    public SubTab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_subtab1, container, false);

        return rootView;
    }


}
