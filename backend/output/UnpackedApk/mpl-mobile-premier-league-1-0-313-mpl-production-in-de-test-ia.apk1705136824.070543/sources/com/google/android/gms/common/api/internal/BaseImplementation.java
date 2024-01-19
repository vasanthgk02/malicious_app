package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.AnyClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult.CallbackHandler;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public class BaseImplementation {

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public static abstract class ApiMethodImpl<R extends Result, A extends AnyClient> extends BasePendingResult<R> implements ResultHolder<R> {
        @KeepForSdk
        public final Api<?> mApi;
        @KeepForSdk
        public final AnyClientKey<A> mClientKey;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        @KeepForSdk
        @Deprecated
        public ApiMethodImpl(AnyClientKey<A> anyClientKey, GoogleApiClient googleApiClient) {
            // Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
            super(googleApiClient);
            Preconditions.checkNotNull(anyClientKey);
            this.mClientKey = anyClientKey;
            this.mApi = null;
        }

        @KeepForSdk
        private void setFailedResult(RemoteException remoteException) {
            setFailedResult(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @KeepForSdk
        public abstract void doExecute(A a2) throws RemoteException;

        @KeepForSdk
        public final Api<?> getApi() {
            return this.mApi;
        }

        @KeepForSdk
        public final AnyClientKey<A> getClientKey() {
            return this.mClientKey;
        }

        @KeepForSdk
        public void onSetFailedResult(R r) {
        }

        @KeepForSdk
        public final void run(A a2) throws DeadObjectException {
            try {
                doExecute(a2);
            } catch (DeadObjectException e2) {
                setFailedResult((RemoteException) e2);
                throw e2;
            } catch (RemoteException e3) {
                setFailedResult(e3);
            }
        }

        @KeepForSdk
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        @KeepForSdk
        public ApiMethodImpl(Api<?> api, GoogleApiClient googleApiClient) {
            // Preconditions.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
            super(googleApiClient);
            Preconditions.checkNotNull(api, "Api must not be null");
            this.mClientKey = api.zab;
            this.mApi = api;
        }

        @KeepForSdk
        public final void setFailedResult(Status status) {
            Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success");
            Result createFailedResult = createFailedResult(status);
            setResult(createFailedResult);
            onSetFailedResult(createFailedResult);
        }

        @KeepForSdk
        public ApiMethodImpl(CallbackHandler<R> callbackHandler) {
            super(callbackHandler);
            this.mClientKey = new AnyClientKey<>();
            this.mApi = null;
        }
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
    public interface ResultHolder<R> {
        @KeepForSdk
        void setResult(R r);
    }
}
