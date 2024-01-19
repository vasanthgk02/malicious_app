package androidx.core.app;

import android.app.PendingIntent;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.VersionedParcelParcel;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object obj = remoteActionCompat.mIcon;
        if (versionedParcel.readField(1)) {
            obj = versionedParcel.readVersionedParcelable();
        }
        remoteActionCompat.mIcon = (IconCompat) obj;
        remoteActionCompat.mTitle = versionedParcel.readCharSequence(remoteActionCompat.mTitle, 2);
        remoteActionCompat.mContentDescription = versionedParcel.readCharSequence(remoteActionCompat.mContentDescription, 3);
        remoteActionCompat.mActionIntent = (PendingIntent) versionedParcel.readParcelable(remoteActionCompat.mActionIntent, 4);
        remoteActionCompat.mEnabled = versionedParcel.readBoolean(remoteActionCompat.mEnabled, 5);
        remoteActionCompat.mShouldShowIcon = versionedParcel.readBoolean(remoteActionCompat.mShouldShowIcon, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        if (versionedParcel != null) {
            IconCompat iconCompat = remoteActionCompat.mIcon;
            versionedParcel.setOutputField(1);
            versionedParcel.writeVersionedParcelable(iconCompat);
            CharSequence charSequence = remoteActionCompat.mTitle;
            versionedParcel.setOutputField(2);
            VersionedParcelParcel versionedParcelParcel = (VersionedParcelParcel) versionedParcel;
            TextUtils.writeToParcel(charSequence, versionedParcelParcel.mParcel, 0);
            CharSequence charSequence2 = remoteActionCompat.mContentDescription;
            versionedParcel.setOutputField(3);
            TextUtils.writeToParcel(charSequence2, versionedParcelParcel.mParcel, 0);
            versionedParcel.writeParcelable(remoteActionCompat.mActionIntent, 4);
            boolean z = remoteActionCompat.mEnabled;
            versionedParcel.setOutputField(5);
            versionedParcelParcel.mParcel.writeInt(z ? 1 : 0);
            boolean z2 = remoteActionCompat.mShouldShowIcon;
            versionedParcel.setOutputField(6);
            versionedParcelParcel.mParcel.writeInt(z2 ? 1 : 0);
            return;
        }
        throw null;
    }
}
