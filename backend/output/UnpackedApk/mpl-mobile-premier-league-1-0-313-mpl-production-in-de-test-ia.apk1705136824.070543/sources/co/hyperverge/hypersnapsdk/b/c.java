package co.hyperverge.hypersnapsdk.b;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: MixpanelConfig */
public class c implements Serializable {
    @SerializedName("events")

    /* renamed from: a  reason: collision with root package name */
    public d f3018a = new d();
    @SerializedName("token")

    /* renamed from: b  reason: collision with root package name */
    public String f3019b = "1860963185fe7a53c60d5c534d3b9fb6";

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar != null) {
            d dVar = this.f3018a;
            d dVar2 = cVar.f3018a;
            if (dVar != null ? !dVar.equals(dVar2) : dVar2 != null) {
                return false;
            }
            String str = this.f3019b;
            String str2 = cVar.f3019b;
            return str != null ? str.equals(str2) : str2 == null;
        }
        throw null;
    }

    public int hashCode() {
        int i;
        d dVar = this.f3018a;
        int i2 = 43;
        if (dVar == null) {
            i = 43;
        } else {
            i = dVar.hashCode();
        }
        String str = this.f3019b;
        int i3 = (i + 59) * 59;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("MixpanelConfig(mixpanelEvents=");
        outline73.append(this.f3018a);
        outline73.append(", mixpanelToken=");
        return GeneratedOutlineSupport.outline62(outline73, this.f3019b, ")");
    }
}
