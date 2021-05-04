package com.example.ubsandroidapplication;

        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;


public class CommunicationView extends MainActivity implements View.OnClickListener {
    //Declaring EditText
    private EditText editTextEmail;
    private EditText editTextSubject;
    private EditText editTextMessage;
    //Send button
    private Button buttonSend;
    private View fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View contentView = inflater.inflate(R.layout.activity_communication_view, null, false);
        //ViewGroup drawer;
       // drawer.addView(contentView, 0);
       // fab.setVisibility(View.INVISIBLE);
        editTextEmail = (EditText) findViewById(R.id.editText5);
        editTextSubject = (EditText) findViewById(R.id.editText12);
        editTextMessage = (EditText) findViewById(R.id.editText3);
        buttonSend = (Button) findViewById(R.id.buttonSend);
        //Adding click listener
        buttonSend.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

