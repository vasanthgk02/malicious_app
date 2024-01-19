package com.netcore.android.network.models;

import com.netcore.android.geofence.c;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/netcore/android/network/models/SMTGeoFenceResponse;", "Lcom/netcore/android/network/models/SMTResponse;", "Lcom/netcore/android/network/models/SMTGeoFenceResponse$SMTGeoFenceList;", "geoFenceList", "Lcom/netcore/android/network/models/SMTGeoFenceResponse$SMTGeoFenceList;", "getGeoFenceList", "()Lcom/netcore/android/network/models/SMTGeoFenceResponse$SMTGeoFenceList;", "setGeoFenceList", "(Lcom/netcore/android/network/models/SMTGeoFenceResponse$SMTGeoFenceList;)V", "<init>", "()V", "SMTGeoFenceList", "smartech_release"}, k = 1, mv = {1, 4, 1})
/* compiled from: SMTGeoFenceResponse.kt */
public final class SMTGeoFenceResponse extends SMTResponse {
    public SMTGeoFenceList geoFenceList;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R2\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0002j\b\u0012\u0004\u0012\u00020\u000b`\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR2\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/netcore/android/network/models/SMTGeoFenceResponse$SMTGeoFenceList;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "deletedFenceIds", "Ljava/util/ArrayList;", "getDeletedFenceIds", "()Ljava/util/ArrayList;", "setDeletedFenceIds", "(Ljava/util/ArrayList;)V", "Lcom/netcore/android/geofence/c;", "geoFenceGroups", "getGeoFenceGroups", "setGeoFenceGroups", "deletedGroupIds", "getDeletedGroupIds", "setDeletedGroupIds", "<init>", "()V", "smartech_release"}, k = 1, mv = {1, 4, 1})
    /* compiled from: SMTGeoFenceResponse.kt */
    public static final class SMTGeoFenceList {
        public ArrayList<String> deletedFenceIds = new ArrayList<>();
        public ArrayList<String> deletedGroupIds = new ArrayList<>();
        public ArrayList<c> geoFenceGroups = new ArrayList<>();

        public final ArrayList<String> getDeletedFenceIds() {
            return this.deletedFenceIds;
        }

        public final ArrayList<String> getDeletedGroupIds() {
            return this.deletedGroupIds;
        }

        public final ArrayList<c> getGeoFenceGroups() {
            return this.geoFenceGroups;
        }

        public final void setDeletedFenceIds(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.deletedFenceIds = arrayList;
        }

        public final void setDeletedGroupIds(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.deletedGroupIds = arrayList;
        }

        public final void setGeoFenceGroups(ArrayList<c> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.geoFenceGroups = arrayList;
        }
    }

    public final SMTGeoFenceList getGeoFenceList() {
        return this.geoFenceList;
    }

    public final void setGeoFenceList(SMTGeoFenceList sMTGeoFenceList) {
        this.geoFenceList = sMTGeoFenceList;
    }
}
