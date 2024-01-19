package com.razorpay;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.webkit.JavascriptInterface;

public final class I$_e_ {
    public SharedPreferences R$$r_;
    public Editor a_$P$;

    public I$_e_(Context context) {
        this.R$$r_ = O__Y_.G__G_(context);
        this.a_$P$ = O__Y_.R$$r_(context);
    }

    @JavascriptInterface
    public final boolean getBoolean(String str) {
        try {
            return this.R$$r_.getBoolean(str, false);
        } catch (Exception unused) {
            return false;
        }
    }

    @JavascriptInterface
    public final float getFloat(String str) {
        try {
            return this.R$$r_.getFloat(str, 0.0f);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @JavascriptInterface
    public final int getInt(String str) {
        try {
            return this.R$$r_.getInt(str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    @JavascriptInterface
    public final String getString(String str) {
        try {
            return this.R$$r_.getString(str, null);
        } catch (Exception unused) {
            return null;
        }
    }

    @JavascriptInterface
    public final void setBoolean(String str, boolean z) {
        try {
            this.a_$P$.putBoolean(str, z);
            this.a_$P$.commit();
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public final void setFloat(String str, float f2) {
        try {
            this.a_$P$.putFloat(str, f2);
            this.a_$P$.commit();
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public final void setInt(String str, int i) {
        try {
            this.a_$P$.putInt(str, i);
            this.a_$P$.commit();
        } catch (Exception unused) {
        }
    }

    @JavascriptInterface
    public final void setString(String str, String str2) {
        try {
            this.a_$P$.putString(str, str2);
            this.a_$P$.commit();
        } catch (Exception unused) {
        }
    }
}
