package com.alin.recyclerview.data;

/**
 * Created by Alin on 11/12/2017.
 */

public class ListItem {

    private String dateAndTime;
    private String message;
    private int colorResources;

    public ListItem(String dateAndTime, String message, int colorResources){
        this.dateAndTime = dateAndTime;
        this.message = message;
        this.colorResources = colorResources;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getColorResources() {
        return colorResources;
    }

    public void setColorResources(int colorResources) {
        this.colorResources = colorResources;
    }
}
