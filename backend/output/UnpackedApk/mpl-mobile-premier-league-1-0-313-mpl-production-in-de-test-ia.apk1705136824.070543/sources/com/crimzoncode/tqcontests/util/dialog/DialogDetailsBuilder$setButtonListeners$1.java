package com.crimzoncode.tqcontests.util.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AlertDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
/* compiled from: DialogDetailsBuilder.kt */
public final class DialogDetailsBuilder$setButtonListeners$1 implements OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ DialogDetailsBuilder this$0;

    public DialogDetailsBuilder$setButtonListeners$1(DialogDetailsBuilder dialogDetailsBuilder, AlertDialog alertDialog) {
        this.this$0 = dialogDetailsBuilder;
        this.$dialog = alertDialog;
    }

    public final void onClick(View view) {
        OnCustomDialogInteractionListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.performDialogAction(view);
            this.$dialog.dismiss();
            return;
        }
        Intrinsics.throwNpe();
        throw null;
    }
}
