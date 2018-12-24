package com.example.toni.vlifttest.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.fragment.main.MenuFragment;
import com.example.toni.vlifttest.fragment.main.ProfileFragment;
import com.example.toni.vlifttest.fragment.menu.AccountSettingFragment;
import com.example.toni.vlifttest.fragment.menu.WebViewFragment;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(this,""+selectedOptionId,Toast.LENGTH_SHORT).show();
        Fragment fragment = null;
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
                break;
            }
            case 5: {
                fragment = WebViewFragment.newInstance("https://partner.urbanclap.com/help-center");
                break;
            }
            case 6: {
                fragment = WebViewFragment.newInstance("https://www.urbanclap.com/terms");
                break;
            }
            case 7: {
                fragment = WebViewFragment.newInstance("https://www.urbanclap.com/privacy-policy");
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
        if(fragment!=null)
            getSupportFragmentManager().beginTransaction()
                .replace(frameLayout.getId(),fragment)
                .commit();
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
