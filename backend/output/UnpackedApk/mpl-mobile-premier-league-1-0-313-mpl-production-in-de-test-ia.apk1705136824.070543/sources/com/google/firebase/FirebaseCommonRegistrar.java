package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.platforminfo.$$Lambda$DefaultUserAgentPublisher$oc31ZRTT0106pFDkKe027FxHmLQ;
import com.google.firebase.platforminfo.LibraryVersion;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;

public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static /* synthetic */ String lambda$getComponents$0(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    public static /* synthetic */ String lambda$getComponents$1(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    public static /* synthetic */ String lambda$getComponents$2(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            return PDPrintFieldAttributeObject.ROLE_TV;
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            return "watch";
        }
        if (VERSION.SDK_INT < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return (VERSION.SDK_INT < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded";
        }
        return "auto";
    }

    public static /* synthetic */ String lambda$getComponents$3(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? safeValue(installerPackageName) : "";
    }

    public static String safeValue(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    public List<Component<?>> getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        Builder<UserAgentPublisher> builder = Component.builder(UserAgentPublisher.class);
        builder.add(new Dependency(LibraryVersion.class, 2, 0));
        builder.factory($$Lambda$DefaultUserAgentPublisher$oc31ZRTT0106pFDkKe027FxHmLQ.INSTANCE);
        arrayList.add(builder.build());
        arrayList.add(DefaultHeartBeatController.component());
        arrayList.add(TextAppearanceConfig.create("fire-android", String.valueOf(VERSION.SDK_INT)));
        arrayList.add(TextAppearanceConfig.create("fire-core", "20.1.0"));
        arrayList.add(TextAppearanceConfig.create("device-name", safeValue(Build.PRODUCT)));
        arrayList.add(TextAppearanceConfig.create("device-model", safeValue(Build.DEVICE)));
        arrayList.add(TextAppearanceConfig.create("device-brand", safeValue(Build.BRAND)));
        arrayList.add(TextAppearanceConfig.fromContext("android-target-sdk", $$Lambda$FirebaseCommonRegistrar$MJj2GWKO_yLkSyf6AZfNviARrgQ.INSTANCE));
        arrayList.add(TextAppearanceConfig.fromContext("android-min-sdk", $$Lambda$FirebaseCommonRegistrar$pGT1RcP4RapBpOq2V73IRqI1I.INSTANCE));
        arrayList.add(TextAppearanceConfig.fromContext("android-platform", $$Lambda$FirebaseCommonRegistrar$OMGxGzs72JnsFA__aYRvT3a3SZo.INSTANCE));
        arrayList.add(TextAppearanceConfig.fromContext("android-installer", $$Lambda$FirebaseCommonRegistrar$0SsttI_xA8sAI74ZXlgAQ_rvhA.INSTANCE));
        try {
            str = KotlinVersion.CURRENT.toString();
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(TextAppearanceConfig.create("kotlin", str));
        }
        return arrayList;
    }
}
