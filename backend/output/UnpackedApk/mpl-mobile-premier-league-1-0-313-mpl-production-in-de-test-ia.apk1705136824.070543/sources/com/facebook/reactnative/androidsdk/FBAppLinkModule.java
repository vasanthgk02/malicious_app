package com.facebook.reactnative.androidsdk;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.facebook.applinks.AppLinkData.CompletionHandler;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "FBAppLink")
public class FBAppLinkModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBAppLink";
    public final ReactApplicationContext mReactContext;

    public FBAppLinkModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    private CompletionHandler createCompletionHandler(final Promise promise) {
        return new CompletionHandler(this) {
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                if (appLinkData == null) {
                    promise.resolve(null);
                } else {
                    promise.resolve(appLinkData.targetUri.toString());
                }
            }
        };
    }

    @ReactMethod
    public void fetchDeferredAppLink(Promise promise) {
        try {
            Context applicationContext = this.mReactContext.getApplicationContext();
            CompletionHandler createCompletionHandler = createCompletionHandler(promise);
            Validate.notNull(applicationContext, "context");
            Validate.notNull(createCompletionHandler, "completionHandler");
            String metadataApplicationId = Utility.getMetadataApplicationId(applicationContext);
            Validate.notNull(metadataApplicationId, "applicationId");
            FacebookSdk.getExecutor().execute(new Runnable(applicationContext.getApplicationContext(), metadataApplicationId, createCompletionHandler) {
                public final /* synthetic */ Context val$applicationContext;
                public final /* synthetic */ String val$applicationIdCopy;
                public final /* synthetic */ CompletionHandler val$completionHandler;

                {
                    this.val$applicationContext = r1;
                    this.val$applicationIdCopy = r2;
                    this.val$completionHandler = r3;
                }

                public void run() {
                    if (!CrashShieldHandler.isObjectCrashing(this)) {
                        try {
                            AppLinkData.fetchDeferredAppLinkFromServer(this.val$applicationContext, this.val$applicationIdCopy, this.val$completionHandler);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    }
                }
            });
        } catch (Exception e2) {
            promise.resolve(null);
            Utility.logd(getName(), "Received error while fetching deferred app link", e2);
        }
    }

    public String getName() {
        return NAME;
    }
}
