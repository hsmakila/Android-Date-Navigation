package com.example.akila.datenavigationbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomView customView = findViewById(R.id.customView);
        customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TEST","Click");
            }
        });
        Log.d("TEST",customView.getTrackText().toString());
        customView.setOnLoadingClickListener(new CustomView.OnLoadingButtonClickListener() {
            @Override
            public void onLoadingButtonClickListener(String title) {
                Log.d("TEST",title);
            }
        });
        /*customView.setOnLoadingClickListener(new CustomView.OnLoadingButtonClickListener() {
            @Override
            public void onLoadingButtonClickListener() {
                Log.d("TEST","OnLoading");
            }
        });*/
    }
}
