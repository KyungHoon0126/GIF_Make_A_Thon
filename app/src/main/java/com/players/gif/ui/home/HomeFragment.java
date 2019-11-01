package com.players.gif.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.players.gif.DataManagers.UserInfo;
import com.players.gif.GroupAdapter;
import com.players.gif.HttpManagers.HttpDataManager;
import com.players.gif.IMSIDATAS;
import com.players.gif.R;
import com.players.gif.item.GroupItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {
    GroupAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ArrayList<GroupItem> groupItems = new ArrayList<>();

        for (int i = 0; i < IMSIDATAS.Home.length(); i++) {
            GroupItem item = new GroupItem();
            try{item.setGroupName(IMSIDATAS.Home.getJSONObject(i).getString("groupName"));
            item.setGroupMembers(IMSIDATAS.Home.getJSONObject(i).getJSONArray("peoples").length());}catch(Exception e){e.printStackTrace();}
            groupItems.add(item);
        }
        adapter = new GroupAdapter(getContext(), groupItems);
        GridView gridView = v.findViewById(R.id.post_scroll);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((c, i, e, d)->{
            try{
                IMSIDATAS.currentID = Integer.parseInt(IMSIDATAS.Home.getJSONObject(e).get("id").toString());}catch (Exception ec){ec.printStackTrace();}
            Navigation.findNavController(getView()).navigate(R.id.nav_share);
        });
        return v;
    }
}