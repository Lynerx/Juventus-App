package com.example.juventus1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Contact> lstContact;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        v = inflater.inflate(R.layout.fragment_home, container, false);
        myrecyclerview = v.findViewById(R.id.contact_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstContact);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter);


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        lstContact = new ArrayList<>();
        //lstContact.add(new Contact("Guarda Redes","",R.drawable.calendario));r
        lstContact.add(new Contact("Wojciech Szczesny", "Number 1", R.drawable.c1));
        lstContact.add(new Contact("Mattia Perin", "Number 22", R.drawable.c2));
        //lstContact.add(new Contact("Defesas","",R.drawable.calendario));
        lstContact.add(new Contact("Carlo Pinsoglio", "Number 21", R.drawable.c3));
        lstContact.add(new Contact("Daniele Rugani", "Number 24", R.drawable.c4));
        lstContact.add(new Contact("Martín Cáceres", "Number 3", R.drawable.c5));
        lstContact.add(new Contact("Andrea Barzagli", "Number 4", R.drawable.c6));
        lstContact.add(new Contact("Leonardo Spinazzola", "Number 15", R.drawable.c7));
        lstContact.add(new Contact("João Cancelo", "Number 20", R.drawable.c8));
        lstContact.add(new Contact("Mattia De Sciglio", "Number 2", R.drawable.c9));
        //lstContact.add(new Contact("Médios","",R.drawable.calendario));
        lstContact.add(new Contact("Miralem Pjanic", "Number 5", R.drawable.c10));
        lstContact.add(new Contact("Emre Can", "Number 23", R.drawable.c11));
        lstContact.add(new Contact("Rodrigo Bentancur", "Number 30", R.drawable.c12));
        lstContact.add(new Contact("Blaise Matuidi", "Number 14", R.drawable.c13));
        //lstContact.add(new Contact("Avançado","",R.drawable.calendario));
        lstContact.add(new Contact("Cristiano Ronaldo", "Number 7", R.drawable.c14));
        lstContact.add(new Contact("Douglas Costa", "Number 11", R.drawable.c15));
        lstContact.add(new Contact("Federico Bernardeschi", "Number 33", R.drawable.c16));
        lstContact.add(new Contact("Juan Cuadrado", "Number 16", R.drawable.c17));
        lstContact.add(new Contact("Paulo Dybala", "Number 10", R.drawable.c18));
        lstContact.add(new Contact("Mario Mandzukic", "Number 17", R.drawable.c19));
        lstContact.add(new Contact("Moise Kean", "Number 18", R.drawable.c20));


    }
}
