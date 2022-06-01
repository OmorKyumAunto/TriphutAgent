package com.example.triphutagent.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.triphutagent.Model.BookModel;
import com.example.triphutagent.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class NotificantionAdapter extends FirebaseRecyclerAdapter<BookModel,NotificantionAdapter.myviewholder> {

    public NotificantionAdapter(@NonNull FirebaseRecyclerOptions<BookModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NotificantionAdapter.myviewholder holder, int position, @NonNull BookModel model) {
        holder.bnametext.setText(model.getName());
        holder.bnumtext.setText(model.getPhone());
        holder.bstatustext.setText(convertCodetoStatus(model.getStatus()));




        holder.bookup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.bnametext.getContext())
                        .setContentHolder(new ViewHolder(R.layout.orderstatus))
                        .setExpanded(true,1200)
                        .create();

                View myview=dialogPlus.getHolderView();
                EditText summary=myview.findViewById(R.id.bookstatus);
                summary.setText(model.getStatus());

                dialogPlus.show();
                Button proced=myview.findViewById(R.id.btnorder);
                Button delete=myview.findViewById(R.id.btndel);
                proced.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map= new HashMap<>();
                        map.put("status",summary.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("Request")
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
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder= new AlertDialog.Builder(holder.bnametext.getContext());
                        builder.setTitle("Delete Booking");
                        builder.setMessage("Want to Delete..?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseDatabase.getInstance().getReference().child("Request")
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
        });
    }
    private String convertCodetoStatus(String status) {
        if(status.equals("0"))
            return "Booking Placed. Please Wait For Confirmation";
        else if(status.equals("1"))
            return "To be Confirmed";
        else
            return "Confirmed";
    }
    @NonNull
    @Override
    public NotificantionAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklayout,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView bnametext,bnumtext,bstatustext;
        Button bookup;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            bnametext=itemView.findViewById(R.id.order_name);
            bnumtext=itemView.findViewById(R.id.order_phone);
            bstatustext=itemView.findViewById(R.id.order_status);
            bookup=itemView.findViewById(R.id.bookupdate);
        }
    }
}
