package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.MainActivity;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Tab3Fragment extends RootFragment {

    String mcolor;
    String mcode;
    String mname;
    String mcolorcode;

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle  = new LinkedList<>();
    List<String> CodeColor = new LinkedList<String>();
    HashMap<String, String> expandableListDetail = new HashMap<>();


    public Tab3Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView = inflater.inflate(R.layout.fragment_tab3, container, false);
   /*     rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tab3Fragment tab3Fragment = new Tab3Fragment();
                FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragment_mainLayout,tab3Fragment);

            }
        });
        */
        expandableListView = (ExpandableListView) rootView.findViewById(R.id.expListView);

        MainActivity mainActivity =(MainActivity) getActivity();
        Bundle args = mainActivity.getBundle();

        mname = args.getString("mname");
        mcolorcode = args.getString("codecolor");
        //CodeColor.add(mcolorcode);

        if (mname!=null && mcolorcode != null) {
            expandableListDetail.put(mname, mcolorcode);
            expandableListTitle.add(mname);

            args.clear();
        }


        expandableListAdapter = new CustomExpandableListAdapter(getActivity(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if ((previousGroup != -1) && (groupPosition != previousGroup)) {
                    expandableListView.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;
                Toast.makeText(getActivity().getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getActivity().getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getActivity().getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });


        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.addToBackStack(null);


        return rootView;
    }

}

