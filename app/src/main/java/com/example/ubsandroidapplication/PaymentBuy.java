package com.example.ubsandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentBuy extends AppCompatActivity {

        CardForm cardForm;
        Button buy;
        AlertDialog.Builder alertBuilder
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_buy);
    }
}