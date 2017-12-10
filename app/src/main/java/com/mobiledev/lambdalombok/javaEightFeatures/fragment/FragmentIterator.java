package com.mobiledev.lambdalombok.javaEightFeatures.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mobiledev.lambdalombok.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by manu on 12/10/2017.
 */

public class FragmentIterator extends Fragment implements View.OnClickListener{
    private Button simpleArrayButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_iterator, container, false);
        simpleArrayButton = rootView.findViewById(R.id.simpleArrayButton);
        simpleArrayButton.setOnClickListener(this);

        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simpleArrayButton:{
                simpleArrayIteration();
            }
            break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void simpleArrayIteration(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //Old way:
        for (Integer n : list) {
            System.out.println(n);
        }
        //New way:
        list.forEach(n -> System.out.println(n));
    }










//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void comparisonString(){
//        /* sorts all elements in a collection using a lambda expression as comparator */
//        List names = Arrays.asList( "prado", "gugenheim", "reina sofia", "louvre" );
//        Collections.sort( names, (String a, String b ) -> b.compareTo( a ) );
//        names.forEach( e -> System.out.println( e ) );
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void simpleList() {
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        //Old way:
//        for (Integer n : list) {
//            System.out.println(n);
//        }
//        //New way:
//        list.forEach(n -> System.out.println(n));
//        //or we can use :: double colon operator in Java 8
//        list.forEach(System.out::println);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    private void simpeListIteration() {
//        List<String> list = new ArrayList<>();
//        list.add("Rick");
//        list.add("Negan");
//        list.add("Daryl");
//        list.add("Glenn");
//        list.add("Carl");
//
//        /* Iterate without using Lambda
//		 Iterator iterator = list.iterator();
//		 while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		 }
//		*/
//        list.forEach(
//                // lambda expression
//                (names) -> System.out.println(names)
//        );
//    }
}
