package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class LoginForgotPassword extends AppCompatActivity {

    TextView SQTitle, SQ1, SQ2, SQ3;
    EditText SQ1Ans, SQ2Ans, SQ3Ans;
    Button ResetPassBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forgot_password);

        SQTitle = findViewById(R.id.loginSQTitle);
        SQ1 = findViewById(R.id.loginSQ1);
        SQ2 = findViewById(R.id.loginSQ2);
        SQ3 = findViewById(R.id.loginSQ3);

        SQ1Ans = findViewById(R.id.loginSQ1Answer);
        SQ2Ans = findViewById(R.id.loginSQ2Answer);
        SQ3Ans = findViewById(R.id.loginSQ3Answer);

        ResetPassBtn = findViewById(R.id.loginResetButton);


        FirebaseAuth fAuth;
        fAuth = FirebaseAuth.getInstance();

        Intent myIntent = getIntent();
        if (myIntent.hasExtra("myExtra")){
            Toast.makeText(LoginForgotPassword.this, "User ID is: "+myIntent.getStringExtra("myExtra")+"!", Toast.LENGTH_SHORT).show();
        }



        // User userRecord = FirebaseAuth.getInstance().getUserByEmail(email);
        // See the UserRecord reference doc for the contents of userRecord.
        // System.out.println("Successfully fetched user data: " + userRecord.getEmail());

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Database");
        DatabaseReference uidRef = rootRef.child("User").child("Registration").child("OwjDifDimvTtu4GMp2duAJjHhMF3");


        uidRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Map<String,Object> objectMap = (HashMap<String, Object>)snapshot.getValue();
                    String question1 =(String) objectMap.get("SQ1");
                    SQ1.setText(question1);

                    String question2 =(String) objectMap.get("SQ2");
                    SQ2.setText(question2);

                    String question3 =(String) objectMap.get("SQ3");
                    SQ3.setText(question3);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        ResetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans1 = SQ1Ans.getText().toString().trim();
                String ans2 = SQ2Ans.getText().toString().trim();
                String ans3 = SQ3Ans.getText().toString().trim();

                boolean b = false;

                if(TextUtils.isEmpty(ans1)){
                    SQ1Ans.setError("Field 1 Cannot Be Empty!");
                    b = true;
                    return;
                }
                if(TextUtils.isEmpty(ans2)){
                    SQ2Ans.setError("Field 2 Cannot Be Empty!");
                    b = true;
                    return;
                }
                if(TextUtils.isEmpty(ans3)){
                    SQ3Ans.setError("Field 3 Cannot Be Empty!");
                    b = true;
                    return;
                }

               /* if(!ans1.equals(NULL)) {
                    boolean c = false;
                    uidRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                Map<String, Object> objectMap = (HashMap<String, Object>) snapshot.getValue();
                                String answer1 = (String) objectMap.get("SQAns1");

                                if (!ans1.equals(answer1)) {
                                    SQ1Ans.setError("Incorrect Response");
                                    //c = true;
                                    return;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }*/

                if(!b){
                fAuth.sendPasswordResetEmail(myIntent.getStringExtra("myExtra")).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginForgotPassword.this, "A Reset Password Link has been sent to your Email", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginPage.class));
                            finish();
                        }
                        else{
                            Toast.makeText(LoginForgotPassword.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginForgotPassword.class));
                            finish();
                            }
                        }
                    });}

            }
        });
    }
}