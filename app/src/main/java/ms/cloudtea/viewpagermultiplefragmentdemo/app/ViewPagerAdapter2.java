package ms.cloudtea.viewpagermultiplefragmentdemo.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ms.cloudtea.viewpagermultiplefragmentdemo.app.frags.SubTab1Fragment;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.frags.SubTab2Fragment;
import ms.cloudtea.viewpagermultiplefragmentdemo.app.frags.SubTab3Fragment;

/**
 * Created by Jal on 7/26/17.
 */

public class ViewPagerAdapter2  extends FragmentStatePagerAdapter{

    public ViewPagerAdapter2(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        final Fragment result;
        switch (i) {
            case 0:
                // First Fragment of First Tab
                result = new SubTab1Fragment();
                break;
            case 1:
                // First Fragment of Second Tab
                result = new SubTab2Fragment();
                break;
            case 2:
                // First Fragment of Third Tab
                result = new SubTab3Fragment();
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:

                    return "Sub 1";

                case 1:
                   return "Sub 2";

                case 2:
                    return "Sub 3";

            }
            return null;
    }
}