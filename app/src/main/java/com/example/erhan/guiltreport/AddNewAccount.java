package com.example.erhan.guiltreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewAccount extends AppCompatActivity {
    EditText editText1;      //username
    EditText editText2;      //password
    EditText editText3;      //Name
    EditText editText4;      //Surname
    Button signup_button;    //sign up button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_account);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        signup_button = (Button) findViewById(R.id.signup_button);
    }

    public void onSignUp(View view){
        String username = editText1.getText().toString();
        String password = editText2.getText().toString();
        String name = editText3.getText().toString();
        String surname = editText4.getText().toString();

        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password,name,surname);

    }
}
