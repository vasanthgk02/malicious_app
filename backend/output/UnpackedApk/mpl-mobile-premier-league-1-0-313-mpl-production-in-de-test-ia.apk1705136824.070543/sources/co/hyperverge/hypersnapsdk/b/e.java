package co.hyperverge.hypersnapsdk.b;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* compiled from: RemoteConfig */
public class e implements Serializable {
    @SerializedName("use_branding")

    /* renamed from: a  reason: collision with root package name */
    public boolean f3026a = true;
    @SerializedName("mixpanelConfig")

    /* renamed from: b  reason: collision with root package name */
    public c f3027b = new c();
    @SerializedName("useIpToGeo")

    /* renamed from: c  reason: collision with root package name */
    public boolean f3028c = false;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (eVar == null) {
            throw null;
        } else if (this.f3026a != eVar.f3026a || this.f3028c != eVar.f3028c) {
            return false;
        } else {
            c cVar = this.f3027b;
            c cVar2 = eVar.f3027b;
            return cVar != null ? cVar.equals(cVar2) : cVar2 == null;
        }
    }

    public int hashCode() {
        int i;
        int i2 = 79;
        int i3 = ((this.f3026a ? 79 : 97) + 59) * 59;
        if (!this.f3028c) {
            i2 = 97;
        }
        int i4 = i3 + i2;
        c cVar = this.f3027b;
        int i5 = i4 * 59;
        if (cVar == null) {
            i = 43;
        } else {
            i = cVar.hashCode();
        }
        return i5 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RemoteConfig(useBranding=");
        outline73.append(this.f3026a);
        outline73.append(", mixpanelConfig=");
        outline73.append(this.f3027b);
        outline73.append(", useIpToGeo=");
        return GeneratedOutlineSupport.outline66(outline73, this.f3028c, ")");
    }
}
