package com.netcore.android.smartechbase.communication;

import android.app.Application;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ;\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\u000eJC\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0018\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\bH&¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/netcore/android/smartechbase/communication/HanselInterface;", "", "Landroid/app/Application;", "app", "Lcom/netcore/android/smartechbase/communication/SmartechInterface;", "smartechInterface", "", "deviceId", "", "init", "(Landroid/app/Application;Lcom/netcore/android/smartechbase/communication/SmartechInterface;Ljava/lang/String;)V", "hanselAppId", "hanselAppKey", "guid", "(Landroid/app/Application;Lcom/netcore/android/smartechbase/communication/SmartechInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "eventName", "vendorName", "Ljava/util/HashMap;", "properties", "logEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)Ljava/util/HashMap;", "", "lists", "segments", "setListAndSegmentsForUser", "(Ljava/util/List;Ljava/util/List;)V", "", "userAttributes", "setUserAttributes", "(Ljava/util/Map;)V", "userIdentity", "login", "(Ljava/lang/String;)V", "clearUserIdentity", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: HanselInterface.kt */
public interface HanselInterface {
    void clearUserIdentity();

    void init(Application application, SmartechInterface smartechInterface, String str);

    void init(Application application, SmartechInterface smartechInterface, String str, String str2, String str3);

    HashMap<String, Object> logEvent(String str, String str2, HashMap<String, Object> hashMap);

    void login(String str);

    void setListAndSegmentsForUser(List<String> list, List<String> list2);

    void setUserAttributes(Map<String, ? extends Object> map);
}
