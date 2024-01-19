package com.crimzoncode.tqcontests.util.dialog;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\b¨\u0006/"}, d2 = {"Lcom/crimzoncode/tqcontests/util/dialog/DialogDetails;", "", "()V", "buttonText", "", "getButtonText", "()Ljava/lang/String;", "setButtonText", "(Ljava/lang/String;)V", "customViewRes", "", "getCustomViewRes", "()I", "setCustomViewRes", "(I)V", "descriptionBig", "getDescriptionBig", "setDescriptionBig", "descriptionSmall", "getDescriptionSmall", "setDescriptionSmall", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "setIconDrawable", "(Landroid/graphics/drawable/Drawable;)V", "iconRes", "getIconRes", "setIconRes", "isCancelable", "", "()Z", "setCancelable", "(Z)V", "listener", "Lcom/crimzoncode/tqcontests/util/dialog/OnCustomDialogInteractionListener;", "getListener", "()Lcom/crimzoncode/tqcontests/util/dialog/OnCustomDialogInteractionListener;", "setListener", "(Lcom/crimzoncode/tqcontests/util/dialog/OnCustomDialogInteractionListener;)V", "secondaryButtonText", "getSecondaryButtonText", "setSecondaryButtonText", "title", "getTitle", "setTitle", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DialogDetails.kt */
public final class DialogDetails {
    public String buttonText;
    public int customViewRes;
    public String descriptionBig;
    public String descriptionSmall;
    public Drawable iconDrawable;
    public int iconRes;
    public boolean isCancelable;
    public OnCustomDialogInteractionListener listener;
    public String secondaryButtonText;
    public String title;

    public final String getButtonText() {
        return this.buttonText;
    }

    public final int getCustomViewRes() {
        return this.customViewRes;
    }

    public final String getDescriptionBig() {
        return this.descriptionBig;
    }

    public final String getDescriptionSmall() {
        return this.descriptionSmall;
    }

    public final Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final OnCustomDialogInteractionListener getListener() {
        return this.listener;
    }

    public final String getSecondaryButtonText() {
        return this.secondaryButtonText;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    public final void setButtonText(String str) {
        this.buttonText = str;
    }

    public final void setCancelable(boolean z) {
        this.isCancelable = z;
    }

    public final void setCustomViewRes(int i) {
        this.customViewRes = i;
    }

    public final void setDescriptionBig(String str) {
        this.descriptionBig = str;
    }

    public final void setDescriptionSmall(String str) {
        this.descriptionSmall = str;
    }

    public final void setIconDrawable(Drawable drawable) {
        this.iconDrawable = drawable;
    }

    public final void setIconRes(int i) {
        this.iconRes = i;
    }

    public final void setListener(OnCustomDialogInteractionListener onCustomDialogInteractionListener) {
        this.listener = onCustomDialogInteractionListener;
    }

    public final void setSecondaryButtonText(String str) {
        this.secondaryButtonText = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}
