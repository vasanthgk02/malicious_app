package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;

public final class bh implements b {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String lM;
    public final /* synthetic */ String lN;
    public final /* synthetic */ String lP;
    public final /* synthetic */ String lQ;
    public final /* synthetic */ boolean ro;

    public bh(String str, String str2, boolean z, Context context, String str3, String str4) {
        this.lM = str;
        this.lN = str2;
        this.ro = z;
        this.iI = context;
        this.lP = str3;
        this.lQ = str4;
    }

    public Event gy() {
        a a2 = bg.a(EventName.FCEventFAQVote).a(Property.FCPropertyFAQCategoryName, this.lM).a(Property.FCPropertyFAQTitle, this.lN).a(Property.FCPropertyIsHelpful, Boolean.valueOf(this.ro));
        Category B = bg.A(this.iI, this.lP);
        if (B != null) {
            a2.a(Property.FCPropertyFAQCategoryID, B.getCategoryAlias());
        }
        Article C = bg.z(this.iI, this.lQ);
        if (C != null) {
            a2.a(Property.FCPropertyFAQID, C.getArticleAlias());
        }
        return a2.gz();
    }
}
