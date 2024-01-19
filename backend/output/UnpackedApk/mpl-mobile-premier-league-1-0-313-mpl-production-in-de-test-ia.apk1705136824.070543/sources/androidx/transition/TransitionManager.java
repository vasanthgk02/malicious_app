package androidx.transition;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
    public static Transition sDefaultTransition = new AutoTransition();
    public static ArrayList<ViewGroup> sPendingTransitions = new ArrayList<>();
    public static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal<>();

    public static class MultiListener implements OnPreDrawListener, OnAttachStateChangeListener {
        public ViewGroup mSceneRoot;
        public Transition mTransition;

        public MultiListener(Transition transition, ViewGroup viewGroup) {
            this.mTransition = transition;
            this.mSceneRoot = viewGroup;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x02b0  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0078  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onPreDraw() {
            /*
                r19 = this;
                r0 = r19
                android.view.ViewGroup r1 = r0.mSceneRoot
                android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
                r1.removeOnPreDrawListener(r0)
                android.view.ViewGroup r1 = r0.mSceneRoot
                r1.removeOnAttachStateChangeListener(r0)
                java.util.ArrayList<android.view.ViewGroup> r1 = androidx.transition.TransitionManager.sPendingTransitions
                android.view.ViewGroup r2 = r0.mSceneRoot
                boolean r1 = r1.remove(r2)
                r2 = 1
                if (r1 != 0) goto L_0x001c
                return r2
            L_0x001c:
                androidx.collection.ArrayMap r1 = androidx.transition.TransitionManager.getRunningTransitions()
                android.view.ViewGroup r3 = r0.mSceneRoot
                java.lang.Object r3 = r1.get(r3)
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                r4 = 0
                if (r3 != 0) goto L_0x0036
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                android.view.ViewGroup r5 = r0.mSceneRoot
                r1.put(r5, r3)
                goto L_0x0042
            L_0x0036:
                int r5 = r3.size()
                if (r5 <= 0) goto L_0x0042
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>(r3)
                goto L_0x0043
            L_0x0042:
                r5 = r4
            L_0x0043:
                androidx.transition.Transition r6 = r0.mTransition
                r3.add(r6)
                androidx.transition.Transition r3 = r0.mTransition
                androidx.transition.TransitionManager$MultiListener$1 r6 = new androidx.transition.TransitionManager$MultiListener$1
                r6.<init>(r1)
                r3.addListener(r6)
                androidx.transition.Transition r1 = r0.mTransition
                android.view.ViewGroup r3 = r0.mSceneRoot
                r6 = 0
                r1.captureValues(r3, r6)
                if (r5 == 0) goto L_0x0072
                java.util.Iterator r1 = r5.iterator()
            L_0x0060:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto L_0x0072
                java.lang.Object r3 = r1.next()
                androidx.transition.Transition r3 = (androidx.transition.Transition) r3
                android.view.ViewGroup r5 = r0.mSceneRoot
                r3.resume(r5)
                goto L_0x0060
            L_0x0072:
                androidx.transition.Transition r1 = r0.mTransition
                android.view.ViewGroup r8 = r0.mSceneRoot
                if (r1 == 0) goto L_0x02b0
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r1.mStartValuesList = r3
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r1.mEndValuesList = r3
                androidx.transition.TransitionValuesMaps r3 = r1.mStartValues
                androidx.transition.TransitionValuesMaps r5 = r1.mEndValues
                androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
                androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> r9 = r3.mViewValues
                r7.<init>(r9)
                androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
                androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> r10 = r5.mViewValues
                r9.<init>(r10)
                r10 = 0
            L_0x0099:
                int[] r11 = r1.mMatchOrder
                int r12 = r11.length
                if (r10 >= r12) goto L_0x01ee
                r11 = r11[r10]
                if (r11 == r2) goto L_0x01ae
                r12 = 2
                if (r11 == r12) goto L_0x0160
                r12 = 3
                if (r11 == r12) goto L_0x010c
                r12 = 4
                if (r11 == r12) goto L_0x00ae
            L_0x00ab:
                r17 = r3
                goto L_0x0108
            L_0x00ae:
                androidx.collection.LongSparseArray<android.view.View> r11 = r3.mItemIdValues
                androidx.collection.LongSparseArray<android.view.View> r12 = r5.mItemIdValues
                int r13 = r11.size()
                r14 = 0
            L_0x00b7:
                if (r14 >= r13) goto L_0x00ab
                java.lang.Object r15 = r11.valueAt(r14)
                android.view.View r15 = (android.view.View) r15
                if (r15 == 0) goto L_0x00fe
                boolean r16 = r1.isValidTarget(r15)
                if (r16 == 0) goto L_0x00fe
                r17 = r3
                long r2 = r11.keyAt(r14)
                java.lang.Object r2 = r12.get(r2)
                android.view.View r2 = (android.view.View) r2
                if (r2 == 0) goto L_0x0100
                boolean r3 = r1.isValidTarget(r2)
                if (r3 == 0) goto L_0x0100
                java.lang.Object r3 = r7.getOrDefault(r15, r4)
                androidx.transition.TransitionValues r3 = (androidx.transition.TransitionValues) r3
                java.lang.Object r18 = r9.getOrDefault(r2, r4)
                r6 = r18
                androidx.transition.TransitionValues r6 = (androidx.transition.TransitionValues) r6
                if (r3 == 0) goto L_0x0100
                if (r6 == 0) goto L_0x0100
                java.util.ArrayList<androidx.transition.TransitionValues> r4 = r1.mStartValuesList
                r4.add(r3)
                java.util.ArrayList<androidx.transition.TransitionValues> r3 = r1.mEndValuesList
                r3.add(r6)
                r7.remove(r15)
                r9.remove(r2)
                goto L_0x0100
            L_0x00fe:
                r17 = r3
            L_0x0100:
                int r14 = r14 + 1
                r3 = r17
                r2 = 1
                r4 = 0
                r6 = 0
                goto L_0x00b7
            L_0x0108:
                r2 = r17
                goto L_0x01e4
            L_0x010c:
                r2 = r3
                android.util.SparseArray<android.view.View> r3 = r2.mIdValues
                android.util.SparseArray<android.view.View> r4 = r5.mIdValues
                int r6 = r3.size()
                r11 = 0
            L_0x0116:
                if (r11 >= r6) goto L_0x01e4
                java.lang.Object r12 = r3.valueAt(r11)
                android.view.View r12 = (android.view.View) r12
                if (r12 == 0) goto L_0x015b
                boolean r13 = r1.isValidTarget(r12)
                if (r13 == 0) goto L_0x015b
                int r13 = r3.keyAt(r11)
                java.lang.Object r13 = r4.get(r13)
                android.view.View r13 = (android.view.View) r13
                if (r13 == 0) goto L_0x015b
                boolean r14 = r1.isValidTarget(r13)
                if (r14 == 0) goto L_0x015b
                r14 = 0
                java.lang.Object r15 = r7.getOrDefault(r12, r14)
                androidx.transition.TransitionValues r15 = (androidx.transition.TransitionValues) r15
                java.lang.Object r17 = r9.getOrDefault(r13, r14)
                r14 = r17
                androidx.transition.TransitionValues r14 = (androidx.transition.TransitionValues) r14
                if (r15 == 0) goto L_0x015b
                if (r14 == 0) goto L_0x015b
                java.util.ArrayList<androidx.transition.TransitionValues> r0 = r1.mStartValuesList
                r0.add(r15)
                java.util.ArrayList<androidx.transition.TransitionValues> r0 = r1.mEndValuesList
                r0.add(r14)
                r7.remove(r12)
                r9.remove(r13)
            L_0x015b:
                int r11 = r11 + 1
                r0 = r19
                goto L_0x0116
            L_0x0160:
                r2 = r3
                androidx.collection.ArrayMap<java.lang.String, android.view.View> r0 = r2.mNameValues
                androidx.collection.ArrayMap<java.lang.String, android.view.View> r3 = r5.mNameValues
                int r4 = r0.mSize
                r6 = 0
            L_0x0168:
                if (r6 >= r4) goto L_0x01e4
                java.lang.Object r11 = r0.valueAt(r6)
                android.view.View r11 = (android.view.View) r11
                if (r11 == 0) goto L_0x01ab
                boolean r12 = r1.isValidTarget(r11)
                if (r12 == 0) goto L_0x01ab
                java.lang.Object r12 = r0.keyAt(r6)
                java.lang.Object r12 = r3.get(r12)
                android.view.View r12 = (android.view.View) r12
                if (r12 == 0) goto L_0x01ab
                boolean r13 = r1.isValidTarget(r12)
                if (r13 == 0) goto L_0x01ab
                r13 = 0
                java.lang.Object r14 = r7.getOrDefault(r11, r13)
                androidx.transition.TransitionValues r14 = (androidx.transition.TransitionValues) r14
                java.lang.Object r15 = r9.getOrDefault(r12, r13)
                androidx.transition.TransitionValues r15 = (androidx.transition.TransitionValues) r15
                if (r14 == 0) goto L_0x01ab
                if (r15 == 0) goto L_0x01ab
                java.util.ArrayList<androidx.transition.TransitionValues> r13 = r1.mStartValuesList
                r13.add(r14)
                java.util.ArrayList<androidx.transition.TransitionValues> r13 = r1.mEndValuesList
                r13.add(r15)
                r7.remove(r11)
                r9.remove(r12)
            L_0x01ab:
                int r6 = r6 + 1
                goto L_0x0168
            L_0x01ae:
                r2 = r3
                int r0 = r7.mSize
            L_0x01b1:
                int r0 = r0 + -1
                if (r0 < 0) goto L_0x01e4
                java.lang.Object r3 = r7.keyAt(r0)
                android.view.View r3 = (android.view.View) r3
                if (r3 == 0) goto L_0x01b1
                boolean r4 = r1.isValidTarget(r3)
                if (r4 == 0) goto L_0x01b1
                java.lang.Object r3 = r9.remove(r3)
                androidx.transition.TransitionValues r3 = (androidx.transition.TransitionValues) r3
                if (r3 == 0) goto L_0x01b1
                android.view.View r4 = r3.view
                boolean r4 = r1.isValidTarget(r4)
                if (r4 == 0) goto L_0x01b1
                java.lang.Object r4 = r7.removeAt(r0)
                androidx.transition.TransitionValues r4 = (androidx.transition.TransitionValues) r4
                java.util.ArrayList<androidx.transition.TransitionValues> r6 = r1.mStartValuesList
                r6.add(r4)
                java.util.ArrayList<androidx.transition.TransitionValues> r4 = r1.mEndValuesList
                r4.add(r3)
                goto L_0x01b1
            L_0x01e4:
                int r10 = r10 + 1
                r0 = r19
                r3 = r2
                r2 = 1
                r4 = 0
                r6 = 0
                goto L_0x0099
            L_0x01ee:
                r0 = 0
            L_0x01ef:
                int r2 = r7.mSize
                if (r0 >= r2) goto L_0x020f
                java.lang.Object r2 = r7.valueAt(r0)
                androidx.transition.TransitionValues r2 = (androidx.transition.TransitionValues) r2
                android.view.View r3 = r2.view
                boolean r3 = r1.isValidTarget(r3)
                if (r3 == 0) goto L_0x020c
                java.util.ArrayList<androidx.transition.TransitionValues> r3 = r1.mStartValuesList
                r3.add(r2)
                java.util.ArrayList<androidx.transition.TransitionValues> r2 = r1.mEndValuesList
                r3 = 0
                r2.add(r3)
            L_0x020c:
                int r0 = r0 + 1
                goto L_0x01ef
            L_0x020f:
                r0 = 0
            L_0x0210:
                int r2 = r9.mSize
                if (r0 >= r2) goto L_0x0230
                java.lang.Object r2 = r9.valueAt(r0)
                androidx.transition.TransitionValues r2 = (androidx.transition.TransitionValues) r2
                android.view.View r3 = r2.view
                boolean r3 = r1.isValidTarget(r3)
                if (r3 == 0) goto L_0x022d
                java.util.ArrayList<androidx.transition.TransitionValues> r3 = r1.mEndValuesList
                r3.add(r2)
                java.util.ArrayList<androidx.transition.TransitionValues> r2 = r1.mStartValuesList
                r3 = 0
                r2.add(r3)
            L_0x022d:
                int r0 = r0 + 1
                goto L_0x0210
            L_0x0230:
                androidx.collection.ArrayMap r0 = androidx.transition.Transition.getRunningAnimators()
                int r2 = r0.mSize
                androidx.transition.WindowIdImpl r3 = androidx.transition.ViewUtils.getWindowId(r8)
                r4 = 1
                int r2 = r2 - r4
            L_0x023c:
                if (r2 < 0) goto L_0x029f
                java.lang.Object r4 = r0.keyAt(r2)
                android.animation.Animator r4 = (android.animation.Animator) r4
                if (r4 == 0) goto L_0x029c
                r5 = 0
                java.lang.Object r6 = r0.getOrDefault(r4, r5)
                androidx.transition.Transition$AnimationInfo r6 = (androidx.transition.Transition.AnimationInfo) r6
                if (r6 == 0) goto L_0x029c
                android.view.View r5 = r6.mView
                if (r5 == 0) goto L_0x029c
                androidx.transition.WindowIdImpl r5 = r6.mWindowId
                boolean r5 = r3.equals(r5)
                if (r5 == 0) goto L_0x029c
                androidx.transition.TransitionValues r5 = r6.mValues
                android.view.View r7 = r6.mView
                r9 = 1
                androidx.transition.TransitionValues r10 = r1.getTransitionValues(r7, r9)
                androidx.transition.TransitionValues r11 = r1.getMatchedTransitionValues(r7, r9)
                if (r10 != 0) goto L_0x0277
                if (r11 != 0) goto L_0x0277
                androidx.transition.TransitionValuesMaps r9 = r1.mEndValues
                androidx.collection.ArrayMap<android.view.View, androidx.transition.TransitionValues> r9 = r9.mViewValues
                java.lang.Object r7 = r9.get(r7)
                r11 = r7
                androidx.transition.TransitionValues r11 = (androidx.transition.TransitionValues) r11
            L_0x0277:
                if (r10 != 0) goto L_0x027b
                if (r11 == 0) goto L_0x0285
            L_0x027b:
                androidx.transition.Transition r6 = r6.mTransition
                boolean r5 = r6.isTransitionRequired(r5, r11)
                if (r5 == 0) goto L_0x0285
                r5 = 1
                goto L_0x0286
            L_0x0285:
                r5 = 0
            L_0x0286:
                if (r5 == 0) goto L_0x029c
                boolean r5 = r4.isRunning()
                if (r5 != 0) goto L_0x0299
                boolean r5 = r4.isStarted()
                if (r5 == 0) goto L_0x0295
                goto L_0x0299
            L_0x0295:
                r0.remove(r4)
                goto L_0x029c
            L_0x0299:
                r4.cancel()
            L_0x029c:
                int r2 = r2 + -1
                goto L_0x023c
            L_0x029f:
                androidx.transition.TransitionValuesMaps r9 = r1.mStartValues
                androidx.transition.TransitionValuesMaps r10 = r1.mEndValues
                java.util.ArrayList<androidx.transition.TransitionValues> r11 = r1.mStartValuesList
                java.util.ArrayList<androidx.transition.TransitionValues> r12 = r1.mEndValuesList
                r7 = r1
                r7.createAnimators(r8, r9, r10, r11, r12)
                r1.runAnimators()
                r0 = 1
                return r0
            L_0x02b0:
                r0 = r4
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionManager.MultiListener.onPreDraw():boolean");
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
            this.mSceneRoot.removeOnAttachStateChangeListener(this);
            TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
            ArrayList arrayList = (ArrayList) TransitionManager.getRunningTransitions().get(this.mSceneRoot);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.mSceneRoot);
                }
            }
            this.mTransition.clearValues(true);
        }
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition) {
        if (!sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            Transition clone = transition.clone();
            ArrayList arrayList = (ArrayList) getRunningTransitions().getOrDefault(viewGroup, null);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).pause(viewGroup);
                }
            }
            if (clone != null) {
                clone.captureValues(viewGroup, true);
            }
            if (((Scene) viewGroup.getTag(R$id.transition_current_scene)) == null) {
                viewGroup.setTag(R$id.transition_current_scene, null);
                if (clone != null) {
                    MultiListener multiListener = new MultiListener(clone, viewGroup);
                    viewGroup.addOnAttachStateChangeListener(multiListener);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        WeakReference weakReference = sRunningTransitions.get();
        if (weakReference != null) {
            ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap = (ArrayMap) weakReference.get();
            if (arrayMap != null) {
                return arrayMap;
            }
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        sRunningTransitions.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }
}
