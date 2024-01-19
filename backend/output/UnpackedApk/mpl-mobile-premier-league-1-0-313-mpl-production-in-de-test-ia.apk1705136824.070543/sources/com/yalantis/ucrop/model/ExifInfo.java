package com.yalantis.ucrop.model;

public class ExifInfo {
    public int mExifDegrees;
    public int mExifOrientation;
    public int mExifTranslation;

    public ExifInfo(int i, int i2, int i3) {
        this.mExifOrientation = i;
        this.mExifDegrees = i2;
        this.mExifTranslation = i3;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || ExifInfo.class != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        if (this.mExifOrientation != exifInfo.mExifOrientation || this.mExifDegrees != exifInfo.mExifDegrees) {
            return false;
        }
        if (this.mExifTranslation != exifInfo.mExifTranslation) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((this.mExifOrientation * 31) + this.mExifDegrees) * 31) + this.mExifTranslation;
    }
}
