package com.example.triphutagent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.triphutagent.Adapter.CarAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class View extends AppCompatActivity {
    RecyclerView Carrecview;
    CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        Carrecview=findViewById(R.id.Carrecview);

        Carrecview.setLayoutManager(new GridLayoutManager(View.this,2));

        FirebaseRecyclerOptions<Carmodel> options =
                new FirebaseRecyclerOptions.Builder<Carmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Drivers"), Carmodel.class)
                        .build();

        carAdapter= new CarAdapter(options);
        Carrecview.setAdapter(carAdapter);

    }

    public void onStart(){
        super.onStart();
        carAdapter.startListening();
    }
    public void onStop(){
        super.onStop();
        carAdapter.stopListening();
    }
}