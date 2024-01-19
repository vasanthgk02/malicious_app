package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.Event.EventName;
import com.freshchat.consumer.sdk.Event.Property;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.j.ab.d;
import com.freshchat.consumer.sdk.j.bg.a;
import com.freshchat.consumer.sdk.j.bg.b;

public final class ce implements b {
    public final /* synthetic */ CarouselCardDefaultFragment jY;

    public ce(CarouselCardDefaultFragment carouselCardDefaultFragment) {
        this.jY = carouselCardDefaultFragment;
    }

    public Event gy() {
        String json = new ab(new d()).toJson(this.jY);
        a b2 = bg.a(EventName.FCEventCarouselOptionSelect);
        if (as.a(json)) {
            b2.a(Property.FCPropertyOption, json);
        }
        return b2.gz();
    }
}
