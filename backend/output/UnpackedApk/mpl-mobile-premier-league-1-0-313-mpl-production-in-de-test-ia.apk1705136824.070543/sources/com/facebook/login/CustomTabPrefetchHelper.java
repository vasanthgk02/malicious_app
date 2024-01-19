package com.facebook.login;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback.Stub;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsClient.AnonymousClass2;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "()V", "onCustomTabsServiceConnected", "", "name", "Landroid/content/ComponentName;", "newClient", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "componentName", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomTabPrefetchHelper.kt */
public final class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    public static final Companion Companion = new Companion(null);
    public static CustomTabsClient client;
    public static final ReentrantLock lock = new ReentrantLock();
    public static CustomTabsSession session;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper$Companion;", "", "()V", "client", "Landroidx/browser/customtabs/CustomTabsClient;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "session", "Landroidx/browser/customtabs/CustomTabsSession;", "getPreparedSessionOnce", "mayLaunchUrl", "", "url", "Landroid/net/Uri;", "prepareSession", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CustomTabPrefetchHelper.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void mayLaunchUrl(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            CustomTabsSession customTabsSession = CustomTabPrefetchHelper.session;
            if (customTabsSession != null) {
                Bundle bundle = new Bundle();
                PendingIntent pendingIntent = customTabsSession.mId;
                if (pendingIntent != null) {
                    bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
                }
                try {
                    customTabsSession.mService.mayLaunchUrl(customTabsSession.mCallback, uri, bundle, null);
                } catch (RemoteException unused) {
                }
            }
            CustomTabPrefetchHelper.lock.unlock();
        }

        public final void prepareSession() {
            CustomTabPrefetchHelper.lock.lock();
            if (CustomTabPrefetchHelper.session == null) {
                CustomTabsClient customTabsClient = CustomTabPrefetchHelper.client;
                if (customTabsClient != null) {
                    Companion companion = CustomTabPrefetchHelper.Companion;
                    CustomTabsSession customTabsSession = null;
                    AnonymousClass2 r1 = new Stub(customTabsClient, null) {
                        public Handler mHandler = new Handler(Looper.getMainLooper());
                        public final /* synthetic */ CustomTabsCallback val$callback;

                        {
                            this.val$callback = r2;
                        }

                        public void extraCallback(final String str, final Bundle bundle) throws RemoteException {
                            if (this.val$callback != null) {
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AnonymousClass2.this.val$callback.extraCallback(str, bundle);
                                    }
                                });
                            }
                        }

                        public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
                            CustomTabsCallback customTabsCallback = this.val$callback;
                            if (customTabsCallback == null) {
                                return null;
                            }
                            return customTabsCallback.extraCallbackWithResult(str, bundle);
                        }

                        public void onMessageChannelReady(final Bundle bundle) throws RemoteException {
                            if (this.val$callback != null) {
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AnonymousClass2.this.val$callback.onMessageChannelReady(bundle);
                                    }
                                });
                            }
                        }

                        public void onNavigationEvent(final int i, final Bundle bundle) {
                            if (this.val$callback != null) {
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AnonymousClass2.this.val$callback.onNavigationEvent(i, bundle);
                                    }
                                });
                            }
                        }

                        public void onPostMessage(final String str, final Bundle bundle) throws RemoteException {
                            if (this.val$callback != null) {
                                this.mHandler.post(new Runnable() {
                                    public void run() {
                                        AnonymousClass2.this.val$callback.onPostMessage(str, bundle);
                                    }
                                });
                            }
                        }

                        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
                            if (this.val$callback != null) {
                                Handler handler = this.mHandler;
                                final int i2 = i;
                                final Uri uri2 = uri;
                                final boolean z2 = z;
                                final Bundle bundle2 = bundle;
                                AnonymousClass5 r1 = new Runnable() {
                                    public void run() {
                                        AnonymousClass2.this.val$callback.onRelationshipValidationResult(i2, uri2, z2, bundle2);
                                    }
                                };
                                handler.post(r1);
                            }
                        }
                    };
                    try {
                        if (customTabsClient.mService.newSession(r1)) {
                            customTabsSession = new CustomTabsSession(customTabsClient.mService, r1, customTabsClient.mServiceComponentName, null);
                        }
                    } catch (RemoteException unused) {
                    }
                    CustomTabPrefetchHelper.session = customTabsSession;
                }
            }
            CustomTabPrefetchHelper.lock.unlock();
        }
    }

    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        Intrinsics.checkNotNullParameter(componentName, "name");
        Intrinsics.checkNotNullParameter(customTabsClient, "newClient");
        try {
            customTabsClient.mService.warmup(0);
        } catch (RemoteException unused) {
        }
        client = customTabsClient;
        lock.lock();
        if (session == null) {
            CustomTabsClient customTabsClient2 = client;
            if (customTabsClient2 != null) {
                CustomTabsSession customTabsSession = null;
                AnonymousClass2 r5 = new Stub(customTabsClient2, null) {
                    public Handler mHandler = new Handler(Looper.getMainLooper());
                    public final /* synthetic */ CustomTabsCallback val$callback;

                    {
                        this.val$callback = r2;
                    }

                    public void extraCallback(final String str, final Bundle bundle) throws RemoteException {
                        if (this.val$callback != null) {
                            this.mHandler.post(new Runnable() {
                                public void run() {
                                    AnonymousClass2.this.val$callback.extraCallback(str, bundle);
                                }
                            });
                        }
                    }

                    public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
                        CustomTabsCallback customTabsCallback = this.val$callback;
                        if (customTabsCallback == null) {
                            return null;
                        }
                        return customTabsCallback.extraCallbackWithResult(str, bundle);
                    }

                    public void onMessageChannelReady(final Bundle bundle) throws RemoteException {
                        if (this.val$callback != null) {
                            this.mHandler.post(new Runnable() {
                                public void run() {
                                    AnonymousClass2.this.val$callback.onMessageChannelReady(bundle);
                                }
                            });
                        }
                    }

                    public void onNavigationEvent(final int i, final Bundle bundle) {
                        if (this.val$callback != null) {
                            this.mHandler.post(new Runnable() {
                                public void run() {
                                    AnonymousClass2.this.val$callback.onNavigationEvent(i, bundle);
                                }
                            });
                        }
                    }

                    public void onPostMessage(final String str, final Bundle bundle) throws RemoteException {
                        if (this.val$callback != null) {
                            this.mHandler.post(new Runnable() {
                                public void run() {
                                    AnonymousClass2.this.val$callback.onPostMessage(str, bundle);
                                }
                            });
                        }
                    }

                    public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
                        if (this.val$callback != null) {
                            Handler handler = this.mHandler;
                            final int i2 = i;
                            final Uri uri2 = uri;
                            final boolean z2 = z;
                            final Bundle bundle2 = bundle;
                            AnonymousClass5 r1 = new Runnable() {
                                public void run() {
                                    AnonymousClass2.this.val$callback.onRelationshipValidationResult(i2, uri2, z2, bundle2);
                                }
                            };
                            handler.post(r1);
                        }
                    }
                };
                try {
                    if (customTabsClient2.mService.newSession(r5)) {
                        customTabsSession = new CustomTabsSession(customTabsClient2.mService, r5, customTabsClient2.mServiceComponentName, null);
                    }
                } catch (RemoteException unused2) {
                }
                session = customTabsSession;
            }
        }
        lock.unlock();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
    }
}
