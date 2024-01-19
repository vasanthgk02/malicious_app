package androidx.fragment.app;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import androidx.collection.MapCollections.EntrySet;
import androidx.collection.MapCollections.MapIterator;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.os.CancellationSignal.OnCancelListener;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentAnim.AnimationOrAnimator;
import androidx.fragment.app.FragmentAnim.EndViewTransitionAnimation;
import androidx.fragment.app.SpecialEffectsController.Operation;
import androidx.fragment.app.SpecialEffectsController.Operation.State;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|5|6|7|8|(3:9|10|12)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001d */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r0
                r1 = 1
                r2 = 2
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x000f }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 3
                int[] r3 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0016 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r4 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r3[r0] = r2     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r2 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r3 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x001d }
                r3 = 0
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State     // Catch:{ NoSuchFieldError -> 0x0024 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0024 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0024 }
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.<clinit>():void");
        }
    }

    public static class AnimationInfo extends SpecialEffectsInfo {
        public AnimationOrAnimator mAnimation;
        public boolean mIsPop;
        public boolean mLoadedAnim = false;

        public AnimationInfo(Operation operation, CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mIsPop = z;
        }

        public AnimationOrAnimator getAnimation(Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    public static class SpecialEffectsInfo {
        public final Operation mOperation;
        public final CancellationSignal mSignal;

        public SpecialEffectsInfo(Operation operation, CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        public Operation getOperation() {
            return this.mOperation;
        }

        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            State from = State.from(this.mOperation.getFragment().mView);
            State finalState = this.mOperation.getFinalState();
            if (from != finalState) {
                State state = State.VISIBLE;
                if (from == state || finalState == state) {
                    return false;
                }
            }
            return true;
        }
    }

    public static class TransitionInfo extends SpecialEffectsInfo {
        public final boolean mOverlapAllowed;
        public final Object mSharedElementTransition;
        public final Object mTransition;

        public TransitionInfo(Operation operation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            Object obj;
            Object obj2;
            boolean z3;
            super(operation, cancellationSignal);
            if (operation.getFinalState() == State.VISIBLE) {
                if (z) {
                    obj2 = operation.getFragment().getReenterTransition();
                } else {
                    obj2 = operation.getFragment().getEnterTransition();
                }
                this.mTransition = obj2;
                if (z) {
                    z3 = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    z3 = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = z3;
            } else {
                if (z) {
                    obj = operation.getFragment().getReturnTransition();
                } else {
                    obj = operation.getFragment().getExitTransition();
                }
                this.mTransition = obj;
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            outline73.append(getOperation().getFragment());
            outline73.append(" returned Transition ");
            outline73.append(this.mTransition);
            outline73.append(" which uses a different Transition  type than its shared element transition ");
            outline73.append(this.mSharedElementTransition);
            throw new IllegalArgumentException(outline73.toString());
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return FragmentTransition.PLATFORM_IMPL;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return FragmentTransition.SUPPORT_IMPL;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(List<AnimationInfo> list, List<Operation> list2, boolean z, Map<Operation, Boolean> map) {
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (AnimationInfo next : list) {
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                AnimationOrAnimator animation = next.getAnimation(context);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        final Operation operation = next.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.";
                            }
                            next.completeSpecialEffect();
                        } else {
                            final boolean z3 = operation.getFinalState() == State.GONE;
                            List<Operation> list3 = list2;
                            if (z3) {
                                list3.remove(operation);
                            }
                            View view = fragment.mView;
                            container.startViewTransition(view);
                            AnonymousClass2 r12 = r0;
                            View view2 = view;
                            final ViewGroup viewGroup = container;
                            final View view3 = view2;
                            final AnimationInfo animationInfo = next;
                            AnonymousClass2 r0 = new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    viewGroup.endViewTransition(view3);
                                    if (z3) {
                                        operation.getFinalState().applyState(view3);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            };
                            animator.addListener(r12);
                            animator.setTarget(view2);
                            animator.start();
                            next.getSignal().setOnCancelListener(new OnCancelListener() {
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
            Map<Operation, Boolean> map2 = map;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.";
                }
                animationInfo2.completeSpecialEffect();
            } else if (z2) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.";
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view4 = fragment2.mView;
                AnimationOrAnimator animation2 = animationInfo2.getAnimation(context);
                b.checkNotNull(animation2);
                Animation animation3 = animation2.animation;
                b.checkNotNull(animation3);
                Animation animation4 = animation3;
                if (operation2.getFinalState() != State.REMOVED) {
                    view4.startAnimation(animation4);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view4);
                    EndViewTransitionAnimation endViewTransitionAnimation = new EndViewTransitionAnimation(animation4, container, view4);
                    endViewTransitionAnimation.setAnimationListener(new AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            container.post(new Runnable() {
                                public void run() {
                                    AnonymousClass4 r0 = AnonymousClass4.this;
                                    container.endViewTransition(view4);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    view4.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new OnCancelListener() {
                    public void onCancel() {
                        view4.clearAnimation();
                        container.endViewTransition(view4);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    private Map<Operation, Boolean> startTransitions(List<TransitionInfo> list, List<Operation> list2, boolean z, Operation operation, Operation operation2) {
        ArrayList arrayList;
        Object obj;
        ArrayMap arrayMap;
        View view;
        ArrayList arrayList2;
        Object obj2;
        View view2;
        Rect rect;
        HashMap hashMap;
        Rect rect2;
        ArrayList arrayList3;
        Object obj3;
        View view3;
        Object obj4;
        Operation operation3;
        final ArrayList arrayList4;
        View view4;
        HashMap hashMap2;
        Rect rect3;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayMap arrayMap2;
        View view5;
        FragmentTransitionImpl fragmentTransitionImpl;
        SharedElementCallback sharedElementCallback;
        SharedElementCallback sharedElementCallback2;
        ArrayList<String> arrayList7;
        int i;
        View view6;
        ArrayList<String> arrayList8;
        boolean z2 = z;
        HashMap hashMap3 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo next : list) {
            if (!next.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = next.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (!(handlingImpl == null || fragmentTransitionImpl2 == handlingImpl)) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    outline73.append(next.getOperation().getFragment());
                    outline73.append(" returned Transition ");
                    outline73.append(next.getTransition());
                    outline73.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(outline73.toString());
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo next2 : list) {
                hashMap3.put(next2.getOperation(), Boolean.FALSE);
                next2.completeSpecialEffect();
            }
            return hashMap3;
        }
        View view7 = new View(getContainer().getContext());
        final Rect rect4 = new Rect();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayMap arrayMap3 = new ArrayMap();
        Object obj5 = null;
        Operation operation4 = operation;
        Operation operation5 = operation2;
        View view8 = null;
        boolean z3 = false;
        DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        for (TransitionInfo next3 : list) {
            if (!next3.hasSharedElementTransition() || operation4 == null || operation5 == null) {
                view4 = view8;
                arrayMap2 = arrayMap3;
                view5 = view7;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                Operation operation6 = operation;
                Operation operation7 = operation2;
                hashMap2 = hashMap3;
                arrayList6 = arrayList10;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next3.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList<String> arrayList11 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList11;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (!z2) {
                    sharedElementCallback2 = operation.getFragment().getExitTransitionCallback();
                    sharedElementCallback = operation2.getFragment().getEnterTransitionCallback();
                } else {
                    sharedElementCallback2 = operation.getFragment().getEnterTransitionCallback();
                    sharedElementCallback = operation2.getFragment().getExitTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                view4 = view8;
                int i3 = 0;
                while (i3 < size) {
                    arrayMap3.put(sharedElementSourceNames.get(i3), sharedElementTargetNames2.get(i3));
                    i3++;
                    size = size;
                    hashMap3 = hashMap3;
                }
                HashMap hashMap4 = hashMap3;
                ArrayMap arrayMap4 = new ArrayMap();
                defaultSpecialEffectsController.findNamedViews(arrayMap4, operation.getFragment().mView);
                MapCollections.retainAllHelper(arrayMap4, sharedElementSourceNames);
                if (sharedElementCallback2 != null) {
                    sharedElementCallback2.onMapSharedElements(sharedElementSourceNames, arrayMap4);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str = sharedElementSourceNames.get(size2);
                        View view9 = (View) arrayMap4.get(str);
                        if (view9 == null) {
                            arrayMap3.remove(str);
                            arrayList8 = sharedElementSourceNames;
                        } else {
                            arrayList8 = sharedElementSourceNames;
                            if (!str.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap3.put(view9.getTransitionName(), (String) arrayMap3.remove(str));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList8;
                    }
                    arrayList7 = sharedElementSourceNames;
                } else {
                    arrayList7 = sharedElementSourceNames;
                    MapCollections.retainAllHelper(arrayMap3, arrayMap4.keySet());
                }
                ArrayMap arrayMap5 = new ArrayMap();
                defaultSpecialEffectsController.findNamedViews(arrayMap5, operation2.getFragment().mView);
                MapCollections.retainAllHelper(arrayMap5, sharedElementTargetNames2);
                MapCollections.retainAllHelper(arrayMap5, arrayMap3.values());
                if (sharedElementCallback != null) {
                    sharedElementCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap5);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str2 = sharedElementTargetNames2.get(size3);
                        View view10 = (View) arrayMap5.get(str2);
                        if (view10 == null) {
                            String findKeyForValue = FragmentTransition.findKeyForValue(arrayMap3, str2);
                            if (findKeyForValue != null) {
                                arrayMap3.remove(findKeyForValue);
                            }
                        } else if (!str2.equals(ViewCompat.getTransitionName(view10))) {
                            String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap3, str2);
                            if (findKeyForValue2 != null) {
                                arrayMap3.put(findKeyForValue2, view10.getTransitionName());
                            }
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap3, arrayMap5);
                }
                defaultSpecialEffectsController.retainMatchingViews(arrayMap4, arrayMap3.keySet());
                defaultSpecialEffectsController.retainMatchingViews(arrayMap5, arrayMap3.values());
                if (arrayMap3.isEmpty()) {
                    arrayList9.clear();
                    arrayList10.clear();
                    obj5 = null;
                    operation4 = operation;
                    Operation operation8 = operation4;
                    operation5 = operation2;
                    arrayMap2 = arrayMap3;
                    arrayList6 = arrayList10;
                    view5 = view7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    hashMap2 = hashMap4;
                    Operation operation9 = operation5;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap4, true);
                    final Operation operation10 = operation2;
                    AnonymousClass6 r6 = r0;
                    final Operation operation11 = operation;
                    ArrayList<String> arrayList12 = sharedElementTargetNames2;
                    final boolean z4 = z;
                    ArrayList<String> arrayList13 = arrayList7;
                    ArrayMap arrayMap6 = arrayMap3;
                    ViewGroup container = getContainer();
                    final ArrayMap arrayMap7 = arrayMap5;
                    AnonymousClass6 r0 = new Runnable() {
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation10.getFragment(), operation11.getFragment(), z4, arrayMap7, false);
                        }
                    };
                    OneShotPreDrawListener.add(container, r6);
                    arrayList9.addAll(arrayMap4.values());
                    if (!arrayList13.isEmpty()) {
                        i = 0;
                        view6 = (View) arrayMap4.get(arrayList13.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view6);
                    } else {
                        i = 0;
                        view6 = view4;
                    }
                    arrayList10.addAll(arrayMap5.values());
                    if (!arrayList12.isEmpty()) {
                        final View view11 = (View) arrayMap5.get(arrayList12.get(i));
                        if (view11 != null) {
                            OneShotPreDrawListener.add(getContainer(), new Runnable() {
                                public void run() {
                                    fragmentTransitionImpl2.getBoundsOnScreen(view11, rect4);
                                }
                            });
                            z3 = true;
                            fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view7, arrayList9);
                            Object obj6 = wrapTransitionInSet;
                            arrayMap2 = arrayMap6;
                            arrayList6 = arrayList10;
                            Rect rect5 = rect4;
                            View view12 = view7;
                            fragmentTransitionImpl = fragmentTransitionImpl2;
                            fragmentTransitionImpl2.scheduleRemoveTargets(obj6, null, null, null, null, obj6, arrayList6);
                            Operation operation12 = operation;
                            hashMap2 = hashMap4;
                            hashMap2.put(operation12, Boolean.TRUE);
                            Operation operation13 = operation2;
                            hashMap2.put(operation13, Boolean.TRUE);
                            view4 = view6;
                            arrayList5 = arrayList9;
                            rect3 = rect5;
                            obj5 = obj6;
                            operation4 = operation12;
                            defaultSpecialEffectsController = this;
                            view5 = view12;
                            operation5 = operation13;
                            arrayMap3 = arrayMap2;
                            arrayList10 = arrayList6;
                            arrayList9 = arrayList5;
                            rect4 = rect3;
                            hashMap3 = hashMap2;
                            view8 = view4;
                            z2 = z;
                            fragmentTransitionImpl2 = fragmentTransitionImpl;
                            view7 = view5;
                        }
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view7, arrayList9);
                    Object obj62 = wrapTransitionInSet;
                    arrayMap2 = arrayMap6;
                    arrayList6 = arrayList10;
                    Rect rect52 = rect4;
                    View view122 = view7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(obj62, null, null, null, null, obj62, arrayList6);
                    Operation operation122 = operation;
                    hashMap2 = hashMap4;
                    hashMap2.put(operation122, Boolean.TRUE);
                    Operation operation132 = operation2;
                    hashMap2.put(operation132, Boolean.TRUE);
                    view4 = view6;
                    arrayList5 = arrayList9;
                    rect3 = rect52;
                    obj5 = obj62;
                    operation4 = operation122;
                    defaultSpecialEffectsController = this;
                    view5 = view122;
                    operation5 = operation132;
                    arrayMap3 = arrayMap2;
                    arrayList10 = arrayList6;
                    arrayList9 = arrayList5;
                    rect4 = rect3;
                    hashMap3 = hashMap2;
                    view8 = view4;
                    z2 = z;
                    fragmentTransitionImpl2 = fragmentTransitionImpl;
                    view7 = view5;
                }
            }
            rect3 = rect4;
            arrayList5 = arrayList9;
            arrayMap3 = arrayMap2;
            arrayList10 = arrayList6;
            arrayList9 = arrayList5;
            rect4 = rect3;
            hashMap3 = hashMap2;
            view8 = view4;
            z2 = z;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            view7 = view5;
        }
        View view13 = view8;
        ArrayMap arrayMap8 = arrayMap3;
        View view14 = view7;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        HashMap hashMap5 = hashMap3;
        ArrayList arrayList14 = arrayList10;
        Rect rect6 = rect4;
        ArrayList arrayList15 = arrayList9;
        ArrayList arrayList16 = new ArrayList();
        Object obj7 = null;
        Object obj8 = null;
        for (TransitionInfo next4 : list) {
            if (next4.isVisibilityUnchanged()) {
                hashMap5.put(next4.getOperation(), Boolean.FALSE);
                next4.completeSpecialEffect();
            } else {
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(next4.getTransition());
                Operation operation14 = next4.getOperation();
                boolean z5 = obj5 != null && (operation14 == operation4 || operation14 == operation5);
                if (cloneTransition == null) {
                    if (!z5) {
                        hashMap5.put(operation14, Boolean.FALSE);
                        next4.completeSpecialEffect();
                    }
                    List<Operation> list3 = list2;
                    arrayMap = arrayMap8;
                    obj = obj7;
                    arrayList = arrayList15;
                    rect = rect6;
                    obj2 = obj8;
                    arrayList2 = arrayList16;
                    view2 = view13;
                    view = view14;
                    hashMap = hashMap5;
                } else {
                    HashMap hashMap6 = hashMap5;
                    ArrayList arrayList17 = new ArrayList();
                    Object obj9 = obj8;
                    defaultSpecialEffectsController.captureTransitioningViews(arrayList17, operation14.getFragment().mView);
                    if (z5) {
                        if (operation14 == operation4) {
                            arrayList17.removeAll(arrayList15);
                        } else {
                            arrayList17.removeAll(arrayList14);
                        }
                    }
                    if (arrayList17.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view14);
                        obj3 = obj9;
                        arrayMap = arrayMap8;
                        obj = obj7;
                        arrayList3 = arrayList16;
                        arrayList = arrayList15;
                        rect2 = rect6;
                        arrayList4 = arrayList17;
                        view3 = view13;
                        view = view14;
                        obj4 = cloneTransition;
                        hashMap = hashMap6;
                        operation3 = operation14;
                        List<Operation> list4 = list2;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList17);
                        Object obj10 = cloneTransition;
                        view3 = view13;
                        obj3 = obj9;
                        Operation operation15 = operation14;
                        obj = obj7;
                        arrayList3 = arrayList16;
                        arrayList = arrayList15;
                        rect2 = rect6;
                        view = view14;
                        arrayMap = arrayMap8;
                        arrayList4 = arrayList17;
                        hashMap = hashMap6;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, obj10, arrayList17, null, null, null, null);
                        if (operation15.getFinalState() == State.GONE) {
                            operation3 = operation15;
                            list2.remove(operation3);
                            ArrayList arrayList18 = new ArrayList(arrayList4);
                            arrayList18.remove(operation3.getFragment().mView);
                            obj4 = obj10;
                            fragmentTransitionImpl3.scheduleHideFragmentView(obj4, operation3.getFragment().mView, arrayList18);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() {
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList4, 4);
                                }
                            });
                        } else {
                            List<Operation> list5 = list2;
                            operation3 = operation15;
                            obj4 = obj10;
                        }
                    }
                    if (operation3.getFinalState() == State.VISIBLE) {
                        arrayList2 = arrayList3;
                        arrayList2.addAll(arrayList4);
                        rect = rect2;
                        if (z3) {
                            fragmentTransitionImpl3.setEpicenter(obj4, rect);
                        }
                        view2 = view3;
                    } else {
                        view2 = view3;
                        arrayList2 = arrayList3;
                        rect = rect2;
                        fragmentTransitionImpl3.setEpicenter(obj4, view2);
                    }
                    hashMap.put(operation3, Boolean.TRUE);
                    if (next4.isOverlapAllowed()) {
                        obj2 = fragmentTransitionImpl3.mergeTransitionsTogether(obj3, obj4, null);
                    } else {
                        obj2 = obj3;
                        obj = fragmentTransitionImpl3.mergeTransitionsTogether(obj, obj4, null);
                    }
                }
                arrayList15 = arrayList;
                hashMap5 = hashMap;
                arrayList16 = arrayList2;
                view14 = view;
                rect6 = rect;
                view13 = view2;
                obj8 = obj2;
                arrayMap8 = arrayMap;
                obj7 = obj;
            }
        }
        ArrayMap arrayMap9 = arrayMap8;
        ArrayList arrayList19 = arrayList16;
        ArrayList arrayList20 = arrayList15;
        HashMap hashMap7 = hashMap5;
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj8, obj7, obj5);
        for (final TransitionInfo next5 : list) {
            if (!next5.isVisibilityUnchanged()) {
                Object transition = next5.getTransition();
                Operation operation16 = next5.getOperation();
                boolean z6 = obj5 != null && (operation16 == operation4 || operation16 == operation5);
                if (transition != null || z6) {
                    if (!ViewCompat.isLaidOut(getContainer())) {
                        if (FragmentManager.isLoggingEnabled(2)) {
                            StringBuilder outline732 = GeneratedOutlineSupport.outline73("SpecialEffectsController: Container ");
                            outline732.append(getContainer());
                            outline732.append(" has not been laid out. Completing operation ");
                            outline732.append(operation16);
                            outline732.toString();
                        }
                        next5.completeSpecialEffect();
                    } else {
                        fragmentTransitionImpl3.setListenerForTransitionEnd(next5.getOperation().getFragment(), mergeTransitionsInSequence, next5.getSignal(), new Runnable() {
                            public void run() {
                                next5.completeSpecialEffect();
                            }
                        });
                    }
                }
            }
        }
        if (!ViewCompat.isLaidOut(getContainer())) {
            return hashMap7;
        }
        FragmentTransition.setViewVisibility(arrayList19, 4);
        ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList14);
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList20, arrayList14, prepareSetNameOverridesReordered, arrayMap9);
        FragmentTransition.setViewVisibility(arrayList19, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj5, arrayList20, arrayList14);
        return hashMap7;
    }

    public void applyContainerChanges(Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!viewGroup.isTransitionGroup()) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        captureTransitioningViews(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void executeOperations(List<Operation> list, boolean z) {
        Operation operation = null;
        Operation operation2 = null;
        for (Operation next : list) {
            State from = State.from(next.getFragment().mView);
            int ordinal = next.getFinalState().ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (from != State.VISIBLE) {
                    operation2 = next;
                }
            }
            if (from == State.VISIBLE && operation == null) {
                operation = next;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        for (final Operation next2 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            next2.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(next2, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            next2.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (next2 != operation) {
                    arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                    next2.addCompletionListener(new Runnable() {
                        public void run() {
                            if (arrayList3.contains(next2)) {
                                arrayList3.remove(next2);
                                DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                            }
                        }
                    });
                }
            } else if (next2 != operation2) {
                arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                next2.addCompletionListener(new Runnable() {
                    public void run() {
                        if (arrayList3.contains(next2)) {
                            arrayList3.remove(next2);
                            DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                        }
                    }
                });
            }
            z2 = true;
            arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
            next2.addCompletionListener(new Runnable() {
                public void run() {
                    if (arrayList3.contains(next2)) {
                        arrayList3.remove(next2);
                        DefaultSpecialEffectsController.this.applyContainerChanges(next2);
                    }
                }
            });
        }
        Map<Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        Iterator it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges((Operation) it.next());
        }
        arrayList3.clear();
    }

    public void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Iterator it = ((EntrySet) arrayMap.entrySet()).iterator();
        while (true) {
            MapIterator mapIterator = (MapIterator) it;
            if (mapIterator.hasNext()) {
                mapIterator.next();
                if (!collection.contains(ViewCompat.getTransitionName((View) mapIterator.getValue()))) {
                    mapIterator.remove();
                }
            } else {
                return;
            }
        }
    }
}
