package com.players.gif.ui.send;

import android.os.Bundle;
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

import com.players.gif.R;
import com.players.gif.SubtitleAdapter;
import com.players.gif.item.SubtitleItem;

import java.util.ArrayList;

public class SendFragment extends Fragment {

    SubtitleAdapter subtitleAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        subtitleAdapter = new SubtitleAdapter(getContext(), new ArrayList<>());
        GridView gridView = root.findViewById(R.id.subtitles);
        gridView.setAdapter(subtitleAdapter);
        for(int i = 0; i < 10; i++) subtitleAdapter.add();
        gridView.setOnItemClickListener((c,s,b,n)->{
            Log.w("OK", "OK");
        });
        return root;
    }
}