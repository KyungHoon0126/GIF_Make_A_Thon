package com.players.gif;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.players.gif.item.GroupItem;
import com.players.gif.view.GroupItemView;

import java.util.ArrayList;

public class GroupAdapter extends BaseAdapter {
    Context context;
    ArrayList<GroupItem> groupItems = new ArrayList<>();

    public GroupAdapter(Context context, ArrayList<GroupItem> items){
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
        if(view == null) view = new GroupItemView(context);
        ((GroupItemView)view).setName(groupItems.get(i).getGroupName());
        ((GroupItemView)view).setInside(groupItems.get(i).getGroupMembers() + "");
        return view;
    }

    public void add(){
        GroupItem item = new GroupItem();
        item.setGroupMembers(24);
        item.setGroupName("TEST");
        groupItems.add(item);
    }
}
