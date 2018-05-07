package com.example.user.dbproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    Button  insertButton,searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        insertButton=findViewById(R.id.baseinsert);
        searchButton=findViewById(R.id.basesearch);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this,MainActivity.class));
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BaseActivity.this, "You Clicked Search", Toast.LENGTH_SHORT).show();
               // startActivity(new Intent(BaseActivity.this,SearchStudent.class));
            }
        });
    }
}
