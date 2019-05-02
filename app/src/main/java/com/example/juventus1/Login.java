package com.example.juventus1;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {


    EditText userEmail;
    EditText pw2;
    Button btn_login;
    TextView tv_regitese;

    private ProgressDialog progressDialog;

    // [START declare_auth]
    private FirebaseAuth mAuth;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);


        userEmail = findViewById(R.id.userEmail);
        pw2 = findViewById(R.id.pw2);
        btn_login = findViewById(R.id.btn_login);
        tv_regitese = findViewById(R.id.tv_regitese);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), PerfilFragment.class));
        }

        tv_regitese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUp();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserLogin(userEmail.getText().toString(),pw2.getText().toString());
            }
        });


    }


    private void openSignUp() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    private void UserLogin(String e, String p) {

        if (TextUtils.isEmpty(e)) {
            Toast.makeText(this, "Introduza o email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(p)) {
            Toast.makeText(this, "Introduza a password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging...");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(e, p)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        } else {
                        }

                    }

                });

    }
}
