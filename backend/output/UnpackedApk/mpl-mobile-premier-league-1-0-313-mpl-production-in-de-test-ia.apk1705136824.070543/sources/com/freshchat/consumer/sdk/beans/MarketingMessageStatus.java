package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public class MarketingMessageStatus {
    public int clicked;
    public int delivered;
    public long marketingId;
    public int seen;

    public static class Builder {
        public int clicked;
        public int delivered;
        public long marketingId;
        public int seen;

        public MarketingMessageStatus build() {
            MarketingMessageStatus marketingMessageStatus = new MarketingMessageStatus();
            marketingMessageStatus.delivered = this.delivered;
            marketingMessageStatus.seen = this.seen;
            marketingMessageStatus.clicked = this.clicked;
            marketingMessageStatus.marketingId = this.marketingId;
            return marketingMessageStatus;
        }

        public Builder clicked(int i) {
            this.clicked = i;
            return this;
        }

        public Builder delivered(int i) {
            this.delivered = i;
            return this;
        }

        public Builder marketingId(long j) {
            this.marketingId = j;
            return this;
        }

        public Builder seen(int i) {
            this.seen = i;
            return this;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || MarketingMessageStatus.class != obj.getClass()) {
            return false;
        }
        if (this.marketingId != ((MarketingMessageStatus) obj).marketingId) {
            z = false;
        }
        return z;
    }

    public int getClicked() {
        return this.clicked;
    }

    public int getDelivered() {
        return this.delivered;
    }

    public long getMarketingId() {
        return this.marketingId;
    }

    public int getSeen() {
        return this.seen;
    }

    public int hashCode() {
        long j = this.marketingId;
        return 31 + ((int) (j ^ (j >>> 32)));
    }

    public void setClicked(int i) {
        this.clicked = i;
    }

    public void setDelivered(int i) {
        this.delivered = i;
    }

    public void setMarketingId(long j) {
        this.marketingId = j;
    }

    public void setSeen(int i) {
        this.seen = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MarketingMessageStatus [delivered=");
        outline73.append(this.delivered);
        outline73.append(", seen=");
        outline73.append(this.seen);
        outline73.append(", clicked=");
        outline73.append(this.clicked);
        outline73.append(", marketingId=");
        return GeneratedOutlineSupport.outline58(outline73, this.marketingId, CMapParser.MARK_END_OF_ARRAY);
    }
}
