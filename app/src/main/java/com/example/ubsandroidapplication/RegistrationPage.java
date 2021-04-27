package com.example.ubsandroidapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView RegisUSBTitle, RegisFullNameTitle, RegisEmailTitle, RegisUniversityTitle, RegisCreateUserIDTitle, RegisCreatePasswordTitle;
    EditText RegisFullName, RegisEmail, RegisCreateUserID, RegisCreatePassword, RegisConfirmPassword;
    Button RegisterButton;
    Spinner RegisUniveristySpinner;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        // All TextViews
        RegisUSBTitle =  findViewById(R.id.RegisUBSTitle);
        RegisFullNameTitle = findViewById(R.id.RegisFullNameTitle);
        RegisEmailTitle = findViewById(R.id.RegisEmailTitle);
        RegisUniversityTitle = findViewById(R.id.RegisUniversityTitle);
        RegisCreateUserIDTitle = findViewById(R.id.RegisCreateUserIDTitle);
        RegisCreatePasswordTitle = findViewById(R.id.RegisCreatePasswordTitle);

        // All EditTexts
        RegisFullName = findViewById(R.id.RegisFullName);
        RegisEmail = findViewById(R.id.RegisEmail);
        RegisCreateUserID = findViewById(R.id.RegisCreateUserID);
        RegisCreatePassword = findViewById(R.id.RegisCreatePassword);
        RegisConfirmPassword = findViewById(R.id.RegisConfirmPassword);

        // FirebaseAuth
        fAuth = FirebaseAuth.getInstance();

        // Spinner
        RegisUniveristySpinner = findViewById(R.id.RegisUniversitySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Universities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RegisUniveristySpinner.setAdapter(adapter);
        RegisUniveristySpinner.setOnItemSelectedListener(this);

        // Have the password
        RegisCreatePassword.setTransformationMethod(new PasswordTransformationMethod());


        // Registration Authentication & Error Checking
        RegisterButton = findViewById(R.id.RegisterButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = RegisFullName.getText().toString().trim();
                String email = RegisEmail.getText().toString().trim();
                String username = RegisCreateUserID.getText().toString().trim();
                String password = RegisCreatePassword.getText().toString().trim();
                String confirmPass = RegisConfirmPassword.getText().toString().trim();



                if(TextUtils.isEmpty(fullName)){
                    RegisFullName.setError("Must Enter Your First & Last Name");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    RegisEmail.setError("Must Enter an Email");
                    return;
                }

                if(TextUtils.isEmpty(username)){
                    RegisCreateUserID.setError("Must Enter a Username");
                    return;
                }

                if(username.length() < 8){
                    RegisCreateUserID.setError("Username Must be at Least 8 Characters");
                }


                if(TextUtils.isEmpty(password)){
                    RegisCreatePassword.setError("Must Enter a Password");
                    return;
                }

                if(password.length() < 8){
                    RegisCreatePassword.setError("Password Must be at Least 8 Characters");
                }

                if(TextUtils.isEmpty(confirmPass)){
                    RegisConfirmPassword.setError("Must Re-enter the Password");
                    return;
                }

                if(!confirmPass.equals(password))
                {
                    RegisConfirmPassword.setError("Passwords Don't Match");
                    return;
                }


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}