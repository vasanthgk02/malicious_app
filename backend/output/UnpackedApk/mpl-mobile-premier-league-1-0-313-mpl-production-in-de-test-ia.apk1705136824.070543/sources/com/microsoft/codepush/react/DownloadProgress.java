package com.microsoft.codepush.react;

public class DownloadProgress {
    public long mReceivedBytes;
    public long mTotalBytes;

    public DownloadProgress(long j, long j2) {
        this.mTotalBytes = j;
        this.mReceivedBytes = j2;
    }
}
