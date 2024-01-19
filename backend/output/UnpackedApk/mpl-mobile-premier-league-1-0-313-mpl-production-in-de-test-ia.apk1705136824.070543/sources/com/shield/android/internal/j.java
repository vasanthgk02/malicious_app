package com.shield.android.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.location.LocationManagerCompat$Api28Impl;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.Random;
import sfs2x.client.entities.invitation.InvitationReply;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f1681a = {-256, -65536, -16711681, -16776961, -16711936, -16777216};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f1682b = {"CarroisGothicSC-Regular.ttf", "ComingSoon.ttf", "CutiveMono.ttf", "DancingScript-Bold.ttf", "DancingScript-Regular.ttf", "DroidSans-Bold.ttf", "DroidSans.ttf", "DroidSansMono.ttf", "NotoSansGeorgian-Bold.otf", "NotoSansGeorgian-Medium.otf", "NotoSansGeorgian-Regular.otf", "Roboto-Black.ttf", "Roboto-BlackItalic.ttf", "Roboto-Bold.ttf", "Roboto-BoldItalic.ttf", "Roboto-Italic.ttf", "Roboto-Medium.ttf", "Roboto-MediumItalic.ttf", "Roboto-Regular.ttf", "RobotoCondensed-Medium.ttf", "RobotoCondensed-MediumItalic.ttf", "RobotoCondensed-Regular.ttf", "SourceSansPro-Bold.ttf", "SourceSansPro-BoldItalic.ttf", "SourceSansPro-Italic.ttf", "SourceSansPro-Regular.ttf", "SourceSansPro-SemiBold.ttf", "SourceSansPro-SemiBoldItalic.ttf"};

    public static boolean a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) || TextUtils.getTrimmedLength(charSequence) == 0;
    }

    public static boolean b(Context context) {
        try {
            Class.forName("com.google.android.gms.common.GoogleApiAvailability");
            Class.forName("com.google.android.gms.location.FusedLocationProviderClient");
            if (GoogleApiAvailability.zab.isGooglePlayServicesAvailable(context, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (VERSION.SDK_INT >= 28) {
                z = LocationManagerCompat$Api28Impl.isLocationEnabled(locationManager);
            } else {
                if (locationManager.isProviderEnabled("network") || locationManager.isProviderEnabled("gps")) {
                    z2 = true;
                }
                z = z2;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String e() {
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(new Random().nextInt(36)));
        }
        return sb.toString();
    }

    public static int f(Context context, String str) {
        try {
            return System.getInt(context.getContentResolver(), str);
        } catch (SettingNotFoundException unused) {
            return 0;
        }
    }

    public static String g(Context context, String str) {
        return System.getString(context.getContentResolver(), str);
    }

    public static boolean h(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean i(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static int a(Context context, String str) {
        try {
            return Global.getInt(context.getContentResolver(), str);
        } catch (SettingNotFoundException unused) {
            return 0;
        }
    }

    public static boolean a(int i) {
        return VERSION.SDK_INT >= i;
    }

    public static Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(200, 120, Config.ARGB_8888);
        createBitmap.eraseColor(-7829368);
        int width = createBitmap.getWidth();
        int height = createBitmap.getHeight();
        int[] iArr = new int[(width * height)];
        createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                if (random.nextInt(101) >= 60) {
                    int i3 = (i * width) + i2;
                    int nextInt = random.nextInt(InvitationReply.EXPIRED);
                    iArr[i3] = Color.rgb(nextInt, nextInt, nextInt) | iArr[i3];
                }
            }
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(width, height, createBitmap.getConfig());
        createBitmap2.setPixels(iArr, 0, width, 0, 0, width, height);
        new Canvas(createBitmap2).drawBitmap(createBitmap2, 0.0f, 0.0f, null);
        return createBitmap2;
    }

    public static Bitmap a(String str) {
        Bitmap a2 = a();
        Canvas canvas = new Canvas(a2);
        canvas.drawBitmap(a2, 0.0f, 0.0f, null);
        Paint paint = new Paint();
        for (int i = 0; i < str.toCharArray().length; i++) {
            char c2 = str.toCharArray()[i];
            int[] iArr = f1681a;
            paint.setColor(iArr[new Random().nextInt(iArr.length)]);
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("/system/fonts/");
                String[] strArr = f1682b;
                sb.append(strArr[new Random().nextInt(strArr.length)]);
                paint.setTypeface(Typeface.createFromFile(sb.toString()));
            } catch (Exception unused) {
            }
            paint.setTextSize((float) (new Random().nextInt(8) + 24));
            canvas.drawText(String.valueOf(c2), (float) ((i * 24) + 30), (float) ((new Random().nextInt(10) + 50) - 5), paint);
        }
        return a2;
    }

    public static Bitmap a(int i, int i2) {
        Bitmap a2 = a();
        Canvas canvas = new Canvas(a2);
        canvas.drawBitmap(a2, 0.0f, 0.0f, null);
        Paint paint = new Paint();
        paint.setColor(-16777216);
        paint.setTextSize(24.0f);
        canvas.drawText(i + " + " + i2 + " = ", 30.0f, 50.0f, paint);
        return a2;
    }
}
