package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.b.k;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyDropDownFragment;
import java.util.Collection;
import java.util.List;

public class h extends a {
    public h(Context context) {
        super(context);
    }

    private MessageFragment D(List<Message> list) {
        return G(F(list));
    }

    private k E(Message message) {
        return message == null ? k.NONE : F(message) != null ? k.CALLBACK : c(G(message));
    }

    private Message F(List<Message> list) {
        if (com.freshchat.consumer.sdk.j.k.isEmpty(list)) {
            return null;
        }
        Message message = list.get(com.freshchat.consumer.sdk.j.k.b((Collection<?>) list) - 1);
        if (com.freshchat.consumer.sdk.j.k.isEmpty(message.getReplyFragments())) {
            return null;
        }
        return message;
    }

    private MessageFragment G(Message message) {
        if (message == null || com.freshchat.consumer.sdk.j.k.isEmpty(message.getReplyFragments())) {
            return null;
        }
        return message.getReplyFragments().get(0);
    }

    private k c(MessageFragment messageFragment) {
        return messageFragment == null ? k.NONE : messageFragment instanceof QuickReplyDropDownFragment ? k.DROP_DOWN : messageFragment instanceof CollectionFragment ? k.NORMAL : messageFragment instanceof CarouselFragment ? k.CAROUSEL : k.NONE;
    }

    public QuickReplyDropDownFragment A(List<Message> list) {
        MessageFragment D = D(list);
        if (D == null || k.DROP_DOWN != c(D)) {
            return null;
        }
        return (QuickReplyDropDownFragment) D;
    }

    public CollectionFragment B(List<Message> list) {
        MessageFragment D = D(list);
        if (D == null || k.NORMAL != c(D)) {
            return null;
        }
        return (CollectionFragment) D;
    }

    public k C(List<Message> list) {
        return E(L(list));
    }

    public long E(List<Message> list) {
        Message F = F(list);
        if (F == null) {
            return -1;
        }
        return F.getId();
    }

    public CollectionFragment F(Message message) {
        if (message != null && !com.freshchat.consumer.sdk.j.k.isEmpty(message.getMessageFragments())) {
            for (MessageFragment next : message.getMessageFragments()) {
                if (next != null && (next instanceof CollectionFragment)) {
                    CollectionFragment collectionFragment = (CollectionFragment) next;
                    List<MessageFragment> fragments = collectionFragment.getFragments();
                    if (com.freshchat.consumer.sdk.j.k.a(fragments)) {
                        for (MessageFragment messageFragment : fragments) {
                            if (messageFragment instanceof CallbackButtonFragment) {
                                return collectionFragment;
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public Message L(List<Message> list) {
        if (com.freshchat.consumer.sdk.j.k.isEmpty(list)) {
            return null;
        }
        return list.get(com.freshchat.consumer.sdk.j.k.b((Collection<?>) list) - 1);
    }

    public CollectionFragment M(List<Message> list) {
        return F(L(list));
    }
}
