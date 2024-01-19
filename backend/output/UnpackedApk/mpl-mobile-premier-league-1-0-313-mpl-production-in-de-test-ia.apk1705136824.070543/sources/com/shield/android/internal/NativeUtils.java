package com.shield.android.internal;

import android.content.Context;

public class NativeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1666a;

    public NativeUtils(Context context) {
        try {
            System.loadLibrary("cashshieldabc-native-lib");
            f1666a = true;
        } catch (UnsatisfiedLinkError e2) {
            f1666a = false;
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        } catch (Exception e3) {
            f1666a = false;
            if (f.a().f1677b && e3.getMessage() != null) {
                e3.getLocalizedMessage();
            }
        }
    }

    public boolean a() {
        if (f1666a) {
            return true;
        }
        try {
            System.loadLibrary("cashshieldabc-native-lib");
            f1666a = true;
        } catch (UnsatisfiedLinkError e2) {
            f1666a = false;
            if (f.a().f1677b && e2.getMessage() != null) {
                e2.getLocalizedMessage();
            }
        } catch (Exception e3) {
            f1666a = false;
            if (f.a().f1677b && e3.getMessage() != null) {
                e3.getLocalizedMessage();
            }
        }
        return f1666a;
    }

    public native int getArpCache(int i);

    public native String getKeyFormat();

    public native String getPayloadFormat();

    public native String getPayloadTransformation();

    public native String getPb();

    public native boolean isAccessedSuperuserApk();

    public native boolean isDetectedDevKeys();

    public native boolean isDetectedTestKeys();

    public native boolean isFoundBusyboxBinary();

    public native boolean isFoundDangerousProps();

    public native boolean isFoundMagisk();

    public native boolean isFoundResetprop();

    public native boolean isFoundSuBinary();

    public native boolean isFoundSubstrate();

    public native boolean isFoundWrongPathPermission();

    public native boolean isFoundXposed();

    public native boolean isFoundZygote();

    public native boolean isFridaDetected();

    public native boolean isNotFoundReleaseKeys();

    public native boolean isPermissiveSelinux();

    public native boolean isSandHookDetected();

    public native boolean isSuExists();

    public native boolean isTaichiDetected();

    public native boolean isVirtualAndroidDetected();

    public native boolean isVirtualXposedDetected();

    public native boolean isZygiskDetected();

    public native boolean listenForFrida();
}
