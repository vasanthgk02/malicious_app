package com.freshchat.consumer.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.View;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.LinkHandler;
import com.freshchat.consumer.sdk.activity.ArticleDetailActivity;
import com.freshchat.consumer.sdk.activity.FAQDetailsActivity;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.c;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.m;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.y;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

public class DeepLinkUtils {

    public static class CustomURLSpan extends URLSpan {
        public Bundle lc;

        public CustomURLSpan(String str, Bundle bundle) {
            super(str);
            this.lc = bundle;
        }

        public void onClick(View view) {
            try {
                DeepLinkUtils.a(view.getContext(), Uri.parse(getURL()), this.lc);
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static void a(Context context, Uri uri, Bundle bundle) {
        try {
            if (!c(uri)) {
                if (!d(uri)) {
                    c(context, uri, bundle);
                    return;
                }
            }
            b(context, uri, bundle);
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static boolean a(Uri uri, String str) {
        return uri != null && as.m(uri.getScheme(), str);
    }

    public static void b(Context context, Uri uri) {
        if (context != null && uri != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("LAUNCHED_FROM_CONVERSATION", true);
            a(context, uri, bundle);
        }
    }

    public static void b(Context context, Uri uri, Bundle bundle) {
        if (context != null && uri != null) {
            try {
                if (f(uri)) {
                    c a2 = c.a(context, new ConversationOptions());
                    if (a2 instanceof m) {
                        long j = j(uri);
                        Collection<String> k = k(uri);
                        if (j > 0) {
                            Channel channel = new Channel();
                            channel.setId(j);
                            ((m) a2).c(channel);
                        } else if (k.a(k)) {
                            String queryParameter = uri.getQueryParameter("title");
                            ConversationOptions conversationOptions = new ConversationOptions();
                            conversationOptions.filterByTags(k, queryParameter);
                            Freshchat.showConversations(context, conversationOptions);
                        }
                    }
                } else if (e(uri) || d(uri)) {
                    d(context, uri, bundle);
                }
            } catch (Exception e2) {
                q.a(e2);
            }
        }
    }

    public static boolean b(String str) {
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("youtube.") || lowerCase.contains("vimeo.");
    }

    public static Pattern bm(Context context) {
        String bp = e.i(context).bp();
        if (as.a(bp)) {
            return Pattern.compile(bp);
        }
        return null;
    }

    public static String bn(Context context) {
        return e.i(context).bq();
    }

    public static Intent c(Context context, Uri uri) {
        try {
            long parseLong = Long.parseLong(g(uri));
            if (parseLong > 0) {
                Intent intent = new Intent(context, ArticleDetailActivity.class);
                intent.putExtra("article_id", parseLong);
                return intent;
            }
        } catch (Exception e2) {
            q.a(e2);
        }
        return null;
    }

    public static SpannableString c(Context context, String str, Bundle bundle) {
        Spanned fromHtml = as.fromHtml(str);
        URLSpan[] uRLSpanArr = (URLSpan[]) fromHtml.getSpans(0, fromHtml.length(), URLSpan.class);
        SpannableString spannableString = new SpannableString(fromHtml);
        Linkify.addLinks(spannableString, 15);
        Pattern bm = bm(context);
        String bn = bn(context);
        if (bm != null && as.a(bn)) {
            Linkify.addLinks(spannableString, bm, bn);
        }
        for (URLSpan uRLSpan : uRLSpanArr) {
            spannableString.setSpan(new CustomURLSpan(uRLSpan.getURL(), bundle), fromHtml.getSpanStart(uRLSpan), fromHtml.getSpanEnd(uRLSpan), 0);
        }
        return spannableString;
    }

    public static boolean c(Context context, Uri uri, Bundle bundle) {
        if (uri != null) {
            bg.a(context, uri);
            LinkHandler customLinkHandler = Freshchat.getInstance(context).getCustomLinkHandler();
            if (customLinkHandler != null && customLinkHandler.handleLink(uri.toString(), null)) {
                return true;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                context.startActivity(intent);
                return true;
            } catch (Exception unused) {
                "Exception opening link " + uri;
            }
        }
        return false;
    }

    public static boolean c(Uri uri) {
        return a(uri, "freshchat");
    }

    public static void d(Context context, Uri uri, Bundle bundle) {
        Intent f2 = y.cp(context) ? f(context, uri) : c(context, uri);
        if (f2 != null) {
            if (bundle != null) {
                f2.putExtras(bundle);
            }
            context.startActivity(f2);
        }
    }

    public static boolean d(Uri uri) {
        try {
            if (!a(uri, "faq")) {
                return false;
            }
            String h = h(uri);
            return as.a(h) && Long.parseLong(h) > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Uri uri) {
        try {
            if (!c(uri)) {
                return false;
            }
            String host = uri.getHost();
            String lastPathSegment = uri.getLastPathSegment();
            String i = i(uri);
            return "faq".equalsIgnoreCase(host) && "article".equalsIgnoreCase(lastPathSegment) && as.a(i) && Long.valueOf(i).longValue() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Intent f(Context context, Uri uri) {
        String l = l(uri);
        String g = g(uri);
        if (!as.a(l) || !as.a(g)) {
            return null;
        }
        Intent intent = new Intent(context, FAQDetailsActivity.class);
        intent.putExtra("article_id", g);
        intent.putExtra("category_id", l);
        return intent;
    }

    public static boolean f(Uri uri) {
        try {
            if (!c(uri) || !"channels".equalsIgnoreCase(uri.getHost())) {
                return false;
            }
            return j(uri) > 0 || k.a(k(uri));
        } catch (Exception unused) {
            return false;
        }
    }

    public static String g(Uri uri) {
        try {
            if (d(uri)) {
                return h(uri);
            }
            if (e(uri)) {
                return i(uri);
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static String h(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            String host = uri.getHost();
            if (Long.parseLong(host) > 0) {
                return host;
            }
            return null;
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static String i(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            String queryParameter = uri.getQueryParameter("article_id");
            if (!as.isEmpty(queryParameter) && Long.valueOf(queryParameter).longValue() > 0) {
                return queryParameter;
            }
            return null;
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static long j(Uri uri) {
        if (uri == null) {
            return 0;
        }
        String queryParameter = uri.getQueryParameter("id");
        if (as.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            long longValue = Long.valueOf(queryParameter).longValue();
            if (longValue > 0) {
                return longValue;
            }
            return 0;
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static Collection<String> k(Uri uri) {
        if (uri == null) {
            return null;
        }
        String queryParameter = uri.getQueryParameter("tags");
        if (as.isEmpty(queryParameter)) {
            return null;
        }
        return k.d((Collection<String>) Arrays.asList(queryParameter.split(",")));
    }

    public static String l(Uri uri) {
        try {
            if (e(uri)) {
                return m(uri);
            }
        } catch (Exception e2) {
            ai.w("FRESHCHAT", "Exception while extracting category id from deeplink", e2);
        }
        return null;
    }

    public static String m(Uri uri) {
        String str = null;
        if (uri == null) {
            return null;
        }
        try {
            str = uri.getQueryParameter("category_id");
        } catch (Exception e2) {
            q.a(e2);
        }
        return str;
    }

    public static String v(long j) {
        if (j <= 0) {
            return null;
        }
        Builder builder = new Builder();
        builder.scheme("freshchat").encodedAuthority("channels").appendQueryParameter("id", String.valueOf(j));
        return builder.build().toString();
    }
}
