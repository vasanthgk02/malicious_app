package com.mpl.androidapp.miniprofile.kotlin.model.deeplink.share;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.onesignal.OneSingnalConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/ActionParams;", "", "actionPayload", "Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/ActionPayload;", "actionType", "", "(Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/ActionPayload;Ljava/lang/String;)V", "getActionPayload", "()Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/ActionPayload;", "setActionPayload", "(Lcom/mpl/androidapp/miniprofile/kotlin/model/deeplink/share/ActionPayload;)V", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionParams.kt */
public final class ActionParams {
    public ActionPayload actionPayload;
    public String actionType;

    public ActionParams() {
        this(null, null, 3, null);
    }

    public ActionParams(ActionPayload actionPayload2, String str) {
        Intrinsics.checkNotNullParameter(actionPayload2, OneSingnalConstant.PARAM_ACTION_PAYLOAD);
        Intrinsics.checkNotNullParameter(str, OneSingnalConstant.PARAM_ACTION_TYPE);
        this.actionPayload = actionPayload2;
        this.actionType = str;
    }

    public static /* synthetic */ ActionParams copy$default(ActionParams actionParams, ActionPayload actionPayload2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            actionPayload2 = actionParams.actionPayload;
        }
        if ((i & 2) != 0) {
            str = actionParams.actionType;
        }
        return actionParams.copy(actionPayload2, str);
    }

    public final ActionPayload component1() {
        return this.actionPayload;
    }

    public final String component2() {
        return this.actionType;
    }

    public final ActionParams copy(ActionPayload actionPayload2, String str) {
        Intrinsics.checkNotNullParameter(actionPayload2, OneSingnalConstant.PARAM_ACTION_PAYLOAD);
        Intrinsics.checkNotNullParameter(str, OneSingnalConstant.PARAM_ACTION_TYPE);
        return new ActionParams(actionPayload2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionParams)) {
            return false;
        }
        ActionParams actionParams = (ActionParams) obj;
        return Intrinsics.areEqual(this.actionPayload, actionParams.actionPayload) && Intrinsics.areEqual(this.actionType, actionParams.actionType);
    }

    public final ActionPayload getActionPayload() {
        return this.actionPayload;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public int hashCode() {
        return this.actionType.hashCode() + (this.actionPayload.hashCode() * 31);
    }

    public final void setActionPayload(ActionPayload actionPayload2) {
        Intrinsics.checkNotNullParameter(actionPayload2, "<set-?>");
        this.actionPayload = actionPayload2;
    }

    public final void setActionType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionType = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ActionParams(actionPayload=");
        outline73.append(this.actionPayload);
        outline73.append(", actionType=");
        return GeneratedOutlineSupport.outline59(outline73, this.actionType, ')');
    }

    public /* synthetic */ ActionParams(ActionPayload actionPayload2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ActionPayload(null, null, 3, null) : actionPayload2, (i & 2) != 0 ? "" : str);
    }
}
