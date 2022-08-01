package com.example.simplecalc;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.net.URLEncoder;

import java.util.ArrayList;

public class ReminderFragment extends Fragment {
    final Context context;
    public Integer img;
    public ReminderFragment(Context c) {
        context = c;
        Log.i("cotext:-", String.valueOf(c));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup reminderViewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_reminder, null);
//        ListView reminderListView = (ListView) reminderViewGroup.findViewById(R.id.reminderLV);
//        generatereminderList(reminderListView);
        View addReminderBtn = reminderViewGroup.findViewById(R.id.addReminderBtn);
        Log.i("Msg:-", "befor getWeather");
        ShowWeather.getWeather(reminderViewGroup,context);

//        setReminderBtn.setOnApplyWindowInsetsListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent=new Intent(context.getApplicationContext(),Addreminder.class);
//                intent.putExtra("plantId",i);
//                startActivity(intent);
//            }
//        });
        return reminderViewGroup;
    }

    static class ShowWeather {
        public static void getWeather(ViewGroup reminderViewGroup,Context context) {
            try {
                DownloadTask task = new DownloadTask(reminderViewGroup,context);
                task.execute("https://api.openweathermap.org/data/2.5/weather?q=" + "Agartala" + "&APPID=fb326550cbee5315dfdeef0b4735fe8e");
            } catch (Exception e) {
                Log.i("1:--", "getWeather error");
                e.printStackTrace();
//                Toast.makeText(c.getApplicationContext(),"Could not find weather :(",Toast.LENGTH_SHORT).show();
            }
        }

        public static class DownloadTask extends AsyncTask<String, Void, String> {
            ImageView weatherIcon;
            TextView tempView;
            ViewGroup parent;
            Context context;

            DownloadTask(ViewGroup reminderViewGroup ,Context c) {
                super();
                weatherIcon = reminderViewGroup.findViewById(R.id.weatherIcon);
                tempView = reminderViewGroup.findViewById(R.id.weatherTemp);
                parent=reminderViewGroup;
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
                    Log.i("urlConnection:--", urlConnection.toString());
                    InputStream in = urlConnection.getInputStream();
                    Log.e("urlConnection:--", urlConnection.toString());
                    reader = new InputStreamReader(in);
                    Log.e("urlConnection:--", urlConnection.toString());
                    int data = reader.read();
                    while (data != -1) {
                        char current = (char) data;
                        result += current;
                        data = reader.read();
                    }
                    return result;
                } catch (Exception e) {
                    Log.w("1:--", "doInBackground error");
                    Log.e("Error", e.getMessage());
//                    Toast.makeText(context.getApplicationContext(),"Could not find weather :(",Toast.LENGTH_SHORT).show();
                    return result;
                }
            }

            @Override
            protected void onPostExecute(String data) {
                super.onPostExecute(data);
                Log.e("Json:--", data);
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    String tempStr = jsonObject.getJSONObject("main").getString("temp");
                    String temp=Math.round(Float.parseFloat(tempStr)-273)+" °C";
                    tempView.setText(temp);

                    JSONArray weatherArr = jsonObject.getJSONArray("weather");
                    String icon = weatherArr.getJSONObject(0).getString("icon");
                    String  iconName="w"+icon;

                    Integer img=parent.getResources().getIdentifier(iconName,"drawable",context.getPackageName());
                    weatherIcon.setImageResource(img);
                } catch (Exception e) {
                    Log.w("1:--", "onPostExecute error");
//                    Toast.makeText(context.getApplicationContext(),"Could not find weather :(",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }
    }

}