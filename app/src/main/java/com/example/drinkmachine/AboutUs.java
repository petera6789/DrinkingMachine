package com.example.drinkmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        TextView newtext = (TextView) findViewById(R.id.hugh);
        newtext.setMovementMethod(LinkMovementMethod.getInstance());
        TextView newtext2 = (TextView) findViewById(R.id.cmt);
        newtext2.setMovementMethod(LinkMovementMethod.getInstance());
        TextView newtext3 = (TextView) findViewById(R.id.jerome);
        newtext3.setMovementMethod(LinkMovementMethod.getInstance());
        TextView newtext4 = (TextView) findViewById(R.id.kayuk);
        newtext4.setMovementMethod(LinkMovementMethod.getInstance());
        TextView newtext5 = (TextView) findViewById(R.id.sillage);
        newtext5.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
