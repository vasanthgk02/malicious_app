package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.activity.FAQDetailsActivity;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.i.d;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class w extends o {
    public Bundle h = null;
    public final int rB = 250;
    public final d rC = new x(this, 250);
    public final List<FAQ> ri = new ArrayList();
    public String rj;

    public w(Context context) {
        super(context);
    }

    private boolean jI() {
        return bz(this.rj);
    }

    public void C(boolean z) {
        bg.a(getContext(), this.rj, k.b((Collection<?>) this.ri), z);
    }

    public void aa(int i) {
        List<String> jj = jj();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("fetchPageData called for search term : ");
        outline73.append(this.rj);
        outline73.append(" page index : ");
        outline73.append(i);
        ai.d("FAQSearchViewModel", outline73.toString());
        b.a(getContext(), this.rj, i, jj);
    }

    public Intent ac(int i) {
        FAQ faq = iV().get(i);
        if (faq == null) {
            return null;
        }
        Intent intent = new Intent(getContext(), FAQDetailsActivity.class);
        Bundle bundle = this.h;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("article_id", faq.getId());
        intent.putExtra("category_id", faq.getCategoryId());
        intent.putExtra("EXTRA_FAQ_VIEW_TITLE", faq.getTitle());
        return intent;
    }

    public boolean bA(String str) {
        String aH = as.aH(str);
        this.rj = aH;
        return bz(aH);
    }

    public boolean bB(String str) {
        return as.o(this.rj, as.aH(str));
    }

    public void bC(String str) {
        if (as.a(this.rj) && this.rj.length() != 1 && as.isEmpty(str)) {
            C(false);
        }
    }

    public boolean bz(String str) {
        return as.b(str) >= 3;
    }

    public Status g(Bundle bundle) {
        Status status;
        if (!jI()) {
            return null;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("processResponse called for search string  : ");
        outline73.append(this.rj);
        ai.d("FAQSearchViewModel", outline73.toString());
        if (bundle != null) {
            try {
                if (as.p(bundle.getString("SEARCH_TERM"), this.rj)) {
                    return null;
                }
                com.freshchat.consumer.sdk.service.e.ai aiVar = (com.freshchat.consumer.sdk.service.e.ai) bundle.getParcelable("RESPONSE");
                if (aiVar != null) {
                    status = aiVar.getStatus();
                    if (status == Status.SUCCESS) {
                        if (k.isEmpty(aiVar.iV())) {
                            status = Status.COMPLETE;
                        } else {
                            this.ri.addAll(aiVar.iV());
                            ai.d("FAQSearchViewModel", " process result list size  : " + aiVar.iV().size());
                            jn();
                        }
                    }
                    return c(status);
                }
                throw new IllegalArgumentException("faqListFetchResponse cannot be null in FAQSearchViewModel::processResponse()");
            } catch (Exception e2) {
                status = Status.ERROR;
                q.a(e2);
            }
        } else {
            throw new IllegalArgumentException("bundle cannot be null in FAQSearchViewModel::processResponse()");
        }
    }

    public List<FAQ> iV() {
        return this.ri;
    }

    public void j(Intent intent) {
        super.j(intent);
        this.h = intent.getExtras();
        this.rj = intent.getStringExtra("search_key");
    }

    public Status jH() {
        Status status;
        if (al.aS(getContext())) {
            this.rC.run();
            status = Status.INIT_LOADING;
        } else {
            status = Status.NO_INTERNET;
        }
        return c(status);
    }

    public void jJ() {
        jo();
        this.ri.clear();
        je();
    }

    public boolean jK() {
        return jk() && this.rr == Status.COMPLETE;
    }

    public void jc() {
        jo();
        this.ri.clear();
    }

    public boolean jk() {
        return k.isEmpty(this.ri);
    }
}
