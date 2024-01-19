package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;

public class cg implements ck {

    /* renamed from: a  reason: collision with root package name */
    public String f4538a;

    /* renamed from: a  reason: collision with other field name */
    public List<cg> f412a = null;

    /* renamed from: a  reason: collision with other field name */
    public String[] f413a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f4539b;

    /* renamed from: b  reason: collision with other field name */
    public String[] f414b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f4540c;

    public cg(String str, String str2, String[] strArr, String[] strArr2) {
        this.f4538a = str;
        this.f4539b = str2;
        this.f413a = strArr;
        this.f414b = strArr2;
    }

    public cg(String str, String str2, String[] strArr, String[] strArr2, String str3, List<cg> list) {
        this.f4538a = str;
        this.f4539b = str2;
        this.f413a = strArr;
        this.f414b = strArr2;
        this.f4540c = str3;
        this.f412a = list;
    }

    public static cg a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        cg cgVar = new cg(string, string2, strArr, strArr2, string3, arrayList);
        return cgVar;
    }

    public static Parcelable[] a(List<cg> list) {
        return a((cg[]) list.toArray(new cg[list.size()]));
    }

    public static Parcelable[] a(cg[] cgVarArr) {
        if (cgVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[cgVarArr.length];
        for (int i = 0; i < cgVarArr.length; i++) {
            parcelableArr[i] = cgVarArr[i].a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f4538a);
        bundle.putString("ext_ns", this.f4539b);
        bundle.putString("ext_text", this.f4540c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f413a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f413a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f414b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<cg> list = this.f412a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f412a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m568a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m569a() {
        return this.f4538a;
    }

    public String a(String str) {
        if (str != null) {
            if (this.f413a != null) {
                int i = 0;
                while (true) {
                    String[] strArr = this.f413a;
                    if (i >= strArr.length) {
                        break;
                    } else if (str.equals(strArr[i])) {
                        return this.f414b[i];
                    } else {
                        i++;
                    }
                }
            }
            return null;
        }
        throw new IllegalArgumentException();
    }

    public void a(cg cgVar) {
        if (this.f412a == null) {
            this.f412a = new ArrayList();
        }
        if (!this.f412a.contains(cgVar)) {
            this.f412a.add(cgVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m570a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = cu.a(str);
        }
        this.f4540c = str;
    }

    public String b() {
        return this.f4539b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.f4540c) ? cu.b(this.f4540c) : this.f4540c;
    }

    public String d() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("<");
        outline73.append(this.f4538a);
        if (!TextUtils.isEmpty(this.f4539b)) {
            GeneratedOutlineSupport.outline102(outline73, CMap.SPACE, "xmlns=", "\"");
            outline73.append(this.f4539b);
            outline73.append("\"");
        }
        String[] strArr = this.f413a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f413a.length; i++) {
                if (!TextUtils.isEmpty(this.f414b[i])) {
                    outline73.append(CMap.SPACE);
                    outline73.append(this.f413a[i]);
                    outline73.append("=\"");
                    outline73.append(cu.a(this.f414b[i]));
                    outline73.append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.f4540c)) {
            outline73.append(">");
            outline73.append(this.f4540c);
        } else {
            List<cg> list = this.f412a;
            if (list == null || list.size() <= 0) {
                outline73.append("/>");
                return outline73.toString();
            }
            outline73.append(">");
            for (cg d2 : this.f412a) {
                outline73.append(d2.d());
            }
        }
        outline73.append("</");
        outline73.append(this.f4538a);
        outline73.append(">");
        return outline73.toString();
    }

    public String toString() {
        return d();
    }
}
