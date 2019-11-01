package com.players.gif.item;

public class WriteItem {
    String username;
    String imgName;
    String when;
    int howmuchseen;
    String title;
    String inside;

    public WriteItem(){}

    public WriteItem(String username, String imgName, String when, int howmuchseen, String title, String inside) {
        this.username = username;
        this.imgName = imgName;
        this.when = when;
        this.howmuchseen = howmuchseen;
        this.title = title;
        this.inside = inside;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public int getHowmuchseen() {
        return howmuchseen;
    }

    public void setHowmuchseen(int howmuchseen) {
        this.howmuchseen = howmuchseen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInside() {
        return inside;
    }

    public void setInside(String inside) {
        this.inside = inside;
    }
}
