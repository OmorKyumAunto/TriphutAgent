package com.example.triphutagent.Notificantions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.triphutagent.Adapter.NotificantionAdapter;
import com.example.triphutagent.Model.BookModel;
import com.example.triphutagent.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class TourNotifications extends AppCompatActivity {
    RecyclerView recview;
    NotificantionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_notifications);

        recview=findViewById(R.id.bookrec);
        recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<BookModel> options =
                new FirebaseRecyclerOptions.Builder<BookModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Request"), BookModel.class)
                        .build();

        adapter=new NotificantionAdapter(options);
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