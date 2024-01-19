package androidx.core.view.inputmethod;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.appcompat.widget.AppCompatReceiveContentHelper$1;
import androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatApi25Impl;

public class InputConnectionCompat$1 extends InputConnectionWrapper {
    public final /* synthetic */ InputConnectionCompat$OnCommitContentListener val$listener;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InputConnectionCompat$1(InputConnection inputConnection, boolean z, InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener) {
        // this.val$listener = inputConnectionCompat$OnCommitContentListener;
        super(inputConnection, z);
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener = this.val$listener;
        InputContentInfoCompat inputContentInfoCompat = null;
        if (inputContentInfo != null && VERSION.SDK_INT >= 25) {
            inputContentInfoCompat = new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(inputContentInfo));
        }
        if (((AppCompatReceiveContentHelper$1) inputConnectionCompat$OnCommitContentListener).onCommitContent(inputContentInfoCompat, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
