package com.RNFetchBlob;

public class RNFetchBlobProgressConfig {
    public int count = -1;
    public boolean enable = false;
    public int interval = -1;
    public long lastTick = 0;
    public int tick = 0;

    public enum ReportType {
        Upload,
        Download
    }

    public RNFetchBlobProgressConfig(boolean z, int i, int i2, ReportType reportType) {
        ReportType reportType2 = ReportType.Download;
        this.enable = z;
        this.interval = i;
        this.count = i2;
    }

    public boolean shouldReport(float f2) {
        int i = this.count;
        boolean z = false;
        boolean z2 = i <= 0 || f2 <= 0.0f || Math.floor((double) (f2 * ((float) i))) > ((double) this.tick);
        if (System.currentTimeMillis() - this.lastTick > ((long) this.interval) && this.enable && z2) {
            z = true;
        }
        if (z) {
            this.tick++;
            this.lastTick = System.currentTimeMillis();
        }
        return z;
    }
}
