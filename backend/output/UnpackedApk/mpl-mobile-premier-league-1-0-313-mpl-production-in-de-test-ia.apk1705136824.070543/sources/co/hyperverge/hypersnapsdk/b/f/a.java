package co.hyperverge.hypersnapsdk.b.f;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: FeatureConfig */
public class a {
    @SerializedName("id")

    /* renamed from: a  reason: collision with root package name */
    public String f3029a;
    @SerializedName("enable")

    /* renamed from: b  reason: collision with root package name */
    public boolean f3030b;
    @SerializedName("override")

    /* renamed from: c  reason: collision with root package name */
    public List<b> f3031c;

    /* compiled from: FeatureConfig */
    public static class b {
        @SerializedName("brand")

        /* renamed from: a  reason: collision with root package name */
        public String f3032a;
        @SerializedName("enable")

        /* renamed from: b  reason: collision with root package name */
        public boolean f3033b;
        @SerializedName("models")

        /* renamed from: c  reason: collision with root package name */
        public List<String> f3034c;

        public b(String str, boolean z, List<String> list) {
            this.f3032a = str;
            this.f3033b = z;
            this.f3034c = list;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar == null) {
                throw null;
            } else if (this.f3033b != bVar.f3033b) {
                return false;
            } else {
                String str = this.f3032a;
                String str2 = bVar.f3032a;
                if (str != null ? !str.equals(str2) : str2 != null) {
                    return false;
                }
                List<String> list = this.f3034c;
                List<String> list2 = bVar.f3034c;
                return list != null ? list.equals(list2) : list2 == null;
            }
        }

        public int hashCode() {
            int i;
            int i2 = this.f3033b ? 79 : 97;
            String str = this.f3032a;
            int i3 = (i2 + 59) * 59;
            int i4 = 43;
            if (str == null) {
                i = 43;
            } else {
                i = str.hashCode();
            }
            int i5 = i3 + i;
            List<String> list = this.f3034c;
            int i6 = i5 * 59;
            if (list != null) {
                i4 = list.hashCode();
            }
            return i6 + i4;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("FeatureConfig.Override(brand=");
            outline73.append(this.f3032a);
            outline73.append(", enable=");
            outline73.append(this.f3033b);
            outline73.append(", models=");
            return GeneratedOutlineSupport.outline64(outline73, this.f3034c, ")");
        }
    }

    public a(String str, boolean z, List<b> list) {
        this.f3029a = str;
        this.f3030b = z;
        this.f3031c = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar == null) {
            throw null;
        } else if (this.f3030b != aVar.f3030b) {
            return false;
        } else {
            String str = this.f3029a;
            String str2 = aVar.f3029a;
            if (str != null ? !str.equals(str2) : str2 != null) {
                return false;
            }
            List<b> list = this.f3031c;
            List<b> list2 = aVar.f3031c;
            return list != null ? list.equals(list2) : list2 == null;
        }
    }

    public int hashCode() {
        int i;
        int i2 = this.f3030b ? 79 : 97;
        String str = this.f3029a;
        int i3 = (i2 + 59) * 59;
        int i4 = 43;
        if (str == null) {
            i = 43;
        } else {
            i = str.hashCode();
        }
        int i5 = i3 + i;
        List<b> list = this.f3031c;
        int i6 = i5 * 59;
        if (list != null) {
            i4 = list.hashCode();
        }
        return i6 + i4;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FeatureConfig(id=");
        outline73.append(this.f3029a);
        outline73.append(", enable=");
        outline73.append(this.f3030b);
        outline73.append(", overrides=");
        return GeneratedOutlineSupport.outline64(outline73, this.f3031c, ")");
    }
}
