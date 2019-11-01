package com.players.gif.welcomePackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.view.animation.AnimationUtils;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.players.gif.R;

public class Popup_welcome_NO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup_welcome__no);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        findViewById(R.id.popup).startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.size_up));
        new Thread(()->{try{
            Thread.sleep(1000);
            Intent i = new Intent();
            i.putExtra("result", "ERROR");
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
