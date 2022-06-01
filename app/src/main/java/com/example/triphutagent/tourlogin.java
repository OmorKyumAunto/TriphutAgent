package com.example.triphutagent;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.triphutagent.Model.Agent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tourlogin extends AppCompatActivity {

    EditText meditTextuser,meditTextpass;
    TextView mlogin;
    Button magent;

    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourlogin);
        changeStatusBarColor();

        meditTextuser = findViewById(R.id.username);
        meditTextpass = findViewById(R.id.password);
        fAuth = FirebaseAuth.getInstance();
        mlogin = findViewById(R.id.loginbtn);
        DatabaseReference table_user= FirebaseDatabase.getInstance().getReference("Agent");


        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = meditTextuser.getText().toString().trim();
                String password = meditTextpass.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    meditTextuser.setError("Email Is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    meditTextpass.setError("Password Is Required");
                    return;
                }
                if(password.length()<6){
                    meditTextpass.setError("Password must be large then 6 Character");
                    return;
                }

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child(meditTextuser.getText().toString()).exists()) {

                            Agent agent = snapshot.child(meditTextuser.getText().toString()).getValue(Agent.class);
                            if (agent.getPassword().equals(meditTextpass.getText().toString())) {
                                Toast.makeText(tourlogin.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), TourHome.class));
                                finish();
                            } else {
                                Toast.makeText(tourlogin.this, "Password Wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(tourlogin.this, "User Not Exist!", Toast.LENGTH_SHORT).show();
                        }
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        tourlogin.super.onBackPressed();
                        System.exit(0);
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void changeStatusBarColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }

    }
}