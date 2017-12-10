package com.mobiledev.lambdalombok.javaEightFeatures;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.mobiledev.lambdalombok.R;
import com.mobiledev.lambdalombok.javaEightFeatures.fragment.FragmentHome;

/**
 * Created by manu on 12/10/2017.
 */

public class LambdaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda);
        navigation(new FragmentHome());
    }
    public void navigation(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();
    }


}
