package com.example.toni.vlifttest.activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.fragment.login.LoginFragment;
import com.example.toni.vlifttest.fragment.main.ProfileFragment;
import com.example.toni.vlifttest.fragment.profile.EditProfilePicFragment;

public class ProfileActivity extends AppCompatActivity implements
        EditProfilePicFragment.FragmentInteractionListener {
    FrameLayout frameLayout;
    private int selectedViewId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        frameLayout = findViewById(R.id.frame_layout_profile_activity);
        Bundle args;
        if(savedInstanceState==null)
            args = getIntent().getExtras();
        else
            args = savedInstanceState;
        selectedViewId = args.getInt(ProfileFragment.SELECTED_VIEW_ID_KEY);
        Toast.makeText(this,""+selectedViewId,Toast.LENGTH_SHORT).show();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Fragment fragment = null;
        switch (selectedViewId) {
            case R.id.button_id_verfication : {
                break;
            }

            case R.id.button_about_me : {
                break;
            }

            case R.id.button_location : {
                break;
            }

            case R.id.button_references: {
                break;
            }

            case R.id.button_work_photos : {
                break;
            }

            case R.id.button_certificate_photos : {
                break;
            }

            case R.id.image_view_profile : {
                getSupportActionBar().setTitle("Choose your Profile Picture");
                fragment = EditProfilePicFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .replace(frameLayout.getId(),fragment)
                        .commit();
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ProfileFragment.SELECTED_VIEW_ID_KEY,selectedViewId);
    }

    @Override
    public void onFragmentInteraction() {

    }
}
