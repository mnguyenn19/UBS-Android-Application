package com.example.ubsandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CommunicationView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication_view);
    }
}

package com.example.ubsandroidapplicationr;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;


public class CommunicationView extends MainActivity implements View.OnClickListener {
    //Declaring EditText
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    //Send button
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_communication_view, null, false);
        drawer.addView(contentView, 0);
        fab.setVisibility(View.INVISIBLE);
        //Initializing the views
        editTextEmail = (EditText) findViewById(R.id.editText5);
        editTextSubject = (EditText) findViewById(R.id.editText12);
        editTextMessage = (EditText) findViewById(R.id.editText3);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        //Adding click listener
        buttonSend.setOnClickListener(this);
    }

    private void sendEmail() {
        //Getting content for email
        SignInActivity login = new SignInActivity();
        String email = editTextEmail.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String message = "University Bazaar" + "\n" + "From: " + login.getUsername() + "\n" + "\n" + editTextMessage.getText().toString().trim();
        SendMail sm = new SendMail(this, email, subject, message);
        sm.execute();
    }
    @Override
    public void onClick(View v) {
        sendEmail();
        Intent intent = new Intent(this, EventPage.class);
        startActivity(intent);
    }
}

