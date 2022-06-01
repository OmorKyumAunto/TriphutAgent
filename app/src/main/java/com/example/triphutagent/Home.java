package com.example.triphutagent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {
    CardView profile,noti,add,edit,view,del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        profile= findViewById(R.id.cprofile);
        noti=findViewById(R.id.cnoti);
        add= findViewById(R.id.cadd);
        edit=findViewById(R.id.cedit);
        view=findViewById(R.id.cview);
        del=findViewById(R.id.cdel);




        //OnClick
        profile.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

            }
        });
        noti.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

            }
        });
        add.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                startActivity(new Intent(getApplicationContext(),Cardata.class));

            }
        });
        edit.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

            }
        });
        view.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                startActivity(new Intent(getApplicationContext(),View.class));

            }
        });
        del.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}