package com.players.gif.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.players.gif.R;

public class WriteItemView extends LinearLayout {
    TextView username, when, howmuchseen, title, inside;
    public WriteItemView(Context context) {
        super(context);
        init(context);
    }

    public WriteItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WriteItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public WriteItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.write_see_fragem, this, true);

        username = findViewById(R.id.username);
        when = findViewById(R.id.when);
        howmuchseen = findViewById(R.id.howmuchseen);
        title = findViewById(R.id.title);
        inside = findViewById(R.id.inside);
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public void setWhen(String when) {
        this.when.setText(when);
    }

    public void setHowmuchseen(String howmuchseen) {
        this.howmuchseen.setText(howmuchseen);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setInside(String inside) {
        this.inside.setText(inside);
    }
}
