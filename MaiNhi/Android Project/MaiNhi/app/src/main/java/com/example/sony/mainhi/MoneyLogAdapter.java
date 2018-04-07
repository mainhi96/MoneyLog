package com.example.sony.mainhi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SONY on 4/6/2018.
 */

public class MoneyLogAdapter extends ArrayAdapter<MoneyLog> {
    public MoneyLogAdapter(@NonNull Context context, int resource, @NonNull List<MoneyLog> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v= convertView;
        if (v==null){
            LayoutInflater inflater= LayoutInflater.from(getContext());
            v=inflater.inflate(R.layout.item_lv_main,null);
        }
        MoneyLog moneyLog= getItem(position);
        if(moneyLog!=null){
            TextView date = (TextView) v.findViewById(R.id.tvtime);
            date.setText(moneyLog.getDate().toString());
          TextView name = (TextView) v.findViewById(R.id.tvname);
          name.setText(moneyLog.getContent().toString());
          TextView amount = (TextView) v.findViewById(R.id.tvamount);
          amount.setText(moneyLog.getAmount()+"");
        }
        return v;
    }

}
