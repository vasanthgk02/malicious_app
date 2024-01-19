package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.widget.CompoundButtonCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProvider.KeyedFactory;
import androidx.lifecycle.ViewModelProvider.OnRequeryFactory;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavControllerViewModel.AnonymousClass1;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.R$id;
import androidx.navigation.R$styleable;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Map.Entry;

public class NavHostFragment extends Fragment {
    public boolean mDefaultNavHost;
    public int mGraphId;
    public Boolean mIsPrimaryBeforeOnCreate = null;
    public NavHostController mNavController;
    public View mViewParent;

    public static NavController findNavController(Fragment fragment) {
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getParentFragment()) {
            if (fragment2 instanceof NavHostFragment) {
                NavHostController navHostController = ((NavHostFragment) fragment2).mNavController;
                if (navHostController != null) {
                    return navHostController;
                }
                throw new IllegalStateException("NavController is not available before onCreate()");
            }
            Fragment primaryNavigationFragment = fragment2.getParentFragmentManager().getPrimaryNavigationFragment();
            if (primaryNavigationFragment instanceof NavHostFragment) {
                NavHostController navHostController2 = ((NavHostFragment) primaryNavigationFragment).mNavController;
                if (navHostController2 != null) {
                    return navHostController2;
                }
                throw new IllegalStateException("NavController is not available before onCreate()");
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return CompoundButtonCompat.findNavController(view);
        }
        throw new IllegalStateException(GeneratedOutlineSupport.outline47("Fragment ", fragment, " does not have a NavController set"));
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.mDefaultNavHost) {
            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        ViewModel viewModel;
        super.onCreate(bundle);
        NavHostController navHostController = new NavHostController(requireContext());
        this.mNavController = navHostController;
        navHostController.mLifecycleOwner = this;
        getLifecycle().addObserver(navHostController.mLifecycleObserver);
        NavHostController navHostController2 = this.mNavController;
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        if (navHostController2.mLifecycleOwner != null) {
            navHostController2.mOnBackPressedCallback.remove();
            onBackPressedDispatcher.addCallback(navHostController2.mLifecycleOwner, navHostController2.mOnBackPressedCallback);
            NavHostController navHostController3 = this.mNavController;
            Boolean bool = this.mIsPrimaryBeforeOnCreate;
            int i = 0;
            navHostController3.mEnableOnBackPressedCallback = bool != null && bool.booleanValue();
            navHostController3.updateOnBackPressedCallbackEnabled();
            Bundle bundle3 = null;
            this.mIsPrimaryBeforeOnCreate = null;
            NavHostController navHostController4 = this.mNavController;
            ViewModelStore viewModelStore = getViewModelStore();
            if (navHostController4.mBackStack.isEmpty()) {
                Factory factory = NavControllerViewModel.FACTORY;
                Class cls = NavControllerViewModel.class;
                String canonicalName = cls.getCanonicalName();
                if (canonicalName != null) {
                    String outline50 = GeneratedOutlineSupport.outline50("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    ViewModel viewModel2 = viewModelStore.mMap.get(outline50);
                    if (!cls.isInstance(viewModel2)) {
                        if (factory instanceof KeyedFactory) {
                            viewModel = ((KeyedFactory) factory).create(outline50, cls);
                        } else {
                            AnonymousClass1 r5 = (AnonymousClass1) factory;
                            viewModel = new NavControllerViewModel();
                        }
                        viewModel2 = viewModel;
                        ViewModel put = viewModelStore.mMap.put(outline50, viewModel2);
                        if (put != null) {
                            put.onCleared();
                        }
                    } else if (factory instanceof OnRequeryFactory) {
                        ((OnRequeryFactory) factory).onRequery(viewModel2);
                    }
                    navHostController4.mViewModel = (NavControllerViewModel) viewModel2;
                    NavHostController navHostController5 = this.mNavController;
                    navHostController5.mNavigatorProvider.addNavigator(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
                    NavigatorProvider navigatorProvider = navHostController5.mNavigatorProvider;
                    Context requireContext = requireContext();
                    FragmentManager childFragmentManager = getChildFragmentManager();
                    int id = getId();
                    if (id == 0 || id == -1) {
                        id = R$id.nav_host_fragment_container;
                    }
                    navigatorProvider.addNavigator(new FragmentNavigator(requireContext, childFragmentManager, id));
                    if (bundle != null) {
                        bundle2 = bundle.getBundle("android-support-nav:fragment:navControllerState");
                        if (bundle.getBoolean("android-support-nav:fragment:defaultHost", false)) {
                            this.mDefaultNavHost = true;
                            getParentFragmentManager().beginTransaction().setPrimaryNavigationFragment(this).commit();
                        }
                        this.mGraphId = bundle.getInt("android-support-nav:fragment:graphId");
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        NavHostController navHostController6 = this.mNavController;
                        if (navHostController6 != null) {
                            bundle2.setClassLoader(navHostController6.mContext.getClassLoader());
                            navHostController6.mNavigatorStateToRestore = bundle2.getBundle("android-support-nav:controller:navigatorState");
                            navHostController6.mBackStackToRestore = bundle2.getParcelableArray("android-support-nav:controller:backStack");
                            navHostController6.mDeepLinkHandled = bundle2.getBoolean("android-support-nav:controller:deepLinkHandled");
                        } else {
                            throw null;
                        }
                    }
                    int i2 = this.mGraphId;
                    if (i2 != 0) {
                        this.mNavController.setGraph(i2, null);
                        return;
                    }
                    Bundle arguments = getArguments();
                    if (arguments != null) {
                        i = arguments.getInt("android-support-nav:fragment:graphId");
                    }
                    if (arguments != null) {
                        bundle3 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
                    }
                    if (i != 0) {
                        this.mNavController.setGraph(i, bundle3);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        int id = getId();
        if (id == 0 || id == -1) {
            id = R$id.nav_host_fragment_container;
        }
        fragmentContainerView.setId(id);
        return fragmentContainerView;
    }

    public void onDestroyView() {
        super.onDestroyView();
        View view = this.mViewParent;
        if (view != null && CompoundButtonCompat.findNavController(view) == this.mNavController) {
            this.mViewParent.setTag(R$id.nav_controller_view_tag, null);
        }
        this.mViewParent = null;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.NavHost);
        int resourceId = obtainStyledAttributes.getResourceId(R$styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.mGraphId = resourceId;
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.NavHostFragment);
        if (obtainStyledAttributes2.getBoolean(R$styleable.NavHostFragment_defaultNavHost, false)) {
            this.mDefaultNavHost = true;
        }
        obtainStyledAttributes2.recycle();
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
        NavHostController navHostController = this.mNavController;
        if (navHostController != null) {
            navHostController.mEnableOnBackPressedCallback = z;
            navHostController.updateOnBackPressedCallbackEnabled();
            return;
        }
        this.mIsPrimaryBeforeOnCreate = Boolean.valueOf(z);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        NavHostController navHostController = this.mNavController;
        Bundle bundle2 = null;
        if (navHostController != null) {
            ArrayList arrayList = new ArrayList();
            Bundle bundle3 = new Bundle();
            for (Entry next : navHostController.mNavigatorProvider.mNavigators.entrySet()) {
                String str = (String) next.getKey();
                Bundle onSaveState = ((Navigator) next.getValue()).onSaveState();
                if (onSaveState != null) {
                    arrayList.add(str);
                    bundle3.putBundle(str, onSaveState);
                }
            }
            if (!arrayList.isEmpty()) {
                bundle2 = new Bundle();
                bundle3.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
                bundle2.putBundle("android-support-nav:controller:navigatorState", bundle3);
            }
            if (!navHostController.mBackStack.isEmpty()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                Parcelable[] parcelableArr = new Parcelable[navHostController.mBackStack.size()];
                int i = 0;
                for (NavBackStackEntry navBackStackEntryState : navHostController.mBackStack) {
                    parcelableArr[i] = new NavBackStackEntryState(navBackStackEntryState);
                    i++;
                }
                bundle2.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
            }
            if (navHostController.mDeepLinkHandled) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putBoolean("android-support-nav:controller:deepLinkHandled", navHostController.mDeepLinkHandled);
            }
            if (bundle2 != null) {
                bundle.putBundle("android-support-nav:fragment:navControllerState", bundle2);
            }
            if (this.mDefaultNavHost) {
                bundle.putBoolean("android-support-nav:fragment:defaultHost", true);
            }
            int i2 = this.mGraphId;
            if (i2 != 0) {
                bundle.putInt("android-support-nav:fragment:graphId", i2);
                return;
            }
            return;
        }
        throw null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (view instanceof ViewGroup) {
            view.setTag(R$id.nav_controller_view_tag, this.mNavController);
            if (view.getParent() != null) {
                View view2 = (View) view.getParent();
                this.mViewParent = view2;
                if (view2.getId() == getId()) {
                    this.mViewParent.setTag(R$id.nav_controller_view_tag, this.mNavController);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
    }
}
