package com.etf.telekomunikacije.datepicker;


//Interface which serves for communicatin between activity and fragment
public interface DateTimePicked {
    public void onDateSelected(int year, int month, int day);
    public void onTimeSelected(int hour, int minute);
}
