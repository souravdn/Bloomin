package com.example.simplecalc;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
    public static void getWeather(ViewGroup viewGroup, Context context) {
        try {
            DownloadTask task = new DownloadTask(viewGroup,context);
            task.execute("https://api.openweathermap.org/data/2.5/weather?q=" + "Agartala" + "&APPID=fb326550cbee5315dfdeef0b4735fe8e");
        } catch (Exception e) {
            e.printStackTrace();
//            Toast.makeText(context.getApplicationContext(),"Could not fetch weather :(",Toast.LENGTH_SHORT).show();
        }
    }

    public static class DownloadTask extends AsyncTask<String, Void, String> {
        ImageView weatherIcon;
        TextView tempView;
        Context context;

        DownloadTask(ViewGroup viewGroup ,Context c) {
            super();
            weatherIcon = viewGroup.findViewById(R.id.weatherIcon);
            tempView = viewGroup.findViewById(R.id.weatherTemp);
            context=c;
        }
        @Override
        protected String doInBackground(String... urls) {
            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            InputStreamReader reader = null;

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                reader = new InputStreamReader(in);
                int data = reader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                return result;
            }
        }

        @Override
        protected void onPostExecute(String data) {
            super.onPostExecute(data);
            try {
                JSONObject jsonObject = new JSONObject(data);
                String tempStr = jsonObject.getJSONObject("main").getString("temp");
                String temp=Math.round(Float.parseFloat(tempStr)-273)+" °C";
                tempView.setText(temp);

                Log.e("weatherIcon:--", weatherIcon.toString());
                Log.e("tempView:--", tempView.toString());
                Log.e("context:--", context.toString());
                Log.e("tempView:==", tempView.getText().toString());

                JSONArray weatherArr = jsonObject.getJSONArray("weather");
                String icon = "w"+weatherArr.getJSONObject(0).getString("icon").replace("d","n");
                Integer img=context.getResources().getIdentifier(icon,"drawable",context.getPackageName());
                weatherIcon.setImageResource(img);

//                weatherIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.w01n));
//                weatherIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.w01n));
//                weatherIcon.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.w01n,null));
                Log.e("weatherIcon:--", weatherIcon.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
