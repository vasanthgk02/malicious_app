package com.google.android.gms.internal.common;

import android.os.Build.VERSION;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class zzd {
    public static final int zza = (VERSION.SDK_INT >= 23 ? PDChoice.FLAG_COMMIT_ON_SEL_CHANGE : 0);
}
