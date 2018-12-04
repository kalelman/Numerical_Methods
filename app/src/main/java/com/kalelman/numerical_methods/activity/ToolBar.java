package com.kalelman.numerical_methods.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.kalelman.numerical_methods.R;

import butterknife.BindView;

/**
 * @author Erick Rojas Perez
 * @date December/04/2018
 * @description Immplementation of a ToolBar properties using Abstract class for all project
 */
public abstract class ToolBar extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    /**
     * Get resource from the Layout
     * @return the layout resource
     */
    protected abstract int getLayoutResource();

    /**
     * Set the Title of ActionBar
     * @param titleActionBar
     */
    public void setTitleActionBar(String titleActionBar) {
        getSupportActionBar().setTitle(titleActionBar);
    }
}
