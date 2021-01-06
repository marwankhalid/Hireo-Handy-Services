package com.example.hireohandyservices.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hireohandyservices.Fragments.BlankFragment;
import com.example.hireohandyservices.Fragments.JobsFragment;
import com.example.hireohandyservices.Fragments.OrderFragment;
import com.example.hireohandyservices.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private int fragment_flag=0;
    BottomNavigationView.OnNavigationItemSelectedListener navListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        connectViews();
        setFragment();
        setNavListnerAndBottomNavigation();

    }

    private void setFragment(){
        fragment_flag=1;
        fragment=new JobsFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_fragment,fragment);
        ft.commit();
    }

    private void connectViews(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        dl = (DrawerLayout)findViewById(R.id.activity_main);
        nv = (NavigationView)findViewById(R.id.nv);
    }

    private void setNavListnerAndBottomNavigation(){
        setBottomNavigationView();
        bottomNavigationView.setOnNavigationItemSelectedListener(navListner);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv.setItemIconTintList(null);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.item5)
                {
                    Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                    dl.closeDrawers();
                }
                else
                {
                    Toast.makeText(HomeActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                    dl.closeDrawers();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(t.onOptionsItemSelected(item)) {
            return true;

        }
        else if(id==R.id.men_refresh)
        {
            if (fragment_flag==1)
            {
                fragment=new JobsFragment();
            }
            else if(fragment_flag==2)
            {
                fragment = new OrderFragment();
                Toast.makeText(this, "Order History", Toast.LENGTH_SHORT).show();
            }
            else if(fragment_flag==3)
            {
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            }

            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.main_fragment,fragment);
            ft.commit();
        }

        return super.onOptionsItemSelected(item);
    }

    private void setBottomNavigationView(){
        navListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        if (menuItem.getItemId() == R.id.nav_jobs){
                            fragment_flag=1;
                            fragment=new JobsFragment();
                            FragmentManager fm=getSupportFragmentManager();
                            FragmentTransaction ft=fm.beginTransaction();
                            ft.replace(R.id.main_fragment,fragment);
                            ft.commit();

                        }
                        else if (menuItem.getItemId() == R.id.nav_orders){

                        fragment_flag=2;
                        fragment=new OrderFragment();
                        FragmentManager fm=getSupportFragmentManager();
                        FragmentTransaction ft=fm.beginTransaction();
                        ft.replace(R.id.main_fragment,fragment);
                        ft.commit();
                        Toast.makeText(HomeActivity.this, "Order History", Toast.LENGTH_SHORT).show();
                        }
                        else if (menuItem.getItemId()==R.id.nav_settings)
                        {
//                        fragment_flag=3;
//                        fragment=new ContractsFragment();
//                        FragmentManager fm=getSupportFragmentManager();
//                        FragmentTransaction ft=fm.beginTransaction();
//                        ft.replace(R.id.main_fragment,fragment);
//                        ft.commit();
                            Toast.makeText(HomeActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        }

                        //Toast.makeText(Dashboard.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();

                        return true;
                    }
                };

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menux, menu);
        return true;
    }


}