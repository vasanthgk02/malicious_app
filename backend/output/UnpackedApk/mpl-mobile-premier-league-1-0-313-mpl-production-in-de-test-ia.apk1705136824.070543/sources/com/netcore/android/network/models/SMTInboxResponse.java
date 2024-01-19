package com.netcore.android.network.models;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR6\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/network/models/SMTInboxResponse;", "Lcom/netcore/android/network/models/SMTResponse;", "Ljava/util/ArrayList;", "Lcom/netcore/android/network/models/SMTInboxResponse$InboxResponse;", "Lkotlin/collections/ArrayList;", "inboxResponse", "Ljava/util/ArrayList;", "getInboxResponse", "()Ljava/util/ArrayList;", "setInboxResponse", "(Ljava/util/ArrayList;)V", "<init>", "()V", "InboxResponse", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTInboxResponse.kt */
public final class SMTInboxResponse extends SMTResponse {
    public ArrayList<InboxResponse> inboxResponse;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/netcore/android/network/models/SMTInboxResponse$InboxResponse;", "", "", "trid", "Ljava/lang/String;", "getTrid", "()Ljava/lang/String;", "setTrid", "(Ljava/lang/String;)V", "", "timeStamp", "J", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "status", "getStatus", "setStatus", "payload", "getPayload", "setPayload", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTInboxResponse.kt */
    public static final class InboxResponse {
        public String payload;
        public String status;
        public long timeStamp = -1;
        public String trid = "";

        public final String getPayload() {
            String str = this.payload;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("payload");
            throw null;
        }

        public final String getStatus() {
            String str = this.status;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("status");
            throw null;
        }

        public final long getTimeStamp() {
            return this.timeStamp;
        }

        public final String getTrid() {
            return this.trid;
        }

        public final void setPayload(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.payload = str;
        }

        public final void setStatus(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.status = str;
        }

        public final void setTimeStamp(long j) {
            this.timeStamp = j;
        }

        public final void setTrid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.trid = str;
        }
    }

    public final ArrayList<InboxResponse> getInboxResponse() {
        return this.inboxResponse;
    }

    public final void setInboxResponse(ArrayList<InboxResponse> arrayList) {
        this.inboxResponse = arrayList;
    }
}
