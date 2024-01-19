package com.crimzoncode.tqcontests.util.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.databinding.DataBindingUtil;
import com.crimzoncode.tqcontests.R;
import com.crimzoncode.tqcontests.databinding.ViewCustomDialogBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0000H\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0002J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010 \u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006J\u0010\u0010!\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010\u0011\u001a\u00020\nJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010$\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0006J\u0010\u0010&\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u0010\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/crimzoncode/tqcontests/util/dialog/DialogDetailsBuilder;", "", "()V", "binding", "Lcom/crimzoncode/tqcontests/databinding/ViewCustomDialogBinding;", "buttonText", "", "cancelable", "", "customViewRes", "", "descriptionBig", "descriptionSmall", "dialogDetails", "Lcom/crimzoncode/tqcontests/util/dialog/DialogDetails;", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "iconRes", "listener", "Lcom/crimzoncode/tqcontests/util/dialog/OnCustomDialogInteractionListener;", "secondaryButtonText", "title", "build", "buildDialog", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/content/Context;", "setButtonListeners", "", "dialog", "setButtonText", "setCancelable", "setDescriptionBig", "setDescriptionSmall", "setIconRes", "setListener", "setSecondaryButtonText", "secondarButtonText", "setTitle", "updateUI", "inflater", "Landroid/view/LayoutInflater;", "Companion", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: DialogDetailsBuilder.kt */
public final class DialogDetailsBuilder {
    public static final Companion Companion = new Companion(null);
    public ViewCustomDialogBinding binding;
    public String buttonText;
    public boolean cancelable;
    public int customViewRes;
    public String descriptionBig;
    public String descriptionSmall;
    public DialogDetails dialogDetails;
    public Drawable iconDrawable;
    public int iconRes;
    public OnCustomDialogInteractionListener listener;
    public String secondaryButtonText;
    public String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/crimzoncode/tqcontests/util/dialog/DialogDetailsBuilder$Companion;", "", "()V", "dialogBuilder", "Lcom/crimzoncode/tqcontests/util/dialog/DialogDetailsBuilder;", "getDialogBuilder", "()Lcom/crimzoncode/tqcontests/util/dialog/DialogDetailsBuilder;", "contests_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: DialogDetailsBuilder.kt */
    public static final class Companion {
        public Companion() {
        }

