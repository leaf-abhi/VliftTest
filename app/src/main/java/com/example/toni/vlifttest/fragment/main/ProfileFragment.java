package com.example.toni.vlifttest.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.SessionManager;
import com.example.toni.vlifttest.activity.ProfileDetailsActivity;

public class ProfileFragment extends Fragment implements View.OnClickListener{
    public static final String SELECTED_VIEW_ID_KEY = "selected view id key";
    Button buttonIdVerification;
    Button buttonAboutMe;
    Button buttonaddLocation;
    Button buttonSubmitReferences;
    Button buttonUploadPhotos;
    Button buttonAwardAndCertificates;
    ImageView imageViewProfile;
    TextView textViewName;
    TextView textViewExtra;
    public ProfileFragment() {

    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        buttonIdVerification = view.findViewById(R.id.button_id_verfication);
        buttonAboutMe = view.findViewById(R.id.button_about_me);
        buttonaddLocation = view.findViewById(R.id.button_location);
        buttonSubmitReferences = view.findViewById(R.id.button_references);
        buttonUploadPhotos = view.findViewById(R.id.button_work_photos);
        buttonAwardAndCertificates = view.findViewById(R.id.button_certificate_photos);
        textViewName = view.findViewById(R.id.text_view_profile_name);
        textViewExtra = view.findViewById(R.id.text_view_profile_extra);
        imageViewProfile = view.findViewById(R.id.image_view_profile);


        textViewName.setText("Hello, "+SessionManager.getInstance().getLoggedInUser().getName());
        textViewExtra.setText("");
        buttonIdVerification.setOnClickListener(this);
        buttonAwardAndCertificates.setOnClickListener(this);
        buttonAboutMe.setOnClickListener(this);
        buttonaddLocation.setOnClickListener(this);
        buttonSubmitReferences.setOnClickListener(this);
        buttonUploadPhotos.setOnClickListener(this);
        buttonAwardAndCertificates.setOnClickListener(this);
        imageViewProfile.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this.getContext(),""+v.getId(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.getContext(),ProfileDetailsActivity.class);
        intent.putExtra(SELECTED_VIEW_ID_KEY,v.getId());
        startActivity(intent);
    }
}
