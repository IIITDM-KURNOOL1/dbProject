package com.example.user.dbproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // For all our buttons and edit text
    Button btnInsert,eventBtn;
    // Button btnDelete;
    // Button btnSelect;
    // Button btnSearch;
    //  TextView btnText;
    EditText editName;
    EditText editmname;
    EditText editlastname;
    EditText editrollno;
    EditText editsex;
    EditText editdob;
    EditText editdno;
    EditText edituserno;
    //EditText editAge;
    //   EditText editDelete;
    // EditText editSearch;

    // This is our DataManager instance
    DataManager dm;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dm = new DataManager(this);

        // get a reference to the UI item
        btnInsert = (Button) findViewById(R.id.btnInsert);
        editName = (EditText) findViewById(R.id.editName);
        eventBtn=findViewById(R.id.eventBtn);
       /* btnDelete = (Button) findViewById(R.id.btnDelete);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnText=(TextView)findViewById(R.id.textView);

        editAge = (EditText) findViewById(R.id.editAge);
        editDelete = (EditText) findViewById(R.id.editDelete);
        editSearch = (EditText) findViewById(R.id.editSearch);

        // Register MainActivity as a listener
        btnSelect.setOnClickListener(this);
        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnText.setOnClickListener(this);*/
        editmname= (EditText) findViewById(R.id.edit_mname);
        editlastname= (EditText) findViewById(R.id.edit_lname);
        editrollno= (EditText) findViewById(R.id.edit_rollno);
        editsex = (EditText) findViewById(R.id.edit_sex);
        editdob = (EditText) findViewById(R.id.edit_dob);
        editdno = (EditText) findViewById(R.id.edit_dno);
        edituserno = (EditText) findViewById(R.id.edit_useno);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dm.insert(editName.getText().toString(),
                        editmname.getText().toString(),editlastname.getText().toString(),editrollno.getText().toString(),editsex.getText().toString(),editdob.getText().toString(), editdno.getText().toString(),edituserno.getText().toString());
                Toast.makeText(MainActivity.this, "The data has been inserted", Toast.LENGTH_LONG).show();


            }
        });
        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,EventInsertionClass.class));
            }
        });
    }
/*
    @Override
    public void onClick(View v){

        switch (v.getId()){
            case R.id.btnInsert:
                dm.insert(editName.getText().toString(),
                        editAge.getText().toString());
                Toast.makeText(MainActivity.this, "The data has been inserted", Toast.LENGTH_LONG).show();

                break;

            case R.id.btnSelect:
                List<String> person = listOfData(dm.selectAll());

                for (String p: person)
                {
                    btnText.append(p);
                }
                break;

            case R.id.btnSearch:
                showData(dm.searchName(editSearch.getText().toString()));
                btnText.setText(searchedData());
                Toast.makeText(MainActivity.this, "The following data has been searched", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnDelete:
                Toast.makeText(MainActivity.this, "The Following data has been deleted", Toast.LENGTH_LONG).show();
                dm.delete(editDelete.getText().toString());
                break;

        }

    }
    */

    // Output the cursor contents to the log
    public void showData(Cursor c){
        while (c.moveToNext()){
            Log.i(c.getString(1), c.getString(2));
        }
    }
    public List listOfData(Cursor c){
        List <String>data=new ArrayList<>();
        c.moveToFirst();
        while(c.moveToNext()){
            data.add(c.getString(1)+c.getString(2));

        }
        return data;
    }
    public String showText(Cursor c)
    {
        int column=1;
        c.moveToFirst();
        String data="";
        while(column<=2){
            data+=" "+c.getString(column);
            column++;
        }

        return data;
    }

   /* public String searchedData(){
        Cursor c= dm.searchName(editSearch.getText().toString());
        c.moveToFirst();
        return(c.getString(1)+" "+c.getString(2));
    }
*/

}
