package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class AddTaskActivity extends AppCompatActivity {

    AutoCompleteTextView plant, reminder;
    EditText date, time;
    int hour, minute;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    AppCompatButton add;

    String[] plants = {"Parsley", "Lemongrass", "Basil", "Sage", "Oregano"};
    String[] reminders = {"Watering", "Misting", "Fertilizing", "Repotting"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        plant = findViewById(R.id.addPlantName);
        reminder = findViewById(R.id.reminderName);
        date = findViewById(R.id.reminderDate);
        date.setShowSoftInputOnFocus(false);
        date.setCursorVisible(false);
        add = findViewById(R.id.add_reminder_btn);

        time = findViewById(R.id.reminderTime);
        time.setShowSoftInputOnFocus(false);
        time.setCursorVisible(false);

        ArrayAdapter<String> plantAdapter = new ArrayAdapter<String>(this, R.layout.gender_list, plants);
        plant.setAdapter(plantAdapter);

        ArrayAdapter<String> reminderAdapter = new ArrayAdapter<String>(this, R.layout.gender_list, reminders);
        reminder.setAdapter(reminderAdapter);


        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddTaskActivity.this, android.R.style.Theme_Holo_Light_Dialog,
                        onDateSetListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                String selectdate = dayOfMonth + "/" + month + "/" + year;
                date.setText(selectdate);
            }
        };


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popTimePicker(view);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(Objects.requireNonNull(plant.getText()).toString())){
                    Toast.makeText(AddTaskActivity.this, "Add Plant Name", Toast.LENGTH_SHORT).show();
                    plant.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(Objects.requireNonNull(reminder.getText()).toString())) {
                    Toast.makeText(AddTaskActivity.this, "Add Reminder Type", Toast.LENGTH_SHORT).show();
                    reminder.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(Objects.requireNonNull(date.getText()).toString())) {
                    Toast.makeText(AddTaskActivity.this, "Add Reminder Date", Toast.LENGTH_SHORT).show();
                    date.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(Objects.requireNonNull(time.getText()).toString())) {
                    Toast.makeText(AddTaskActivity.this, "Add Reminder Time", Toast.LENGTH_SHORT).show();
                    time.requestFocus();
                    return;
                }
                Toast.makeText(getApplicationContext(), "Reminder Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void popTimePicker(View view)
    {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener()
        {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                hour = selectedHour;
                minute = selectedMinute;
                time.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };

        int style = AlertDialog.THEME_HOLO_LIGHT;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hour, minute, false);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();

    }


}