package com.players.gif.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.players.gif.GroupAdapter;
import com.players.gif.R;

import java.util.ArrayList;

public class GroupFragment extends Fragment {
    GroupAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.group_page, container, false);

        adapter = new GroupAdapter(v.getContext(), new ArrayList<>());
        GridView gridView = v.findViewById(R.id.post_scroll);
        gridView.setAdapter(adapter);
        for(int i = 0; i < 3; i++) adapter.add();
        return v;
    }
}
