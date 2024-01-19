package com.google.android.gms.internal.base;

import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import sfs2x.client.entities.invitation.InvitationReply;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zak extends Drawable implements Callback {
    public int zaa;
    public long zab;
    public int zac;
    public int zad;
    public int zae;
    public int zaf;
    public boolean zag;
    public boolean zah;
    public zaj zai;
    public Drawable zaj;
    public Drawable zak;
    public boolean zal;
    public boolean zam;
    public boolean zan;
    public int zao;

    public zak(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? zai.zaa : drawable;
        this.zaj = drawable;
        drawable.setCallback(this);
        zaj zaj2 = this.zai;
        zaj2.zab = drawable.getChangingConfigurations() | zaj2.zab;
        drawable2 = drawable2 == null ? zai.zaa : drawable2;
        this.zak = drawable2;
        drawable2.setCallback(this);
        zaj zaj3 = this.zai;
        zaj3.zab = drawable2.getChangingConfigurations() | zaj3.zab;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r0 == 0) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r8) {
        /*
            r7 = this;
            int r0 = r7.zaa
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L_0x0039
            if (r0 == r1) goto L_0x000a
            goto L_0x0042
        L_0x000a:
            long r0 = r7.zab
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0042
            long r0 = android.os.SystemClock.uptimeMillis()
            long r4 = r7.zab
            long r0 = r0 - r4
            float r0 = (float) r0
            int r1 = r7.zae
            float r1 = (float) r1
            float r0 = r0 / r1
            r1 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 < 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            if (r3 == 0) goto L_0x002a
            r7.zaa = r2
        L_0x002a:
            float r0 = java.lang.Math.min(r0, r1)
            int r1 = r7.zac
            float r1 = (float) r1
            float r1 = r1 * r0
            r0 = 0
            float r1 = r1 + r0
            int r0 = (int) r1
            r7.zaf = r0
            goto L_0x0042
        L_0x0039:
            long r3 = android.os.SystemClock.uptimeMillis()
            r7.zab = r3
            r7.zaa = r1
            r3 = 0
        L_0x0042:
            int r0 = r7.zaf
            boolean r1 = r7.zag
            android.graphics.drawable.Drawable r4 = r7.zaj
            android.graphics.drawable.Drawable r5 = r7.zak
            if (r3 == 0) goto L_0x0061
            if (r1 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0056
            goto L_0x0052
        L_0x0051:
            r2 = r0
        L_0x0052:
            r4.draw(r8)
            r0 = r2
        L_0x0056:
            int r1 = r7.zad
            if (r0 != r1) goto L_0x0060
            r5.setAlpha(r1)
            r5.draw(r8)
        L_0x0060:
            return
        L_0x0061:
            if (r1 == 0) goto L_0x0069
            int r2 = r7.zad
            int r2 = r2 - r0
            r4.setAlpha(r2)
        L_0x0069:
            r4.draw(r8)
            if (r1 == 0) goto L_0x0073
            int r1 = r7.zad
            r4.setAlpha(r1)
        L_0x0073:
            if (r0 <= 0) goto L_0x0080
            r5.setAlpha(r0)
            r5.draw(r8)
            int r8 = r7.zad
            r5.setAlpha(r8)
        L_0x0080:
            r7.invalidateSelf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.base.zak.draw(android.graphics.Canvas):void");
    }

    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        zaj zaj2 = this.zai;
        return changingConfigurations | zaj2.zaa | zaj2.zab;
    }

    public final ConstantState getConstantState() {
        if (!zac()) {
            return null;
        }
        this.zai.zaa = getChangingConfigurations();
        return this.zai;
    }

    public final int getIntrinsicHeight() {
        return Math.max(this.zaj.getIntrinsicHeight(), this.zak.getIntrinsicHeight());
    }

    public final int getIntrinsicWidth() {
        return Math.max(this.zaj.getIntrinsicWidth(), this.zak.getIntrinsicWidth());
    }

    public final int getOpacity() {
        if (!this.zan) {
            this.zao = Drawable.resolveOpacity(this.zaj.getOpacity(), this.zak.getOpacity());
            this.zan = true;
        }
        return this.zao;
    }

    public final void invalidateDrawable(Drawable drawable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public final Drawable mutate() {
        if (!this.zah && super.mutate() == this) {
            if (zac()) {
                this.zaj.mutate();
                this.zak.mutate();
                this.zah = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        this.zaj.setBounds(rect);
        this.zak.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public final void setAlpha(int i) {
        if (this.zaf == this.zad) {
            this.zaf = i;
        }
        this.zad = i;
        invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zaj.setColorFilter(colorFilter);
        this.zak.setColorFilter(colorFilter);
    }

    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final Drawable zaa() {
        return this.zak;
    }

    public final void zab(int i) {
        this.zac = this.zad;
        this.zaf = 0;
        this.zae = 250;
        this.zaa = 1;
        invalidateSelf();
    }

    public final boolean zac() {
        if (!this.zal) {
            boolean z = false;
            if (!(this.zaj.getConstantState() == null || this.zak.getConstantState() == null)) {
                z = true;
            }
            this.zam = z;
            this.zal = true;
        }
        return this.zam;
    }

    public zak(zaj zaj2) {
        this.zaa = 0;
        this.zad = InvitationReply.EXPIRED;
        this.zaf = 0;
        this.zag = true;
        this.zai = new zaj(zaj2);
    }
}
