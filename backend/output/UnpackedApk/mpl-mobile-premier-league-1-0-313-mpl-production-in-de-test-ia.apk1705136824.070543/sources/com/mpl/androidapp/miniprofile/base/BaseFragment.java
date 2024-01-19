package com.mpl.androidapp.miniprofile.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B1\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016J\u001a\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\r\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/mpl/androidapp/miniprofile/base/BaseFragment;", "VIEW_BINDING", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "inflate", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "Lcom/mpl/androidapp/miniprofile/base/InflateFragment;", "(Lkotlin/jvm/functions/Function3;)V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "fragmentContext", "Landroid/content/Context;", "getFragmentContext", "()Landroid/content/Context;", "setFragmentContext", "(Landroid/content/Context;)V", "onAttach", "", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "container", "onDestroyView", "onDetach", "onViewCreated", "view", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment<VIEW_BINDING extends ViewBinding> extends Fragment {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public VIEW_BINDING _binding;
    public Context fragmentContext;
    public final Function3<LayoutInflater, ViewGroup, Boolean, VIEW_BINDING> inflate;

    public BaseFragment(Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ? extends VIEW_BINDING> function3) {
        Intrinsics.checkNotNullParameter(function3, "inflate");
        this.inflate = function3;
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
        View view2 = getView();
        if (view2 != null) {
            View findViewById = view2.findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
        }
        return null;
    }

    public final VIEW_BINDING getBinding() {
        VIEW_BINDING view_binding = this._binding;
        Intrinsics.checkNotNull(view_binding);
        return view_binding;
    }

    public final Context getFragmentContext() {
        return this.fragmentContext;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        this.fragmentContext = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fragmentContext != null) {
            setFragmentContext(getContext());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = (ViewBinding) this.inflate.invoke(layoutInflater, viewGroup, Boolean.FALSE);
        return getBinding().getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentContext = null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (this.fragmentContext != null) {
            setFragmentContext(view.getContext());
        }
    }

    public final void setFragmentContext(Context context) {
        this.fragmentContext = context;
    }
}
