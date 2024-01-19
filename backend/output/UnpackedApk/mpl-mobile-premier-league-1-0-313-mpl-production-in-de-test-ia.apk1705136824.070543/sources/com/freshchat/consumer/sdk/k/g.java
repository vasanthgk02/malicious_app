package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyDropDownFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class g extends a {
    public QuickReplyDropDownFragment nx;

    public g(Context context) {
        super(context);
    }

    private void hd() {
        if (this.nx != null) {
            ArrayList arrayList = new ArrayList();
            List<MessageFragment> fragmentsForSection = this.nx.getFragmentsForSection(SectionKey.DROP_DOWN_OPTIONS);
            if (!k.isEmpty(fragmentsForSection)) {
                for (MessageFragment next : fragmentsForSection) {
                    if (next instanceof QuickReplyButtonFragment) {
                        QuickReplyButtonFragment quickReplyButtonFragment = (QuickReplyButtonFragment) next;
                        String label = quickReplyButtonFragment.getLabel();
                        String customReplyText = quickReplyButtonFragment.getCustomReplyText();
                        if (as.a(label) || as.a(customReplyText)) {
                            arrayList.add(quickReplyButtonFragment);
                        }
                    }
                }
                this.nx.replaceSection(SectionKey.DROP_DOWN_OPTIONS, arrayList);
            }
        }
    }

    public void a(QuickReplyDropDownFragment quickReplyDropDownFragment) {
        this.nx = quickReplyDropDownFragment;
        hd();
    }

    public List<MessageFragment> he() {
        QuickReplyDropDownFragment quickReplyDropDownFragment = this.nx;
        if (quickReplyDropDownFragment == null) {
            return null;
        }
        return quickReplyDropDownFragment.getFragmentsForSection(SectionKey.DROP_DOWN_OPTIONS);
    }

    public int hf() {
        QuickReplyDropDownFragment quickReplyDropDownFragment = this.nx;
        if (quickReplyDropDownFragment == null) {
            return 0;
        }
        return k.b((Collection<?>) quickReplyDropDownFragment.getFragmentsForSection(SectionKey.DROP_DOWN_OPTIONS));
    }
}
