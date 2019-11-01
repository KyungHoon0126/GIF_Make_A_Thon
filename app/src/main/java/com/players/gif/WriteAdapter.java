package com.players.gif;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.players.gif.item.WriteItem;
import com.players.gif.view.GroupItemView;
import com.players.gif.view.WriteItemView;

import java.util.ArrayList;

public class WriteAdapter extends BaseAdapter {
    private ArrayList<WriteItem> items = new ArrayList<>();
    private Context context;
    public WriteAdapter(Context context, ArrayList<WriteItem> items){this.context=  context; this.items = items;}
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null) view = new WriteItemView(context);
        WriteItem item = items.get(i);
        WriteItemView v = (WriteItemView)view;
        v.setHowmuchseen(item.getHowmuchseen() + "");
        v.setInside(item.getInside());
        v.setTitle(item.getTitle());
        v.setUsername(item.getUsername());
        v.setWhen(item.getWhen());
        return view;
    }
    public void add(){
        WriteItem i = new WriteItem();
        i.setHowmuchseen(1);
        i.setImgName("Image");
        i.setInside("오늘 저녁 같이 먹으실 분 계신가요~");
        i.setTitle("저녁 드실분~");
        i.setUsername("사아람");
        i.setWhen("5분 전");
        items.add(i);
    }
}
