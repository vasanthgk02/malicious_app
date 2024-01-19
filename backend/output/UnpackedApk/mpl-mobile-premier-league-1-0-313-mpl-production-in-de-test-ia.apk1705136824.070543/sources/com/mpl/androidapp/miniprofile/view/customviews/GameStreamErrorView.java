package com.mpl.androidapp.miniprofile.view.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.GameStreamErrorViewBinding;
import com.mpl.androidapp.miniprofile.extensions.DataBindingExtKt;
import com.mpl.androidapp.miniprofile.extensions.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/mpl/androidapp/miniprofile/view/customviews/GameStreamErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributes", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBinding", "Lcom/mpl/androidapp/databinding/GameStreamErrorViewBinding;", "setCloseButtonVisibility", "", "isVisible", "", "setCloseClickListener", "listener", "Landroid/view/View$OnClickListener;", "setDefaultParams", "setMiniProfileScreenParams", "setParamsForShareScreen", "setTryAgainClickListener", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameStreamErrorView.kt */
public final class GameStreamErrorView extends ConstraintLayout {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "GameStreamErrorView : GameStreamErrorView";
    public Map<Integer, View> _$_findViewCache;
    public GameStreamErrorViewBinding mBinding;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/miniprofile/view/customviews/GameStreamErrorView$Companion;", "", "()V", "TAG", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GameStreamErrorView.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GameStreamErrorView(Context context) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, null, 0, 6, null);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GameStreamErrorView(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ GameStreamErrorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setDefaultParams() {
        GameStreamErrorViewBinding gameStreamErrorViewBinding = this.mBinding;
        gameStreamErrorViewBinding.connectivityImgId.setImageResource(R.drawable.ic_mini_profile_error);
        gameStreamErrorViewBinding.txtTryAgain.setTextColor(ContextCompat.getColor(getContext(), R.color.gb_red_rounded));
        gameStreamErrorViewBinding.txtPleaseTryAgain.setText(R.string.gb_please_try_again_later);
        gameStreamErrorViewBinding.txtSomethingWentWrong.setTextColor(ContextCompat.getColor(getContext(), R.color.gb_profile_param_value));
        gameStreamErrorViewBinding.txtPleaseTryAgain.setTextColor(ContextCompat.getColor(getContext(), R.color.gb_profile_param_tag));
        ImageView imageView = gameStreamErrorViewBinding.smallLineId;
        Intrinsics.checkNotNullExpressionValue(imageView, "smallLineId");
        ViewExtKt.setVisibleOrGone(imageView, true);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.gb_profile_error_margin_top);
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.gb_profile_error_margin_bottom);
        LayoutParams layoutParams = gameStreamErrorViewBinding.txtTryAgain.getLayoutParams();
        if (layoutParams != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = dimensionPixelOffset2;
            marginLayoutParams.topMargin = dimensionPixelOffset;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
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

    public final void setCloseButtonVisibility(boolean z) {
        ImageView imageView = this.mBinding.streamCloseId;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.streamCloseId");
        ViewExtKt.setVisibleOrInvisible(imageView, z);
    }

    public final void setCloseClickListener(OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.mBinding.streamCloseId.setOnClickListener(onClickListener);
    }

    public final void setMiniProfileScreenParams() {
        setDefaultParams();
    }

    public final void setParamsForShareScreen() {
        setDefaultParams();
        GameStreamErrorViewBinding gameStreamErrorViewBinding = this.mBinding;
        ImageView imageView = gameStreamErrorViewBinding.smallLineId;
        Intrinsics.checkNotNullExpressionValue(imageView, "smallLineId");
        ViewExtKt.setVisibleOrGone(imageView, false);
        LayoutParams layoutParams = gameStreamErrorViewBinding.connectivityImgId.getLayoutParams();
        if (layoutParams != null) {
            ((MarginLayoutParams) layoutParams).topMargin = getContext().getResources().getDimensionPixelOffset(R.dimen.gb_share_screen_error_margin_top);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void setTryAgainClickListener(OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        setOnClickListener(onClickListener);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GameStreamErrorView(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.mBinding = (GameStreamErrorViewBinding) DataBindingExtKt.bind(this, from, R.layout.game_stream_error_view);
        this._$_findViewCache = new LinkedHashMap();
    }
}
