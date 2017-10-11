package com.example.carlos.sesion9;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.carlos.sesion9.beans.User;

import layout.FragmentElectronics;
import layout.FragmentHome;
import layout.FragmentTechnology;

public class ActivityMain extends AppCompatActivity {

    private Toolbar tb;
    private TabLayout tl;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb = (Toolbar) findViewById(R.id.activity_main_toolbar);
        tl = (TabLayout) findViewById(R.id.activity_main_tabs);
        vp = (ViewPager) findViewById(R.id.activity_main_viewpager);

        setSupportActionBar(tb);

        SectionsPagerAdapter mSection = new SectionsPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mSection);
        tl .setupWithViewPager(vp);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.main_menu_logoff:
                //delete Prefferences
                User user = new User();
                user.deletePreferences(this);

                Intent intent = new Intent(this, ActivityLogin.class);
                startActivity(intent);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter{
        public SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentTechnology();
                case 1:
                    return new FragmentHome();
                case 2:
                    return new FragmentElectronics();
                default:
                    return new FragmentTechnology();
            }
        }
        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public CharSequence getPageTitle(int position) {

            switch(position){
                case 0: return getString(R.string.fragment_tab1);
                case 1: return getString(R.string.fragment_tab2);
                case 2: return getString(R.string.fragment_tab3);
            }
            return super.getPageTitle(position);
        }
    }

    public static class PlaceHolder extends Fragment{
        public static PlaceHolder newInstance(){
            PlaceHolder fragment = new PlaceHolder();
            return fragment;
        }

        public PlaceHolder(){}

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
