package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.Validate;
import com.facebook.login.widget.ProfilePictureView;
import com.facebook.login.widget.ProfilePictureView$initialize$1;
import com.razorpay.AnalyticsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH$J\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/ProfileTracker;", "", "()V", "broadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "<set-?>", "", "isTracking", "()Z", "receiver", "Landroid/content/BroadcastReceiver;", "addBroadcastReceiver", "", "onCurrentProfileChanged", "oldProfile", "Lcom/facebook/Profile;", "currentProfile", "startTracking", "stopTracking", "ProfileBroadcastReceiver", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProfileTracker.kt */
public abstract class ProfileTracker {
    public final LocalBroadcastManager broadcastManager;
    public boolean isTracking;
    public final BroadcastReceiver receiver = new ProfileBroadcastReceiver(this);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/ProfileTracker$ProfileBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/facebook/ProfileTracker;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ProfileTracker.kt */
    public final class ProfileBroadcastReceiver extends BroadcastReceiver {
        public final /* synthetic */ ProfileTracker this$0;

        public ProfileBroadcastReceiver(ProfileTracker profileTracker) {
            Intrinsics.checkNotNullParameter(profileTracker, "this$0");
            this.this$0 = profileTracker;
        }

        public void onReceive(Context context, Intent intent) {
            String str;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, AnalyticsConstants.INTENT);
            if (Intrinsics.areEqual("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED", intent.getAction())) {
                Profile profile = (Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE");
                Profile profile2 = (Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE");
                ProfilePictureView$initialize$1 profilePictureView$initialize$1 = (ProfilePictureView$initialize$1) this.this$0;
                ProfilePictureView profilePictureView = profilePictureView$initialize$1.this$0;
                if (profile2 == null) {
                    str = null;
                } else {
                    str = profile2.id;
                }
                profilePictureView.setProfileId(str);
                profilePictureView$initialize$1.this$0.refreshImage(true);
            }
        }
    }

    public ProfileTracker() {
        Validate.sdkInitialized();
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(FacebookSdk.getApplicationContext())");
        this.broadcastManager = instance;
        startTracking();
    }

    public final void startTracking() {
        if (!this.isTracking) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
            this.broadcastManager.registerReceiver(this.receiver, intentFilter);
            this.isTracking = true;
        }
    }
}
