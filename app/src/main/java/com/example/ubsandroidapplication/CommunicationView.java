package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class CommunicationView extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    private Button buttonSend;
    private View fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        setContentView(R.layout.activity_communication_view);
        //View contentView = inflater.inflate(R.layout.activity_communication_view, null, false);

        //ViewGroup drawer;
        // drawer.addView(contentView, 0);
        // fab.setVisibility(View.INVISIBLE);
        editTextEmail = (EditText) findViewById(R.id.editText5);
        editTextSubject = (EditText) findViewById(R.id.editText12);
        editTextMessage = (EditText) findViewById(R.id.editText3);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        //Adding click listener
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String subj = editTextSubject.getText().toString().trim();;
                String msg = editTextMessage.getText().toString().trim();;

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }

        });
    }


}
