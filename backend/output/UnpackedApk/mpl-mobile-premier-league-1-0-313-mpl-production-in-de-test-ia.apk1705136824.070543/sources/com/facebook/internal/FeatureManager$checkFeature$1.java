package com.facebook.internal;

import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FetchedAppGateKeepersManager.Callback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/internal/FeatureManager$checkFeature$1", "Lcom/facebook/internal/FetchedAppGateKeepersManager$Callback;", "onCompleted", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FeatureManager.kt */
public final class FeatureManager$checkFeature$1 implements Callback {
    public final /* synthetic */ FeatureManager.Callback $callback;
    public final /* synthetic */ Feature $feature;

    public FeatureManager$checkFeature$1(FeatureManager.Callback callback, Feature feature) {
        this.$callback = callback;
        this.$feature = feature;
    }

    public void onCompleted() {
        FeatureManager.Callback callback = this.$callback;
        FeatureManager featureManager = FeatureManager.INSTANCE;
        callback.onCompleted(FeatureManager.isEnabled(this.$feature));
    }
}
