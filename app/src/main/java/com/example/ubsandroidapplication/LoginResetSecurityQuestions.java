package com.example.ubsandroidapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginResetSecurityQuestions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView LoginSQTitle;
    EditText SQAnswer1, SQAnswer2, SQAnswer3;
    Button ResetSQBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reset_security_questions);


        Spinner SQ1 = findViewById(R.id.loginSQ1_spinner);
        Spinner SQ2 = findViewById(R.id.loginSQ2_spinner);
        Spinner SQ3 = findViewById(R.id.loginSQ3_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.SecurityQuestions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SQ1.setAdapter(adapter);
        SQ1.setOnItemSelectedListener(this);

        SQ2.setAdapter(adapter);
        SQ2.setOnItemSelectedListener(this);

        SQ3.setAdapter(adapter);
        SQ3.setOnItemSelectedListener(this);


        // All TextViews
        LoginSQTitle = findViewById(R.id.loginResetSQTitle);

        SQAnswer1 = findViewById(R.id.loginSQ1ResetAnswer);
        SQAnswer2 = findViewById(R.id.loginSQ2ResetAnswer);
        SQAnswer3 = findViewById(R.id.loginSQ3ResetAnswer);

        ResetSQBtn = findViewById(R.id.loginResetButton);
        ResetSQBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SQ1Ans = SQAnswer1.getText().toString().trim();
                String SQ2Ans = SQAnswer2.getText().toString().trim();
                String SQ3Ans = SQAnswer3.getText().toString().trim();


                if(TextUtils.isEmpty(SQ1Ans)){
                    SQAnswer1.setError("Cannot Leave Field Empty");
                    return;
                }

                if(TextUtils.isEmpty(SQ2Ans)){
                    SQAnswer2.setError("Cannot Leave Field Empty");
                    return;
                }


                if(TextUtils.isEmpty(SQ3Ans)){
                    SQAnswer3.setError("Cannot Leave Field Empty");
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