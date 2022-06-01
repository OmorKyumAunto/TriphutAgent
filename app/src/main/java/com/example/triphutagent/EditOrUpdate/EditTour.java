package com.example.triphutagent.EditOrUpdate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.triphutagent.Adapter.EditAdapter;
import com.example.triphutagent.R;
import com.example.triphutagent.model;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class EditTour extends AppCompatActivity {
    RecyclerView recview;
    EditAdapter adapter;
    ImageView btnedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tour);


        recview=findViewById(R.id.recview);
        btnedit=findViewById(R.id.editic);


        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Events"), model.class)
                        .build();

        adapter= new EditAdapter(options);
        recview.setAdapter(adapter);
    }

    @Override
    public void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}