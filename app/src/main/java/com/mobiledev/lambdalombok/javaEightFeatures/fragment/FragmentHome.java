package com.mobiledev.lambdalombok.javaEightFeatures.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobiledev.lambdalombok.R;
import com.mobiledev.lambdalombok.javaEightFeatures.LambdaActivity;

/**
 * Created by manu on 12/10/2017.
 */

public class FragmentHome extends Fragment {

    private Button iteratorButton;
    private View rootView;
    private LambdaActivity lambdaActivity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home,container,false);
        lambdaActivity = (LambdaActivity)getActivity();
        iteratorButton = rootView.findViewById(R.id.iteratorButton);
        iteratorButton.setOnClickListener(v -> {
            lambdaActivity.navigation(new FragmentReference());
        });
        return rootView;
    }
}
