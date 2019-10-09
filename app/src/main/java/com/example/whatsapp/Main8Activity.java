package com.example.whatsapp;

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

public class Main8Activity extends AppCompatActivity {
    EditText name, password;
    Button button;
    String s3, s4;
    FirebaseAuth fba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fba = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main8);

        name = findViewById(R.id.editText6);
        password = findViewById(R.id.editText7);
        button = findViewById(R.id.button4);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s3 = name.getText().toString();
                s4 = password.getText().toString();

                fba.signInWithEmailAndPassword(s3, s4).addOnCompleteListener
                        (new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Main8Activity.this, "DoneL", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Main8Activity.this, "Not doneL", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
            }
        });
    }
}
