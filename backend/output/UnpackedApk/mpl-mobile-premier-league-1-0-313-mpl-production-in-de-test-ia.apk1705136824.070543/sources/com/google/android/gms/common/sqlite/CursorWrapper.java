package com.google.android.gms.common.sqlite;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    @KeepForSdk
    public void fillWindow(int i, CursorWindow cursorWindow) {
        throw null;
    }

    @KeepForSdk
    public CursorWindow getWindow() {
        throw null;
    }

    public final /* synthetic */ Cursor getWrappedCursor() {
        return null;
    }

    public final boolean onMove(int i, int i2) {
        throw null;
    }
}
