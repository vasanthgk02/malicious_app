package com.freshchat.consumer.sdk;

import com.android.tools.r8.GeneratedOutlineSupport;

public class FreshchatUser {
    public String email;
    public String externalId;
    public String firstName;
    public String lastName;
    public String phone;
    public String phoneCountryCode;
    public String restoreId;

    public FreshchatUser() {
    }

    public FreshchatUser(String str, String str2) {
        this.externalId = str;
        this.restoreId = str2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || FreshchatUser.class != obj.getClass()) {
            return false;
        }
        FreshchatUser freshchatUser = (FreshchatUser) obj;
        String str = this.email;
        if (str == null ? freshchatUser.email != null : !str.equals(freshchatUser.email)) {
            return false;
        }
        String str2 = this.firstName;
        if (str2 == null ? freshchatUser.firstName != null : !str2.equals(freshchatUser.firstName)) {
            return false;
        }
        String str3 = this.lastName;
        if (str3 == null ? freshchatUser.lastName != null : !str3.equals(freshchatUser.lastName)) {
            return false;
        }
        String str4 = this.phone;
        if (str4 == null ? freshchatUser.phone != null : !str4.equals(freshchatUser.phone)) {
            return false;
        }
        String str5 = this.phoneCountryCode;
        if (str5 == null ? freshchatUser.phoneCountryCode != null : !str5.equals(freshchatUser.phoneCountryCode)) {
            return false;
        }
        String str6 = this.restoreId;
        if (str6 == null ? freshchatUser.restoreId != null : !str6.equals(freshchatUser.restoreId)) {
            return false;
        }
        String str7 = this.externalId;
        String str8 = freshchatUser.externalId;
        if (str7 == null ? str8 != null : !str7.equals(str8)) {
            z = false;
        }
        return z;
    }

    public String getEmail() {
        return this.email;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneCountryCode() {
        return this.phoneCountryCode;
    }

    public String getRestoreId() {
        return this.restoreId;
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.firstName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.lastName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.externalId;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public FreshchatUser setEmail(String str) {
        this.email = str;
        return this;
    }

    public FreshchatUser setFirstName(String str) {
        this.firstName = str;
        return this;
    }

    public FreshchatUser setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public FreshchatUser setPhone(String str, String str2) {
        this.phoneCountryCode = str;
        this.phone = str2;
        return this;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("FreshchatUser{ ", "email=");
        outline77.append(this.email);
        outline77.append(", firstName=");
        outline77.append(this.firstName);
        outline77.append(", lastName=");
        outline77.append(this.lastName);
        outline77.append(", externalId=");
        outline77.append(this.externalId);
        outline77.append(", restoreId=");
        outline77.append(this.restoreId);
        outline77.append(", phoneNumber=");
        outline77.append(this.phoneCountryCode);
        return GeneratedOutlineSupport.outline59(outline77, this.phone, '}');
    }
}
