package com.example.drinkmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MachineListActivity extends AppCompatActivity {
    DatabaseReference base;
    String itemValue;
    ListView listView;
    String[] seperate;
    int maxid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_machine);

        base = FirebaseDatabase.getInstance().getReference().child("Machine");
        Bundle bundle = getIntent().getExtras();
        ArrayList<String> VendingList = bundle.getStringArrayList("SortArray");
        listView = findViewById(R.id.listview);
        ArrayAdapter<String> items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, VendingList);
        listView.setAdapter(items);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                itemValue = (String) listView.getItemAtPosition(position);
                seperate = itemValue.split(" ");

                base.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists())
                            maxid=((int)dataSnapshot.getChildrenCount());
                        for(int i = 1; i <= maxid; i++) {
                            if(dataSnapshot.child(String.valueOf(i)).exists()){
                                if (String.valueOf(i).equals(seperate [1])){
                                    Intent intent = new Intent(MachineListActivity.this, MacInfoActivity.class);
                                    intent.putExtra("MachineNum", seperate [1]);
                                    startActivity(intent);

                                }
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

            }
        });

    }

}
