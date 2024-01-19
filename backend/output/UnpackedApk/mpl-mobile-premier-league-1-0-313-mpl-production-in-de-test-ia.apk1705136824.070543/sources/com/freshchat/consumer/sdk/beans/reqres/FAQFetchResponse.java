package com.freshchat.consumer.sdk.beans.reqres;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.service.e.ag;

public class FAQFetchResponse extends ag {
    public static final Creator<FAQFetchResponse> CREATOR = new Creator<FAQFetchResponse>() {
        public FAQFetchResponse createFromParcel(Parcel parcel) {
            return new FAQFetchResponse(parcel);
        }

        public FAQFetchResponse[] newArray(int i) {
            return new FAQFetchResponse[i];
        }
    };
    public FAQ faq;

    public FAQFetchResponse() {
    }

    public FAQFetchResponse(Parcel parcel) {
        super(parcel);
        this.faq = (FAQ) parcel.readParcelable(FAQ.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public FAQ getFaq() {
        return this.faq;
    }

    public void setFaq(FAQ faq2) {
        this.faq = faq2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.faq, i);
    }
}
