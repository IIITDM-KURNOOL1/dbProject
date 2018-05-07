package com.example.user.dbproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SportInsert extends AppCompatActivity {
    EditText Sroll,Seventid,Sname;
    Button  InsertBtn;
    DataManagerSports dataManagerSports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport_insert);
        Sroll=findViewById(R.id.Sroll);
        Seventid=findViewById(R.id.Sid);
        Sname=findViewById(R.id.Sname);
        InsertBtn=findViewById(R.id.insertSports);
        dataManagerSports=new DataManagerSports(this);

        InsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataManagerSports.insert(Sroll.getText().toString(),Seventid.getText().toString(),Sname.getText().toString());
                Toast.makeText(SportInsert.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(SportInsert.this,BaseActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}
