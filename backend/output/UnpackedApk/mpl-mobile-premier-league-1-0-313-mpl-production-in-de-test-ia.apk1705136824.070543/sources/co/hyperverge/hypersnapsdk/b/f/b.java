package co.hyperverge.hypersnapsdk.b.f;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: FeatureConfigResponse */
public class b {
    @SerializedName("features")

    /* renamed from: a  reason: collision with root package name */
    public List<a> f3035a;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar != null) {
            List<a> list = this.f3035a;
            List<a> list2 = bVar.f3035a;
            return list != null ? list.equals(list2) : list2 == null;
        }
        throw null;
    }

    public int hashCode() {
        int i;
        List<a> list = this.f3035a;
        if (list == null) {
            i = 43;
        } else {
            i = list.hashCode();
        }
        return i + 59;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline64(GeneratedOutlineSupport.outline73("FeatureConfigResponse(features="), this.f3035a, ")");
    }
}
