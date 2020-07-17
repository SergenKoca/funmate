package com.sergenkoca.funmate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText flname,username,email,password,passwordAgain;
    Button register;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void onStart() {
        super.onStart();

        init();
        setListener();
    }

    private void init(){
        flname = findViewById(R.id.register_ac_flnametxt);
        username = findViewById(R.id.register_ac_usernametxt);
        email = findViewById(R.id.register_ac_emailtxt);
        password = findViewById(R.id.register_ac_passwordtxt);
        passwordAgain = findViewById(R.id.register_ac_password_againtxt);
        register = findViewById(R.id.register_ac_registerbtn);
        login = findViewById(R.id.register_ac_logintxt);
    }

    private void setListener(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInputs()){
                    registerUser();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private boolean validateInputs(){
        if(flname.getText() != null && username.getText() != null && email.getText() != null
        && password.getText() != null && passwordAgain.getText() != null){
            if(!flname.getText().toString().isEmpty() && !username.getText().toString().isEmpty()
            && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()
            && !passwordAgain.getText().toString().isEmpty()){
                return  true;
            }
            else{
                if(flname.getText().toString().isEmpty()){
                    flname.setError(getString(R.string.need_flname));
                }
                if(username.getText().toString().isEmpty()){
                    username.setError(getString(R.string.need_username));
                }
                if(email.getText().toString().isEmpty()){
                    email.setError(getString(R.string.need_email));
                }
                if(password.getText().toString().isEmpty()){
                    password.setError(getString(R.string.need_password));
                }
                if(passwordAgain.getText().toString().isEmpty()){
                    passwordAgain.setError(getString(R.string.need_password_again));
                }
                return false;
            }
        }
        else{
            if(flname.getText() == null){
                flname.setError(getString(R.string.need_flname));
            }
            if(username.getText() == null){
                username.setError(getString(R.string.need_username));
            }
            if(email.getText() == null){
                email.setError(getString(R.string.need_email));
            }
            if(password.getText() == null){
                password.setError(getString(R.string.need_password));
            }
            if(passwordAgain.getText() == null){
                passwordAgain.setError(getString(R.string.need_password_again));
            }
            return false;
        }
    }

    private void registerUser(){
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(false);
        ProgressBar progressBar = new ProgressBar(RegisterActivity.this);
        alertDialog.setView(progressBar);
        alertDialog.show();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            // database'e kaydet ve mainActivity'e ilerle
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                alertDialog.cancel();
                Toast.makeText(RegisterActivity.this, "Kayıt Olurken Bir Hata Meydana Geldi", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
