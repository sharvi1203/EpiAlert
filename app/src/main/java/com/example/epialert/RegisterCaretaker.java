package com.example.epialert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterCaretaker extends AppCompatActivity {
    EditText eTxtName,eTxtPhone,eTxtPassword,eTxtAddress,eTxtInviteCode,eTxtEmailAddress;
    Button btnSubmit;
    Caretaker caretaker;
    void init(){
        eTxtName=(EditText)findViewById(R.id.editTextNameC);
        eTxtPhone=(EditText)findViewById(R.id.editTextPhoneC);
        eTxtAddress=(EditText)findViewById(R.id.editTextAddressC);
        eTxtEmailAddress=(EditText)findViewById(R.id.editTextEmailC);
        eTxtPassword=(EditText)findViewById(R.id.editTextPasswordC);
        eTxtInviteCode=(EditText)findViewById(R.id.editTextInviteCode);
        btnSubmit=(Button)findViewById(R.id.buttonSubmit);
        caretaker=new Caretaker();
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caretaker.Name=eTxtName.getText().toString();
                caretaker.Phone=eTxtPhone.getText().toString();
                caretaker.Address=eTxtAddress.getText().toString();
                caretaker.Password=eTxtPassword.getText().toString();
                caretaker.EmailAdd=eTxtEmailAddress.getText().toString();
                caretaker.InviteCode=eTxtInviteCode.getText().toString();
                Toast.makeText(getApplicationContext(),caretaker.toString() +"saved into database",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(RegisterCaretaker.this,LoginCaretaker.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_caretaker);
        init();
    }
}
