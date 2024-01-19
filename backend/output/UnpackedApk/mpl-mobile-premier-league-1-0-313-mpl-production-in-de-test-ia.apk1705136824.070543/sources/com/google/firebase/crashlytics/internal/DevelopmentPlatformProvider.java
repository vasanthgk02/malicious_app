package com.google.firebase.crashlytics.internal;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;

public class DevelopmentPlatformProvider {
    public static final String FLUTTER_ASSETS_PATH = "flutter_assets";
    public static final String FLUTTER_PLATFORM = "Flutter";
    public static final String UNITY_PLATFORM = "Unity";
    public static final String UNITY_VERSION_FIELD = "com.google.firebase.crashlytics.unity_version";
    public final Context context;
    public DevelopmentPlatform developmentPlatform = null;

    public class DevelopmentPlatform {
        public final String developmentPlatform;
        public final String developmentPlatformVersion;

        public DevelopmentPlatform() {
            int resourcesIdentifier = CommonUtils.getResourcesIdentifier(DevelopmentPlatformProvider.this.context, DevelopmentPlatformProvider.UNITY_VERSION_FIELD, NetworkingModule.REQUEST_BODY_KEY_STRING);
            if (resourcesIdentifier != 0) {
                this.developmentPlatform = DevelopmentPlatformProvider.UNITY_PLATFORM;
                this.developmentPlatformVersion = DevelopmentPlatformProvider.this.context.getResources().getString(resourcesIdentifier);
                Logger logger = Logger.getLogger();
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unity Editor version is: ");
                outline73.append(this.developmentPlatformVersion);
                logger.v(outline73.toString());
            } else if (DevelopmentPlatformProvider.this.assetPathExists(DevelopmentPlatformProvider.FLUTTER_ASSETS_PATH)) {
                this.developmentPlatform = DevelopmentPlatformProvider.FLUTTER_PLATFORM;
                this.developmentPlatformVersion = null;
                Logger.getLogger().v("Development platform is: Flutter");
            } else {
                this.developmentPlatform = null;
                this.developmentPlatformVersion = null;
            }
        }
    }

    public DevelopmentPlatformProvider(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public boolean assetPathExists(String str) {
        boolean z = false;
        try {
            if (this.context.getAssets() == null) {
                return false;
            }
            String[] list = this.context.getAssets().list(str);
            if (list != null && list.length > 0) {
                z = true;
            }
            return z;
        } catch (IOException unused) {
        }
    }

    private DevelopmentPlatform initDevelopmentPlatform() {
        if (this.developmentPlatform == null) {
            this.developmentPlatform = new DevelopmentPlatform();
        }
        return this.developmentPlatform;
    }

    public static boolean isUnity(Context context2) {
        return CommonUtils.getResourcesIdentifier(context2, UNITY_VERSION_FIELD, NetworkingModule.REQUEST_BODY_KEY_STRING) != 0;
    }

    public String getDevelopmentPlatform() {
        return initDevelopmentPlatform().developmentPlatform;
    }

    public String getDevelopmentPlatformVersion() {
        return initDevelopmentPlatform().developmentPlatformVersion;
    }
}
