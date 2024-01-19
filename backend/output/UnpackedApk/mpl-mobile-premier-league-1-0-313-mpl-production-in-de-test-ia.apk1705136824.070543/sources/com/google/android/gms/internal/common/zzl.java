package com.google.android.gms.internal.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.pdfbox.filter.ASCII85InputStream;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzl extends zzk {
    public final char zza;

    public zzl(char c2) {
        this.zza = c2;
    }

    public final String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CharMatcher.is('");
        int i = this.zza;
        char[] cArr = {'\\', ASCII85InputStream.PADDING_U, 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        outline73.append(String.copyValueOf(cArr));
        outline73.append("')");
        return outline73.toString();
    }

    public final boolean zza(char c2) {
        return c2 == this.zza;
    }
}
