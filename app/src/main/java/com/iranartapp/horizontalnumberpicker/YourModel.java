package com.iranartapp.horizontalnumberpicker;

public class YourModel {

    private int temp;
    private String itemName;
    private boolean isSelected;

    public YourModel(int temp) {

        this.temp = temp;

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
