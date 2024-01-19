package com.freshchat.consumer.sdk.c.a;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.freshchat.consumer.sdk.beans.ColDef;
import com.freshchat.consumer.sdk.j.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.fontbox.cmap.CMap;

public abstract class c implements h {
    private Set<Integer> fN() {
        HashSet hashSet = new HashSet();
        for (ColDef versionNumber : cO()) {
            hashSet.add(Integer.valueOf(versionNumber.getVersionNumber()));
        }
        return hashSet;
    }

    public static List<String> m(int i) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : n.eq) {
            if (hVar.fL() <= i) {
                arrayList.add(hVar.cT());
                arrayList.add(hVar.n(i));
            }
        }
        return arrayList;
    }

    public static List<String> q(int i) {
        ArrayList arrayList = new ArrayList();
        for (h hVar : n.eq) {
            int fL = hVar.fL();
            int fM = hVar.fM();
            if (fL <= i && fM >= i) {
                if (fL == i) {
                    arrayList.add(hVar.cT());
                    arrayList.add(hVar.n(i));
                } else if (fL < fM) {
                    for (ColDef colDef : hVar.cO()) {
                        if (colDef.getVersionNumber() == i) {
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("ALTER TABLE ");
                            outline73.append(hVar.cP());
                            outline73.append(" ADD COLUMN ");
                            outline73.append(colDef.getColumnDefForQuery());
                            arrayList.add(outline73.toString());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final String[] cR() {
        ColDef[] cO = cO();
        String[] strArr = new String[cO.length];
        int length = cO.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            strArr[i2] = cO[i].getColumnName();
            i++;
            i2++;
        }
        return strArr;
    }

    public final String cS() {
        return k(true);
    }

    public final String cT() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("DROP TABLE IF EXISTS ");
        outline73.append(cP());
        outline73.append(";");
        return outline73.toString();
    }

    public String cU() {
        return "";
    }

    public final int fL() {
        return ((Integer) Collections.min(fN())).intValue();
    }

    public final int fM() {
        return ((Integer) Collections.max(fN())).intValue();
    }

    public final String k(boolean z) {
        StringBuilder sb = new StringBuilder();
        String[] cR = cR();
        sb.append("INSERT");
        sb.append(z ? " OR REPLACE " : CMap.SPACE);
        sb.append(" INTO ");
        sb.append(cP());
        sb.append("(");
        GeneratedOutlineSupport.outline103(sb, as.a(cR, ","), ")", " VALUES ", "(");
        sb.append(as.a(ColorPropConverter.PREFIX_ATTR, ",", cR.length));
        sb.append(");");
        return sb.toString();
    }

    public final String n(int i) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CREATE TABLE IF NOT EXISTS ");
        outline73.append(cP());
        outline73.append("(");
        String str = "";
        for (ColDef colDef : cO()) {
            if (colDef.getVersionNumber() <= i) {
                outline73.append(str);
                outline73.append(colDef.getColumnDefForQuery());
                str = ",";
            }
        }
        if (as.a(cU())) {
            outline73.append(",");
            outline73.append(cU());
        }
        outline73.append(")");
        return outline73.toString();
    }
}
