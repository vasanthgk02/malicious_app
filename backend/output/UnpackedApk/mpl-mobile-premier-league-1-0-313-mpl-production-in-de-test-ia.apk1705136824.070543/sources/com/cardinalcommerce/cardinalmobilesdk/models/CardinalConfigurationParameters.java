package com.cardinalcommerce.cardinalmobilesdk.models;

import com.cardinalcommerce.cardinalmobilesdk.a.d.b;
import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment;
import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType;
import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import org.json.JSONArray;

public class CardinalConfigurationParameters {

    /* renamed from: a  reason: collision with root package name */
    public int f1892a = 8000;

    /* renamed from: b  reason: collision with root package name */
    public int f1893b = 5;

    /* renamed from: c  reason: collision with root package name */
    public String f1894c = "";

    /* renamed from: d  reason: collision with root package name */
    public CardinalUiType f1895d = CardinalUiType.BOTH;

    /* renamed from: e  reason: collision with root package name */
    public JSONArray f1896e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1897f = false;
    public CardinalEnvironment g = CardinalEnvironment.PRODUCTION;
    public String h = "";
    public UiCustomization i = new UiCustomization();
    public boolean j = true;
    public final b k = b.a();
    public boolean l = true;

    public CardinalConfigurationParameters() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(CardinalRenderType.OTP);
        jSONArray.put(CardinalRenderType.SINGLE_SELECT);
        jSONArray.put(CardinalRenderType.MULTI_SELECT);
        jSONArray.put(CardinalRenderType.OOB);
        jSONArray.put(CardinalRenderType.HTML);
        this.f1896e = jSONArray;
    }
}
