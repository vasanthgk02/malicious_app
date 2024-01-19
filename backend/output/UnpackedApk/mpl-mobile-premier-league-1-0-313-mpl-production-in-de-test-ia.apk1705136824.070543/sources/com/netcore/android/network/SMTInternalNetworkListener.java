package com.netcore.android.network;

import com.netcore.android.network.models.SMTResponse;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/netcore/android/network/SMTInternalNetworkListener;", "", "Lcom/netcore/android/network/models/SMTResponse;", "smtResponse", "", "onRequestProcessComplete", "(Lcom/netcore/android/network/models/SMTResponse;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTInternalNetworkListener.kt */
public interface SMTInternalNetworkListener {
    void onRequestProcessComplete(SMTResponse sMTResponse);
}