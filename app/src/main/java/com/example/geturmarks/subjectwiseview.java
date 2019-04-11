package com.example.geturmarks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class subjectwiseview extends AppCompatActivity {
    TextView tv,sub;
    private static final String url = "https://sriramvcse.000webhostapp.com/subjectwiseview.php";

    //a list to store all the products
    List<Product1> productList1;

    ;
    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectwiseview);
        Intent intent = this.getIntent();
        tv=(TextView)findViewById(R.id.exam);
        sub=(TextView)findViewById(R.id.sub);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final String examid= intent.getExtras().getString("examid");
        final String subject=intent.getExtras().getString("subject");
        sub.setText(subject);
        //final String subject= intent.getExtras().getString("subject");
        tv.setText(examid);
        productList1 = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int i;
                try {
                    //converting the string to json array object
                    JSONArray array = new JSONArray(response);
                    // textView.setText(response);
                    //traversing through all the object
                    for (i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject product1 = array.getJSONObject(i);

                        //adding the product to product list
                        productList1.add(new Product1(

                                product1.getString("rollno"),
                                product1.getString(subject)



                        ));
                    }

                    ProductAdapter1 adapter1 = new ProductAdapter1(getApplicationContext(), productList1);
                    recyclerView.setAdapter(adapter1);


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String,String > getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("examid",examid);
                params.put("subject",subject);
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        stringRequest.setShouldCache(false);
    }
}
