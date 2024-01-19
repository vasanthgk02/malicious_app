package androidx.transition;

import a.a.a.a.d.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.ContainerHelpers;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public abstract class Transition implements Cloneable {
    public static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    public static final PathMotion STRAIGHT_PATH_MOTION = new PathMotion() {
        public Path getPath(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    public static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    public ArrayList<Animator> mAnimators = new ArrayList<>();
    public boolean mCanRemoveViews = false;
    public ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    public long mDuration = -1;
    public TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    public ArrayList<TransitionValues> mEndValuesList;
    public boolean mEnded = false;
    public EpicenterCallback mEpicenterCallback;
    public TimeInterpolator mInterpolator = null;
    public ArrayList<TransitionListener> mListeners = null;
    public int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    public String mName = getClass().getName();
    public int mNumInstances = 0;
    public TransitionSet mParent = null;
    public PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    public boolean mPaused = false;
    public TransitionPropagation mPropagation;
    public long mStartDelay = -1;
    public TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    public ArrayList<TransitionValues> mStartValuesList;
    public ArrayList<View> mTargetChildExcludes = null;
    public ArrayList<View> mTargetExcludes = null;
    public ArrayList<Integer> mTargetIdChildExcludes = null;
    public ArrayList<Integer> mTargetIdExcludes = null;
    public ArrayList<Integer> mTargetIds = new ArrayList<>();
    public ArrayList<String> mTargetNameExcludes = null;
    public ArrayList<String> mTargetNames = null;
    public ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    public ArrayList<Class<?>> mTargetTypeExcludes = null;
    public ArrayList<Class<?>> mTargetTypes = null;
    public ArrayList<View> mTargets = new ArrayList<>();

    public static class AnimationInfo {
        public String mName;
        public Transition mTransition;
        public TransitionValues mValues;
        public View mView;
        public WindowIdImpl mWindowId;

        public AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
            this.mView = view;
            this.mName = str;
            this.mValues = transitionValues;
            this.mWindowId = windowIdImpl;
            this.mTransition = transition;
        }
    }

    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(Transition transition);
    }

    public interface TransitionListener {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    public Transition() {
    }

    public static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.mViewValues.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.mIdValues.indexOfKey(id) >= 0) {
                transitionValuesMaps.mIdValues.put(id, null);
            } else {
                transitionValuesMaps.mIdValues.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (transitionValuesMaps.mNameValues.indexOfKey(transitionName) >= 0) {
                transitionValuesMaps.mNameValues.put(transitionName, null);
            } else {
                transitionValuesMaps.mNameValues.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                LongSparseArray<View> longSparseArray = transitionValuesMaps.mItemIdValues;
                if (longSparseArray.mGarbage) {
                    longSparseArray.gc();
                }
                if (ContainerHelpers.binarySearch(longSparseArray.mKeys, longSparseArray.mSize, itemIdAtPosition) >= 0) {
                    View view2 = (View) transitionValuesMaps.mItemIdValues.get(itemIdAtPosition);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                transitionValuesMaps.mItemIdValues.put(itemIdAtPosition, view);
            }
        }
    }

    public static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    public static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    public Transition addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i = 0; i < size2; i++) {
                ((TransitionListener) arrayList2.get(i)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public final void captureHierarchy(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i = 0;
                        while (i < size) {
                            if (!this.mTargetTypeExcludes.get(i).isInstance(view)) {
                                i++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.mTargetedTransitions.add(this);
                        capturePropagationValues(transitionValues);
                        if (z) {
                            addViewValues(this.mStartValues, view, transitionValues);
                        } else {
                            addViewValues(this.mEndValues, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i2 = 0;
                                    while (i2 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                            i2++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                    captureHierarchy(viewGroup.getChildAt(i3), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void capturePropagationValues(TransitionValues transitionValues) {
        boolean z;
        if (this.mPropagation != null && !transitionValues.values.isEmpty()) {
            if (((VisibilityPropagation) this.mPropagation) != null) {
                String[] strArr = VisibilityPropagation.VISIBILITY_PROPAGATION_VALUES;
                if (strArr != null) {
                    int i = 0;
                    while (true) {
                        if (i >= strArr.length) {
                            z = true;
                            break;
                        } else if (!transitionValues.values.containsKey(strArr[i])) {
                            z = false;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z) {
                        if (((VisibilityPropagation) this.mPropagation) != null) {
                            View view = transitionValues.view;
                            Integer num = (Integer) transitionValues.values.get("android:visibility:visibility");
                            if (num == null) {
                                num = Integer.valueOf(view.getVisibility());
                            }
                            transitionValues.values.put("android:visibilityPropagation:visibility", num);
                            int[] iArr = new int[2];
                            view.getLocationOnScreen(iArr);
                            iArr[0] = Math.round(view.getTranslationX()) + iArr[0];
                            iArr[0] = (view.getWidth() / 2) + iArr[0];
                            iArr[1] = Math.round(view.getTranslationY()) + iArr[1];
                            iArr[1] = (view.getHeight() / 2) + iArr[1];
                            transitionValues.values.put("android:visibilityPropagation:center", iArr);
                        } else {
                            throw null;
                        }
                    }
                }
            } else {
                throw null;
            }
        }
    }

    public abstract void captureStartValues(TransitionValues transitionValues);

    public void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            ArrayList<String> arrayList = this.mTargetNames;
            if (arrayList == null || arrayList.isEmpty()) {
                ArrayList<Class<?>> arrayList2 = this.mTargetTypes;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    for (int i = 0; i < this.mTargetIds.size(); i++) {
                        View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                        if (findViewById != null) {
                            TransitionValues transitionValues = new TransitionValues(findViewById);
                            if (z) {
                                captureStartValues(transitionValues);
                            } else {
                                captureEndValues(transitionValues);
                            }
                            transitionValues.mTargetedTransitions.add(this);
                            capturePropagationValues(transitionValues);
                            if (z) {
                                addViewValues(this.mStartValues, findViewById, transitionValues);
                            } else {
                                addViewValues(this.mEndValues, findViewById, transitionValues);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                        View view = this.mTargets.get(i2);
                        TransitionValues transitionValues2 = new TransitionValues(view);
                        if (z) {
                            captureStartValues(transitionValues2);
                        } else {
                            captureEndValues(transitionValues2);
                        }
                        transitionValues2.mTargetedTransitions.add(this);
                        capturePropagationValues(transitionValues2);
                        if (z) {
                            addViewValues(this.mStartValues, view, transitionValues2);
                        } else {
                            addViewValues(this.mEndValues, view, transitionValues2);
                        }
                    }
                    return;
                }
            }
        }
        captureHierarchy(viewGroup, z);
    }

    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
            return;
        }
        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        this.mEndValues.mItemIdValues.clear();
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        int i;
        int i2;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        TransitionValues transitionValues2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            TransitionValues transitionValues3 = arrayList.get(i3);
            TransitionValues transitionValues4 = arrayList2.get(i3);
            if (transitionValues3 != null && !transitionValues3.mTargetedTransitions.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.mTargetedTransitions.contains(this)) {
                transitionValues4 = null;
            }
            if (!(transitionValues3 == null && transitionValues4 == null)) {
                if (transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) {
                    Animator createAnimator = createAnimator(viewGroup2, transitionValues3, transitionValues4);
                    if (createAnimator != null) {
                        if (transitionValues4 != null) {
                            view = transitionValues4.view;
                            String[] transitionProperties = getTransitionProperties();
                            if (transitionProperties != null && transitionProperties.length > 0) {
                                transitionValues2 = new TransitionValues(view);
                                Animator animator3 = createAnimator;
                                i2 = size;
                                TransitionValues transitionValues5 = (TransitionValues) transitionValuesMaps2.mViewValues.get(view);
                                if (transitionValues5 != null) {
                                    int i4 = 0;
                                    while (i4 < transitionProperties.length) {
                                        transitionValues2.values.put(transitionProperties[i4], transitionValues5.values.get(transitionProperties[i4]));
                                        i4++;
                                        ArrayList<TransitionValues> arrayList3 = arrayList2;
                                        i3 = i3;
                                        transitionValues5 = transitionValues5;
                                    }
                                }
                                i = i3;
                                int i5 = runningAnimators.mSize;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= i5) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    AnimationInfo animationInfo = (AnimationInfo) runningAnimators.get((Animator) runningAnimators.keyAt(i6));
                                    if (animationInfo.mValues != null && animationInfo.mView == view && animationInfo.mName.equals(this.mName) && animationInfo.mValues.equals(transitionValues2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i6++;
                                }
                            } else {
                                i2 = size;
                                i = i3;
                                animator2 = createAnimator;
                                transitionValues2 = null;
                            }
                            animator = animator2;
                            transitionValues = transitionValues2;
                        } else {
                            i2 = size;
                            i = i3;
                            view = transitionValues3.view;
                            animator = createAnimator;
                            transitionValues = null;
                        }
                        if (animator != null) {
                            TransitionPropagation transitionPropagation = this.mPropagation;
                            if (transitionPropagation != null) {
                                long startDelay = transitionPropagation.getStartDelay(viewGroup2, this, transitionValues3, transitionValues4);
                                sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                                j = Math.min(startDelay, j);
                            }
                            long j2 = j;
                            AnimationInfo animationInfo2 = new AnimationInfo(view, this.mName, this, ViewUtils.getWindowId(viewGroup), transitionValues);
                            runningAnimators.put(animator, animationInfo2);
                            this.mAnimators.add(animator);
                            j = j2;
                        }
                        i3 = i + 1;
                        size = i2;
                    }
                }
            }
            i2 = size;
            i = i3;
            i3 = i + 1;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i7 = 0; i7 < sparseIntArray.size(); i7++) {
                Animator animator4 = this.mAnimators.get(sparseIntArray.keyAt(i7));
                animator4.setStartDelay(animator4.getStartDelay() + (((long) sparseIntArray.valueAt(i7)) - j));
            }
        }
    }

    public void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((TransitionListener) arrayList2.get(i2)).onTransitionEnd(this);
                }
            }
            for (int i3 = 0; i3 < this.mStartValues.mItemIdValues.size(); i3++) {
                View view = (View) this.mStartValues.mItemIdValues.valueAt(i3);
                if (view != null) {
                    ViewCompat.setHasTransientState(view, false);
                }
            }
            for (int i4 = 0; i4 < this.mEndValues.mItemIdValues.size(); i4++) {
                View view2 = (View) this.mEndValues.mItemIdValues.valueAt(i4);
                if (view2 != null) {
                    ViewCompat.setHasTransientState(view2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
    }

    public TransitionValues getMatchedTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        ArrayList<TransitionValues> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        TransitionValues transitionValues = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            TransitionValues transitionValues2 = arrayList.get(i2);
            if (transitionValues2 == null) {
                return null;
            }
            if (transitionValues2.view == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            transitionValues = (TransitionValues) (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return transitionValues;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        return (TransitionValues) (z ? this.mStartValues : this.mEndValues).mViewValues.getOrDefault(view, null);
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i = 0;
            while (i < length) {
                if (!isValueChanged(transitionValues, transitionValues2, transitionProperties[i])) {
                    i++;
                }
            }
            return false;
        }
        for (String isValueChanged : transitionValues.values.keySet()) {
            if (isValueChanged(transitionValues, transitionValues2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList != null && arrayList.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList2 = this.mTargetExcludes;
        if (arrayList2 != null && arrayList2.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
        if (arrayList3 != null) {
            int size = arrayList3.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName(view) != null && this.mTargetNameExcludes.contains(view.getTransitionName())) {
            return false;
        }
        if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0) {
            ArrayList<Class<?>> arrayList4 = this.mTargetTypes;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                ArrayList<String> arrayList5 = this.mTargetNames;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    return true;
                }
            }
        }
        if (this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (this.mTargetTypes.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pause(View view) {
        if (!this.mEnded) {
            for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
                this.mCurrentAnimators.get(size).pause();
            }
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i = 0; i < size2; i++) {
                    ((TransitionListener) arrayList2.get(i)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    public Transition removeListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
                    this.mCurrentAnimators.get(size).resume();
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i = 0; i < size2; i++) {
                        ((TransitionListener) arrayList2.get(i)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        final ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                if (next != null) {
                    next.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            runningAnimators.remove(animator);
                            Transition.this.mCurrentAnimators.remove(animator);
                        }

                        public void onAnimationStart(Animator animator) {
                            Transition.this.mCurrentAnimators.add(animator);
                        }
                    });
                    long j = this.mDuration;
                    if (j >= 0) {
                        next.setDuration(j);
                    }
                    long j2 = this.mStartDelay;
                    if (j2 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.mInterpolator;
                    if (timeInterpolator != null) {
                        next.setInterpolator(timeInterpolator);
                    }
                    next.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            Transition.this.end();
                            animator.removeListener(this);
                        }
                    });
                    next.start();
                }
            }
        }
        this.mAnimators.clear();
        end();
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((TransitionListener) arrayList2.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String toString(String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
        outline73.append(getClass().getSimpleName());
        outline73.append(ColorPropConverter.PREFIX_RESOURCE);
        outline73.append(Integer.toHexString(hashCode()));
        outline73.append(": ");
        String sb = outline73.toString();
        if (this.mDuration != -1) {
            sb = GeneratedOutlineSupport.outline58(GeneratedOutlineSupport.outline78(sb, "dur("), this.mDuration, ") ");
        }
        if (this.mStartDelay != -1) {
            sb = GeneratedOutlineSupport.outline58(GeneratedOutlineSupport.outline78(sb, "dly("), this.mStartDelay, ") ");
        }
        if (this.mInterpolator != null) {
            StringBuilder outline78 = GeneratedOutlineSupport.outline78(sb, "interp(");
            outline78.append(this.mInterpolator);
            outline78.append(") ");
            sb = outline78.toString();
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return sb;
        }
        String outline50 = GeneratedOutlineSupport.outline50(sb, "tgts(");
        if (this.mTargetIds.size() > 0) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    outline50 = GeneratedOutlineSupport.outline50(outline50, ", ");
                }
                StringBuilder outline732 = GeneratedOutlineSupport.outline73(outline50);
                outline732.append(this.mTargetIds.get(i));
                outline50 = outline732.toString();
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    outline50 = GeneratedOutlineSupport.outline50(outline50, ", ");
                }
                StringBuilder outline733 = GeneratedOutlineSupport.outline73(outline50);
                outline733.append(this.mTargets.get(i2));
                outline50 = outline733.toString();
            }
        }
        return GeneratedOutlineSupport.outline50(outline50, ")");
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        boolean z;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = (long) b.getNamedInt(obtainStyledAttributes, xmlResourceParser, InlineAnimation.DURATION, 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = (long) b.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = b.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, InlineAnimation.INTERPOLATOR, 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = b.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(namedString, ",");
            int[] iArr = new int[stringTokenizer.countTokens()];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                if ("id".equalsIgnoreCase(trim)) {
                    iArr[i] = 3;
                } else if (DefaultSettingsSpiCall.INSTANCE_PARAM.equalsIgnoreCase(trim)) {
                    iArr[i] = 1;
                } else if ("name".equalsIgnoreCase(trim)) {
                    iArr[i] = 2;
                } else if ("itemId".equalsIgnoreCase(trim)) {
                    iArr[i] = 4;
                } else if (trim.isEmpty()) {
                    int[] iArr2 = new int[(iArr.length - 1)];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    i--;
                    iArr = iArr2;
                } else {
                    throw new InflateException(GeneratedOutlineSupport.outline52("Unknown match type in matchOrder: '", trim, "'"));
                }
                i++;
            }
            if (iArr.length == 0) {
                this.mMatchOrder = DEFAULT_MATCH_ORDER;
            } else {
                int i2 = 0;
                while (i2 < iArr.length) {
                    int i3 = iArr[i2];
                    if (i3 >= 1 && i3 <= 4) {
                        int i4 = iArr[i2];
                        int i5 = 0;
                        while (true) {
                            if (i5 >= i2) {
                                z = false;
                                break;
                            } else if (iArr[i5] == i4) {
                                z = true;
                                break;
                            } else {
                                i5++;
                            }
                        }
                        if (!z) {
                            i2++;
                        } else {
                            throw new IllegalArgumentException("matches contains a duplicate value");
                        }
                    } else {
                        throw new IllegalArgumentException("matches contains invalid value");
                    }
                }
                this.mMatchOrder = (int[]) iArr.clone();
            }
        }
        obtainStyledAttributes.recycle();
    }
}
