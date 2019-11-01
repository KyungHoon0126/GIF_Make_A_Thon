package com.players.gif.item;

public class GroupItem {
    private String imgName;
    private String groupName;
    private int groupMembers;

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(int groupMembers) {
        this.groupMembers = groupMembers;
    }

    public GroupItem(){}
    public GroupItem(String imgName, int groupMembers, String groupName){
        this.imgName = imgName;
        this.groupMembers = groupMembers;
        this.groupName = groupName;
    }
}
