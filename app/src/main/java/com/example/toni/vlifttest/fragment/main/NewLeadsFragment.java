package com.example.toni.vlifttest.fragment.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.activity.MainActivity;
import com.example.toni.vlifttest.model.NewLead;

import java.util.ArrayList;
import java.util.List;

public class NewLeadsFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<NewLead> newLeads = new ArrayList<>();
    Toolbar toolbar;
    public NewLeadsFragment() {
        // Required empty public constructor
    }

    public static NewLeadsFragment newInstance() {
        NewLeadsFragment fragment = new NewLeadsFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_leads, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_new_leads);
        toolbar = view.findViewById(R.id.toolbar_new_leads);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
        addDummyData();
        return view;
    }

    private void addNewLead(NewLead newLead) {
        if(newLead!=null) {
            newLeads.add(newLead);
            recyclerViewAdapter.notifyItemInserted(newLeads.size()-1);
        }
    }

    void addDummyData() {
        for(int i=0;i<50;++i) {
            addNewLead(new NewLead.Builder()
                            .setName("Name "+i)
                            .setAddress("Address"+i)
                            .setCredits("10")
                            .setDistanceKm(i)
                            .setQuotes("0")
                            .setTime("24 Dec 2018")
                            .setWorkTitle("Work "+i)
                            .setWorkDescription("This is the description of Work"+i)
                            .build());
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu_new_leads,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout_new_leads,viewGroup,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
            itemViewHolder.bindData(newLeads.get(position),position);
        }

        @Override
        public int getItemCount() {
            return newLeads.size();
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewQuotes;
        TextView textViewWorkTitle;
        TextView textViewTime;
        TextView textViewCredits;
        TextView textViewWorkDesc;
        TextView textViewAddress;
        TextView textViewDistance;
        ItemViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.text_view_lead_name);
            textViewQuotes = view.findViewById(R.id.text_view_quotes);
            textViewWorkTitle = view.findViewById(R.id.text_view_work_title);
            textViewWorkDesc = view.findViewById(R.id.text_view_work_description);
            textViewTime = view.findViewById(R.id.text_view_time);
            textViewCredits = view.findViewById(R.id.text_view_credits);
            textViewAddress = view.findViewById(R.id.text_view_address);
            textViewDistance = view.findViewById(R.id.text_view_distance);
        }

        void bindData(NewLead newLead,int position) {
            textViewName.setText(newLead.getName());
            textViewQuotes.setText(newLead.getQuotes()+"/5 quotes");
            textViewWorkTitle.setText(newLead.getWorkTitle());
            textViewWorkDesc.setText(newLead.getWorkDescription());
            textViewTime.setText(newLead.getTime());
            textViewCredits.setText(newLead.getCredits()+" credits");
            textViewAddress.setText(newLead.getAddress());
            textViewDistance.setText(String.valueOf(newLead.getDistanceKm())+" Km");
        }
    }
}
