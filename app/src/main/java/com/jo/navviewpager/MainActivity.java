package com.jo.navviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback, OnClickMovieListener {

    navMovieInfoFragment navFrag1;
    Toolbar toolbar;
    MovieInfoFragment movieInfoFragment;
    MovieDetailFragment movieDetailFragment;

    ArrayList<CommentItems> items;
    int requestCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.menu_movie_list);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        movieInfoFragment = MovieInfoFragment.newInstance();
        navFrag1 = new navMovieInfoFragment();
        movieDetailFragment = new MovieDetailFragment();

        //첫화면 movieInfoFragment 지정
        getSupportFragmentManager().beginTransaction().add(R.id.container, movieInfoFragment).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (movieInfoFragment.isAdded()) {
                finish();
            }
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentChanged(int index) {
        if (index == 0) {
            toolbar.setTitle(R.string.nav_MovieListString);
        } else if (index == 1) {
            toolbar.setTitle(R.string.nav_MovieApiString);
        } else if (index == 2) {
            toolbar.setTitle(R.string.nav_MovieResvationString);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, movieInfoFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_0) {
            onFragmentChanged(0);
        } else if (id == R.id.nav_1) {
            onFragmentChanged(1);
        } else if (id == R.id.nav_2) {
            onFragmentChanged(2);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClickMovie(int movieIdx) {
        toolbar.setTitle(R.string.detailString);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, movieDetailFragment).addToBackStack(null).commit();
    }
}
