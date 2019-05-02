package com.example.juventus1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Home2Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home2, container, false);

        // WebView
        WebView myWebWiew = v.findViewById(R.id.webviewHome2);
        myWebWiew.getSettings().getJavaScriptEnabled();
        myWebWiew.setWebViewClient(new WebViewClient());
        myWebWiew.loadUrl("https://www.juventus.com/en/tickets/stadium-museum/juventus-museum-tickets.php");

        return v;
    }
}
