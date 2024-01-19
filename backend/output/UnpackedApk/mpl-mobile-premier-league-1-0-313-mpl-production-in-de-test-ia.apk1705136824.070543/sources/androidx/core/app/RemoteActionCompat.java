package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.os.Build.VERSION;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcelable;

public final class RemoteActionCompat implements VersionedParcelable {
    public PendingIntent mActionIntent;
    public CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public CharSequence mTitle;

    public RemoteActionCompat(IconCompat iconCompat, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
        if (iconCompat != null) {
            this.mIcon = iconCompat;
            if (charSequence != null) {
                this.mTitle = charSequence;
                if (charSequence2 != null) {
                    this.mContentDescription = charSequence2;
                    if (pendingIntent != null) {
                        this.mActionIntent = pendingIntent;
                        this.mEnabled = true;
                        this.mShouldShowIcon = true;
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    public static RemoteActionCompat createFromRemoteAction(RemoteAction remoteAction) {
        if (remoteAction != null) {
            RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(remoteAction.getIcon()), remoteAction.getTitle(), remoteAction.getContentDescription(), remoteAction.getActionIntent());
            remoteActionCompat.setEnabled(remoteAction.isEnabled());
            if (VERSION.SDK_INT >= 28) {
                remoteActionCompat.setShouldShowIcon(remoteAction.shouldShowIcon());
            }
            return remoteActionCompat;
        }
        throw null;
    }

    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public void setShouldShowIcon(boolean z) {
        this.mShouldShowIcon = z;
    }

    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    public RemoteAction toRemoteAction() {
        RemoteAction remoteAction = new RemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        remoteAction.setEnabled(isEnabled());
        if (VERSION.SDK_INT >= 28) {
            remoteAction.setShouldShowIcon(shouldShowIcon());
        }
        return remoteAction;
    }

    public RemoteActionCompat() {
    }

    public RemoteActionCompat(RemoteActionCompat remoteActionCompat) {
        if (remoteActionCompat != null) {
            this.mIcon = remoteActionCompat.mIcon;
            this.mTitle = remoteActionCompat.mTitle;
            this.mContentDescription = remoteActionCompat.mContentDescription;
            this.mActionIntent = remoteActionCompat.mActionIntent;
            this.mEnabled = remoteActionCompat.mEnabled;
            this.mShouldShowIcon = remoteActionCompat.mShouldShowIcon;
            return;
        }
        throw null;
    }
}
