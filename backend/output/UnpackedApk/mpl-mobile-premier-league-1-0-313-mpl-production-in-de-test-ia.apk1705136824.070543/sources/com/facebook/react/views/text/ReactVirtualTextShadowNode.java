package com.facebook.react.views.text;

public class ReactVirtualTextShadowNode extends ReactBaseTextShadowNode {
    public ReactVirtualTextShadowNode() {
        super(null);
    }

    public boolean isVirtual() {
        return true;
    }
}
