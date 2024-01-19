package org.apache.fontbox.afm;

import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;

public class CharMetric {
    public BoundingBox boundingBox;
    public int characterCode;
    public List<Ligature> ligatures = new ArrayList();
    public String name;
    public float[] vv;
    public float[] w;
    public float[] w0;
    public float w0x;
    public float w0y;
    public float[] w1;
    public float w1x;
    public float w1y;
    public float wx;
    public float wy;

    public void addLigature(Ligature ligature) {
        this.ligatures.add(ligature);
    }

    public BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public int getCharacterCode() {
        return this.characterCode;
    }

    public List<Ligature> getLigatures() {
        return this.ligatures;
    }

    public String getName() {
        return this.name;
    }

    public float[] getVv() {
        return this.vv;
    }

    public float[] getW() {
        return this.w;
    }

    public float[] getW0() {
        return this.w0;
    }

    public float getW0x() {
        return this.w0x;
    }

    public float getW0y() {
        return this.w0y;
    }

    public float[] getW1() {
        return this.w1;
    }

    public float getW1x() {
        return this.w1x;
    }

    public float getW1y() {
        return this.w1y;
    }

    public float getWx() {
        return this.wx;
    }

    public float getWy() {
        return this.wy;
    }

    public void setBoundingBox(BoundingBox boundingBox2) {
        this.boundingBox = boundingBox2;
    }

    public void setCharacterCode(int i) {
        this.characterCode = i;
    }

    public void setLigatures(List<Ligature> list) {
        this.ligatures = list;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setVv(float[] fArr) {
        this.vv = fArr;
    }

    public void setW(float[] fArr) {
        this.w = fArr;
    }

    public void setW0(float[] fArr) {
        this.w0 = fArr;
    }

    public void setW0x(float f2) {
        this.w0x = f2;
    }

    public void setW0y(float f2) {
        this.w0y = f2;
    }

    public void setW1(float[] fArr) {
        this.w1 = fArr;
    }

    public void setW1x(float f2) {
        this.w1x = f2;
    }

    public void setW1y(float f2) {
        this.w1y = f2;
    }

    public void setWx(float f2) {
        this.wx = f2;
    }

    public void setWy(float f2) {
        this.wy = f2;
    }
}
