package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.BotFAQ;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.reqres.BotFAQFetchResponse;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class y extends n {
    public BotFAQ botFAQ;
    public String ej;
    public String placeholderReferenceId;
    public final String rA = "</bdi></body></html>";
    public String referenceId;
    public Status rr;
    public final String s = "HL_ARTICLE_TITLE";
    public final String t = "<head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_res/raw/normalize.css\"/><script src='file:///freshchat_assets/freshchat_hacks.js'></script><title>HL_ARTICLE_TITLE</title></head>";
    public String title;
    public final String u = "<!DOCTYPE html>\t<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_res/raw/normalize.css\"/><script src='file:///freshchat_assets/freshchat_hacks.js'></script><title>HL_ARTICLE_TITLE</title></head><body onload='correctIframe()'> <bdi>";

    public y(Context context) {
        super(context);
    }

    private void d(Status status) {
        this.rr = status;
    }

    private List<MessageFragment> kd() {
        BotFAQ botFAQ2 = this.botFAQ;
        return (botFAQ2 == null || botFAQ2.getTemplateContentPayloads() == null || k.isEmpty(this.botFAQ.getTemplateContentPayloads().getDescription())) ? new ArrayList() : this.botFAQ.getTemplateContentPayloads().getDescription();
    }

    public void c(CallbackButtonFragment callbackButtonFragment) {
        if (callbackButtonFragment != null) {
            bg.y(getContext(), callbackButtonFragment.getLabel());
            b.a(getContext(), this.ej, callbackButtonFragment, this.referenceId);
        }
    }

    public Status g(Bundle bundle) {
        if (bundle != null) {
            try {
                BotFAQFetchResponse botFAQFetchResponse = (BotFAQFetchResponse) bundle.getParcelable("RESPONSE");
                if (botFAQFetchResponse != null) {
                    this.botFAQ = botFAQFetchResponse.getBotFAQ();
                    d(botFAQFetchResponse.getStatus());
                    return this.rr;
                }
                throw new IllegalArgumentException("botFAQFetchResponse cannot be null in BotFAQDetailViewModel::processResponse()");
            } catch (Exception e2) {
                d(Status.ERROR);
                q.a(e2);
            }
        } else {
            throw new IllegalArgumentException("bundle cannot be null in BotFAQDetailViewModel::processResponse()");
        }
    }

    public List<MessageFragment> getCallbacks() {
        BotFAQ botFAQ2 = this.botFAQ;
        return (botFAQ2 == null || botFAQ2.getTemplateContentPayloads() == null || k.isEmpty(this.botFAQ.getTemplateContentPayloads().getCallbacks())) ? new ArrayList() : this.botFAQ.getTemplateContentPayloads().getCallbacks();
    }

    public boolean h(Bundle bundle) {
        boolean z = false;
        if (bundle == null) {
            return false;
        }
        if (bundle.containsKey("MESSAGE_ALIAS") && !as.isEmpty(bundle.getString("MESSAGE_ALIAS")) && bundle.containsKey("EXTRA_TITLE") && !as.isEmpty(bundle.getString("EXTRA_TITLE")) && bundle.containsKey("REFERENCE_ID") && !as.isEmpty(bundle.getString("REFERENCE_ID")) && bundle.containsKey("PLACEOLDER_REFERENCE_ID") && !as.isEmpty(bundle.getString("PLACEOLDER_REFERENCE_ID"))) {
            z = true;
        }
        return z;
    }

    public String hV() {
        return getContext().getString(R.string.freshchat_no_faq_found);
    }

    public void j(Intent intent) {
        super.j(intent);
        if (intent.hasExtra("MESSAGE_ALIAS")) {
            this.ej = intent.getStringExtra("MESSAGE_ALIAS");
        }
        if (intent.hasExtra("EXTRA_TITLE")) {
            this.title = intent.getStringExtra("EXTRA_TITLE");
        }
        if (intent.hasExtra("REFERENCE_ID")) {
            this.referenceId = intent.getStringExtra("REFERENCE_ID");
        }
        if (intent.hasExtra("PLACEOLDER_REFERENCE_ID")) {
            this.placeholderReferenceId = intent.getStringExtra("PLACEOLDER_REFERENCE_ID");
        }
    }

    public void jc() {
        this.botFAQ = null;
    }

    public Status jd() {
        Status status;
        if (al.aS(getContext())) {
            b.k(getContext(), this.referenceId, this.placeholderReferenceId);
            status = Status.INIT_LOADING;
        } else {
            status = Status.NO_INTERNET;
        }
        d(status);
        return this.rr;
    }

    public Status jm() {
        if (al.aS(getContext()) && this.rr == Status.NO_INTERNET) {
            jd();
            d(Status.INIT_LOADING);
        }
        return this.rr;
    }

    public Status jv() {
        return jd();
    }

    public String jw() {
        return this.title;
    }

    public String jx() {
        String str;
        List<MessageFragment> kd = kd();
        if (k.isEmpty(kd) || as.isEmpty(kd.get(0).getContent())) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String replaceAll = kd.get(0).getContent().replaceAll("src=\"//", "src=\"http://").replaceAll("value=\"//", "value=\"http://");
        Pattern compile = Pattern.compile("<\\s*(img|iframe).*?src\\s*=[ '\"]+http[s]?:\\/\\/.*?>");
        if (al.aS(getContext()) || !compile.matcher(replaceAll).find()) {
            str = "";
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("<div class='offline-article-message'>");
            outline73.append(getContext().getString(R.string.freshchat_faq_rich_media_content_cannot_be_displayed));
            outline73.append("</div>");
            str = outline73.toString();
        }
        GeneratedOutlineSupport.outline103(sb, "<!DOCTYPE html>\t<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_res/raw/normalize.css\"/><script src='file:///freshchat_assets/freshchat_hacks.js'></script><title>HL_ARTICLE_TITLE</title></head><body onload='correctIframe()'> <bdi>", str, "<div class=\"article-body\">", replaceAll);
        return GeneratedOutlineSupport.outline62(sb, "</div>", "</bdi></body></html>").replace("HL_ARTICLE_TITLE", jw());
    }

    public void kc() {
        bg.a(getContext(), jw(), this.referenceId, this.placeholderReferenceId);
    }
}
