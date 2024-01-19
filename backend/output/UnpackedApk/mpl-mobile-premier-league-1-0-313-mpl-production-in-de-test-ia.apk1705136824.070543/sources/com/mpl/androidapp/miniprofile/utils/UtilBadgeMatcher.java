package com.mpl.androidapp.miniprofile.utils;

import com.mpl.androidapp.R;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/mpl/androidapp/miniprofile/utils/UtilBadgeMatcher;", "", "()V", "badgeCollection", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getBadgeCollection", "()Ljava/util/HashMap;", "setBadgeCollection", "(Ljava/util/HashMap;)V", "defaultBadge", "getDefaultBadge", "()I", "setDefaultBadge", "(I)V", "getBadge", "keyMatch", "(Ljava/lang/String;)Ljava/lang/Integer;", "isBadgePresent", "", "prepareBadgeDataSet", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UtilBadgeMatcher.kt */
public final class UtilBadgeMatcher {
    public HashMap<String, Integer> badgeCollection = new HashMap<>();
    public int defaultBadge = R.drawable.full_steel;

    public UtilBadgeMatcher() {
        prepareBadgeDataSet();
    }

    private final boolean isBadgePresent(String str) {
        HashMap<String, Integer> hashMap = this.badgeCollection;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return hashMap.get(upperCase) != null;
    }

    private final void prepareBadgeDataSet() {
        this.badgeCollection.put(Constants.INSTANCE.getSTEEL(), Integer.valueOf(R.drawable.full_steel));
        this.badgeCollection.put(Constants.INSTANCE.getCOPPER(), Integer.valueOf(R.drawable.full_copper));
        this.badgeCollection.put(Constants.INSTANCE.getBRONZE(), Integer.valueOf(R.drawable.full_bronze));
        this.badgeCollection.put(Constants.INSTANCE.getSILVER(), Integer.valueOf(R.drawable.full_silver));
        this.badgeCollection.put(Constants.INSTANCE.getGOLD(), Integer.valueOf(R.drawable.full_gold));
        this.badgeCollection.put(Constants.INSTANCE.getPLATINUM(), Integer.valueOf(R.drawable.full_platinum));
        this.badgeCollection.put(Constants.INSTANCE.getPEARL(), Integer.valueOf(R.drawable.full_pearl));
        this.badgeCollection.put(Constants.INSTANCE.getONYX(), Integer.valueOf(R.drawable.full_onyx));
        this.badgeCollection.put(Constants.INSTANCE.getJADE(), Integer.valueOf(R.drawable.full_jade));
        this.badgeCollection.put(Constants.INSTANCE.getOPAL(), Integer.valueOf(R.drawable.full_opal));
        this.badgeCollection.put(Constants.INSTANCE.getTOPAZ(), Integer.valueOf(R.drawable.full_topaz));
        this.badgeCollection.put(Constants.INSTANCE.getSAPPHIRE(), Integer.valueOf(R.drawable.full_sapphire));
        this.badgeCollection.put(Constants.INSTANCE.getEMERALD(), Integer.valueOf(R.drawable.full_emerald));
        this.badgeCollection.put(Constants.INSTANCE.getRUBY(), Integer.valueOf(R.drawable.full_ruby));
        this.badgeCollection.put(Constants.INSTANCE.getDIAMOND(), Integer.valueOf(R.drawable.full_diamond));
    }

    public final Integer getBadge(String str) {
        Intrinsics.checkNotNullParameter(str, "keyMatch");
        if (!isBadgePresent(str)) {
            return Integer.valueOf(this.defaultBadge);
        }
        HashMap<String, Integer> hashMap = this.badgeCollection;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return hashMap.get(upperCase);
    }

    public final HashMap<String, Integer> getBadgeCollection() {
        return this.badgeCollection;
    }

    public final int getDefaultBadge() {
        return this.defaultBadge;
    }

    public final void setBadgeCollection(HashMap<String, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.badgeCollection = hashMap;
    }

    public final void setDefaultBadge(int i) {
        this.defaultBadge = i;
    }
}
