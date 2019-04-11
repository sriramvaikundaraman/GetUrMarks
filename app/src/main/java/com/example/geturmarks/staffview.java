package com.example.geturmarks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class staffview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffview);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.exam, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);


        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.viewsubject, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        Button b=(Button)findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exam=spinner2.getSelectedItem().toString();
                String subject=spinner3.getSelectedItem().toString();
                Intent i=new Intent(getApplicationContext(),allsubjectview.class);
                Intent ii=new Intent(getApplicationContext(),subjectwiseview.class);
                i.putExtra("examid",exam);
                i.putExtra("subject",subject);
                ii.putExtra("examid",exam);
                ii.putExtra("subject",subject);




                if(subject.equals("Allsubjects")){
                    startActivity(i);
                }
                else
                    startActivity(ii);

            }
        });
    }
}
