package com.pasmata.dynamicallyautocompletetextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.pasmata.dynamicallyautocompletetextview.api.EndPointInterface;
import com.pasmata.dynamicallyautocompletetextview.api.HeaderHelper;
import com.pasmata.dynamicallyautocompletetextview.api.ServiceGenerator;
import com.pasmata.dynamicallyautocompletetextview.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String token = "Bearer YOUR TOKEN";
    private static final String TAG = "MainActivity";

    ArrayAdapter<String> adapter;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> list = new ArrayList<>();
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);

        Log.d(TAG, "onCreate: " + adapter.getFilter().toString());
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (autoCompleteTextView.getThreshold() < s.length()) {
                    return;
                }
                fetchUser(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private static class UserList {
        private String user;
        public UserList(String user) {
            this.user = user;
        }

        @Override
        public String toString() {
            return user;
        }
    }

    private void fetchUser(final CharSequence c) {
        String keyword = c.toString();
        EndPointInterface endPoint = ServiceGenerator.createService(EndPointInterface.class,
                new HeaderHelper("Authorization", token));

        Call<User> result = endPoint.getUser(keyword);
        result.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, final Response<User> response) {
                try {
                    Log.d(TAG, "onResponse: " + response.code());
                    if(response.code() == 200 && (response.body().getItems().size() > 0)) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.clear();
                                int total = response.body().getItems().size();
                                for(int i=0; i<total; i++) {
                                    String userName = response.body().getItems().get(i).getName();
                                    adapter.add(userName);
                                }
                                adapter.getFilter().filter(c, autoCompleteTextView);

                            }
                        });

                        Log.d(TAG, "total adapter: " + adapter.getCount());
                    }
                    else if(response.code() == 200 && (response.body().getItems().size() > 0)) {
                        Toast.makeText(getBaseContext(), "No suggestion", Toast.LENGTH_LONG).show();
                    }
                    else if(response.code() == 401) {
                        Log.d(TAG, "onResponse: auth failed");
                    }

                }catch (Exception e){
                    Log.d(TAG, "on Cactched " + e.getMessage());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "failure");
            }
        });
    }
}
