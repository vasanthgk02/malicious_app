package com.yalantis.ucrop.model;

import android.graphics.Bitmap.CompressFormat;

public class CropParameters {
    public CompressFormat mCompressFormat;
    public int mCompressQuality;
    public ExifInfo mExifInfo;
    public String mImageInputPath;
    public String mImageOutputPath;
    public int mMaxResultImageSizeX;
    public int mMaxResultImageSizeY;

    public CropParameters(int i, int i2, CompressFormat compressFormat, int i3, String str, String str2, ExifInfo exifInfo) {
        this.mMaxResultImageSizeX = i;
        this.mMaxResultImageSizeY = i2;
        this.mCompressFormat = compressFormat;
        this.mCompressQuality = i3;
        this.mImageInputPath = str;
        this.mImageOutputPath = str2;
        this.mExifInfo = exifInfo;
    }
}
