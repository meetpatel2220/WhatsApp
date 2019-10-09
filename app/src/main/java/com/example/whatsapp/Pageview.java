package com.example.whatsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Pageview extends FragmentPagerAdapter {
    public Pageview(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new Chats();
            case 1:
                return new Status();

            case 2:
                return new Calls();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
