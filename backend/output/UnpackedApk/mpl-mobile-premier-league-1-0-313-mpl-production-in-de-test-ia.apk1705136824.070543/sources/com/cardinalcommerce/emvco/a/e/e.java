package com.cardinalcommerce.emvco.a.e;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.cardinalcommerce.shared.cs.d.a;
import org.json.JSONException;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public final com.cardinalcommerce.emvco.a.g.a f2066a = com.cardinalcommerce.emvco.a.g.a.a();

    public e(com.cardinalcommerce.shared.cs.e.e eVar, String str) {
        try {
            b.a();
            super.a(str, eVar.e().toString(), 8000);
        } catch (JSONException e2) {
            com.cardinalcommerce.emvco.a.g.a aVar = this.f2066a;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Exception while executing task \n");
            outline73.append(e2.getLocalizedMessage());
            aVar.b(String.valueOf(11421), outline73.toString());
        }
    }

    public void a(Exception exc, com.cardinalcommerce.shared.cs.b.a aVar) {
        this.f2066a.b(String.valueOf(11421), GeneratedOutlineSupport.outline38(exc, GeneratedOutlineSupport.outline73("Exception while executing task \n")));
    }

    public void a(String str) {
        this.f2066a.a("EMVCoTransaction", "Error Task Ended");
    }

    public void a(String str, int i) {
        this.f2066a.b(String.valueOf(11421), GeneratedOutlineSupport.outline50("Exception while executing task \n", str));
    }
}
