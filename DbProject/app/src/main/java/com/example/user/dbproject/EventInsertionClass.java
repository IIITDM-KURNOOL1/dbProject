package com.example.user.dbproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EventInsertionClass extends AppCompatActivity {
    EditText TeamSize,EventName,DateE,Event_id,Venue,Organizer,Level,AwardType;
    Button InsertBtn,switchBtn;
    DataManagerEvent dataManagerEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_insertion_class);
        TeamSize=findViewById(R.id.team_size);
        EventName=findViewById(R.id.event_name);
        DateE=findViewById(R.id.date);
        switchBtn=findViewById(R.id.eventtotype);
        Event_id=findViewById(R.id.event_id);
        Venue=findViewById(R.id.venue);
        Organizer=findViewById(R.id.Organizer);
        Level=findViewById(R.id.level);
        AwardType=findViewById(R.id.award_type);
        InsertBtn=findViewById(R.id.insertBtn);
        dataManagerEvent=new DataManagerEvent(this);

        InsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dataManagerEvent.insert(TeamSize.getText().toString(),
                        EventName.getText().toString(),DateE.getText().toString(),Event_id.getText().toString(),Venue.getText().toString(),Organizer.getText().toString(), Level.getText().toString(),AwardType.getText().toString());
                Toast.makeText(EventInsertionClass.this, "The data has been inserted", Toast.LENGTH_LONG).show();

            }
        });
        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EventInsertionClass.this,TypeClass.class));
            }
        });

    }
}
