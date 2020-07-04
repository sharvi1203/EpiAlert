package com.example.epialert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class LoginPatient extends AppCompatActivity {
    EditText eTxtEmail,eTxtPass;
    Button btnRegister,btnLogIn;
    ProgressDialog progressDialog;
    Patient patient;
    Random random;
    void init(){
        patient=new Patient();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait... ");
        eTxtEmail=(EditText)findViewById(R.id.editTextEmailLogP);
        eTxtPass=(EditText)findViewById(R.id.editTextPasswordLogP);
        btnRegister=(Button)findViewById(R.id.buttonRegisterP);
        btnLogIn=(Button)findViewById(R.id.buttonLogInP);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginPatient.this,RegisterPatientActivity.class);
                startActivity(intent);
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                patient.EmailAdd=eTxtEmail.getText().toString();
                patient.password=eTxtPass.getText().toString();
                if(patient.EmailAdd.isEmpty() || patient.password.isEmpty()){
                    Toast.makeText(LoginPatient.this,"Please fill all credentials",Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }else {
//                    String generatedPassword = String.format("%04d", random.nextInt(10000));
//                    Toast.makeText(LoginPatient.this,generatedPassword,Toast.LENGTH_LONG).show();
                      loginUserFromFirebase();
                }
                    //Log.i("String",patient.EmailAdd + patient.password);

            }
        });
    }

    private void loginUserFromFirebase() {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(patient.EmailAdd,patient.password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful() && task.isComplete()){
                            Toast.makeText(LoginPatient.this,"Log in Successfully",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LoginPatient.this,HomeActivity.class);
                            startActivity(intent);
                            finish();
                            progressDialog.dismiss();
                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(LoginPatient.this,"Verify your email Address and Password",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.activity_login_patient);
        init();
    }

}
