package kotlinx.serialization.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\b\u0010!\u001a\u00020\nH\u0016R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/JsonConfiguration;", "", "encodeDefaults", "", "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", "prettyPrintIndent", "", "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZ)V", "getAllowSpecialFloatingPointValues", "()Z", "getAllowStructuredMapKeys", "getClassDiscriminator", "()Ljava/lang/String;", "getCoerceInputValues", "getEncodeDefaults", "getExplicitNulls$annotations", "()V", "getExplicitNulls", "getIgnoreUnknownKeys", "getPrettyPrint", "getPrettyPrintIndent$annotations", "getPrettyPrintIndent", "getUseAlternativeNames", "getUseArrayPolymorphism", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonConfiguration.kt */
public final class JsonConfiguration {
    public final boolean allowSpecialFloatingPointValues;
    public final boolean allowStructuredMapKeys;
    public final String classDiscriminator;
    public final boolean coerceInputValues;
    public final boolean encodeDefaults;
    public final boolean explicitNulls;
    public final boolean ignoreUnknownKeys;
    public final boolean isLenient;
    public final boolean prettyPrint;
    public final String prettyPrintIndent;
    public final boolean useAlternativeNames;
    public final boolean useArrayPolymorphism;

    public JsonConfiguration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, boolean z7, boolean z8, String str2, boolean z9, boolean z10, int i) {
        int i2 = i;
        boolean z11 = false;
        boolean z12 = (i2 & 1) != 0 ? false : z;
        boolean z13 = (i2 & 2) != 0 ? false : z2;
        boolean z14 = (i2 & 4) != 0 ? false : z3;
        boolean z15 = (i2 & 8) != 0 ? false : z4;
        boolean z16 = (i2 & 16) != 0 ? false : z5;
        boolean z17 = true;
        boolean z18 = (i2 & 32) != 0 ? true : z6;
        String str3 = null;
        String str4 = (i2 & 64) != 0 ? "    " : null;
        boolean z19 = (i2 & 128) != 0 ? false : z7;
        boolean z20 = (i2 & 256) != 0 ? false : z8;
        str3 = (i2 & 512) != 0 ? "type" : str3;
        z11 = (i2 & 1024) == 0 ? z9 : z11;
        z17 = (i2 & 2048) == 0 ? z10 : z17;
        Intrinsics.checkNotNullParameter(str4, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(str3, "classDiscriminator");
        this.encodeDefaults = z12;
        this.ignoreUnknownKeys = z13;
        this.isLenient = z14;
        this.allowStructuredMapKeys = z15;
        this.prettyPrint = z16;
        this.explicitNulls = z18;
        this.prettyPrintIndent = str4;
        this.coerceInputValues = z19;
        this.useArrayPolymorphism = z20;
        this.classDiscriminator = str3;
        this.allowSpecialFloatingPointValues = z11;
        this.useAlternativeNames = z17;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JsonConfiguration(encodeDefaults=");
        outline73.append(this.encodeDefaults);
        outline73.append(", ignoreUnknownKeys=");
        outline73.append(this.ignoreUnknownKeys);
        outline73.append(", isLenient=");
        outline73.append(this.isLenient);
        outline73.append(", allowStructuredMapKeys=");
        outline73.append(this.allowStructuredMapKeys);
        outline73.append(", prettyPrint=");
        outline73.append(this.prettyPrint);
        outline73.append(", explicitNulls=");
        outline73.append(this.explicitNulls);
        outline73.append(", prettyPrintIndent='");
        outline73.append(this.prettyPrintIndent);
        outline73.append("', coerceInputValues=");
        outline73.append(this.coerceInputValues);
        outline73.append(", useArrayPolymorphism=");
        outline73.append(this.useArrayPolymorphism);
        outline73.append(", classDiscriminator='");
        outline73.append(this.classDiscriminator);
        outline73.append("', allowSpecialFloatingPointValues=");
        return GeneratedOutlineSupport.outline65(outline73, this.allowSpecialFloatingPointValues, ')');
    }
}
