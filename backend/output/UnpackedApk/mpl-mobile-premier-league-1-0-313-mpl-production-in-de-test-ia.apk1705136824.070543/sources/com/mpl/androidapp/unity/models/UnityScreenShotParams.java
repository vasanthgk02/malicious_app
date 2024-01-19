package com.mpl.androidapp.unity.models;

import android.app.Activity;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lcom/mpl/androidapp/unity/models/UnityScreenShotParams;", "", "screenName", "", "gameName", "activity", "Landroid/app/Activity;", "decorView", "Landroid/view/ViewGroup;", "isScreenshotUiDisabled", "", "isScreenShotOptions", "(Ljava/lang/String;Ljava/lang/String;Landroid/app/Activity;Landroid/view/ViewGroup;ZLjava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "getDecorView", "()Landroid/view/ViewGroup;", "getGameName", "()Ljava/lang/String;", "()Z", "getScreenName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnityScreenShotParams.kt */
public final class UnityScreenShotParams {
    public final Activity activity;
    public final ViewGroup decorView;
    public final String gameName;
    public final String isScreenShotOptions;
    public final boolean isScreenshotUiDisabled;
    public final String screenName;

    public UnityScreenShotParams(String str, String str2, Activity activity2, ViewGroup viewGroup, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "decorView");
        Intrinsics.checkNotNullParameter(str3, "isScreenShotOptions");
        this.screenName = str;
        this.gameName = str2;
        this.activity = activity2;
        this.decorView = viewGroup;
        this.isScreenshotUiDisabled = z;
        this.isScreenShotOptions = str3;
    }

    public static /* synthetic */ UnityScreenShotParams copy$default(UnityScreenShotParams unityScreenShotParams, String str, String str2, Activity activity2, ViewGroup viewGroup, boolean z, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unityScreenShotParams.screenName;
        }
        if ((i & 2) != 0) {
            str2 = unityScreenShotParams.gameName;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            activity2 = unityScreenShotParams.activity;
        }
        Activity activity3 = activity2;
        if ((i & 8) != 0) {
            viewGroup = unityScreenShotParams.decorView;
        }
        ViewGroup viewGroup2 = viewGroup;
        if ((i & 16) != 0) {
            z = unityScreenShotParams.isScreenshotUiDisabled;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str3 = unityScreenShotParams.isScreenShotOptions;
        }
        return unityScreenShotParams.copy(str, str4, activity3, viewGroup2, z2, str3);
    }

    public final String component1() {
        return this.screenName;
    }

    public final String component2() {
        return this.gameName;
    }

    public final Activity component3() {
        return this.activity;
    }

    public final ViewGroup component4() {
        return this.decorView;
    }

    public final boolean component5() {
        return this.isScreenshotUiDisabled;
    }

    public final String component6() {
        return this.isScreenShotOptions;
    }

    public final UnityScreenShotParams copy(String str, String str2, Activity activity2, ViewGroup viewGroup, boolean z, String str3) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(viewGroup, "decorView");
        Intrinsics.checkNotNullParameter(str3, "isScreenShotOptions");
        UnityScreenShotParams unityScreenShotParams = new UnityScreenShotParams(str, str2, activity2, viewGroup, z, str3);
        return unityScreenShotParams;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnityScreenShotParams)) {
            return false;
        }
        UnityScreenShotParams unityScreenShotParams = (UnityScreenShotParams) obj;
        return Intrinsics.areEqual(this.screenName, unityScreenShotParams.screenName) && Intrinsics.areEqual(this.gameName, unityScreenShotParams.gameName) && Intrinsics.areEqual(this.activity, unityScreenShotParams.activity) && Intrinsics.areEqual(this.decorView, unityScreenShotParams.decorView) && this.isScreenshotUiDisabled == unityScreenShotParams.isScreenshotUiDisabled && Intrinsics.areEqual(this.isScreenShotOptions, unityScreenShotParams.isScreenShotOptions);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final ViewGroup getDecorView() {
        return this.decorView;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.gameName, this.screenName.hashCode() * 31, 31);
        int hashCode = (this.decorView.hashCode() + ((this.activity.hashCode() + outline11) * 31)) * 31;
        boolean z = this.isScreenshotUiDisabled;
        if (z) {
            z = true;
        }
        return this.isScreenShotOptions.hashCode() + ((hashCode + (z ? 1 : 0)) * 31);
    }

    public final String isScreenShotOptions() {
        return this.isScreenShotOptions;
    }

    public final boolean isScreenshotUiDisabled() {
        return this.isScreenshotUiDisabled;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UnityScreenShotParams(screenName=");
        outline73.append(this.screenName);
        outline73.append(", gameName=");
        outline73.append(this.gameName);
        outline73.append(", activity=");
        outline73.append(this.activity);
        outline73.append(", decorView=");
        outline73.append(this.decorView);
        outline73.append(", isScreenshotUiDisabled=");
        outline73.append(this.isScreenshotUiDisabled);
        outline73.append(", isScreenShotOptions=");
        return GeneratedOutlineSupport.outline59(outline73, this.isScreenShotOptions, ')');
    }
}
