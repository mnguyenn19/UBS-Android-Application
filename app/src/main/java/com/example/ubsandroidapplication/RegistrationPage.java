package com.example.ubsandroidapplication;

import android.content.Intent;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegistrationPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView RegisUSBTitle, RegisFullNameTitle, RegisEmailTitle, RegisUniversityTitle, RegisCreateUserIDTitle, RegisCreatePasswordTitle;
    EditText RegisFullName, RegisEmail, RegisCreateUserID, RegisCreatePassword, RegisConfirmPassword;
    Button RegisterButton;
    Spinner RegisUniveristySpinner;
    FirebaseAuth fAuth;
    DatabaseReference rootDatabaseref;



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



        /*if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }*/

        //Database
        rootDatabaseref = FirebaseDatabase.getInstance().getReference("Database").child("User").child("Registration");


        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = RegisFullName.getText().toString().trim();
                String email = RegisEmail.getText().toString().trim();
                String username = RegisCreateUserID.getText().toString().trim();
                String password = RegisCreatePassword.getText().toString().trim();
                String confirmPass = RegisConfirmPassword.getText().toString().trim();
                String university = RegisUniveristySpinner.getSelectedItem().toString();
                int selectedUniItem = RegisUniveristySpinner.getSelectedItemPosition();
                String spinnerPosition = (String)RegisUniveristySpinner.getItemAtPosition(selectedUniItem);

                    boolean b = false;
                
                    if (TextUtils.isEmpty(fullName)) {
                        RegisFullName.setError("Must Enter Your First & Last Name");
                        b = true;
                        return;
                    }

                    if (TextUtils.isEmpty(email)) {
                        RegisEmail.setError("Must Enter an Email");
                        b = true;
                        return;
                    }


                    if (TextUtils.isEmpty(username)) {
                        RegisCreateUserID.setError("Must Enter a Username");
                        b = true;
                        return;
                    }

                    if (username.length() < 6) {
                        RegisCreateUserID.setError("Username Must be at Least 6 Characters");
                        b = true;
                        return;
                    }


                    if (TextUtils.isEmpty(password)) {
                        RegisCreatePassword.setError("Must Enter a Password");
                        b = true;
                        return;
                    }

                    if (password.length() < 6) {
                        RegisCreatePassword.setError("Password Must be at Least 6 Characters");
                        b = true;
                        return;
                    }

                    if (TextUtils.isEmpty(confirmPass)) {
                        RegisConfirmPassword.setError("Must Re-enter the Password");
                        b = true;
                        return;
                    }

                    if (!confirmPass.equals(password)) {
                        RegisConfirmPassword.setError("Passwords Don't Match");
                        b = true;
                        return;
                    }
                     
                    if(!b)
                    fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegistrationPage.this, "Successfully Created User", Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(getApplicationContext(),RegistrationSetSecurityQuestions.class);
                                myIntent.putExtra("Email",email);

                                startActivity(myIntent);

                                finish();

                                //Updating Database fields
                                HashMap hashMap = new HashMap();
                                hashMap.put("regFirstName", fullName);
                                hashMap.put("username", username);
                                // hashMap.put("password", password);
                                hashMap.put("email", email);
                                hashMap.put("university",university);


                                rootDatabaseref.child(fAuth.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                                    @Override
                                    public void onSuccess(Object o) {
                                        Toast.makeText(RegistrationPage.this, "Database updated", Toast.LENGTH_SHORT).show();

                                    }
                                });


                            }
                            else {
                                Toast.makeText(RegistrationPage.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

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