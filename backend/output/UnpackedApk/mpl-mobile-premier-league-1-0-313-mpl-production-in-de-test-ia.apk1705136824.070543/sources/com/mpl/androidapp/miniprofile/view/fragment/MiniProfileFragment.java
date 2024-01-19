package com.mpl.androidapp.miniprofile.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.mpl.androidapp.R;
import com.mpl.androidapp.databinding.FragmentMiniProfileBinding;
import com.mpl.androidapp.miniprofile.base.BaseBottomSheetDialogFragment;
import com.mpl.androidapp.miniprofile.ct.C.ProfileFollowed;
import com.mpl.androidapp.miniprofile.extensions.ViewExtKt;
import com.mpl.androidapp.miniprofile.models.GameStatsPayload;
import com.mpl.androidapp.miniprofile.utils.Constants;
import com.mpl.androidapp.miniprofile.view.customviews.GameStreamErrorView;
import com.mpl.androidapp.miniprofile.view.customviews.MiniProfileLoadingView;
import com.mpl.androidapp.miniprofile.view.customviews.MiniProfileView;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult.ErrorState;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult.GameStatusSuccess;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult.LoadingState;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult.ProfileDetailsSuccessState;
import com.mpl.androidapp.miniprofile.viewresult.MiniProfileResult.ScreenSuccessFollowState;
import com.mpl.androidapp.miniprofile.vm.MiniProfileViewModel;
import com.mpl.androidapp.miniprofile.vm.SharedGameStreamViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0014H\u0002J\b\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0014H\u0002J \u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006-"}, d2 = {"Lcom/mpl/androidapp/miniprofile/view/fragment/MiniProfileFragment;", "Lcom/mpl/androidapp/miniprofile/base/BaseBottomSheetDialogFragment;", "Lcom/mpl/androidapp/databinding/FragmentMiniProfileBinding;", "()V", "listener", "Lcom/mpl/androidapp/miniprofile/view/fragment/MiniProfileBottomSheetImpl;", "mContext", "Landroid/content/Context;", "sharedGameStreamViewModel", "Lcom/mpl/androidapp/miniprofile/vm/SharedGameStreamViewModel;", "getSharedGameStreamViewModel", "()Lcom/mpl/androidapp/miniprofile/vm/SharedGameStreamViewModel;", "sharedGameStreamViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/mpl/androidapp/miniprofile/vm/MiniProfileViewModel;", "getViewModel", "()Lcom/mpl/androidapp/miniprofile/vm/MiniProfileViewModel;", "viewModel$delegate", "fullProfileView", "", "initOnClickInterface", "initUi", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "Landroid/view/View;", "profileDetailsApi", "setClickListeners", "setViewState", "it", "Lcom/mpl/androidapp/miniprofile/viewresult/MiniProfileResult;", "setupObserver", "updateMiniProfileDisplayStates", "profileViewState", "", "profileLoadingViewState", "profileErrorViewState", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MiniProfileFragment.kt */
public final class MiniProfileFragment extends BaseBottomSheetDialogFragment<FragmentMiniProfileBinding> {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public MiniProfileBottomSheetImpl listener;
    public Context mContext;
    public final Lazy sharedGameStreamViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SharedGameStreamViewModel.class), new MiniProfileFragment$special$$inlined$viewModels$default$3(new MiniProfileFragment$sharedGameStreamViewModel$2(this)), null);
    public final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(MiniProfileViewModel.class), new MiniProfileFragment$special$$inlined$viewModels$default$2(new MiniProfileFragment$special$$inlined$viewModels$default$1(this)), null);

    public MiniProfileFragment() {
        super(AnonymousClass1.INSTANCE);
    }

    private final void fullProfileView() {
        getSharedGameStreamViewModel().getShowCompleteProfile().setValue(getViewModel().getProfileDetails());
        dismiss();
    }

    private final SharedGameStreamViewModel getSharedGameStreamViewModel() {
        return (SharedGameStreamViewModel) this.sharedGameStreamViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MiniProfileViewModel getViewModel() {
        return (MiniProfileViewModel) this.viewModel$delegate.getValue();
    }

    private final void initUi() {
        setupObserver();
        setClickListeners();
        ((FragmentMiniProfileBinding) getBinding()).profileErrorViewId.setMiniProfileScreenParams();
        profileDetailsApi();
    }

    private final void profileDetailsApi() {
        TypeUtilsKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new MiniProfileFragment$profileDetailsApi$1(this, null), 3, null);
    }

    private final void setClickListeners() {
        ((FragmentMiniProfileBinding) getBinding()).profileViewId.otherUserViewProfile(new OnClickListener() {
            public final void onClick(View view) {
                MiniProfileFragment.m15setClickListeners$lambda4(MiniProfileFragment.this, view);
            }
        });
        ((FragmentMiniProfileBinding) getBinding()).profileViewId.otherUserMessageFollow(new OnClickListener() {
            public final void onClick(View view) {
                MiniProfileFragment.m16setClickListeners$lambda5(MiniProfileFragment.this, view);
            }
        });
        ((FragmentMiniProfileBinding) getBinding()).profileErrorViewId.setTryAgainClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MiniProfileFragment.m17setClickListeners$lambda6(MiniProfileFragment.this, view);
            }
        });
        ((FragmentMiniProfileBinding) getBinding()).closeBtn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                MiniProfileFragment.m18setClickListeners$lambda7(MiniProfileFragment.this, view);
            }
        });
    }

    /* renamed from: setClickListeners$lambda-4  reason: not valid java name */
    public static final void m15setClickListeners$lambda4(MiniProfileFragment miniProfileFragment, View view) {
        Intrinsics.checkNotNullParameter(miniProfileFragment, "this$0");
        miniProfileFragment.fullProfileView();
    }

    /* renamed from: setClickListeners$lambda-5  reason: not valid java name */
    public static final void m16setClickListeners$lambda5(MiniProfileFragment miniProfileFragment, View view) {
        Intrinsics.checkNotNullParameter(miniProfileFragment, "this$0");
        if (miniProfileFragment.getViewModel().getProfileDetails().getFollowDetails().getFollowing()) {
            miniProfileFragment.getSharedGameStreamViewModel().getSendChatToPlayer().setValue(miniProfileFragment.getViewModel().getProfileDetails());
            miniProfileFragment.dismiss();
            return;
        }
        TypeUtilsKt.launch$default(LifecycleOwnerKt.getLifecycleScope(miniProfileFragment), null, null, new MiniProfileFragment$setClickListeners$2$1(miniProfileFragment, null), 3, null);
    }

    /* renamed from: setClickListeners$lambda-6  reason: not valid java name */
    public static final void m17setClickListeners$lambda6(MiniProfileFragment miniProfileFragment, View view) {
        Intrinsics.checkNotNullParameter(miniProfileFragment, "this$0");
        TypeUtilsKt.launch$default(LifecycleOwnerKt.getLifecycleScope(miniProfileFragment), null, null, new MiniProfileFragment$setClickListeners$3$1(miniProfileFragment, null), 3, null);
    }

    /* renamed from: setClickListeners$lambda-7  reason: not valid java name */
    public static final void m18setClickListeners$lambda7(MiniProfileFragment miniProfileFragment, View view) {
        Intrinsics.checkNotNullParameter(miniProfileFragment, "this$0");
        miniProfileFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public final void setViewState(MiniProfileResult miniProfileResult) {
        if (miniProfileResult instanceof ErrorState) {
            updateMiniProfileDisplayStates(false, false, true);
        } else if (miniProfileResult instanceof LoadingState) {
            updateMiniProfileDisplayStates(false, true, false);
        } else if (miniProfileResult instanceof ProfileDetailsSuccessState) {
            updateMiniProfileDisplayStates(true, false, false);
            ProfileDetailsSuccessState profileDetailsSuccessState = (ProfileDetailsSuccessState) miniProfileResult;
            getViewModel().setProfileDetails(profileDetailsSuccessState.getProfileDetails());
            getViewModel().getGameStats();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                getViewModel().initiateProfileViewedEvent(activity, profileDetailsSuccessState.getProfileDetails());
                ((FragmentMiniProfileBinding) getBinding()).profileViewId.isUserAccountDeleted(profileDetailsSuccessState.getProfileDetails());
            }
        } else if (miniProfileResult instanceof ScreenSuccessFollowState) {
            updateMiniProfileDisplayStates(true, false, true);
            if (((ScreenSuccessFollowState) miniProfileResult).isSuccess()) {
                getSharedGameStreamViewModel().getUpdateFollowedUsrOnPlayersListIfOpened().setValue(getViewModel().getProfileId());
                profileDetailsApi();
                getSharedGameStreamViewModel().sendProfileFollowedEvent(ProfileFollowed.ENTRY_MINI_PROFILE);
            }
        } else if (miniProfileResult instanceof GameStatusSuccess) {
            boolean showKycVerifiedStatus = getSharedGameStreamViewModel().getProfileConfig().getShowKycVerifiedStatus();
            GameStatsPayload gameStatsPayload = ((GameStatusSuccess) miniProfileResult).getGameStatsPayload();
            ((FragmentMiniProfileBinding) getBinding()).profileViewId.setDataForProfile(getViewModel().getProfileDetails(), getSharedGameStreamViewModel().isChatEnabled(), getSharedGameStreamViewModel().isUserNameEnabledInConfig(), showKycVerifiedStatus, getViewModel().isGameStatsEnabled(getSharedGameStreamViewModel().getProfileConfig().getProfileShowWinRate(), getSharedGameStreamViewModel().isGameStatsEnabled()), gameStatsPayload);
        }
    }

    private final void setupObserver() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new MiniProfileFragment$setupObserver$1(this, null));
    }

    /* access modifiers changed from: private */
    public final void updateMiniProfileDisplayStates(boolean z, boolean z2, boolean z3) {
        MiniProfileView miniProfileView = ((FragmentMiniProfileBinding) getBinding()).profileViewId;
        Intrinsics.checkNotNullExpressionValue(miniProfileView, "binding.profileViewId");
        ViewExtKt.setVisibleOrGone(miniProfileView, z);
        MiniProfileLoadingView miniProfileLoadingView = ((FragmentMiniProfileBinding) getBinding()).profileLoadingViewId;
        Intrinsics.checkNotNullExpressionValue(miniProfileLoadingView, "binding.profileLoadingViewId");
        ViewExtKt.setVisibleOrGone(miniProfileLoadingView, z2);
        GameStreamErrorView gameStreamErrorView = ((FragmentMiniProfileBinding) getBinding()).profileErrorViewId;
        Intrinsics.checkNotNullExpressionValue(gameStreamErrorView, "binding.profileErrorViewId");
        ViewExtKt.setVisibleOrGone(gameStreamErrorView, z3);
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

    public final void initOnClickInterface(MiniProfileBottomSheetImpl miniProfileBottomSheetImpl) {
        Intrinsics.checkNotNullParameter(miniProfileBottomSheetImpl, "listener");
        this.listener = miniProfileBottomSheetImpl;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.mpl.androidapp.miniprofile.view.fragment.Hilt_MiniProfileFragment, com.mpl.androidapp.miniprofile.view.fragment.MiniProfileFragment] */
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MiniProfileFragment.super.onAttach(context);
        this.mContext = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.VideoTracksTheme);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        MiniProfileBottomSheetImpl miniProfileBottomSheetImpl = this.listener;
        if (miniProfileBottomSheetImpl != null) {
            miniProfileBottomSheetImpl.onCloseMiniProfileBottomSheet();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(Constants.PLAYER_ID_KEY);
            if (string != null) {
                getViewModel().setProfileId(string);
            }
            String string2 = arguments.getString(Constants.EVENT_ID);
            if (string2 != null) {
                getViewModel().setEventId(string2);
            }
            String string3 = arguments.getString(Constants.KEY_SCREEN_TYPE);
            if (string3 != null) {
                getViewModel().setScreenType(string3);
            }
        }
        initUi();
    }
}
