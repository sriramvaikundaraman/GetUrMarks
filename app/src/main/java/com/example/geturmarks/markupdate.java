package com.example.geturmarks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class markupdate extends AppCompatActivity {
    TextView examt,subt;
    EditText r1,r2,r3,r4,r5,r6,e1,e2,e3,e4,e5,e6;
    Button b1,b2,b3,b4,b5,b6,b7;
    ProgressDialog progressDialog;
    String url="https://sriramvcse.000webhostapp.com/markpush1.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markupdate);
        Intent intent = this.getIntent();
        final String exam= intent.getExtras().getString("exam");
        final String subject= intent.getExtras().getString("subject");
        examt=(TextView)findViewById(R.id.exam);
        subt=(TextView)findViewById(R.id.sub);
        examt.setText(exam);
        subt.setText(subject);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        e3=(EditText)findViewById(R.id.e3);
        e4=(EditText)findViewById(R.id.e4);
        e5=(EditText)findViewById(R.id.e5);
        e6=(EditText)findViewById(R.id.e6);
        r1=(EditText)findViewById(R.id.r1);
        r2=(EditText)findViewById(R.id.r2);
        r3=(EditText)findViewById(R.id.r3);
        r4=(EditText)findViewById(R.id.r4);
        r5=(EditText)findViewById(R.id.r5);
        r6=(EditText)findViewById(R.id.r6);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        b5=(Button)findViewById(R.id.b5);
        b6=(Button)findViewById(R.id.b6);
        progressDialog=new ProgressDialog(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Updating marks..");
                progressDialog.show();
                String mark=e1.getText().toString();
                String roll=r1.getText().toString();
                insert(exam,subject,mark,roll);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Updating marks..");
                progressDialog.show();
                String mark=e2.getText().toString();
                String roll=r2.getText().toString();
                insert(exam,subject,mark,roll);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Updating marks..");
                progressDialog.show();
                String mark=e3.getText().toString();
                String roll=r3.getText().toString();
                insert(exam,subject,mark,roll);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Updating marks..");
                progressDialog.show();
                String mark=e4.getText().toString();
                String roll=r4.getText().toString();
                insert(exam,subject,mark,roll);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Updating marks..");
                progressDialog.show();
                String mark=e5.getText().toString();
                String roll=r5.getText().toString();
                insert(exam,subject,mark,roll);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Updating marks..");
                progressDialog.show();
                String mark=e6.getText().toString();
                String roll=r6.getText().toString();
                insert(exam,subject,mark,roll);
            }
        });








    }

    private void insert(final String exam, final String sub, final String mark, final String roll) {
        AddDb addDb = new AddDb(exam,sub,mark,roll);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("exam", exam);
                params.put("sub", sub);
                params.put("mark", mark);
                params.put("roll", roll);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        stringRequest.setShouldCache(false);


    }
}
