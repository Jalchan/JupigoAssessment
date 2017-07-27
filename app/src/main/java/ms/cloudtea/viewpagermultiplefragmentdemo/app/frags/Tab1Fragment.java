package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.MainActivity;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Tab1Fragment extends RootFragment {


    FragmentToActivity mCallback;
    Button sbutton;
    Button submitbtn;
    EditText mcode;
    EditText mname;
    String selection="";
    String code="";
    String name="";
    String codecolor;


    public Tab1Fragment() {
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
        final MainActivity mMainActivity = (MainActivity) getActivity();
        Bundle args1 =mMainActivity.getBundle();
        final Bundle args2 = mMainActivity.getBundle2();


        sbutton = (Button) rootView.findViewById(R.id.selectbtn);
        submitbtn = (Button) rootView.findViewById(R.id.submitbtn);
        mcode = (EditText) rootView.findViewById(R.id.code);
        mname = (EditText) rootView.findViewById(R.id.name);


        mcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //String thecode = mcode.getText().toString();
            }
        });



        mname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            /*    String thename = mname.getText().toString();

                if(thename!= null){
                    submitbtn.setBackgroundColor(0xff444444);
                }else{
                    submitbtn.setBackgroundColor(0xffcccccc);
                }
*/
            }
        });


        sbutton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ChooseColor();

                }
            });


/*

*/
            submitbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selection = args2.getString("mcolor");

                name = mname.getText().toString();
                code = mcode.getText().toString();

                codecolor = code + ""+ selection;
                if(code.length()<=4 && code.length()>0 && name!= null && selection != null) {
                    mCallback.SendData(code, name, selection, codecolor);
                    ChangeFragment();
                } else{
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Please complete!",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });




        return rootView;
    }


    public void ChooseColor(){

        StringPicker stringPicker = new StringPicker();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.add(R.id.picker, stringPicker);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }

    public void ChangeFragment() {

        NameListFragment nameListFragment = new NameListFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        //FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_mainLayout, nameListFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



    public void setButton(String color){
        sbutton.setText(color);
    }
}
