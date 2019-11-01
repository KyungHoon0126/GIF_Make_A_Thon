package com.players.gif;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.players.gif.item.GroupItem;
import com.players.gif.item.SubtitleItem;
import com.players.gif.view.GroupItemView;
import com.players.gif.view.SubtitleItemView;

import java.util.ArrayList;

public class SubtitleAdapter extends BaseAdapter {
    Context context;
    ArrayList<SubtitleItem> groupItems;

    public SubtitleAdapter(Context context, ArrayList<SubtitleItem> items) {
        this.context = context;
        groupItems = items;
    }

    @Override
    public int getCount() {
        return groupItems.size();
    }

    @Override
    public Object getItem(int i) {
        return groupItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) view = new SubtitleItemView(context);
        ((SubtitleItemView) view).setName(groupItems.get(i).getUsername());
        ((SubtitleItemView) view).setInside(groupItems.get(i).getInsideWrite() + "");
        return view;
    }

    public void add() {
        SubtitleItem item = new SubtitleItem();
        item.setInsideWrite("SAG");
        item.setUsername("TEST");
        groupItems.add(item);
    }
}
