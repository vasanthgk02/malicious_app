package co.hyperverge.hypersnapsdk.b;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: MixpanelEvents */
public class d implements Serializable {
    @SerializedName("userSession")

    /* renamed from: a  reason: collision with root package name */
    public boolean f3020a = false;
    @SerializedName("instructionsScreenLaunched")

    /* renamed from: b  reason: collision with root package name */
    public boolean f3021b = false;
    @SerializedName("captureScreenLaunched")

    /* renamed from: c  reason: collision with root package name */
    public boolean f3022c = false;
    @SerializedName("captureScreenClosed")

    /* renamed from: d  reason: collision with root package name */
    public boolean f3023d = false;
    @SerializedName("captureSuccessful")

    /* renamed from: e  reason: collision with root package name */
    public boolean f3024e = false;
    @SerializedName("captureFailed")

    /* renamed from: f  reason: collision with root package name */
    public boolean f3025f = true;
    @SerializedName("oldDocReviewScreenEvents")
    public boolean g = false;
    @SerializedName("apiCallMade")
    public boolean h = false;
    @SerializedName("apiCallSuccessful")
    public boolean i = false;
    @SerializedName("apiCallFailed")
    public boolean j = false;
    @SerializedName("otherErrors")
    public boolean k = true;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar != null) {
            return this.f3020a == dVar.f3020a && this.f3021b == dVar.f3021b && this.f3022c == dVar.f3022c && this.f3023d == dVar.f3023d && this.f3024e == dVar.f3024e && this.f3025f == dVar.f3025f && this.g == dVar.g && this.h == dVar.h && this.i == dVar.i && this.j == dVar.j && this.k == dVar.k;
        }
        throw null;
    }

    public int hashCode() {
        int i2 = 79;
        int i3 = ((((((((((((((((((((this.f3020a ? 79 : 97) + 59) * 59) + (this.f3021b ? 79 : 97)) * 59) + (this.f3022c ? 79 : 97)) * 59) + (this.f3023d ? 79 : 97)) * 59) + (this.f3024e ? 79 : 97)) * 59) + (this.f3025f ? 79 : 97)) * 59) + (this.g ? 79 : 97)) * 59) + (this.h ? 79 : 97)) * 59) + (this.i ? 79 : 97)) * 59) + (this.j ? 79 : 97)) * 59;
        if (!this.k) {
            i2 = 97;
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MixpanelEvents(userSession=");
        outline73.append(this.f3020a);
        outline73.append(", instructionsScreenLaunched=");
        outline73.append(this.f3021b);
        outline73.append(", captureScreenLaunched=");
        outline73.append(this.f3022c);
        outline73.append(", captureScreenClosed=");
        outline73.append(this.f3023d);
        outline73.append(", captureSuccessful=");
        outline73.append(this.f3024e);
        outline73.append(", captureFailed=");
        outline73.append(this.f3025f);
        outline73.append(", oldDocReviewScreenEvents=");
        outline73.append(this.g);
        outline73.append(", apiCallMade=");
        outline73.append(this.h);
        outline73.append(", apiCallSuccessful=");
        outline73.append(this.i);
        outline73.append(", apiCallFailed=");
        outline73.append(this.j);
        outline73.append(", otherErrors=");
        return GeneratedOutlineSupport.outline66(outline73, this.k, ")");
    }
}
