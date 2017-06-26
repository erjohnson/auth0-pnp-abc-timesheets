package com.auth0.samples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ej on 6/26/17.
 */

public class TimeSheets extends Activity {

    private TextView token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_sheets);
        token = (TextView) findViewById(R.id.token);
        token.setText(getIntent().getStringExtra("token"));
    }

    private void getEntries() {

    }

    private void createEntry() {

    }
}
