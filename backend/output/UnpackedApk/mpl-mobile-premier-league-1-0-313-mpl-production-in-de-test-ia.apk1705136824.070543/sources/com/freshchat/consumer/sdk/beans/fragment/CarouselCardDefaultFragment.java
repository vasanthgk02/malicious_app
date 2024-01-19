package com.freshchat.consumer.sdk.beans.fragment;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.ab.c;
import org.apache.commons.lang.text.ExtendedMessageFormat;

public class CarouselCardDefaultFragment extends TemplateFragment {
    @c
    public boolean selected = false;

    public CarouselCardDefaultFragment() {
        super(TemplateType.CAROUSEL_CARD_DEFAULT.asString());
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CarouselCardDefaultFragment{messageFragment='");
        GeneratedOutlineSupport.outline99(outline73, super.toString(), ExtendedMessageFormat.QUOTE, ", selected=");
        return GeneratedOutlineSupport.outline65(outline73, this.selected, '}');
    }
}
