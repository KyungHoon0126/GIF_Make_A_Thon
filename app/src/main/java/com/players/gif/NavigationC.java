package com.players.gif;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.players.gif.DataManagers.UserInfo;
import com.players.gif.HttpManagers.HttpDataManager;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class NavigationC extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private Toolbar toolbar;

    public static final String GOOGLE_ACCOUNT = "google_account";
    private final String TAG = "[MainActivity]";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(()->{
            try {
                UserInfo info = UserInfo.getInstance();
                JSONObject object = new JSONObject();
                object.put("id", info.getEmail());
                object.put("password", "null");
                object.put("isGoogle", true);
                JSONObject obj = HttpDataManager.postData("http://danny-dataserver.kro.kr:8080/checkUser", object);
                info.setGoogle(true);
                JSONArray array = obj.get("groups").toString().equals("null") ? null : obj.getJSONArray("groups");
                Log.w("CURRENT : ", array.toString());
                ArrayList<Long> data = new ArrayList<>();
                if(array != null)
                    for(int i = 0; i < array.length(); i++) data.add(array.getLong(i));
                info.setGroups(data);
                info.setProfileImgName(obj.get("profileImgName").toString());
                info.setUsername(obj.getString("username"));
                Log.w(TAG, obj.getString("when"));
                Date date = new Date();
                date.setTime(obj.getLong("when"));
                info.setWhen(date);
                JSONArray arrayc = new JSONArray();
                ArrayList<Long> groups = UserInfo.getInstance().getGroups();
                if(groups != null) {
                    for (int i = 0; i < groups.size(); i++) arrayc.put(groups.get(i));
                    Log.w("DATA : ", arrayc.toString() + " / " + "{\"groups\":" + arrayc.toString() + "}");
                    try {
                        IMSIDATAS.Home = HttpDataManager.postDataARR("http://danny-dataserver.kro.kr:8080/getAllGroupOnUser", new JSONObject("{\"groups\":" + arrayc.toString() + "}"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
