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
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Main3Activity extends AppCompatActivity {
    EditText ed3;
    Button b2;
    FirebaseAuth mAuth;
    FirebaseUser fbu;
    String s3;
    PhoneAuthProvider.ForceResendingToken phon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        fbu = mAuth.getCurrentUser();

        setContentView(R.layout.activity_main3);
        ed3 = findViewById(R.id.editText);
        b2 = findViewById(R.id.button2);
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phnnmbr");
        verif(phone);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s2 = ed3.getText().toString();
                if (s2.isEmpty()) {
                    Toast.makeText(Main3Activity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    PhoneAuthCredential pap = PhoneAuthProvider.getCredential(s3, s2);
                    signInWithPhoneAuthCredential(pap);
                }
            }
        });
    }

    public void verif(final String phoneNumber) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        s3 = s;
                        phon = forceResendingToken;
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(Main3Activity.this, "Verification failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = task.getResult().getUser();
                            Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                            startActivity(intent);
                            finish();
                            Toast.makeText(Main3Activity.this, "OTP verified", Toast.LENGTH_SHORT).show();
                            // ...
                        } else {
                            // Sign in failed, display a message and update the UI
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(Main3Activity.this, "Connection error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}


