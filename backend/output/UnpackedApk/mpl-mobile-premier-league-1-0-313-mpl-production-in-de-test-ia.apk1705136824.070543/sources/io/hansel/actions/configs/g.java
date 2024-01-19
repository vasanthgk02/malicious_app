package io.hansel.actions.configs;

import io.hansel.core.json.CoreJSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public Object f5068a;

    public g(CoreJSONObject coreJSONObject) {
        if (coreJSONObject != null && !coreJSONObject.isNull("v")) {
            this.f5068a = coreJSONObject.opt("v");
        }
    }

    public Object a() {
        return this.f5068a;
    }
}
