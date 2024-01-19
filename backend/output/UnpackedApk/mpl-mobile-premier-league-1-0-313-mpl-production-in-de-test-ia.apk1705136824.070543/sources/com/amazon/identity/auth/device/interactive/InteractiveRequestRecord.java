package com.amazon.identity.auth.device.interactive;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class InteractiveRequestRecord implements Parcelable {
    public static final Creator<InteractiveRequestRecord> CREATOR = new Creator<InteractiveRequestRecord>() {
        /* renamed from: a */
        public InteractiveRequestRecord createFromParcel(Parcel parcel) {
            return new InteractiveRequestRecord(parcel);
        }

        /* renamed from: a */
        public InteractiveRequestRecord[] newArray(int i) {
            return new InteractiveRequestRecord[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f3295a;

    /* renamed from: a  reason: collision with other field name */
    public final String f121a;

    /* renamed from: b  reason: collision with root package name */
    public Bundle f3296b;

    public InteractiveRequestRecord(Parcel parcel) {
        this.f121a = parcel.readString();
        this.f3295a = parcel.readBundle();
        this.f3296b = parcel.readBundle();
    }

    public InteractiveRequestRecord(String str, Bundle bundle) {
        this.f121a = str;
        this.f3295a = bundle;
    }

    public Bundle a() {
        return this.f3296b;
    }

    public void a(Bundle bundle) {
        this.f3296b = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || InteractiveRequestRecord.class != obj.getClass()) {
            return false;
        }
        InteractiveRequestRecord interactiveRequestRecord = (InteractiveRequestRecord) obj;
        Bundle bundle = this.f3296b;
        if (bundle == null) {
            if (interactiveRequestRecord.f3296b != null) {
                return false;
            }
        } else if (!bundle.equals(interactiveRequestRecord.f3296b)) {
            return false;
        }
        Bundle bundle2 = this.f3295a;
        if (bundle2 == null) {
            if (interactiveRequestRecord.f3295a != null) {
                return false;
            }
        } else if (!bundle2.equals(interactiveRequestRecord.f3295a)) {
            return false;
        }
        String str = this.f121a;
        String str2 = interactiveRequestRecord.f121a;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public Bundle getRequestExtras() {
        return this.f3295a;
    }

    public String getRequestId() {
        return this.f121a;
    }

    public int hashCode() {
        Bundle bundle = this.f3296b;
        int i = 0;
        int hashCode = ((bundle == null ? 0 : bundle.hashCode()) + 31) * 31;
        Bundle bundle2 = this.f3295a;
        int hashCode2 = (hashCode + (bundle2 == null ? 0 : bundle2.hashCode())) * 31;
        String str = this.f121a;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" id=");
        sb.append(this.f121a);
        sb.append(" hasFragment=");
        sb.append(this.f3296b != null);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f121a);
        parcel.writeBundle(this.f3295a);
        parcel.writeBundle(this.f3296b);
    }
}
