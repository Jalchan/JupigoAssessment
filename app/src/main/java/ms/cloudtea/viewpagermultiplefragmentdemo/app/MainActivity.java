package ms.cloudtea.viewpagermultiplefragmentdemo.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.frags.FragmentToActivity;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.frags.Tab1Fragment;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.frags.Tab3Fragment;


public class MainActivity extends ActionBarActivity implements FragmentToActivity{

    private CarouselFragment carouselFragment;
    Bundle args1 = new Bundle();
    Bundle args2 = new Bundle();
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        if (savedInstanceState == null) {
            // withholding the previously created fragment from being created again
            // On orientation change, it will prevent fragment recreation
            // its necessary to reserving the fragment stack inside each tab
            initScreen();

        } else {
            // restoring the previously created fragment
            // and getting the reference

            carouselFragment = (CarouselFragment) getSupportFragmentManager().getFragments().get(0);
        }
    }

    private void initScreen() {
        // Creating the ViewPager container fragment once
        carouselFragment = new CarouselFragment();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, carouselFragment)
                .commit();
    }

    public Bundle getBundle(){
        return args1;
    }
    public Bundle getBundle2(){return args2;}

    /**
     * Only Activity has this special callback method
     * Fragment doesn't have any onBackPressed callback
     *
     * Logic:
     * Each time when the back button is pressed, this Activity will propagate the call to the
     * container Fragment and that Fragment will propagate the call to its each tab Fragment
     * those Fragments will propagate this method call to their child Fragments and
     * eventually all the propagated calls will get back to this initial method
     *
     * If the container Fragment or any of its Tab Fragments and/or Tab child Fragments couldn't
     * handle the onBackPressed propagated call then this Activity will handle the callback itself
     */
    @Override
    public void onBackPressed() {

        if (!carouselFragment.onBackPressed()) {
            // container Fragment or its associates couldn't handle the back pressed task
            // delegating the task to super class
            super.onBackPressed();

        } else {
            // carousel handled the back pressed task
            // do not call super
        }
    }

    @Override
    public void SendData(String code, String name, String color, String codecolor) {

        if(code.length()>=0 && code.length()<5 && name!= null && codecolor !=null) {
            args1.putString("mcode", code);
            args1.putString("mname", name);
            args1.putString("mcolor", color);
            args1.putString("codecolor", codecolor);


            Tab3Fragment tab3Fragment = new Tab3Fragment();
            tab3Fragment.setArguments(args1);
        }
    }
    @Override
    public void SendColor(String color){

        if (color!=null){
            args2.putString("mcolor",color);
            Tab1Fragment tab1Fragment = new Tab1Fragment();
            tab1Fragment.setArguments(args2);
            //button = tab1Fragment.getButton();
            //button.setText(color);
        }
    }

}
