package com.mpl.androidapp.react;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class UserInfoBackup {
    public String avatar;
    public Avatars avatars;
    public String coverPhoto;
    public CoverPhotos coverPhotos;
    public String displayName;
    public int id;
    public String mobileNumber;
    public boolean newUser;
    public boolean ownProfile;
    public boolean pro;
    public String referralCode;
    public String tier;

    public static class Avatars {
        public String regular;
        public String small;

        public String getRegular() {
            return this.regular;
        }

        public String getSmall() {
            return this.small;
        }

        public void setRegular(String str) {
            this.regular = str;
        }

        public void setSmall(String str) {
            this.small = str;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Avatars{small='");
            GeneratedOutlineSupport.outline99(outline73, this.small, ExtendedMessageFormat.QUOTE, ", regular='");
            return GeneratedOutlineSupport.outline60(outline73, this.regular, ExtendedMessageFormat.QUOTE, '}');
        }
    }

    public static class CoverPhotos {
        public String regular;
        public String small;

        public String getRegular() {
            return this.regular;
        }

        public String getSmall() {
            return this.small;
        }

        public void setRegular(String str) {
            this.regular = str;
        }

        public void setSmall(String str) {
            this.small = str;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("CoverPhotos{small='");
            GeneratedOutlineSupport.outline99(outline73, this.small, ExtendedMessageFormat.QUOTE, ", regular='");
            return GeneratedOutlineSupport.outline60(outline73, this.regular, ExtendedMessageFormat.QUOTE, '}');
        }
    }

    public String getAvatar() {
        return this.avatar;
    }

    public Avatars getAvatars() {
        return this.avatars;
    }

    public String getCoverPhoto() {
        return this.coverPhoto;
    }

    public CoverPhotos getCoverPhotos() {
        return this.coverPhotos;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getId() {
        return this.id;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public String getTier() {
        return this.tier;
    }

    public boolean isNewUser() {
        return this.newUser;
    }

    public boolean isOwnProfile() {
        return this.ownProfile;
    }

    public boolean isPro() {
        return this.pro;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatars(Avatars avatars2) {
        this.avatars = avatars2;
    }

    public void setCoverPhoto(String str) {
        this.coverPhoto = str;
    }

    public void setCoverPhotos(CoverPhotos coverPhotos2) {
        this.coverPhotos = coverPhotos2;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setNewUser(boolean z) {
        this.newUser = z;
    }

    public void setOwnProfile(boolean z) {
        this.ownProfile = z;
    }

    public void setPro(boolean z) {
        this.pro = z;
    }

    public void setReferralCode(String str) {
        this.referralCode = str;
    }

    public void setTier(String str) {
        this.tier = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("UserInfo{id=");
        outline73.append(this.id);
        outline73.append(", mobileNumber='");
        GeneratedOutlineSupport.outline99(outline73, this.mobileNumber, ExtendedMessageFormat.QUOTE, ", displayName='");
        GeneratedOutlineSupport.outline99(outline73, this.displayName, ExtendedMessageFormat.QUOTE, ", avatars=");
        String str = "";
        outline73.append(this.avatars != null ? this.avatar.toString() : str);
        outline73.append(", avatar='");
        GeneratedOutlineSupport.outline99(outline73, this.avatar, ExtendedMessageFormat.QUOTE, ", newUser=");
        outline73.append(this.newUser);
        outline73.append(", referralCode='");
        GeneratedOutlineSupport.outline99(outline73, this.referralCode, ExtendedMessageFormat.QUOTE, ", coverPhoto='");
        GeneratedOutlineSupport.outline99(outline73, this.coverPhoto, ExtendedMessageFormat.QUOTE, ", coverPhotos=");
        CoverPhotos coverPhotos2 = this.coverPhotos;
        if (coverPhotos2 != null) {
            str = coverPhotos2.toString();
        }
        outline73.append(str);
        outline73.append(", tier='");
        GeneratedOutlineSupport.outline99(outline73, this.tier, ExtendedMessageFormat.QUOTE, ", pro=");
        outline73.append(this.pro);
        outline73.append(", ownProfile=");
        return GeneratedOutlineSupport.outline65(outline73, this.ownProfile, '}');
    }
}
