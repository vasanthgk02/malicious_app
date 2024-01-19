package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AppsFlyerProperties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class bf implements bg {
    public av AFInAppEventParameterName;
    public bh AFInAppEventType;
    public final be AFKeystoreWrapper = new be();
    public ab AFLogger$LogLevel;
    public by AFVersionDeclaration;
    public cl AppsFlyer2dXConversionCallback;
    public aa getLevel;
    public ai init;
    public de onAppOpenAttributionNative;
    public ca onInstallConversionDataLoadedNative;
    public l onInstallConversionFailureNative;
    public ExecutorService valueOf;
    public final int values = ((int) TimeUnit.SECONDS.toMillis(30));

    private synchronized ab onAppOpenAttributionNative() {
        if (this.AFLogger$LogLevel == null) {
            this.AFLogger$LogLevel = new ab(new bm(this.values), onDeepLinkingNative());
        }
        return this.AFLogger$LogLevel;
    }

    private synchronized be onAttributionFailureNative() {
        return this.AFKeystoreWrapper;
    }

    private synchronized ExecutorService onDeepLinkingNative() {
        if (this.valueOf == null) {
            this.valueOf = Executors.newCachedThreadPool();
        }
        return this.valueOf;
    }

    private synchronized bh onInstallConversionDataLoadedNative() {
        if (this.AFInAppEventType == null) {
            this.AFInAppEventType = new bh();
        }
        return this.AFInAppEventType;
    }

    private synchronized ai onInstallConversionFailureNative() {
        if (this.init == null) {
            new ThreadPoolExecutor(0, 4, 180, TimeUnit.SECONDS, new LinkedBlockingQueue());
            this.init = new ai(0);
        }
        return this.init;
    }

    public final bv AFInAppEventParameterName() {
        Context context = this.AFKeystoreWrapper.values;
        if (context != null) {
            return new bc(ac.AFInAppEventType(context));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    public final synchronized aa AFInAppEventType() {
        if (this.getLevel == null) {
            Context context = this.AFKeystoreWrapper.values;
            if (context != null) {
                this.getLevel = new aa(context);
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.getLevel;
    }

    public final synchronized av AFKeystoreWrapper() {
        if (this.AFInAppEventParameterName == null) {
            bh onInstallConversionDataLoadedNative2 = onInstallConversionDataLoadedNative();
            Context context = this.AFKeystoreWrapper.values;
            if (context != null) {
                av avVar = new av(onInstallConversionDataLoadedNative2, new bb(context), AFInAppEventParameterName(), onDeepLinkingNative(), new bd(onAppOpenAttributionNative(), AFInAppEventType(), AppsFlyerProperties.getInstance()));
                this.AFInAppEventParameterName = avVar;
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.AFInAppEventParameterName;
    }

    public final synchronized de AFLogger$LogLevel() {
        if (this.onAppOpenAttributionNative == null) {
            this.onAppOpenAttributionNative = new de();
        }
        return this.onAppOpenAttributionNative;
    }

    public final synchronized l AFVersionDeclaration() {
        if (this.onInstallConversionFailureNative == null) {
            this.onInstallConversionFailureNative = new l(onAttributionFailureNative());
        }
        return this.onInstallConversionFailureNative;
    }

    public final synchronized ak AppsFlyer2dXConversionCallback() {
        return ak.AFInAppEventType();
    }

    public final synchronized cl getLevel() {
        if (this.AppsFlyer2dXConversionCallback == null) {
            this.AppsFlyer2dXConversionCallback = new cl(AFInAppEventParameterName());
        }
        return this.AppsFlyer2dXConversionCallback;
    }

    public final synchronized ca init() {
        try {
            if (this.onInstallConversionDataLoadedNative == null) {
                this.onInstallConversionDataLoadedNative = new ca(onAttributionFailureNative());
            }
        }
        return this.onInstallConversionDataLoadedNative;
    }

    public final bd valueOf() {
        return new bd(onAppOpenAttributionNative(), AFInAppEventType(), AppsFlyerProperties.getInstance());
    }

    public final synchronized by values() {
        if (this.AFVersionDeclaration == null) {
            bx bxVar = new bx(AFInAppEventParameterName());
            by byVar = new by(new bw(), AFInAppEventType(), init(), bxVar, new bd(onAppOpenAttributionNative(), AFInAppEventType(), AppsFlyerProperties.getInstance()), new cb(AFInAppEventType(), bxVar), Executors.newSingleThreadExecutor(), onInstallConversionFailureNative());
            this.AFVersionDeclaration = byVar;
        }
        return this.AFVersionDeclaration;
    }
}
