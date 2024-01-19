package androidx.ads.identifier;

import a.a.a.a.d.b;
import android.content.Context;
import android.os.RemoteException;
import androidx.ads.identifier.internal.HoldingConnectionClient;
import androidx.ads.identifier.provider.IAdvertisingIdService;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class AdvertisingIdClient {
    public static final ExecutorService QUERY_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    public static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();
    public static final AtomicReference<HoldingConnectionClient> sConnectionClient = new AtomicReference<>(null);
    public static final Object sLock = new Object();

    /* renamed from: androidx.ads.identifier.AdvertisingIdClient$1  reason: invalid class name */
    public static class AnonymousClass1 {
    }

    public static abstract class ConnectionPair {
    }

    public static ListenableFuture<AdvertisingIdInfo> getAdvertisingIdInfo(Context context) {
        final Context applicationContext = context.getApplicationContext();
        final CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = new CallbackToFutureAdapter$Completer();
        CallbackToFutureAdapter$SafeFuture<T> callbackToFutureAdapter$SafeFuture = new CallbackToFutureAdapter$SafeFuture<>(callbackToFutureAdapter$Completer);
        callbackToFutureAdapter$Completer.future = callbackToFutureAdapter$SafeFuture;
        callbackToFutureAdapter$Completer.tag = AnonymousClass1.class;
        try {
            final Future<?> submit = QUERY_EXECUTOR_SERVICE.submit(new Runnable() {
                public void run() {
                    try {
                        ConnectionPair connection = AdvertisingIdClient.getConnection(applicationContext);
                        AdvertisingIdClient.scheduleAutoDisconnect(connection);
                        callbackToFutureAdapter$Completer.set(AdvertisingIdClient.getIdInfo(((AutoValue_AdvertisingIdClient_ConnectionPair) connection).connectionClient));
                    } catch (AdvertisingIdNotAvailableException | IOException | InterruptedException | TimeoutException e2) {
                        callbackToFutureAdapter$Completer.setException(e2);
                    }
                }
            });
            SCHEDULED_EXECUTOR_SERVICE.schedule(new Runnable() {
                public void run() {
                    if (!submit.isDone()) {
                        callbackToFutureAdapter$Completer.setException(new TimeoutException());
                        submit.cancel(true);
                    }
                }
            }, 20, TimeUnit.SECONDS);
            callbackToFutureAdapter$Completer.tag = "getAdvertisingIdInfo";
        } catch (Exception e2) {
            callbackToFutureAdapter$SafeFuture.delegate.setException(e2);
        }
        return callbackToFutureAdapter$SafeFuture;
    }

    public static ConnectionPair getConnection(Context context) throws IOException, AdvertisingIdNotAvailableException, TimeoutException, InterruptedException {
        ConnectionPair tryConnect = tryConnect();
        if (tryConnect == null) {
            synchronized (sLock) {
                tryConnect = tryConnect();
                if (tryConnect == null) {
                    HoldingConnectionClient holdingConnectionClient = new HoldingConnectionClient(context);
                    sConnectionClient.set(holdingConnectionClient);
                    tryConnect = new AutoValue_AdvertisingIdClient_ConnectionPair(holdingConnectionClient, 0);
                }
            }
        }
        return tryConnect;
    }

    public static AdvertisingIdInfo getIdInfo(HoldingConnectionClient holdingConnectionClient) throws IOException, AdvertisingIdNotAvailableException {
        IAdvertisingIdService iAdvertisingIdService = holdingConnectionClient.mIdService;
        try {
            String id = iAdvertisingIdService.getId();
            if (id == null || id.trim().isEmpty()) {
                throw new AdvertisingIdNotAvailableException("Advertising ID Provider does not returns an Advertising ID.");
            }
            String str = holdingConnectionClient.mPackageName;
            if (str != null) {
                Boolean valueOf = Boolean.valueOf(iAdvertisingIdService.isLimitAdTrackingEnabled());
                String str2 = "";
                if (valueOf == null) {
                    str2 = str2 + " limitAdTrackingEnabled";
                }
                if (str2.isEmpty()) {
                    return new AutoValue_AdvertisingIdInfo(id, str, valueOf.booleanValue(), null);
                }
                throw new IllegalStateException("Missing required properties:" + str2);
            }
            throw new NullPointerException("Null providerPackageName");
        } catch (RemoteException e2) {
            throw new IOException("Remote exception", e2);
        } catch (RuntimeException e3) {
            throw new AdvertisingIdNotAvailableException("Advertising ID Provider throws a exception.", e3);
        }
    }

    public static boolean isAdvertisingIdProviderAvailable(Context context) {
        return !b.getAdvertisingIdProviderServices(context.getPackageManager()).isEmpty();
    }

    public static void scheduleAutoDisconnect(final ConnectionPair connectionPair) {
        SCHEDULED_EXECUTOR_SERVICE.schedule(new Runnable() {
            public void run() {
                AutoValue_AdvertisingIdClient_ConnectionPair autoValue_AdvertisingIdClient_ConnectionPair = (AutoValue_AdvertisingIdClient_ConnectionPair) connectionPair;
                HoldingConnectionClient holdingConnectionClient = autoValue_AdvertisingIdClient_ConnectionPair.connectionClient;
                boolean z = true;
                if (holdingConnectionClient.mLastConnectionId.compareAndSet(autoValue_AdvertisingIdClient_ConnectionPair.connectionId, Long.MIN_VALUE)) {
                    holdingConnectionClient.mContext.unbindService(holdingConnectionClient.mConnection);
                } else {
                    z = true ^ (holdingConnectionClient.mLastConnectionId.get() >= 0);
                }
                if (z) {
                    AdvertisingIdClient.sConnectionClient.compareAndSet(holdingConnectionClient, null);
                }
            }
        }, 30, TimeUnit.SECONDS);
    }

    public static ConnectionPair tryConnect() {
        HoldingConnectionClient holdingConnectionClient = sConnectionClient.get();
        if (holdingConnectionClient != null) {
            long incrementAndGet = holdingConnectionClient.mLastConnectionId.incrementAndGet();
            if (incrementAndGet >= 0) {
                return new AutoValue_AdvertisingIdClient_ConnectionPair(holdingConnectionClient, incrementAndGet);
            }
        }
        return null;
    }
}
