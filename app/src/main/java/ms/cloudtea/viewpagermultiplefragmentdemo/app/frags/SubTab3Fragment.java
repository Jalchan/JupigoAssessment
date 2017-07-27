package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;

/**
 * Created by Jal on 7/23/17.
 */

public class SubTab3Fragment extends RootFragment {


    public SubTab3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_subtab3, container, false);

        return rootView;
    }


}
