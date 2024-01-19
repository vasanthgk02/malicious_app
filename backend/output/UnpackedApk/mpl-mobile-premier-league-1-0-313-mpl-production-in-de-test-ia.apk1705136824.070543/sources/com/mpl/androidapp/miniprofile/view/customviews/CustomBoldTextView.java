package com.mpl.androidapp.miniprofile.view.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import com.mpl.androidapp.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/miniprofile/view/customviews/CustomBoldTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "init", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomBoldTextView.kt */
public final class CustomBoldTextView extends AppCompatTextView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CustomBoldTextView(Context context) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context);
        init(context, null);
    }

    private final void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            setTypeface(ResourcesCompat.getFont(context, R.font.roboto_bold));
        }
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

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CustomBoldTextView(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet);
        init(context, attributeSet);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CustomBoldTextView(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
