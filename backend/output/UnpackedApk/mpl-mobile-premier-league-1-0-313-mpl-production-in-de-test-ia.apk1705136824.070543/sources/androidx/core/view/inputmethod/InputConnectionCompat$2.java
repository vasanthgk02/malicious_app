package androidx.core.view.inputmethod;

import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

public class InputConnectionCompat$2 extends InputConnectionWrapper {
    public final /* synthetic */ InputConnectionCompat$OnCommitContentListener val$listener;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public InputConnectionCompat$2(InputConnection inputConnection, boolean z, InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener) {
        // this.val$listener = inputConnectionCompat$OnCommitContentListener;
        super(inputConnection, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performPrivateCommand(java.lang.String r13, android.os.Bundle r14) {
        /*
            r12 = this;
            androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener r0 = r12.val$listener
            r1 = 0
            r2 = 1
            if (r14 != 0) goto L_0x0008
            goto L_0x00e4
        L_0x0008:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r3 = android.text.TextUtils.equals(r3, r13)
            if (r3 == 0) goto L_0x0012
            r3 = 0
            goto L_0x001b
        L_0x0012:
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r3 = android.text.TextUtils.equals(r3, r13)
            if (r3 == 0) goto L_0x00e4
            r3 = 1
        L_0x001b:
            r4 = 0
            if (r3 == 0) goto L_0x0021
            java.lang.String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
            goto L_0x0023
        L_0x0021:
            java.lang.String r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
        L_0x0023:
            android.os.Parcelable r5 = r14.getParcelable(r5)     // Catch:{ all -> 0x00dc }
            android.os.ResultReceiver r5 = (android.os.ResultReceiver) r5     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x002e
            java.lang.String r6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI"
            goto L_0x0030
        L_0x002e:
            java.lang.String r6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI"
        L_0x0030:
            android.os.Parcelable r6 = r14.getParcelable(r6)     // Catch:{ all -> 0x00da }
            android.net.Uri r6 = (android.net.Uri) r6     // Catch:{ all -> 0x00da }
            if (r3 == 0) goto L_0x003b
            java.lang.String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
            goto L_0x003d
        L_0x003b:
            java.lang.String r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
        L_0x003d:
            android.os.Parcelable r7 = r14.getParcelable(r7)     // Catch:{ all -> 0x00da }
            android.content.ClipDescription r7 = (android.content.ClipDescription) r7     // Catch:{ all -> 0x00da }
            if (r3 == 0) goto L_0x0048
            java.lang.String r8 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
            goto L_0x004a
        L_0x0048:
            java.lang.String r8 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
        L_0x004a:
            android.os.Parcelable r8 = r14.getParcelable(r8)     // Catch:{ all -> 0x00da }
            android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x00da }
            if (r3 == 0) goto L_0x0055
            java.lang.String r9 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
            goto L_0x0057
        L_0x0055:
            java.lang.String r9 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
        L_0x0057:
            int r9 = r14.getInt(r9)     // Catch:{ all -> 0x00da }
            if (r3 == 0) goto L_0x0060
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
            goto L_0x0062
        L_0x0060:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
        L_0x0062:
            android.os.Parcelable r3 = r14.getParcelable(r3)     // Catch:{ all -> 0x00da }
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x00da }
            if (r6 == 0) goto L_0x00d4
            if (r7 == 0) goto L_0x00d4
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00da }
            r11 = 25
            if (r10 < r11) goto L_0x0078
            androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl r10 = new androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl     // Catch:{ all -> 0x00da }
            r10.<init>(r6, r7, r8)     // Catch:{ all -> 0x00da }
            goto L_0x007d
        L_0x0078:
            androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatBaseImpl r10 = new androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatBaseImpl     // Catch:{ all -> 0x00da }
            r10.<init>(r6, r7, r8)     // Catch:{ all -> 0x00da }
        L_0x007d:
            androidx.appcompat.widget.AppCompatReceiveContentHelper$1 r0 = (androidx.appcompat.widget.AppCompatReceiveContentHelper$1) r0
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00da }
            if (r6 < r11) goto L_0x00a6
            r6 = r9 & 1
            if (r6 == 0) goto L_0x00a6
            r10.requestPermission()     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r6 = r10.getInputContentInfo()     // Catch:{ all -> 0x00da }
            android.view.inputmethod.InputContentInfo r6 = (android.view.inputmethod.InputContentInfo) r6     // Catch:{ all -> 0x00da }
            if (r3 != 0) goto L_0x0098
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x00da }
            r3.<init>()     // Catch:{ all -> 0x00da }
            goto L_0x009e
        L_0x0098:
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x00da }
            r7.<init>(r3)     // Catch:{ all -> 0x00da }
            r3 = r7
        L_0x009e:
            java.lang.String r7 = "androidx.core.view.extra.INPUT_CONTENT_INFO"
            r3.putParcelable(r7, r6)     // Catch:{ all -> 0x00da }
            goto L_0x00a6
        L_0x00a4:
            goto L_0x00d4
        L_0x00a6:
            android.content.ClipData r6 = new android.content.ClipData     // Catch:{ all -> 0x00da }
            android.content.ClipDescription r7 = r10.getDescription()     // Catch:{ all -> 0x00da }
            android.content.ClipData$Item r8 = new android.content.ClipData$Item     // Catch:{ all -> 0x00da }
            android.net.Uri r9 = r10.getContentUri()     // Catch:{ all -> 0x00da }
            r8.<init>(r9)     // Catch:{ all -> 0x00da }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00da }
            androidx.core.view.ContentInfoCompat$Builder r7 = new androidx.core.view.ContentInfoCompat$Builder     // Catch:{ all -> 0x00da }
            r8 = 2
            r7.<init>(r6, r8)     // Catch:{ all -> 0x00da }
            android.net.Uri r6 = r10.getLinkUri()     // Catch:{ all -> 0x00da }
            r7.mLinkUri = r6     // Catch:{ all -> 0x00da }
            r7.mExtras = r3     // Catch:{ all -> 0x00da }
            androidx.core.view.ContentInfoCompat r3 = new androidx.core.view.ContentInfoCompat     // Catch:{ all -> 0x00da }
            r3.<init>(r7)     // Catch:{ all -> 0x00da }
            android.view.View r0 = r0.val$view     // Catch:{ all -> 0x00da }
            androidx.core.view.ContentInfoCompat r0 = androidx.core.view.ViewCompat.performReceiveContent(r0, r3)     // Catch:{ all -> 0x00da }
            if (r0 != 0) goto L_0x00d4
            r1 = 1
        L_0x00d4:
            if (r5 == 0) goto L_0x00e4
            r5.send(r1, r4)
            goto L_0x00e4
        L_0x00da:
            r13 = move-exception
            goto L_0x00de
        L_0x00dc:
            r13 = move-exception
            r5 = r4
        L_0x00de:
            if (r5 == 0) goto L_0x00e3
            r5.send(r1, r4)
        L_0x00e3:
            throw r13
        L_0x00e4:
            if (r1 == 0) goto L_0x00e7
            return r2
        L_0x00e7:
            boolean r13 = super.performPrivateCommand(r13, r14)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.InputConnectionCompat$2.performPrivateCommand(java.lang.String, android.os.Bundle):boolean");
    }
}
