package com.etf.telekomunikacije.datepicker;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

//Class for making time picker fragment
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    //local variable neccessary for showing right toast format
    public String format;


    //serves for saving values from time picker
    private DateTimePicked onSelectedListener;

    @Override
    public void onAttach (Activity activity) {
        super.onAttach(activity);

        try {
            onSelectedListener = (DateTimePicked) activity;
        } catch (Exception e) {
            // we will do nothing for now
        }
    }


    //Creating TimePicker
        @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));

    }
    //when time is set, show toast message and save values from time picker
    public void onTimeSet(TimePicker view, int hour, int minute) {

            if (hour == 0) {
                hour += 12;
                format = "AM";
            } else if (hour == 12) {
                format = "PM";
            } else if (hour > 12) {
                hour -= 12;
                format = "PM";
            } else {
                format = "AM";
            }


        Toast.makeText(getActivity(), hour + ":" + minute + "" + format , Toast.LENGTH_SHORT).show();

        if(onSelectedListener != null) {
            onSelectedListener.onTimeSelected(hour, minute);
        }
    }


    }


