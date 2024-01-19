package com.mpl.androidapp.miniprofile.models;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\bHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006#"}, d2 = {"Lcom/mpl/androidapp/miniprofile/models/ExtendedFields;", "", "audioBio", "", "bio", "coverPhotos", "Lcom/mpl/androidapp/miniprofile/models/CoverPhotos;", "profaneChangeFields", "", "videoLinks", "kycVerified", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/mpl/androidapp/miniprofile/models/CoverPhotos;Ljava/util/List;Ljava/util/List;Z)V", "getAudioBio", "()Ljava/lang/String;", "getBio", "getCoverPhotos", "()Lcom/mpl/androidapp/miniprofile/models/CoverPhotos;", "getKycVerified", "()Z", "getProfaneChangeFields", "()Ljava/util/List;", "getVideoLinks", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExtendedFields.kt */
public final class ExtendedFields {
    @SerializedName("audioBio")
    public final String audioBio;
    @SerializedName("bio")
    public final String bio;
    @SerializedName("coverPhotos")
    public final CoverPhotos coverPhotos;
    @SerializedName("kycVerified")
    public final boolean kycVerified;
    @SerializedName("profaneChangeFields")
    public final List<Object> profaneChangeFields;
    @SerializedName("videoLinks")
    public final List<Object> videoLinks;

    public ExtendedFields(String str, String str2, CoverPhotos coverPhotos2, List<? extends Object> list, List<? extends Object> list2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "audioBio");
        Intrinsics.checkNotNullParameter(str2, "bio");
        Intrinsics.checkNotNullParameter(coverPhotos2, "coverPhotos");
        Intrinsics.checkNotNullParameter(list, "profaneChangeFields");
        Intrinsics.checkNotNullParameter(list2, "videoLinks");
        this.audioBio = str;
        this.bio = str2;
        this.coverPhotos = coverPhotos2;
        this.profaneChangeFields = list;
        this.videoLinks = list2;
        this.kycVerified = z;
    }

    public static /* synthetic */ ExtendedFields copy$default(ExtendedFields extendedFields, String str, String str2, CoverPhotos coverPhotos2, List<Object> list, List<Object> list2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = extendedFields.audioBio;
        }
        if ((i & 2) != 0) {
            str2 = extendedFields.bio;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            coverPhotos2 = extendedFields.coverPhotos;
        }
        CoverPhotos coverPhotos3 = coverPhotos2;
        if ((i & 8) != 0) {
            list = extendedFields.profaneChangeFields;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = extendedFields.videoLinks;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            z = extendedFields.kycVerified;
        }
        return extendedFields.copy(str, str3, coverPhotos3, list3, list4, z);
    }

    public final String component1() {
        return this.audioBio;
    }

    public final String component2() {
        return this.bio;
    }

    public final CoverPhotos component3() {
        return this.coverPhotos;
    }

    public final List<Object> component4() {
        return this.profaneChangeFields;
    }

    public final List<Object> component5() {
        return this.videoLinks;
    }

    public final boolean component6() {
        return this.kycVerified;
    }

    public final ExtendedFields copy(String str, String str2, CoverPhotos coverPhotos2, List<? extends Object> list, List<? extends Object> list2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "audioBio");
        Intrinsics.checkNotNullParameter(str2, "bio");
        Intrinsics.checkNotNullParameter(coverPhotos2, "coverPhotos");
        Intrinsics.checkNotNullParameter(list, "profaneChangeFields");
        Intrinsics.checkNotNullParameter(list2, "videoLinks");
        ExtendedFields extendedFields = new ExtendedFields(str, str2, coverPhotos2, list, list2, z);
        return extendedFields;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtendedFields)) {
            return false;
        }
        ExtendedFields extendedFields = (ExtendedFields) obj;
        return Intrinsics.areEqual(this.audioBio, extendedFields.audioBio) && Intrinsics.areEqual(this.bio, extendedFields.bio) && Intrinsics.areEqual(this.coverPhotos, extendedFields.coverPhotos) && Intrinsics.areEqual(this.profaneChangeFields, extendedFields.profaneChangeFields) && Intrinsics.areEqual(this.videoLinks, extendedFields.videoLinks) && this.kycVerified == extendedFields.kycVerified;
    }

    public final String getAudioBio() {
        return this.audioBio;
    }

    public final String getBio() {
        return this.bio;
    }

    public final CoverPhotos getCoverPhotos() {
        return this.coverPhotos;
    }

    public final boolean getKycVerified() {
        return this.kycVerified;
    }

    public final List<Object> getProfaneChangeFields() {
        return this.profaneChangeFields;
    }

    public final List<Object> getVideoLinks() {
        return this.videoLinks;
    }

    public int hashCode() {
        int outline11 = GeneratedOutlineSupport.outline11(this.bio, this.audioBio.hashCode() * 31, 31);
        int hashCode = this.profaneChangeFields.hashCode();
        int hashCode2 = (this.videoLinks.hashCode() + ((hashCode + ((this.coverPhotos.hashCode() + outline11) * 31)) * 31)) * 31;
        boolean z = this.kycVerified;
        if (z) {
            z = true;
        }
        return hashCode2 + (z ? 1 : 0);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ExtendedFields(audioBio=");
        outline73.append(this.audioBio);
        outline73.append(", bio=");
        outline73.append(this.bio);
        outline73.append(", coverPhotos=");
        outline73.append(this.coverPhotos);
        outline73.append(", profaneChangeFields=");
        outline73.append(this.profaneChangeFields);
        outline73.append(", videoLinks=");
        outline73.append(this.videoLinks);
        outline73.append(", kycVerified=");
        return GeneratedOutlineSupport.outline65(outline73, this.kycVerified, ')');
    }
}
