package com.example.erhan.guiltreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    EditText editText1; //username
    EditText editText2; //password
    Button login_button;    //login button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        login_button = (Button) findViewById(R.id.login_button);


    }

    public void onLogin(View view){     //onClick method of LOGIN button
        String username = editText1.getText().toString();
        String password = editText2.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);
    }

    public void onSignUp(View view){
        Intent intent = new Intent(LoginScreen.this, AddNewAccount.class);
        startActivity(intent);
    }
}
