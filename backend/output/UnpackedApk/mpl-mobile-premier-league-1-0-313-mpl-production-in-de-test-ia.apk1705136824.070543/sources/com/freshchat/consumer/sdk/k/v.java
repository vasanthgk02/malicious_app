package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.FAQDetailsActivity;
import com.freshchat.consumer.sdk.beans.FAQ;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.Status;
import com.freshchat.consumer.sdk.service.e.ai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class v extends o {
    public String M = "";
    public String categoryId = "";
    public String categoryName = "";
    public Bundle h = null;
    public final List<FAQ> ri = new ArrayList();

    public v(Context context) {
        super(context);
    }

    public void aa(int i) {
        b.c(getContext(), i, this.categoryId, jj());
    }

    public Status g(Bundle bundle) {
        Status status;
        if (bundle != null) {
            try {
                ai aiVar = (ai) bundle.getParcelable("RESPONSE");
                if (aiVar != null) {
                    status = aiVar.getStatus();
                    if (status == Status.SUCCESS) {
                        if (k.isEmpty(aiVar.iV())) {
                            status = Status.COMPLETE;
                        } else {
                            this.ri.addAll(aiVar.iV());
                            jn();
                        }
                    }
                    return c(status);
                }
                throw new IllegalArgumentException("faqListFetchResponse cannot be null in FAQListViewModel::processResponse()");
            } catch (Exception e2) {
                status = Status.ERROR;
                q.a(e2);
            }
        } else {
            throw new IllegalArgumentException("bundle cannot be null in FAQListViewModel::processResponse()");
        }
    }

    public List<FAQ> iV() {
        return this.ri;
    }

    public void j(Intent intent) {
        super.j(intent);
        if (intent.hasExtra("category_name")) {
            this.categoryName = intent.getStringExtra("category_name");
        }
        if (intent.hasExtra("category_ids")) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("category_ids");
            if (k.b((Collection<?>) stringArrayListExtra) == 1) {
                this.categoryId = stringArrayListExtra.get(0);
            }
        }
        this.h = intent.getExtras();
        this.M = as.a(this.categoryName) ? this.categoryName : getContext().getString(R.string.freshchat_activity_title_article_list);
    }

    public String jE() {
        return this.M;
    }

    public String jF() {
        return getContext().getString(R.string.freshchat_no_faqs, new Object[]{this.M});
    }

    public void jG() {
        bg.a(getContext(), this.categoryId, this.categoryName, this.lE);
    }

    public void jc() {
        jo();
        this.ri.clear();
    }

    public boolean jk() {
        return k.isEmpty(this.ri);
    }

    public Intent y(String str, String str2) {
        Intent intent = new Intent(getContext(), FAQDetailsActivity.class);
        Bundle bundle = this.h;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("article_id", str);
        intent.putExtra("category_id", this.categoryId);
        intent.putExtra("EXTRA_FAQ_VIEW_TITLE", str2);
        return intent;
    }
}
