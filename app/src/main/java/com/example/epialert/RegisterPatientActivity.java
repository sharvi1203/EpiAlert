package com.example.epialert;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegisterPatientActivity extends AppCompatActivity {

    EditText eTxtName,eTxtPhone,eTxtDOB,eTxtPass,eTxtAddress,eTxtCaretakersN,eTxtCaretakersP,eTxtEmailAdd;
    Button btnSubmitInvite;
    Patient patient;
    Random random;
    ProgressDialog progressDialog;
    void init(){
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        eTxtName=(EditText) findViewById(R.id.editTextName);
        eTxtPhone=(EditText)findViewById(R.id.editTextPhone);
        eTxtDOB=(EditText)findViewById(R.id.editTextDOB);
        eTxtEmailAdd=(EditText)findViewById(R.id.editTextEmail);
        eTxtPass=(EditText)findViewById(R.id.editTextPassword);
        eTxtAddress=(EditText)findViewById(R.id.editTextAddress);
        eTxtCaretakersN=(EditText)findViewById(R.id.editTextCaretakerN);
        eTxtCaretakersP=(EditText)findViewById(R.id.editTextCaretakerP);
        btnSubmitInvite=(Button)findViewById(R.id.SubmitAndInvite);
        btnSubmitInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patient=new Patient();
                patient.name=eTxtName.getText().toString();
                patient.Phone=eTxtPhone.getText().toString();
                patient.password=eTxtPass.getText().toString();
                patient.DOB=eTxtDOB.getText().toString();
                patient.Address=eTxtAddress.getText().toString();
                patient.EmailAdd=eTxtEmailAdd.getText().toString();
                patient.CaretakersName=eTxtCaretakersN.getText().toString();
                patient.CaretakersPhone=eTxtCaretakersP.getText().toString();
                if(patient.name.isEmpty() || patient.Phone.isEmpty() || patient.DOB.isEmpty() || patient.password.isEmpty() || patient.Address.isEmpty() || patient.CaretakersName.isEmpty() || patient.CaretakersPhone.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please fill all the credentials!",Toast.LENGTH_LONG).show();
                }else {
                    progressDialog.show();
                    registerUserInFirebase();
                    String generatedPassword = String.format("%04d", random.nextInt(10000));
                   // Log.d("MyApp", "Generated Password : " + generatedPassword);
                    Toast.makeText(getApplicationContext(), patient.EmailAdd + " saved to database" , Toast.LENGTH_LONG).show();
                    //saveUserInFirebase();
                }
            }
        });
    }


    private void saveUserInFirebase() {
    }

    private void registerUserInFirebase() {
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(patient.EmailAdd,patient.password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isComplete() && task.isSuccessful()){
                    Intent intent=new Intent(RegisterPatientActivity.this,LoginPatient.class);
                    startActivity(intent);            
                    finish();
                    progressDialog.dismiss();
                }
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);
        init();
    }
}
