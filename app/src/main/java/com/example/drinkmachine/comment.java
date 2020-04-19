package com.example.drinkmachine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Comment;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class comment extends Fragment {
    Spinner have;
    Spinner valid;
    ArrayAdapter<String> ARadapter;
    String[] choose = {"Yes", "No"};
    String Choose1, Choose2;
    DatabaseReference Database;
    public comment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_comment, container, false);
        TextView Loginname = view.findViewById(R.id.Comname);
        Button Submit1 =view.findViewById(R.id.Submit1);
        Button Submit2 =view.findViewById(R.id.Submit2);
        have = view.findViewById(R.id.DrinkSpinnerValid);
        valid = view.findViewById(R.id.PaySpinnerValid);
        ARadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, choose);
        ARadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        have.setAdapter(ARadapter);
        valid.setAdapter((ARadapter));
        have.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Choose1 = choose[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
         valid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Choose2 = choose[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        int NumVM = MacInfoActivity.macNum;
        Database = FirebaseDatabase.getInstance().getReference().child("Machine").child(String.valueOf(NumVM));




        String[] drinknames = new String[9];
        int [] drinkImages = new int[9];

        SharedPreferences checklogin = this.getActivity().getSharedPreferences("comment", MODE_PRIVATE);
        SharedPreferences out = this.getActivity().getSharedPreferences("out", MODE_PRIVATE);

        if (checklogin.getInt("comment", 1)==2) {

            SharedPreferences prefs = this.getActivity().getSharedPreferences("name", MODE_PRIVATE);
            String username = prefs.getString("username", "UNKNOWN");
            Loginname.setText(username);
            Submit1.setEnabled(true);
            Submit2.setEnabled(true);

        }
        else {
            Loginname.setText("Please login to update the machine information");
            checklogin.edit().clear().apply();
        }

        Spinner drinksort;
        final String[] SortText = new String[1];
        if(NumVM == 1){
            drinknames = new String[] {"Coca Cola", "Coca Cola Zero", "Minute Maid", "Oolong Tea", "Pocari Sweat", "Ribena", "Vita Lemon Tea", "Vita Malted Soya", "Vitasoy"};
            drinkImages = new int[] {R.drawable.coke, R.drawable.coke_zero, R.drawable.minutemaid, R.drawable.wulong_tea, R.drawable.pocari, R.drawable.ribena, R.drawable.lemontea, R.drawable.vitasoy2, R.drawable.vitasoy};
        }
        else if(NumVM == 2){
            drinknames = new String[] {"Monster", "Monster Zero", "Blackcurrant Juice", "LemonTea(Bottle)", "Lucozade",  "RedBull", "Vita Chocolate Milk", "Vita Guava Juice", "Vita Mango Juice"};
            drinkImages = new int[] {R.drawable.monster, R.drawable.monster_zero, R.drawable.grape, R.drawable.lemon_bottle, R.drawable.lucozade, R.drawable.redbull, R.drawable.chocomilk, R.drawable.guava, R.drawable.mango};
        }
        else if(NumVM == 3){
            drinknames = new String[]{"Blackcurrant Juice", "Coca Cola", "Lucozade", "Monster", "Oolong Tea", "Pocari Sweat", "Vita Chocolate Milk", "Vita Lemon Tea", "Vitasoy"};
            drinkImages = new int[] {R.drawable.grape, R.drawable.coke, R.drawable.lucozade, R.drawable.monster, R.drawable.wulong_tea, R.drawable.pocari, R.drawable.chocomilk, R.drawable.lemontea, R.drawable.vitasoy};
        }
        else {
            drinknames = new String[]{"Coca Cola", "Coca Cola Zero", "LemonTea(Bottle)", "Lucozade", "RedBull", "Ribena", "Vita Chocolate Milk", "Vita Guava Juice", "Vita Mango Juice"};
            drinkImages = new int[] {R.drawable.coke, R.drawable.coke_zero, R.drawable.lemon_bottle, R.drawable.lucozade, R.drawable.redbull, R.drawable.ribena, R.drawable.chocomilk, R.drawable.guava, R.drawable.mango};
        }
        CustomAdapter adapter;
        final String[] text = drinknames;
        drinksort = view.findViewById(R.id.DrinkSpinner);
        adapter = new CustomAdapter(this.getActivity(), drinknames, drinkImages);
        drinksort.setAdapter(adapter);
        drinksort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SortText[0] = text[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner Paysort;
        final String[] paySortText = new String[1];
        final String[] paynames = {"Octopus", "Coin", "Alipay"};
        int[] payimages ={R.drawable.octopus, R.drawable.coin, R.drawable.aliplay};

        Paysort = view.findViewById(R.id.PaySpinner);
        CustomAdapter payadapter = new CustomAdapter(this.getActivity(), paynames, payimages);
        Paysort.setAdapter(payadapter);
        Paysort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paySortText[0] = paynames[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Submit1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Choose1.equals("Yes")){
                    Database.child("Drinks").child(SortText[0]).setValue(1);
                }
                else if(Choose1.equals("No")){
                    Database.child("Drinks").child(SortText[0]).setValue(0);
                }
                Toast.makeText(getContext(),"Thanks for your updating",Toast.LENGTH_LONG).show();

            }
        });
        Submit2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Choose2.equals("Yes")){
                    Database.child("Payment").child(paySortText[0]).setValue(1);
                }
                else if(Choose2.equals("No")){
                    Database.child("Payment").child(paySortText[0]).setValue(0);
                }
                Toast.makeText(getContext(),"Thanks for your updating",Toast.LENGTH_LONG).show();
            }
        });



        return view;
    }


}
