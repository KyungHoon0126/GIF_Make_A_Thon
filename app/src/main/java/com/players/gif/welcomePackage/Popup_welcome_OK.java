package com.players.gif.welcomePackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.AnimationUtils;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.players.gif.DataManagers.UserInfo;
import com.players.gif.HttpManagers.HttpDataManager;
import com.players.gif.IMSIDATAS;
import com.players.gif.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Popup_welcome_OK extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.welcome_popup);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        findViewById(R.id.popup).startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.size_up));

        new Thread(()->{try{
            Thread.sleep(2000);
            Intent i = new Intent();
            i.putExtra("result", (GoogleSignInAccount)getIntent().getParcelableExtra("google_account"));
            setResult(RESULT_OK, i);
            finish();}catch (Exception e){e.printStackTrace();}}).start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE) return false;
        return true;
    }
    @Override
    public void onBackPressed(){ return; }
}
