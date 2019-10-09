package com.example.whatsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Main4Activity extends AppCompatActivity {
    EditText ed;
    Button b1;
    ImageView img;
    FirebaseAuth fba;
    FirebaseUser fbu;
    DatabaseReference dbr;
    String phonenmbr;
    HashMap<String, String> data = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ed = findViewById(R.id.editText3);
        b1 = findViewById(R.id.nxtbtnn);
        img = findViewById(R.id.imageView3);
        fba = FirebaseAuth.getInstance();
        fbu = fba.getCurrentUser();
        phonenmbr = fbu.getPhoneNumber();
        dbr = FirebaseDatabase.getInstance().getReference().child("Whatsapp").child(phonenmbr);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(Main4Activity.this, "Sign out", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s4 = ed.getText().toString();
                if (s4.isEmpty()) {
                    Toast.makeText(Main4Activity.this, "Please enter your message", Toast.LENGTH_SHORT).show();
                } else {
                    data.put("message", s4);

                    datasend();
                }
            }
        });
    }

    private void datasend() {
        dbr.setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                    startActivity(intent);
                    Toast.makeText(Main4Activity.this, "Data sent to Firebase", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Main4Activity.this, "Connection error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
