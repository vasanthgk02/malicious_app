package com.netcore.android.network;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.network.models.SMTRequest;
import com.netcore.android.network.models.SMTResponse;
import com.userexperior.models.recording.enums.UeCustomType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR2\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002`\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R2\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u0013j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002`\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R:\u0010\u001b\u001a&\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0013j\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a`\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u001e\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/netcore/android/network/SMTRequestQueue;", "Lcom/netcore/android/network/SMTInternalNetworkListener;", "Lcom/netcore/android/network/models/SMTRequest;", "request", "", "processRequest", "(Lcom/netcore/android/network/models/SMTRequest;)V", "removeRunningTaskFromList", "sendFailureState", "addRequest", "Lcom/netcore/android/network/models/SMTResponse;", "smtResponse", "onRequestProcessComplete", "(Lcom/netcore/android/network/models/SMTResponse;)V", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "mRequestQueue", "Ljava/util/LinkedHashMap;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mRequestProcessingQueue", "Ljava/util/HashMap;", "", "maxParallelRequests", "I", "Ljava/util/concurrent/Future;", "mRunningTaskList", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "Companion", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTRequestQueue.kt */
public class SMTRequestQueue implements SMTInternalNetworkListener {
    public static final Companion Companion = new Companion(null);
    public static volatile SMTRequestQueue INSTANCE;
    public final String TAG = SMTRequestQueue.class.getSimpleName();
    public HashMap<Long, SMTRequest> mRequestProcessingQueue = new HashMap<>();
    public LinkedHashMap<Long, SMTRequest> mRequestQueue = new LinkedHashMap<>();
    public HashMap<Long, Future<?>> mRunningTaskList = new HashMap<>();
    public final int maxParallelRequests = 5;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/netcore/android/network/SMTRequestQueue$Companion;", "", "Lcom/netcore/android/network/SMTRequestQueue;", "buildInstance", "()Lcom/netcore/android/network/SMTRequestQueue;", "getInstance", "INSTANCE", "Lcom/netcore/android/network/SMTRequestQueue;", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTRequestQueue.kt */
    public static final class Companion {
        public Companion() {
        }

        private final SMTRequestQueue buildInstance() {
            return new SMTRequestQueue();
        }

        public final SMTRequestQueue getInstance() {
            SMTRequestQueue access$getINSTANCE$cp = SMTRequestQueue.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                synchronized (this) {
                    try {
                        access$getINSTANCE$cp = SMTRequestQueue.INSTANCE;
                        if (access$getINSTANCE$cp == null) {
                            access$getINSTANCE$cp = SMTRequestQueue.Companion.buildInstance();
                            SMTRequestQueue.INSTANCE = access$getINSTANCE$cp;
                        }
                    }
                }
            }
            return access$getINSTANCE$cp;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void processRequest(SMTRequest sMTRequest) {
        this.mRequestProcessingQueue.put(Long.valueOf(sMTRequest.getRequestId$smartech_release()), sMTRequest);
        sMTRequest.setRetryCount$smartech_release(sMTRequest.getRetryCount$smartech_release() + 1);
        try {
            Future submit = SMTThreadPoolManager.INSTANCE.getIntance().submit(new SMTRequestProcessor(sMTRequest, this));
            Intrinsics.checkNotNullExpressionValue(submit, "SMTThreadPoolManager.get…Processor(request, this))");
            SMTLogger sMTLogger = SMTLogger.INSTANCE;
            String str = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str, UeCustomType.TAG);
            sMTLogger.internal(str, "URL: " + sMTRequest.getBaseUrl$smartech_release() + sMTRequest.getApiEndPoint$smartech_release());
            String str2 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str2, UeCustomType.TAG);
            sMTLogger.internal(str2, "RequestID: " + sMTRequest.getRequestId$smartech_release());
            String str3 = this.TAG;
            Intrinsics.checkNotNullExpressionValue(str3, UeCustomType.TAG);
            sMTLogger.internal(str3, "RequestHParams: " + sMTRequest.getHParams$smartech_release());
            this.mRunningTaskList.put(Long.valueOf(sMTRequest.getRequestId$smartech_release()), submit);
        } catch (Exception e2) {
            SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Request failure : ");
            outline73.append(e2.getLocalizedMessage());
            sMTLogger2.e("Request", outline73.toString());
            sendFailureState(sMTRequest);
        }
    }

    private final void removeRunningTaskFromList(SMTRequest sMTRequest) {
        HashMap<Long, Future<?>> hashMap = this.mRunningTaskList;
        Long valueOf = sMTRequest != null ? Long.valueOf(sMTRequest.getRequestId$smartech_release()) : null;
        if (hashMap != null) {
            TypeIntrinsics.asMutableMap(hashMap).remove(valueOf);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    private final void sendFailureState(SMTRequest sMTRequest) {
        SMTResponse sMTResponse = new SMTResponse();
        sMTResponse.setRequestId(sMTRequest.getRequestId$smartech_release());
        sMTResponse.setHttpCode(Integer.valueOf(400));
        sMTResponse.setSuccess(false);
        sMTResponse.setShouldRetry(true);
        sMTResponse.setSmtApiTypeID(sMTRequest.getAPITypeID$smartech_release());
        onRequestProcessComplete(sMTResponse);
    }

    public final void addRequest(SMTRequest sMTRequest) {
        Intrinsics.checkNotNullParameter(sMTRequest, "request");
        if (this.mRequestProcessingQueue.size() < this.maxParallelRequests) {
            this.mRequestQueue.remove(Long.valueOf(sMTRequest.getRequestId$smartech_release()));
            processRequest(sMTRequest);
            return;
        }
        this.mRequestQueue.put(Long.valueOf(sMTRequest.getRequestId$smartech_release()), sMTRequest);
        SMTLogger sMTLogger = SMTLogger.INSTANCE;
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Queue size : ");
        outline73.append(this.mRequestQueue.size());
        sMTLogger.v("Queue", outline73.toString());
    }

    public void onRequestProcessComplete(SMTResponse sMTResponse) {
        Intrinsics.checkNotNullParameter(sMTResponse, "smtResponse");
        SMTRequest sMTRequest = this.mRequestProcessingQueue.get(Long.valueOf(sMTResponse.getRequestId()));
        if (sMTRequest != null) {
            SMTResponseListener responseListener$smartech_release = sMTRequest.getResponseListener$smartech_release();
            SMTRequest sMTRequest2 = this.mRequestProcessingQueue.get(Long.valueOf(sMTResponse.getRequestId()));
            if (sMTRequest2 != null) {
                SMTRequest sMTRequest3 = sMTRequest2;
                removeRunningTaskFromList(this.mRequestProcessingQueue.get(Long.valueOf(sMTResponse.getRequestId())));
                this.mRequestProcessingQueue.remove(Long.valueOf(sMTResponse.getRequestId()));
                SMTLogger sMTLogger = SMTLogger.INSTANCE;
                String str = this.TAG;
                StringBuilder outline79 = GeneratedOutlineSupport.outline79(str, UeCustomType.TAG, "Event response : ");
                outline79.append(sMTResponse.getHttpCode());
                sMTLogger.internal(str, outline79.toString());
                if (sMTResponse.getShouldRetry()) {
                    if (sMTRequest3.getRetryCount$smartech_release() < SMTNetworkManager.Companion.getMAX_RETRY_COUNT()) {
                        processRequest(sMTRequest3);
                        return;
                    } else if (responseListener$smartech_release != null) {
                        responseListener$smartech_release.onResponseFailure(sMTResponse);
                    }
                } else if (sMTResponse.isSuccess()) {
                    Integer httpCode = sMTResponse.getHttpCode();
                    if (httpCode != null && httpCode.intValue() == 200) {
                        if (responseListener$smartech_release != null) {
                            responseListener$smartech_release.onResponseSuccess(sMTResponse);
                        }
                        String str2 = this.TAG;
                        StringBuilder outline792 = GeneratedOutlineSupport.outline79(str2, UeCustomType.TAG, "Event request id : ");
                        outline792.append(sMTRequest3.getRequestId$smartech_release());
                        outline792.append(" :  ");
                        outline792.append(sMTResponse.isSuccess());
                        sMTLogger.internal(str2, outline792.toString());
                    } else {
                        if (responseListener$smartech_release != null) {
                            responseListener$smartech_release.onResponseFailure(sMTResponse);
                        }
                        String str3 = this.TAG;
                        StringBuilder outline793 = GeneratedOutlineSupport.outline79(str3, UeCustomType.TAG, "Event request id : ");
                        outline793.append(sMTRequest3.getRequestId$smartech_release());
                        outline793.append(" :  ");
                        outline793.append(sMTResponse.isSuccess());
                        sMTLogger.internal(str3, outline793.toString());
                    }
                }
                if (this.mRequestQueue.size() != 0) {
                    Long next = this.mRequestQueue.keySet().iterator().next();
                    Intrinsics.checkNotNullExpressionValue(next, "mRequestQueue.keys.iterator().next()");
                    long longValue = next.longValue();
                    SMTRequest sMTRequest4 = this.mRequestQueue.get(Long.valueOf(longValue));
                    if (sMTRequest4 != null) {
                        processRequest(sMTRequest4);
                        this.mRequestQueue.remove(Long.valueOf(longValue));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.network.models.SMTRequest");
                    }
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.network.models.SMTRequest");
        }
        throw new NullPointerException("null cannot be cast to non-null type com.netcore.android.network.models.SMTRequest");
    }
}
