package com.freshchat.consumer.sdk.j;

import android.os.Bundle;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.ArticleDetailActivity;
import com.freshchat.consumer.sdk.activity.ArticleListActivity;
import com.freshchat.consumer.sdk.activity.CategoryListActivity;
import com.freshchat.consumer.sdk.activity.FAQCategoriesActivity;
import com.freshchat.consumer.sdk.activity.FAQListActivity;
import com.freshchat.consumer.sdk.activity.FAQSearchActivity;
import com.freshchat.consumer.sdk.activity.InterstitialActivity;
import com.freshchat.consumer.sdk.b.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class v extends c<FaqOptions> {
    private Class ja() {
        return y.cp(getContext()) ? FAQCategoriesActivity.class : CategoryListActivity.class;
    }

    private Class jb() {
        return y.cp(getContext()) ? FAQListActivity.class : ArticleListActivity.class;
    }

    public void a(String str, String str2, String[] strArr) {
        a(jb());
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("category_ids", arrayList);
        bundle.putString("category_name", str2);
        bundle.putStringArray("INPUT_TAGS", strArr);
        b(bundle);
    }

    public void aE() {
        FaqOptions faqOptions = (FaqOptions) ec();
        if (faqOptions == null || !k.a(faqOptions.getContactUsTags())) {
            Freshchat.showConversations(getContext());
            return;
        }
        ConversationOptions conversationOptions = new ConversationOptions();
        conversationOptions.filterByTags(faqOptions.getContactUsTags(), faqOptions.getContactUsViewTitle());
        Freshchat.showConversations(getContext(), conversationOptions);
    }

    public void b(ArrayList<String> arrayList) {
        a(ArticleListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("force_search_open", true);
        if (k.a(arrayList)) {
            bundle.putStringArrayList("category_ids", arrayList);
        }
        b(bundle);
    }

    public void e(String[] strArr) {
        a(ArticleListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("force_search_open", true);
        if (as.f(strArr)) {
            bundle.putStringArray("INPUT_TAGS", strArr);
        }
        b(bundle);
    }

    public void ea() {
        ev();
    }

    public Bundle eb() {
        Bundle bundle = new Bundle();
        bundle.putAll(u.a((FaqOptions) ec()));
        bundle.putString("OPTIONS_TYPE", FaqOptions.class.getSimpleName());
        return bundle;
    }

    public void eu() {
        a(ja());
        FaqOptions faqOptions = (FaqOptions) ec();
        if (faqOptions != null && k.a(faqOptions.getTags())) {
            faqOptions.filterByTags(null, null, null);
        }
        b(null);
    }

    public void ev() {
        a(InterstitialActivity.class);
        b(null);
    }

    public void iY() {
        a(FAQCategoriesActivity.class);
        b(null);
    }

    public void iZ() {
        a(FAQSearchActivity.class);
        b(null);
    }

    public void w(List<String> list) {
        if (k.b((Collection<?>) list) == 0) {
            i.e(getContext(), getContext().getString(R.string.freshchat_error_no_matching_faq_categories_found));
            eu();
            return;
        }
        a(CategoryListActivity.class);
        b(null);
    }

    public void x(List<String> list) {
        int b2 = k.b((Collection<?>) list);
        if (b2 == 0) {
            i.e(getContext(), getContext().getString(R.string.freshchat_error_no_matching_faqs_found));
            eu();
        } else if (b2 == 1) {
            a(ArticleDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putLong("article_id", Long.parseLong(list.get(0)));
            b(bundle);
        } else {
            a(ArticleListActivity.class);
            b(new Bundle());
        }
    }
}
