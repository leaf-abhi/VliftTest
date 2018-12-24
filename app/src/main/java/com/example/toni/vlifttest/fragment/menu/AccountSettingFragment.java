package com.example.toni.vlifttest.fragment.menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.se.omapi.Session;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class AccountSettingFragment extends Fragment {
    private FragmentInteractionListener mListener;
    RecyclerView recyclerView;
    List<String> settingOpts = new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    public AccountSettingFragment() {
        // Required empty public constructor
    }

    public static AccountSettingFragment newInstance() {
        AccountSettingFragment fragment = new AccountSettingFragment();
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInteractionListener) {
            mListener = (FragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentInteractionListener");
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account_setting, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_account_settings);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

        addItem("Communication Settings");
        addItem("Enter your referral code");
        addItem("Logout");
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    void addItem(String item) {
        if(item!=null) {
            settingOpts.add(item);
            recyclerViewAdapter.notifyItemInserted(settingOpts.size()-1);
        }
    }

    void onItemClick(int position) {
        if(position == 2) { //logout
            SessionManager.getInstance().destroySession();
            Toast.makeText(this.getContext(),"Logged out successfully",Toast.LENGTH_SHORT).show();
            this.getActivity().finish();
        }
    }

    public interface FragmentInteractionListener {
        void onFragmentInteraction();
    }
    private class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout_account_settings,viewGroup,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
            viewHolder.bindData(settingOpts.get(i),i);
        }

        @Override
        public int getItemCount() {
            return settingOpts.size();
        }
    }
    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        int position;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_item_account_setting);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick(position);
                }
            });
        }

        public void bindData(String data, final int position) {
            textView.setText(data);
            this.position = position;
        }
    }
}
