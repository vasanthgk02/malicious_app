package com.freshchat.consumer.sdk.beans;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class Participant {
    public String alias;
    public String firstName;
    public String lastName;
    public String profilePicUrl;

    public String getAlias() {
        return this.alias;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getProfilePicUrl() {
        return this.profilePicUrl;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setProfilePicUrl(String str) {
        this.profilePicUrl = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Participant{alias='");
        GeneratedOutlineSupport.outline99(outline73, this.alias, ExtendedMessageFormat.QUOTE, ", firstName='");
        GeneratedOutlineSupport.outline99(outline73, this.firstName, ExtendedMessageFormat.QUOTE, ", lastName='");
        GeneratedOutlineSupport.outline99(outline73, this.lastName, ExtendedMessageFormat.QUOTE, ", profilePicUrl='");
        return GeneratedOutlineSupport.outline60(outline73, this.profilePicUrl, ExtendedMessageFormat.QUOTE, '}');
    }
}
