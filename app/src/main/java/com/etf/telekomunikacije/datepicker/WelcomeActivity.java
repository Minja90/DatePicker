package com.etf.telekomunikacije.datepicker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class WelcomeActivity extends Activity {


    ImageButton setButton;
    TextView welcome_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setButton = (ImageButton) findViewById(R.id.setButton);
        welcome_text = (TextView) findViewById(R.id.welcome_text);
        setButton.setBackgroundDrawable(null);


    }


    public void openActivity (View view) {

        Intent otvori = new Intent(this, MainActivity.class);
        WelcomeActivity.this.startActivity(otvori);

    }

}
