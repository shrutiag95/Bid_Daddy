package com.biddaddy.pdg.bidding;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class detail extends Activity {
    final String url="http://192.168.43.36/php/bid/change_bid.php";
    final String url_2="http://192.168.43.36/php/bid/get_current_max.php";
    ProgressDialog pDialog;
    EditText bid;
    ImageView img;
    String id,mm;
    TextView des,max,base,name;
    Map<String,Integer> image;
//    Bundle b=getIntent().getExtras();
//    mm =b.getString("curr_max");

    protected void onCreate(Bundle savedInstanceState) {

        image=new HashMap<String,Integer>();
        image.put("1",R.drawable.car2);
        image.put("2",R.drawable.bike);
        image.put("3",R.drawable.mobile);
        image.put("4",R.drawable.def);
        image.put("5",R.drawable.abc);
        super.onCreate(savedInstanceState);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.detail);
        bid=(EditText)findViewById(R.id.bid_input);
        img=(ImageView)findViewById(R.id.item_image);
        des=(TextView)findViewById(R.id.description);
        name=(TextView)findViewById(R.id.item_name);
        base=(TextView)findViewById(R.id.base);
        max=(TextView)findViewById(R.id.cur_bid);
//        Toast.makeText(getApplicationContext(), username.name, Toast.LENGTH_SHORT).show();
        Bundle b=getIntent().getExtras();
        //mm =b.getString("curr_max");

        name.setText(b.getString("name"));
        des.setText(b.getString("des"));
        base.setText("Base Price: $"+b.getString("base"));
        id=b.getString("id");
        img.setImageResource(image.get(id));


        StringRequest strq = new StringRequest(Request.Method.POST, url_2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pDialog.dismiss();
                max.setText("Current ongoing bid is $"+response.trim());
                mm=response.trim();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.dismiss();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }

        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", id);
                return params;
            }

        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(strq);


        pDialog=new ProgressDialog(this);
        pDialog.setMessage("Updating...");

    }






    public void bid_input(View v) {

        int b = Integer.parseInt(bid.getText().toString().trim());
        int m = Integer.parseInt(mm);
        if (b <= m)
            Toast.makeText(getApplicationContext(),"Bid must be higher than current bid",Toast.LENGTH_SHORT).show();
        else {


            pDialog.show();
            StringRequest strq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    pDialog.dismiss();
                    //Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    max.setText("Current ongoing bid is $"+response.trim());
                    mm=response.trim();

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    pDialog.dismiss();
                    //Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("bid", bid.getText().toString());
                    params.put("username", username.name);
                    params.put("id", id);

                    return params;
                }

            };
            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(strq);


        }
    }
}
