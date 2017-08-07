package com.example.erhan.guiltreport;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewReport extends AppCompatActivity {
    TextView textView1;     //header
    TextView textView2;     //locaiton
    TextView textView3;     //explanation
    ImageView imageView;   //report photo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);

        imageView = (ImageView) findViewById(R.id.imageview1);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        imageView.setImageResource(R.drawable.test1);
        textView1.setText("asda");
        textView2.setText("asda");
        textView3.setText("asda");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_report_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) // switch based on selected MenuItem's ID
        {
            case R.id.editItem:
                // create an Intent to launch the AddEditContact Activity
                Intent addNewReport =
                        new Intent(this, AddNewReport.class);
              //  Bundle extras = new Bundle();
                // pass the selected contact's data as extras with the Intent
               // addEditContact.putExtra(MainScreen.ROW_ID, rowID);
                addNewReport.putExtra("header", textView1.getText());
                addNewReport.putExtra("location", textView2.getText());
                addNewReport.putExtra("explanation", textView3.getText());
             //   Bitmap image = imageView.getDrawingCache();
            //    extras.putParcelable("imagebitmap", image);
               // addNewReport.putExtra(extras);
                startActivity(addNewReport); // start the Activity
                return true;
            case R.id.deleteItem:
                //deleteContact(); // delete the displayed contact
                return true;
            default:
                return super.onOptionsItemSelected(item);
        } // end switch
    } // end method onOptionsItemSelected
}
