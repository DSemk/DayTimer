package com.eurotech.samik.daytimer;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.eurotech.samik.daytimer.fragments.AboutFragment;
import com.eurotech.samik.daytimer.fragments.StatisticFragment;
import com.eurotech.samik.daytimer.fragments.TodayFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TodayFragment todayFragment;

    StatisticFragment statisticFragment;
    AboutFragment aboutFragment;
    FragmentTransaction fTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationBar();
        initFragments();

        fTransaction = getFragmentManager().beginTransaction();
        fTransaction.add(R.id.ma_container, todayFragment);
        fTransaction.commit();
    }


    private void initFragments() {
        todayFragment = new TodayFragment();
        statisticFragment = new StatisticFragment();
        aboutFragment = new AboutFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        fTransaction = getFragmentManager().beginTransaction();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_today) {
            fTransaction.replace(R.id.ma_container, todayFragment);
        } else if (id == R.id.nav_statistic) {
            fTransaction.replace(R.id.ma_container, statisticFragment);
        } else if (id == R.id.nav_about) {
            fTransaction.replace(R.id.ma_container, aboutFragment);
        } else if (id == R.id.nav_exit) {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        fTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initNavigationBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
