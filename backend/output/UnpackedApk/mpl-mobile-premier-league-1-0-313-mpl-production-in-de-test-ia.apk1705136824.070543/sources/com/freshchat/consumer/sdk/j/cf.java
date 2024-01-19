package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import java.util.List;

public class cf {

    public enum a {
        NORMAL(0),
        CAROUSEL(1),
        CAROUSEL_CARD(2),
        CALENDAR_EVENT(3);
        
        public static final a ob = null;
        public int oc;

        /* access modifiers changed from: public */
        static {
            a aVar;
            ob = aVar;
        }

        /* access modifiers changed from: public */
        a(int i) {
            this.oc = i;
        }

        public int asInt() {
            return this.oc;
        }
    }

    public static a a(Message message, boolean z, boolean z2) {
        return message == null ? a.ob : (!z || z2 || l(message) == null) ? m(message) != null ? a.CAROUSEL_CARD : cm.s(message) != null ? a.CALENDAR_EVENT : a.ob : a.CAROUSEL;
    }

    public static List<MessageFragment> k(Message message) {
        CarouselFragment l = l(message);
        if (l == null) {
            return null;
        }
        return l.getFragmentsForSection(SectionKey.CAROUSEL_CARDS);
    }

    public static CarouselFragment l(Message message) {
        if (message != null && k.a(message.getReplyFragments())) {
            MessageFragment messageFragment = message.getReplyFragments().get(0);
            if (messageFragment instanceof CarouselFragment) {
                return (CarouselFragment) messageFragment;
            }
        }
        return null;
    }

    public static CarouselCardDefaultFragment m(Message message) {
        if (message != null && k.a(message.getMessageFragments()) && (message.getMessageFragments().get(0) instanceof CarouselCardDefaultFragment)) {
            return (CarouselCardDefaultFragment) message.getMessageFragments().get(0);
        }
        return null;
    }
}
