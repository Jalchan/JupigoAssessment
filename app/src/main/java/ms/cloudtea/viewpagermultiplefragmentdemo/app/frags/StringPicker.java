package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;

/**
 * Created by Jal on 7/25/17.
 */

public class StringPicker extends RootFragment {

    FragmentToActivity mCallback;
    String[] items = new String[]{"Red", "Yellow", "Blue", "Green", "Purple"};
    Button mButton;
    NumberPicker mNumberPicker;
    String color;

    public StringPicker() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (FragmentToActivity) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_picker, container, false);

        mNumberPicker = (NumberPicker) rootView.findViewById(R.id.colorPicker);
        mNumberPicker.setMinValue(0);
        mNumberPicker.setMaxValue(items.length-1);
        mNumberPicker.setDisplayedValues(items);

        mButton = (Button) rootView.findViewById(R.id.done_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                 //bundle = new Bundle();
                Tab1Fragment tab1Fragment = new Tab1Fragment();
                color = items[mNumberPicker.getValue()];
                //tab1Fragment.refresh();
                //bundle.putString("color",color);
                //tab1Fragment.setArguments(bundle);
                mCallback.SendColor(color);
                Toast.makeText(getActivity(),color,Toast.LENGTH_SHORT).show();


                FragmentManager manager = getActivity().getSupportFragmentManager();
                manager.popBackStack();


            }
        });

        return rootView;
    }


}
