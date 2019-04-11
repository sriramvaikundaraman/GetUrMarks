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

public class allsubjectview extends AppCompatActivity {
    TextView tv;
    private static final String url = "https://sriramvcse.000webhostapp.com/allsubview.php";

    //a list to store all the products
    List<Product> productList;

    ;
    //the recyclerview
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allsubjectview);
        Intent intent = this.getIntent();
        tv=(TextView)findViewById(R.id.exam);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final String examid= intent.getExtras().getString("examid");
        //final String subject= intent.getExtras().getString("subject");
        tv.setText(examid);
        productList = new ArrayList<>();
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
                        JSONObject product = array.getJSONObject(i);

                        //adding the product to product list
                        productList.add(new Product(

                                product.getString("rollno"),
                                product.getString("cs6601"),
                                product.getString("cs6602"),
                                product.getString("cs6603"),
                                product.getString("cs6604"),
                                product.getString("cs6605"),
                                product.getString("cs6606")


                        ));
                    }

                    ProductAdapter adapter = new ProductAdapter(getApplicationContext(), productList);
                    recyclerView.setAdapter(adapter);


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
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        stringRequest.setShouldCache(false);
    }
}




