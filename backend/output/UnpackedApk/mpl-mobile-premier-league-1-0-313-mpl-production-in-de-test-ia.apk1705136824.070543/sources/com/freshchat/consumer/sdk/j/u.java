package com.freshchat.consumer.sdk.j;

import android.os.Bundle;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.FaqOptions.FilterType;
import java.util.ArrayList;

public class u {
    public static Bundle a(FaqOptions faqOptions) {
        Bundle bundle = new Bundle();
        if (faqOptions != null) {
            bundle.putBoolean("SHOW_FAQ_CATEGORY_AS_GRID", faqOptions.shouldShowFaqCategoriesAsGrid());
            bundle.putBoolean("SHOW_CONTACT_US_ON_FAQ_SCREENS", faqOptions.shouldShowContactUsOnFaqScreens());
            bundle.putBoolean("SHOW_CONTACT_US_ON_SEARCH_AND_DOWN_VOTE", faqOptions.shouldShowContactUsOnFaqNotHelpful());
            bundle.putBoolean("SHOW_CONTACT_US_ON_APP_BAR", faqOptions.shouldShowContactUsOnAppBar());
            ArrayList arrayList = new ArrayList(faqOptions.getTags());
            if (arrayList.size() > 0) {
                bundle.putStringArrayList("FAQ_TAG_LIST", arrayList);
            }
            if (!as.isEmpty(faqOptions.getFilteredViewTitle())) {
                bundle.putString("FAQ_TAG_VIEW_TITLE", faqOptions.getFilteredViewTitle());
            }
            if (faqOptions.getFilterType() != null) {
                bundle.putString("FAQ_TAG_TYPE", faqOptions.getFilterType().toString());
            }
            ArrayList arrayList2 = new ArrayList(faqOptions.getContactUsTags());
            if (arrayList2.size() > 0) {
                bundle.putStringArrayList("FAQ_CONTACT_US_FILTER_TAGS_LIST", arrayList2);
            }
            if (!as.isEmpty(faqOptions.getContactUsViewTitle())) {
                bundle.putString("FAQ_CONTACT_US_FILTER_TITLE", faqOptions.getContactUsViewTitle());
            }
        }
        return bundle;
    }

    public static FaqOptions d(Bundle bundle) {
        FaqOptions faqOptions = new FaqOptions();
        if (bundle != null) {
            faqOptions.showFaqCategoriesAsGrid(bundle.getBoolean("SHOW_FAQ_CATEGORY_AS_GRID", faqOptions.shouldShowFaqCategoriesAsGrid()));
            faqOptions.showContactUsOnFaqScreens(bundle.getBoolean("SHOW_CONTACT_US_ON_FAQ_SCREENS", faqOptions.shouldShowContactUsOnFaqScreens()));
            faqOptions.showContactUsOnFaqNotHelpful(bundle.getBoolean("SHOW_CONTACT_US_ON_SEARCH_AND_DOWN_VOTE", faqOptions.shouldShowContactUsOnFaqNotHelpful()));
            faqOptions.showContactUsOnAppBar(bundle.getBoolean("SHOW_CONTACT_US_ON_APP_BAR", faqOptions.shouldShowContactUsOnAppBar()));
            if (bundle.containsKey("FAQ_TAG_LIST")) {
                faqOptions.filterByTags(bundle.getStringArrayList("FAQ_TAG_LIST"), bundle.getString("FAQ_TAG_VIEW_TITLE"), FilterType.valueOf(bundle.getString("FAQ_TAG_TYPE")));
            }
            if (bundle.containsKey("FAQ_CONTACT_US_FILTER_TAGS_LIST")) {
                faqOptions.filterContactUsByTags(bundle.getStringArrayList("FAQ_CONTACT_US_FILTER_TAGS_LIST"), bundle.getString("FAQ_CONTACT_US_FILTER_TITLE"));
            }
        }
        return faqOptions;
    }
}
