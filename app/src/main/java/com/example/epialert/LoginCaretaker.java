package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginCaretaker extends AppCompatActivity {
    EditText eTxtEmailAddress,eTxtPassword;
    Button btnLogIn,btnRegister;
    void init(){
        eTxtEmailAddress=findViewById(R.id.editTextEmailLogC);
        eTxtPassword=findViewById(R.id.editTextPasswordLogP);
        btnLogIn=findViewById(R.id.buttonLogInC);
        btnRegister=findViewById(R.id.buttonRegisterC);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginCaretaker.this,RegisterCaretaker.class);
                startActivity(intent);
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginCaretaker.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_caretaker);
        init();
    }
}
