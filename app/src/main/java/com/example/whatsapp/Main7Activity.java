package com.example.whatsapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main7Activity extends AppCompatActivity {
    EditText name, password;
    Button button, button1;
    FirebaseAuth fba;
    String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        name = findViewById(R.id.editText4);
        password = findViewById(R.id.editText5);
        button = findViewById(R.id.button3);
        button1 = findViewById(R.id.button5);



        fba = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = name.getText().toString();
                s2 = password.getText().toString();

                fba.createUserWithEmailAndPassword(s1, s2).addOnCompleteListener
                        (new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Main7Activity.this, "Done", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Main7Activity.this, "Not done", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main7Activity.this,Main8Activity.class);
                startActivity(intent);
            }
        });
    }
}
