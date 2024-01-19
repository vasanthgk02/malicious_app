package com.cardinalcommerce.dependencies.internal.minidev.json;

public interface JSONStreamAwareEx extends JSONStreamAware {
    void writeJSONString(Appendable appendable, JSONStyle jSONStyle);
}
