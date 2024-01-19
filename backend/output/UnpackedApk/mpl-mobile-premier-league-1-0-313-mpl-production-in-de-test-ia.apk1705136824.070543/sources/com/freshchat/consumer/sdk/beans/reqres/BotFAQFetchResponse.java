package com.freshchat.consumer.sdk.beans.reqres;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.beans.BotFAQ;
import com.freshchat.consumer.sdk.service.e.ag;

public class BotFAQFetchResponse extends ag {
    public static final Creator<BotFAQFetchResponse> CREATOR = new Creator<BotFAQFetchResponse>() {
        public BotFAQFetchResponse createFromParcel(Parcel parcel) {
            return new BotFAQFetchResponse(parcel);
        }

        public BotFAQFetchResponse[] newArray(int i) {
            return new BotFAQFetchResponse[i];
        }
    };
    public BotFAQ botFAQ;

    public BotFAQFetchResponse() {
    }

    public BotFAQFetchResponse(Parcel parcel) {
        super(parcel);
        this.botFAQ = (BotFAQ) parcel.readParcelable(BotFAQ.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public BotFAQ getBotFAQ() {
        return this.botFAQ;
    }

    public void setBotFAQ(BotFAQ botFAQ2) {
        this.botFAQ = botFAQ2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.botFAQ, i);
    }
}
