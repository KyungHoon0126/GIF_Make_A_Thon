package com.players.gif.DataManagers;

import android.app.Activity;
import android.os.Build;

import androidx.core.content.ContextCompat;

import com.players.gif.R;

public class Utils {
    public enum StatusBarColorType {
        LOGINSTATUS( R.color.colorLogin );

        private int backgroundColorId;

        StatusBarColorType(int backgroundColorId){
            this.backgroundColorId = backgroundColorId;
        }

        public int getBackgroundColorId() {
            return backgroundColorId;
        }
    }

    public static void setStatusBarColor(Activity activity, StatusBarColorType colorType) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, colorType.getBackgroundColorId()));
        }
    }
}