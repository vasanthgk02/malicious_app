package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;
import java.util.Arrays;

public final class bq implements b {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String lM;
    public final /* synthetic */ String lP;
    public final /* synthetic */ String[] lS;

    public bq(String str, Context context, String str2, String[] strArr) {
        this.lM = str;
        this.iI = context;
        this.lP = str2;
        this.lS = strArr;
    }

    public Event gy() {
        a a2 = bg.a(EventName.FCEventFAQListOpen).a(Property.FCPropertyFAQCategoryName, this.lM);
        Category B = bg.A(this.iI, this.lP);
        if (B != null) {
            a2.a(Property.FCPropertyFAQCategoryID, B.getCategoryAlias());
        }
        if (as.f(this.lS)) {
            a2.a(Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return a2.gz();
    }
}
