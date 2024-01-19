package com.google.android.gms.measurement.internal;

import com.facebook.react.modules.dialog.DialogModule;
import com.google.firebase.crashlytics.CrashlyticsAnalyticsListener;
import com.mpl.payment.routing.RoutingConstants;
import com.rudderstack.android.sdk.core.ecomm.ECommerceParamNames;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import in.juspay.hypersdk.core.PaymentConstants;
import io.hansel.core.criteria.HSLCriteriaBuilder;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzhg {
    public static final String[] zza = {"ga_conversion", "engagement_time_msec", "exposure_time", "ad_event_id", "ad_unit_id", "ga_error", "ga_error_value", "ga_error_length", "ga_event_origin", "ga_screen", "ga_screen_class", "ga_screen_id", "ga_previous_screen", "ga_previous_class", "ga_previous_id", "manual_tracking", "message_device_time", "message_id", "message_name", "message_time", "message_tracking_id", PushMessageHelper.MESSAGE_TYPE, "previous_app_version", "previous_os_version", MiPushMessage.KEY_TOPIC, "update_with_analytics", "previous_first_open_count", "system_app", "system_app_update", "previous_install_count", "ga_event_id", "ga_extra_params_ct", "ga_group_name", "ga_list_length", "ga_index", "ga_event_name", "campaign_info_source", "cached_campaign", "deferred_analytics_collection", "ga_session_number", "ga_session_id", "campaign_extra_referrer", "app_in_background", "firebase_feature_rollouts", "firebase_conversion", "firebase_error", "firebase_error_value", "firebase_error_length", "firebase_event_origin", "firebase_screen", "firebase_screen_class", "firebase_screen_id", "firebase_previous_screen", "firebase_previous_class", "firebase_previous_id", "session_number", "session_id"};
    public static final String[] zzb = {"_c", "_et", "_xt", "_aeid", "_ai", "_err", "_ev", "_el", CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_mst", "_ndt", "_nmid", "_nmn", "_nmt", "_nmtid", "_nmc", "_pv", "_po", "_nt", "_uwa", "_pfo", "_sys", "_sysu", "_pin", "_eid", "_epc", "_gn", "_ll", "_i", "_en", "_cis", "_cc", "_dac", "_sno", "_sid", "_cer", "_aib", "_ffr", "_c", "_err", "_ev", "_el", CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, "_sn", "_sc", "_si", "_pn", "_pc", "_pi", "_sno", "_sid"};
    public static final String[] zzc = {DialogModule.KEY_ITEMS};
    public static final String[] zzd = {"affiliation", RoutingConstants.MI_REACT_COUPON, "creative_name", "creative_slot", "currency", ECommerceParamNames.DISCOUNT, "index", "item_id", "item_brand", "item_category", "item_category2", "item_category3", "item_category4", "item_category5", "item_list_name", "item_list_id", "item_name", "item_variant", "location_id", "payment_type", ECommerceParamNames.PRICE, "promotion_id", "promotion_name", ECommerceParamNames.QUANTITY, "shipping", "shipping_tier", "tax", PaymentConstants.TRANSACTION_ID, HSLCriteriaBuilder.VALUE, "item_list", "checkout_step", "checkout_option", "item_location_id"};
}
