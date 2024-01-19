package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/BufferConfig;", "", "minBufferMs", "", "maxBufferMs", "bufferForPlaybackMs", "bufferForPlaybackAfterRebufferMs", "(IIII)V", "getBufferForPlaybackAfterRebufferMs", "()I", "getBufferForPlaybackMs", "getMaxBufferMs", "getMinBufferMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferConfig.kt */
public final class BufferConfig {
    public final int bufferForPlaybackAfterRebufferMs;
    public final int bufferForPlaybackMs;
    public final int maxBufferMs;
    public final int minBufferMs;

    public BufferConfig(int i, int i2, int i3, int i4) {
        this.minBufferMs = i;
        this.maxBufferMs = i2;
        this.bufferForPlaybackMs = i3;
        this.bufferForPlaybackAfterRebufferMs = i4;
    }

    public static /* synthetic */ BufferConfig copy$default(BufferConfig bufferConfig, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = bufferConfig.minBufferMs;
        }
        if ((i5 & 2) != 0) {
            i2 = bufferConfig.maxBufferMs;
        }
        if ((i5 & 4) != 0) {
            i3 = bufferConfig.bufferForPlaybackMs;
        }
        if ((i5 & 8) != 0) {
            i4 = bufferConfig.bufferForPlaybackAfterRebufferMs;
        }
        return bufferConfig.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.minBufferMs;
    }

    public final int component2() {
        return this.maxBufferMs;
    }

    public final int component3() {
        return this.bufferForPlaybackMs;
    }

    public final int component4() {
        return this.bufferForPlaybackAfterRebufferMs;
    }

    public final BufferConfig copy(int i, int i2, int i3, int i4) {
        return new BufferConfig(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BufferConfig)) {
            return false;
        }
        BufferConfig bufferConfig = (BufferConfig) obj;
        return this.minBufferMs == bufferConfig.minBufferMs && this.maxBufferMs == bufferConfig.maxBufferMs && this.bufferForPlaybackMs == bufferConfig.bufferForPlaybackMs && this.bufferForPlaybackAfterRebufferMs == bufferConfig.bufferForPlaybackAfterRebufferMs;
    }

    public final int getBufferForPlaybackAfterRebufferMs() {
        return this.bufferForPlaybackAfterRebufferMs;
    }

    public final int getBufferForPlaybackMs() {
        return this.bufferForPlaybackMs;
    }

    public final int getMaxBufferMs() {
        return this.maxBufferMs;
    }

    public final int getMinBufferMs() {
        return this.minBufferMs;
    }

    public int hashCode() {
        return (((((this.minBufferMs * 31) + this.maxBufferMs) * 31) + this.bufferForPlaybackMs) * 31) + this.bufferForPlaybackAfterRebufferMs;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BufferConfig(minBufferMs=");
        outline73.append(this.minBufferMs);
        outline73.append(", maxBufferMs=");
        outline73.append(this.maxBufferMs);
        outline73.append(", bufferForPlaybackMs=");
        outline73.append(this.bufferForPlaybackMs);
        outline73.append(", bufferForPlaybackAfterRebufferMs=");
        return GeneratedOutlineSupport.outline56(outline73, this.bufferForPlaybackAfterRebufferMs, ')');
    }
}
