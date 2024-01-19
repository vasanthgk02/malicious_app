package com.freshchat.consumer.sdk.h;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.Style;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.a;
import com.freshchat.consumer.sdk.FreshchatNotificationConfig;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.ConversationDetailActivity;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ag;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.g;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.receiver.FreshchatReceiver;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;
import com.google.firebase.messaging.RemoteMessage;
import com.mpl.payment.paytm.PaytmRequestConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.apache.pdfbox.pdmodel.interactive.form.PDChoice;

public class b {
    public static final String TAG = "com.freshchat.consumer.sdk.h.b";

    public static Uri N(Context context) {
        Uri uri;
        String ee = e.i(context).ee();
        if (as.a(ee)) {
            try {
                uri = Uri.parse(ee);
            } catch (Exception unused) {
            }
            return (uri != null || as.isEmpty(uri.toString())) ? RingtoneManager.getDefaultUri(2) : uri;
        }
        uri = null;
        if (uri != null) {
        }
    }

    public static void O(Context context) {
        b(context, true);
        b(context, false);
    }

    public static Notification a(Context context, a aVar, int i) {
        Style style;
        PendingIntent pendingIntent;
        e i2 = e.i(context);
        Builder a2 = a(context, i2, aVar);
        if (aVar.getMarketingId() > 0) {
            a2.setWhen(aVar.getTimestamp());
        }
        CharSequence f2 = f(context, aVar);
        if (URLUtil.isNetworkUrl(aVar.dl())) {
            Bitmap bitmap = null;
            FreshchatImageLoaderRequest dM = new a(aVar.dl()).dM();
            FreshchatImageLoader eK = af.eK();
            if (eK != null) {
                bitmap = eK.get(dM);
            }
            style = new BigPictureStyle().bigPicture(bitmap).setSummaryText(f2);
        } else {
            style = new BigTextStyle().bigText(f2);
        }
        a2.setStyle(style);
        if (i2.isNotificationInterceptionEnabled()) {
            Intent intent = new Intent(context, FreshchatReceiver.class);
            intent.setAction("com.freshchat.consumer.sdk.actions.NotificationClicked");
            intent.putExtra("FRESHCHAT_DEEPLINK", DeepLinkUtils.v(aVar.getChannelId()));
            pendingIntent = PendingIntent.getBroadcast(context, i, intent, 335544320);
        } else {
            pendingIntent = PendingIntent.getActivity(context, i, a(context, aVar, i2), 335544320);
        }
        a2.setContentIntent(pendingIntent);
        return a2.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Context r4, com.freshchat.consumer.sdk.h.a r5, com.freshchat.consumer.sdk.b.e r6) {
        /*
            android.content.Intent r6 = new android.content.Intent
            java.lang.Class<com.freshchat.consumer.sdk.activity.DeeplinkInterstitialActivity> r0 = com.freshchat.consumer.sdk.activity.DeeplinkInterstitialActivity.class
            r6.<init>(r4, r0)
            boolean r0 = r5.dm()
            r1 = 1
            if (r0 == 0) goto L_0x0014
            java.lang.String r4 = "LAUNCH_APP_ON_CLICK"
        L_0x0010:
            r6.putExtra(r4, r1)
            goto L_0x0036
        L_0x0014:
            android.content.Intent r6 = new android.content.Intent
            java.lang.Class<com.freshchat.consumer.sdk.activity.ConversationDetailActivity> r0 = com.freshchat.consumer.sdk.activity.ConversationDetailActivity.class
            r6.<init>(r4, r0)
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r6.setFlags(r0)
            long r2 = r5.getChannelId()
            java.lang.String r0 = "CHANNEL_ID"
            r6.putExtra(r0, r2)
            long r2 = r5.getChannelId()
            boolean r4 = a(r4, r2)
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = "UNFETCHED_CHANNEL"
            goto L_0x0010
        L_0x0036:
            long r4 = r5.getMarketingId()
            r2 = 0
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x004a
            java.lang.String r0 = "NOTIFICATION_CLICKED"
            r6.putExtra(r0, r1)
            java.lang.String r0 = "MARKETING_ID"
            r6.putExtra(r0, r4)
        L_0x004a:
            java.lang.String r4 = "LAUNCHED_FROM_NOTIFICATION"
            r6.putExtra(r4, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.h.b.a(android.content.Context, com.freshchat.consumer.sdk.h.a, com.freshchat.consumer.sdk.b.e):android.content.Intent");
    }

    public static Bundle a(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        if (obj instanceof Intent) {
            return ((Intent) obj).getExtras();
        }
        if (dq() && (obj instanceof RemoteMessage)) {
            RemoteMessage remoteMessage = (RemoteMessage) obj;
            if (!(remoteMessage.getData() == null || remoteMessage.getData().size() == 0)) {
                Bundle bundle = new Bundle();
                Map<String, String> data = remoteMessage.getData();
                for (String next : data.keySet()) {
                    bundle.putString(next, data.get(next));
                }
                return bundle;
            }
        }
        return null;
    }

    public static Builder a(Context context, e eVar, a aVar) {
        int bQ = eVar.bQ();
        int n = n(context);
        Bitmap o = o(context);
        String d2 = d(context, aVar);
        CharSequence f2 = f(context, aVar);
        boolean z = true;
        Builder style = new Builder(context).setSmallIcon(n).setLargeIcon(o).setContentTitle(d2).setContentText(f2).setTicker(f2).setAutoCancel(true).setPriority(bQ).setStyle(new BigTextStyle().bigText(f2));
        int a2 = aq.a(context, R.color.freshchat_notification_accent_color, 0);
        if (a2 != 0) {
            style.setColor(a2);
        }
        if (eVar.isNotificationSoundEnabled()) {
            style.setSound(N(context));
        }
        if (aw.eN() && g.an(context)) {
            if (aVar.getMarketingId() <= 0) {
                z = false;
            }
            String str = z ? "fc_campaign_notif_ch" : "fc_conv_notif_ch";
            if (!s(context, str)) {
                ai.d("FRESHCHAT", "Creating channel '" + str + "'");
                b(context, z);
            } else {
                ai.d("FRESHCHAT", "Channel '" + str + "' already exists");
            }
            a(context, str, style);
        }
        return style;
    }

    public static void a(Context context, long j, long j2) {
        int b2 = b(j, j2);
        if (b2 > 0) {
            ((NotificationManager) context.getSystemService("notification")).cancel(b2);
        }
    }

    public static void a(Context context, FreshchatNotificationConfig freshchatNotificationConfig) {
        e i = e.i(context);
        i.h(freshchatNotificationConfig.getPriority());
        i.D(freshchatNotificationConfig.getImportance());
        i.i(freshchatNotificationConfig.isNotificationSoundEnabled());
        if (freshchatNotificationConfig.getNotificationSound() != null) {
            i.L(freshchatNotificationConfig.getNotificationSound().toString());
        }
        if (as.a(freshchatNotificationConfig.getActivityToLaunchOnFinish())) {
            i.F(freshchatNotificationConfig.getActivityToLaunchOnFinish());
        }
        i.j(freshchatNotificationConfig.getLargeIcon());
        i.i(freshchatNotificationConfig.getSmallIcon());
        i.u(freshchatNotificationConfig.isNotificationInterceptionEnabled());
    }

    public static void a(final Context context, final a aVar) {
        if (!a(context, aVar.dn(), aVar.getMarketingId())) {
            aa.a(context, aVar.getChannelId(), aVar.getConversationId(), 6, d.a.IMMEDIATE, aVar.getMarketingId() != 0);
            if (a(context, aVar.getChannelId())) {
                b(context, aVar);
            } else {
                ai.i(TAG, "Received message from a new unfetched channel");
                com.freshchat.consumer.sdk.j.b.a(context, com.freshchat.consumer.sdk.service.e.b.a.IMMEDIATE, (com.freshchat.consumer.sdk.service.a) new com.freshchat.consumer.sdk.service.a() {
                    public void a(k kVar) {
                        b.b(context, aVar);
                    }
                });
            }
        }
    }

    public static void a(Context context, String str, Builder builder) {
        try {
            if (!aw.eN() || !g.an(context)) {
                ai.d("FRESHCHAT", "Not setting notification channel. OS/Target SDK version below O");
                return;
            }
            ai.d("FRESHCHAT", "Setting notification channel id as'" + str + "' to notification builder");
            builder.setChannelId(str);
        } catch (Exception e2) {
            ai.e("FRESHCHAT", e2.toString());
        }
    }

    public static boolean a(long j, boolean z) {
        return z || j != ConversationDetailActivity.H();
    }

    public static boolean a(Context context, long j) {
        return (context == null || j <= 0 || new c(context).e(j) == null) ? false : true;
    }

    public static boolean a(Context context, String str, long j) {
        com.freshchat.consumer.sdk.c.g gVar = new com.freshchat.consumer.sdk.c.g(context);
        if (j > 0) {
            return gVar.j(j);
        }
        if (as.a(str)) {
            Message X = gVar.X(str);
            if (X != null) {
                String str2 = TAG;
                ai.d(str2, "Ignoring duplicate message " + X);
                return true;
            }
        }
        return false;
    }

    public static int b(long j, long j2) {
        String l;
        if (j2 > 0) {
            l = Long.toString(j2);
        } else if (j <= 0) {
            return -1;
        } else {
            l = Long.toString(j);
        }
        return aa.aB(l);
    }

    public static void b(Context context, Intent intent) {
        if (intent != null) {
            int e2 = ag.e(intent, "notif_type");
            a aVar = new a(intent);
            bg.d(context, aVar.getChannelId(), aVar.getConversationId());
            if (aVar.getMarketingId() == 0 && !as.m(e.i(context).bj(), aVar.m91do())) {
                return;
            }
            if (e2 == 1 || e2 == 2) {
                a(context, aVar);
            } else if (e2 == 3) {
                c(context, aVar);
            } else {
                ai.d("FRESHCHAT", "Unknown notification category " + e2);
            }
        }
    }

    public static void b(Context context, a aVar) {
        int b2 = b(aVar.getChannelId(), aVar.getMarketingId());
        Notification a2 = a(context, aVar, b2);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (a(aVar.getChannelId(), aVar.dm())) {
            notificationManager.notify(b2, a2);
        }
        com.freshchat.consumer.sdk.b.a.g(context);
        com.freshchat.consumer.sdk.b.a.f(context);
        com.freshchat.consumer.sdk.b.a.aJ(context);
        String str = TAG;
        StringBuilder outline74 = GeneratedOutlineSupport.outline74("Notified with Id ", b2, " for channel id: ");
        outline74.append(aVar.getChannelId());
        outline74.append(", marketing id: ");
        outline74.append(aVar.getMarketingId());
        ai.d(str, outline74.toString());
        aa.e(context, aVar.getMarketingId());
    }

    public static void b(Context context, boolean z) {
        int i;
        if (!aw.fI() && !g.ao(context)) {
            String str = z ? "fc_campaign_notif_ch" : "fc_conv_notif_ch";
            if (z) {
                try {
                    i = R.string.freshchat_campaign_notification_channel_name;
                } catch (Exception unused) {
                    return;
                }
            } else {
                i = R.string.freshchat_conversation_notification_channel_name;
            }
            String string = context.getString(i);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel == null) {
                NotificationChannel notificationChannel2 = new NotificationChannel(str, string, e.i(context).gw());
                notificationChannel2.setSound(N(context), new AudioAttributes.Builder().setContentType(4).setUsage(6).build());
                notificationManager.createNotificationChannel(notificationChannel2);
            } else if (as.p(string, notificationChannel.getName().toString())) {
                notificationChannel.setName(string);
            }
        }
    }

    public static void bj(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            c cVar = new c(context);
            com.freshchat.consumer.sdk.c.g gVar = new com.freshchat.consumer.sdk.c.g(context);
            for (Channel next : cVar.d(null)) {
                arrayList.add(Integer.valueOf(aa.aB(Long.toString(next.getId()))));
                for (Long longValue : gVar.i(next.getId())) {
                    arrayList.add(Integer.valueOf(aa.aB(Long.toString(longValue.longValue()))));
                }
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    notificationManager.cancel(((Integer) it.next()).intValue());
                }
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    public static void c(Context context, a aVar) {
        e i = e.i(context);
        final long channelId = aVar.getChannelId();
        final int b2 = b(channelId, 0);
        Builder a2 = a(context, i, aVar);
        Intent intent = new Intent(context, ConversationDetailActivity.class);
        intent.setFlags(PDChoice.FLAG_COMMIT_ON_SEL_CHANGE);
        intent.putExtra(PaytmRequestConstants.PARAMS_CHANNEL_ID, channelId);
        a2.setContentIntent(PendingIntent.getActivity(context, b2, intent, 335544320));
        final Notification build = a2.build();
        d.a aVar2 = d.a.IMMEDIATE;
        final Context context2 = context;
        AnonymousClass2 r1 = new com.freshchat.consumer.sdk.service.a() {
            public void a(k kVar) {
                if (b.a(channelId, false)) {
                    ((NotificationManager) context2.getSystemService("notification")).notify(b2, build);
                }
                com.freshchat.consumer.sdk.b.a.f(context2);
                com.freshchat.consumer.sdk.b.a.g(context2);
            }
        };
        com.freshchat.consumer.sdk.j.b.a(context, 6, aVar2, (com.freshchat.consumer.sdk.service.a) r1);
    }

    public static String d(Context context, a aVar) {
        return context.getString((aVar.getMarketingId() > 0 ? 1 : (aVar.getMarketingId() == 0 ? 0 : -1)) > 0 ? R.string.freshchat_promotional_message_notification_title : R.string.freshchat_support_message_notification_title).replace(context.getString(R.string.freshchat_placeholder_app_name), g.getAppName(context));
    }

    public static boolean dq() {
        try {
            Class.forName("com.google.firebase.messaging.RemoteMessage");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static CharSequence f(Context context, a aVar) {
        if (aVar.fK() == 3) {
            String string = context.getString(R.string.freshchat_chat_resolution_survey_question);
            if (as.a(string)) {
                return as.fromHtml(string);
            }
        }
        return as.fromHtml(aVar.getBody());
    }

    public static int n(Context context) {
        e i = e.i(context);
        if (i.bR() != 0) {
            return i.bR();
        }
        int a2 = aq.a(context, R.style.Theme_Freshchat_SelectedTheme, R.attr.freshchatContactUsIcon, false);
        return a2 != 0 ? a2 : R.drawable.freshchat_ic_action_contact_us;
    }

    public static Bitmap o(Context context) {
        try {
            e i = e.i(context);
            int bS = i.bS() != 0 ? i.bS() : g.P(context);
            if (bS != 0) {
                return af.b(context, bS, R.dimen.freshchat_notification_large_icon_size);
            }
            return null;
        } catch (Exception e2) {
            ai.e("FRESHCHAT_WARNING", e2.toString());
            return null;
        }
    }

    @TargetApi(26)
    public static boolean s(Context context, String str) {
        try {
            return as.a(str) && ((NotificationManager) context.getSystemService("notification")).getNotificationChannel(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
