package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.MainActivity;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class NameListFragment extends RootFragment {

    static ArrayList<String> Namelist = new ArrayList<String>();
    static ArrayList<String> Codelist = new ArrayList<String>();
    static ArrayList<String> Colorlist = new ArrayList<String>();
    String name;
    String code;
    String color;
    ListView listView;


    public NameListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onResume() {
        super.onResume();
        MainActivity mainActivity = (MainActivity)getActivity();
        Bundle args = mainActivity.getBundle();
        name = args.getString("mname");
        code = args.getString("mcode");
        color = args.getString("mcolor");

        Namelist.add(name);
        Codelist.add(code);
        Colorlist.add(color);

        String[] listItems = new String[Namelist.size()];

        for(int i = 0; i < Namelist.size(); i++){
            String mName = Namelist.get(i);
            listItems[i] = mName;

            //  }
            ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(),R.layout.name,listItems);
            listView.setAdapter(adapter);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_namelist, container, false);
        listView = (ListView) rootView.findViewById(R.id.namelist);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                NameDetailFragment nameDetailFragment = new NameDetailFragment();
                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                //FragmentManager manager = getActivity().getSupportFragmentManager();
                //FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_mainLayout, nameDetailFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });





        return rootView;
    }

}
