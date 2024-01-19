package com.clevertap.android.pushtemplates;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.text.format.DateUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat.BigPictureStyle;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.app.NotificationCompat.Style;
import androidx.core.app.RemoteInput;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.content.PendingIntentFactory;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.interfaces.ActionButtonClickHandler;
import com.clevertap.android.sdk.pushnotification.CTNotificationIntentService;
import com.clevertap.android.sdk.task.CTExecutorFactory;
import com.clevertap.android.sdk.task.Task;
import com.mpl.androidapp.utils.Constant;
import com.squareup.picasso.NetworkRequestHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;

public class PushTemplateReceiver extends BroadcastReceiver {
    public ArrayList<String> bigTextList = new ArrayList<>();
    public String channelId;
    public CleverTapAPI cleverTapAPI;
    public boolean close = true;
    public CleverTapInstanceConfig config;
    public RemoteViews contentViewBig;
    public RemoteViews contentViewManualCarousel;
    public RemoteViews contentViewRating;
    public RemoteViews contentViewSmall;
    public ArrayList<String> deepLinkList = new ArrayList<>();
    public ArrayList<String> imageList = new ArrayList<>();
    public NotificationManager notificationManager;
    public ArrayList<String> priceList = new ArrayList<>();
    public String pt_big_img;
    public String pt_big_img_alt;
    public boolean pt_dismiss_intent;
    public String pt_id;
    public String pt_meta_clr;
    public String pt_msg;
    public String pt_msg_summary;
    public String pt_product_display_linear;
    public String pt_rating_default_dl;
    public String pt_rating_toast;
    public String pt_small_icon_clr;
    public String pt_subtitle;
    public String pt_title;
    public boolean requiresChannelId;
    public int smallIcon = 0;
    public ArrayList<String> smallTextList = new ArrayList<>();
    public TemplateType templateType;

