package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/ChatDisclaimerConfig;", "", "showDisclaimer", "", "disclaimerHeader", "", "disclaimerBody", "(ZLjava/lang/String;Ljava/lang/String;)V", "getDisclaimerBody", "()Ljava/lang/String;", "getDisclaimerHeader", "getShowDisclaimer", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatDisclaimerConfig.kt */
public final class ChatDisclaimerConfig {
    public final String disclaimerBody;
    public final String disclaimerHeader;
    public final boolean showDisclaimer;

    public ChatDisclaimerConfig() {
        this(false, null, null, 7, null);
    }

    public ChatDisclaimerConfig(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "disclaimerHeader");
        Intrinsics.checkNotNullParameter(str2, "disclaimerBody");
        this.showDisclaimer = z;
        this.disclaimerHeader = str;
        this.disclaimerBody = str2;
    }

    public static /* synthetic */ ChatDisclaimerConfig copy$default(ChatDisclaimerConfig chatDisclaimerConfig, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = chatDisclaimerConfig.showDisclaimer;
        }
        if ((i & 2) != 0) {
            str = chatDisclaimerConfig.disclaimerHeader;
        }
        if ((i & 4) != 0) {
            str2 = chatDisclaimerConfig.disclaimerBody;
        }
        return chatDisclaimerConfig.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.showDisclaimer;
    }

    public final String component2() {
        return this.disclaimerHeader;
    }

    public final String component3() {
        return this.disclaimerBody;
    }

    public final ChatDisclaimerConfig copy(boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "disclaimerHeader");
        Intrinsics.checkNotNullParameter(str2, "disclaimerBody");
        return new ChatDisclaimerConfig(z, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatDisclaimerConfig)) {
            return false;
        }
        ChatDisclaimerConfig chatDisclaimerConfig = (ChatDisclaimerConfig) obj;
        return this.showDisclaimer == chatDisclaimerConfig.showDisclaimer && Intrinsics.areEqual(this.disclaimerHeader, chatDisclaimerConfig.disclaimerHeader) && Intrinsics.areEqual(this.disclaimerBody, chatDisclaimerConfig.disclaimerBody);
    }

    public final String getDisclaimerBody() {
        return this.disclaimerBody;
    }

    public final String getDisclaimerHeader() {
        return this.disclaimerHeader;
    }

    public final boolean getShowDisclaimer() {
        return this.showDisclaimer;
    }

    public int hashCode() {
        boolean z = this.showDisclaimer;
        if (z) {
            z = true;
        }
        return this.disclaimerBody.hashCode() + GeneratedOutlineSupport.outline11(this.disclaimerHeader, (z ? 1 : 0) * true, 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ChatDisclaimerConfig(showDisclaimer=");
        outline73.append(this.showDisclaimer);
        outline73.append(", disclaimerHeader=");
        outline73.append(this.disclaimerHeader);
        outline73.append(", disclaimerBody=");
        return GeneratedOutlineSupport.outline59(outline73, this.disclaimerBody, ')');
    }

    public /* synthetic */ ChatDisclaimerConfig(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? "Disclaimer" : str, (i & 4) != 0 ? "All livestreams including the chats are monitored constantly. Any content/comment that violates Terms of Use, Community Guidelines and/or applicable law including content/comment relating to pornography, indecency, dangerous, hate speech, slurs, harassment, frauds, defamatory, illegal gambling or any other criminal activity is prohibited and such content/comment shall entitle MPL to take suitable actions, including removal of such content and blocking of accounts. *Conditions Apply. Please refer to our Full Terms and Conditions, including our Community Guidelines on www.mpl.live & MPL App." : str2);
    }
}
