package com.sergenkoca.funmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

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

    }

}
