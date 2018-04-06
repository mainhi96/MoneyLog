package com.example.sony.mainhi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Log_Statistic extends AppCompatActivity {

    Spinner spin;
    Spinner spinner;
    String arr[] = {"Tháng", "Năm"};
    String arr2[] = {"Chi", "Thu", "Tất cả"};
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
                //  new DoGets().execute("http://192.168.1.109/moneylog/api/money");

            }
        });

        spin = (Spinner) findViewById(R.id.spinDate);
        selection = (TextView) findViewById(R.id.tv1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        this,
                        android.R.layout.simple_spinner_item,
                        arr
                );
        adapter.setDropDownViewResource
                (android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new MyProcessEvent());



    }

    private class MyProcessEvent implements
            AdapterView.OnItemSelectedListener {
        //Khi có chọn lựa thì vào hàm này
        public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            //arg2 là phần tử được chọn trong data source
            selection.setText(arr[arg2]);
        }

        //Nếu không chọn gì cả
        public void onNothingSelected(AdapterView<?> arg0) {
            selection.setText("");
        }
    }
}