    public static void access$200(PushTemplateReceiver pushTemplateReceiver, Context context, Bundle bundle) {
        Builder builder;
        PushTemplateReceiver pushTemplateReceiver2 = pushTemplateReceiver;
        Context context2 = context;
        Bundle bundle2 = bundle;
        Class<?> cls = null;
        if (pushTemplateReceiver2 != null) {
            try {
                int i = bundle2.getInt(Constant.NOTIFICATION_ID);
                if (bundle2.getBoolean("default_dl", false)) {
                    pushTemplateReceiver2.config = (CleverTapInstanceConfig) bundle2.getParcelable("config");
                    pushTemplateReceiver2.notificationManager.cancel(i);
                    cls = Class.forName("com.clevertap.android.sdk.pushnotification.CTNotificationIntentService");
                    if (Utils.isServiceAvailable(context2, cls)) {
                        Intent intent = new Intent(CTNotificationIntentService.MAIN_ACTION);
                        intent.setPackage(context.getPackageName());
                        intent.putExtra("ct_type", CTNotificationIntentService.TYPE_BUTTON_CLICK);
                        intent.putExtras(bundle2);
                        intent.putExtra("dl", pushTemplateReceiver2.pt_rating_default_dl);
                        context2.startService(intent);
                        return;
                    }
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(pushTemplateReceiver2.pt_rating_default_dl));
                    intent2.removeExtra("wzrk_acts");
                    intent2.putExtra("wzrk_from", "CTPushNotificationReceiver");
                    intent2.setFlags(872415232);
                    k.raiseNotificationClicked(context2, bundle2, pushTemplateReceiver2.config);
                    intent2.putExtras(bundle2);
                    intent2.putExtra("wzrk_dl", pushTemplateReceiver2.pt_rating_default_dl);
                    context2.startActivity(intent2);
                    return;
                }
                String str = pushTemplateReceiver2.deepLinkList.get(0);
                if (1 == bundle2.getInt("clickedStar", 0)) {
                    bundle2.putString("wzrk_c2a", "rating_1");
                    if (pushTemplateReceiver2.deepLinkList.size() > 0) {
                        str = pushTemplateReceiver2.deepLinkList.get(0);
                    }
                }
                if (2 == bundle2.getInt("clickedStar", 0)) {
                    bundle2.putString("wzrk_c2a", "rating_2");
                    if (pushTemplateReceiver2.deepLinkList.size() > 1) {
                        str = pushTemplateReceiver2.deepLinkList.get(1);
                    } else {
                        str = pushTemplateReceiver2.deepLinkList.get(0);
                    }
                }
                if (3 == bundle2.getInt("clickedStar", 0)) {
                    bundle2.putString("wzrk_c2a", "rating_3");
                    if (pushTemplateReceiver2.deepLinkList.size() > 2) {
                        str = pushTemplateReceiver2.deepLinkList.get(2);
                    } else {
                        str = pushTemplateReceiver2.deepLinkList.get(0);
                    }
                }
                if (4 == bundle2.getInt("clickedStar", 0)) {
                    bundle2.putString("wzrk_c2a", "rating_4");
                    if (pushTemplateReceiver2.deepLinkList.size() > 3) {
                        str = pushTemplateReceiver2.deepLinkList.get(3);
                    } else {
                        str = pushTemplateReceiver2.deepLinkList.get(0);
                    }
                }
                if (5 == bundle2.getInt("clickedStar", 0)) {
                    bundle2.putString("wzrk_c2a", "rating_5");
                    if (pushTemplateReceiver2.deepLinkList.size() > 4) {
                        str = pushTemplateReceiver2.deepLinkList.get(4);
                    } else {
                        str = pushTemplateReceiver2.deepLinkList.get(0);
                    }
                }
                String str2 = str;
                if (VERSION.SDK_INT >= 23) {
                    Notification notificationById = k.getNotificationById(context2, i);
                    if (notificationById != null) {
                        pushTemplateReceiver2.contentViewRating = notificationById.bigContentView;
                        pushTemplateReceiver2.contentViewSmall = notificationById.contentView;
                    }
                    if (1 == bundle2.getInt("clickedStar", 0)) {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                    } else {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star1, R$drawable.pt_star_outline);
                    }
                    if (2 == bundle2.getInt("clickedStar", 0)) {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
                    } else {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star2, R$drawable.pt_star_outline);
                    }
                    if (3 == bundle2.getInt("clickedStar", 0)) {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star3, R$drawable.pt_star_filled);
                    } else {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star3, R$drawable.pt_star_outline);
                    }
                    if (4 == bundle2.getInt("clickedStar", 0)) {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star3, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star4, R$drawable.pt_star_filled);
                    } else {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star4, R$drawable.pt_star_outline);
                    }
                    if (5 == bundle2.getInt("clickedStar", 0)) {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star1, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star2, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star3, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star4, R$drawable.pt_star_filled);
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star5, R$drawable.pt_star_filled);
                    } else {
                        pushTemplateReceiver2.contentViewRating.setImageViewResource(R$id.star5, R$drawable.pt_star_outline);
                    }
                    bundle2.putString("wzrk_dl", str2);
                    pushTemplateReceiver2.contentViewRating.setOnClickPendingIntent(R$id.tVRatingConfirmation, k.getActivityIntent(bundle2, context2));
                    pushTemplateReceiver.setSmallIcon(context);
                    if (notificationById != null) {
                        builder = new Builder(context2, notificationById);
                    } else {
                        builder = pushTemplateReceiver2.setBuilderWithChannelIDCheck(pushTemplateReceiver2.requiresChannelId, "pt_silent_sound_channel", context2);
                    }
                    PendingIntent dismissIntent = PendingIntentFactory.setDismissIntent(context2, bundle2, new Intent(context2, PushTemplateReceiver.class));
                    if (pushTemplateReceiver2.notificationManager != null) {
                        builder.setSmallIcon(pushTemplateReceiver2.smallIcon).setCustomContentView(pushTemplateReceiver2.contentViewSmall).setCustomBigContentView(pushTemplateReceiver2.contentViewRating).setContentTitle(pushTemplateReceiver2.pt_title).setDeleteIntent(dismissIntent).setAutoCancel(true);
                        pushTemplateReceiver2.notificationManager.notify(i, builder.build());
                    }
                    if (VERSION.SDK_INT < 31) {
                        k.raiseCleverTapEvent(context2, pushTemplateReceiver2.config, "Rating Submitted", k.convertRatingBundleObjectToHashMap(bundle));
                        pushTemplateReceiver.handleRatingDeepLink(context, bundle, i, str2, pushTemplateReceiver2.config);
                        return;
                    }
                    return;
                }
                bundle2.putString("extras_from", "PTReceiver");
                Bundle bundle3 = (Bundle) bundle.clone();
                ActionButtonClickHandler actionButtonClickHandler = CleverTapAPI.sNotificationHandler;
                if (actionButtonClickHandler != null) {
                    actionButtonClickHandler.onMessageReceived(context2, bundle2, "FCM");
                    bundle3.putString("wzrk_dl", str2);
                    k.raiseCleverTapEvent(context2, pushTemplateReceiver2.config, "Rating Submitted", k.convertRatingBundleObjectToHashMap(bundle));
                    pushTemplateReceiver.handleRatingDeepLink(context, bundle3, i, str2, pushTemplateReceiver2.config);
                }
            } catch (ClassNotFoundException unused) {
                k.debug("No Intent Service found");
            } catch (Throwable th) {
                k.verbose("Error creating rating notification ", th);
            }
        } else {
            throw null;
        }
    }

    public static void access$300(PushTemplateReceiver pushTemplateReceiver, Context context, Bundle bundle) {
        if (pushTemplateReceiver != null) {
            int i = bundle.getInt(Constant.NOTIFICATION_ID);
            bundle.putString("wzrk_dl", null);
            if (pushTemplateReceiver.close == bundle.getBoolean("close")) {
                bundle.putString("wzrk_c2a", "5cta_close");
                pushTemplateReceiver.notificationManager.cancel(i);
            }
            k.raiseNotificationClicked(context, bundle, pushTemplateReceiver.config);
            return;
        }
        throw null;
    }

    public static void access$400(PushTemplateReceiver pushTemplateReceiver, Context context, Bundle bundle) {
        Builder builderWithChannelIDCheck;
        if (pushTemplateReceiver != null) {
            try {
                if (VERSION.SDK_INT >= 23) {
                    int i = bundle.getInt(Constant.NOTIFICATION_ID);
                    Notification notificationById = k.getNotificationById(context, i);
                    if (notificationById != null) {
                        pushTemplateReceiver.contentViewBig = notificationById.bigContentView;
                        pushTemplateReceiver.contentViewSmall = notificationById.contentView;
                    }
                    boolean z = false;
                    if (pushTemplateReceiver.pt_product_display_linear != null) {
                        if (!pushTemplateReceiver.pt_product_display_linear.isEmpty()) {
                            z = true;
                        }
                    }
                    pushTemplateReceiver.setCustomContentViewBasicKeys(pushTemplateReceiver.contentViewBig, context);
                    if (!z) {
                        pushTemplateReceiver.setCustomContentViewBasicKeys(pushTemplateReceiver.contentViewSmall, context);
                    }
                    int i2 = bundle.getInt("pt_current_position");
                    pushTemplateReceiver.contentViewBig.setDisplayedChild(R$id.carousel_image, i2);
                    pushTemplateReceiver.imageList = bundle.getStringArrayList("pt_image_list");
                    pushTemplateReceiver.deepLinkList = bundle.getStringArrayList("pt_deeplink_list");
                    pushTemplateReceiver.bigTextList = bundle.getStringArrayList("pt_big_text_list");
                    pushTemplateReceiver.smallTextList = bundle.getStringArrayList("pt_small_text_list");
                    pushTemplateReceiver.priceList = bundle.getStringArrayList("pt_price_list");
                    String str = pushTemplateReceiver.deepLinkList.get(i2);
                    if (!z) {
                        pushTemplateReceiver.contentViewBig.setTextViewText(R$id.title, pushTemplateReceiver.bigTextList.get(i2));
                    } else {
                        pushTemplateReceiver.contentViewBig.setTextViewText(R$id.product_name, pushTemplateReceiver.bigTextList.get(i2));
                    }
                    pushTemplateReceiver.contentViewBig.setTextViewText(R$id.msg, pushTemplateReceiver.smallTextList.get(i2));
                    pushTemplateReceiver.contentViewBig.setTextViewText(R$id.product_price, pushTemplateReceiver.priceList.get(i2));
                    bundle.remove("pt_current_position");
                    Bundle bundle2 = (Bundle) bundle.clone();
                    bundle2.putBoolean("img1", true);
                    bundle2.putInt(Constant.NOTIFICATION_ID, i);
                    bundle2.putString("pt_buy_now_dl", str);
                    bundle2.putBoolean("buynow", true);
                    pushTemplateReceiver.contentViewBig.setOnClickPendingIntent(R$id.product_action, PendingIntentFactory.getCtaLaunchPendingIntent(context, bundle2, str, i));
                    if (notificationById != null) {
                        builderWithChannelIDCheck = new Builder(context, notificationById);
                    } else {
                        builderWithChannelIDCheck = pushTemplateReceiver.setBuilderWithChannelIDCheck(pushTemplateReceiver.requiresChannelId, "pt_silent_sound_channel", context);
                    }
                    Builder builder = builderWithChannelIDCheck;
                    Bundle bundle3 = (Bundle) bundle.clone();
                    bundle3.putString("wzrk_dl", str);
                    PendingIntent pendingIntent = PendingIntentFactory.getPendingIntent(context, i, bundle3, true, 20, null);
                    if (pushTemplateReceiver.notificationManager != null) {
                        PendingIntent dismissIntent = PendingIntentFactory.setDismissIntent(context, bundle, new Intent(context, PushTemplateReceiver.class));
                        pushTemplateReceiver.setSmallIcon(context);
                        pushTemplateReceiver.setNotificationBuilderBasics(builder, pushTemplateReceiver.contentViewSmall, pushTemplateReceiver.contentViewBig, pushTemplateReceiver.pt_title, pendingIntent, dismissIntent);
                        pushTemplateReceiver.notificationManager.notify(i, builder.build());
                        return;
                    }
                    return;
                }
                bundle.putString("extras_from", "PTReceiver");
                ActionButtonClickHandler actionButtonClickHandler = CleverTapAPI.sNotificationHandler;
                if (actionButtonClickHandler != null) {
                    actionButtonClickHandler.onMessageReceived(context, bundle, "FCM");
                }
            } catch (Throwable th) {
                k.verbose("Error creating product display notification ", th);
            }
        } else {
            throw null;
        }
    }

    public static void access$500(PushTemplateReceiver pushTemplateReceiver, Context context, Bundle bundle, Intent intent) {
        CleverTapAPI cleverTapAPI2;
        Builder builder;
        Style style;
        Intent intent2;
        if (pushTemplateReceiver != null) {
            Bundle resultsFromIntent = RemoteInput.getResultsFromIntent(intent);
            PendingIntent dismissIntent = PendingIntentFactory.setDismissIntent(context, bundle, new Intent(context, PushTemplateReceiver.class));
            pushTemplateReceiver.config = (CleverTapInstanceConfig) bundle.getParcelable("config");
            if (resultsFromIntent != null) {
                CharSequence charSequence = resultsFromIntent.getCharSequence("pt_input_reply");
                int i = bundle.getInt(Constant.NOTIFICATION_ID);
                if (charSequence != null) {
                    k.verbose("Processing Input from Input Template");
                    bundle.putString("pt_input_reply", charSequence.toString());
                    CleverTapInstanceConfig cleverTapInstanceConfig = pushTemplateReceiver.config;
                    if (cleverTapInstanceConfig != null) {
                        cleverTapAPI2 = CleverTapAPI.instanceWithConfig(context, cleverTapInstanceConfig);
                    } else {
                        cleverTapAPI2 = CleverTapAPI.getDefaultInstance(context);
                    }
                    String string = bundle.getString("pt_input_reply");
                    HashMap hashMap = new HashMap();
                    for (String str : bundle.keySet()) {
                        if (str.contains("pt_event_property")) {
                            if (bundle.getString(str) == null || bundle.getString(str).isEmpty()) {
                                k.verbose("Property Key is Empty. Skipping Property: " + str);
                            } else if (str.contains("pt_event_property_")) {
                                String[] split = str.split("pt_event_property_");
                                if (bundle.getString(str).equalsIgnoreCase("pt_input_reply")) {
                                    hashMap.put(split[1], string);
                                } else {
                                    hashMap.put(split[1], bundle.getString(str));
                                }
                            } else {
                                k.verbose("Property " + str + " does not have the separator");
                            }
                        }
                    }
                    String eventNameFromExtras = k.getEventNameFromExtras(bundle);
                    if (eventNameFromExtras != null && !eventNameFromExtras.isEmpty()) {
                        if (cleverTapAPI2 != null) {
                            cleverTapAPI2.pushEvent(eventNameFromExtras, hashMap);
                        } else {
                            k.debug("CleverTap instance is NULL, not raising the event");
                        }
                    }
                    if (pushTemplateReceiver.requiresChannelId) {
                        builder = new Builder(context, (String) "pt_silent_sound_channel");
                    } else {
                        builder = new Builder(context);
                    }
                    pushTemplateReceiver.setSmallIcon(context);
                    builder.setSmallIcon(pushTemplateReceiver.smallIcon).setContentTitle(pushTemplateReceiver.pt_title).setContentText(bundle.getString("pt_input_feedback")).setTimeoutAfter(1300).setDeleteIntent(dismissIntent).setWhen(System.currentTimeMillis()).setAutoCancel(true);
                    String str2 = pushTemplateReceiver.pt_big_img_alt;
                    if (str2 == null || !str2.startsWith(NetworkRequestHandler.SCHEME_HTTP)) {
                        style = new BigTextStyle().bigText(bundle.getString("pt_input_feedback"));
                    } else {
                        try {
                            Bitmap notificationBitmap = k.getNotificationBitmap(str2, false, context);
                            if (notificationBitmap != null) {
                                style = new BigPictureStyle().setSummaryText(bundle.getString("pt_input_feedback")).bigPicture(notificationBitmap);
                            } else {
                                throw new Exception("Failed to fetch big picture!");
                            }
                        } catch (Throwable th) {
                            Style bigText = new BigTextStyle().bigText(bundle.getString("pt_input_feedback"));
                            k.verbose("Falling back to big text notification, couldn't fetch big picture", th);
                            style = bigText;
                        }
                    }
                    builder.setStyle(style);
                    pushTemplateReceiver.notificationManager.notify(i, builder.build());
                    if (VERSION.SDK_INT >= 31) {
                        return;
                    }
                    if (bundle.getString("pt_input_auto_open") != null || bundle.getBoolean("pt_input_auto_open")) {
                        try {
                            Thread.sleep(1300);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (!bundle.containsKey("wzrk_dl") || bundle.getString("wzrk_dl") == null) {
                            intent2 = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                            if (intent2 == null) {
                                return;
                            }
                        } else {
                            intent2 = new Intent("android.intent.action.VIEW", Uri.parse(intent.getStringExtra("wzrk_dl")));
                            k.setPackageNameFromResolveInfoList(context, intent2);
                        }
                        intent2.putExtras(bundle);
                        intent2.putExtra("pt_reply", charSequence);
                        intent2.removeExtra("wzrk_acts");
                        intent2.setFlags(872415232);
                        context.startActivity(intent2);
                        return;
                    }
                    return;
                }
                k.verbose("PushTemplateReceiver: Input is Empty");
                return;
            }
            return;
        }
        throw null;
    }

    public static void access$600(PushTemplateReceiver pushTemplateReceiver, Context context, Bundle bundle) {
        int i;
        Builder builderWithChannelIDCheck;
        PushTemplateReceiver pushTemplateReceiver2 = pushTemplateReceiver;
        Context context2 = context;
        Bundle bundle2 = bundle;
        if (pushTemplateReceiver2 != null) {
            try {
                if (VERSION.SDK_INT >= 23) {
                    int i2 = bundle2.getInt(Constant.NOTIFICATION_ID);
                    Notification notificationById = k.getNotificationById(context, i2);
                    if (notificationById != null) {
                        pushTemplateReceiver2.contentViewManualCarousel = notificationById.bigContentView;
                        pushTemplateReceiver2.contentViewSmall = notificationById.contentView;
                    }
                    pushTemplateReceiver.setCustomContentViewBasicKeys(pushTemplateReceiver2.contentViewManualCarousel, context);
                    boolean z = bundle2.getBoolean("right_swipe");
                    pushTemplateReceiver2.imageList = bundle2.getStringArrayList("pt_image_list");
                    pushTemplateReceiver2.deepLinkList = bundle2.getStringArrayList("pt_deeplink_list");
                    int i3 = bundle2.getInt("pt_manual_carousel_current");
                    if (z) {
                        pushTemplateReceiver2.contentViewManualCarousel.showNext(R$id.carousel_image);
                        pushTemplateReceiver2.contentViewManualCarousel.showNext(R$id.carousel_image_right);
                        pushTemplateReceiver2.contentViewManualCarousel.showNext(R$id.carousel_image_left);
                        i = i3 == pushTemplateReceiver2.imageList.size() - 1 ? 0 : i3 + 1;
                    } else {
                        pushTemplateReceiver2.contentViewManualCarousel.showPrevious(R$id.carousel_image);
                        pushTemplateReceiver2.contentViewManualCarousel.showPrevious(R$id.carousel_image_right);
                        pushTemplateReceiver2.contentViewManualCarousel.showPrevious(R$id.carousel_image_left);
                        i = i3 == 0 ? pushTemplateReceiver2.imageList.size() - 1 : i3 - 1;
                    }
                    String str = "";
                    if (pushTemplateReceiver2.deepLinkList != null && pushTemplateReceiver2.deepLinkList.size() == pushTemplateReceiver2.imageList.size()) {
                        str = pushTemplateReceiver2.deepLinkList.get(i);
                    } else if (pushTemplateReceiver2.deepLinkList != null && pushTemplateReceiver2.deepLinkList.size() == 1) {
                        str = pushTemplateReceiver2.deepLinkList.get(0);
                    } else if (pushTemplateReceiver2.deepLinkList != null && pushTemplateReceiver2.deepLinkList.size() > i) {
                        str = pushTemplateReceiver2.deepLinkList.get(i);
                    } else if (pushTemplateReceiver2.deepLinkList != null && pushTemplateReceiver2.deepLinkList.size() < i) {
                        str = pushTemplateReceiver2.deepLinkList.get(0);
                    }
                    bundle2.putInt("pt_manual_carousel_current", i);
                    bundle2.remove("right_swipe");
                    bundle2.putString("wzrk_dl", str);
                    bundle2.putInt("manual_carousel_from", i3);
                    pushTemplateReceiver2.contentViewManualCarousel.setOnClickPendingIntent(R$id.rightArrowPos0, PendingIntentFactory.getPendingIntent(context, i2, bundle, false, 4, null));
                    pushTemplateReceiver2.contentViewManualCarousel.setOnClickPendingIntent(R$id.leftArrowPos0, PendingIntentFactory.getPendingIntent(context, i2, bundle, false, 5, null));
                    PendingIntent pendingIntent = PendingIntentFactory.getPendingIntent(context, i2, bundle, true, 3, null);
                    if (notificationById != null) {
                        builderWithChannelIDCheck = new Builder(context, notificationById);
                    } else {
                        builderWithChannelIDCheck = pushTemplateReceiver.setBuilderWithChannelIDCheck(pushTemplateReceiver2.requiresChannelId, "pt_silent_sound_channel", context);
                    }
                    Builder builder = builderWithChannelIDCheck;
                    PendingIntent pendingIntent2 = PendingIntentFactory.getPendingIntent(context, i2, bundle, false, 6, null);
                    pushTemplateReceiver.setSmallIcon(context);
                    pushTemplateReceiver.setNotificationBuilderBasics(builder, pushTemplateReceiver2.contentViewSmall, pushTemplateReceiver2.contentViewManualCarousel, pushTemplateReceiver2.pt_title, pendingIntent, pendingIntent2);
                    pushTemplateReceiver2.notificationManager.notify(i2, builder.build());
                    return;
                }
                bundle2.putString("extras_from", "PTReceiver");
                ActionButtonClickHandler actionButtonClickHandler = CleverTapAPI.sNotificationHandler;
                if (actionButtonClickHandler != null) {
                    actionButtonClickHandler.onMessageReceived(context, bundle2, "FCM");
                }
            } catch (Throwable th) {
                k.verbose("Error creating manual carousel notification ", th);
            }
        } else {
            throw null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void handleRatingDeepLink(Context context, Bundle bundle, int i, String str, CleverTapInstanceConfig cleverTapInstanceConfig) throws InterruptedException {
        Intent intent;
        Thread.sleep(1000);
        this.notificationManager.cancel(i);
        String str2 = this.pt_rating_toast;
        if (!(str2 == null || str2.isEmpty() || cleverTapInstanceConfig == null)) {
            Task mainTask = CTExecutorFactory.executors(cleverTapInstanceConfig).mainTask();
            mainTask.executor.execute(new Runnable("PushTemplatesUtils#showToast", new Utils$1(str2, context)) {
                public final /* synthetic */ Callable val$callable;
                public final /* synthetic */ String val$logTag;

                {
                    this.val$logTag = r2;
                    this.val$callable = r3;
                }

                public void run() {
                    try {
                        Logger logger = Task.this.config.getLogger();
                        logger.verbose(Task.this.taskName + " Task: " + this.val$logTag + " starting on..." + Thread.currentThread().getName());
                        TResult call = this.val$callable.call();
                        Logger logger2 = Task.this.config.getLogger();
                        logger2.verbose(Task.this.taskName + " Task: " + this.val$logTag + " executed successfully on..." + Thread.currentThread().getName());
                        Task task = Task.this;
                        if (task != null) {
                            STATE state = STATE.SUCCESS;
                            task.result = call;
                            for (SuccessExecutable<TResult> execute : task.successExecutables) {
                                execute.execute(task.result);
                            }
                            return;
                        }
                        throw null;
                    } catch (Exception e2) {
                        Task task2 = Task.this;
                        if (task2 != null) {
                            STATE state2 = STATE.FAILED;
                            for (FailureExecutable<Exception> execute2 : task2.failureExecutables) {
                                execute2.execute(e2);
                            }
                            Logger logger3 = Task.this.config.getLogger();
                            logger3.verbose(Task.this.taskName + " Task: " + this.val$logTag + " failed to execute on..." + Thread.currentThread().getName(), (Throwable) e2);
                            e2.printStackTrace();
                            return;
                        }
                        throw null;
                    }
                }
            });
        }
        context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        if (bundle.containsKey("wzrk_dl")) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(bundle.getString("wzrk_dl")));
            Utils.setPackageNameFromResolveInfoList(context, intent);
        } else {
            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (intent == null) {
                return;
            }
        }
        intent.putExtras(bundle);
        intent.putExtra("wzrk_dl", str);
        intent.removeExtra("wzrk_acts");
        intent.putExtra("wzrk_from", "CTPushNotificationReceiver");
        intent.setFlags(872415232);
        context.startActivity(intent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (((android.os.Build.VERSION.SDK_INT < 26 || r6 == null || r6.getImportance() == 0) ? false : true) == false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(final android.content.Context r11, final android.content.Intent r12) {
        /*
            r10 = this;
            java.lang.String r0 = "notification"
            java.lang.Object r1 = r11.getSystemService(r0)
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
            r2 = 1
            r3 = 26
            r4 = 0
            if (r1 != 0) goto L_0x000f
            goto L_0x007b
        L_0x000f:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r3) goto L_0x007b
            java.lang.String r5 = "pt_silent_sound_channel"
            android.app.NotificationChannel r6 = r1.getNotificationChannel(r5)
            if (r6 == 0) goto L_0x0036
            android.app.NotificationChannel r6 = r1.getNotificationChannel(r5)
            if (r6 == 0) goto L_0x007b
            android.app.NotificationChannel r6 = r1.getNotificationChannel(r5)
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r3) goto L_0x0033
            if (r6 == 0) goto L_0x0033
            int r6 = r6.getImportance()
            if (r6 == 0) goto L_0x0033
            r6 = 1
            goto L_0x0034
        L_0x0033:
            r6 = 0
        L_0x0034:
            if (r6 != 0) goto L_0x007b
        L_0x0036:
            java.lang.String r6 = "android.resource://"
            java.lang.StringBuilder r6 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r6)
            java.lang.String r7 = r11.getPackageName()
            r6.append(r7)
            java.lang.String r7 = "/raw/"
            r6.append(r7)
            java.lang.String r7 = "pt_silent_sound"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.net.Uri r6 = android.net.Uri.parse(r6)
            android.app.NotificationChannel r7 = new android.app.NotificationChannel
            r8 = 4
            java.lang.String r9 = "Silent Channel"
            r7.<init>(r5, r9, r8)
            if (r6 == 0) goto L_0x0070
            android.media.AudioAttributes$Builder r5 = new android.media.AudioAttributes$Builder
            r5.<init>()
            r8 = 5
            android.media.AudioAttributes$Builder r5 = r5.setUsage(r8)
            android.media.AudioAttributes r5 = r5.build()
            r7.setSound(r6, r5)
        L_0x0070:
            java.lang.String r5 = "A channel to silently update notifications"
            r7.setDescription(r5)
            r7.setShowBadge(r4)
            r1.createNotificationChannel(r7)
        L_0x007b:
            android.os.Bundle r1 = r12.getExtras()
            if (r1 == 0) goto L_0x0247
            android.os.Bundle r1 = r12.getExtras()
            java.lang.String r5 = "wzrk_acct_id"
            java.lang.String r5 = r1.getString(r5)
            com.clevertap.android.sdk.CleverTapAPI r5 = com.clevertap.android.sdk.CleverTapAPI.fromAccountId(r11, r5)
            r10.cleverTapAPI = r5
            java.lang.String r5 = "pt_id"
            java.lang.String r5 = r12.getStringExtra(r5)
            r10.pt_id = r5
            java.lang.String r5 = "pt_msg"
            java.lang.String r5 = r1.getString(r5)
            r10.pt_msg = r5
            java.lang.String r5 = "pt_msg_summary"
            java.lang.String r5 = r1.getString(r5)
            r10.pt_msg_summary = r5
            java.lang.String r5 = "pt_title"
            java.lang.String r5 = r1.getString(r5)
            r10.pt_title = r5
            java.lang.String r5 = "pt_default_dl"
            java.lang.String r5 = r1.getString(r5)
            r10.pt_rating_default_dl = r5
            java.util.ArrayList r5 = co.hyperverge.hypersnapsdk.c.k.getImageListFromExtras(r1)
            r10.imageList = r5
            java.util.ArrayList r5 = co.hyperverge.hypersnapsdk.c.k.getDeepLinkListFromExtras(r1)
            r10.deepLinkList = r5
            java.util.ArrayList r5 = co.hyperverge.hypersnapsdk.c.k.getBigTextFromExtras(r1)
            r10.bigTextList = r5
            java.util.ArrayList r5 = co.hyperverge.hypersnapsdk.c.k.getSmallTextFromExtras(r1)
            r10.smallTextList = r5
            java.util.ArrayList r5 = co.hyperverge.hypersnapsdk.c.k.getPriceFromExtras(r1)
            r10.priceList = r5
            java.lang.String r5 = "pt_product_display_linear"
            java.lang.String r5 = r1.getString(r5)
            r10.pt_product_display_linear = r5
            java.lang.Object r0 = r11.getSystemService(r0)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            r10.notificationManager = r0
            java.lang.String r0 = "wzrk_cid"
            java.lang.String r5 = ""
            java.lang.String r0 = r1.getString(r0, r5)
            r10.channelId = r0
            java.lang.String r0 = "pt_big_img_alt"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_big_img_alt = r0
            java.lang.String r0 = "pt_small_icon_clr"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_small_icon_clr = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x0106
            goto L_0x0107
        L_0x0106:
            r2 = 0
        L_0x0107:
            r10.requiresChannelId = r2
            java.lang.String r0 = "pt_dismiss_intent"
            boolean r0 = r1.getBoolean(r0, r4)
            r10.pt_dismiss_intent = r0
            java.lang.String r0 = "pt_rating_toast"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_rating_toast = r0
            java.lang.String r0 = "pt_subtitle"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_subtitle = r0
            java.lang.String r0 = r10.pt_title
            if (r0 == 0) goto L_0x012b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0133
        L_0x012b:
            java.lang.String r0 = "nt"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_title = r0
        L_0x0133:
            java.lang.String r0 = r10.pt_msg
            if (r0 == 0) goto L_0x013d
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0145
        L_0x013d:
            java.lang.String r0 = "nm"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_msg = r0
        L_0x0145:
            java.lang.String r0 = r10.pt_msg_summary
            if (r0 == 0) goto L_0x014f
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0157
        L_0x014f:
            java.lang.String r0 = "wzrk_nms"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_msg_summary = r0
        L_0x0157:
            java.lang.String r0 = r10.pt_big_img
            if (r0 == 0) goto L_0x0161
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0169
        L_0x0161:
            java.lang.String r0 = "wzrk_bp"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_big_img = r0
        L_0x0169:
            java.lang.String r0 = r10.pt_rating_default_dl
            if (r0 == 0) goto L_0x0173
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x017b
        L_0x0173:
            java.lang.String r0 = "wzrk_dl"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_rating_default_dl = r0
        L_0x017b:
            java.lang.String r0 = r10.pt_meta_clr
            java.lang.String r2 = "wzrk_clr"
            if (r0 == 0) goto L_0x0187
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x018d
        L_0x0187:
            java.lang.String r0 = r1.getString(r2)
            r10.pt_meta_clr = r0
        L_0x018d:
            java.lang.String r0 = r10.pt_small_icon_clr
            if (r0 == 0) goto L_0x0197
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x019d
        L_0x0197:
            java.lang.String r0 = r1.getString(r2)
            r10.pt_small_icon_clr = r0
        L_0x019d:
            java.lang.String r0 = r10.pt_subtitle
            if (r0 == 0) goto L_0x01a7
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01af
        L_0x01a7:
            java.lang.String r0 = "wzrk_st"
            java.lang.String r0 = r1.getString(r0)
            r10.pt_subtitle = r0
        L_0x01af:
            java.lang.String r0 = r10.pt_small_icon_clr
            if (r0 == 0) goto L_0x01b9
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01bf
        L_0x01b9:
            java.lang.String r0 = r1.getString(r2)
            r10.pt_small_icon_clr = r0
        L_0x01bf:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r3) goto L_0x01fe
            r0 = 0
            java.lang.String r2 = r10.channelId
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x01de
            java.lang.String r0 = "Unable to render notification, channelId is required but not provided in the notification payload: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r2 = r1.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x01f8
        L_0x01de:
            android.app.NotificationManager r2 = r10.notificationManager
            if (r2 == 0) goto L_0x01f8
            java.lang.String r3 = r10.channelId
            android.app.NotificationChannel r2 = r2.getNotificationChannel(r3)
            if (r2 != 0) goto L_0x01f8
            java.lang.String r0 = "Unable to render notification, channelId: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r2 = r10.channelId
            java.lang.String r3 = " not registered by the app."
            java.lang.String r0 = com.android.tools.r8.GeneratedOutlineSupport.outline62(r0, r2, r3)
        L_0x01f8:
            if (r0 == 0) goto L_0x01fe
            co.hyperverge.hypersnapsdk.c.k.verbose(r0)
            return
        L_0x01fe:
            java.lang.String r0 = r10.pt_id
            if (r0 == 0) goto L_0x0208
            com.clevertap.android.pushtemplates.TemplateType r0 = com.clevertap.android.pushtemplates.TemplateType.fromString(r0)
            r10.templateType = r0
        L_0x0208:
            com.clevertap.android.sdk.CleverTapAPI r0 = r10.cleverTapAPI
            if (r0 == 0) goto L_0x0242
            com.clevertap.android.sdk.CoreState r0 = r0.coreState     // Catch:{ Exception -> 0x022c }
            com.clevertap.android.sdk.CleverTapInstanceConfig r0 = r0.config     // Catch:{ Exception -> 0x022c }
            r10.config = r0     // Catch:{ Exception -> 0x022c }
            com.clevertap.android.sdk.task.CTExecutors r0 = com.clevertap.android.sdk.task.CTExecutorFactory.executors(r0)     // Catch:{ Exception -> 0x022c }
            com.clevertap.android.sdk.task.Task r0 = r0.postAsyncSafelyTask()     // Catch:{ Exception -> 0x022c }
            java.lang.String r2 = "PushTemplateReceiver#renderNotification"
            com.clevertap.android.pushtemplates.PushTemplateReceiver$1 r3 = new com.clevertap.android.pushtemplates.PushTemplateReceiver$1     // Catch:{ Exception -> 0x022c }
            r3.<init>(r11, r12, r1)     // Catch:{ Exception -> 0x022c }
            java.util.concurrent.Executor r11 = r0.executor     // Catch:{ Exception -> 0x022c }
            com.clevertap.android.sdk.task.Task$1 r12 = new com.clevertap.android.sdk.task.Task$1     // Catch:{ Exception -> 0x022c }
            r12.<init>(r2, r3)     // Catch:{ Exception -> 0x022c }
            r11.execute(r12)     // Catch:{ Exception -> 0x022c }
            goto L_0x0247
        L_0x022c:
            r11 = move-exception
            java.lang.String r12 = "Couldn't render notification: "
            java.lang.StringBuilder r12 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r12)
            java.lang.String r11 = r11.getLocalizedMessage()
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            co.hyperverge.hypersnapsdk.c.k.verbose(r11)
            goto L_0x0247
        L_0x0242:
            java.lang.String r11 = "clevertap instance is null, not running PushTemplateReceiver#renderNotification"
            co.hyperverge.hypersnapsdk.c.k.verbose(r11)
        L_0x0247:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.PushTemplateReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    public final Builder setBuilderWithChannelIDCheck(boolean z, String str, Context context) {
        if (z) {
            return new Builder(context, str);
        }
        return new Builder(context);
    }

    public final void setCustomContentViewBasicKeys(RemoteViews remoteViews, Context context) {
        remoteViews.setTextViewText(R$id.app_name, k.getApplicationName(context));
        remoteViews.setTextViewText(R$id.timestamp, DateUtils.formatDateTime(context, System.currentTimeMillis(), 1));
        String str = this.pt_subtitle;
        if (str == null || str.isEmpty()) {
            remoteViews.setViewVisibility(R$id.subtitle, 8);
            remoteViews.setViewVisibility(R$id.sep_subtitle, 8);
        } else if (VERSION.SDK_INT >= 24) {
            remoteViews.setTextViewText(R$id.subtitle, Html.fromHtml(this.pt_subtitle, 0));
        } else {
            remoteViews.setTextViewText(R$id.subtitle, Html.fromHtml(this.pt_subtitle));
        }
        String str2 = this.pt_meta_clr;
        if (str2 != null && !str2.isEmpty()) {
            remoteViews.setTextColor(R$id.app_name, k.getColour(this.pt_meta_clr, "#A6A6A6"));
            remoteViews.setTextColor(R$id.timestamp, k.getColour(this.pt_meta_clr, "#A6A6A6"));
            remoteViews.setTextColor(R$id.subtitle, k.getColour(this.pt_meta_clr, "#A6A6A6"));
        }
    }

    public final void setNotificationBuilderBasics(Builder builder, RemoteViews remoteViews, RemoteViews remoteViews2, String str, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        builder.setSmallIcon(this.smallIcon).setCustomContentView(remoteViews).setCustomBigContentView(remoteViews2).setContentTitle(Html.fromHtml(str)).setDeleteIntent(pendingIntent2).setContentIntent(pendingIntent).setDefaults(5).setWhen(System.currentTimeMillis()).setAutoCancel(true);
    }

    public final void setSmallIcon(Context context) {
        try {
            String str = null;
            try {
                Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CLEVERTAP_NOTIFICATION_ICON");
                if (obj != null) {
                    str = obj.toString();
                }
            } catch (Throwable unused) {
            }
            if (str != null) {
                int identifier = context.getResources().getIdentifier(str, "drawable", context.getPackageName());
                this.smallIcon = identifier;
                if (identifier == 0) {
                    throw new IllegalArgumentException();
                }
                return;
            }
            throw new IllegalArgumentException();
        } catch (Throwable unused2) {
            this.smallIcon = context.getApplicationInfo().icon;
        }
    }
}
