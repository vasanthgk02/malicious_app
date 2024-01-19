package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.MessageMask;
import com.freshchat.consumer.sdk.beans.MessageMaskingConfig;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bc {
    public static void a(Context context, MessageMaskingConfig messageMaskingConfig) {
        if (context != null) {
            try {
                e.i(context).aX(new ab().toJson(messageMaskingConfig));
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static void a(MessageMask messageMask, Message message) {
        if (messageMask != null && message != null) {
            try {
                String regex = messageMask.getRegex();
                String replacementStr = messageMask.getReplacementStr();
                for (MessageFragment next : message.getMessageFragments()) {
                    if (next instanceof TextFragment) {
                        next.setContent(b(next.getContent(), regex, replacementStr));
                    }
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        String str4;
        try {
            Pattern compile = Pattern.compile(str2);
            if (as.isEmpty(str3)) {
                str3 = "*";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = compile.matcher(str);
            while (matcher.find()) {
                if (str3.length() == 1) {
                    str4 = as.a(str3, "", matcher.end() - matcher.start());
                } else {
                    str4 = str3;
                }
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(str4));
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (Exception e2) {
            q.a(e2);
            return null;
        }
    }

    public static MessageMaskingConfig bH(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String fq = e.i(context).fq();
            if (as.a(fq)) {
                return (MessageMaskingConfig) new ab().fromJson(fq, MessageMaskingConfig.class);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return null;
    }

    public static void e(Context context, Message message) {
        String str;
        if (context == null) {
            str = "Context cannot be null in MessageMaskingUtils::applyMask()";
        } else if (message == null) {
            str = "Message cannot be null in MessageMaskingUtils::applyMask()";
        } else {
            MessageMaskingConfig messageMaskingConfig = ap.bD(context).getMessageMaskingConfig();
            if (messageMaskingConfig != null) {
                LinkedList<MessageMask> messageMasks = messageMaskingConfig.getMessageMasks();
                if (!k.isEmpty(messageMasks)) {
                    Iterator it = messageMasks.iterator();
                    while (it.hasNext()) {
                        a((MessageMask) it.next(), message);
                    }
                    return;
                }
                return;
            }
            return;
        }
        ai.e("FRESHCHAT_WARNING", str);
    }
}
