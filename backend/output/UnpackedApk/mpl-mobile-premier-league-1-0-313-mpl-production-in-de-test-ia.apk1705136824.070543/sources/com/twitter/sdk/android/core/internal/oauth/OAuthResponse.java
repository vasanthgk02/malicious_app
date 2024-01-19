package com.twitter.sdk.android.core.internal.oauth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.core.TwitterAuthToken;

public class OAuthResponse implements Parcelable {
    public static final Creator<OAuthResponse> CREATOR = new Creator<OAuthResponse>() {
        public Object createFromParcel(Parcel parcel) {
            return new OAuthResponse(parcel, null);
        }

        public Object[] newArray(int i) {
            return new OAuthResponse[i];
        }
    };
    public final TwitterAuthToken authToken;
    public final long userId;
    public final String userName;

    public OAuthResponse(TwitterAuthToken twitterAuthToken, String str, long j) {
        this.authToken = twitterAuthToken;
        this.userName = str;
        this.userId = j;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("authToken=");
        outline73.append(this.authToken);
        outline73.append(",userName=");
        outline73.append(this.userName);
        outline73.append(",userId=");
        outline73.append(this.userId);
        return outline73.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.authToken, i);
        parcel.writeString(this.userName);
        parcel.writeLong(this.userId);
    }

    public OAuthResponse(Parcel parcel, AnonymousClass1 r2) {
        this.authToken = (TwitterAuthToken) parcel.readParcelable(TwitterAuthToken.class.getClassLoader());
        this.userName = parcel.readString();
        this.userId = parcel.readLong();
    }
}
