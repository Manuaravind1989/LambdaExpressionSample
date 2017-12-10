package com.mobiledev.lambdalombok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobiledev.lambdalombok.javaEightFeatures.LambdaActivity;
import com.mobiledev.lambdalombok.network.NetworkActivity;

public class MainActivity extends AppCompatActivity {
    private Button serviceButton, java8FeatureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceButton = findViewById(R.id.serviceButton);
        serviceButton.setOnClickListener((View v) -> {
           Intent intent = new Intent(MainActivity.this, NetworkActivity.class);
           startActivity(intent);
        } );
        java8FeatureButton = findViewById(R.id.java8FeatureButton);
        java8FeatureButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, LambdaActivity.class);
            startActivity(intent);
        } );
    }
}
