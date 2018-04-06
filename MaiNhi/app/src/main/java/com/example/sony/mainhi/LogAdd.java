package com.example.sony.mainhi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogAdd extends AppCompatActivity {
    Button btnDate ;
    EditText edtAmount;
    EditText edtContent;
    EditText edtNote;
    RadioButton rdbutton;
    Button btnAdd;


    Calendar myCalendar = Calendar.getInstance();
    DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
    DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(DatePicker view,
                              int year, int monthOfYear, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateTime();
        }
    };
    private Date updateTime() {
        return myCalendar.getTime();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edtContent = (EditText) findViewById(R.id.edtcontent);
        edtAmount= (EditText) findViewById(R.id.edtamount);
        edtNote= (EditText) findViewById(R.id.edtnote);
        rdbutton= (RadioButton) findViewById(R.id.rdthu);
        btnDate= findViewById(R.id.btndate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(LogAdd.this,d,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        updateTime();

        btnAdd= (Button) findViewById(R.id.btnThem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoneyLog moneyLog= new MoneyLog();
                moneyLog.setAmount(Double.parseDouble(edtAmount.getText().toString()));
                moneyLog.setContent(edtContent.getText().toString());
                moneyLog.setNote(edtNote.getText().toString());
                if (rdbutton.isChecked()) moneyLog.setCategory("Thu");
                else  moneyLog.setCategory("Chi");
                Date date = updateTime();
                moneyLog.setDate(date.toString());
                MoneyLogDAO moneyLogDAO= new MoneyLogDAO(LogAdd.this);
                moneyLogDAO.insert(moneyLog);
                Toast.makeText(LogAdd.this,moneyLog.toString(),Toast.LENGTH_LONG).show();
                MoneyLogsRecent.moneyLogs.add(moneyLog);
            }
        });

        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogAdd.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }


}
