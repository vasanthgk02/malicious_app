package com.mpl.androidapp.miniprofile.extensions;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.razorpay.AnalyticsConstants;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0001¨\u0006\n"}, d2 = {"Lcom/mpl/androidapp/miniprofile/extensions/IntentData;", "", "()V", "putExtra", "", "intent", "Landroid/content/Intent;", "key", "", "value", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntentData.kt */
public final class IntentData {
    public static final IntentData INSTANCE = new IntentData();

    public final void putExtra(Intent intent, String str, Object obj) {
        Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(obj, HSLCriteriaBuilder.VALUE);
        if (obj instanceof Boolean) {
            intent.putExtra(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            intent.putExtra(str, ((Number) obj).byteValue());
        } else if (obj instanceof Character) {
            intent.putExtra(str, ((Character) obj).charValue());
        } else if (obj instanceof Short) {
            intent.putExtra(str, ((Number) obj).shortValue());
        } else if (obj instanceof Integer) {
            intent.putExtra(str, ((Number) obj).intValue());
        } else if (obj instanceof Long) {
            intent.putExtra(str, ((Number) obj).longValue());
        } else if (obj instanceof Float) {
            intent.putExtra(str, ((Number) obj).floatValue());
        } else if (obj instanceof Double) {
            intent.putExtra(str, ((Number) obj).doubleValue());
        } else if (obj instanceof String) {
            intent.putExtra(str, (String) obj);
        } else if (obj instanceof CharSequence) {
            intent.putExtra(str, (CharSequence) obj);
        } else if (obj instanceof Parcelable) {
            intent.putExtra(str, (Parcelable) obj);
        } else if (obj instanceof Serializable) {
            intent.putExtra(str, (Serializable) obj);
        } else if (obj instanceof boolean[]) {
            intent.putExtra(str, (boolean[]) obj);
        } else if (obj instanceof byte[]) {
            intent.putExtra(str, (byte[]) obj);
        } else if (obj instanceof short[]) {
            intent.putExtra(str, (short[]) obj);
        } else if (obj instanceof char[]) {
            intent.putExtra(str, (char[]) obj);
        } else if (obj instanceof long[]) {
            intent.putExtra(str, (long[]) obj);
        } else if (obj instanceof double[]) {
            intent.putExtra(str, (double[]) obj);
        } else if (obj instanceof float[]) {
            intent.putExtra(str, (float[]) obj);
        } else if (obj instanceof int[]) {
            intent.putExtra(str, (int[]) obj);
        } else if (obj instanceof Bundle) {
            intent.putExtra(str, (Bundle) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if ((!(objArr.length == 0)) && objArr[0] != null) {
                Object obj2 = objArr[0];
                if (obj2 instanceof Parcelable) {
                    intent.putExtra(str, (Parcelable[]) obj);
                } else if (obj2 instanceof CharSequence) {
                    intent.putExtra(str, (CharSequence[]) obj);
                } else if (obj2 instanceof String) {
                    intent.putExtra(str, (String[]) obj);
                }
            }
        }
    }
}
