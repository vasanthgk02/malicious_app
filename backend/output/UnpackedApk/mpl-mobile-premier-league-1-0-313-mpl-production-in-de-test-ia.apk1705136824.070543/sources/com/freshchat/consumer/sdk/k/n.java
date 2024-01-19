package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.content.Intent;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.FaqOptions.FilterType;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.Status;
import java.util.ArrayList;
import java.util.List;

public abstract class n extends a {
    public FaqOptions g = new FaqOptions();
    public String[] lE;
    public String rq;
    public Status rr;

    public n(Context context) {
        super(context);
    }

    public String getFilteredViewTitle() {
        return this.g.getFilteredViewTitle();
    }

    public void j(Intent intent) {
        if (intent.getExtras() != null) {
            this.g = u.d(intent.getExtras());
            this.lE = intent.getStringArrayExtra("INPUT_TAGS");
        }
    }

    public abstract void jc();

    public abstract Status jd();

    public void je() {
        this.rr = null;
    }

    public Status jf() {
        String bc = ah.bc(getContext());
        if (as.isEmpty(this.rq)) {
            this.rq = bc;
            return null;
        } else if (as.o(this.rq, bc)) {
            return null;
        } else {
            this.rq = bc;
            jc();
            je();
            return jd();
        }
    }

    public void jg() {
        v r = r();
        if (r != null) {
            r.aE();
        }
    }

    public void jh() {
        v r = r();
        if (r != null) {
            r.iZ();
        }
    }

    public List<String> ji() {
        if (!k.a(this.g.getTags()) || this.g.getFilterType() != FilterType.CATEGORY) {
            return null;
        }
        return new ArrayList(this.g.getTags());
    }

    public List<String> jj() {
        if (!k.a(this.g.getTags()) || this.g.getFilterType() != FilterType.ARTICLE) {
            return null;
        }
        return new ArrayList(this.g.getTags());
    }

    public v r() {
        return aa.a(getContext(), this.g);
    }

    public boolean shouldShowContactUsOnAppBar() {
        return this.g.shouldShowContactUsOnAppBar();
    }

    public boolean shouldShowContactUsOnFaqNotHelpful() {
        return this.g.shouldShowContactUsOnFaqNotHelpful();
    }

    public boolean shouldShowContactUsOnFaqScreens() {
        return this.g.shouldShowContactUsOnFaqScreens();
    }

    public boolean shouldShowFaqCategoriesAsGrid() {
        return this.g.shouldShowFaqCategoriesAsGrid();
    }
}
