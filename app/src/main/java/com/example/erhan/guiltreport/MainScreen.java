package com.example.erhan.guiltreport;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainScreen extends AppCompatActivity {
    String url="http://10.0.2.2/getreport.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView lv = (ListView) findViewById(R.id.lv);
        final Downloader d= new Downloader(MainScreen.this,this.url,lv);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.execute();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainscreen_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        // create a new Intent to launch the AddEditContact Activity
        Intent addNewContact =
                new Intent(MainScreen.this, AddNewReport.class);
        startActivity(addNewContact); // start the AddEditContact Activity
        return super.onOptionsItemSelected(item); // call super's method
    }
}
