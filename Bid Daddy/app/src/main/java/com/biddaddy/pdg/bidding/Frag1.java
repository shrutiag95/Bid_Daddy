package com.biddaddy.pdg.bidding;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hpuser on 02-06-2016.
 */
public class Frag1 extends Fragment {

    @Nullable
    ProgressDialog pDialog;
    Map<String,Integer> image;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag1,null);

        image=new HashMap<String,Integer>();
        image.put("1",R.drawable.car2);
        image.put("2",R.drawable.bike);
        image.put("3",R.drawable.mobile);
        image.put("4",R.drawable.def);
        image.put("5",R.drawable.abc);

        final RecyclerView rv = (RecyclerView)v.findViewById(R.id.r1);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        String view_url = "http://192.168.43.36/php/bid/all_bids.php";
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Loading...");
        pDialog.show();
        JsonObjectRequest req=new JsonObjectRequest(Request.Method.POST,view_url,null,new Response.Listener<JSONObject>(){


            @Override
            public void onResponse(JSONObject response) {
                pDialog.hide();
                JSONArray followerarray= null;
                List<model> list=new ArrayList<>();
                try {
                    followerarray = response.getJSONArray("items");

                    for(int i=0;i<followerarray.length();i++){
                        model m=new model();
                        JSONObject obj=followerarray.getJSONObject(i);
                        m.setItemname(obj.getString("name").toString());
                        m.setPrice(obj.getString("base"));
                        m.setId(obj.getString("id"));
                        m.setDes(obj.getString("description"));
                        m.setCurrent_max(obj.getString("current_max_bid"));
                        list.add(m);

                    }} catch (JSONException e) {
                    e.printStackTrace();
                }


                rv.setAdapter(new MyRecyclerAdapter(getActivity(), list, image));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.hide();
                Toast.makeText(getActivity().getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        MySingleton.getInstance(getActivity().getApplicationContext()).addToRequestQueue(req);





        return v;
    }




    @Override
    public String toString() {
        return "All Bids";
    }
}
