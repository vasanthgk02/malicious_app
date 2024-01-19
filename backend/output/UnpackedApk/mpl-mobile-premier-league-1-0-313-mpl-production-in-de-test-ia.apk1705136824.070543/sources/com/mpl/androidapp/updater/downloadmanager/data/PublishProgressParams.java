package com.mpl.androidapp.updater.downloadmanager.data;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/mpl/androidapp/updater/downloadmanager/data/PublishProgressParams;", "", "id", "", "progress", "isProgressComplete", "", "(IIZ)V", "getId", "()I", "setId", "(I)V", "()Z", "setProgressComplete", "(Z)V", "getProgress", "setProgress", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishProgressParams.kt */
public final class PublishProgressParams {
    public int id;
    public boolean isProgressComplete;
    public int progress;

    public PublishProgressParams(int i, int i2, boolean z) {
        this.id = i;
        this.progress = i2;
        this.isProgressComplete = z;
    }

    public static /* synthetic */ PublishProgressParams copy$default(PublishProgressParams publishProgressParams, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = publishProgressParams.id;
        }
        if ((i3 & 2) != 0) {
            i2 = publishProgressParams.progress;
        }
        if ((i3 & 4) != 0) {
            z = publishProgressParams.isProgressComplete;
        }
        return publishProgressParams.copy(i, i2, z);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.progress;
    }

    public final boolean component3() {
        return this.isProgressComplete;
    }

    public final PublishProgressParams copy(int i, int i2, boolean z) {
        return new PublishProgressParams(i, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishProgressParams)) {
            return false;
        }
        PublishProgressParams publishProgressParams = (PublishProgressParams) obj;
        return this.id == publishProgressParams.id && this.progress == publishProgressParams.progress && this.isProgressComplete == publishProgressParams.isProgressComplete;
    }

    public final int getId() {
        return this.id;
    }

    public final int getProgress() {
        return this.progress;
    }

    public int hashCode() {
        int i = ((this.id * 31) + this.progress) * 31;
        boolean z = this.isProgressComplete;
        if (z) {
            z = true;
        }
        return i + (z ? 1 : 0);
    }

    public final boolean isProgressComplete() {
        return this.isProgressComplete;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final void setProgressComplete(boolean z) {
        this.isProgressComplete = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PublishProgressParams(id=");
        outline73.append(this.id);
        outline73.append(", progress=");
        outline73.append(this.progress);
        outline73.append(", isProgressComplete=");
        return GeneratedOutlineSupport.outline65(outline73, this.isProgressComplete, ')');
    }
}
