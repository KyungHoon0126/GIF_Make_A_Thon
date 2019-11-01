package com.players.gif;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.players.gif.DataManagers.UserInfo;
import com.players.gif.HttpManagers.HttpDataManager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Handler h = new Handler();

        h.postDelayed(()->{
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }, 1000);
    }
}
