package com.squareup.picasso;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StatsSnapshot {
    public final long averageDownloadSize;
    public final long averageOriginalBitmapSize;
    public final long averageTransformedBitmapSize;
    public final long cacheHits;
    public final long cacheMisses;
    public final int downloadCount;
    public final int maxSize;
    public final int originalBitmapCount;
    public final int size;
    public final long timeStamp;
    public final long totalDownloadSize;
    public final long totalOriginalBitmapSize;
    public final long totalTransformedBitmapSize;
    public final int transformedBitmapCount;

    public StatsSnapshot(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.maxSize = i;
        this.size = i2;
        this.cacheHits = j;
        this.cacheMisses = j2;
        this.totalDownloadSize = j3;
        this.totalOriginalBitmapSize = j4;
        this.totalTransformedBitmapSize = j5;
        this.averageDownloadSize = j6;
        this.averageOriginalBitmapSize = j7;
        this.averageTransformedBitmapSize = j8;
        this.downloadCount = i3;
        this.originalBitmapCount = i4;
        this.transformedBitmapCount = i5;
        this.timeStamp = j9;
    }

    public void dump() {
        StringWriter stringWriter = new StringWriter();
        dump(new PrintWriter(stringWriter));
        stringWriter.toString();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("StatsSnapshot{maxSize=");
        outline73.append(this.maxSize);
        outline73.append(", size=");
        outline73.append(this.size);
        outline73.append(", cacheHits=");
        outline73.append(this.cacheHits);
        outline73.append(", cacheMisses=");
        outline73.append(this.cacheMisses);
        outline73.append(", downloadCount=");
        outline73.append(this.downloadCount);
        outline73.append(", totalDownloadSize=");
        outline73.append(this.totalDownloadSize);
        outline73.append(", averageDownloadSize=");
        outline73.append(this.averageDownloadSize);
        outline73.append(", totalOriginalBitmapSize=");
        outline73.append(this.totalOriginalBitmapSize);
        outline73.append(", totalTransformedBitmapSize=");
        outline73.append(this.totalTransformedBitmapSize);
        outline73.append(", averageOriginalBitmapSize=");
        outline73.append(this.averageOriginalBitmapSize);
        outline73.append(", averageTransformedBitmapSize=");
        outline73.append(this.averageTransformedBitmapSize);
        outline73.append(", originalBitmapCount=");
        outline73.append(this.originalBitmapCount);
        outline73.append(", transformedBitmapCount=");
        outline73.append(this.transformedBitmapCount);
        outline73.append(", timeStamp=");
        outline73.append(this.timeStamp);
        outline73.append('}');
        return outline73.toString();
    }

    public void dump(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.maxSize);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.size);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.size) / ((float) this.maxSize)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.cacheHits);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.cacheMisses);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.downloadCount);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.totalDownloadSize);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.averageDownloadSize);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.originalBitmapCount);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.totalOriginalBitmapSize);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.transformedBitmapCount);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.totalTransformedBitmapSize);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.averageOriginalBitmapSize);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.averageTransformedBitmapSize);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }
}
