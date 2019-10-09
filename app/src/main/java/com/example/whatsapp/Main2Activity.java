package com.example.whatsapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Main2Activity extends AppCompatActivity {
    EditText ed1, ed2;
    Button button;
    String s1, s2;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ed1 = findViewById(R.id.phnnmbr);
        ed2 = findViewById(R.id.editText2);
        button = findViewById(R.id.nxtbtn);
        spinner = findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                s1 = ed1.getText().toString();
                s2 = ed2.getText().toString();
                if (s1.isEmpty()) {
                    Toast.makeText(Main2Activity.this, "Please enter your number", Toast.LENGTH_SHORT).show();
                } else if (s2.isEmpty()) {
                    Toast.makeText(Main2Activity.this, "Please enter +91", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("phnnmbr", s2 + s1);
                    startActivity(intent);
                }

                Dialog dialog = new Dialog(Main2Activity.this);
                dialog.setContentView(R.layout.dialog);
                dialog.show();
            }
        });
    }
}