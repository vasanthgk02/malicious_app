package com.rnfs;

import com.facebook.react.bridge.ReadableMap;
import java.io.File;
import java.net.URL;

public class DownloadParams {
    public int connectionTimeout;
    public File dest;
    public ReadableMap headers;
    public OnDownloadBegin onDownloadBegin;
    public OnDownloadProgress onDownloadProgress;
    public OnTaskCompleted onTaskCompleted;
    public float progressDivider;
    public int progressInterval;
    public int readTimeout;
    public URL src;

    public interface OnDownloadBegin {
    }

    public interface OnDownloadProgress {
    }

    public interface OnTaskCompleted {
    }
}
