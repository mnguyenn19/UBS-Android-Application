package com.example.ubsandroidapplication;

import android.content.Context;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExchangeHomeFrag extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    private View view;

    private Button excBackBtn, excCreateBtn, excEditBtn;
    private DatabaseReference dRef;
    private FirebaseAuth m;
    private RecyclerView recyclerVieww;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Database").child("User").child("Exchange");
    private excModelAdapter adapter;
    private ArrayList<excModel> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange_home_frag);

        // Button
        excCreateBtn = findViewById(R.id.createButton);
        excEditBtn = findViewById(R.id.editButton);
        excBackBtn = findViewById(R.id.homePageBtn);
        recyclerVieww = findViewById(R.id.home_recycler_viewer);
        recyclerVieww.setHasFixedSize(true);
        recyclerVieww.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new excModelAdapter(this, list);

        recyclerVieww.setAdapter(adapter);

        // there is an error right here
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    excModel model = dataSnapshot.getValue(excModel.class);
                    list.add(model);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        excCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExchangeHomeFrag.this,ExchangeCreateFrag.class);
                startActivity(intent);
            }
        });

        excEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExchangeHomeFrag.this,ExchangeEditFrag.class);
                startActivity(intent);
            }
        });

        excBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExchangeHomeFrag.this,MainActivity.class);
                startActivity(intent);
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
/*
public class ExchangeHomeFrag extends Fragment {
    private View view;

    private Button excBackBtn;
    //private ViewPager viewPager;

    private RecyclerView rV;
    private List<Database> post;
    private DatabaseReference AnnouncementRef, UsersRef;
    private FirebaseAuth exchangeAuth;
    private String userID;

    public ExchangeHomeFrag() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exchange_home_frag, container, false);

        rV = (RecyclerView) view.findViewById(R.id.home_recycler_viewer);
        //RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(),post);
        rV.setLayoutManager(new LinearLayoutManager(getActivity()));
        //rV.setAdapter(recyclerAdapter);

        exchangeAuth = FirebaseAuth.getInstance();
        userID = exchangeAuth.getCurrentUser().getUid();
        AnnouncementRef = FirebaseDatabase.getInstance().getReference().child("Database").child("User").child("Exchange");
        UsersRef = FirebaseDatabase.getInstance().getReference().child("Database").child("User").child("Exchange");

        excBackBtn = (Button) view.findViewById(R.id.homePageBtn);

        excBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public static class exchangeViewHolder extends RecyclerView.ViewHolder{
        private TextView postAnnTitle;
        private TextView postAnnDescription;
        private TextView postAnnUniversity;
        private TextView postAnnUsername;
        private LinearLayout postSingleItem;

        public exchangeViewHolder(@NonNull View itemView) {
            super(itemView);

            postSingleItem = (LinearLayout) itemView.findViewById(R.id.postSingleAnnouncement);
            postAnnTitle = (TextView) itemView.findViewById(R.id.exchangePostTitle);
            postAnnDescription = (TextView) itemView.findViewById(R.id.exchangeDescription);
            postAnnUniversity = (TextView) itemView.findViewById(R.id.exchangeUni);
            postAnnUsername = (TextView) itemView.findViewById(R.id.exchangeUsername);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Database>()
                .setQuery(AnnouncementRef, Database.class)
                .build();

        final FirebaseRecyclerAdapter<Database, exchangeViewHolder> adapter = new FirebaseRecyclerAdapter<Database, exchangeViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull exchangeViewHolder holder, int position, @NonNull Database model) {
                String userIDs = getRef(position).getKey();
                UsersRef.child(userIDs).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        String profUsername = snapshot.child("excUsername").getValue().toString();
                        String profTitle = snapshot.child("excTitle").getValue().toString();
                        String profDesc = snapshot.child("excAnnouncementBox").getValue().toString();
                        String profUni = snapshot.child("excUniversity").getValue().toString();

                        holder.postAnnUsername.setText(profUsername);
                        holder.postAnnUniversity.setText(profUni);
                        holder.postAnnDescription.setText(profDesc);
                        holder.postAnnTitle.setText(profTitle);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

            @NonNull
            @Override
            public exchangeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View viewer = LayoutInflater.from(parent.getContext()).inflate(R.layout.exchange_home_option, parent, false);
                exchangeViewHolder viewHolder = new exchangeViewHolder(viewer);


                //final ExchangeRVA.rva_ExchangeVH vH = new ExchangeRVA.rva_ExchangeVH(view);
*/
                /*Dialog box;
                List<Database> rvaInfo;
                Context rvaContext;
                box = new Dialog(rvaContext);
                box.setContentView(R.layout.exchange_view_post_box);
                box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));    //makes the box behind transparent
                */
/*
                viewHolder.postSingleItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

 */
                        /*
                        TextView boxPostName = (TextView) box.findViewById(R.id.boxTitle);
                        TextView boxPostDescription = (TextView) box.findViewById(R.id.boxDescription);
                        TextView boxPostUniversity = (TextView) box.findViewById(R.id.boxUniversity);
                        TextView boxPostUsername = (TextView) box.findViewById(R.id.boxUsername);
                        boxPostName.setText(rvaInfo.get(viewHolder.getAdapterPosition()).getExcTitle());
                        boxPostDescription.setText(rvaInfo.get(viewHolder.getAdapterPosition()).getExcAnnouncementBox());
                        boxPostUniversity.setText(rvaInfo.get(viewHolder.getAdapterPosition()).getExcUniversity());
                        boxPostUsername.setText(rvaInfo.get(viewHolder.getAdapterPosition()).getExcUsername());

                        Toast.makeText(rvaContext,"Test Click" + String.valueOf(viewHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                        box.show();
                        */
/*                    }
                });
                return viewHolder;
            }
        };
        rV.setAdapter(adapter);
        adapter.startListening();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        post = new ArrayList<>();
        post.add(new Database("", "", "", "", "", "", "", "", "uta000", "Meeting Cancelled", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        //"", "", "", "", "", "", "", "", "uta123", "Meeting Cancelled", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""//
        post.add(new Database("", "", "", "", "", "", "", "", "uta001", "Tesla Hiring", "Looking for CSE applicants!", "TCU", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta002", "Dance Practice", "Hello dancers! Remember today's meeting at 6pm in the gym!", "A&M", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta003", "Lost cat near Central Library", "Looking for a blue eyed, white furry cat. 10 pounds and loves fish.", "SMU", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta004", "Meet your advisors!", "Meet and greet session at the engineering building. 5pm!", "Rice", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta005", "Looking for Lab Participants", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta006", "Found a Student ID", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta007", "Lost my calculator", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta008", "Looking for a New Roomate", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta009", "Offering tutoring", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta010", "Found lost cat", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta011", "Movie night!", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));
        post.add(new Database("", "", "", "", "", "", "", "", "uta012", "Happy Spring Break", "Description here", "UTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", '\0', ""));

    }
}
*/