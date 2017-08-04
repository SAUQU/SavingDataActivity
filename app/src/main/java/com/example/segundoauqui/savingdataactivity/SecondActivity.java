package com.example.segundoauqui.savingdataactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "Second";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Person person = getIntent().getParcelableExtra("person");
        Log.d(TAG, "onCreate: " + person.getName());




        Toast.makeText(this, person.getName(), Toast.LENGTH_LONG).show();

    }





}
