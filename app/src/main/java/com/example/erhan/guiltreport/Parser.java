package com.example.erhan.guiltreport;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Erhan on 7.08.2017.
 */

public class Parser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    ListView lv;
    String data;

    ArrayList<String> reports = new ArrayList<>();
    ProgressDialog pd;

    public Parser(Context c, String data, ListView lv) {
        this.c = c;
        this.lv = lv;
        this.data = data;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Parser");
        pd.setMessage("Parsing .... Please wait");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {


        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        pd.dismiss();

        if(integer == 1){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,reports);
            lv.setAdapter(adapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Snackbar.make(view,reports.get(position), Snackbar.LENGTH_SHORT).show();
                }
            });
        }else{
            Toast.makeText(c,"Unable to parse data",Toast.LENGTH_SHORT).show();
        }
    }

    private int parse(){
        try {
            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;

            reports.clear();

            for (int i=0;i<ja.length();i++){
                jo = ja.getJSONObject(i);

                String username = jo.getString("username");

                reports.add(username);
            }

            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
