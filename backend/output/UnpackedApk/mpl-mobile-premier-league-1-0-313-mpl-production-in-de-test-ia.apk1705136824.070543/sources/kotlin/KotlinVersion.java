package kotlin;

import com.netcore.android.notification.SMTNotificationConstants;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", "toString", "", "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KotlinVersion.kt */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    public static final KotlinVersion CURRENT = new KotlinVersion(1, 7, 20);
    public final int major;
    public final int minor;
    public final int patch;
    public final int version;

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public KotlinVersion(int r4, int r5, int r6) {
        /*
            r3 = this;
            r3.<init>()
            r3.major = r4
            r3.minor = r5
            r3.patch = r6
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            r1 = 0
            r2 = 255(0xff, float:3.57E-43)
            r0.<init>(r1, r2)
            boolean r0 = r0.contains(r4)
            if (r0 == 0) goto L_0x002e
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            r0.<init>(r1, r2)
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L_0x002e
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            r0.<init>(r1, r2)
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L_0x002e
            r1 = 1
        L_0x002e:
            if (r1 == 0) goto L_0x0039
            int r4 = r4 << 16
            int r5 = r5 << 8
            int r4 = r4 + r5
            int r4 = r4 + r6
            r3.version = r4
            return
        L_0x0039:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Version components are out of range: "
            r0.append(r1)
            r0.append(r4)
            r4 = 46
            r0.append(r4)
            r0.append(r5)
            r0.append(r4)
            r0.append(r6)
            java.lang.String r4 = r0.toString()
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.KotlinVersion.<init>(int, int, int):void");
    }

    public int compareTo(Object obj) {
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        Intrinsics.checkNotNullParameter(kotlinVersion, SMTNotificationConstants.NOTIF_ATTRIBUTION_OTHER);
        return this.version - kotlinVersion.version;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        KotlinVersion kotlinVersion = obj instanceof KotlinVersion ? (KotlinVersion) obj : null;
        if (kotlinVersion == null) {
            return false;
        }
        if (this.version != kotlinVersion.version) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.version;
    }

    public String toString() {
        return this.major + '.' + this.minor + '.' + this.patch;
    }
}
