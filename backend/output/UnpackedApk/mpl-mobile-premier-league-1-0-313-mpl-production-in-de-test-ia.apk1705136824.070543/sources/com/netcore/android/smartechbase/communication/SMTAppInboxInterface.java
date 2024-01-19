package com.netcore.android.smartechbase.communication;

import android.content.Context;
import com.netcore.android.inbox.SMTAppInboxData;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/netcore/android/smartechbase/communication/SMTAppInboxInterface;", "", "Landroid/content/Context;", "context", "Lcom/netcore/android/inbox/SMTAppInboxData;", "smtAppInboxData", "", "init", "(Landroid/content/Context;Lcom/netcore/android/inbox/SMTAppInboxData;)V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTAppInboxInterface.kt */
public interface SMTAppInboxInterface {
    void init(Context context, SMTAppInboxData sMTAppInboxData);
}
