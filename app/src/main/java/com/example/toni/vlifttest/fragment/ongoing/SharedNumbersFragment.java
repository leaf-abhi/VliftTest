package com.example.toni.vlifttest.fragment.ongoing;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.model.OngoingAll;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SharedNumbersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SharedNumbersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SharedNumbersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SharedNumbersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SharedNumbersFragment newInstance(String param1, String param2) {
        SharedNumbersFragment fragment = new SharedNumbersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shared_numbers, container, false);
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
    }
    private class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        int position;
        OngoingAll ongoingAll;
        public ItemViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.text_view_item_ongoing_all);
        }

        public void bindData(OngoingAll ongoingAll,int position) {
            tv.setText(ongoingAll.getData());
            this.position = position;
        }
    }

}
