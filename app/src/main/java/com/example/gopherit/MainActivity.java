package com.example.gopherit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

//    private Fragment eventSearchFragment;
//    private Fragment mapFragment;
//    private Fragment gameSearchFragment;
//    private Fragment profileSearchFragment;

    // Drawer Navigation Setup
    private AppBarConfiguration mAppBarConfiguration;

    //public variables for settings
    public boolean isNightmode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Nightmode Setup
        isNightmode = false;
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        //setContentView(R.layout.activity_main);
        setContentView(R.layout.drawer_layout);

//        eventSearchFragment = new EventSearchFragment();


//        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.action_home:
//                        updateFragment(eventSearchFragment);
//                        break;
//                    case R.id.action_map:
//                        updateFragment(mapFragment);
//                        break;
//                    case R.id.action_game:
//                        updateFragment(gameSearchFragment);
//                        break;
//                    case R.id.action_profile:
//                        updateFragment(profileSearchFragment);
//                        break;
//                }
//                return true;
//            }
//        });

//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.activity_main, eventSearchFragment)
//                .addToBackStack(null)
//                .commit();

        // Drawer Navigation Setup

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_game, R.id.nav_map, R.id.nav_profile)
                .setDrawerLayout(drawer)
                .build();



        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // BottomNavigation Setup
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        NavigationUI.setupWithNavController(bottomNav,navController);


        // DrawerNavigation Setup
        //NavController navController2 = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationView navigationView = findViewById(R.id.nav_view);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



    }

    //remove overflow button from toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void updateFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, fragment)
                .commit();
    }


}
