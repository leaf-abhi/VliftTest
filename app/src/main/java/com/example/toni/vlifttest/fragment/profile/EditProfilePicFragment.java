package com.example.toni.vlifttest.fragment.profile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toni.vlifttest.R;

public class EditProfilePicFragment extends Fragment {
    private FragmentInteractionListener mListener;

    public EditProfilePicFragment() {
        // Required empty public constructor
    }

    public static EditProfilePicFragment newInstance() {
        EditProfilePicFragment fragment = new EditProfilePicFragment();
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
        return inflater.inflate(R.layout.fragment_edit_profile_pic, container, false);
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
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface FragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
