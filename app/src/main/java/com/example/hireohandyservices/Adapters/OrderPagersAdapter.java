package com.example.hireohandyservices.Adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OrderPagersAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentsList = new ArrayList<>();
    private final List<String> FragmentListTitle = new ArrayList<>();

    public OrderPagersAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return FragmentListTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListTitle.get(position);
    }


    public void addfragment (Fragment fragment, String title)
    {
        fragmentsList.add(fragment);
        FragmentListTitle.add(title);
    }
}
