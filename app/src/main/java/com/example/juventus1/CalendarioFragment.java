package com.example.juventus1;


import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarioFragment extends Fragment {

    private TextView mTextViewResult;

    private ImageView homeTeam;
    private ImageView awayTeam;
    private RequestQueue mQueue;


    public CalendarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendario, container, false);


        homeTeam = v.findViewById(R.id.flag_homeTeam);
        awayTeam = v.findViewById(R.id.flag_awayTeam);
        mTextViewResult = v.findViewById(R.id.text_view_result);

        final Button epoca1617 = v.findViewById(R.id.epoca16_17);
        mQueue = Volley.newRequestQueue(v.getContext());
        epoca1617.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

        return v;

    }


    private void jsonParse() {

        final String url = "https://api.myjson.com/bins/1ab9i8";


        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, (String) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("rounds");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject rounds = jsonArray.getJSONObject(i);
                                String home_team = rounds.getString("home_team");
                                String score = rounds.getString("match_result");
                                String away_team = rounds.getString("away_team");
                                String data = rounds.getString("date_match");
                                String roundName = rounds.getString("name");

                               // String flag_home_team = rounds.getString("flag_home_team");
                               // String flag_away_team = rounds.getString("flag_away_team");


                                mTextViewResult.append(roundName + "\n" + data + " \n" + home_team + " " + score + " " + away_team + "\n\n");
                                //Picasso.with(getContext()).load(flag_away_team);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        mQueue.add(request);


    }

}
