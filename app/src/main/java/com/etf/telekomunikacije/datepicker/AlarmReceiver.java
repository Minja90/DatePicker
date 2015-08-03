package com.etf.telekomunikacije.datepicker;

//importing necessary packages

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

// Creating Alarm Receiver, who will listen upcomming events
public class AlarmReceiver extends BroadcastReceiver {

//Creating method on receive. When intnet is received on front screen we should see notification
    @Override
    public void onReceive(Context context, Intent intent) {

        //variable values from three edit text fields
        String name = intent.getStringExtra(MainActivity.EVENT_NAME);
        String description = intent.getStringExtra(MainActivity.EVENT_DESCRIPTION);
        String location = intent.getStringExtra(MainActivity.EVENT_LOCATION);

        //setig up RingtonManger who will notify user about received notification
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        //Handling the notifications, and attributes which will be displayed on front screen
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle(name + "," + location);
        builder.setAutoCancel(true);
        builder.setContentText(description);
        builder.setSmallIcon(R.drawable.alarm_icon1);
        builder.setSound(soundUri);
        builder.setTicker("New event");



        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        nm.notify(0, builder.build());

    }



}