        public final DialogDetailsBuilder getDialogBuilder() {
            return new DialogDetailsBuilder(null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DialogDetailsBuilder() {
        this.cancelable = true;
    }

    private final DialogDetailsBuilder build() {
        DialogDetails dialogDetails2 = new DialogDetails();
        dialogDetails2.setListener(this.listener);
        dialogDetails2.setTitle(this.title);
        dialogDetails2.setDescriptionSmall(this.descriptionSmall);
        dialogDetails2.setDescriptionBig(this.descriptionBig);
        dialogDetails2.setButtonText(this.buttonText);
        dialogDetails2.setCancelable(this.cancelable);
        dialogDetails2.setIconRes(this.iconRes);
        dialogDetails2.setIconDrawable(this.iconDrawable);
        dialogDetails2.setSecondaryButtonText(this.secondaryButtonText);
        dialogDetails2.setCustomViewRes(this.customViewRes);
        this.dialogDetails = dialogDetails2;
        return this;
    }

    private final void setButtonListeners(AlertDialog alertDialog) {
        if (this.listener != null) {
            ViewCustomDialogBinding viewCustomDialogBinding = this.binding;
            if (viewCustomDialogBinding != null) {
                viewCustomDialogBinding.actionButton.setOnClickListener(new DialogDetailsBuilder$setButtonListeners$1(this, alertDialog));
                ViewCustomDialogBinding viewCustomDialogBinding2 = this.binding;
                if (viewCustomDialogBinding2 != null) {
                    viewCustomDialogBinding2.secondaryActionButton.setOnClickListener(new DialogDetailsBuilder$setButtonListeners$2(this, alertDialog));
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            } else {
                Intrinsics.throwNpe();
                throw null;
            }
        }
    }

    private final void updateUI(LayoutInflater layoutInflater) {
        DialogDetails dialogDetails2 = this.dialogDetails;
        if (dialogDetails2 != null) {
            if (dialogDetails2.getCustomViewRes() != 0) {
                DialogDetails dialogDetails3 = this.dialogDetails;
                if (dialogDetails3 != null) {
                    View inflate = layoutInflater.inflate(dialogDetails3.getCustomViewRes(), null);
                    ViewCustomDialogBinding viewCustomDialogBinding = this.binding;
                    if (viewCustomDialogBinding != null) {
                        viewCustomDialogBinding.customViewContainer.addView(inflate);
                    } else {
                        Intrinsics.throwNpe();
                        throw null;
                    }
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            }
            ViewCustomDialogBinding viewCustomDialogBinding2 = this.binding;
            if (viewCustomDialogBinding2 != null) {
                ImageView imageView = viewCustomDialogBinding2.popupLogo;
                Intrinsics.checkExpressionValueIsNotNull(imageView, "binding!!.popupLogo");
                DialogDetails dialogDetails4 = this.dialogDetails;
                if (dialogDetails4 != null) {
                    if (dialogDetails4.getIconRes() == 0) {
                        DialogDetails dialogDetails5 = this.dialogDetails;
                        if (dialogDetails5 == null) {
                            Intrinsics.throwNpe();
                            throw null;
                        } else if (dialogDetails5.getIconDrawable() == null) {
                            imageView.setVisibility(8);
                            return;
                        }
                    }
                    DialogDetails dialogDetails6 = this.dialogDetails;
                    if (dialogDetails6 != null) {
                        if (dialogDetails6.getIconRes() != 0) {
                            DialogDetails dialogDetails7 = this.dialogDetails;
                            if (dialogDetails7 != null) {
                                imageView.setImageResource(dialogDetails7.getIconRes());
                            } else {
                                Intrinsics.throwNpe();
                                throw null;
                            }
                        }
                        DialogDetails dialogDetails8 = this.dialogDetails;
                        if (dialogDetails8 == null) {
                            Intrinsics.throwNpe();
                            throw null;
                        } else if (dialogDetails8.getIconDrawable() != null) {
                            DialogDetails dialogDetails9 = this.dialogDetails;
                            if (dialogDetails9 != null) {
                                imageView.setImageDrawable(dialogDetails9.getIconDrawable());
                            } else {
                                Intrinsics.throwNpe();
                                throw null;
                            }
                        }
                    } else {
                        Intrinsics.throwNpe();
                        throw null;
                    }
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            } else {
                Intrinsics.throwNpe();
                throw null;
            }
        } else {
            Intrinsics.throwNpe();
            throw null;
        }
    }

    public final AlertDialog buildDialog(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        build();
        Builder builder = new Builder(context, R.style.CustomDialogTheme);
        LayoutInflater from = LayoutInflater.from(context);
        ViewCustomDialogBinding viewCustomDialogBinding = (ViewCustomDialogBinding) DataBindingUtil.inflate(from, R.layout.view_custom_dialog, null, false);
        this.binding = viewCustomDialogBinding;
        if (viewCustomDialogBinding != null) {
            TextView textView = viewCustomDialogBinding.descriptionSmall;
            Intrinsics.checkExpressionValueIsNotNull(textView, "binding!!.descriptionSmall");
            textView.setMovementMethod(new ScrollingMovementMethod());
            ViewCustomDialogBinding viewCustomDialogBinding2 = this.binding;
            if (viewCustomDialogBinding2 != null) {
                viewCustomDialogBinding2.setListener(this.listener);
                ViewCustomDialogBinding viewCustomDialogBinding3 = this.binding;
                if (viewCustomDialogBinding3 != null) {
                    viewCustomDialogBinding3.setDialogDetails(this.dialogDetails);
                    ViewCustomDialogBinding viewCustomDialogBinding4 = this.binding;
                    if (viewCustomDialogBinding4 != null) {
                        View root = viewCustomDialogBinding4.getRoot();
                        Intrinsics.checkExpressionValueIsNotNull(root, "binding!!.root");
                        AlertParams alertParams = builder.P;
                        alertParams.mView = root;
                        alertParams.mViewLayoutResId = 0;
                        alertParams.mViewSpacingSpecified = false;
                        DialogDetails dialogDetails2 = this.dialogDetails;
                        if (dialogDetails2 != null) {
                            builder.P.mCancelable = dialogDetails2.isCancelable();
                            AlertDialog create = builder.create();
                            Intrinsics.checkExpressionValueIsNotNull(from, "inflater");
                            updateUI(from);
                            Intrinsics.checkExpressionValueIsNotNull(create, "dialog");
                            setButtonListeners(create);
                            return create;
                        }
                        Intrinsics.throwNpe();
                        throw null;
                    }
                    Intrinsics.throwNpe();
                    throw null;
                }
                Intrinsics.throwNpe();
                throw null;
            }
            Intrinsics.throwNpe();
            throw null;
        }
        Intrinsics.throwNpe();
        throw null;
    }

    public final DialogDetailsBuilder setButtonText(String str) {
        this.buttonText = str;
        return this;
    }

    public final DialogDetailsBuilder setCancelable(boolean z) {
        this.cancelable = z;
        return this;
    }

    public final DialogDetailsBuilder setDescriptionBig(String str) {
        this.descriptionBig = str;
        return this;
    }

    public final DialogDetailsBuilder setDescriptionSmall(String str) {
        this.descriptionSmall = str;
        return this;
    }

    public final DialogDetailsBuilder setIconRes(int i) {
        this.iconRes = i;
        return this;
    }

    public final DialogDetailsBuilder setListener(OnCustomDialogInteractionListener onCustomDialogInteractionListener) {
        this.listener = onCustomDialogInteractionListener;
        return this;
    }

    public final DialogDetailsBuilder setSecondaryButtonText(String str) {
        this.secondaryButtonText = str;
        return this;
    }

    public final DialogDetailsBuilder setTitle(String str) {
        this.title = str;
        return this;
    }

    public /* synthetic */ DialogDetailsBuilder(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
