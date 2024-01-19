package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
public final class NavBackStackEntryState implements Parcelable {
    public static final Creator<NavBackStackEntryState> CREATOR = new Creator<NavBackStackEntryState>() {
        public Object createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        public Object[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }
    };
    public final Bundle mArgs;
    public final int mDestinationId;
    public final Bundle mSavedState;
    public final UUID mUUID;

    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.mUUID = navBackStackEntry.mId;
        this.mDestinationId = navBackStackEntry.mDestination.mId;
        this.mArgs = navBackStackEntry.mArgs;
        Bundle bundle = new Bundle();
        this.mSavedState = bundle;
        navBackStackEntry.mSavedStateRegistryController.performSave(bundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mUUID.toString());
        parcel.writeInt(this.mDestinationId);
        parcel.writeBundle(this.mArgs);
        parcel.writeBundle(this.mSavedState);
    }

    public NavBackStackEntryState(Parcel parcel) {
        this.mUUID = UUID.fromString(parcel.readString());
        this.mDestinationId = parcel.readInt();
        this.mArgs = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.mSavedState = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
