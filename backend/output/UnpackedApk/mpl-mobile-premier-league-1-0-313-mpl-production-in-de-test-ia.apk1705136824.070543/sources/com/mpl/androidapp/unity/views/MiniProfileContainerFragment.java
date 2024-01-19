package com.mpl.androidapp.unity.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.databinding.FragmentMiniProfileContainerBinding;
import com.mpl.androidapp.miniprofile.models.ProfileDetails;
import com.mpl.androidapp.miniprofile.utils.Constants;
import com.mpl.androidapp.miniprofile.view.fragment.MiniProfileBottomSheetImpl;
import com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment;
import com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel;
import com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel;
import com.mpl.androidapp.model.UnityMiniProfileData;
import com.mpl.androidapp.unity.states.UnityViewProfileState;
import com.mpl.androidapp.unity.states.UnityViewProfileState.ErrorState;
import com.mpl.androidapp.unity.states.UnityViewProfileState.InitialUnityProfileState;
import com.mpl.androidapp.unity.states.UnityViewProfileState.ViewProfileDeepLink;
import com.mpl.androidapp.unity.vm.MiniProfileContainerVm;
import com.mpl.androidapp.utils.MLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u001a\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010$\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010%\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006*"}, d2 = {"Lcom/mpl/androidapp/unity/views/MiniProfileContainerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/mpl/androidapp/miniprofile/view/fragment/MiniProfileBottomSheetImpl;", "()V", "binding", "Lcom/mpl/androidapp/databinding/FragmentMiniProfileContainerBinding;", "callback", "Lcom/mpl/androidapp/unity/views/MiniProfileContainerFragment$Callback;", "profileData", "Lcom/mpl/androidapp/model/UnityMiniProfileData;", "sharedGameStreamViewModel", "Lcom/mpl/androidapp/miniprofile/vm/SharedGameStreamViewModel;", "getSharedGameStreamViewModel", "()Lcom/mpl/androidapp/miniprofile/vm/SharedGameStreamViewModel;", "sharedGameStreamViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/mpl/androidapp/unity/vm/MiniProfileContainerVm;", "getViewModel", "()Lcom/mpl/androidapp/unity/vm/MiniProfileContainerVm;", "viewModel$delegate", "launchMiniProfile", "", "observeLiveData", "onCloseMiniProfileBottomSheet", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setCallback", "setProfileData", "setViewState", "state", "Lcom/mpl/androidapp/unity/states/UnityViewProfileState;", "Callback", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiniProfileContainerFragment.kt */
public final class MiniProfileContainerFragment extends Hilt_MiniProfileContainerFragment implements MiniProfileBottomSheetImpl {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public FragmentMiniProfileContainerBinding binding;
    public Callback callback;
    public UnityMiniProfileData profileData;
    public final Lazy sharedGameStreamViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SharedGameStreamViewModel.class), new MiniProfileContainerFragment$special$$inlined$viewModels$default$4(new MiniProfileContainerFragment$special$$inlined$viewModels$default$3(this)), null);
    public final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MiniProfileContainerVm.class), new MiniProfileContainerFragment$special$$inlined$viewModels$default$2(new MiniProfileContainerFragment$special$$inlined$viewModels$default$1(this)), null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/unity/views/MiniProfileContainerFragment$Callback;", "", "closeProfile", "", "openProfile", "reactDeepLink", "", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MiniProfileContainerFragment.kt */
    public interface Callback {
        void closeProfile();

        void openProfile(String str);
    }

    private final SharedGameStreamViewModel getSharedGameStreamViewModel() {
        return (SharedGameStreamViewModel) this.sharedGameStreamViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MiniProfileContainerVm getViewModel() {
        return (MiniProfileContainerVm) this.viewModel$delegate.getValue();
    }

    private final void launchMiniProfile() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        MiniProfileFragment miniProfileFragment = new MiniProfileFragment();
        miniProfileFragment.initOnClickInterface(this);
        if (!miniProfileFragment.isAdded()) {
            Bundle outline14 = GeneratedOutlineSupport.outline14(Constants.KEY_SCREEN_TYPE, MiniProfileViewModel.UNITY_INSTRUMENTATION_DEEPLINK);
            UnityMiniProfileData unityMiniProfileData = this.profileData;
            if (unityMiniProfileData != null) {
                outline14.putString(Constants.PLAYER_ID_KEY, String.valueOf(unityMiniProfileData.getProfileId()));
                miniProfileFragment.setArguments(outline14);
                miniProfileFragment.show(childFragmentManager, (String) Constants.miniProfileTag);
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("profileData");
            throw null;
        }
    }

    private final void observeLiveData() {
        SharedGameStreamViewModel sharedGameStreamViewModel = getSharedGameStreamViewModel();
        sharedGameStreamViewModel.getShowCompleteProfile().observe(getViewLifecycleOwner(), new Observer(this) {
            public final /* synthetic */ MiniProfileContainerFragment f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                MiniProfileContainerFragment.m24observeLiveData$lambda1$lambda0(SharedGameStreamViewModel.this, this.f$1, (ProfileDetails) obj);
            }
        });
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new MiniProfileContainerFragment$observeLiveData$2(this, null));
    }

    /* renamed from: observeLiveData$lambda-1$lambda-0  reason: not valid java name */
    public static final void m24observeLiveData$lambda1$lambda0(SharedGameStreamViewModel sharedGameStreamViewModel, MiniProfileContainerFragment miniProfileContainerFragment, ProfileDetails profileDetails) {
        Intrinsics.checkNotNullParameter(sharedGameStreamViewModel, "$this_apply");
        Intrinsics.checkNotNullParameter(miniProfileContainerFragment, "this$0");
        MLogger.d("UnitiyMiniProfile", "show full profile live data of " + sharedGameStreamViewModel + ".javaClass.simpleName class is triggered");
        LifecycleOwnerKt.getLifecycleScope(miniProfileContainerFragment).launchWhenStarted(new MiniProfileContainerFragment$observeLiveData$1$1$1(miniProfileContainerFragment, profileDetails, null));
    }

    /* access modifiers changed from: private */
    public final void setViewState(UnityViewProfileState unityViewProfileState) {
        if (unityViewProfileState instanceof ViewProfileDeepLink) {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.openProfile(((ViewProfileDeepLink) unityViewProfileState).getReactDeepLink());
            }
        } else if (!(unityViewProfileState instanceof ErrorState)) {
            boolean z = unityViewProfileState instanceof InitialUnityProfileState;
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

    public void onCloseMiniProfileBottomSheet() {
        MLogger.d("UnitiyMiniProfile", "onCloseMiniProfileBottomSheet function of  " + this + ".javaClass.simpleName class is triggered");
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.closeProfile();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMiniProfileContainerBinding inflate = FragmentMiniProfileContainerBinding.inflate(layoutInflater, viewGroup, false);
        this.binding = inflate;
        if (inflate == null) {
            return null;
        }
        return inflate.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        MLogger.d("UnitiyMiniProfile", "onDestroyView event of " + this + ".javaClass.simpleName class is triggered");
        this.binding = null;
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        MLogger.d("UnitiyMiniProfile", "onViewCreated event of " + this + ".javaClass.simpleName class is triggered");
        getSharedGameStreamViewModel().setGameBroadcastConfig();
        launchMiniProfile();
        observeLiveData();
    }

    public final void setCallback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
    }

    public final void setProfileData(UnityMiniProfileData unityMiniProfileData) {
        Intrinsics.checkNotNullParameter(unityMiniProfileData, "profileData");
        this.profileData = unityMiniProfileData;
    }
}
