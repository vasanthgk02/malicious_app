package org.apache.fontbox.afm;

public class KernPair {
    public String firstKernCharacter;
    public String secondKernCharacter;
    public float x;
    public float y;

    public String getFirstKernCharacter() {
        return this.firstKernCharacter;
    }

    public String getSecondKernCharacter() {
        return this.secondKernCharacter;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public void setFirstKernCharacter(String str) {
        this.firstKernCharacter = str;
    }

    public void setSecondKernCharacter(String str) {
        this.secondKernCharacter = str;
    }

    public void setX(float f2) {
        this.x = f2;
    }

    public void setY(float f2) {
        this.y = f2;
    }
}
