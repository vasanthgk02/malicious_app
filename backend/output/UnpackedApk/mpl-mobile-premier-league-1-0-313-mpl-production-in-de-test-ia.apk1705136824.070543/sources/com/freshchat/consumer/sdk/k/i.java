package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.net.Uri;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.ImageFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import com.freshchat.consumer.sdk.j.aj;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.cg;

public class i extends a {
    public CarouselCardDefaultFragment oe = null;

    public enum a {
        PRE_SELECTED_CARD,
        CARD_WITH_CALLBACK_ONLY,
        CARD_WITH_CALLBACK_AND_VIEW_OPTION;
        
        public static a oi;

        /* access modifiers changed from: public */
        static {
            a aVar;
            oi = aVar;
        }
    }

    public i(Context context) {
        super(context);
    }

    private ImageFragment hr() {
        MessageFragment b2 = cg.b(this.oe, SectionKey.CAROUSEL_CARD_HERO_IMAGE);
        if (b2 instanceof ImageFragment) {
            return (ImageFragment) b2;
        }
        return null;
    }

    public int I(int i) {
        ImageFragment hr = hr();
        return (hr == null || hr.getWidth() == 0) ? i : hr.getWidth();
    }

    public int J(int i) {
        ImageFragment hr = hr();
        return (hr == null || hr.getHeight() == 0) ? i : hr.getHeight();
    }

    public String bl(String str) {
        return cg.a(this.oe, SectionKey.CAROUSEL_CARD_CALLBACK, str);
    }

    public String bm(String str) {
        return cg.a(this.oe, SectionKey.CAROUSEL_CARD_VIEW, str);
    }

    public String getDescription() {
        return cg.a(this.oe, SectionKey.CAROUSEL_CARD_DESCRIPTION);
    }

    public String getTitle() {
        return cg.a(this.oe, SectionKey.CAROUSEL_CARD_TITLE);
    }

    public CarouselCardDefaultFragment hn() {
        return this.oe;
    }

    public String ho() {
        String a2 = cg.a(this.oe, SectionKey.CAROUSEL_CARD_HERO_IMAGE);
        if (as.a(a2)) {
            return a2;
        }
        return null;
    }

    public a hp() {
        CarouselCardDefaultFragment carouselCardDefaultFragment = this.oe;
        if (carouselCardDefaultFragment != null) {
            if (carouselCardDefaultFragment.isSelected()) {
                return a.PRE_SELECTED_CARD;
            }
            if (cg.b(this.oe, SectionKey.CAROUSEL_CARD_VIEW) != null) {
                return a.CARD_WITH_CALLBACK_AND_VIEW_OPTION;
            }
        }
        return a.oi;
    }

    public Uri hq() {
        MessageFragment b2 = cg.b(this.oe, SectionKey.CAROUSEL_CARD_VIEW);
        if (!(b2 instanceof ButtonFragment)) {
            return null;
        }
        return aj.b((ButtonFragment) b2);
    }

    public void hs() {
        if (this.oe != null) {
            bg.b(getContext(), this.oe);
        }
    }

    public void setData(CarouselCardDefaultFragment carouselCardDefaultFragment) {
        this.oe = carouselCardDefaultFragment;
    }

    public boolean x(String str, String str2) {
        boolean z = true;
        if (hp() != a.CARD_WITH_CALLBACK_AND_VIEW_OPTION) {
            return true;
        }
        if (as.b(bl(str)) > 7 || as.b(bm(str2)) > 7) {
            z = false;
        }
        return z;
    }
}
