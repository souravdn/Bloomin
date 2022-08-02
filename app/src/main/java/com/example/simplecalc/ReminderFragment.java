package com.example.simplecalc;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import java.net.URLEncoder;


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
        Weather.getWeather(reminderViewGroup,context);

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
}