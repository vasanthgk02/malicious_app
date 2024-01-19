package org.apache.fontbox.afm;

public class Ligature {
    public String ligature;
    public String successor;

    public String getLigature() {
        return this.ligature;
    }

    public String getSuccessor() {
        return this.successor;
    }

    public void setLigature(String str) {
        this.ligature = str;
    }

    public void setSuccessor(String str) {
        this.successor = str;
    }
}
