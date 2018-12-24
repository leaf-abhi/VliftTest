package com.example.toni.vlifttest.fragment.menu;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toni.vlifttest.R;

import java.util.ArrayList;
import java.util.List;

public class ContactUs extends Fragment {
    List<String> contactUsList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    public ContactUs() {
        // Required empty public constructor
    }
    
    public static ContactUs newInstance() {
        ContactUs fragment = new ContactUs();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_contact_us);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);

        addItem("Email us");
        addItem("Chat with us");
        return view;
    }

    void addItem(String item) {
        if(item!=null) {
            contactUsList.add(item);
            recyclerViewAdapter.notifyItemInserted(contactUsList.size()-1);
        }
    }
    
    void onItemClick(int position) {
        
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout_contact_us,viewGroup,false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder viewHolder, int i) {
            viewHolder.bindData(contactUsList.get(i),i);
        }

        @Override
        public int getItemCount() {
            return contactUsList.size();
        }
    }
    
    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        int position;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_item_contact_us);

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
