package com.idology.idscan.check;

import java.util.HashMap;
import java.util.Map;

public class IdImageCheckResult {
    public boolean barcodeLocated;
    public Map<Border, Boolean> borderTooSmall;
    public int cornersLocated = 0;
    public int documentHeight;
    public int documentWidth;
    public boolean faceLocated = false;
    public boolean imageError = false;
    public int imageHeight;
    public int imageWidth;
    public double maxCornerAngle;

    public enum Border {
        Top,
        Right,
        Bottom,
        Left
    }

    public IdImageCheckResult(String str) {
        HashMap hashMap = new HashMap();
        this.borderTooSmall = hashMap;
        this.maxCornerAngle = 0.0d;
        this.imageHeight = 0;
        this.imageWidth = 0;
        this.documentHeight = 0;
        this.documentWidth = 0;
        this.barcodeLocated = false;
        hashMap.put(Border.Top, Boolean.FALSE);
        this.borderTooSmall.put(Border.Right, Boolean.FALSE);
        this.borderTooSmall.put(Border.Bottom, Boolean.FALSE);
        this.borderTooSmall.put(Border.Left, Boolean.FALSE);
    }

    public boolean isBorderTooSmall(Border border) {
        return this.borderTooSmall.get(border).booleanValue();
    }
}
