package com.example.juventus1;



import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;


public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "EmailPassword";


    EditText pt_email;
    EditText pw;
    Button btn_registar;

    private ProgressDialog progressDialog;

    // [START declare_auth]
    private FirebaseAuth mAuth;

    public SignUp() {
    }
    // [END declare_auth]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        progressDialog = new ProgressDialog(this);


        pt_email = findViewById(R.id.pt_email);
        pw = findViewById(R.id.pw);
        btn_registar = findViewById(R.id.btn_registar);



        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]


        btn_registar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == btn_registar){
            registerUser();
        }
    }

    private void registerUser() {
        String email = pt_email.getText().toString().trim();
        String password = pw.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Introduza o email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Introduza a password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Registered Sucessfull",Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(SignUp.this, "Could not register please try again!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
