package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import com.freshchat.consumer.sdk.beans.fragment.TemplateFragment;
import com.freshchat.consumer.sdk.j.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class z extends a {
    public z(Context context) {
        super(context);
    }

    public List<MessageFragment> O(List<Message> list) {
        List<MessageFragment> arrayList = new ArrayList<>();
        if (k.a(list)) {
            List<MessageFragment> replyFragments = list.get(k.b((Collection<?>) list) - 1).getReplyFragments();
            if (replyFragments != null) {
                for (MessageFragment next : replyFragments) {
                    if (next instanceof TemplateFragment) {
                        arrayList = ((TemplateFragment) next).getFragmentsForSection(SectionKey.QUICK_ACTIONS_BUTTON);
                    }
                }
            }
        }
        return arrayList;
    }
}
