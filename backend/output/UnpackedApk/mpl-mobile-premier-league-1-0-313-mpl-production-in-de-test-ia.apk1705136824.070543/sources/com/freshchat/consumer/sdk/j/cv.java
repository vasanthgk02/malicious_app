package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import java.util.List;

public class cv {
    public static String a(MessageFragment messageFragment, boolean z, boolean z2) {
        return (!z || !z2 || !as.a(messageFragment.getTranslatedContent())) ? messageFragment.getContent() : messageFragment.getTranslatedContent();
    }

    public static boolean h(Context context, Message message) {
        if (context == null || message == null || message.isUserMessage() || !ap.bD(context).getLiveTranslationConfig().isEnabled() || message.getShouldTranslate() != 1) {
            return false;
        }
        List<MessageFragment> messageFragments = message.getMessageFragments();
        if (k.a(messageFragments)) {
            for (MessageFragment translatedContent : messageFragments) {
                if (as.a(translatedContent.getTranslatedContent())) {
                    return true;
                }
            }
        }
        return false;
    }
}
