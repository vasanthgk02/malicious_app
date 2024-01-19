package com.crimzoncode.tqcontests.util.dialog;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import com.crimzoncode.tqcontests.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012Jj\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015Jx\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012J`\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¨\u0006\u0017"}, d2 = {"Lcom/crimzoncode/tqcontests/util/dialog/DialogUtils;", "", "()V", "showCustomPopup", "", "context", "Landroid/content/Context;", "iconId", "", "title", "", "description", "descriptionBig", "button", "secondaryButton", "cancelable", "", "onBtnClick", "Lkotlin/Function0;", "onSecondaryBtnClick", "listener", "Lcom/crimzoncode/tqcontests/util/dialog/OnCustomDialogInteractionListener;", "showErrorPopup", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DialogUtils.kt */
public final class DialogUtils {
    public static final DialogUtils INSTANCE = new DialogUtils();

    public static /* synthetic */ void showCustomPopup$default(DialogUtils dialogUtils, Context context, int i, String str, String str2, String str3, String str4, String str5, boolean z, OnCustomDialogInteractionListener onCustomDialogInteractionListener, int i2, Object obj) {
        int i3 = i2;
        dialogUtils.showCustomPopup(context, i, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? true : z, (i3 & 256) != 0 ? null : onCustomDialogInteractionListener);
    }

    public static /* synthetic */ void showErrorPopup$default(DialogUtils dialogUtils, Context context, String str, String str2, String str3, String str4, String str5, Function0 function0, boolean z, Function0 function02, int i, Object obj) {
        int i2 = i;
        Function0 function03 = null;
        String str6 = (i2 & 2) != 0 ? null : str;
        String str7 = (i2 & 4) != 0 ? null : str2;
        String str8 = (i2 & 8) != 0 ? null : str3;
        String str9 = (i2 & 16) != 0 ? null : str4;
        String str10 = (i2 & 32) != 0 ? null : str5;
        Function0 function04 = (i2 & 64) != 0 ? null : function0;
        boolean z2 = (i2 & 128) != 0 ? true : z;
        if ((i2 & 256) == 0) {
            function03 = function02;
        }
        dialogUtils.showErrorPopup(context, str6, str7, str8, str9, str10, function04, z2, function03);
    }

    public final void showCustomPopup(Context context, int i, String str, String str2, String str3, String str4, String str5, boolean z, OnCustomDialogInteractionListener onCustomDialogInteractionListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        DialogDetailsBuilder dialogBuilder = DialogDetailsBuilder.Companion.getDialogBuilder();
        dialogBuilder.setTitle(str).setDescriptionBig(str3).setDescriptionSmall(str2).setButtonText(str4).setSecondaryButtonText(str5).setCancelable(z).setIconRes(i).setListener(onCustomDialogInteractionListener);
        if (onCustomDialogInteractionListener == null) {
            dialogBuilder.setListener(new DialogUtils$showCustomPopup$1());
        }
        AlertDialog buildDialog = dialogBuilder.buildDialog(context);
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            buildDialog.show();
        }
    }

    public final void showErrorPopup(Context context, String str, String str2, String str3, String str4, String str5, Function0<? extends Object> function0, boolean z, Function0<? extends Object> function02) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        showErrorPopup(context, str, str2, str3, str4, str5, z, new DialogUtils$showErrorPopup$listener$1(function0, function02));
    }

    public static /* synthetic */ void showCustomPopup$default(DialogUtils dialogUtils, Context context, int i, String str, String str2, String str3, String str4, String str5, boolean z, Function0 function0, Function0 function02, int i2, Object obj) {
        int i3 = i2;
        dialogUtils.showCustomPopup(context, i, (i3 & 4) != 0 ? null : str, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? true : z, (i3 & 256) != 0 ? null : function0, (i3 & 512) != 0 ? null : function02);
    }

    public static /* synthetic */ void showErrorPopup$default(DialogUtils dialogUtils, Context context, String str, String str2, String str3, String str4, String str5, boolean z, OnCustomDialogInteractionListener onCustomDialogInteractionListener, int i, Object obj) {
        int i2 = i;
        OnCustomDialogInteractionListener onCustomDialogInteractionListener2 = null;
        String str6 = (i2 & 2) != 0 ? null : str;
        String str7 = (i2 & 4) != 0 ? null : str2;
        String str8 = (i2 & 8) != 0 ? null : str3;
        String str9 = (i2 & 16) != 0 ? null : str4;
        String str10 = (i2 & 32) != 0 ? null : str5;
        boolean z2 = (i2 & 64) != 0 ? true : z;
        if ((i2 & 128) == 0) {
            onCustomDialogInteractionListener2 = onCustomDialogInteractionListener;
        }
        dialogUtils.showErrorPopup(context, str6, str7, str8, str9, str10, z2, onCustomDialogInteractionListener2);
    }

    public final void showErrorPopup(Context context, String str, String str2, String str3, String str4, String str5, boolean z, OnCustomDialogInteractionListener onCustomDialogInteractionListener) {
        Context context2 = context;
        Intrinsics.checkParameterIsNotNull(context, "context");
        showCustomPopup(context, R.drawable.ic_dialog_error, str != null ? str : context.getString(R.string.default_error_title), str2, str3, str4, str5, z, onCustomDialogInteractionListener);
    }

    public final void showCustomPopup(Context context, int i, String str, String str2, String str3, String str4, String str5, boolean z, Function0<? extends Object> function0, Function0<? extends Object> function02) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        showCustomPopup(context, R.drawable.ic_dialog_error, str, str2, str3, str4, str5, z, new DialogUtils$showCustomPopup$listener$1(function0, function02));
    }
}
