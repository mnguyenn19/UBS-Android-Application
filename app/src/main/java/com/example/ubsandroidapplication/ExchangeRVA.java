package com.example.ubsandroidapplication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRVA extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragArrayList = new ArrayList<>();
    private final ArrayList<String> fragName = new ArrayList<>();

    public ExchangeRVA(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragArrayList.size();
    }

    public void addFrag(Fragment fragment, String name) {
        fragArrayList.add(fragment);
        fragName.add(name);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragName.get(position);
    }
}



//public class ExchangeRVA extends RecyclerView.Adapter<ExchangeRVA.rva_ExchangeVH> {
/*public class ExchangeRVA extends FirebaseRecyclerAdapter<ExchangeRVA.rva_ExchangeVH> {
    Context rvaContext;
    List<Database> rvaInfo;
    Dialog box;

    RecyclerViewAdapter(Context rvaContext, List<Database> rvaInfo) {
        this.rvaContext = rvaContext;
        this.rvaInfo = rvaInfo;
    }
    public static class rva_ExchangeVH extends RecyclerView.ViewHolder {

        private TextView postAnnTitle;
        private TextView postAnnDescription;
        private TextView postAnnUniversity;
        private TextView postAnnUsername;
        private LinearLayout postSingleItem;

        public rva_ExchangeVH(View vhView) {
            super(vhView);

            postSingleItem = (LinearLayout) itemView.findViewById(R.id.postSingleAnnouncement);
            postAnnTitle = (TextView) itemView.findViewById(R.id.exchangePostTitle);
            postAnnDescription = (TextView) itemView.findViewById(R.id.exchangeDescription);
            postAnnUniversity = (TextView) itemView.findViewById(R.id.exchangeUni);
            postAnnUsername = (TextView) itemView.findViewById(R.id.exchangeUsername);
        }
    }

    @Override
    public rva_ExchangeVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(rvaContext).inflate(R.layout.exchange_home_option, parent, false);
        final rva_ExchangeVH vH = new rva_ExchangeVH(view);

        box = new Dialog(rvaContext);
        box.setContentView(R.layout.exchange_view_post_box);
        box.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));    //makes the box behind transparent

        vH.postSingleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView boxPostName = (TextView) box.findViewById(R.id.boxTitle);
                TextView boxPostDescription = (TextView) box.findViewById(R.id.boxDescription);
                TextView boxPostUniversity = (TextView) box.findViewById(R.id.boxUniversity);
                TextView boxPostUsername = (TextView) box.findViewById(R.id.boxUsername);
                boxPostName.setText(rvaInfo.get(vH.getAdapterPosition()).getExcTitle());
                boxPostDescription.setText(rvaInfo.get(vH.getAdapterPosition()).getExcAnnouncementBox());
                boxPostUniversity.setText(rvaInfo.get(vH.getAdapterPosition()).getExcUniversity());
                boxPostUsername.setText(rvaInfo.get(vH.getAdapterPosition()).getExcUsername());

                Toast.makeText(rvaContext,"Test Click" + String.valueOf(vH.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                box.show();
            }
        });
        return vH;
    }

    @Override
    public void onBindViewHolder(rva_ExchangeVH holder, int position) {
        holder.postAnnTitle.setText(rvaInfo.get(position).getExcTitle());
        holder.postAnnDescription.setText(rvaInfo.get(position).getExcAnnouncementBox());
        holder.postAnnUniversity.setText(rvaInfo.get(position).getExcUniversity());
        holder.postAnnUsername.setText(rvaInfo.get(position).getExcUsername());
    }

    @Override
    public int getItemCount() {
        return rvaInfo.size();
    }
}*/
