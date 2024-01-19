package org.apache.fontbox.afm;

public class CompositePart {
    public String name;
    public int xDisplacement;
    public int yDisplacement;

    public String getName() {
        return this.name;
    }

    public int getXDisplacement() {
        return this.xDisplacement;
    }

    public int getYDisplacement() {
        return this.yDisplacement;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setXDisplacement(int i) {
        this.xDisplacement = i;
    }

    public void setYDisplacement(int i) {
        this.yDisplacement = i;
    }
}
