package com.example.sony.mainhi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnadd;
    ListView listView;
    Button btnshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogAdd.class);
                startActivity(intent);
            }
        });
        btnadd = (Button) findViewById(R.id.btnAdd);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Log_Statistic.class);
            }
        });
        listView = (ListView) findViewById(R.id.lvRecent);
        List<MoneyLog> list = new ArrayList<>();
        MoneyLogDAO moneyLogDAO= new MoneyLogDAO(MainActivity.this);
        list=MoneyLogsRecent.moneyLogs;
    //    list=moneyLogDAO.query();
        MoneyLogAdapter adapter = new MoneyLogAdapter(MainActivity.this, R.layout.item_lv_main, list);
        listView.setAdapter(adapter);


    }


}
