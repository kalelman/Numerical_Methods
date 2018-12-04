package com.kalelman.numerical_methods.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kalelman.numerical_methods.R;
import com.kalelman.numerical_methods.fragment.ContentFragmentOption1;
import com.kalelman.numerical_methods.fragment.ContentFragmentOption2;
import com.kalelman.numerical_methods.fragment.ContentFragmentOption3;
import com.kalelman.numerical_methods.fragment.ContentFrarmentOptionMain;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Created by Erick Rojas Perez
 * @date   December/04/2018
 * @description Main Activity container for all app content App
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.textView_toolbar)
    TextView titleToolBar;
    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setTitle(R.string.toolbar_title);

        }

        setText();
        showMainScreen();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.main:
                        showMainScreen();
                        titleToolBar.setText("Main");
                        return true;

                    case R.id.option1:
                        ContentFragmentOption1 fragmentOption1 = new ContentFragmentOption1();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment, fragmentOption1);
                        transaction.addToBackStack(null); // just for remember the capacity to come back to the previus fragment
                        transaction.commit();
                        titleToolBar.setText("Bisection");
                        return true;

                    case R.id.option2:
                        ContentFragmentOption2 fragmentOption2 = new ContentFragmentOption2();
                        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                        t.replace(R.id.fragment, fragmentOption2);
                        t.addToBackStack(null);
                        t.commit();
                        titleToolBar.setText("Option2");
                        return true;

                    case R.id.option3:
                        ContentFragmentOption3 fragmentMistery = new ContentFragmentOption3();
                        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
                        trans.replace(R.id.fragment, fragmentMistery);
                        trans.addToBackStack(null);
                        trans.commit();
                        titleToolBar.setText("Option3");
                        return true;

                    default:
                        return false;
                }
            }
        });

    }

    /**
     * Set the Text for the Activity
     */
    private void setText() {
        titleToolBar.setText(R.string.txt_main);
    }

    /**
     * Get resource from the Layout
     * @return the layout resource
     */
    /*@Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }*/

    /**
     * Implement the Main View in a fragment and return a true vaule for
     * the case of switch statement
     * @return Boolean true
     */
    private void showMainScreen() {
        ContentFrarmentOptionMain fragmentMain = new ContentFrarmentOptionMain();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragmentMain);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * Inflate the menu of the ToolBar
     * @param menu
     * @return boolean true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
