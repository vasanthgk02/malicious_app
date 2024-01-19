package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.google.android.material.R$attr;
import sfs2x.client.entities.invitation.InvitationReply;

public class ElevationOverlayProvider {
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        this.elevationOverlayEnabled = ImageOriginUtils.resolveBoolean(context, R$attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = ImageOriginUtils.getColor(context, R$attr.elevationOverlayColor, 0);
        this.colorSurface = ImageOriginUtils.getColor(context, R$attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    public int compositeOverlayIfNeeded(int i, float f2) {
        if (!this.elevationOverlayEnabled) {
            return i;
        }
        if (!(ColorUtils.setAlphaComponent(i, InvitationReply.EXPIRED) == this.colorSurface)) {
            return i;
        }
        float f3 = this.displayDensity;
        float f4 = 0.0f;
        if (f3 > 0.0f && f2 > 0.0f) {
            f4 = Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return ColorUtils.setAlphaComponent(ImageOriginUtils.layer(ColorUtils.setAlphaComponent(i, InvitationReply.EXPIRED), this.elevationOverlayColor, f4), Color.alpha(i));
    }
}
