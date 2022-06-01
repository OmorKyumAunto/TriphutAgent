package com.example.triphutagent.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.triphutagent.Carmodel;
import com.example.triphutagent.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CarAdapter extends FirebaseRecyclerAdapter<Carmodel,CarAdapter.Carviewholder> {


    public CarAdapter(@NonNull FirebaseRecyclerOptions<Carmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Carviewholder holder, int position, @NonNull Carmodel model) {

        holder.carmodeltext.setText(model.getCarmodel());
        holder.renttext.setText(model.getRent());
        Glide.with(holder.img1.getContext()).load(model.getPimage()).into(holder.img1);
    }

    @NonNull
    @Override
    public Carviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);

        return new Carviewholder(view);
    }

    public class Carviewholder extends RecyclerView.ViewHolder{

        ImageView img1;
        TextView carmodeltext,renttext;
        Button btnbook;

        public Carviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            carmodeltext=itemView.findViewById(R.id.carmodeltext);
            renttext=itemView.findViewById(R.id.renttext);
            btnbook=itemView.findViewById(R.id.btnbook);
        }
    }
}
