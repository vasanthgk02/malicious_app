package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.a;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.w;
import com.freshchat.consumer.sdk.activity.PictureAttachmentActivity;
import com.freshchat.consumer.sdk.beans.UnsupportedFragmentConfig;
import com.freshchat.consumer.sdk.beans.UnsupportedFragmentConfig.ErrorMessage;
import com.freshchat.consumer.sdk.beans.fragment.AudioFragment;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.ImageFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.StaticTemplateFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.k.e;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;
import java.util.List;

public class ak {
    public final Context context;
    public final LayoutInflater cr;
    public ViewGroup iA;
    public final ae iz;
    public final int rp;

    public ak(Context context2) {
        this.context = context2;
        this.iz = new ae(context2);
        this.cr = LayoutInflater.from(context2);
        this.rp = aq.j(context2, R.attr.freshchatPictureMessagePlaceholderImage);
    }

    private View a(AudioFragment audioFragment) {
        View inflate = View.inflate(this.context, R.layout.freshchat_partial_message_fragment_audio, this.iA);
        View findViewById = inflate.findViewById(R.id.freshchat_message_duration);
        inflate.findViewById(R.id.freshchat_message_play);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(n.s(audioFragment.getDuration()));
        }
        return inflate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(com.freshchat.consumer.sdk.beans.fragment.CollectionFragment r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r3 = r8.getFragments()
            boolean r4 = com.freshchat.consumer.sdk.j.k.a(r3)
            r5 = 1
            if (r4 == 0) goto L_0x003a
            java.util.Iterator r3 = r3.iterator()
        L_0x0019:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x003a
            java.lang.Object r4 = r3.next()
            com.freshchat.consumer.sdk.beans.fragment.MessageFragment r4 = (com.freshchat.consumer.sdk.beans.fragment.MessageFragment) r4
            boolean r6 = r4 instanceof com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment
            if (r6 == 0) goto L_0x002b
        L_0x0029:
            r1 = 1
            goto L_0x003a
        L_0x002b:
            boolean r6 = r4 instanceof com.freshchat.consumer.sdk.beans.fragment.StaticTemplateFragment
            if (r6 == 0) goto L_0x0035
            com.freshchat.consumer.sdk.beans.fragment.StaticTemplateFragment r4 = (com.freshchat.consumer.sdk.beans.fragment.StaticTemplateFragment) r4
            r2.add(r4)
            goto L_0x0019
        L_0x0035:
            boolean r4 = r4 instanceof com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment
            if (r4 == 0) goto L_0x0019
            goto L_0x0029
        L_0x003a:
            if (r1 == 0) goto L_0x003d
            return r0
        L_0x003d:
            boolean r0 = com.freshchat.consumer.sdk.j.k.a(r2)
            if (r0 == 0) goto L_0x0048
            android.view.View r8 = r7.a(r2, r9)
            return r8
        L_0x0048:
            android.view.View r8 = r7.b(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.ak.a(com.freshchat.consumer.sdk.beans.fragment.CollectionFragment, java.lang.String):android.view.View");
    }

    private View a(ImageFragment imageFragment, boolean z) {
        final String content = imageFragment.getContent();
        if (!URLUtil.isNetworkUrl(content)) {
            content = GeneratedOutlineSupport.outline50("file:", content);
        }
        View inflate = this.cr.inflate(R.layout.freshchat_partial_message_fragment_image, this.iA, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.freshchat_image);
        Point b2 = this.iz.b(imageFragment.getWidth(), imageFragment.getHeight());
        int i = b2.x;
        int i2 = b2.y;
        if (z) {
            this.iz.a(imageView, b2);
        }
        FreshchatImageLoaderRequest dM = new a(content).a(i, i2).G(this.rp).dM();
        FreshchatImageLoader eK = af.eK();
        if (eK != null) {
            eK.load(dM, imageView);
        }
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ak.this.context.startActivity(PictureAttachmentActivity.a(ak.this.context, content));
            }
        });
        return inflate;
    }

    private View a(QuickReplyButtonFragment quickReplyButtonFragment) {
        e eVar = new e(this.context);
        eVar.b(quickReplyButtonFragment);
        return bi(eVar.hb());
    }

    private View a(TextFragment textFragment, boolean z, boolean z2) {
        return bi(cv.a(textFragment, z, z2));
    }

    private View a(List<StaticTemplateFragment> list, String str) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.freshchat_partial_bot_faq_list_fragment, this.iA, false);
        ((LinearLayout) inflate.findViewById(R.id.freshchat_conv_bot_list)).setVisibility(0);
        ((RecyclerView) inflate.findViewById(R.id.freshchat_conv_detail_bot_list)).setAdapter(new w(list, new db(this), str));
        return inflate;
    }

    private View b(MessageFragment messageFragment) {
        Integer num;
        String str;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.freshchat_unknown_fragment, this.iA, false);
        TextView textView = (TextView) inflate.findViewById(R.id.freshchat_unknown_fragment_text);
        String str2 = null;
        if (messageFragment != null) {
            str = messageFragment.getContentType();
            num = Integer.valueOf(messageFragment.getFragmentType());
        } else {
            num = null;
            str = null;
        }
        UnsupportedFragmentConfig unsupportedFragmentConfig = ap.bD(this.context).getUnsupportedFragmentConfig();
        if (unsupportedFragmentConfig != null) {
            ErrorMessage errorMessage = unsupportedFragmentConfig.getErrorMessage(num, str);
            if (errorMessage != null) {
                str2 = unsupportedFragmentConfig.getDisplayableErrorMessage(errorMessage);
            }
        }
        if (as.a(str2)) {
            textView.setText(str2);
        } else {
            textView.setText(R.string.freshchat_unknown_message_fragment);
        }
        return inflate;
    }

    private View bi(String str) {
        View inflate = this.cr.inflate(R.layout.freshchat_partial_message_fragment_text, this.iA, false);
        TextView textView = (TextView) inflate.findViewById(R.id.freshchat_text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Bundle bundle = new Bundle();
        bundle.putBoolean("LAUNCHED_FROM_CONVERSATION", true);
        textView.setText(DeepLinkUtils.c(this.context, str, bundle));
        textView.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                ((View) view.getParent()).performLongClick();
                return true;
            }
        });
        return inflate;
    }

    public View a(ViewGroup viewGroup, MessageFragment messageFragment, boolean z, boolean z2, boolean z3, String str) {
        a(viewGroup);
        return messageFragment instanceof TextFragment ? a((TextFragment) messageFragment, z, z2) : messageFragment instanceof AudioFragment ? a((AudioFragment) messageFragment) : messageFragment instanceof ImageFragment ? a((ImageFragment) messageFragment, z3) : messageFragment instanceof ButtonFragment ? a((ButtonFragment) messageFragment) : messageFragment instanceof CollectionFragment ? a((CollectionFragment) messageFragment, str) : messageFragment instanceof QuickReplyButtonFragment ? a((QuickReplyButtonFragment) messageFragment) : b(messageFragment);
    }

    public View a(ButtonFragment buttonFragment) {
        String str;
        Context context2;
        int i;
        View inflate = this.cr.inflate(R.layout.freshchat_partial_message_fragment_button, this.iA, false);
        View findViewById = inflate.findViewById(R.id.freshchat_button);
        Uri b2 = aj.b(buttonFragment);
        if (findViewById instanceof TextView) {
            if (DeepLinkUtils.e(b2)) {
                context2 = this.context;
                i = R.string.freshchat_chat_deeplink_faq;
            } else if (as.a(buttonFragment.getLabel())) {
                str = buttonFragment.getLabel();
                ((TextView) findViewById).setText(str);
            } else {
                context2 = this.context;
                i = R.string.freshchat_chat_deeplink;
            }
            str = context2.getString(i);
            ((TextView) findViewById).setText(str);
        }
        findViewById.setOnClickListener(new cs(this, b2));
        return inflate;
    }

    public void a(ViewGroup viewGroup) {
        this.iA = viewGroup;
    }
}
