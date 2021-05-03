package com.example.ubsandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ExchangeEditFrag extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button excSubmitBtn;
    private Button excCancelBtn;
    private Button excDeleteBtn;

    TextView excEditTitle, excEditDescription, excEditUni, excEditUsername;
    EditText excEditUserTitle, excEditUserDescription, excEditUserUni, excEditUserUsername;

    FirebaseAuth fAuth;
    DatabaseReference rootRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange_edit_frag);

        // Button
        excSubmitBtn = (Button) findViewById(R.id.exchangeSubmitButton);
        excCancelBtn = findViewById(R.id.exchangeCancelButton);
        excDeleteBtn = findViewById(R.id.exchangeDeleteButton);

        // TextView
        excEditTitle = findViewById(R.id.exchangeEditTitle);
        excEditDescription = findViewById(R.id.exchangeEditDescription);
        excEditUni = findViewById(R.id.exchangeEditUniversity);
        excEditUsername = findViewById(R.id.exchangeEditUsername);

        // EditText
        excEditUserTitle = findViewById(R.id.exchangeEditUserTitle);
        excEditUserDescription = findViewById(R.id.exchangeEditUserDescription);
        excEditUserUni = findViewById(R.id.exchangeEditUserUniversity);
        excEditUserUsername = findViewById(R.id.exchangeEditUserUsername);

        //Database
        fAuth = FirebaseAuth.getInstance();
        rootRef = FirebaseDatabase.getInstance().getReference("Database").child("User").child("Exchange");

        excSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = excEditUserTitle.getText().toString().trim();
                String desc = excEditUserDescription.getText().toString().trim();
                String uni = excEditUserUni.getText().toString().trim();
                String username = excEditUserUsername.getText().toString().trim();

                Intent intent = new Intent(getApplicationContext(),ExchangeHomeFrag.class);
                startActivity(intent);
                finish();

                // Update Database
                HashMap hashMap = new HashMap();
                hashMap.put("excTitle", title);
                hashMap.put("excAnnouncementBox", desc);
                hashMap.put("excUniversity", uni);
                hashMap.put("excUsername", username);

                rootRef.child(fAuth.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(ExchangeEditFrag.this, "Database updated", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        excCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ExchangeHomeFrag.class);
                startActivity(intent);
                finish();

                HashMap hashMap = new HashMap();
                rootRef.child(fAuth.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(ExchangeEditFrag.this, "Cancelled. Returning to home page.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        excDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

/*public class ExchangeEditFrag extends Fragment {
    View view;

    private Button excSubmitBtn;
    private Button excCancelBtn;
    private Button excDeleteBtn;

    TextView excEditTitle, excEditDescription, excEditUni, excEditUsername;
    EditText excEditUserTitle, excEditUserDescription, excEditUserUni, excEditUserUsername;

    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exchange_edit_frag, container, false);

        // Button
        excSubmitBtn = (Button) view.findViewById(R.id.exchangeSubmitButton);
        excCancelBtn = view.findViewById(R.id.exchangeCancelButton);
        excDeleteBtn = view.findViewById(R.id.exchangeDeleteButton);

        // TextView
        excEditTitle = view.findViewById(R.id.exchangeEditTitle);
        excEditDescription = view.findViewById(R.id.exchangeEditDescription);
        excEditUni = view.findViewById(R.id.exchangeEditUniversity);
        excEditUsername = view.findViewById(R.id.exchangeEditUsername);

        // EditText
        excEditUserTitle = view.findViewById(R.id.exchangeEditUserTitle);
        excEditUserDescription = view.findViewById(R.id.exchangeEditUserDescription);
        excEditUserUni = view.findViewById(R.id.exchangeEditUserUniversity);
        excEditUserUsername = view.findViewById(R.id.exchangeEditUserUsername);

        viewPager = (ViewPager) getActivity().findViewById(R.id.exchangePgFrag);

        //showAllPosts();

        excSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
*/
                /*FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.exchangePgFrag, new ExchangeHomeFrag());
                ft.commit();*/
 /*           }
        });

        excCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        excDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }
*/
/*
    /*private void showAllPosts() {
        Intent intent = getIntent();
        String a = intent.getStringExtra("");
        String a = intent.getStringExtra("");
        String a = intent.getStringExtra("");
        String a = intent.getStringExtra("");

        excEditUserTitle.getEditText().setText
    }
}*/
