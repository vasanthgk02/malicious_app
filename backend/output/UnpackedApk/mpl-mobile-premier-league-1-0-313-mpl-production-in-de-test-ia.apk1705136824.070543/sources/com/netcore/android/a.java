package com.netcore.android;

import com.netcore.android.network.models.SMTRequest.SMTApiTypeID;

public final /* synthetic */ class a {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f1013a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f1014b;

    static {
        int[] iArr = new int[SMTApiTypeID.values().length];
        f1013a = iArr;
        SMTApiTypeID sMTApiTypeID = SMTApiTypeID.SDK_INITIALIZE_ON_SESSION_REFRESH;
        iArr[1] = 1;
        SMTApiTypeID sMTApiTypeID2 = SMTApiTypeID.SDK_INITIALIZE;
        iArr[0] = 2;
        int[] iArr2 = new int[SMTApiTypeID.values().length];
        f1014b = iArr2;
        iArr2[1] = 1;
        iArr2[0] = 2;
    }
}
