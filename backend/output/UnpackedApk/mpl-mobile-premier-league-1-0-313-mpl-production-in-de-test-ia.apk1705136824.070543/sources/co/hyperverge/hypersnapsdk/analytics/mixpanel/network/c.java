package co.hyperverge.hypersnapsdk.analytics.mixpanel.network;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;

/* compiled from: MixPanelErrorResponse */
public class c {
    @SerializedName("error")

    /* renamed from: a  reason: collision with root package name */
    public String f3014a;
    @SerializedName("status")

    /* renamed from: b  reason: collision with root package name */
    public String f3015b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar != null) {
            String str = this.f3014a;
            String str2 = cVar.f3014a;
            if (str != null ? !str.equals(str2) : str2 != null) {
                return false;
            }
            String str3 = this.f3015b;
            String str4 = cVar.f3015b;
            return str3 != null ? str3.equals(str4) : str4 == null;
        }
        throw null;
    }

    public int hashCode() {
        int i;
        String str = this.f3014a;
        int i2 = 43;
        if (str == null) {
            i = 43;
        } else {
            i = str.hashCode();
        }
        String str2 = this.f3015b;
        int i3 = (i + 59) * 59;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MixPanelErrorResponse(error=");
        outline73.append(this.f3014a);
        outline73.append(", status=");
        return GeneratedOutlineSupport.outline62(outline73, this.f3015b, ")");
    }
}
