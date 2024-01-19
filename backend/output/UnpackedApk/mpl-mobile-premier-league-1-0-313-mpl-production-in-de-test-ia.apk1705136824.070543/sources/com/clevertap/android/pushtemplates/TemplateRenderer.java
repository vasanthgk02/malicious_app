package com.clevertap.android.pushtemplates;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat.Builder;
import co.hyperverge.hypersnapsdk.c.k;
import com.clevertap.android.pushtemplates.content.ContentView;
import com.clevertap.android.pushtemplates.content.FiveIconBigContentView;
import com.clevertap.android.pushtemplates.content.FiveIconSmallContentView;
import com.clevertap.android.pushtemplates.styles.AutoCarouselStyle;
import com.clevertap.android.pushtemplates.styles.BasicStyle;
import com.clevertap.android.pushtemplates.styles.FiveIconStyle;
import com.clevertap.android.pushtemplates.styles.InputBoxStyle;
import com.clevertap.android.pushtemplates.styles.ManualCarouselStyle;
import com.clevertap.android.pushtemplates.styles.ProductDisplayStyle;
import com.clevertap.android.pushtemplates.styles.RatingStyle;
import com.clevertap.android.pushtemplates.styles.TimerStyle;
import com.clevertap.android.pushtemplates.styles.ZeroBezelStyle;
import com.clevertap.android.pushtemplates.validators.Validator;
import com.clevertap.android.pushtemplates.validators.ValidatorFactory;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.pushnotification.INotificationRenderer;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ©\u00012\u00020\u0001:\u0004©\u0001ª\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0001\u001a\u00020\u0012H\u0016J\u0013\u0010\u0001\u001a\u0004\u0018\u00010:2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0003\u0010\u0001J\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J6\u0010\u0001\u001a\u0005\u0018\u00010 \u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010¡\u0001\u001a\u00030 \u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0016J8\u0010¢\u0001\u001a\u0005\u0018\u00010 \u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\b\u0010¡\u0001\u001a\u00030 \u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010£\u0001\u001a\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001b\u0010¤\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J$\u0010¥\u0001\u001a\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J3\u0010¦\u0001\u001a\u00030\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\t\u0010§\u0001\u001a\u0004\u0018\u00010\"H\u0003¢\u0006\u0003\u0010¨\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\"\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001c\u0010+\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R\u0010\u00103\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0016\u00105\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010-\"\u0004\b=\u0010/R\u001a\u0010>\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010$\"\u0004\bI\u0010&R\u0010\u0010J\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010K\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010-\"\u0004\bM\u0010/R\u001c\u0010N\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010-\"\u0004\bP\u0010/R\u001c\u0010Q\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010-\"\u0004\bS\u0010/R\u001c\u0010T\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010-\"\u0004\bV\u0010/R\u001c\u0010W\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010-\"\u0004\bY\u0010/R\u001c\u0010Z\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010-\"\u0004\b\\\u0010/R\u001c\u0010]\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010-\"\u0004\b_\u0010/R\u0010\u0010`\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010a\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010-\"\u0004\bc\u0010/R\u001c\u0010d\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010-\"\u0004\bf\u0010/R\u001c\u0010g\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010-\"\u0004\bi\u0010/R\u001c\u0010j\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010-\"\u0004\bl\u0010/R\u001c\u0010m\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010-\"\u0004\bo\u0010/R\u001c\u0010p\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010-\"\u0004\br\u0010/R\u001c\u0010s\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010-\"\u0004\bu\u0010/R\u001c\u0010v\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010D\"\u0004\bx\u0010FR\u001c\u0010y\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010-\"\u0004\b{\u0010/R\u001c\u0010|\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010-\"\u0004\b~\u0010/R\u001e\u0010\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010&R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010&R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0001\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010-\"\u0005\b\u0001\u0010/R\u001d\u0010\u0001\u001a\u00020\"X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010$\"\u0005\b\u0001\u0010&R%\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0014\"\u0005\b\u0001\u0010\u0016R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006«\u0001"}, d2 = {"Lcom/clevertap/android/pushtemplates/TemplateRenderer;", "Lcom/clevertap/android/sdk/pushnotification/INotificationRenderer;", "context", "Landroid/content/Context;", "extras", "Landroid/os/Bundle;", "(Landroid/content/Context;Landroid/os/Bundle;)V", "config", "Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/clevertap/android/sdk/CleverTapInstanceConfig;)V", "actions", "Lorg/json/JSONArray;", "getActions", "()Lorg/json/JSONArray;", "setActions", "(Lorg/json/JSONArray;)V", "bigTextList", "Ljava/util/ArrayList;", "", "getBigTextList$clevertap_pushtemplates_release", "()Ljava/util/ArrayList;", "setBigTextList$clevertap_pushtemplates_release", "(Ljava/util/ArrayList;)V", "getConfig$clevertap_pushtemplates_release", "()Lcom/clevertap/android/sdk/CleverTapInstanceConfig;", "setConfig$clevertap_pushtemplates_release", "(Lcom/clevertap/android/sdk/CleverTapInstanceConfig;)V", "deepLinkList", "getDeepLinkList$clevertap_pushtemplates_release", "setDeepLinkList$clevertap_pushtemplates_release", "imageList", "getImageList$clevertap_pushtemplates_release", "setImageList$clevertap_pushtemplates_release", "notificationId", "", "getNotificationId$clevertap_pushtemplates_release", "()I", "setNotificationId$clevertap_pushtemplates_release", "(I)V", "pID", "priceList", "getPriceList$clevertap_pushtemplates_release", "setPriceList$clevertap_pushtemplates_release", "pt_bg", "getPt_bg$clevertap_pushtemplates_release", "()Ljava/lang/String;", "setPt_bg$clevertap_pushtemplates_release", "(Ljava/lang/String;)V", "pt_big_img", "getPt_big_img$clevertap_pushtemplates_release", "setPt_big_img$clevertap_pushtemplates_release", "pt_big_img_alt", "pt_cancel_notif_id", "pt_cancel_notif_ids", "pt_chrono_title_clr", "getPt_chrono_title_clr$clevertap_pushtemplates_release", "setPt_chrono_title_clr$clevertap_pushtemplates_release", "pt_collapse_key", "", "pt_dismiss_on_click", "getPt_dismiss_on_click$clevertap_pushtemplates_release", "setPt_dismiss_on_click$clevertap_pushtemplates_release", "pt_dot", "getPt_dot$clevertap_pushtemplates_release", "setPt_dot$clevertap_pushtemplates_release", "pt_dot_sep", "Landroid/graphics/Bitmap;", "getPt_dot_sep$clevertap_pushtemplates_release", "()Landroid/graphics/Bitmap;", "setPt_dot_sep$clevertap_pushtemplates_release", "(Landroid/graphics/Bitmap;)V", "pt_flip_interval", "getPt_flip_interval$clevertap_pushtemplates_release", "setPt_flip_interval$clevertap_pushtemplates_release", "pt_id", "pt_input_auto_open", "getPt_input_auto_open$clevertap_pushtemplates_release", "setPt_input_auto_open$clevertap_pushtemplates_release", "pt_input_feedback", "getPt_input_feedback", "setPt_input_feedback", "pt_input_label", "getPt_input_label$clevertap_pushtemplates_release", "setPt_input_label$clevertap_pushtemplates_release", "pt_large_icon", "getPt_large_icon$clevertap_pushtemplates_release", "setPt_large_icon$clevertap_pushtemplates_release", "pt_manual_carousel_type", "getPt_manual_carousel_type$clevertap_pushtemplates_release", "setPt_manual_carousel_type$clevertap_pushtemplates_release", "pt_meta_clr", "getPt_meta_clr$clevertap_pushtemplates_release", "setPt_meta_clr$clevertap_pushtemplates_release", "pt_msg", "getPt_msg$clevertap_pushtemplates_release", "setPt_msg$clevertap_pushtemplates_release", "pt_msg_alt", "pt_msg_clr", "getPt_msg_clr$clevertap_pushtemplates_release", "setPt_msg_clr$clevertap_pushtemplates_release", "pt_msg_summary", "getPt_msg_summary$clevertap_pushtemplates_release", "setPt_msg_summary$clevertap_pushtemplates_release", "pt_product_display_action", "getPt_product_display_action$clevertap_pushtemplates_release", "setPt_product_display_action$clevertap_pushtemplates_release", "pt_product_display_action_clr", "getPt_product_display_action_clr$clevertap_pushtemplates_release", "setPt_product_display_action_clr$clevertap_pushtemplates_release", "pt_product_display_action_text_clr", "getPt_product_display_action_text_clr$clevertap_pushtemplates_release", "setPt_product_display_action_text_clr$clevertap_pushtemplates_release", "pt_product_display_linear", "getPt_product_display_linear$clevertap_pushtemplates_release", "setPt_product_display_linear$clevertap_pushtemplates_release", "pt_rating_default_dl", "getPt_rating_default_dl$clevertap_pushtemplates_release", "setPt_rating_default_dl$clevertap_pushtemplates_release", "pt_small_icon", "getPt_small_icon$clevertap_pushtemplates_release", "setPt_small_icon$clevertap_pushtemplates_release", "pt_small_icon_clr", "getPt_small_icon_clr$clevertap_pushtemplates_release", "setPt_small_icon_clr$clevertap_pushtemplates_release", "pt_small_view", "getPt_small_view$clevertap_pushtemplates_release", "setPt_small_view$clevertap_pushtemplates_release", "pt_subtitle", "getPt_subtitle$clevertap_pushtemplates_release", "setPt_subtitle$clevertap_pushtemplates_release", "pt_timer_end", "getPt_timer_end", "setPt_timer_end", "pt_timer_threshold", "getPt_timer_threshold", "setPt_timer_threshold", "pt_title", "getPt_title$clevertap_pushtemplates_release", "setPt_title$clevertap_pushtemplates_release", "pt_title_alt", "pt_title_clr", "getPt_title_clr$clevertap_pushtemplates_release", "setPt_title_clr$clevertap_pushtemplates_release", "smallIcon", "getSmallIcon$clevertap_pushtemplates_release", "setSmallIcon$clevertap_pushtemplates_release", "smallTextList", "getSmallTextList$clevertap_pushtemplates_release", "setSmallTextList$clevertap_pushtemplates_release", "templateType", "Lcom/clevertap/android/pushtemplates/TemplateType;", "getActionButtonIconKey", "getCollapseKey", "getMessage", "getTimerEnd", "()Ljava/lang/Integer;", "getTitle", "renderCancelNotification", "", "renderNotification", "Landroidx/core/app/NotificationCompat$Builder;", "nb", "setActionButtons", "setKeysFromDashboard", "setSmallIcon", "setUp", "timerRunner", "delay", "(Landroid/content/Context;Landroid/os/Bundle;ILjava/lang/Integer;)V", "Companion", "LogLevel", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: TemplateRenderer.kt */
public final class TemplateRenderer implements INotificationRenderer {
    public static int debugLevel = LogLevel.INFO.intValue();
    public JSONArray actions;
    public ArrayList<String> bigTextList;
    public CleverTapInstanceConfig config;
    public ArrayList<String> deepLinkList;
    public ArrayList<String> imageList;
    public int notificationId = -1;
    public ArrayList<String> priceList;
    public String pt_bg;
    public String pt_big_img;
    public String pt_big_img_alt;
    public String pt_cancel_notif_id;
    public ArrayList<Integer> pt_cancel_notif_ids;
    public String pt_chrono_title_clr;
    public Object pt_collapse_key;
    public String pt_dismiss_on_click;
    public int pt_dot;
    public Bitmap pt_dot_sep;
    public int pt_flip_interval;
    public String pt_id;
    public String pt_input_auto_open;
    public String pt_input_feedback;
    public String pt_input_label;
    public String pt_large_icon;
    public String pt_manual_carousel_type;
    public String pt_meta_clr;
    public String pt_msg;
    public String pt_msg_alt;
    public String pt_msg_clr;
    public String pt_msg_summary;
    public String pt_product_display_action;
    public String pt_product_display_action_clr;
    public String pt_product_display_action_text_clr;
    public String pt_product_display_linear;
    public String pt_rating_default_dl;
    public Bitmap pt_small_icon;
    public String pt_small_icon_clr;
    public String pt_small_view;
    public String pt_subtitle;
    public int pt_timer_end;
    public int pt_timer_threshold;
    public String pt_title;
    public String pt_title_alt;
    public String pt_title_clr;
    public int smallIcon;
    public ArrayList<String> smallTextList;
    public TemplateType templateType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/clevertap/android/pushtemplates/TemplateRenderer$LogLevel;", "", "value", "", "(Ljava/lang/String;II)V", "intValue", "OFF", "INFO", "DEBUG", "VERBOSE", "clevertap-pushtemplates_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TemplateRenderer.kt */
    public enum LogLevel {
        OFF(-1),
        INFO(0),
        DEBUG(2),
        VERBOSE(3);
        
        public final int value;

        /* access modifiers changed from: public */
        LogLevel(int i) {
            this.value = i;
        }

        public final int intValue() {
            return this.value;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: TemplateRenderer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TemplateType.values().length];
            TemplateType templateType = TemplateType.BASIC;
            iArr[0] = 1;
            TemplateType templateType2 = TemplateType.AUTO_CAROUSEL;
            iArr[1] = 2;
            TemplateType templateType3 = TemplateType.MANUAL_CAROUSEL;
            iArr[2] = 3;
            TemplateType templateType4 = TemplateType.RATING;
            iArr[3] = 4;
            TemplateType templateType5 = TemplateType.FIVE_ICONS;
            iArr[4] = 5;
            TemplateType templateType6 = TemplateType.PRODUCT_DISPLAY;
            iArr[5] = 6;
            TemplateType templateType7 = TemplateType.ZERO_BEZEL;
            iArr[6] = 7;
            TemplateType templateType8 = TemplateType.TIMER;
            iArr[7] = 8;
            TemplateType templateType9 = TemplateType.INPUT_BOX;
            iArr[8] = 9;
            TemplateType templateType10 = TemplateType.CANCEL;
            iArr[10] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02ee, code lost:
        if ((r13.length() == 0) != false) goto L_0x02f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0306, code lost:
        if ((r13.length() == 0) != false) goto L_0x0308;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x031e, code lost:
        if ((r13.length() == 0) != false) goto L_0x0320;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0336, code lost:
        if ((r13.length() == 0 ? true : r3) != false) goto L_0x0338;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x026a, code lost:
        if ((r13.length() == 0) != false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0284, code lost:
        if ((r13.length() == 0) != false) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x029e, code lost:
        if ((r13.length() == 0) != false) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02b8, code lost:
        if ((r13.length() == 0) != false) goto L_0x02ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02d2, code lost:
        if ((r13.length() == 0) != false) goto L_0x02d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TemplateRenderer(android.content.Context r13, android.os.Bundle r14) {
        /*
            r12 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r12.<init>()
            r0 = -1
            r12.notificationId = r0
            java.lang.String r0 = "pt_id"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_id = r0
            java.lang.String r0 = "pt_json"
            java.lang.String r0 = r14.getString(r0)
            java.lang.String r1 = r12.pt_id
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x004e
            com.clevertap.android.pushtemplates.TemplateType$Companion r5 = com.clevertap.android.pushtemplates.TemplateType.Companion
            com.clevertap.android.pushtemplates.TemplateType r1 = r5.fromString(r1)
            r12.templateType = r1
            if (r0 == 0) goto L_0x0048
            int r1 = r0.length()     // Catch:{ JSONException -> 0x0044 }
            if (r1 <= 0) goto L_0x0037
            r1 = 1
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            if (r1 == 0) goto L_0x0048
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0044 }
            r1.<init>(r0)     // Catch:{ JSONException -> 0x0044 }
            android.os.Bundle r0 = co.hyperverge.hypersnapsdk.c.k.fromJson(r1)     // Catch:{ JSONException -> 0x0044 }
            goto L_0x0049
        L_0x0044:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0048:
            r0 = r2
        L_0x0049:
            if (r0 == 0) goto L_0x004e
            r14.putAll(r0)
        L_0x004e:
            java.lang.String r0 = "pt_msg"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_msg = r0
            java.lang.String r0 = "pt_msg_summary"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_msg_summary = r0
            java.lang.String r0 = "pt_msg_clr"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_msg_clr = r0
            java.lang.String r0 = "pt_title"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_title = r0
            java.lang.String r0 = "pt_title_clr"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_title_clr = r0
            java.lang.String r0 = "pt_meta_clr"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_meta_clr = r0
            java.lang.String r0 = "pt_bg"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_bg = r0
            java.lang.String r0 = "pt_big_img"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_big_img = r0
            java.lang.String r0 = "pt_ico"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_large_icon = r0
            java.lang.String r0 = "pt_small_view"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_small_view = r0
            java.util.ArrayList r0 = co.hyperverge.hypersnapsdk.c.k.getImageListFromExtras(r14)
            r12.imageList = r0
            java.util.ArrayList r0 = co.hyperverge.hypersnapsdk.c.k.getDeepLinkListFromExtras(r14)
            r12.deepLinkList = r0
            java.util.ArrayList r0 = co.hyperverge.hypersnapsdk.c.k.getBigTextFromExtras(r14)
            r12.bigTextList = r0
            java.util.ArrayList r0 = co.hyperverge.hypersnapsdk.c.k.getSmallTextFromExtras(r14)
            r12.smallTextList = r0
            java.util.ArrayList r0 = co.hyperverge.hypersnapsdk.c.k.getPriceFromExtras(r14)
            r12.priceList = r0
            java.lang.String r0 = "pt_default_dl"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_rating_default_dl = r0
            java.util.Set r0 = r14.keySet()
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "-1"
            r5 = r1
        L_0x00cf:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r0.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "pt_timer_threshold"
            boolean r7 = r6.contains(r7)
            if (r7 == 0) goto L_0x00cf
            java.lang.String r5 = r14.getString(r6)
            goto L_0x00cf
        L_0x00e8:
            if (r5 == 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00eb:
            r5 = r1
        L_0x00ec:
            int r0 = java.lang.Integer.parseInt(r5)
            r12.pt_timer_threshold = r0
            java.lang.String r0 = "pt_input_label"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_input_label = r0
            java.lang.String r0 = "pt_input_feedback"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_input_feedback = r0
            java.lang.String r0 = "pt_input_auto_open"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_input_auto_open = r0
            java.lang.String r0 = "pt_dismiss_on_click"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_dismiss_on_click = r0
            java.lang.String r0 = "pt_chrono_title_clr"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_chrono_title_clr = r0
            java.lang.String r0 = "pt_product_display_action"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_product_display_action = r0
            java.lang.String r0 = "pt_product_display_action_clr"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_product_display_action_clr = r0
            java.util.Set r0 = r14.keySet()
            java.util.Iterator r0 = r0.iterator()
            r5 = r1
        L_0x0133:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x014c
            java.lang.Object r6 = r0.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = "pt_timer_end"
            boolean r7 = r6.contains(r7)
            if (r7 == 0) goto L_0x0133
            java.lang.String r5 = r14.getString(r6)
            goto L_0x0133
        L_0x014c:
            java.lang.String r0 = "$D_"
            boolean r0 = r5.contains(r0)
            if (r0 == 0) goto L_0x015c
            java.lang.String r0 = "\\$D_"
            java.lang.String[] r0 = r5.split(r0)
            r5 = r0[r4]
        L_0x015c:
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = java.lang.Long.parseLong(r5)
            r10 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r10
            long r8 = r8 - r6
            int r0 = (int) r8
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L_0x0171
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0171:
            r12.pt_timer_end = r0
            java.lang.String r0 = "pt_big_img_alt"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_big_img_alt = r0
            java.lang.String r0 = "pt_msg_alt"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_msg_alt = r0
            java.lang.String r0 = "pt_title_alt"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_title_alt = r0
            java.lang.String r0 = "pt_product_display_linear"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_product_display_linear = r0
            java.lang.String r0 = "pt_product_display_action_text_clr"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_product_display_action_text_clr = r0
            java.lang.String r0 = "pt_small_icon_clr"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_small_icon_clr = r0
            java.lang.String r0 = "pt_cancel_notif_id"
            java.lang.String r0 = r14.getString(r0)
            r12.pt_cancel_notif_id = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r1 < r4) goto L_0x01e4
            java.lang.String r1 = "notification"
            java.lang.Object r1 = r13.getSystemService(r1)
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
            android.service.notification.StatusBarNotification[] r1 = r1.getActiveNotifications()
            int r4 = r1.length
            r5 = 0
        L_0x01c4:
            if (r5 >= r4) goto L_0x01e4
            r6 = r1[r5]
            java.lang.String r7 = r6.getPackageName()
            java.lang.String r8 = r13.getPackageName()
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x01e1
            int r6 = r6.getId()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.add(r6)
        L_0x01e1:
            int r5 = r5 + 1
            goto L_0x01c4
        L_0x01e4:
            r12.pt_cancel_notif_ids = r0
            java.lang.String r13 = "wzrk_acts"
            java.lang.String r13 = r14.getString(r13)
            if (r13 == 0) goto L_0x020a
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x01f5 }
            r0.<init>(r13)     // Catch:{ all -> 0x01f5 }
            r2 = r0
            goto L_0x020a
        L_0x01f5:
            r13 = move-exception
            java.lang.String r0 = "error parsing notification actions: "
            java.lang.StringBuilder r0 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r0)
            java.lang.String r13 = r13.getLocalizedMessage()
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            co.hyperverge.hypersnapsdk.c.k.debug(r13)
        L_0x020a:
            r12.actions = r2
            java.lang.String r13 = "pt_subtitle"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_subtitle = r13
            java.lang.String r13 = "pt_ck"
            java.lang.Object r13 = r14.get(r13)
            r12.pt_collapse_key = r13
            java.lang.String r13 = "pt_flip_interval"
            java.lang.String r13 = r14.getString(r13)
            r0 = 4000(0xfa0, float:5.605E-42)
            if (r13 == 0) goto L_0x024b
            int r1 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x022f }
            int r0 = java.lang.Math.max(r1, r0)     // Catch:{ Exception -> 0x022f }
            goto L_0x024b
        L_0x022f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Flip Interval couldn't be converted to number: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = " - Defaulting to base value: "
            r1.append(r13)
            r1.append(r0)
            java.lang.String r13 = r1.toString()
            co.hyperverge.hypersnapsdk.c.k.debug(r13)
        L_0x024b:
            r12.pt_flip_interval = r0
            java.lang.String r13 = "wzrk_pid"
            r14.getString(r13)
            java.lang.String r13 = "pt_manual_carousel_type"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_manual_carousel_type = r13
            java.lang.String r13 = r12.pt_title
            if (r13 == 0) goto L_0x026c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x0269
            r13 = 1
            goto L_0x026a
        L_0x0269:
            r13 = 0
        L_0x026a:
            if (r13 == 0) goto L_0x0274
        L_0x026c:
            java.lang.String r13 = "nt"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_title = r13
        L_0x0274:
            java.lang.String r13 = r12.pt_msg
            if (r13 == 0) goto L_0x0286
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x0283
            r13 = 1
            goto L_0x0284
        L_0x0283:
            r13 = 0
        L_0x0284:
            if (r13 == 0) goto L_0x028e
        L_0x0286:
            java.lang.String r13 = "nm"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_msg = r13
        L_0x028e:
            java.lang.String r13 = r12.pt_msg_summary
            if (r13 == 0) goto L_0x02a0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x029d
            r13 = 1
            goto L_0x029e
        L_0x029d:
            r13 = 0
        L_0x029e:
            if (r13 == 0) goto L_0x02a8
        L_0x02a0:
            java.lang.String r13 = "wzrk_nms"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_msg_summary = r13
        L_0x02a8:
            java.lang.String r13 = r12.pt_big_img
            if (r13 == 0) goto L_0x02ba
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x02b7
            r13 = 1
            goto L_0x02b8
        L_0x02b7:
            r13 = 0
        L_0x02b8:
            if (r13 == 0) goto L_0x02c2
        L_0x02ba:
            java.lang.String r13 = "wzrk_bp"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_big_img = r13
        L_0x02c2:
            java.lang.String r13 = r12.pt_rating_default_dl
            if (r13 == 0) goto L_0x02d4
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x02d1
            r13 = 1
            goto L_0x02d2
        L_0x02d1:
            r13 = 0
        L_0x02d2:
            if (r13 == 0) goto L_0x02dc
        L_0x02d4:
            java.lang.String r13 = "wzrk_dl"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_rating_default_dl = r13
        L_0x02dc:
            java.lang.String r13 = r12.pt_meta_clr
            java.lang.String r0 = "wzrk_clr"
            if (r13 == 0) goto L_0x02f0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x02ed
            r13 = 1
            goto L_0x02ee
        L_0x02ed:
            r13 = 0
        L_0x02ee:
            if (r13 == 0) goto L_0x02f6
        L_0x02f0:
            java.lang.String r13 = r14.getString(r0)
            r12.pt_meta_clr = r13
        L_0x02f6:
            java.lang.String r13 = r12.pt_small_icon_clr
            if (r13 == 0) goto L_0x0308
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x0305
            r13 = 1
            goto L_0x0306
        L_0x0305:
            r13 = 0
        L_0x0306:
            if (r13 == 0) goto L_0x030e
        L_0x0308:
            java.lang.String r13 = r14.getString(r0)
            r12.pt_small_icon_clr = r13
        L_0x030e:
            java.lang.String r13 = r12.pt_subtitle
            if (r13 == 0) goto L_0x0320
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x031d
            r13 = 1
            goto L_0x031e
        L_0x031d:
            r13 = 0
        L_0x031e:
            if (r13 == 0) goto L_0x0328
        L_0x0320:
            java.lang.String r13 = "wzrk_st"
            java.lang.String r13 = r14.getString(r13)
            r12.pt_subtitle = r13
        L_0x0328:
            java.lang.String r13 = r12.pt_small_icon_clr
            if (r13 == 0) goto L_0x0338
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            int r13 = r13.length()
            if (r13 != 0) goto L_0x0336
            r3 = 1
        L_0x0336:
            if (r3 == 0) goto L_0x033e
        L_0x0338:
            java.lang.String r13 = r14.getString(r0)
            r12.pt_small_icon_clr = r13
        L_0x033e:
            java.lang.Object r13 = r12.pt_collapse_key
            if (r13 != 0) goto L_0x034a
            java.lang.String r13 = "wzrk_ck"
            java.lang.Object r13 = r14.get(r13)
            r12.pt_collapse_key = r13
        L_0x034a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.TemplateRenderer.<init>(android.content.Context, android.os.Bundle):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* renamed from: timerRunner$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m113timerRunner$lambda0(android.content.Context r6, int r7, com.clevertap.android.pushtemplates.TemplateRenderer r8, android.os.Bundle r9) {
        /*
            java.lang.String r0 = "$context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "$extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "notification"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            android.service.notification.StatusBarNotification[] r0 = r0.getActiveNotifications()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x001e:
            r4 = 1
            if (r3 >= r1) goto L_0x002e
            r5 = r0[r3]
            int r5 = r5.getId()
            if (r5 != r7) goto L_0x002b
            r7 = 1
            goto L_0x002f
        L_0x002b:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x002e:
            r7 = 0
        L_0x002f:
            if (r7 == 0) goto L_0x0112
            com.clevertap.android.pushtemplates.TemplateType r7 = com.clevertap.android.pushtemplates.TemplateType.BASIC
            com.clevertap.android.pushtemplates.validators.Validator r7 = com.clevertap.android.pushtemplates.validators.ValidatorFactory.getValidator(r7, r8)
            if (r7 != 0) goto L_0x003a
            goto L_0x0042
        L_0x003a:
            boolean r7 = r7.validate()
            if (r7 != r4) goto L_0x0042
            r7 = 1
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            if (r7 == 0) goto L_0x0112
            android.content.Context r6 = r6.getApplicationContext()
            java.lang.Object r7 = r9.clone()
            android.os.Bundle r7 = (android.os.Bundle) r7
            java.lang.String r9 = "wzrk_rnv"
            r7.remove(r9)
            java.lang.String r9 = "wzrk_pid"
            r0 = 0
            r7.putString(r9, r0)
            java.lang.String r9 = "pt_id"
            java.lang.String r1 = "pt_basic"
            r7.putString(r9, r1)
            java.lang.String r9 = "pt_json"
            java.lang.String r1 = r7.getString(r9)
            if (r1 == 0) goto L_0x0074
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x006f }
            r3.<init>(r1)     // Catch:{ Exception -> 0x006f }
            goto L_0x0075
        L_0x006f:
            java.lang.String r1 = "Unable to convert JSON to String"
            com.clevertap.android.sdk.Logger.v(r1)
        L_0x0074:
            r3 = r0
        L_0x0075:
            java.lang.String r1 = r8.pt_title_alt
            if (r1 == 0) goto L_0x009a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0084
            r1 = 1
            goto L_0x0085
        L_0x0084:
            r1 = 0
        L_0x0085:
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = "pt_title"
            if (r3 != 0) goto L_0x008d
            r4 = r0
            goto L_0x0093
        L_0x008d:
            java.lang.String r4 = r8.pt_title_alt
            org.json.JSONObject r4 = r3.put(r1, r4)
        L_0x0093:
            if (r4 != 0) goto L_0x009a
            java.lang.String r4 = r8.pt_title_alt
            r7.putString(r1, r4)
        L_0x009a:
            java.lang.String r1 = r8.pt_big_img_alt
            if (r1 == 0) goto L_0x00bf
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x00a9
            r1 = 1
            goto L_0x00aa
        L_0x00a9:
            r1 = 0
        L_0x00aa:
            if (r1 == 0) goto L_0x00bf
            java.lang.String r1 = "pt_big_img"
            if (r3 != 0) goto L_0x00b2
            r4 = r0
            goto L_0x00b8
        L_0x00b2:
            java.lang.String r4 = r8.pt_big_img_alt
            org.json.JSONObject r4 = r3.put(r1, r4)
        L_0x00b8:
            if (r4 != 0) goto L_0x00bf
            java.lang.String r4 = r8.pt_big_img_alt
            r7.putString(r1, r4)
        L_0x00bf:
            java.lang.String r1 = r8.pt_msg_alt
            if (r1 == 0) goto L_0x00e2
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x00cd
            r2 = 1
        L_0x00cd:
            if (r2 == 0) goto L_0x00e2
            java.lang.String r1 = "pt_msg"
            if (r3 != 0) goto L_0x00d5
            r2 = r0
            goto L_0x00db
        L_0x00d5:
            java.lang.String r2 = r8.pt_msg_alt
            org.json.JSONObject r2 = r3.put(r1, r2)
        L_0x00db:
            if (r2 != 0) goto L_0x00e2
            java.lang.String r8 = r8.pt_msg_alt
            r7.putString(r1, r8)
        L_0x00e2:
            if (r3 == 0) goto L_0x00eb
            java.lang.String r8 = r3.toString()
            r7.putString(r9, r8)
        L_0x00eb:
            java.lang.String r8 = "pt_ck"
            r7.putString(r8, r0)
            java.lang.String r8 = "wzrk_ck"
            r7.putString(r8, r0)
            java.lang.String r8 = "notificationId"
            r7.remove(r8)
            com.clevertap.android.pushtemplates.TemplateRenderer r8 = new com.clevertap.android.pushtemplates.TemplateRenderer
            java.lang.String r9 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
            r8.<init>(r6, r7)
            java.lang.String r9 = co.hyperverge.hypersnapsdk.c.k.getAccountIdFromNotificationBundle(r7)
            com.clevertap.android.sdk.CleverTapAPI r9 = com.clevertap.android.sdk.CleverTapAPI.fromAccountId(r6, r9)
            if (r9 != 0) goto L_0x010f
            goto L_0x0112
        L_0x010f:
            r9.renderPushNotification(r8, r6, r7)
        L_0x0112:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.TemplateRenderer.m113timerRunner$lambda0(android.content.Context, int, com.clevertap.android.pushtemplates.TemplateRenderer, android.os.Bundle):void");
    }

    public String getActionButtonIconKey() {
        return "pt_ico";
    }

    public Object getCollapseKey(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return this.pt_collapse_key;
    }

    public String getMessage(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "extras");
        return this.pt_msg;
    }

    public String getTitle(Bundle bundle, Context context) {
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Intrinsics.checkNotNullParameter(context, "context");
        return this.pt_title;
    }

    public Builder renderNotification(Bundle bundle, Context context, Builder builder, CleverTapInstanceConfig cleverTapInstanceConfig, int i) {
        Integer num;
        Intrinsics.checkNotNullParameter(bundle, "extras");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, PaymentConstants.WIDGET_NETBANKING);
        Intrinsics.checkNotNullParameter(cleverTapInstanceConfig, "config");
        Builder builder2 = null;
        if (this.pt_id == null) {
            k.verbose("Template ID not provided. Cannot create the notification");
            return null;
        }
        this.notificationId = i;
        TemplateType templateType2 = this.templateType;
        int i2 = 0;
        boolean z = true;
        switch (templateType2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[templateType2.ordinal()]) {
            case 1:
                Validator validator = ValidatorFactory.getValidator(TemplateType.BASIC, this);
                if (validator != null && validator.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return new BasicStyle(this).builderFromStyle(context, bundle, i, builder);
                }
                break;
            case 2:
                Validator validator2 = ValidatorFactory.getValidator(TemplateType.AUTO_CAROUSEL, this);
                if (validator2 != null && validator2.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return new AutoCarouselStyle(this).builderFromStyle(context, bundle, i, builder);
                }
                break;
            case 3:
                Validator validator3 = ValidatorFactory.getValidator(TemplateType.MANUAL_CAROUSEL, this);
                if (validator3 != null && validator3.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return new ManualCarouselStyle(this, bundle).builderFromStyle(context, bundle, i, builder);
                }
                break;
            case 4:
                Validator validator4 = ValidatorFactory.getValidator(TemplateType.RATING, this);
                if (validator4 != null && validator4.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return new RatingStyle(this, bundle).builderFromStyle(context, bundle, i, builder);
                }
                break;
            case 5:
                Validator validator5 = ValidatorFactory.getValidator(TemplateType.FIVE_ICONS, this);
                if (validator5 != null && validator5.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    FiveIconStyle fiveIconStyle = new FiveIconStyle(this, bundle);
                    Builder ongoing = fiveIconStyle.builderFromStyle(context, bundle, i, builder).setOngoing(true);
                    Intrinsics.checkNotNullExpressionValue(ongoing, "fiveIconStyle.builderFro…       ).setOngoing(true)");
                    ContentView contentView = fiveIconStyle.fiveIconSmallContentView;
                    if (contentView != null) {
                        if (((FiveIconSmallContentView) contentView).imageCounter <= 2) {
                            ContentView contentView2 = fiveIconStyle.fiveIconBigContentView;
                            if (contentView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("fiveIconBigContentView");
                                throw null;
                            } else if (((FiveIconBigContentView) contentView2).imageCounter <= 2) {
                                builder2 = ongoing;
                            }
                        }
                        return builder2;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("fiveIconSmallContentView");
                    throw null;
                }
                break;
            case 6:
                Validator validator6 = ValidatorFactory.getValidator(TemplateType.PRODUCT_DISPLAY, this);
                if (validator6 != null && validator6.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return new ProductDisplayStyle(this, bundle).builderFromStyle(context, bundle, i, builder);
                }
                break;
            case 7:
                Validator validator7 = ValidatorFactory.getValidator(TemplateType.ZERO_BEZEL, this);
                if (validator7 != null && validator7.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return new ZeroBezelStyle(this).builderFromStyle(context, bundle, i, builder);
                }
                break;
            case 8:
                if (VERSION.SDK_INT >= 24) {
                    Validator validator8 = ValidatorFactory.getValidator(TemplateType.TIMER, this);
                    if (validator8 != null && validator8.validate()) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        int i3 = this.pt_timer_threshold;
                        if (i3 == -1 || i3 < 10) {
                            int i4 = this.pt_timer_end;
                            if (i4 >= 10) {
                                num = Integer.valueOf((i4 * 1000) + 1000);
                            } else {
                                k.debug("Not rendering notification Timer End value lesser than threshold (10 seconds) from current time: pt_timer_end");
                                num = null;
                            }
                        } else {
                            num = Integer.valueOf((i3 * 1000) + 1000);
                        }
                        if (num != null) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(context, i, this, bundle) {
                                public final /* synthetic */ Context f$0;
                                public final /* synthetic */ int f$1;
                                public final /* synthetic */ TemplateRenderer f$2;
                                public final /* synthetic */ Bundle f$3;

                                {
                                    this.f$0 = r1;
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                    this.f$3 = r4;
                                }

                                public final void run() {
                                    TemplateRenderer.m113timerRunner$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
                                }
                            }, (long) (num.intValue() - 100));
                            return new TimerStyle(this, bundle).builderFromStyle(context, bundle, i, builder).setTimeoutAfter((long) num.intValue());
                        }
                    }
                } else {
                    k.debug("Push Templates SDK supports Timer Notifications only on or above Android Nougat, reverting to basic template");
                    Validator validator9 = ValidatorFactory.getValidator(TemplateType.BASIC, this);
                    if (validator9 != null && validator9.validate()) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        return new BasicStyle(this).builderFromStyle(context, bundle, i, builder);
                    }
                }
                break;
            case 9:
                Validator validator10 = ValidatorFactory.getValidator(TemplateType.INPUT_BOX, this);
                if (validator10 != null && validator10.validate()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    return new InputBoxStyle(this).builderFromStyle(context, bundle, i, builder);
                }
                break;
            case 10:
                Object systemService = context.getSystemService("notification");
                if (systemService != null) {
                    NotificationManager notificationManager = (NotificationManager) systemService;
                    String str = this.pt_cancel_notif_id;
                    if (str != null) {
                        Intrinsics.checkNotNull(str);
                        if (str.length() <= 0) {
                            z = false;
                        }
                        if (z) {
                            String str2 = this.pt_cancel_notif_id;
                            Intrinsics.checkNotNull(str2);
                            notificationManager.cancel(Integer.parseInt(str2));
                            break;
                        }
                    }
                    ArrayList<Integer> arrayList = this.pt_cancel_notif_ids;
                    Intrinsics.checkNotNull(arrayList);
                    if (arrayList.size() > 0) {
                        ArrayList<Integer> arrayList2 = this.pt_cancel_notif_ids;
                        Intrinsics.checkNotNull(arrayList2);
                        int size = arrayList2.size();
                        if (size >= 0) {
                            while (true) {
                                int i5 = i2 + 1;
                                ArrayList<Integer> arrayList3 = this.pt_cancel_notif_ids;
                                Intrinsics.checkNotNull(arrayList3);
                                Integer num2 = arrayList3.get(i2);
                                Intrinsics.checkNotNullExpressionValue(num2, "pt_cancel_notif_ids!![i]");
                                notificationManager.cancel(num2.intValue());
                                if (i2 == size) {
                                    break;
                                } else {
                                    i2 = i5;
                                }
                            }
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
                }
                break;
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r7 = java.lang.Class.forName("com.clevertap.android.sdk.pushnotification.CTNotificationIntentService");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
        com.clevertap.android.sdk.Logger.d("No Intent Service found");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002f */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x015f A[Catch:{ all -> 0x0107, all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x018c A[Catch:{ all -> 0x0107, all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b0 A[Catch:{ all -> 0x01d4, all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01c0 A[Catch:{ all -> 0x01d4, all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01c4 A[Catch:{ all -> 0x01d4, all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01cc A[Catch:{ all -> 0x01d4, all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0208 A[LOOP:0: B:21:0x0053->B:131:0x0208, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x020f A[EDGE_INSN: B:134:0x020f->B:132:0x020f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d1 A[ADDED_TO_REGION, Catch:{ all -> 0x01d4, all -> 0x01ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e2 A[SYNTHETIC, Splitter:B:64:0x00e2] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0119 A[Catch:{ all -> 0x0107, all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0136 A[Catch:{ all -> 0x0107, all -> 0x012e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.core.app.NotificationCompat.Builder setActionButtons(android.content.Context r22, android.os.Bundle r23, int r24, androidx.core.app.NotificationCompat.Builder r25, org.json.JSONArray r26) {
        /*
            r21 = this;
            r1 = r22
            r2 = r23
            r3 = r25
            r4 = r26
            java.lang.String r5 = "id"
            java.lang.String r6 = "dl"
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "extras"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "nb"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.clevertap.android.sdk.ManifestInfo r0 = com.clevertap.android.sdk.ManifestInfo.getInstance(r22)
            r7 = 0
            if (r0 == 0) goto L_0x0210
            java.lang.String r0 = com.clevertap.android.sdk.ManifestInfo.intentServiceName
            java.lang.String r8 = "No Intent Service found"
            java.lang.String r9 = "com.clevertap.android.sdk.pushnotification.CTNotificationIntentService"
            if (r0 == 0) goto L_0x0038
            java.lang.Class r7 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x002f }
            goto L_0x0040
        L_0x002f:
            java.lang.Class r7 = java.lang.Class.forName(r9)     // Catch:{ ClassNotFoundException -> 0x0034 }
            goto L_0x0040
        L_0x0034:
            com.clevertap.android.sdk.Logger.d(r8)
            goto L_0x0040
        L_0x0038:
            java.lang.Class r7 = java.lang.Class.forName(r9)     // Catch:{ ClassNotFoundException -> 0x003d }
            goto L_0x0040
        L_0x003d:
            com.clevertap.android.sdk.Logger.d(r8)
        L_0x0040:
            boolean r7 = com.clevertap.android.sdk.Utils.isServiceAvailable(r1, r7)
            if (r4 == 0) goto L_0x020f
            int r0 = r26.length()
            if (r0 <= 0) goto L_0x020f
            int r8 = r26.length()
            if (r8 <= 0) goto L_0x020f
            r10 = 0
        L_0x0053:
            int r11 = r10 + 1
            org.json.JSONObject r0 = r4.getJSONObject(r10)     // Catch:{ all -> 0x01ee }
            java.lang.String r12 = "l"
            java.lang.String r12 = r0.optString(r12)     // Catch:{ all -> 0x01ee }
            java.lang.String r13 = r0.optString(r6)     // Catch:{ all -> 0x01ee }
            java.lang.String r14 = "pt_ico"
            java.lang.String r14 = r0.optString(r14)     // Catch:{ all -> 0x01ee }
            java.lang.String r15 = r0.optString(r5)     // Catch:{ all -> 0x01ee }
            java.lang.String r9 = "ac"
            r4 = 1
            boolean r9 = r0.optBoolean(r9, r4)     // Catch:{ all -> 0x01ee }
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)     // Catch:{ all -> 0x01ee }
            int r0 = r12.length()     // Catch:{ all -> 0x01ee }
            if (r0 != 0) goto L_0x0081
            r0 = 1
            goto L_0x0082
        L_0x0081:
            r0 = 0
        L_0x0082:
            if (r0 != 0) goto L_0x01dd
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r5)     // Catch:{ all -> 0x01ee }
            int r0 = r15.length()     // Catch:{ all -> 0x01ee }
            if (r0 != 0) goto L_0x008f
            r0 = 1
            goto L_0x0090
        L_0x008f:
            r0 = 0
        L_0x0090:
            if (r0 == 0) goto L_0x0094
            goto L_0x01dd
        L_0x0094:
            java.lang.String r0 = "ico"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r0)     // Catch:{ all -> 0x01ee }
            int r0 = r14.length()     // Catch:{ all -> 0x01ee }
            if (r0 != 0) goto L_0x00a1
            r0 = 1
            goto L_0x00a2
        L_0x00a1:
            r0 = 0
        L_0x00a2:
            if (r0 != 0) goto L_0x00c8
            android.content.res.Resources r0 = r22.getResources()     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = "drawable"
            r17 = r5
            java.lang.String r5 = r22.getPackageName()     // Catch:{ all -> 0x00b5 }
            int r0 = r0.getIdentifier(r14, r4, r5)     // Catch:{ all -> 0x00b5 }
            goto L_0x00cb
        L_0x00b5:
            r0 = move-exception
            goto L_0x00ba
        L_0x00b7:
            r0 = move-exception
            r17 = r5
        L_0x00ba:
            java.lang.String r4 = "unable to add notification action icon: "
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r0)     // Catch:{ all -> 0x01d4 }
            com.clevertap.android.sdk.Logger.d(r0)     // Catch:{ all -> 0x01d4 }
            goto L_0x00ca
        L_0x00c8:
            r17 = r5
        L_0x00ca:
            r0 = 0
        L_0x00cb:
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01d4 }
            r5 = 31
            if (r4 >= r5) goto L_0x00d7
            if (r9 == 0) goto L_0x00d7
            if (r7 == 0) goto L_0x00d7
            r4 = 1
            goto L_0x00d8
        L_0x00d7:
            r4 = 0
        L_0x00d8:
            java.lang.String r5 = "pt_dismiss_on_click"
            java.lang.String r5 = r2.getString(r5)     // Catch:{ all -> 0x01d4 }
            java.lang.String r14 = "true"
            if (r4 != 0) goto L_0x010e
            boolean r18 = com.clevertap.android.sdk.pushnotification.PushNotificationHandler.isForPushTemplates(r23)     // Catch:{ all -> 0x0107 }
            if (r18 == 0) goto L_0x010e
            r18 = r4
            java.lang.String r4 = "remind"
            r19 = r8
            r8 = 2
            r20 = r11
            r11 = 0
            boolean r4 = kotlin.text.CharsKt__CharKt.contains$default(r15, r4, r11, r8)     // Catch:{ all -> 0x012e }
            if (r4 == 0) goto L_0x0115
            if (r5 == 0) goto L_0x0115
            r4 = 1
            boolean r8 = kotlin.text.CharsKt__CharKt.equals(r5, r14, r4)     // Catch:{ all -> 0x012e }
            if (r8 == 0) goto L_0x0115
            if (r9 == 0) goto L_0x0115
            if (r7 == 0) goto L_0x0115
            r4 = 1
            goto L_0x0117
        L_0x0107:
            r0 = move-exception
            r19 = r8
            r20 = r11
            r11 = 0
            goto L_0x012f
        L_0x010e:
            r18 = r4
            r19 = r8
            r20 = r11
            r11 = 0
        L_0x0115:
            r4 = r18
        L_0x0117:
            if (r4 != 0) goto L_0x0133
            boolean r8 = com.clevertap.android.sdk.pushnotification.PushNotificationHandler.isForPushTemplates(r23)     // Catch:{ all -> 0x012e }
            if (r8 == 0) goto L_0x0133
            if (r5 == 0) goto L_0x0133
            r8 = 1
            boolean r5 = kotlin.text.CharsKt__CharKt.equals(r5, r14, r8)     // Catch:{ all -> 0x012e }
            if (r5 == 0) goto L_0x0134
            if (r9 == 0) goto L_0x0134
            if (r7 == 0) goto L_0x0134
            r4 = 1
            goto L_0x0134
        L_0x012e:
            r0 = move-exception
        L_0x012f:
            r9 = r24
            goto L_0x01f4
        L_0x0133:
            r8 = 1
        L_0x0134:
            if (r4 == 0) goto L_0x015f
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x012e }
            java.lang.String r14 = "com.clevertap.PUSH_EVENT"
            r5.<init>(r14)     // Catch:{ all -> 0x012e }
            java.lang.String r14 = r22.getPackageName()     // Catch:{ all -> 0x012e }
            r5.setPackage(r14)     // Catch:{ all -> 0x012e }
            java.lang.String r14 = "ct_type"
            java.lang.String r8 = "com.clevertap.ACTION_BUTTON_CLICK"
            r5.putExtra(r14, r8)     // Catch:{ all -> 0x012e }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r6)     // Catch:{ all -> 0x012e }
            int r8 = r13.length()     // Catch:{ all -> 0x012e }
            if (r8 <= 0) goto L_0x0157
            r16 = 1
            goto L_0x0159
        L_0x0157:
            r16 = 0
        L_0x0159:
            if (r16 == 0) goto L_0x018a
            r5.putExtra(r6, r13)     // Catch:{ all -> 0x012e }
            goto L_0x018a
        L_0x015f:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r6)     // Catch:{ all -> 0x012e }
            int r5 = r13.length()     // Catch:{ all -> 0x012e }
            if (r5 <= 0) goto L_0x016b
            r16 = 1
            goto L_0x016d
        L_0x016b:
            r16 = 0
        L_0x016d:
            if (r16 == 0) goto L_0x017e
            android.content.Intent r5 = new android.content.Intent     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "android.intent.action.VIEW"
            android.net.Uri r13 = android.net.Uri.parse(r13)     // Catch:{ all -> 0x012e }
            r5.<init>(r8, r13)     // Catch:{ all -> 0x012e }
            co.hyperverge.hypersnapsdk.c.k.setPackageNameFromResolveInfoList(r1, r5)     // Catch:{ all -> 0x012e }
            goto L_0x018a
        L_0x017e:
            android.content.pm.PackageManager r5 = r22.getPackageManager()     // Catch:{ all -> 0x012e }
            java.lang.String r8 = r22.getPackageName()     // Catch:{ all -> 0x012e }
            android.content.Intent r5 = r5.getLaunchIntentForPackage(r8)     // Catch:{ all -> 0x012e }
        L_0x018a:
            if (r5 == 0) goto L_0x01b0
            r5.putExtras(r2)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "wzrk_acts"
            r5.removeExtra(r8)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "actionId"
            r5.putExtra(r8, r15)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "autoCancel"
            r5.putExtra(r8, r9)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "wzrk_c2a"
            r5.putExtra(r8, r15)     // Catch:{ all -> 0x012e }
            java.lang.String r8 = "notificationId"
            r9 = r24
            r5.putExtra(r8, r9)     // Catch:{ all -> 0x01ec }
            r8 = 603979776(0x24000000, float:2.7755576E-17)
            r5.setFlags(r8)     // Catch:{ all -> 0x01ec }
            goto L_0x01b2
        L_0x01b0:
            r9 = r24
        L_0x01b2:
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01ec }
            int r8 = (int) r13     // Catch:{ all -> 0x01ec }
            int r8 = r8 + r10
            r10 = 134217728(0x8000000, float:3.85186E-34)
            int r13 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01ec }
            r14 = 23
            if (r13 < r14) goto L_0x01c2
            r10 = 201326592(0xc000000, float:9.8607613E-32)
        L_0x01c2:
            if (r4 == 0) goto L_0x01cc
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x01ec }
            android.app.PendingIntent r4 = android.app.PendingIntent.getService(r1, r8, r5, r10)     // Catch:{ all -> 0x01ec }
            goto L_0x01d0
        L_0x01cc:
            android.app.PendingIntent r4 = android.app.PendingIntent.getActivity(r1, r8, r5, r10)     // Catch:{ all -> 0x01ec }
        L_0x01d0:
            r3.addAction(r0, r12, r4)     // Catch:{ all -> 0x01ec }
            goto L_0x0201
        L_0x01d4:
            r0 = move-exception
            r9 = r24
        L_0x01d7:
            r19 = r8
            r20 = r11
            r11 = 0
            goto L_0x01f4
        L_0x01dd:
            r9 = r24
            r17 = r5
            r19 = r8
            r20 = r11
            r11 = 0
            java.lang.String r0 = "not adding push notification action: action label or id missing"
            com.clevertap.android.sdk.Logger.d(r0)     // Catch:{ all -> 0x01ec }
            goto L_0x0201
        L_0x01ec:
            r0 = move-exception
            goto L_0x01f4
        L_0x01ee:
            r0 = move-exception
            r9 = r24
            r17 = r5
            goto L_0x01d7
        L_0x01f4:
            java.lang.String r0 = r0.getLocalizedMessage()
            java.lang.String r4 = "error adding notification action : "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r0)
            com.clevertap.android.sdk.Logger.d(r0)
        L_0x0201:
            r4 = r19
            r10 = r20
            if (r10 < r4) goto L_0x0208
            goto L_0x020f
        L_0x0208:
            r8 = r4
            r5 = r17
            r4 = r26
            goto L_0x0053
        L_0x020f:
            return r3
        L_0x0210:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.pushtemplates.TemplateRenderer.setActionButtons(android.content.Context, android.os.Bundle, int, androidx.core.app.NotificationCompat$Builder, org.json.JSONArray):androidx.core.app.NotificationCompat$Builder");
    }

    public void setSmallIcon(int i, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.smallIcon = i;
        try {
            this.pt_small_icon = k.setBitMapColour(context, i, this.pt_small_icon_clr);
        } catch (NullPointerException unused) {
            k.debug("NPE while setting small icon color");
        }
    }
}
