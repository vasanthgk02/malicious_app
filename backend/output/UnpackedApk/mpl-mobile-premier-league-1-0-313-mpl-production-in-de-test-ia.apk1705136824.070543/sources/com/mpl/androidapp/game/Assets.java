package com.mpl.androidapp.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Assets implements Serializable, Parcelable {
    public static final Creator<Assets> CREATOR = new Creator<Assets>() {
        public Assets createFromParcel(Parcel parcel) {
            return new Assets(parcel);
        }

        public Assets[] newArray(int i) {
            return new Assets[i];
        }
    };
    public static final long serialVersionUID = -7479715403941870415L;
    @SerializedName("images")
    @Expose
    public List<String> images = new ArrayList();
    @SerializedName("preview")
    @Expose
    public String preview;
    @SerializedName("previewVideo")
    @Expose
    public String previewVideo;
    @SerializedName("thumb")
    @Expose
    public String thumb;

    public Assets(Parcel parcel) {
        Class<String> cls = String.class;
        this.thumb = (String) parcel.readValue(cls.getClassLoader());
        this.preview = (String) parcel.readValue(cls.getClassLoader());
        parcel.readList(this.images, cls.getClassLoader());
        this.previewVideo = (String) parcel.readValue(cls.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public List<String> getImages() {
        return this.images;
    }

    public String getPreview() {
        return this.preview;
    }

    public String getPreviewVideo() {
        return this.previewVideo;
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setImages(List<String> list) {
        this.images = list;
    }

    public void setPreview(String str) {
        this.preview = str;
    }

    public void setPreviewVideo(String str) {
        this.previewVideo = str;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.thumb);
        parcel.writeValue(this.preview);
        parcel.writeList(this.images);
        parcel.writeValue(this.previewVideo);
    }

    public Assets() {
    }
}
