package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public class dr implements ef<dr, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final em f4686a = new em("", 15, 1);

    /* renamed from: a  reason: collision with other field name */
    public static final eu f585a = new eu("XmPushActionCustomConfig");

    /* renamed from: a  reason: collision with other field name */
    public List<dg> f586a;

    /* JADX WARNING: type inference failed for: r0v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r1v1, types: [boolean] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v2, types: [boolean]
      assigns: [java.util.List<com.xiaomi.push.dg>]
      uses: [boolean]
      mth insns count: 25
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(com.xiaomi.push.dr r3) {
        /*
            r2 = this;
            java.lang.Class<com.xiaomi.push.dr> r0 = com.xiaomi.push.dr.class
            java.lang.Class r1 = r3.getClass()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001d
            java.lang.Class<com.xiaomi.push.dr> r3 = com.xiaomi.push.dr.class
            java.lang.String r3 = r3.getName()
            java.lang.Class<com.xiaomi.push.dr> r0 = com.xiaomi.push.dr.class
            java.lang.String r0 = r0.getName()
            int r3 = r3.compareTo(r0)
            return r3
        L_0x001d:
            boolean r0 = r2.a()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r1 = r3.a()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            int r0 = r0.compareTo(r1)
            if (r0 == 0) goto L_0x0034
            return r0
        L_0x0034:
            boolean r0 = r2.a()
            if (r0 == 0) goto L_0x0045
            java.util.List<com.xiaomi.push.dg> r0 = r2.f586a
            java.util.List<com.xiaomi.push.dg> r3 = r3.f586a
            int r3 = com.xiaomi.push.eg.a(r0, r3)
            if (r3 == 0) goto L_0x0045
            return r3
        L_0x0045:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dr.compareTo(com.xiaomi.push.dr):int");
    }

    public List<dg> a() {
        return this.f586a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m651a() {
        if (this.f586a == null) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Required field 'customConfigs' was not present! Struct: ");
            outline73.append(toString());
            throw new eq(outline73.toString());
        }
    }

    public void a(ep epVar) {
        epVar.a();
        while (true) {
            em a2 = epVar.a();
            byte b2 = a2.f4765a;
            if (b2 == 0) {
                epVar.f();
                a();
                return;
            }
            if (a2.f755a == 1 && b2 == 15) {
                en a3 = epVar.a();
                this.f586a = new ArrayList(a3.f756a);
                for (int i = 0; i < a3.f756a; i++) {
                    dg dgVar = new dg();
                    dgVar.a(epVar);
                    this.f586a.add(dgVar);
                }
                epVar.i();
            } else {
                es.a(epVar, b2);
            }
            epVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m652a() {
        return this.f586a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m653a(dr drVar) {
        if (drVar == null) {
            return false;
        }
        List<dg> a2 = a();
        List<dg> a3 = drVar.a();
        return (a2 == null && a3 == null) || !(a2 == null || a3 == null || !this.f586a.equals(drVar.f586a));
    }

    public void b(ep epVar) {
        a();
        epVar.a(f585a);
        if (this.f586a != null) {
            epVar.a(f4686a);
            epVar.a(new en(MqttWireMessage.MESSAGE_TYPE_PINGREQ, this.f586a.size()));
            for (dg b2 : this.f586a) {
                b2.b(epVar);
            }
            epVar.e();
            epVar.b();
        }
        epVar.c();
        epVar.a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof dr)) {
            return compareTo((dr) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder outline77 = GeneratedOutlineSupport.outline77("XmPushActionCustomConfig(", "customConfigs:");
        List<dg> list = this.f586a;
        if (list == null) {
            outline77.append("null");
        } else {
            outline77.append(list);
        }
        outline77.append(")");
        return outline77.toString();
    }
}
