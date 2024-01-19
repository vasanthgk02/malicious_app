package com.mpl.androidapp.database.entity;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.MLogger;
import com.paynimo.android.payment.UPIFragment;
import org.apache.commons.lang.text.ExtendedMessageFormat;
import org.json.JSONObject;

public class Contact {
    public static final String TAG = "Contact";
    public int id = 0;
    public Boolean isMplContact;
    public Boolean isOnline;
    public Boolean isSync;
    public String mContactDisplayName;
    public String mContactFamilyName;
    public String mContactGivenName;
    public String mContactId;
    public String mContactLookupKey;
    public String mContactName;
    public String mContactType;
    public String mLastSeen;
    public String mLastUpdateTimeStamp;
    public String mMplContactName;
    public String mMplId = "0";
    public String mPhoneNumber = "";
    public String mPhotoThumbUri;

    public String getContactDisplayName() {
        return this.mContactDisplayName;
    }

    public String getContactFamilyName() {
        return this.mContactFamilyName;
    }

    public String getContactGivenName() {
        return this.mContactGivenName;
    }

    public String getContactId() {
        return this.mContactId;
    }

    public String getContactLookupKey() {
        return this.mContactLookupKey;
    }

    public String getContactName() {
        return this.mContactName;
    }

    public String getContactType() {
        return this.mContactType;
    }

    public int getId() {
        return this.id;
    }

    public String getLastSeen() {
        return this.mLastSeen;
    }

    public String getLastUpdateTimeStamp() {
        return this.mLastUpdateTimeStamp;
    }

    public String getMplContactName() {
        return this.mMplContactName;
    }

    public String getMplId() {
        return this.mMplId;
    }

    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }

    public String getPhotoThumbUri() {
        return this.mPhotoThumbUri;
    }

    public Boolean isMplContact() {
        return this.isMplContact;
    }

    public Boolean isOnline() {
        return this.isOnline;
    }

    public Boolean isSync() {
        return this.isSync;
    }

    public void setContactDisplayName(String str) {
        this.mContactDisplayName = str;
    }

    public void setContactFamilyName(String str) {
        this.mContactFamilyName = str;
    }

    public void setContactGivenName(String str) {
        this.mContactGivenName = str;
    }

    public void setContactId(String str) {
        this.mContactId = str;
    }

    public void setContactLookupKey(String str) {
        this.mContactLookupKey = str;
    }

    public void setContactName(String str) {
        this.mContactName = str;
    }

    public void setContactType(String str) {
        this.mContactType = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setLastSeen(String str) {
        this.mLastSeen = str;
    }

    public void setLastUpdateTimeStamp(String str) {
        this.mLastUpdateTimeStamp = str;
    }

    public void setMplContact(Boolean bool) {
        this.isMplContact = bool;
    }

    public void setMplContactName(String str) {
        this.mMplContactName = str;
    }

    public void setMplId(String str) {
        this.mMplId = str;
    }

    public void setOnline(Boolean bool) {
        this.isOnline = bool;
    }

    public void setPhoneNumber(String str) {
        this.mPhoneNumber = str;
    }

    public void setPhotoThumbUri(String str) {
        this.mPhotoThumbUri = str;
    }

    public void setSync(Boolean bool) {
        this.isSync = bool;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UPIFragment.CONFIG_TYPE_NUMBER, getPhoneNumber());
            jSONObject.put("name", getContactDisplayName());
            jSONObject.put("id", getMplId());
        } catch (Exception e2) {
            MLogger.e(TAG, "toJson: ", e2);
        }
        return jSONObject;
    }

    public JSONObject toJsonForServerPush() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UPIFragment.CONFIG_TYPE_NUMBER, getPhoneNumber());
            jSONObject.put("name", getContactDisplayName());
        } catch (Exception e2) {
            MLogger.e(TAG, "toJsonForServerPush: ", e2);
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Contacts{mPhoneNumber='");
        GeneratedOutlineSupport.outline99(outline73, this.mPhoneNumber, ExtendedMessageFormat.QUOTE, ", mContactId='");
        GeneratedOutlineSupport.outline99(outline73, this.mContactId, ExtendedMessageFormat.QUOTE, ", mContactLookupKey='");
        GeneratedOutlineSupport.outline99(outline73, this.mContactLookupKey, ExtendedMessageFormat.QUOTE, ", mContactName='");
        GeneratedOutlineSupport.outline99(outline73, this.mContactName, ExtendedMessageFormat.QUOTE, ", mContactDisplayName='");
        GeneratedOutlineSupport.outline99(outline73, this.mContactDisplayName, ExtendedMessageFormat.QUOTE, ", mContactGivenName='");
        GeneratedOutlineSupport.outline99(outline73, this.mContactGivenName, ExtendedMessageFormat.QUOTE, ", mContactFamilyName='");
        GeneratedOutlineSupport.outline99(outline73, this.mContactFamilyName, ExtendedMessageFormat.QUOTE, ", isMplContact=");
        outline73.append(this.isMplContact);
        outline73.append(", mMplContactName='");
        GeneratedOutlineSupport.outline99(outline73, this.mMplContactName, ExtendedMessageFormat.QUOTE, ", isSync=");
        outline73.append(this.isSync);
        outline73.append('}');
        return outline73.toString();
    }
}
