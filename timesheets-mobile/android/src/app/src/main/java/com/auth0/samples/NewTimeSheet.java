package com.auth0.samples;

import android.app.Activity;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Request;

/**
 * Created by ej on 6/28/17.
 */

public class NewTimeSheet extends Activity {
    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception {
        RequestBody formBody = new FormBody.Builder()
                .add("date", "todo")
                .add("project", "todo")
                .add("hours", "todo")
                .build();

        Request request = new Request.Builder()
                .url(getString(R.string.api_domain) + "/timesheets")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        System.out.println(response.body().string());
        // alert for success

    }
}
