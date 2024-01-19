package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;
import java.util.Arrays;

public final class bk implements b {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String lM;
    public final /* synthetic */ String lN;
    public final /* synthetic */ String lP;
    public final /* synthetic */ String lQ;
    public final /* synthetic */ String[] lS;

    public bk(String str, String str2, Context context, String str3, String str4, String[] strArr) {
        this.lN = str;
        this.lM = str2;
        this.iI = context;
        this.lP = str3;
        this.lQ = str4;
        this.lS = strArr;
    }

    public Event gy() {
        a a2 = bg.a(EventName.FCEventFAQOpen).a(Property.FCPropertyFAQTitle, this.lN).a(Property.FCPropertyFAQCategoryName, this.lM);
        Category B = bg.A(this.iI, this.lP);
        if (B != null) {
            a2.a(Property.FCPropertyFAQCategoryID, B.getCategoryAlias());
        }
        Article C = bg.z(this.iI, this.lQ);
        if (C != null) {
            a2.a(Property.FCPropertyFAQID, C.getArticleAlias());
        }
        if (as.f(this.lS)) {
            a2.a(Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return a2.gz();
    }
}