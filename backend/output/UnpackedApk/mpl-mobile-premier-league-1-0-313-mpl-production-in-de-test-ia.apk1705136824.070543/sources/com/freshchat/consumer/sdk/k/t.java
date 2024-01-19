package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.FAQCategory;
import com.freshchat.consumer.sdk.beans.FAQCategoryFetchResponse;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.service.Status;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.FTPReply;

public class t extends o {
    public String M;
    public final List<FAQCategory> ry = new ArrayList();

    public t(Context context) {
        super(context);
    }

    public int a(WindowManager windowManager) {
        return Math.round((float) (af.i(getContext(), p.ar(getContext())) / (p.a(getContext(), windowManager) ? 200 : FTPReply.FILE_STATUS_OK)));
    }

    public void aa(int i) {
        b.b(getContext(), i, ji());
    }

    public void ab(int i) {
        v r = r();
        if (r != null) {
            List<FAQCategory> jt = jt();
            if (k.a(jt)) {
                FAQCategory fAQCategory = jt.get(i);
                if (fAQCategory != null) {
                    r.a(fAQCategory.getCategoryId(), fAQCategory.getTitle(), this.lE);
                }
            }
        }
    }

    public Status g(Bundle bundle) {
        Status status;
        if (bundle != null) {
            try {
                FAQCategoryFetchResponse fAQCategoryFetchResponse = (FAQCategoryFetchResponse) bundle.getParcelable("RESPONSE");
                if (fAQCategoryFetchResponse != null) {
                    status = fAQCategoryFetchResponse.getStatus();
                    if (status == Status.SUCCESS) {
                        if (k.isEmpty(fAQCategoryFetchResponse.getCategoryList())) {
                            status = Status.COMPLETE;
                        } else {
                            this.ry.addAll(fAQCategoryFetchResponse.getCategoryList());
                            jn();
                        }
                    }
                    return c(status);
                }
                throw new IllegalArgumentException("faqCategoryFetchResponse cannot be null in FAQCategoriesViewModel::processResponse()");
            } catch (Exception e2) {
                q.a(e2);
                status = Status.ERROR;
            }
        } else {
            throw new IllegalArgumentException("bundle cannot be null in FAQCategoriesViewModel::processResponse()");
        }
    }

    public String getTitle() {
        return this.M;
    }

    public void j(Intent intent) {
        super.j(intent);
        this.M = as.a(getFilteredViewTitle()) ? getFilteredViewTitle() : getContext().getString(R.string.freshchat_activity_title_category_list);
    }

    public void jc() {
        jo();
        this.ry.clear();
    }

    public boolean jk() {
        return k.isEmpty(this.ry);
    }

    public void js() {
        bg.c(getContext(), this.lE);
    }

    public List<FAQCategory> jt() {
        return this.ry;
    }

    public String ju() {
        return getContext().getString(R.string.freshchat_no_faq_categories);
    }
}
