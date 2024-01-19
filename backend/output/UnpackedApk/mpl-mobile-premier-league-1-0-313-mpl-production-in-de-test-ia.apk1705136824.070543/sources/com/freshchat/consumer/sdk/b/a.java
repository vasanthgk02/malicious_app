package com.freshchat.consumer.sdk.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.freshchat.consumer.sdk.Freshchat;

public class a {
    public static void W(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.KillCurrentUserSession");
    }

    public static void X(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.ExpectedConversationResponseTimeUpdated");
    }

    public static void a(Context context, Bundle bundle) {
        b(context, Freshchat.FRESHCHAT_EVENTS, bundle);
    }

    public static void a(Context context, String str, Bundle bundle) {
        bundle.putBoolean("STATUS_SUCCESS", false);
        b(context, str, bundle);
    }

    public static void aJ(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.MessageCountChanged");
    }

    public static void aY(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount");
    }

    public static void ai(Context context) {
        d(context, (String) Freshchat.FRESHCHAT_USER_RESTORE_ID_GENERATED);
    }

    public static void ax(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged");
    }

    public static void b(Context context, Bundle bundle) {
        b(context, "com.freshchat.consumer.sdk.actions.FAQCategoriesFetched", bundle);
    }

    public static void b(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("STATUS_SUCCESS", true);
        b(context, str, bundle);
    }

    public static void b(Context context, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        c(context).sendBroadcast(intent);
    }

    public static void ba(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.TokenWaitTimeout");
    }

    public static LocalBroadcastManager c(Context context) {
        return LocalBroadcastManager.getInstance(context.getApplicationContext());
    }

    public static void c(Context context, Bundle bundle) {
        b(context, "com.freshchat.consumer.sdk.actions.FAQListFetched", bundle);
    }

    public static void c(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("STATUS_SUCCESS", false);
        b(context, str, bundle);
    }

    public static void cm(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated");
    }

    public static void cn(Context context) {
        d(context, (String) Freshchat.FRESHCHAT_SET_TOKEN_TO_REFRESH_DEVICE_PROPERTIES);
    }

    public static void co(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.FAQApiVersionChanged");
    }

    public static void d(Context context, Bundle bundle) {
        b(context, "com.freshchat.consumer.sdk.actions.FAQFetched", bundle);
    }

    public static void d(Context context, String str) {
        b(context, str, null);
    }

    public static void e(Context context, Bundle bundle) {
        b(context, "com.freshchat.consumer.sdk.actions.FAQSearchResultFetched", bundle);
    }

    public static void f(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.MessagesUpdated");
    }

    public static void f(Context context, Bundle bundle) {
        b(context, "com.freshchat.consumer.sdk.actions.FAQVoted", bundle);
    }

    public static void g(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.ChannelsUpdated");
    }

    public static void g(Context context, Bundle bundle) {
        b(context, "com.freshchat.consumer.sdk.actions.BotFAQFetched", bundle);
    }

    public static void h(Context context) {
        d(context, (String) "com.freshchat.consumer.sdk.actions.SolutionsUpdated");
    }

    public static void p(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("FRESHCHAT", true);
        bundle.putString("FRESHCHAT_DEEPLINK", str);
        b(context, Freshchat.FRESHCHAT_ACTION_NOTIFICATION_INTERCEPTED, bundle);
    }
}
