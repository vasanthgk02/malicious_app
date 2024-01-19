package com.clevertap.android.sdk.inbox;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class CTInboxTabAdapter extends FragmentPagerAdapter {
    public final Fragment[] fragmentList;
    public final List<String> fragmentTitleList = new ArrayList();

    public CTInboxTabAdapter(FragmentManager fragmentManager, int i) {
        super(fragmentManager);
        this.fragmentList = new Fragment[i];
    }

    public int getCount() {
        return this.fragmentList.length;
    }

    public Fragment getItem(int i) {
        return this.fragmentList[i];
    }

    public CharSequence getPageTitle(int i) {
        return this.fragmentTitleList.get(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        this.fragmentList[i] = (Fragment) instantiateItem;
        return instantiateItem;
    }
}
