package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;

@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Creator<ActivityResult> CREATOR = new Creator<ActivityResult>() {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        public Object[] newArray(int i) {
            return new ActivityResult[i];
        }
    };
    public final Intent mData;
    public final int mResultCode;

    public ActivityResult(int i, Intent intent) {
        this.mResultCode = i;
        this.mData = intent;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ActivityResult{resultCode=");
        int i = this.mResultCode;
        outline73.append(i != -1 ? i != 0 ? String.valueOf(i) : "RESULT_CANCELED" : "RESULT_OK");
        outline73.append(", data=");
        outline73.append(this.mData);
        outline73.append('}');
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mResultCode);
        parcel.writeInt(this.mData == null ? 0 : 1);
        Intent intent = this.mData;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    public ActivityResult(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mData = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
