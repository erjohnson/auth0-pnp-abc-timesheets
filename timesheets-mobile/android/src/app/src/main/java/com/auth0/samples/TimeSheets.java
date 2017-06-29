package com.auth0.samples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by ej on 6/26/17.
 */

public class TimeSheets extends Activity {

    private TextView token;
    OkHttpClient client;
    MediaType JSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_sheets);

        Button btCreateEntry = (Button) findViewById(R.id.btCreateEntry);
        token = (TextView) findViewById(R.id.token);
        token.setText(getIntent().getStringExtra("token"));
        client = new OkHttpClient();
        JSON = MediaType.parse("application/json; charset=utf-8");
        try {
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url(getString(R.string.api_domain) + "/timesheets")
                .addHeader("Authorization", "Bearer " + getIntent().getStringExtra("token"))
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Headers responseHeaders = response.headers();
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                }

                System.out.println(response.body().string());
            }
        });
    }
}
