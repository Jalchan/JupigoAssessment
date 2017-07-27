package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import ms.cloudtea.viewpagermultiplefragmentdemo.app.MainActivity;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class NameDetailFragment extends RootFragment {
    String mcolor;
    String mcode;
    String mname;

    public NameDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_namedetail, container, false);
        TextView color = (TextView) rootView.findViewById(R.id.showcolor);
        TextView code = (TextView) rootView.findViewById(R.id.showcode);
        TextView name = (TextView) rootView.findViewById(R.id.showname);

        MainActivity mainActivity = (MainActivity)getActivity();
        Bundle args = mainActivity.getBundle();
        if(args != null) {
            mcolor = args.getString("mcolor");
            mcode = args.getString("mcode");
            mname = args.getString("mname");


            color.setText("Color: " + mcolor);
            code.setText("Code: " + mcode);
            name.setText("Name: " + mname);
        }
        //}


        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.addToBackStack(null);

        return rootView;
    }


}
