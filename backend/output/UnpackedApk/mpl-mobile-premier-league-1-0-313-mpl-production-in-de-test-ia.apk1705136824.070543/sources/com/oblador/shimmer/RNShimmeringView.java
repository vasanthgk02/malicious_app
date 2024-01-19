package com.oblador.shimmer;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.shimmer.Shimmer.AlphaHighlightBuilder;
import com.facebook.shimmer.Shimmer.Builder;
import com.facebook.shimmer.ShimmerFrameLayout;

public class RNShimmeringView extends ShimmerFrameLayout {
    public Builder builder = new AlphaHighlightBuilder();

    public RNShimmeringView(Context context) {
        super(context);
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public void updateShimmer() {
        setShimmer(this.builder.build());
    }

    public RNShimmeringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RNShimmeringView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
