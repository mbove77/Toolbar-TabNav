package com.bove.martin.toolbar.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.bove.martin.toolbar.activities.MainActivity;
import com.bove.martin.toolbar.fragments.FormFragment;
import com.bove.martin.toolbar.fragments.ListFragment;

import java.util.HashMap;

import static com.bove.martin.toolbar.activities.MainActivity.FORM_FRAGMENT;
import static com.bove.martin.toolbar.activities.MainActivity.LIST_FRAGMENT;

/**
 * Created by Martín Bove on 03/05/2018.
 * E-mail: mbove77@gmail.com
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs;
    private HashMap mPageReferenceMap;

    public PagerAdapter(FragmentManager fm, int tabs) {
        super(fm);
        this.numberOfTabs = tabs;
        mPageReferenceMap = new HashMap();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case FORM_FRAGMENT:
                FormFragment formFragment = new FormFragment();
                mPageReferenceMap.put(position, formFragment);
                return formFragment;
            case LIST_FRAGMENT:
                ListFragment listFragment = new ListFragment();
                mPageReferenceMap.put(position, listFragment);
                return listFragment;
            default:
                return null;
        }
    }

    public Fragment getFragment(int key) {
        return (Fragment) mPageReferenceMap.get(key);
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        mPageReferenceMap.remove(position);
    }
}
