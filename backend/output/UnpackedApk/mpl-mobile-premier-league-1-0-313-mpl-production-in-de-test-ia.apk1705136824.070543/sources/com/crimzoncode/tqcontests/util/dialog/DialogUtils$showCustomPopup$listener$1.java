package com.crimzoncode.tqcontests.util.dialog;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/crimzoncode/tqcontests/util/dialog/DialogUtils$showCustomPopup$listener$1", "Lcom/crimzoncode/tqcontests/util/dialog/OnCustomDialogInteractionListener;", "performDialogAction", "", "view", "Landroid/view/View;", "performDialogSecondaryAction", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DialogUtils.kt */
public final class DialogUtils$showCustomPopup$listener$1 implements OnCustomDialogInteractionListener {
    public final /* synthetic */ Function0 $onBtnClick;
    public final /* synthetic */ Function0 $onSecondaryBtnClick;

    public DialogUtils$showCustomPopup$listener$1(Function0 function0, Function0 function02) {
        this.$onBtnClick = function0;
        this.$onSecondaryBtnClick = function02;
    }

    public void performDialogAction(View view) {
        Function0 function0 = this.$onBtnClick;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void performDialogSecondaryAction(View view) {
        Function0 function0 = this.$onSecondaryBtnClick;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
