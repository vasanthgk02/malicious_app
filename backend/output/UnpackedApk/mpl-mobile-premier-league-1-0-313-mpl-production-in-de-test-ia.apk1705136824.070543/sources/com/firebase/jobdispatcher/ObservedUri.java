package com.firebase.jobdispatcher;

import android.net.Uri;

public final class ObservedUri {
    public final int flags;
    public final Uri uri;

    public ObservedUri(Uri uri2, int i) {
        if (uri2 != null) {
            this.uri = uri2;
            this.flags = i;
            return;
        }
        throw new IllegalArgumentException("URI must not be null.");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ObservedUri)) {
            return false;
        }
        ObservedUri observedUri = (ObservedUri) obj;
        if (this.flags != observedUri.flags || !this.uri.equals(observedUri.uri)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.uri.hashCode() ^ this.flags;
    }
}
