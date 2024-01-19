package com.cardinalcommerce.cardinalmobilesdk.a.a;

import android.app.Activity;
import android.content.Context;
import co.hyperverge.hypersnapsdk.c.k;
import com.braintreepayments.api.ThreeDSecureActivity;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver;
import com.cardinalcommerce.shared.cs.userinterfaces.ChallengeUtils;

public class b extends ChallengeUtils {

    /* renamed from: b  reason: collision with root package name */
    public static final com.cardinalcommerce.cardinalmobilesdk.a.d.b f1852b = com.cardinalcommerce.cardinalmobilesdk.a.d.b.a();

    public static void a(CardinalValidateReceiver cardinalValidateReceiver, c cVar, Activity activity, CardinalConfigurationParameters cardinalConfigurationParameters, String str) {
        com.cardinalcommerce.cardinalmobilesdk.a.d.b bVar = f1852b;
        if (bVar != null) {
            bVar.b(String.valueOf(cVar.f1853a), cVar.f1854b, str);
            if (cardinalValidateReceiver != null) {
                ValidateResponse validateResponse = new ValidateResponse(false, CardinalActionCode.ERROR, cVar);
                f1852b.a(cardinalConfigurationParameters.g.toString());
                ((ThreeDSecureActivity) cardinalValidateReceiver).onValidated(activity.getApplicationContext(), validateResponse, "");
                return;
            }
            return;
        }
        throw null;
    }

    public static void a(com.cardinalcommerce.shared.cs.e.b bVar, Activity activity, CardinalConfigurationParameters cardinalConfigurationParameters, CardinalValidateReceiver cardinalValidateReceiver, String str) {
        c cVar;
        if (bVar.B.equalsIgnoreCase("Y") || bVar.B.equalsIgnoreCase("N")) {
            cVar = new c(10607);
        } else if (bVar.i.equalsIgnoreCase("N")) {
            k.a((Context) activity, bVar, cardinalConfigurationParameters.i);
            return;
        } else {
            cVar = new c(10608);
        }
        a(cardinalValidateReceiver, cVar, activity, cardinalConfigurationParameters, str);
    }
}
