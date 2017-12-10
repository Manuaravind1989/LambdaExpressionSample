package com.mobiledev.lambdalombok.javaEightFeatures.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.mobiledev.lambdalombok.R;
import com.mobiledev.lambdalombok.dataTemplate.MoviesModel;
import com.mobiledev.lambdalombok.dataTemplate.TempaeroryData;
import com.mobiledev.lambdalombok.utils.LogUtils;
import com.mobiledev.lambdalombok.utils.MathCalculas;
import com.mobiledev.lambdalombok.utils.MathOperations;


/**
 * Created by manu on 12/10/2017.
 */

public class FragmentReference extends Fragment {

    private View rootView;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_reference,container,false);

        Gson gson = new Gson();
        MoviesModel moviesModel = gson.fromJson(TempaeroryData.response, MoviesModel.class);

        //Method Reference to static Method
        for(MoviesModel.DataBean dataBean : moviesModel.getData()){
            Movie movie = LogUtils::logError;
            movie.print(dataBean.getTitle());
        }

        //Reference to a constructor
        referencetoConstructor();

        //Reference to an instance method of a particular object
        referencetoParticularMethod();
        return rootView;
    }

    private void referencetoConstructor(){
        System.out.println("------------Using lambda expression------------");
        MathOperable addtion1 = (a, b) -> new MathOperations(a, b);
        addtion1.accept(10, 20);

        System.out.println("\n------------Using method reference------------");
        MathOperable addtion2 = MathOperations::new;
        addtion2.accept(50, 20);
    }


    private void referencetoParticularMethod(){
        MathCalculas op = new MathCalculas();

        System.out.println("--------------------Using lambda expression----------------------");
        MathCalculator add1 = (a, b) -> op.add(a, b);
        Log.e("Addtion = ","" + add1.acceptingData(4, 5));

        MathCalculator sub1 = (a, b) -> op.sub(a, b);
        Log.e("Subtraction = ","" + sub1.acceptingData(58, 5));

        System.out.println("---------------------Using method reference---------------------");
        MathCalculator add2 = op::add;
        Log.e("Addtion = ","" + add2.acceptingData(4, 5));

        MathCalculator sub2 = op::sub;
        Log.e("Subtraction = " ,""+ sub2.acceptingData(58, 5));
    }


}

@FunctionalInterface
interface  Movie {
    void print(String ok);
}


@FunctionalInterface
interface MathOperable {
    void accept(int a , int b);
}

@FunctionalInterface
interface MathCalculator{
   int acceptingData(int a , int b);
 }