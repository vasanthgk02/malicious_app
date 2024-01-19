package com.freshchat.consumer.sdk.j;

import android.net.Uri;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import java.util.Collection;
import java.util.List;

public class aj {
    public static boolean D(Message message) {
        List<MessageFragment> messageFragments = message.getMessageFragments();
        int b2 = k.b((Collection<?>) messageFragments);
        if (b2 == 0) {
            return true;
        }
        if (b2 == 1) {
            MessageFragment messageFragment = messageFragments.get(0);
            if (messageFragment instanceof TextFragment) {
                return as.isEmpty(((TextFragment) messageFragment).getContent());
            }
        }
        return false;
    }

    public static boolean a(MessageFragment messageFragment) {
        int fragmentType = messageFragment.getFragmentType();
        return fragmentType == FragmentType.AUDIO.asInt() || fragmentType == FragmentType.IMAGE.asInt();
    }

    public static Uri b(ButtonFragment buttonFragment) {
        try {
            String androidUri = buttonFragment.getAndroidUri();
            if (as.isEmpty(androidUri) && as.a(buttonFragment.getContent())) {
                androidUri = buttonFragment.getContent();
            }
            if (as.a(androidUri)) {
                return Uri.parse(androidUri);
            }
            return null;
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }
}
