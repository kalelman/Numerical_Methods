package com.kalelman.numerical_methods.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kalelman.numerical_methods.R;
import com.kalelman.numerical_methods.activity.MainActivity;

/**
 * Created by Erick Rojas Perez on December/03/18.</br>
 * SplashScreen.</br>
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
