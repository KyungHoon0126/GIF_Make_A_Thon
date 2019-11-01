package com.players.gif.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.players.gif.HttpManagers.HttpDataManager;
import com.players.gif.IMSIDATAS;
import com.players.gif.New_Login_Register_Request.NewMainActivity;
import com.players.gif.R;
import com.players.gif.WriteAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShareFragment extends Fragment {

    WriteAdapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        adapter = new WriteAdapter(getContext(), new ArrayList<>());
        GridView v = ((GridView)root.findViewById(R.id.shareid));try {
        ((TextView) root.findViewById(R.id.title)).setText(IMSIDATAS.Home.getJSONObject(IMSIDATAS.currentID-1).getString("groupName"));
            ((TextView)root.findViewById(R.id.members)).setText("멤버 " + IMSIDATAS.Home.getJSONObject(IMSIDATAS.currentID-1).getJSONArray("peoples").length() + "명");

            Handler h = new Handler();
            new Thread(()->{
                JSONObject data = new JSONObject();
                try {
                    data.put("id", IMSIDATAS.Home.getJSONObject(IMSIDATAS.currentID-1).getLong("groupPlayerID"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    JSONObject obj = HttpDataManager.postData("http://localhost:8080/getUserNameWithID", data);
                    h.post(()-> {
                        try {
                            ((TextView)root.findViewById(R.id.username)).setText(obj.getString("username"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }catch(Exception e){e.printStackTrace();}
        v.setAdapter(adapter);adapter.add();
        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Navigation.findNavController(getView()).navigate(R.id.nav_send);
            }
        });
        return root;
    }

}