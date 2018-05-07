package com.example.user.dbproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TypeClass extends AppCompatActivity {
    Button sportsBtn,culturalBtn,acedemicsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_class);
        sportsBtn=findViewById(R.id.sports);
        culturalBtn=findViewById(R.id.cultural);
        acedemicsBtn=findViewById(R.id.acedemics);

        sportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TypeClass.this,SportInsert.class));
            }
        });
        culturalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TypeClass.this, "cultural is clciked", Toast.LENGTH_SHORT).show();
            }
        });
        acedemicsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TypeClass.this, "Acedemics is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
