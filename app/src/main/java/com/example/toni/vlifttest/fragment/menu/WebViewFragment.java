package com.example.toni.vlifttest.fragment.menu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.toni.vlifttest.R;

public class WebViewFragment extends Fragment {
    private static final String URL_KEY = "url key";
    private String url;
    public WebViewFragment() {
        // Required empty public constructor
    }

    public static WebViewFragment newInstance(String url) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(URL_KEY,url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args;
        if(savedInstanceState==null)
            args = getArguments();
        else
            args = savedInstanceState;

        url = args.getString(URL_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_privacy_policy, container, false);
        WebView wV = view.findViewById(R.id.web_view_privacy_policy);
        wV.loadUrl(url);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle args) {
        args.putString(URL_KEY,url);
        super.onSaveInstanceState(args);
    }

}
