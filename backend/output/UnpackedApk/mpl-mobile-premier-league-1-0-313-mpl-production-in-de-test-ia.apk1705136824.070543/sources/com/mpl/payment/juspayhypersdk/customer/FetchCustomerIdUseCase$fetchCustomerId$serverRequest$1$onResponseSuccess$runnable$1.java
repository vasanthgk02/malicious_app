package com.mpl.payment.juspayhypersdk.customer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 2})
/* compiled from: FetchCustomerIdUseCase.kt */
public final class FetchCustomerIdUseCase$fetchCustomerId$serverRequest$1$onResponseSuccess$runnable$1 implements Runnable {
    public final /* synthetic */ String $response;
    public final /* synthetic */ FetchCustomerIdUseCase$fetchCustomerId$serverRequest$1 this$0;

    public FetchCustomerIdUseCase$fetchCustomerId$serverRequest$1$onResponseSuccess$runnable$1(FetchCustomerIdUseCase$fetchCustomerId$serverRequest$1 fetchCustomerIdUseCase$fetchCustomerId$serverRequest$1, String str) {
        this.this$0 = fetchCustomerIdUseCase$fetchCustomerId$serverRequest$1;
        this.$response = str;
    }

    public final void run() {
        try {
            FetchCustomerIdUseCase fetchCustomerIdUseCase = this.this$0.this$0;
            String str = this.$response;
            Intrinsics.checkNotNull(str);
            fetchCustomerIdUseCase.processResponse(str);
        } catch (Exception e2) {
            FetchCustomerIdUseCaseResultListener listener = this.this$0.this$0.getListener();
            if (listener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.this$0.this$0.getTAG());
                sb.append(' ');
                String message = e2.getMessage();
                if (message == null) {
                    message = "Exception when processing card charge Response";
                }
                sb.append(message);
                listener.onError(sb.toString());
            }
        }
    }
}
