package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import android.text.Html;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Message.MessageType;
import com.freshchat.consumer.sdk.beans.Message.ReplyTo;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyDropDownFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.beans.fragment.UnknownFragment;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.cv;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.k.e;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class c {
    public static Message a(String str, MessageFragment messageFragment, long j, long j2) {
        return a(str, messageFragment, MessageType.MESSAGE_TYPE_NORMAL, j, j2, -1);
    }

    public static Message a(String str, MessageFragment messageFragment, long j, long j2, ReplyTo replyTo, MessageType messageType) {
        String str2;
        StringBuilder sb;
        long fE = com.freshchat.consumer.sdk.j.b.c.fE();
        if (as.isEmpty(str)) {
            sb = new StringBuilder();
            str2 = "user_";
        } else {
            sb = GeneratedOutlineSupport.outline73(str);
            str2 = "_";
        }
        sb.append(str2);
        sb.append(Long.toString(fE));
        String sb2 = sb.toString();
        Message message = new Message();
        message.setAlias(sb2);
        message.setConversationId(j);
        message.setMessageUserAlias(str);
        message.setChannelId(j2);
        message.setMessageType(messageType.getIntValue());
        if (messageFragment != null) {
            message.addMessageFragment(messageFragment);
        }
        if (replyTo != null) {
            message.setReplyTo(replyTo);
        }
        message.setRead(true);
        message.setCreatedMillis(fE);
        return message;
    }

    public static Message a(String str, MessageFragment messageFragment, MessageType messageType, long j, long j2, long j3) {
        ReplyTo replyTo;
        long j4 = j3;
        if (j4 > 0) {
            replyTo = new ReplyTo();
            replyTo.setOriginalMessageId(j4);
        } else {
            replyTo = null;
        }
        return a(str, messageFragment, j, j2, replyTo, messageType);
    }

    public static Message a(String str, String str2, long j, long j2) {
        TextFragment textFragment;
        if (as.a(str2)) {
            textFragment = new TextFragment();
            textFragment.setContent(str2);
            textFragment.setContentType(RNCWebViewManager.HTML_MIME_TYPE);
        } else {
            textFragment = null;
        }
        return a(str, (MessageFragment) textFragment, j, j2);
    }

    public static String a(Context context, Message message, boolean z) {
        String a2;
        boolean h = z ? cv.h(context, message) : false;
        List<MessageFragment> messageFragments = message.getMessageFragments();
        StringBuilder sb = new StringBuilder();
        if (k.a(messageFragments)) {
            for (MessageFragment next : messageFragments) {
                if (next.getFragmentType() == FragmentType.TEXT.asInt()) {
                    String a3 = cv.a(next, h, z);
                    if (as.a(a3)) {
                        a2 = Html.fromHtml(a3).toString();
                    }
                } else if (next.getFragmentType() == FragmentType.TEMPLATE.asInt()) {
                    if (next instanceof CarouselCardDefaultFragment) {
                        a2 = cg.a((CarouselCardDefaultFragment) next, SectionKey.CAROUSEL_CARD_TITLE);
                        if (!as.a(a2)) {
                        }
                    }
                } else if (!(next.getFragmentType() == FragmentType.BUTTON.asInt() || next.getFragmentType() == FragmentType.IMAGE.asInt() || next.getFragmentType() == FragmentType.AUDIO.asInt())) {
                    next.getFragmentType();
                    FragmentType.VIDEO.asInt();
                }
                sb.append(a2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static Message b(JSONObject jSONObject) {
        return (Message) new ab().fromJson(jSONObject.toString(), Message.class);
    }

    public static String f(Context context, Message message) {
        boolean z;
        boolean z2;
        Context context2 = context;
        String str = "";
        if (message == null) {
            return str;
        }
        boolean u = cm.u(message);
        List<MessageFragment> replyFragments = message.getReplyFragments();
        List<MessageFragment> messageFragments = message.getMessageFragments();
        if (k.a(replyFragments)) {
            z = false;
            for (MessageFragment next : replyFragments) {
                if (next instanceof QuickReplyDropDownFragment) {
                    if (!message.isUserMessage()) {
                        z = true;
                    }
                } else if (next instanceof CarouselFragment) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("&#128280; ");
                    outline73.append(context2.getString(R.string.freshchat_carousel_default_preview_text));
                    return outline73.toString();
                }
            }
        } else {
            z = false;
        }
        boolean h = cv.h(context, message);
        if (k.a(messageFragments)) {
            Iterator<MessageFragment> it = messageFragments.iterator();
            String str2 = null;
            String str3 = null;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MessageFragment next2 = it.next();
                if (!(next2 instanceof UnknownFragment)) {
                    if (next2.getFragmentType() != FragmentType.TEXT.asInt()) {
                        if (next2.getFragmentType() != FragmentType.IMAGE.asInt()) {
                            if (next2.getFragmentType() != FragmentType.AUDIO.asInt()) {
                                if (next2.getFragmentType() != FragmentType.VIDEO.asInt()) {
                                    if (next2.getFragmentType() != FragmentType.BUTTON.asInt()) {
                                        if (next2.getFragmentType() != FragmentType.COLLECTION.asInt()) {
                                            if (next2.getFragmentType() != FragmentType.QUICK_REPLY_BUTTON.asInt()) {
                                                if (next2.getFragmentType() != FragmentType.TEMPLATE.asInt()) {
                                                    if (next2.getFragmentType() == FragmentType.CALENDAR_EVENT.asInt() && message.isUserMessage()) {
                                                        str2 = context2.getString(R.string.freshchat_calendar_invite_awaiting_confirmation);
                                                        break;
                                                    }
                                                } else if (next2 instanceof CarouselCardDefaultFragment) {
                                                    str2 = cg.a((CarouselCardDefaultFragment) next2, SectionKey.CAROUSEL_CARD_TITLE);
                                                }
                                            } else if (next2 instanceof QuickReplyButtonFragment) {
                                                e eVar = new e(context2);
                                                eVar.b((QuickReplyButtonFragment) next2);
                                                str2 = eVar.hb();
                                            }
                                        } else {
                                            CollectionFragment collectionFragment = (CollectionFragment) next2;
                                            if (k.a(collectionFragment.getFragments())) {
                                                Iterator<MessageFragment> it2 = collectionFragment.getFragments().iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        if (!(it2.next() instanceof QuickReplyButtonFragment)) {
                                                            break;
                                                        }
                                                    } else {
                                                        z2 = true;
                                                        break;
                                                    }
                                                }
                                                z2 = false;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                            }
                                        }
                                    } else if (as.isEmpty(str3)) {
                                        str3 = as.b(((ButtonFragment) next2).getLabel(), 40);
                                    }
                                } else {
                                    z5 = true;
                                }
                            } else {
                                z4 = true;
                            }
                        } else {
                            z3 = true;
                        }
                    } else if (as.isEmpty(str2)) {
                        str2 = as.b(cv.a(next2, h, true), 100);
                    }
                }
                z6 = true;
            }
            if (u) {
                str = "&#128197; ";
            }
            if (z3) {
                str = GeneratedOutlineSupport.outline50(str, "&#128247; ");
            }
            if (z4) {
                str = GeneratedOutlineSupport.outline50(str, "&#127908; Voice Message ");
            }
            if (z5) {
                str = GeneratedOutlineSupport.outline50(str, "&#127909; ");
            }
            if (z) {
                str = GeneratedOutlineSupport.outline50(str, "&#128315; ");
            }
            if (as.a(str3)) {
                str = GeneratedOutlineSupport.outline50(str, str3);
            }
            if (as.a(str2)) {
                str = GeneratedOutlineSupport.outline50(str, str2);
            }
            if (as.isEmpty(str) && z6) {
                str = GeneratedOutlineSupport.outline50(str, "&#10071;");
            }
        }
        return str;
    }

    public static boolean i(Message message) {
        return (message == null || message.getAlias() == null || !message.getAlias().endsWith("_welcome_message")) ? false : true;
    }
}
