package com.example.toni.vlifttest.fragment.main;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.activity.MenuDetailsActivity;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    public static final String MENU_ITEM_ID_KEY = "menu item id key";
    ListView listView;
    List<String> menuItems = new ArrayList<>();
    public MenuFragment() {

    }
    public static MenuFragment newInstance() {
        MenuFragment fragment = new MenuFragment();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        PackageInfo pkgInfo = null;
        try {
            pkgInfo = this.getContext().getPackageManager().getPackageInfo(this.getContext().getPackageName(), 0);
        }catch(PackageManager.NameNotFoundException nameNotFoundE) {
            nameNotFoundE.printStackTrace();
        }
        String version = "";
        if(pkgInfo!=null)
            version = pkgInfo.versionName;

        listView = view.findViewById(R.id.list_view_menu);
        menuItems.add("Credits Balance");
        menuItems.add("GST, PAN and Bank Details");
        menuItems.add("Find Friends on Urban Clap");
        menuItems.add("Earn Free Credits");
        menuItems.add("Account Setting");
        menuItems.add("How it works");
        menuItems.add("Terms of Use");
        menuItems.add("Privacy Policy");
        menuItems.add("Contact Us");
        menuItems.add("Rate App on Play Store");
        menuItems.add("Download UrbanClap Customer app");
        menuItems.add("App Version "+version);
        listView.setAdapter(new MenuAdapter());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(id);
                if(id!=11) { //id = 11 is for app version number
                    Intent intent = new Intent(MenuFragment.this.getContext(), MenuDetailsActivity.class);
                    intent.putExtra(MENU_ITEM_ID_KEY, id);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

    private class MenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return menuItems.size();
        }

        @Override
        public Object getItem(int position) {
            return menuItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_menu,parent,false);
            TextView tV = view.findViewById(R.id.text_view_item);
            ImageView imageViewMore = view.findViewById(R.id.image_view_more);
            imageViewMore.setVisibility(position==menuItems.size()-1?View.INVISIBLE:View.VISIBLE);
            tV.setText(menuItems.get(position));

            return view;
        }
    }
}
