package com.auth0.samples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by ej on 6/26/17.
 */

public class TimeSheets extends Activity {

    private TextView token;
    private OkHttpClient client;

    @Override`
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_sheets);
        Button btCreateEntry = (Button) findViewById(R.id.btCreateEntry);
        token = (TextView) findViewById(R.id.token);
        token.setText(getIntent().getStringExtra("token"));
    }

//    private String getEntries() throws IOException {
//        Request request = new Request.Builder()
//                .url(getString(R.string.api_domain))
//                .build();
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }
//
//    private void createEntry() {
//
//    }
}
