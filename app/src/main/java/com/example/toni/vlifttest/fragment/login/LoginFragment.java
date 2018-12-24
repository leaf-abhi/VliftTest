package com.example.toni.vlifttest.fragment.login;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.activity.LoginActivity;


public class LoginFragment extends Fragment {

    private FragmentInteractionListener listener;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private Button buttonLogin;
    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        if(context instanceof LoginActivity) {
            if (context instanceof FragmentInteractionListener) {
                listener = (FragmentInteractionListener) context;
                super.onAttach(context);
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement FragmentInteractionListener");
            }
        } else {
            throw new RuntimeException(context.toString()
                    + " must be Instance of LoginActivity");
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        textInputLayoutEmail = view.findViewById(R.id.text_input_layout_email);
        textInputLayoutPassword = view.findViewById(R.id.text_input_layout_password);
        buttonLogin = view.findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textInputLayoutEmail.getEditText().getText().toString();
                String password = textInputLayoutPassword.getEditText().getText().toString();
                listener.onClickLogin(email,password);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface FragmentInteractionListener {
        void onClickLogin(String email,String password);
    }
}
