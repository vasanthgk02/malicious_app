package com.mpl.androidapp.webview.view.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.mpl.androidapp.databinding.ContainerLoaderWebviewBinding;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.vm.WebViewGameVm;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u000eR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/mpl/androidapp/webview/view/customviews/WebViewLoaderContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/mpl/androidapp/databinding/ContainerLoaderWebviewBinding;", "screenVisible", "", "isVisible", "", "setGameIcon", "gameIcon", "", "setHeaderText", "message", "setLoadingMessageText", "setProgress", "progress", "setProgressType", "isIndefinate", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewLoaderContainer.kt */
public final class WebViewLoaderContainer extends LinearLayout {
    public Map<Integer, View> _$_findViewCache;
    public ContainerLoaderWebviewBinding binding;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewLoaderContainer(Context context) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, null, 0, 6, null);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewLoaderContainer(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WebViewLoaderContainer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void screenVisible(boolean z) {
        if (z) {
            this.binding.assetsLoadingLayout.setVisibility(0);
        } else {
            this.binding.assetsLoadingLayout.setVisibility(8);
        }
    }

    public final void setGameIcon(String str) {
        Intrinsics.checkNotNullParameter(str, WebViewGameVm.KEY_GAME_ICON);
        try {
            ((RequestBuilder) Glide.with((View) this).load(str).centerCrop()).into((ImageView) this.binding.logoOne);
        } catch (Exception e2) {
            MLogger.e("UI-WebView-Loader", e2.getMessage());
        }
    }

    public final void setHeaderText(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.binding.header.setText(str);
    }

    public final void setLoadingMessageText(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.binding.progressText.setText(str);
    }

    public final void setProgress(int i) {
        this.binding.assetsDownloadProgress.setProgress(i);
    }

    public final void setProgressType(boolean z) {
        this.binding.assetsDownloadProgress.setIndeterminate(z);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public WebViewLoaderContainer(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        ContainerLoaderWebviewBinding inflate = ContainerLoaderWebviewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…ontext), this, true\n    )");
        this.binding = inflate;
        this._$_findViewCache = new LinkedHashMap();
    }
}
