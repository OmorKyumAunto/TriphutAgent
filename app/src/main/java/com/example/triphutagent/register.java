package com.example.triphutagent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.triphutagent.Model.Agent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class register extends AppCompatActivity {

    EditText meditTextuser,meditTextemail,meditTextpass,meditTextphone,meditTextnid;
    Button mregister;
    private FirebaseAuth mAuth;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Admin.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        changeStatusBarColor();
        meditTextuser = findViewById(R.id.editTextuser);
        meditTextemail = findViewById(R.id.editTextemail);
        meditTextpass = findViewById(R.id.editTextpass);
        meditTextphone = findViewById(R.id.editTextMobile);
        meditTextnid = findViewById(R.id.editTextnid);
        mregister = findViewById(R.id.btnregister);

        mAuth = FirebaseAuth.getInstance();
        DatabaseReference table_user= FirebaseDatabase.getInstance().getReference("Agent");





        mregister.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String name = meditTextuser.getText().toString().trim();
                String email = meditTextemail.getText().toString().trim();
                String nid = meditTextnid.getText().toString().trim();
                String phone = meditTextphone.getText().toString().trim();
                String password= meditTextpass.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    meditTextemail.setError("Email Is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    meditTextpass.setError("Password Is Required");
                    return;
                }
                if(password.length()<= 6){
                    meditTextpass.setError("Password must be large then 6 Character");
                    return;
                }


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child(meditTextnid.getText().toString()).exists()){
                            Toast.makeText(register.this, "Failed To Register Already Exists", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Agent agent = new Agent(meditTextuser.getText().toString(),meditTextpass.getText().toString());
                            table_user.child(meditTextnid.getText().toString()).setValue(agent);
                            Toast.makeText(register.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(),Admin.class));
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }

    private void changeStatusBarColor() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // window.setStatusBarColor(Color.TRANSPARENT);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }
}