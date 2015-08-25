package com.etf.telekomunikacije.datepicker;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


//Class predicted for creating DatePicker fragment

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    //local variables needed for showing the toast
    public int day_x,month_x,year_x;

    //serves for saving values from date picker
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


    //Creating DatePicker
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    //When date is chosen
    public void onDateSet(DatePicker view, int year, int month, int day) {
        day_x = day;
        month_x = month+1;
        year_x = year;

        Toast.makeText(getActivity(),day_x+"/"+month_x+"/"+year_x,Toast.LENGTH_SHORT).show();


        if(onSelectedListener != null) {
            onSelectedListener.onDateSelected(year, month, day);

        }

    }



}