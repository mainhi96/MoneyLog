package com.example.sony.mainhi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Log_Statistic extends AppCompatActivity {

    Spinner spin;
    Spinner spinner;
    String arr[] = {" ","Tháng", "Năm"};
    String arr2[] = {"Tất cả", "Thu", "Chi"};
    TextView selection;
    Button btn;
    public TextView responseView;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__statistic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        responseView = (TextView) findViewById(R.id.view);
        btn = (Button) findViewById(R.id.Xem);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                 new DoGets().execute("http://192.168.211.10/moneylog/api/money");

            }
        });

        spin = (Spinner) findViewById(R.id.spinDate);
        spinner= (Spinner) findViewById(R.id.spinDate) ;
        selection = (TextView) findViewById(R.id.tv1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        adapter1.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(adapter1);
        spin.setOnItemSelectedListener(new MyProcessEvent());

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr2
                );
        adapter2.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter2);
    }

    private class MyProcessEvent implements
            AdapterView.OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            //arg2 là phần tử được chọn trong data source

        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            selection.setText("");
        }
    }
    class DoGets extends AsyncTask<String, Void, Integer> {


        @Override
        protected void onPostExecute(Integer integer) {
            // super.onPostExecute(integer);
            if (integer == 500) Log.d("test", "Failed");
            else if (integer == 200) Log.d("test", "Successfl");
        }

        @Override
        protected Integer doInBackground(String... params) {

            String urlString = "http://192.168.211.10/moneylog/api/money";
            URL url = null;
            HttpURLConnection httpURLConnection = null;
            InputStream inputStream = null;
            String result = "";
            int c;

            try {
                url = new URL(urlString);
              //  Toast.makeText(Log_Statistic.this,"sfjjdds",Toast.LENGTH_LONG).show();
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                while ((c = inputStream.read()) != -1) {
                    result += (char) c;

                }
                Log.d("test", result);
                JSONArray jsonArray = new JSONArray(result);
                JSONObject jsonObject;
                //Toast.makeText(Log_Statistic.this, "js", Toast.LENGTH_LONG).show();
                responseView.setText(jsonArray.toString());
          /*      List<MoneyLog> monies = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);// lan luot lay du lieu ra
                    MoneyLog mn = new MoneyLog(jsonObject.getDouble("amount"), jsonObject.getString("name"), null, null, "abc");
                    monies.add(mn);
                }
                  Toast.makeText(Log_Statistic.this, monies.size() + "", Toast.LENGTH_LONG).show();
                for (MoneyLog money : monies) {
                    Toast.makeText(Log_Statistic.this, money.toString(), Toast.LENGTH_LONG).show();
                }*/
            } catch (Exception ex) {
                ex.printStackTrace();
                return 400;
            }
            return 200;
        }
    }
}

