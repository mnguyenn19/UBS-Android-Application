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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationSetSecurityQuestions extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView RegisSQTitle;
    EditText SQAnswer1, SQAnswer2, SQAnswer3;
    Button SetSQBtn;


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


        // All TextViews
        RegisSQTitle = findViewById(R.id.RegisSetSQTitle);

        SQAnswer1 = findViewById(R.id.RegisSQ1Answer);
        SQAnswer2 = findViewById(R.id.RegisSQ2Answer);
        SQAnswer3 = findViewById(R.id.RegisSQ3Answer);

        SetSQBtn = findViewById(R.id.RegisSetButton);
        SetSQBtn.setOnClickListener(new View.OnClickListener() {
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
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}