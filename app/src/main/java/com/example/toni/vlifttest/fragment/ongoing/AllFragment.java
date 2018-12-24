package com.example.toni.vlifttest.fragment.ongoing;


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
import com.example.toni.vlifttest.model.OngoingAll;

import java.util.ArrayList;
import java.util.List;

public class AllFragment extends Fragment {
    RecyclerView recyclerView;
    public static final int ITEM_TYPE = 0;
    public AllFragment() {
        // Required empty public constructor
    }

    public static AllFragment newInstance() {
        AllFragment fragment = new AllFragment();
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
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_ongoing_all);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        List<OngoingAll> dataList = new ArrayList<>();
        for(int i=0;i<50;++i) {
            dataList.add(new OngoingAll.Builder().setData("Name "+i)
                                                .setDesc("This is description of Person "+i)
                                                .build());
        }

        recyclerView.setAdapter(new RecyclerViewAdapter(dataList));
        return view;
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
        List<OngoingAll> dataList;
        RecyclerViewAdapter(@NonNull List<OngoingAll> dataList) {
            this.dataList = dataList;
        }
        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View viewItem = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
            return new ItemViewHolder(viewItem);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
            itemViewHolder.bindData(dataList.get(i),i);
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        @Override
        public int getItemViewType(int position) {
            return R.layout.item_layout_ongoing_all;
        }
    }
    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewDesc;
        int position;
        OngoingAll ongoingAll;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_item_ongoing_all);
            textViewDesc = itemView.findViewById(R.id.text_view_desc);
        }

        public void bindData(OngoingAll ongoingAll,int position) {
            textViewName.setText(ongoingAll.getData());
            textViewDesc.setText(ongoingAll.getDesc());
            this.position = position;
        }
    }
}
