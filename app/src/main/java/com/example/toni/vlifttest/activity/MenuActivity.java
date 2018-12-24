package com.example.toni.vlifttest.activity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.fragment.main.MenuFragment;
import com.example.toni.vlifttest.fragment.main.ProfileFragment;
import com.example.toni.vlifttest.fragment.menu.AccountSettingFragment;

public class MenuActivity extends AppCompatActivity implements
        AccountSettingFragment.FragmentInteractionListener {
    FrameLayout frameLayout;
    int selectedOptionId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        frameLayout = findViewById(R.id.frame_layout_menu_activity);
        Bundle args;
        if(savedInstanceState==null)
            args = getIntent().getExtras();
        else
            args = savedInstanceState;

        selectedOptionId = (int)args.getLong(MenuFragment.MENU_ITEM_ID_KEY);
        Toast.makeText(this,""+selectedOptionId,Toast.LENGTH_SHORT).show();
        Fragment fragment;
        switch(selectedOptionId) {
            case 0: {
                break;
            }

            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                fragment = AccountSettingFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .replace(frameLayout.getId(),fragment)
                        .commit();
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                break;
            }
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                break;
            }
            default : {
                break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ProfileFragment.SELECTED_VIEW_ID_KEY,selectedOptionId);
    }

    @Override
    public void onFragmentInteraction() {

    }
}
