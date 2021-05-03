package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegistrationSetSecurityQuestions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView RegisSQTitle;
    EditText SQAnswer1, SQAnswer2, SQAnswer3;
    Button SetSQBtn;
    FirebaseAuth fAuth;
    DatabaseReference rootDatabaseref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_set_security_questions);


        Spinner SQ1 = findViewById(R.id.RegisSQ1_spinner);
        Spinner SQ2 = findViewById(R.id.RegisSQ2_spinner);
        Spinner SQ3 = findViewById(R.id.RegisSQ3_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.SecurityQuestions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SQ1.setAdapter(adapter);
        SQ1.setOnItemSelectedListener(this);

        SQ2.setAdapter(adapter);
        SQ2.setOnItemSelectedListener(this);

        SQ3.setAdapter(adapter);
        SQ3.setOnItemSelectedListener(this);

        fAuth = FirebaseAuth.getInstance();
        //rootDatabaseref = FirebaseDatabase.getInstance().getReference("Database").child("User").child("Registration");


        // All TextViews
        RegisSQTitle = findViewById(R.id.RegisSetSQTitle);

        SQAnswer1 = findViewById(R.id.RegisSQ1Answer);
        SQAnswer2 = findViewById(R.id.RegisSQ2Answer);
        SQAnswer3 = findViewById(R.id.RegisSQ3Answer);

        SetSQBtn = findViewById(R.id.RegisSetButton);
        SetSQBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                String SQ1Question = SQ1.getSelectedItem().toString();
                String SQ2Question = SQ2.getSelectedItem().toString();
                String SQ3Question = SQ3.getSelectedItem().toString();
                String SQ1Ans = SQAnswer1.getText().toString().trim();
                String SQ2Ans = SQAnswer2.getText().toString().trim();
                String SQ3Ans = SQAnswer3.getText().toString().trim();

                boolean b;
                b= false;
                if(TextUtils.isEmpty(SQ1Ans)){
                    SQAnswer1.setError("Cannot Leave Field Empty");
                    b=true;
                    return;
                }

                if(TextUtils.isEmpty(SQ2Ans)){
                    SQAnswer2.setError("Cannot Leave Field Empty");
                    b=true;
                    return;
                }


                if(TextUtils.isEmpty(SQ3Ans)){
                    SQAnswer3.setError("Cannot Leave Field Empty");
                    b=true;
                    return;
                }



                if(!b) {
                    // instead of replace i think i found the update function and ill be doing that shortly

                    //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    //finish();

                    //String cool = String.valueOf(fAuth.getUid());
                    //Toast.makeText(RegistrationSetSecurityQuestions.this, "User is: "+cool, Toast.LENGTH_SHORT).show();

                    fAuth = FirebaseAuth.getInstance();
                    rootDatabaseref = FirebaseDatabase.getInstance().getReference("Database").child("User").child("Registration");
                    Intent myIntent = getIntent();
                    fAuth.fetchSignInMethodsForEmail(myIntent.getStringExtra("Email")).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                            if(task.isSuccessful()){
                                if (!task.getResult().getSignInMethods().isEmpty()) {
                                    Toast.makeText(RegistrationSetSecurityQuestions.this, "Welcome!", Toast.LENGTH_SHORT).show();

                                    //Intent myIntent = new Intent(getApplicationContext(),RegistrationSetSecurityQuestions.class);
                                    //myIntent.putExtra("myExtra",user);

                                   // startActivity(myIntent);
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                    HashMap hashMap = new HashMap();


                                    hashMap.put("SQ1", SQ1Question);
                                    hashMap.put("SQ2", SQ2Question);
                                    hashMap.put("SQ3", SQ3Question);
                                    hashMap.put("SQAns1", SQ1Ans);
                                    hashMap.put("SQAns2", SQ2Ans);
                                    hashMap.put("SQAns3", SQ3Ans);

                                    rootDatabaseref.child(fAuth.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                                        @Override
                                        public void onSuccess(Object o) {
                                            Toast.makeText(RegistrationSetSecurityQuestions.this, "Database updated", Toast.LENGTH_SHORT).show();

                                        }
                                    });


                                }
                                else {
                                    Toast.makeText(RegistrationSetSecurityQuestions.this, "User Doesn't Exists",Toast.LENGTH_SHORT).show();
                                    //startActivity(new Intent(getApplicationContext(), LoginPage.class));
                                }}
                            else{
                                Toast.makeText(RegistrationSetSecurityQuestions.this, "Error: " +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                //startActivity(new Intent(getApplicationContext(), LoginPage.class));
                            }
                        }
                    });
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