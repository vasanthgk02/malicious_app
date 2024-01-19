package com.mpl.androidapp.miniprofile.extensions;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u001a-\u0010\u001f\u001a\u00020\u001b\"\b\b\u0000\u0010 *\u00020\u0010*\u0002H 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001b0\"¢\u0006\u0002\u0010#\u001a\n\u0010$\u001a\u00020\u001b*\u00020\u001c\u001a\u0015\u0010%\u001a\u00020\u0010*\u00020\u00112\u0006\u0010&\u001a\u00020\u0007H\u0002\u001a\n\u0010'\u001a\u00020(*\u00020\u0010\u001a\n\u0010)\u001a\u00020\u001b*\u00020\u0010\u001a\u001e\u0010*\u001a\u00020\u001b*\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0+H\bø\u0001\u0000\u001a\u001e\u0010,\u001a\u00020\u001b*\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0+H\bø\u0001\u0000\u001a\n\u0010-\u001a\u00020\u001e*\u00020\u0010\u001a\n\u0010.\u001a\u00020\u001e*\u00020\u0010\u001a\n\u0010/\u001a\u00020\u001e*\u00020\u0010\u001a-\u00100\u001a\u00020\u001b\"\b\b\u0000\u0010 *\u00020\u0010*\u0002H 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u00020\u001e0\"¢\u0006\u0002\u0010#\u001a\n\u00101\u001a\u00020\u001b*\u00020\u0015\u001a\n\u00102\u001a\u00020\u001b*\u00020\u0015\u001a\u001a\u00103\u001a\u00020\u001b*\u00020\u00102\u0006\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007\u001a\u0012\u00106\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u00107\u001a\u00020\u001b*\u00020\u00102\u0006\u00108\u001a\u00020\u0007\u001a\u0012\u00109\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010:\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010;\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010<\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010=\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010>\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010?\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010@\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010A\u001a\u00020\u001b*\u00020B2\u0006\u0010C\u001a\u00020\u001e\u001a\u0012\u0010D\u001a\u00020\u001b*\u00020\u00102\u0006\u0010E\u001a\u00020\u001e\u001a\u0012\u0010F\u001a\u00020\u001b*\u00020\u00102\u0006\u0010/\u001a\u00020\u001e\u001a\u0012\u0010G\u001a\u00020\u001b*\u00020\u00102\u0006\u0010/\u001a\u00020\u001e\u001a\u0012\u0010H\u001a\u00020\u001b*\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010I\u001a\u00020\u001b*\u00020B2\u0006\u0010C\u001a\u00020\u001e\u001a\"\u0010J\u001a\u0004\u0018\u0001H \"\u0004\b\u0000\u0010 *\u00020\u001e2\u0006\u0010K\u001a\u0002H H\u0004¢\u0006\u0002\u0010L\u001a\n\u0010M\u001a\u00020\u001b*\u00020\u001c\u001a\n\u0010N\u001a\u00020\u001b*\u00020\u0015\u001a\u001e\u0010O\u001a\u00020\u001b*\u00020\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0+H\bø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u00038Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"(\u0010\b\u001a\u00020\u0007*\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"(\u0010\u0006\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0002\u0007\n\u0005\b20\u0001¨\u0006P"}, d2 = {"duration", "", "interpolator", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "value", "", "checkedIndex", "Landroid/widget/RadioGroup;", "getCheckedIndex", "(Landroid/widget/RadioGroup;)I", "setCheckedIndex", "(Landroid/widget/RadioGroup;I)V", "children", "", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Ljava/util/List;", "", "Landroid/widget/EditText;", "getValue", "(Landroid/widget/EditText;)Ljava/lang/String;", "setValue", "(Landroid/widget/EditText;Ljava/lang/String;)V", "bold", "", "Landroid/widget/TextView;", "isBold", "", "click", "T", "block", "Lkotlin/Function1;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "deleteLine", "get", "index", "getBitmap", "Landroid/graphics/Bitmap;", "gone", "goneIf", "Lkotlin/Function0;", "invisiableIf", "isGone", "isInvisible", "isVisible", "longClick", "lowercase", "passwordToggledVisible", "resize", "width", "height", "setHeight", "setMarginLeft", "leftMargin", "setPaddingBottom", "setPaddingEnd", "setPaddingHorizontal", "setPaddingLeft", "setPaddingRight", "setPaddingStart", "setPaddingTop", "setPaddingVertical", "setShimmerVisibility", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "show", "setVisible", "visibility", "setVisibleOrGone", "setVisibleOrInvisible", "setWidth", "showShimmer", "then", "first", "(ZLjava/lang/Object;)Ljava/lang/Object;", "underLine", "uppercase", "visiableIf", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewExt.kt */
public final class ViewExtKt {
    public static final long duration = 750;

    public static final void bold(TextView textView, boolean z) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.getPaint().setFakeBoldText(z);
        textView.getPaint().setAntiAlias(true);
    }

    public static /* synthetic */ void bold$default(TextView textView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        bold(textView, z);
    }

    public static final <T extends View> void click(T t, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        t.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ViewExtKt.m13click$lambda4(Function1.this, view);
            }
        });
    }

    /* renamed from: click$lambda-4  reason: not valid java name */
    public static final void m13click$lambda4(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$block");
        if (view != null) {
            function1.invoke(view);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.mpl.androidapp.miniprofile.extensions.ViewExtKt.click$lambda-4");
    }

    public static final void deleteLine(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.getPaint().setFlags(textView.getPaint().getFlags() | 16);
        textView.getPaint().setAntiAlias(true);
    }

    public static final View get(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        View childAt = viewGroup.getChildAt(i);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(index)");
        return childAt;
    }

    public static final Bitmap getBitmap(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.draw(canvas);
        canvas.save();
        Intrinsics.checkNotNullExpressionValue(createBitmap, "bmp");
        return createBitmap;
    }

    public static final int getCheckedIndex(RadioGroup radioGroup) {
        Object obj;
        Intrinsics.checkNotNullParameter(radioGroup, "<this>");
        Iterator it = RangesKt___RangesKt.until(0, radioGroup.getChildCount()).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            View childAt = radioGroup.getChildAt(((Number) obj).intValue());
            if (childAt != null) {
                if (((RadioButton) childAt).isChecked()) {
                    break;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioButton");
            }
        }
        Integer num = (Integer) obj;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static final List<View> getChildren(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        IntRange until = RangesKt___RangesKt.until(0, viewGroup.getChildCount());
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(viewGroup.getChildAt(((IntIterator) it).nextInt()));
        }
        return arrayList;
    }

    public static final Interpolator getInterpolator() {
        return new AccelerateDecelerateInterpolator();
    }

    public static final String getValue(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        return editText.getText().toString();
    }

    public static final void gone(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static final void goneIf(View view, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (view.getVisibility() != 8 && ((Boolean) function0.invoke()).booleanValue()) {
            view.setVisibility(8);
        }
    }

    public static final void invisiableIf(View view, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (view.getVisibility() != 4 && ((Boolean) function0.invoke()).booleanValue()) {
            view.setVisibility(4);
        }
    }

    public static final boolean isGone(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final <T extends View> void longClick(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        t.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return ViewExtKt.m14longClick$lambda5(Function1.this, view);
            }
        });
    }

    /* renamed from: longClick$lambda-5  reason: not valid java name */
    public static final boolean m14longClick$lambda5(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$block");
        if (view != null) {
            return ((Boolean) function1.invoke(view)).booleanValue();
        }
        throw new NullPointerException("null cannot be cast to non-null type T of com.mpl.androidapp.miniprofile.extensions.ViewExtKt.longClick$lambda-5");
    }

    public static final void lowercase(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setTransformationMethod(new ViewExtKt$lowercase$1());
    }

    public static final void passwordToggledVisible(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        int selectionStart = editText.getSelectionStart();
        editText.setTransformationMethod(editText.getTransformationMethod() == null ? new PasswordTransformationMethod() : null);
        editText.setSelection(selectionStart);
    }

    public static final void resize(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    public static final void setCheckedIndex(RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(radioGroup, "<this>");
        if (!(i >= 0 && i < radioGroup.getChildCount())) {
            IntRange until = RangesKt___RangesKt.until(0, radioGroup.getChildCount());
            ArrayList<View> arrayList = new ArrayList<>(TweetUtils.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(radioGroup.getChildAt(((IntIterator) it).nextInt()));
            }
            ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(arrayList, 10));
            for (View view : arrayList) {
                arrayList2.add((RadioButton) view);
            }
            ArrayList<RadioButton> arrayList3 = new ArrayList<>();
            for (Object next : arrayList2) {
                if (((RadioButton) next).isChecked()) {
                    arrayList3.add(next);
                }
            }
            for (RadioButton checked : arrayList3) {
                checked.setChecked(false);
            }
            return;
        }
        View childAt = radioGroup.getChildAt(i);
        if (childAt != null) {
            ((RadioButton) childAt).setChecked(true);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RadioButton");
    }

    public static final void setHeight(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static final void setMarginLeft(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(i, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public static final void setPaddingBottom(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), i);
    }

    public static final void setPaddingEnd(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final void setPaddingHorizontal(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(i, view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final void setPaddingLeft(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(i, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public static final void setPaddingRight(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), i, view.getPaddingBottom());
    }

    public static final void setPaddingStart(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(i, view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
    }

    public static final void setPaddingTop(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(view.getPaddingStart(), i, view.getPaddingEnd(), view.getPaddingBottom());
    }

    public static final void setPaddingVertical(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPaddingRelative(view.getPaddingStart(), i, view.getPaddingEnd(), i);
    }

    public static final void setShimmerVisibility(ShimmerFrameLayout shimmerFrameLayout, boolean z) {
        Intrinsics.checkNotNullParameter(shimmerFrameLayout, "<this>");
        setVisible(shimmerFrameLayout, z);
        shimmerFrameLayout.showShimmer(z);
    }

    public static final void setValue(EditText editText, String str) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        editText.setText(str);
    }

    public static final void setVisible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static final void setVisibleOrGone(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public static final void setVisibleOrInvisible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    public static final void setWidth(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static final void showShimmer(ShimmerFrameLayout shimmerFrameLayout, boolean z) {
        Intrinsics.checkNotNullParameter(shimmerFrameLayout, "<this>");
        if (z) {
            shimmerFrameLayout.startShimmer();
        } else {
            shimmerFrameLayout.stopShimmer();
        }
    }

    public static final <T> T then(boolean z, T t) {
        if (z) {
            return t;
        }
        return null;
    }

    public static final void underLine(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.getPaint().setFlags(textView.getPaint().getFlags() | 8);
        textView.getPaint().setAntiAlias(true);
    }

    public static final void uppercase(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setTransformationMethod(new ViewExtKt$uppercase$1());
    }

    public static final void visiableIf(View view, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (view.getVisibility() != 0 && ((Boolean) function0.invoke()).booleanValue()) {
            view.setVisibility(0);
        }
    }
}
