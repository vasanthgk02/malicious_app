package com.crimzoncode.tqcontests.data.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/crimzoncode/tqcontests/data/model/Option;", "Lcom/crimzoncode/tqcontests/data/model/BaseModel;", "Ljava/io/Serializable;", "optionCode", "", "option", "", "(Ljava/lang/String;Ljava/lang/Object;)V", "getOption", "()Ljava/lang/Object;", "getOptionCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: Option.kt */
public final class Option extends BaseModel implements Serializable {
    @SerializedName("option_text")
    public final Object option;
    @SerializedName("code")
    public final String optionCode;

    public Option() {
        this(null, null, 3, null);
    }

    public /* synthetic */ Option(String str, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : obj);
    }

    public static /* synthetic */ Option copy$default(Option option2, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = option2.optionCode;
        }
        if ((i & 2) != 0) {
            obj = option2.option;
        }
        return option2.copy(str, obj);
    }

    public final String component1() {
        return this.optionCode;
    }

    public final Object component2() {
        return this.option;
    }

    public final Option copy(String str, Object obj) {
        return new Option(str, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.option, r3.option) != false) goto L_0x001f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x001f
            boolean r0 = r3 instanceof com.crimzoncode.tqcontests.data.model.Option
            if (r0 == 0) goto L_0x001d
            com.crimzoncode.tqcontests.data.model.Option r3 = (com.crimzoncode.tqcontests.data.model.Option) r3
            java.lang.String r0 = r2.optionCode
            java.lang.String r1 = r3.optionCode
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r2.option
            java.lang.Object r3 = r3.option
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            if (r3 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r3 = 0
            return r3
        L_0x001f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crimzoncode.tqcontests.data.model.Option.equals(java.lang.Object):boolean");
    }

    public final Object getOption() {
        return this.option;
    }

    public final String getOptionCode() {
        return this.optionCode;
    }

    public int hashCode() {
        String str = this.optionCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Object obj = this.option;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Option(optionCode=");
        outline73.append(this.optionCode);
        outline73.append(", option=");
        outline73.append(this.option);
        outline73.append(")");
        return outline73.toString();
    }

    public Option(String str, Object obj) {
        this.optionCode = str;
        this.option = obj;
    }
}
