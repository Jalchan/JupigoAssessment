package ms.cloudtea.viewpagermultiplefragmentdemo.app.frags;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.R;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.ViewPagerAdapter2;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class Tab2Fragment extends RootFragment {
    private FragmentTabHost tabHost;
    ViewPager mViewPager;
    ViewPagerAdapter2 mViewPagerAdapter2;
    android.app.ActionBar actionBar;
    private String[] tabs = { "Top Rated", "Games", "Movies" };
    public Tab2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
/*
        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mViewPagerAdapter2 = new ViewPagerAdapter2(getFragmentManager());
        mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
        mViewPager.setAdapter(mViewPagerAdapter2);
        actionBar = getActivity().getActionBar();
  */

        tabHost = new FragmentTabHost(getActivity());
        tabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_tab2);
        Bundle arg1 = new Bundle();
        arg1.putInt("Arg for Frag1", 1);
        tabHost.addTab(tabHost.newTabSpec("Tab1").setIndicator("SUB TAB 1"),
                SubTab1Fragment.class, arg1);

        Bundle arg2 = new Bundle();
        arg2.putInt("Arg for Frag2", 2);
        tabHost.addTab(tabHost.newTabSpec("Tab2").setIndicator("SUB TAB 2"),
                SubTab2Fragment.class, arg2);

        Bundle arg3 = new Bundle();
        arg2.putInt("Arg for Frag3", 3);
        tabHost.addTab(tabHost.newTabSpec("Tab3").setIndicator("SUB TAB 3"),
                SubTab3Fragment.class, arg3);


//        FragmentManager manager = getActivity().getSupportFragmentManager();
  //      FragmentTransaction fragmentTransaction = manager.beginTransaction();
    //    fragmentTransaction.addToBackStack(null);
        return tabHost;

    }

//        return rootView;
//    }

}
