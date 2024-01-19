package org.apache.fontbox.afm;

public class TrackKern {
    public int degree;
    public float maxKern;
    public float maxPointSize;
    public float minKern;
    public float minPointSize;

    public int getDegree() {
        return this.degree;
    }

    public float getMaxKern() {
        return this.maxKern;
    }

    public float getMaxPointSize() {
        return this.maxPointSize;
    }

    public float getMinKern() {
        return this.minKern;
    }

    public float getMinPointSize() {
        return this.minPointSize;
    }

    public void setDegree(int i) {
        this.degree = i;
    }

    public void setMaxKern(float f2) {
        this.maxKern = f2;
    }

    public void setMaxPointSize(float f2) {
        this.maxPointSize = f2;
    }

    public void setMinKern(float f2) {
        this.minKern = f2;
    }

    public void setMinPointSize(float f2) {
        this.minPointSize = f2;
    }
}
