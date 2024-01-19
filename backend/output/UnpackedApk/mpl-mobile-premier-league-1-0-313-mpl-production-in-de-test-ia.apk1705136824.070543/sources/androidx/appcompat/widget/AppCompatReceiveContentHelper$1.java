package androidx.appcompat.widget;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ContentInfoCompat.Builder;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public class AppCompatReceiveContentHelper$1 implements InputConnectionCompat$OnCommitContentListener {
    public final /* synthetic */ View val$view;

    public AppCompatReceiveContentHelper$1(View view) {
        this.val$view = view;
    }

    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        boolean z = false;
        if (VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                inputContentInfoCompat.mImpl.requestPermission();
                InputContentInfo inputContentInfo = (InputContentInfo) inputContentInfoCompat.mImpl.getInputContentInfo();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception unused) {
                return false;
            }
        }
        Builder builder = new Builder(new ClipData(inputContentInfoCompat.mImpl.getDescription(), new Item(inputContentInfoCompat.mImpl.getContentUri())), 2);
        builder.mLinkUri = inputContentInfoCompat.mImpl.getLinkUri();
        builder.mExtras = bundle;
        if (ViewCompat.performReceiveContent(this.val$view, new ContentInfoCompat(builder)) == null) {
            z = true;
        }
        return z;
    }
}
