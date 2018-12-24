package com.example.toni.vlifttest.fragment.login;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.activity.LoginActivity;

public class LoginPromoFragment extends Fragment {
    Button buttonLoginPromo;
    FragmentInteractionListener listener;
    public LoginPromoFragment() {
        // Required empty public constructor
    }

    public static LoginPromoFragment newInstance() {
        LoginPromoFragment fragment = new LoginPromoFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        if(context instanceof LoginActivity) {
            if(context instanceof FragmentInteractionListener) {
                listener = (FragmentInteractionListener)context;
                super.onAttach(context);
            } else {
                throw new IllegalStateException("Context must implement FragmentInteractionListener");
            }

        } else {
            throw new IllegalStateException("Context must be instance of LoginActivity");
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
        View view = inflater.inflate(R.layout.fragment_login_promo, container, false);
        buttonLoginPromo = view.findViewById(R.id.button_login_promo);
        buttonLoginPromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickLoginPromo();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        buttonLoginPromo.setOnClickListener(null);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface FragmentInteractionListener {
        void onClickLoginPromo();
    }

}
