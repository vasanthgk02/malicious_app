package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class Csat {
    public long csatId;
    @SerializedName("initiated")
    public long initiatedTime;
    public boolean isMandatory;
    public boolean mobileUserCommentsAllowed;
    public String question;
    public transient CSatStatus status = CSatStatus.NOT_RATED;

    public enum CSatStatus {
        NOT_RATED(0),
        RATED_NOT_UPLOADED(1),
        UPLOADED(2);
        
        public final int intValue;

        /* access modifiers changed from: public */
        CSatStatus(int i) {
            this.intValue = i;
        }

        public static CSatStatus fromInt(int i) {
            for (CSatStatus cSatStatus : values()) {
                if (cSatStatus.asInt() == i) {
                    return cSatStatus;
                }
            }
            return NOT_RATED;
        }

        public int asInt() {
            return this.intValue;
        }
    }

    public long getCsatId() {
        return this.csatId;
    }

    public long getInitiatedTime() {
        return this.initiatedTime;
    }

    public String getQuestion() {
        return this.question;
    }

    public CSatStatus getStatus() {
        return this.status;
    }

    public boolean isMandatory() {
        return this.isMandatory;
    }

    public boolean isMobileUserCommentsAllowed() {
        return this.mobileUserCommentsAllowed;
    }

    public void setCsatId(long j) {
        this.csatId = j;
    }

    public void setInitiatedTime(long j) {
        this.initiatedTime = j;
    }

    public void setMandatory(boolean z) {
        this.isMandatory = z;
    }

    public void setMobileUserCommentsAllowed(boolean z) {
        this.mobileUserCommentsAllowed = z;
    }

    public void setQuestion(String str) {
        this.question = str;
    }

    public void setStatus(CSatStatus cSatStatus) {
        this.status = cSatStatus;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("Csat{", "csatId=");
        outline77.append(this.csatId);
        outline77.append(", question='");
        GeneratedOutlineSupport.outline99(outline77, this.question, ExtendedMessageFormat.QUOTE, ", mobileUserCommentsAllowed=");
        outline77.append(this.mobileUserCommentsAllowed);
        outline77.append(", isMandatory=");
        outline77.append(this.isMandatory);
        outline77.append(", status=");
        outline77.append(this.status);
        outline77.append(", initiatedTime=");
        outline77.append(this.initiatedTime);
        outline77.append('}');
        return outline77.toString();
    }
}
