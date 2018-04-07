package com.example.sony.mainhi;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 4/7/2018.
 */

public class Connect {

    class DoGets extends AsyncTask<String, Void, Integer> {


        @Override
        protected void onPostExecute(Integer integer) {
            // super.onPostExecute(integer);
            if (integer == 500) Log.d("test", "Failed");
            else if (integer == 200) Log.d("test", "Successfl");
        }

        @Override
        protected Integer doInBackground(String... params) {

            String urlString = "http://192.168.1.109/moneylog/api/money";
            URL url = null;
            HttpURLConnection httpURLConnection = null;
            InputStream inputStream = null;
            String result = "";
            int c;

            try {
                url = new URL(urlString);
                //Toast.makeText(Statitstics.this,"sfjjdds",Toast.LENGTH_LONG).show();
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
                //Toast.makeText(Log_Statistic.this, "sfjjdds", Toast.LENGTH_LONG).show();
                List<MoneyLog> monies = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);// lan luot lay du lieu ra
                    MoneyLog mn = new MoneyLog(jsonObject.getDouble("amount"), jsonObject.getString("name"), null, null, "abc");
                    monies.add(mn);
                }
             //   Toast.makeText(Statitstics.this, monies.size() + "", Toast.LENGTH_LONG).show();
                for (MoneyLog money : monies) {
             //       Toast.makeText(Statitstics.this, money.toString(), Toast.LENGTH_LONG).show();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return 400;
            }
            return 200;
        }
    }
}
