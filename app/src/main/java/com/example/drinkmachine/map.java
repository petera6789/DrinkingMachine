package com.example.drinkmachine;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zolad.zoominimageview.ZoomInImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class map extends Fragment {
    int current_map;

    public map() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        int abc = MacInfoActivity.macNum;
        ZoomInImageView map =  view.findViewById(R.id.location);
        if(abc == 1){
            map.setImageResource(R.mipmap.floor1);
        }
        else if (abc ==2){
            map.setImageResource(R.mipmap.floor_plan2);
        }
        else if (abc ==3){
            map.setImageResource(R.mipmap.floor_plan3);
        }
        else if (abc ==4){
            map.setImageResource(R.mipmap.floor_plan4);
        }

        // Inflate the layout for this fragment
        return view;

    }

}
