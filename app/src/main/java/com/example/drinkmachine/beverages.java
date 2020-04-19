package com.example.drinkmachine;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zolad.zoominimageview.ZoomInImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class beverages extends Fragment {
    DatabaseReference database;
    int maxid;
    ImageView x1, x2, x3, x4, x5, x6, x7, x8, x9, xali, xocto, xcoin;
    public beverages() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beverages, container, false);
        int NumVM = MacInfoActivity.macNum;
        database = FirebaseDatabase.getInstance().getReference().child("Machine");
        ImageView machine =  view.findViewById(R.id.imageView2);
        x1 = view.findViewById(R.id.X1);
        x2 = view.findViewById(R.id.X2);
        x3 = view.findViewById(R.id.X3);
        x4 = view.findViewById(R.id.X4);
        x5 = view.findViewById(R.id.X5);
        x6 = view.findViewById(R.id.X6);
        x7 = view.findViewById(R.id.X7);
        x8 = view.findViewById(R.id.X8);
        x9 = view.findViewById(R.id.X9);
        xali = view.findViewById(R.id.X_ali);
        xocto = view.findViewById(R.id.X_octopus);
        xcoin = view.findViewById(R.id.X_coin);

        if(NumVM == 1){
            machine.setImageResource(R.mipmap.vendingmachine1);
        }
        else if (NumVM ==2){
            machine.setImageResource(R.mipmap.vendingmachine2);
        }
        else if (NumVM ==3){
            machine.setImageResource(R.mipmap.vendingmachine3);
        }
        else if (NumVM ==4){
            machine.setImageResource(R.mipmap.vendingmachine4);
        }
        if (NumVM == 1){
            database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(((dataSnapshot.child("1").child("Drinks").child("Coca Cola").getValue()).toString()).equals("0")){
                        x1.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Coca Cola Zero").getValue()).toString()).equals("0")){
                        x2.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Pocari Sweat").getValue()).toString()).equals("0")){
                        x3.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Vita Lemon Tea").getValue()).toString()).equals("0")){
                        x4.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Vitasoy").getValue()).toString()).equals("0")){
                        x5.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Vita Malted Soya").getValue()).toString()).equals("0")){
                        x6.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Minute Maid").getValue()).toString()).equals("0")){
                        x7.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Ribena").getValue()).toString()).equals("0")){
                        x8.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Drinks").child("Oolong Tea").getValue()).toString()).equals("0")){
                        x9.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Payment").child("Alipay").getValue()).toString()).equals("0")){
                        xali.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Payment").child("Octopus").getValue()).toString()).equals("0")){
                        xocto.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("1").child("Payment").child("Coin").getValue()).toString()).equals("0")){
                        xcoin.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
        else if  (NumVM == 2){
            database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(((dataSnapshot.child("2").child("Drinks").child("Monster").getValue()).toString()).equals("0")){
                        x1.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("Monster Zero").getValue()).toString()).equals("0")){
                        x2.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("RedBull").getValue()).toString()).equals("0")){
                        x3.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("Vita Mango Juice").getValue()).toString()).equals("0")){
                        x4.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("Vita Guava Juice").getValue()).toString()).equals("0")){
                        x5.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("Blackcurrant Juice").getValue()).toString()).equals("0")){
                        x6.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("LemonTea(Bottle)").getValue()).toString()).equals("0")){
                        x7.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("Lucozade").getValue()).toString()).equals("0")){
                        x8.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Drinks").child("Vita Chocolate Milk").getValue()).toString()).equals("0")){
                        x9.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Payment").child("Alipay").getValue()).toString()).equals("0")){
                        xali.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Payment").child("Octopus").getValue()).toString()).equals("0")){
                        xocto.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("2").child("Payment").child("Coin").getValue()).toString()).equals("0")){
                        xcoin.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
        else if  (NumVM == 3){
            database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(((dataSnapshot.child("3").child("Drinks").child("Monster").getValue()).toString()).equals("0")){
                        x1.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Coca Cola").getValue()).toString()).equals("0")){
                        x2.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Pocari Sweat").getValue()).toString()).equals("0")){
                        x3.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Vitasoy").getValue()).toString()).equals("0")){
                        x4.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Vita Lemon Tea").getValue()).toString()).equals("0")){
                        x5.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Blackcurrant Juice").getValue()).toString()).equals("0")){
                        x6.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Lucozade").getValue()).toString()).equals("0")){
                        x7.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Oolong Tea").getValue()).toString()).equals("0")){
                        x8.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Drinks").child("Vita Chocolate Milk").getValue()).toString()).equals("0")){
                        x9.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Payment").child("Alipay").getValue()).toString()).equals("0")){
                        xali.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Payment").child("Octopus").getValue()).toString()).equals("0")){
                        xocto.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("3").child("Payment").child("Coin").getValue()).toString()).equals("0")){
                        xcoin.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
        else if  (NumVM == 4){
            database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(((dataSnapshot.child("4").child("Drinks").child("Coca Cola").getValue()).toString()).equals("0")){
                        x1.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("Coca Cola Zero").getValue()).toString()).equals("0")){
                        x2.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("RedBull").getValue()).toString()).equals("0")){
                        x3.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("Vita Mango Juice").getValue()).toString()).equals("0")){
                        x4.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("Vita Guava Juice").getValue()).toString()).equals("0")){
                        x5.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("Vita Chocolate Milk").getValue()).toString()).equals("0")){
                        x6.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("LemonTea(Bottle)").getValue()).toString()).equals("0")){
                        x7.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("Ribena").getValue()).toString()).equals("0")){
                        x8.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Drinks").child("Lucozade").getValue()).toString()).equals("0")){
                        x9.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Payment").child("Alipay").getValue()).toString()).equals("0")){
                        xali.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Payment").child("Octopus").getValue()).toString()).equals("0")){
                        xocto.setVisibility(View.VISIBLE);
                    }
                    if(((dataSnapshot.child("4").child("Payment").child("Coin").getValue()).toString()).equals("0")){
                        xcoin.setVisibility(View.VISIBLE);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });

        }
        // Inflate the layout for this fragment
        return view;

    }




}
