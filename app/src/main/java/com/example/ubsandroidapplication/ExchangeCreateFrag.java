package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ExchangeCreateFrag extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button excSubmitBtn;
    private Button excCancelBtn;
    TextView excCreateTitle, excCreateDescription, excCreateUni, excCreateUsername;
    EditText excUserTitle, excUserDescription, excUserUni, excUserUsername;
    DatabaseReference firebaseRef;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange_create_frag);

        // Button
        excSubmitBtn = (Button) findViewById(R.id.exchangeSubmitButton);
        excCancelBtn = findViewById(R.id.exchangeCancelButton);

        // TextView
        excCreateTitle = findViewById(R.id.exchangeCreateTitle);
        excCreateDescription = findViewById(R.id.exchangeCreateDescription);
        excCreateUni = findViewById(R.id.exchangeCreateUniversity);
        excCreateUsername = findViewById(R.id.exchangeCreateUsername);

        // EditText
        excUserTitle = findViewById(R.id.exchangeUserTitle);
        excUserDescription = findViewById(R.id.exchangeUserDescription);
        excUserUni = findViewById(R.id.exchangeUserUniversity);
        excUserUsername = findViewById(R.id.exchangeUserUsername);

        // Firebase
        fAuth = FirebaseAuth.getInstance();

        //Database
        firebaseRef = FirebaseDatabase.getInstance().getReference("Database").child("User").child("Exchange");

        excSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = excUserTitle.getText().toString().trim();
                String desc = excUserDescription.getText().toString().trim();
                String uni = excUserUni.getText().toString().trim();
                String username = excUserUsername.getText().toString().trim();


                Intent intent = new Intent(getApplicationContext(),ExchangeHomeFrag.class);
                startActivity(intent);
                finish();

                // Update Database
                HashMap hashMap = new HashMap();
                hashMap.put("excTitle", title);
                hashMap.put("excAnnouncementBox", desc);
                hashMap.put("excUniversity", uni);
                hashMap.put("excUsername", username);

                firebaseRef.child(fAuth.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(ExchangeCreateFrag.this, "Database updated", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        excCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excUserTitle.getText().clear();
                excUserDescription.getText().clear();
                excUserUni.getText().clear();
                excUserUsername.getText().clear();

                Intent intent = new Intent(getApplicationContext(),ExchangeHomeFrag.class);
                startActivity(intent);
                finish();
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


/*public class ExchangeCreateFrag extends Fragment implements AdapterView.OnItemSelectedListener {

    private Button excSubmitBtn;
    private Button excCancelBtn;
    TextView excCreateTitle, excCreateDescription, excCreateUni, excCreateUsername;
    EditText excUserTitle, excUserDescription, excUserUni, excUserUsername;
    DatabaseReference firebaseRef;
    FirebaseAuth fAuth;

    private ViewPager viewPager;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exchange_create_frag, container, false);

        // Button
        excSubmitBtn = (Button) view.findViewById(R.id.exchangeSubmitButton);
        excCancelBtn = view.findViewById(R.id.exchangeCancelButton);

        // TextView
        excCreateTitle = view.findViewById(R.id.exchangeCreateTitle);
        excCreateDescription = view.findViewById(R.id.exchangeCreateDescription);
        excCreateUni = view.findViewById(R.id.exchangeCreateUniversity);
        excCreateUsername = view.findViewById(R.id.exchangeCreateUsername);

        // EditText
        excUserTitle = view.findViewById(R.id.exchangeUserTitle);
        excUserDescription = view.findViewById(R.id.exchangeUserDescription);
        excUserUni = view.findViewById(R.id.exchangeUserUniversity);
        excUserUsername = view.findViewById(R.id.exchangeUserUsername);

        // Firebase
        fAuth = FirebaseAuth.getInstance();

        // Viewpager
        viewPager = (ViewPager) getActivity().findViewById(R.id.exchangePgFrag);

        //Database
        firebaseRef = FirebaseDatabase.getInstance().getReference("Database").child("User").child("Exchange");

        excSubmitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);

                String title = excUserTitle.getText().toString().trim();
                String desc = excUserDescription.getText().toString().trim();
                String uni = excUserUni.getText().toString().trim();
                String username = excUserUsername.getText().toString().trim();




                // Update Database
                HashMap hashMap = new HashMap();
                hashMap.put("excTitle", title);
                hashMap.put("excAnnouncementBox", desc);
                hashMap.put("excUniversity", uni);
                hashMap.put("excUsername", username);

                //firebaseRef.setValue(firebaseRef);

                firebaseRef.child(fAuth.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getContext(), "Database updated", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        excCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excUserTitle.getText().clear();
                excUserDescription.getText().clear();
                excUserUni.getText().clear();
                excUserUsername.getText().clear();
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}*/
