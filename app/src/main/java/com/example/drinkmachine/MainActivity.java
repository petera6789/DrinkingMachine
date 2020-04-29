package com.example.drinkmachine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void toAboutUs(View view){
        startActivity(new Intent(this,AboutUs.class));//start Activity via intent
    }

    DatabaseReference Machine;
    int maxid;
    Spinner sort;
    String SortText;
    ArrayList<String> List =  new ArrayList<>();
    String[] names = {"Vita Chocolate Milk", "Lucozade", "Coca Cola", "Coca Cola Zero", "Blackcurrant Juice", "Vita Guava Juice", "LemonTea(Bottle)", "Vita Lemon Tea", "Vita Mango Juice", "Minute Maid", "Monster", "Monster Zero", "Pocari Sweat", "RedBull", "Ribena", "Vitasoy", "Vita Malted Soya", "Oolong Tea"};
    int[] images ={R.drawable.chocomilk, R.drawable.lucozade, R.drawable.coke, R.drawable.coke_zero, R.drawable.grape, R.drawable.guava, R.drawable.lemon_bottle, R.drawable.lemontea, R.drawable.mango, R.drawable.minutemaid, R.drawable.monster, R.drawable.monster_zero, R.drawable.pocari, R.drawable.redbull, R.drawable.ribena, R.drawable.vitasoy, R.drawable.vitasoy2, R.drawable.wulong_tea};
    CustomAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sort = findViewById(R.id.sorting);
        adapter = new CustomAdapter(this, names, images);
        sort.setAdapter(adapter);
        sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SortText = names[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Machine = FirebaseDatabase.getInstance().getReference().child("Machine");
        Button search;
        final Button LogButton = (Button) findViewById(R.id.LogButton);
        LogButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), LoginActivity.class);
                finish();
                startActivity(getIntent());
                overridePendingTransition(0,0);
                startActivity(startIntent);

            }
        });

        Button Logout = (Button)findViewById(R.id.Logout);
        Logout.setVisibility(View.GONE);
        TextView welcome = (TextView)findViewById(R.id.welcome);
        final SharedPreferences prefs = getSharedPreferences("name", MODE_PRIVATE);
        String username = prefs.getString("username", "UNKNOWN");
        welcome.setText("");
        final SharedPreferences checklog = getSharedPreferences("check", MODE_PRIVATE);
        final SharedPreferences commentallow = getSharedPreferences("comment", MODE_PRIVATE);
        int check123 = 2;

        if (checklog.getInt("check", 1)==0){
            welcome.setText("User : " + username);
            LogButton.setVisibility(View.GONE);
            Logout.setVisibility(View.VISIBLE);
            commentallow.edit().putInt("comment",check123).apply();
        }
        else {
            checklog.edit().clear().apply();
        }

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.edit().clear().apply();
                checklog.edit().clear().apply();
                finish();
                startActivity(getIntent());
                overridePendingTransition(0,0);
                int check123 = 0;
                commentallow.edit().putInt("comment",check123).apply();
                LogButton.setVisibility(View.VISIBLE);
            }
        });

        Button Reg_Button = (Button) findViewById(R.id.Reg_Button);
        Reg_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), RegActivity.class);
                startActivity(startIntent);
            }
        });

        search = (Button) findViewById(R.id.go);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Machine.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List.clear();
                        SortText = sort.getSelectedItem().toString();
                        if(dataSnapshot.exists())
                            maxid=((int)dataSnapshot.getChildrenCount());
                        for(int i = 1; i <= maxid; i++) {
                            if(dataSnapshot.child(String.valueOf(i)).child("Drinks").child(SortText).exists()){
                                List.add(String.format("Floor " + i));
                            }
                        }
                        Intent intent = new Intent(MainActivity.this, MachineListActivity.class);
                        intent.putExtra("SortArray", List);
                        startActivity(intent);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

            }
        });
        Button all = (Button) findViewById(R.id.All);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Machine.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        List.clear();
                        SortText = sort.getSelectedItem().toString();
                        if(dataSnapshot.exists())
                            maxid=((int)dataSnapshot.getChildrenCount());
                        for(int i = 1; i <= maxid; i++) {
                            List.add(String.format("Floor " + i));
                        }
                        Intent intent = new Intent(MainActivity.this, MachineListActivity.class);
                        intent.putExtra("SortArray", List);
                        startActivity(intent);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });


    }
}


