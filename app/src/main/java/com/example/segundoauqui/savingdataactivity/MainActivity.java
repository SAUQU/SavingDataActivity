package com.example.segundoauqui.savingdataactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    EditText name;
    EditText gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.etname);
        textView = (TextView) findViewById(R.id.tvName);
        name  = (EditText) findViewById(R.id.PersonName);
        gender = (EditText) findViewById(R.id.Gender);

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        String data = textView.getText().toString();


        outState.putString("data", data);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        textView.setText(savedInstanceState.getString("data"));


    }

    public void doSomething(View view) {

        switch (view.getId()) {
            case R.id.btnChangeText:
                String data = editText.getText().toString();
                textView.setText(data);
                break;

            case R.id.btnGoToSecond:
                Person person = new Person(name.getText().toString(), gender.getText().toString());

                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("person", person);

                startActivity(intent);


                break;

            case R.id.btnShareData:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);


        }
    }
}
