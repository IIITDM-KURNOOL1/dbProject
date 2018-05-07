package com.example.user.dbproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CulturalInsert extends AppCompatActivity {
    EditText Croll, Ceventid, Cname;
    Button InsertBtn1;
    DataManagerCultural dataManagerCultural;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_insert);
        Croll = findViewById(R.id.Croll);
        Ceventid = findViewById(R.id.Cid);
        Cname = findViewById(R.id.Cname);
       InsertBtn1=findViewById(R.id.culturalInsert);
        dataManagerCultural = new DataManagerCultural(this);

        InsertBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataManagerCultural.insert(Croll.getText().toString(), Ceventid.getText().toString(), Cname.getText().toString());
                Toast.makeText(CulturalInsert.this, "Data Inserted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
