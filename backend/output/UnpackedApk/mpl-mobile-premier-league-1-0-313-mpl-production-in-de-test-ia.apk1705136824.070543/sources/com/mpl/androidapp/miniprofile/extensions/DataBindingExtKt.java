package com.mpl.androidapp.miniprofile.extensions;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006\u001a\u0019\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0007¢\u0006\u0002\u0010\b\u001a)\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"bind", "T", "Landroidx/databinding/ViewDataBinding;", "Landroid/app/Activity;", "layoutId", "", "(Landroid/app/Activity;I)Landroidx/databinding/ViewDataBinding;", "Landroid/view/View;", "(Landroid/view/View;)Landroidx/databinding/ViewDataBinding;", "Landroid/view/ViewGroup;", "inflater", "Landroid/view/LayoutInflater;", "(Landroid/view/ViewGroup;Landroid/view/LayoutInflater;I)Landroidx/databinding/ViewDataBinding;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DataBindingExt.kt */
public final class DataBindingExtKt {
    public static final <T extends ViewDataBinding> T bind(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        T inflate = DataBindingUtil.inflate(layoutInflater, i, viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, layoutId, this, true)");
        return inflate;
    }

    public static final <T extends ViewDataBinding> T bind(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        T contentView = DataBindingUtil.setContentView(activity, i);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, layoutId)");
        return contentView;
    }

    public static final <T extends ViewDataBinding> T bind(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        DataBindingComponent dataBindingComponent = DataBindingUtil.sDefaultComponent;
        T binding = ViewDataBinding.getBinding(view);
        if (binding == null) {
            Object tag = view.getTag();
            if (tag instanceof String) {
                int layoutId = DataBindingUtil.sMapper.getLayoutId((String) tag);
                if (layoutId != 0) {
                    binding = DataBindingUtil.sMapper.getDataBinder(dataBindingComponent, view, layoutId);
                } else {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline48("View is not a binding layout. Tag: ", tag));
                }
            } else {
                throw new IllegalArgumentException("View is not a binding layout");
            }
        }
        if (binding != null) {
            return binding;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.mpl.androidapp.miniprofile.extensions.DataBindingExtKt.bind");
    }
}
