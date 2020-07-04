package com.sergenkoca.funmate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText email,password;
    Button login;
    TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setListener();
    }

    private void init(){
        email = findViewById(R.id.login_ac_emailtxt);
        password = findViewById(R.id.login_ac_passwordtxt);
        login = findViewById(R.id.login_ac_loginbtn);
        register = findViewById(R.id.login_ac_registertxt);
    }

    private void setListener(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateInputs()){

                }
            }
        });
    }

    private boolean validateInputs(){
        if(email.getText() != null && password.getText()!= null && !email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            return  true;
        }
        else{
            if(email.getText() != null || !email.getText().toString().isEmpty()){
                email.setError("email adresi gereklidir");
            }
            if(password.getText() != null || !password.getText().toString().isEmpty()){
                password.setError("şifre gereklidir");
            }
            return false;
        }
    }
}
