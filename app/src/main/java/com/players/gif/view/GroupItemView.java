package com.players.gif.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.players.gif.R;

public class GroupItemView extends LinearLayout {
    TextView name, inside;

    public GroupItemView(Context context) {
        super(context);
        init(context);
    }

    public GroupItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.groups, this, true);

        name = findViewById(R.id.group_name);
        inside = findViewById(R.id.group_members);

    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setInside(String inside) {
        this.inside.setText(inside);
    }
}