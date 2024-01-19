package com.freshchat.consumer.sdk;

import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.z;
import java.util.ArrayList;
import java.util.Collection;

public class FaqOptions implements z {
    public int accessoryViewLayoutResId;
    public Collection<String> contactusFilterTags = new ArrayList();
    public String contactusFilterTitle;
    public FilterType filterType;
    public String filteredViewTitle;
    public boolean showContactUsOnAppBar = false;
    public boolean showContactUsOnFaqNotHelpful = true;
    public boolean showContactUsOnFaqScreens = true;
    public boolean showFaqCategoriesAsGrid = true;
    public Collection<String> tags = new ArrayList();

    public enum FilterType {
        ARTICLE(0),
        CATEGORY(1);
        
        public final int type;

        /* access modifiers changed from: public */
        FilterType(int i) {
            this.type = i;
        }
    }

    public FaqOptions filterByTags(Collection<String> collection, String str) {
        return filterByTags(collection, str, FilterType.ARTICLE);
    }

    public FaqOptions filterByTags(Collection<String> collection, String str, FilterType filterType2) {
        this.tags.clear();
        if (k.a(collection)) {
            this.tags.addAll(k.c(collection));
            this.filteredViewTitle = str;
            if (filterType2 != null) {
                this.filterType = filterType2;
            } else {
                this.filterType = FilterType.ARTICLE;
            }
        }
        return this;
    }

    public FaqOptions filterContactUsByTags(Collection<String> collection, String str) {
        if (k.a(collection)) {
            this.contactusFilterTags.addAll(k.c(collection));
            this.contactusFilterTitle = str;
        }
        return this;
    }

    public Collection<String> getContactUsTags() {
        ArrayList arrayList = new ArrayList();
        if (k.a(this.contactusFilterTags)) {
            arrayList.addAll(this.contactusFilterTags);
        }
        return arrayList;
    }

    public String getContactUsViewTitle() {
        return this.contactusFilterTitle;
    }

    public FilterType getFilterType() {
        return this.filterType;
    }

    public String getFilteredViewTitle() {
        return this.filteredViewTitle;
    }

    public Collection<String> getTags() {
        ArrayList arrayList = new ArrayList();
        if (k.a(this.tags)) {
            arrayList.addAll(this.tags);
        }
        return arrayList;
    }

    public boolean shouldShowContactUsOnAppBar() {
        return this.showContactUsOnAppBar;
    }

    public boolean shouldShowContactUsOnFaqNotHelpful() {
        return this.showContactUsOnFaqNotHelpful;
    }

    public boolean shouldShowContactUsOnFaqScreens() {
        return this.showContactUsOnFaqScreens;
    }

    public boolean shouldShowFaqCategoriesAsGrid() {
        return this.showFaqCategoriesAsGrid;
    }

    public FaqOptions showContactUsOnAppBar(boolean z) {
        this.showContactUsOnAppBar = z;
        return this;
    }

    public FaqOptions showContactUsOnFaqNotHelpful(boolean z) {
        this.showContactUsOnFaqNotHelpful = z;
        return this;
    }

    public FaqOptions showContactUsOnFaqScreens(boolean z) {
        this.showContactUsOnFaqScreens = z;
        return this;
    }

    public FaqOptions showFaqCategoriesAsGrid(boolean z) {
        this.showFaqCategoriesAsGrid = z;
        return this;
    }
}
