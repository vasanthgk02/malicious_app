package com.netcore.android.smartechbase.communication;

import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JC\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022(\b\u0002\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/netcore/android/smartechbase/communication/SmartechInterface;", "", "", "eventName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventPayLoad", "", "trackEventFromHansel", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getUUID", "()Ljava/lang/String;", "fetchListAndSegment", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SmartechInterface.kt */
public interface SmartechInterface {
    void fetchListAndSegment();

    String getUUID();

    void trackEventFromHansel(String str, HashMap<String, Object> hashMap);
}
