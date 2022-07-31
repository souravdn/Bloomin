package com.example.simplecalc;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReminderFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup remainderViewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_reminder, null);
//        ListView remainderListView = (ListView) remainderViewGroup.findViewById(R.id.remainderLV);
//        generateRemainderList(remainderListView);
        return remainderViewGroup;
    }

    final Context context;
    public ReminderFragment(Context c) {
        context=c;
    }

    public void generateRemainderList(ListView remainderListView) {
        ArrayList<String> remainderList = new ArrayList<>();
        for (int j = 1; j <= 10; j++) {
            remainderList.add("Remainder "+j);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context.getApplicationContext(), android.R.layout.simple_list_item_checked,remainderList);
        Log.i("Adapter",arrayAdapter.toString());
        remainderListView.setAdapter(arrayAdapter);
    }
}