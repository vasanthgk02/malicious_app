package com.netcore.android.network;

import com.netcore.android.network.models.SMTRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/netcore/android/network/SMTNetworkManager;", "", "Lcom/netcore/android/network/models/SMTRequest;", "request", "", "processRequest", "(Lcom/netcore/android/network/models/SMTRequest;)V", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTNetworkManager.kt */
public class SMTNetworkManager {
    public static final Companion Companion = new Companion(null);
    public static volatile SMTNetworkManager INSTANCE;
    public static int MAX_RETRY_COUNT = 2;
    public static SMTRequestQueue smtRequestQueue;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/netcore/android/network/SMTNetworkManager$Companion;", "", "Lcom/netcore/android/network/SMTRequestQueue;", "smtRequestQueue", "Lcom/netcore/android/network/SMTNetworkManager;", "buildInstance", "(Lcom/netcore/android/network/SMTRequestQueue;)Lcom/netcore/android/network/SMTNetworkManager;", "getInstance", "", "MAX_RETRY_COUNT", "I", "getMAX_RETRY_COUNT", "()I", "setMAX_RETRY_COUNT", "(I)V", "Lcom/netcore/android/network/SMTRequestQueue;", "getSmtRequestQueue", "()Lcom/netcore/android/network/SMTRequestQueue;", "setSmtRequestQueue", "(Lcom/netcore/android/network/SMTRequestQueue;)V", "INSTANCE", "Lcom/netcore/android/network/SMTNetworkManager;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTNetworkManager.kt */
    public static final class Companion {
        public Companion() {
        }

        private final SMTNetworkManager buildInstance(SMTRequestQueue sMTRequestQueue) {
            setSmtRequestQueue(sMTRequestQueue);
            return new SMTNetworkManager(null);
        }

        public final SMTNetworkManager getInstance(SMTRequestQueue sMTRequestQueue) {
            SMTNetworkManager sMTNetworkManager;
            Intrinsics.checkNotNullParameter(sMTRequestQueue, "smtRequestQueue");
            SMTNetworkManager access$getINSTANCE$cp = SMTNetworkManager.INSTANCE;
            if (access$getINSTANCE$cp != null) {
                return access$getINSTANCE$cp;
            }
            synchronized (SMTNetworkManager.class) {
                try {
                    SMTNetworkManager access$getINSTANCE$cp2 = SMTNetworkManager.INSTANCE;
                    if (access$getINSTANCE$cp2 != null) {
                        sMTNetworkManager = access$getINSTANCE$cp2;
                    } else {
                        sMTNetworkManager = SMTNetworkManager.Companion.buildInstance(sMTRequestQueue);
                        SMTNetworkManager.INSTANCE = sMTNetworkManager;
                    }
                }
            }
            return sMTNetworkManager;
        }

        public final int getMAX_RETRY_COUNT() {
            return SMTNetworkManager.MAX_RETRY_COUNT;
        }

        public final SMTRequestQueue getSmtRequestQueue() {
            SMTRequestQueue access$getSmtRequestQueue$cp = SMTNetworkManager.smtRequestQueue;
            if (access$getSmtRequestQueue$cp != null) {
                return access$getSmtRequestQueue$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("smtRequestQueue");
            throw null;
        }

        public final void setMAX_RETRY_COUNT(int i) {
            SMTNetworkManager.MAX_RETRY_COUNT = i;
        }

        public final void setSmtRequestQueue(SMTRequestQueue sMTRequestQueue) {
            Intrinsics.checkNotNullParameter(sMTRequestQueue, "<set-?>");
            SMTNetworkManager.smtRequestQueue = sMTRequestQueue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SMTNetworkManager() {
    }

    public final void processRequest(SMTRequest sMTRequest) {
        Intrinsics.checkNotNullParameter(sMTRequest, "request");
        SMTRequestQueue sMTRequestQueue = smtRequestQueue;
        if (sMTRequestQueue != null) {
            sMTRequestQueue.addRequest(sMTRequest);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("smtRequestQueue");
            throw null;
        }
    }

    public /* synthetic */ SMTNetworkManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
