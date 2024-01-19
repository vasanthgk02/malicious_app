package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController {
    public Activity mActivity;
    public final Deque<NavBackStackEntry> mBackStack = new ArrayDeque();
    public Parcelable[] mBackStackToRestore;
    public final Context mContext;
    public boolean mDeepLinkHandled;
    public boolean mEnableOnBackPressedCallback = true;
    public NavGraph mGraph;
    public NavInflater mInflater;
    public final LifecycleObserver mLifecycleObserver = new LifecycleEventObserver() {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
            State state;
            NavController navController = NavController.this;
            if (navController.mGraph != null) {
                for (NavBackStackEntry next : navController.mBackStack) {
                    if (next != null) {
                        int ordinal = event.ordinal();
                        if (ordinal != 0) {
                            if (ordinal != 1) {
                                if (ordinal == 2) {
                                    state = State.RESUMED;
                                } else if (ordinal != 3) {
                                    if (ordinal != 4) {
                                        if (ordinal == 5) {
                                            state = State.DESTROYED;
                                        } else {
                                            throw new IllegalArgumentException("Unexpected event value " + event);
                                        }
                                    }
                                }
                                next.mHostLifecycle = state;
                                next.updateState();
                            }
                            state = State.STARTED;
                            next.mHostLifecycle = state;
                            next.updateState();
                        }
                        state = State.CREATED;
                        next.mHostLifecycle = state;
                        next.updateState();
                    } else {
                        throw null;
                    }
                }
            }
        }
    };
    public LifecycleOwner mLifecycleOwner;
    public NavigatorProvider mNavigatorProvider = new NavigatorProvider();
    public Bundle mNavigatorStateToRestore;
    public final OnBackPressedCallback mOnBackPressedCallback = new OnBackPressedCallback(false) {
        public void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    };
    public final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList<>();
    public NavControllerViewModel mViewModel;

    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    public NavController(Context context) {
        this.mContext = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        NavigatorProvider navigatorProvider = this.mNavigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
    }

    public final boolean dispatchOnDestinationChanged() {
        while (!this.mBackStack.isEmpty() && (this.mBackStack.peekLast().mDestination instanceof NavGraph)) {
            if (!popBackStackInternal(this.mBackStack.peekLast().mDestination.mId, true)) {
                break;
            }
        }
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        NavDestination navDestination = this.mBackStack.peekLast().mDestination;
        NavDestination navDestination2 = null;
        if (navDestination instanceof FloatingWindow) {
            Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                NavDestination navDestination3 = descendingIterator.next().mDestination;
                if (!(navDestination3 instanceof NavGraph) && !(navDestination3 instanceof FloatingWindow)) {
                    navDestination2 = navDestination3;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<NavBackStackEntry> descendingIterator2 = this.mBackStack.descendingIterator();
        while (descendingIterator2.hasNext()) {
            NavBackStackEntry next = descendingIterator2.next();
            State state = next.mMaxLifecycle;
            NavDestination navDestination4 = next.mDestination;
            if (navDestination != null && navDestination4.mId == navDestination.mId) {
                State state2 = State.RESUMED;
                if (state != state2) {
                    hashMap.put(next, state2);
                }
                navDestination = navDestination.mParent;
            } else if (navDestination2 == null || navDestination4.mId != navDestination2.mId) {
                next.mMaxLifecycle = State.CREATED;
                next.updateState();
            } else {
                if (state == State.RESUMED) {
                    next.mMaxLifecycle = State.STARTED;
                    next.updateState();
                } else {
                    State state3 = State.STARTED;
                    if (state != state3) {
                        hashMap.put(next, state3);
                    }
                }
                navDestination2 = navDestination2.mParent;
            }
        }
        for (NavBackStackEntry next2 : this.mBackStack) {
            State state4 = (State) hashMap.get(next2);
            if (state4 != null) {
                next2.mMaxLifecycle = state4;
                next2.updateState();
            } else {
                next2.updateState();
            }
        }
        NavBackStackEntry peekLast = this.mBackStack.peekLast();
        Iterator<OnDestinationChangedListener> it = this.mOnDestinationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onDestinationChanged(this, peekLast.mDestination, peekLast.mArgs);
        }
        return true;
    }

    public NavDestination findDestination(int i) {
        NavDestination navDestination;
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 == null) {
            return null;
        }
        if (navGraph2.mId == i) {
            return navGraph2;
        }
        if (this.mBackStack.isEmpty()) {
            navDestination = this.mGraph;
        } else {
            navDestination = this.mBackStack.getLast().mDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.mParent;
        }
        return navGraph.findNode(i, true);
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry navBackStackEntry;
        if (this.mBackStack.isEmpty()) {
            navBackStackEntry = null;
        } else {
            navBackStackEntry = this.mBackStack.getLast();
        }
        if (navBackStackEntry != null) {
            return navBackStackEntry.mDestination;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void navigate(androidx.navigation.NavDestination r20, android.os.Bundle r21, androidx.navigation.NavOptions r22, androidx.navigation.Navigator.Extras r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            r3 = 0
            if (r2 == 0) goto L_0x0015
            int r4 = r2.mPopUpTo
            r5 = -1
            if (r4 == r5) goto L_0x0015
            boolean r5 = r2.mPopUpToInclusive
            boolean r4 = r0.popBackStackInternal(r4, r5)
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            androidx.navigation.NavigatorProvider r5 = r0.mNavigatorProvider
            java.lang.String r6 = r1.mNavigatorName
            androidx.navigation.Navigator r5 = r5.getNavigator(r6)
            android.os.Bundle r12 = r20.addInDefaultArgs(r21)
            r6 = 0
            androidx.navigation.NavDestination r1 = r5.navigate(r1, r12, r2, r6)
            r5 = 1
            if (r1 == 0) goto L_0x00b9
            boolean r2 = r1 instanceof androidx.navigation.FloatingWindow
            if (r2 != 0) goto L_0x0057
        L_0x002e:
            java.util.Deque<androidx.navigation.NavBackStackEntry> r2 = r0.mBackStack
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0057
            java.util.Deque<androidx.navigation.NavBackStackEntry> r2 = r0.mBackStack
            java.lang.Object r2 = r2.peekLast()
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.navigation.NavDestination r2 = r2.mDestination
            boolean r2 = r2 instanceof androidx.navigation.FloatingWindow
            if (r2 == 0) goto L_0x0057
            java.util.Deque<androidx.navigation.NavBackStackEntry> r2 = r0.mBackStack
            java.lang.Object r2 = r2.peekLast()
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.navigation.NavDestination r2 = r2.mDestination
            int r2 = r2.mId
            boolean r2 = r0.popBackStackInternal(r2, r5)
            if (r2 == 0) goto L_0x0057
            goto L_0x002e
        L_0x0057:
            java.util.Deque<androidx.navigation.NavBackStackEntry> r2 = r0.mBackStack
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0073
            androidx.navigation.NavBackStackEntry r2 = new androidx.navigation.NavBackStackEntry
            android.content.Context r7 = r0.mContext
            androidx.navigation.NavGraph r8 = r0.mGraph
            androidx.lifecycle.LifecycleOwner r10 = r0.mLifecycleOwner
            androidx.navigation.NavControllerViewModel r11 = r0.mViewModel
            r6 = r2
            r9 = r12
            r6.<init>(r7, r8, r9, r10, r11)
            java.util.Deque<androidx.navigation.NavBackStackEntry> r5 = r0.mBackStack
            r5.add(r2)
        L_0x0073:
            java.util.ArrayDeque r2 = new java.util.ArrayDeque
            r2.<init>()
            r5 = r1
        L_0x0079:
            if (r5 == 0) goto L_0x0099
            int r6 = r5.mId
            androidx.navigation.NavDestination r6 = r0.findDestination(r6)
            if (r6 != 0) goto L_0x0099
            androidx.navigation.NavGraph r5 = r5.mParent
            if (r5 == 0) goto L_0x0079
            androidx.navigation.NavBackStackEntry r13 = new androidx.navigation.NavBackStackEntry
            android.content.Context r7 = r0.mContext
            androidx.lifecycle.LifecycleOwner r10 = r0.mLifecycleOwner
            androidx.navigation.NavControllerViewModel r11 = r0.mViewModel
            r6 = r13
            r8 = r5
            r9 = r12
            r6.<init>(r7, r8, r9, r10, r11)
            r2.addFirst(r13)
            goto L_0x0079
        L_0x0099:
            java.util.Deque<androidx.navigation.NavBackStackEntry> r5 = r0.mBackStack
            r5.addAll(r2)
            androidx.navigation.NavBackStackEntry r2 = new androidx.navigation.NavBackStackEntry
            android.content.Context r14 = r0.mContext
            android.os.Bundle r16 = r1.addInDefaultArgs(r12)
            androidx.lifecycle.LifecycleOwner r5 = r0.mLifecycleOwner
            androidx.navigation.NavControllerViewModel r6 = r0.mViewModel
            r13 = r2
            r15 = r1
            r17 = r5
            r18 = r6
            r13.<init>(r14, r15, r16, r17, r18)
            java.util.Deque<androidx.navigation.NavBackStackEntry> r5 = r0.mBackStack
            r5.add(r2)
            goto L_0x00ce
        L_0x00b9:
            if (r2 == 0) goto L_0x00ce
            boolean r2 = r2.mSingleTop
            if (r2 == 0) goto L_0x00ce
            java.util.Deque<androidx.navigation.NavBackStackEntry> r2 = r0.mBackStack
            java.lang.Object r2 = r2.peekLast()
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            if (r2 == 0) goto L_0x00cd
            r3 = r21
            r2.mArgs = r3
        L_0x00cd:
            r3 = 1
        L_0x00ce:
            r19.updateOnBackPressedCallbackEnabled()
            if (r4 != 0) goto L_0x00d7
            if (r1 != 0) goto L_0x00d7
            if (r3 == 0) goto L_0x00da
        L_0x00d7:
            r19.dispatchOnDestinationChanged()
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):void");
    }

    public boolean popBackStack() {
        boolean z = false;
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        if (popBackStackInternal(getCurrentDestination().mId, true) && dispatchOnDestinationChanged()) {
            z = true;
        }
        return z;
    }

    public boolean popBackStackInternal(int i, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.mBackStack.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NavBackStackEntry> descendingIterator = this.mBackStack.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            NavDestination navDestination = descendingIterator.next().mDestination;
            Navigator navigator = this.mNavigatorProvider.getNavigator(navDestination.mNavigatorName);
            if (z || navDestination.mId != i) {
                arrayList.add(navigator);
            }
            if (navDestination.mId == i) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            NavDestination.getDisplayName(this.mContext, i);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            NavBackStackEntry removeLast = this.mBackStack.removeLast();
            removeLast.mMaxLifecycle = State.DESTROYED;
            removeLast.updateState();
            NavControllerViewModel navControllerViewModel = this.mViewModel;
            if (navControllerViewModel != null) {
                ViewModelStore remove = navControllerViewModel.mViewModelStores.remove(removeLast.mId);
                if (remove != null) {
                    remove.clear();
                }
            }
            z3 = true;
        }
        updateOnBackPressedCallbackEnabled();
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02a8, code lost:
        if (r1 == false) goto L_0x02ab;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setGraph(int r19, android.os.Bundle r20) {
        /*
            r18 = this;
            r0 = r18
            androidx.navigation.NavInflater r1 = r0.mInflater
            if (r1 != 0) goto L_0x0011
            androidx.navigation.NavInflater r1 = new androidx.navigation.NavInflater
            android.content.Context r2 = r0.mContext
            androidx.navigation.NavigatorProvider r3 = r0.mNavigatorProvider
            r1.<init>(r2, r3)
            r0.mInflater = r1
        L_0x0011:
            androidx.navigation.NavInflater r1 = r0.mInflater
            r2 = r19
            androidx.navigation.NavGraph r1 = r1.inflate(r2)
            androidx.navigation.NavGraph r2 = r0.mGraph
            r3 = 1
            if (r2 == 0) goto L_0x0023
            int r2 = r2.mId
            r0.popBackStackInternal(r2, r3)
        L_0x0023:
            r0.mGraph = r1
            android.os.Bundle r1 = r0.mNavigatorStateToRestore
            if (r1 == 0) goto L_0x0053
            java.lang.String r2 = "android-support-nav:controller:navigatorState:names"
            java.util.ArrayList r1 = r1.getStringArrayList(r2)
            if (r1 == 0) goto L_0x0053
            java.util.Iterator r1 = r1.iterator()
        L_0x0035:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0053
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            androidx.navigation.NavigatorProvider r4 = r0.mNavigatorProvider
            androidx.navigation.Navigator r4 = r4.getNavigator(r2)
            android.os.Bundle r5 = r0.mNavigatorStateToRestore
            android.os.Bundle r2 = r5.getBundle(r2)
            if (r2 == 0) goto L_0x0035
            r4.onRestoreState(r2)
            goto L_0x0035
        L_0x0053:
            android.os.Parcelable[] r1 = r0.mBackStackToRestore
            java.lang.String r2 = " cannot be found from the current destination "
            r4 = 0
            r5 = 0
            if (r1 == 0) goto L_0x00b8
            int r6 = r1.length
            r7 = 0
        L_0x005d:
            if (r7 >= r6) goto L_0x00b3
            r8 = r1[r7]
            androidx.navigation.NavBackStackEntryState r8 = (androidx.navigation.NavBackStackEntryState) r8
            int r9 = r8.mDestinationId
            androidx.navigation.NavDestination r12 = r0.findDestination(r9)
            if (r12 == 0) goto L_0x0094
            android.os.Bundle r13 = r8.mArgs
            if (r13 == 0) goto L_0x0078
            android.content.Context r9 = r0.mContext
            java.lang.ClassLoader r9 = r9.getClassLoader()
            r13.setClassLoader(r9)
        L_0x0078:
            androidx.navigation.NavBackStackEntry r9 = new androidx.navigation.NavBackStackEntry
            android.content.Context r11 = r0.mContext
            androidx.lifecycle.LifecycleOwner r14 = r0.mLifecycleOwner
            androidx.navigation.NavControllerViewModel r15 = r0.mViewModel
            java.util.UUID r10 = r8.mUUID
            android.os.Bundle r8 = r8.mSavedState
            r16 = r10
            r10 = r9
            r17 = r8
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            java.util.Deque<androidx.navigation.NavBackStackEntry> r8 = r0.mBackStack
            r8.add(r9)
            int r7 = r7 + 1
            goto L_0x005d
        L_0x0094:
            android.content.Context r1 = r0.mContext
            int r3 = r8.mDestinationId
            java.lang.String r1 = androidx.navigation.NavDestination.getDisplayName(r1, r3)
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Restoring the Navigation back stack failed: destination "
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r4, r1, r2)
            androidx.navigation.NavDestination r2 = r18.getCurrentDestination()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r3.<init>(r1)
            throw r3
        L_0x00b3:
            r18.updateOnBackPressedCallbackEnabled()
            r0.mBackStackToRestore = r4
        L_0x00b8:
            androidx.navigation.NavGraph r1 = r0.mGraph
            if (r1 == 0) goto L_0x02b6
            java.util.Deque<androidx.navigation.NavBackStackEntry> r1 = r0.mBackStack
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x02b6
            boolean r1 = r0.mDeepLinkHandled
            if (r1 != 0) goto L_0x02ab
            android.app.Activity r1 = r0.mActivity
            if (r1 == 0) goto L_0x02ab
            android.content.Intent r1 = r1.getIntent()
            if (r1 != 0) goto L_0x00d4
            goto L_0x02a7
        L_0x00d4:
            android.os.Bundle r6 = r1.getExtras()
            if (r6 == 0) goto L_0x00e1
            java.lang.String r7 = "android-support-nav:controller:deepLinkIds"
            int[] r7 = r6.getIntArray(r7)
            goto L_0x00e2
        L_0x00e1:
            r7 = r4
        L_0x00e2:
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            if (r6 == 0) goto L_0x00f0
            java.lang.String r9 = "android-support-nav:controller:deepLinkExtras"
            android.os.Bundle r6 = r6.getBundle(r9)
            goto L_0x00f1
        L_0x00f0:
            r6 = r4
        L_0x00f1:
            if (r6 == 0) goto L_0x00f6
            r8.putAll(r6)
        L_0x00f6:
            if (r7 == 0) goto L_0x00fb
            int r6 = r7.length
            if (r6 != 0) goto L_0x014e
        L_0x00fb:
            android.net.Uri r6 = r1.getData()
            if (r6 == 0) goto L_0x014e
            androidx.navigation.NavGraph r6 = r0.mGraph
            androidx.navigation.NavDeepLinkRequest r9 = new androidx.navigation.NavDeepLinkRequest
            r9.<init>(r1)
            androidx.navigation.NavDestination$DeepLinkMatch r6 = r6.matchDeepLink(r9)
            if (r6 == 0) goto L_0x014e
            androidx.navigation.NavDestination r7 = r6.mDestination
            if (r7 == 0) goto L_0x014d
            java.util.ArrayDeque r9 = new java.util.ArrayDeque
            r9.<init>()
        L_0x0117:
            androidx.navigation.NavGraph r10 = r7.mParent
            if (r10 == 0) goto L_0x0121
            int r11 = r10.mStartDestId
            int r12 = r7.mId
            if (r11 == r12) goto L_0x0124
        L_0x0121:
            r9.addFirst(r7)
        L_0x0124:
            if (r10 != 0) goto L_0x014b
            int r7 = r9.size()
            int[] r7 = new int[r7]
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x0131:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0145
            java.lang.Object r11 = r9.next()
            androidx.navigation.NavDestination r11 = (androidx.navigation.NavDestination) r11
            int r12 = r10 + 1
            int r11 = r11.mId
            r7[r10] = r11
            r10 = r12
            goto L_0x0131
        L_0x0145:
            android.os.Bundle r6 = r6.mMatchingArgs
            r8.putAll(r6)
            goto L_0x014e
        L_0x014b:
            r7 = r10
            goto L_0x0117
        L_0x014d:
            throw r4
        L_0x014e:
            if (r7 == 0) goto L_0x02a7
            int r6 = r7.length
            if (r6 != 0) goto L_0x0155
            goto L_0x02a7
        L_0x0155:
            androidx.navigation.NavGraph r6 = r0.mGraph
            r9 = 0
        L_0x0158:
            int r10 = r7.length
            if (r9 >= r10) goto L_0x0194
            r10 = r7[r9]
            if (r9 != 0) goto L_0x0168
            androidx.navigation.NavGraph r11 = r0.mGraph
            int r12 = r11.mId
            if (r12 != r10) goto L_0x0166
            goto L_0x016c
        L_0x0166:
            r11 = r4
            goto L_0x016c
        L_0x0168:
            androidx.navigation.NavDestination r11 = r6.findNode(r10)
        L_0x016c:
            if (r11 != 0) goto L_0x0175
            android.content.Context r6 = r0.mContext
            java.lang.String r6 = androidx.navigation.NavDestination.getDisplayName(r6, r10)
            goto L_0x0195
        L_0x0175:
            int r10 = r7.length
            int r10 = r10 + -1
            if (r9 == r10) goto L_0x0191
            androidx.navigation.NavGraph r11 = (androidx.navigation.NavGraph) r11
        L_0x017c:
            int r6 = r11.mStartDestId
            androidx.navigation.NavDestination r6 = r11.findNode(r6)
            boolean r6 = r6 instanceof androidx.navigation.NavGraph
            if (r6 == 0) goto L_0x0190
            int r6 = r11.mStartDestId
            androidx.navigation.NavDestination r6 = r11.findNode(r6)
            r11 = r6
            androidx.navigation.NavGraph r11 = (androidx.navigation.NavGraph) r11
            goto L_0x017c
        L_0x0190:
            r6 = r11
        L_0x0191:
            int r9 = r9 + 1
            goto L_0x0158
        L_0x0194:
            r6 = r4
        L_0x0195:
            if (r6 == 0) goto L_0x01b1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Could not find destination "
            r2.append(r5)
            r2.append(r6)
            java.lang.String r5 = " in the navigation graph, ignoring the deep link from "
            r2.append(r5)
            r2.append(r1)
            r2.toString()
            goto L_0x02a7
        L_0x01b1:
            java.lang.String r6 = "android-support-nav:controller:deepLinkIntent"
            r8.putParcelable(r6, r1)
            int r6 = r1.getFlags()
            r9 = 268435456(0x10000000, float:2.524355E-29)
            r9 = r9 & r6
            if (r9 == 0) goto L_0x01e3
            r10 = 32768(0x8000, float:4.5918E-41)
            r6 = r6 & r10
            if (r6 != 0) goto L_0x01e3
            r1.addFlags(r10)
            android.content.Context r2 = r0.mContext
            androidx.core.app.TaskStackBuilder r2 = androidx.core.app.TaskStackBuilder.create(r2)
            androidx.core.app.TaskStackBuilder r1 = r2.addNextIntentWithParentStack(r1)
            r1.startActivities()
            android.app.Activity r1 = r0.mActivity
            if (r1 == 0) goto L_0x02a5
            r1.finish()
            android.app.Activity r1 = r0.mActivity
            r1.overridePendingTransition(r5, r5)
            goto L_0x02a5
        L_0x01e3:
            java.lang.String r1 = "Deep Linking failed: destination "
            if (r9 == 0) goto L_0x0234
            java.util.Deque<androidx.navigation.NavBackStackEntry> r5 = r0.mBackStack
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x01f6
            androidx.navigation.NavGraph r5 = r0.mGraph
            int r5 = r5.mId
            r0.popBackStackInternal(r5, r3)
        L_0x01f6:
            r5 = 0
        L_0x01f7:
            int r6 = r7.length
            if (r5 >= r6) goto L_0x02a5
            int r6 = r5 + 1
            r5 = r7[r5]
            androidx.navigation.NavDestination r9 = r0.findDestination(r5)
            if (r9 == 0) goto L_0x0219
            r13 = 0
            r11 = 0
            r17 = -1
            r14 = 0
            r15 = 0
            androidx.navigation.NavOptions r5 = new androidx.navigation.NavOptions
            r10 = r5
            r12 = r17
            r16 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            r0.navigate(r9, r8, r5, r4)
            r5 = r6
            goto L_0x01f7
        L_0x0219:
            android.content.Context r3 = r0.mContext
            java.lang.String r3 = androidx.navigation.NavDestination.getDisplayName(r3, r5)
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r1, r3, r2)
            androidx.navigation.NavDestination r2 = r18.getCurrentDestination()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r4.<init>(r1)
            throw r4
        L_0x0234:
            androidx.navigation.NavGraph r2 = r0.mGraph
            r5 = 0
        L_0x0237:
            int r6 = r7.length
            if (r5 >= r6) goto L_0x02a3
            r6 = r7[r5]
            if (r5 != 0) goto L_0x0241
            androidx.navigation.NavGraph r9 = r0.mGraph
            goto L_0x0245
        L_0x0241:
            androidx.navigation.NavDestination r9 = r2.findNode(r6)
        L_0x0245:
            if (r9 == 0) goto L_0x0280
            int r6 = r7.length
            int r6 = r6 - r3
            if (r5 == r6) goto L_0x0263
            androidx.navigation.NavGraph r9 = (androidx.navigation.NavGraph) r9
        L_0x024d:
            int r2 = r9.mStartDestId
            androidx.navigation.NavDestination r2 = r9.findNode(r2)
            boolean r2 = r2 instanceof androidx.navigation.NavGraph
            if (r2 == 0) goto L_0x0261
            int r2 = r9.mStartDestId
            androidx.navigation.NavDestination r2 = r9.findNode(r2)
            r9 = r2
            androidx.navigation.NavGraph r9 = (androidx.navigation.NavGraph) r9
            goto L_0x024d
        L_0x0261:
            r2 = r9
            goto L_0x027d
        L_0x0263:
            android.os.Bundle r6 = r9.addInDefaultArgs(r8)
            r11 = 0
            r17 = -1
            androidx.navigation.NavGraph r10 = r0.mGraph
            int r12 = r10.mId
            r13 = 1
            r14 = 0
            r15 = 0
            androidx.navigation.NavOptions r10 = new androidx.navigation.NavOptions
            r19 = r10
            r16 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            r0.navigate(r9, r6, r10, r4)
        L_0x027d:
            int r5 = r5 + 1
            goto L_0x0237
        L_0x0280:
            android.content.Context r3 = r0.mContext
            java.lang.String r3 = androidx.navigation.NavDestination.getDisplayName(r3, r6)
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = " cannot be found in graph "
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = r5.toString()
            r4.<init>(r1)
            throw r4
        L_0x02a3:
            r0.mDeepLinkHandled = r3
        L_0x02a5:
            r1 = 1
            goto L_0x02a8
        L_0x02a7:
            r1 = 0
        L_0x02a8:
            if (r1 == 0) goto L_0x02ab
            goto L_0x02ac
        L_0x02ab:
            r3 = 0
        L_0x02ac:
            if (r3 != 0) goto L_0x02b9
            androidx.navigation.NavGraph r1 = r0.mGraph
            r2 = r20
            r0.navigate(r1, r2, r4, r4)
            goto L_0x02b9
        L_0x02b6:
            r18.dispatchOnDestinationChanged()
        L_0x02b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.setGraph(int, android.os.Bundle):void");
    }

    public final void updateOnBackPressedCallbackEnabled() {
        OnBackPressedCallback onBackPressedCallback = this.mOnBackPressedCallback;
        boolean z = false;
        if (this.mEnableOnBackPressedCallback) {
            int i = 0;
            for (NavBackStackEntry navBackStackEntry : this.mBackStack) {
                if (!(navBackStackEntry.mDestination instanceof NavGraph)) {
                    i++;
                }
            }
            if (i > 1) {
                z = true;
            }
        }
        onBackPressedCallback.setEnabled(z);
    }
}
