package androidx.ads.identifier.internal;

import a.a.a.a.d.b;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import androidx.ads.identifier.AdvertisingIdNotAvailableException;
import androidx.ads.identifier.provider.IAdvertisingIdService;
import androidx.ads.identifier.provider.IAdvertisingIdService.Stub;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

public class HoldingConnectionClient {
    public final BlockingServiceConnection mConnection;
    public final Context mContext;
    public final IAdvertisingIdService mIdService;
    public final AtomicLong mLastConnectionId = new AtomicLong(0);
    public final String mPackageName;

    public class BlockingServiceConnection implements ServiceConnection {
        public final BlockingQueue<IBinder> mBlockingQueue = new LinkedBlockingQueue();

        public BlockingServiceConnection() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.mBlockingQueue.add(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            HoldingConnectionClient holdingConnectionClient = HoldingConnectionClient.this;
            if (holdingConnectionClient.mLastConnectionId.getAndSet(Long.MIN_VALUE) >= 0) {
                holdingConnectionClient.mContext.unbindService(holdingConnectionClient.mConnection);
            }
        }
    }

    public HoldingConnectionClient(Context context) throws AdvertisingIdNotAvailableException, IOException, TimeoutException, InterruptedException {
        this.mContext = context;
        PackageManager packageManager = context.getPackageManager();
        List<ServiceInfo> advertisingIdProviderServices = b.getAdvertisingIdProviderServices(packageManager);
        ServiceInfo serviceInfo = null;
        if (!advertisingIdProviderServices.isEmpty()) {
            PackageInfo packageInfo = null;
            for (ServiceInfo next : advertisingIdProviderServices) {
                try {
                    PackageInfo packageInfo2 = packageManager.getPackageInfo(next.packageName, 4096);
                    if (packageInfo != null) {
                        boolean isRequestHighPriority = b.isRequestHighPriority(packageInfo2);
                        if (isRequestHighPriority == b.isRequestHighPriority(packageInfo)) {
                            int i = (packageInfo2.firstInstallTime > packageInfo.firstInstallTime ? 1 : (packageInfo2.firstInstallTime == packageInfo.firstInstallTime ? 0 : -1));
                            isRequestHighPriority = i == 0 ? packageInfo2.packageName.compareTo(packageInfo.packageName) < 0 : i < 0;
                        }
                        if (!isRequestHighPriority) {
                        }
                    }
                    serviceInfo = next;
                    packageInfo = packageInfo2;
                } catch (NameNotFoundException unused) {
                }
            }
        }
        if (serviceInfo != null) {
            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
            Intent intent = new Intent("androidx.ads.identifier.provider.GET_AD_ID");
            intent.setComponent(componentName);
            BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
            if (this.mContext.bindService(intent, blockingServiceConnection, 1)) {
                this.mConnection = blockingServiceConnection;
                IBinder poll = blockingServiceConnection.mBlockingQueue.poll(10, TimeUnit.SECONDS);
                if (poll != null) {
                    this.mIdService = Stub.asInterface(poll);
                    this.mPackageName = componentName.getPackageName();
                    return;
                }
                throw new TimeoutException("Timed out waiting for the service connection");
            }
            throw new IOException("Connection failure");
        }
        throw new AdvertisingIdNotAvailableException("No compatible AndroidX Advertising ID Provider available.");
    }
}
