package com.google.firebase.platforminfo;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_LibraryVersion extends LibraryVersion {
    public final String libraryName;
    public final String version;

    public AutoValue_LibraryVersion(String str, String str2) {
        if (str != null) {
            this.libraryName = str;
            if (str2 != null) {
                this.version = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        AutoValue_LibraryVersion autoValue_LibraryVersion = (AutoValue_LibraryVersion) ((LibraryVersion) obj);
        if (!this.libraryName.equals(autoValue_LibraryVersion.libraryName) || !this.version.equals(autoValue_LibraryVersion.version)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LibraryVersion{libraryName=");
        outline73.append(this.libraryName);
        outline73.append(", version=");
        return GeneratedOutlineSupport.outline62(outline73, this.version, "}");
    }
}
