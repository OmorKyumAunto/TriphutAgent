package com.example.triphutagent.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.triphutagent.R;
import com.example.triphutagent.model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

public class EditAdapter extends FirebaseRecyclerAdapter<model,EditAdapter.editviewholder> {

    public EditAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final EditAdapter.editviewholder holder,final int position, @NonNull final model model) {
        holder.placetext.setText(model.getPlace());
        holder.hoteltext.setText(model.getHotel());
        holder.duratext.setText(model.getDuration());
        holder.costtext.setText(model.getCost());
        Glide.with(holder.img.getContext()).load(model.gettimage()).into(holder.img);

        holder.bedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true,1700)
                        .create();
                View myview=dialogPlus.getHolderView();
                EditText place =myview.findViewById(R.id.upplace);
                EditText hotel =myview.findViewById(R.id.uphotel);
                EditText dura =myview.findViewById(R.id.updura);
                EditText cost =myview.findViewById(R.id.upcost);
                EditText brif= myview.findViewById(R.id.upbrif);

                Button submit=myview.findViewById(R.id.upbutton);

                place.setText(model.getPlace());
                hotel.setText(model.getHotel());
                dura.setText(model.getDuration());
                cost.setText(model.getCost());
                brif.setText("Must Enter New Brif");
                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map= new HashMap<>();
                        map.put("place",place.getText().toString());
                        map.put("hotel",hotel.getText().toString());
                        map.put("duration",dura.getText().toString());
                        map.put("cost",cost.getText().toString());
                        map.put("brif",brif.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Events")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });

        holder.bdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Delete Event");
                builder.setMessage("Want to Delete..?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Events")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });


    }

    @NonNull
    @Override
    public EditAdapter.editviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.editlayout,parent,false);
        return new EditAdapter.editviewholder(view);
    }

    public class editviewholder extends RecyclerView.ViewHolder {
        ImageView img,bedit,bdelete;
        TextView placetext,hoteltext,duratext,costtext;
        public editviewholder(@NonNull View itemView) {
            super(itemView);

            img= itemView.findViewById(R.id.toureditimg);
            placetext= itemView.findViewById(R.id.editplacetext);
            hoteltext= itemView.findViewById(R.id.edithoteltext);
            duratext= itemView.findViewById(R.id.editduratext);
            costtext= itemView.findViewById(R.id.editcosttext);

            bedit=itemView.findViewById(R.id.editic);
            bdelete=itemView.findViewById(R.id.delic);

        }
    }
}
