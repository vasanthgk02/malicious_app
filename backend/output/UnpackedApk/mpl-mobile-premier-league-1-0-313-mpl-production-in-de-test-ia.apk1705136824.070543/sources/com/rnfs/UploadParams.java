package com.rnfs;

import com.facebook.react.bridge.ReadableMap;
import java.net.URL;
import java.util.ArrayList;

public class UploadParams {
    public boolean binaryStreamOnly;
    public ReadableMap fields;
    public ArrayList<ReadableMap> files;
    public ReadableMap headers;
    public String method;
    public onUploadBegin onUploadBegin;
    public onUploadComplete onUploadComplete;
    public onUploadProgress onUploadProgress;
    public URL src;

    public interface onUploadBegin {
    }

    public interface onUploadComplete {
    }

    public interface onUploadProgress {
    }
}
