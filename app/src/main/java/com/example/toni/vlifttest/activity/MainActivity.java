package com.example.toni.vlifttest.activity;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.SessionManager;
import com.example.toni.vlifttest.fragment.main.MenuFragment;
import com.example.toni.vlifttest.fragment.main.NewLeadsFragment;
import com.example.toni.vlifttest.fragment.main.OngoingFragment;
import com.example.toni.vlifttest.fragment.main.ProfileFragment;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    private static final String SELECTED_MENU_ITEM_ID_KEY = "selected menu item id key";
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private int selectedMenuItemId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view_main);
        frameLayout = findViewById(R.id.frame_layout_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                Fragment fragment;
                selectedMenuItemId = menuItem.getItemId();
                switch (selectedMenuItemId) {
                    case R.id.menu_item_new : {
                        fragment = NewLeadsFragment.newInstance();
                        break;
                    }

                    case R.id.menu_item_ongoing : {
                        fragment = OngoingFragment.newInstance();
                        break;
                    }

                    case R.id.menu_item_profile : {
                        fragment = ProfileFragment.newInstance();
                        break;
                    }

                    case R.id.menu_item_menu : {
                        fragment = MenuFragment.newInstance();
                        break;
                    }

                    default : {
                        return false;
                    }
                }
                ft.replace(frameLayout.getId(),fragment);
                ft.commit();
                return true;
            }
        });
        if(savedInstanceState!=null) {
            selectedMenuItemId = savedInstanceState.getInt(SELECTED_MENU_ITEM_ID_KEY);
        }
        else if(selectedMenuItemId == 0)
            selectedMenuItemId = R.id.menu_item_profile;
        bottomNavigationView.setSelectedItemId(selectedMenuItemId);
        getSupportFragmentManager().beginTransaction()
                .replace(frameLayout.getId(),ProfileFragment.newInstance())
                .commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!SessionManager.getInstance().isSessionAlive())
            this.finish();
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        state.putInt(SELECTED_MENU_ITEM_ID_KEY,selectedMenuItemId);
        super.onSaveInstanceState(state);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
