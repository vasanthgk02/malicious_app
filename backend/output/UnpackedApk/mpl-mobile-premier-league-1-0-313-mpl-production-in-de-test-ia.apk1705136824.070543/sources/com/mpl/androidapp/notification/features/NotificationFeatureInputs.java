package com.mpl.androidapp.notification.features;

import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.mpl.androidapp.R;
import com.mpl.androidapp.notification.models.FeatureUgcInput;
import com.mpl.androidapp.utils.MSharedPreferencesUtils;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/mpl/androidapp/notification/features/NotificationFeatureInputs;", "", "()V", "ugcNotificationFeatureInput", "Lcom/mpl/androidapp/notification/models/FeatureUgcInput;", "gameId", "", "tournamentId", "title", "", "message", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotificationFeatureInputs.kt */
public final class NotificationFeatureInputs {
    public static final NotificationFeatureInputs INSTANCE = new NotificationFeatureInputs();

    public final FeatureUgcInput ugcNotificationFeatureInput(int i, int i2, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        FeatureUgcInput featureUgcInput = new FeatureUgcInput(str, str2, i, i2, NotificationFeatureNames.NOTIFICATION_UGC_FEATURE_TAG, true, DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD, false, MSharedPreferencesUtils.isUserPlayingGame(), R.mipmap.ic_launcher, R.drawable.ic_stat_mpl, R.color.notif_action_button, 0, (int) Calendar.getInstance().getTimeInMillis(), true, true, 0, true, true, 69760, null);
        return featureUgcInput;
    }
}
