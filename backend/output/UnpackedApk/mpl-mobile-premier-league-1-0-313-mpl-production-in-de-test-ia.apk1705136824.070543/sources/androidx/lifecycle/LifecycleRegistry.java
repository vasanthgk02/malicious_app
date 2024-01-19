package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.DescendingIterator;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
    public int mAddingObserverCounter = 0;
    public final boolean mEnforceMainThread;
    public boolean mHandlingEvent = false;
    public final WeakReference<LifecycleOwner> mLifecycleOwner;
    public boolean mNewEventOccurred = false;
    public FastSafeIterableMap<LifecycleObserver, ObserverWithState> mObserverMap = new FastSafeIterableMap<>();
    public ArrayList<State> mParentStates = new ArrayList<>();
    public State mState;

    public static class ObserverWithState {
        public LifecycleEventObserver mLifecycleObserver;
        public State mState;

        public ObserverWithState(LifecycleObserver lifecycleObserver, State state) {
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.mState = state;
        }

        public void dispatchEvent(LifecycleOwner lifecycleOwner, Event event) {
            State targetState = event.getTargetState();
            this.mState = LifecycleRegistry.min(this.mState, targetState);
            this.mLifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.mState = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this.mLifecycleOwner = new WeakReference<>(lifecycleOwner);
        this.mState = State.INITIALIZED;
        this.mEnforceMainThread = true;
    }

    public static State min(State state, State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    public void addObserver(LifecycleObserver lifecycleObserver) {
        enforceMainThreadIfNeeded("addObserver");
        State state = this.mState;
        State state2 = State.DESTROYED;
        if (state != state2) {
            state2 = State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, state2);
        if (((ObserverWithState) this.mObserverMap.putIfAbsent(lifecycleObserver, observerWithState)) == null) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) this.mLifecycleOwner.get();
            if (lifecycleOwner != null) {
                boolean z = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
                State calculateTargetState = calculateTargetState(lifecycleObserver);
                this.mAddingObserverCounter++;
                while (observerWithState.mState.compareTo(calculateTargetState) < 0 && this.mObserverMap.mHashMap.containsKey(lifecycleObserver)) {
                    this.mParentStates.add(observerWithState.mState);
                    Event upFrom = Event.upFrom(observerWithState.mState);
                    if (upFrom != null) {
                        observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                        popParentState();
                        calculateTargetState = calculateTargetState(lifecycleObserver);
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("no event up from ");
                        outline73.append(observerWithState.mState);
                        throw new IllegalStateException(outline73.toString());
                    }
                }
                if (!z) {
                    sync();
                }
                this.mAddingObserverCounter--;
            }
        }
    }

    public final State calculateTargetState(LifecycleObserver lifecycleObserver) {
        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.mObserverMap;
        State state = null;
        Entry entry = fastSafeIterableMap.mHashMap.containsKey(lifecycleObserver) ? fastSafeIterableMap.mHashMap.get(lifecycleObserver).mPrevious : null;
        State state2 = entry != null ? ((ObserverWithState) entry.getValue()).mState : null;
        if (!this.mParentStates.isEmpty()) {
            ArrayList<State> arrayList = this.mParentStates;
            state = arrayList.get(arrayList.size() - 1);
        }
        return min(min(this.mState, state2), state);
    }

    @SuppressLint({"RestrictedApi"})
    public final void enforceMainThreadIfNeeded(String str) {
        if (this.mEnforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException(GeneratedOutlineSupport.outline52("Method ", str, " must be called on the main thread"));
        }
    }

    public void handleLifecycleEvent(Event event) {
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    public final void moveToState(State state) {
        if (this.mState != state) {
            this.mState = state;
            if (this.mHandlingEvent || this.mAddingObserverCounter != 0) {
                this.mNewEventOccurred = true;
                return;
            }
            this.mHandlingEvent = true;
            sync();
            this.mHandlingEvent = false;
        }
    }

    public final void popParentState() {
        ArrayList<State> arrayList = this.mParentStates;
        arrayList.remove(arrayList.size() - 1);
    }

    public void removeObserver(LifecycleObserver lifecycleObserver) {
        enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.remove(lifecycleObserver);
    }

    public void setCurrentState(State state) {
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    public final void sync() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this.mLifecycleOwner.get();
        if (lifecycleOwner != null) {
            while (true) {
                FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.mObserverMap;
                boolean z = true;
                if (fastSafeIterableMap.mSize != 0) {
                    State state = ((ObserverWithState) fastSafeIterableMap.mStart.mValue).mState;
                    State state2 = ((ObserverWithState) fastSafeIterableMap.mEnd.mValue).mState;
                    if (!(state == state2 && this.mState == state2)) {
                        z = false;
                    }
                }
                if (!z) {
                    this.mNewEventOccurred = false;
                    if (this.mState.compareTo(((ObserverWithState) this.mObserverMap.mStart.mValue).mState) < 0) {
                        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap2 = this.mObserverMap;
                        DescendingIterator descendingIterator = new DescendingIterator(fastSafeIterableMap2.mEnd, fastSafeIterableMap2.mStart);
                        fastSafeIterableMap2.mIterators.put(descendingIterator, Boolean.FALSE);
                        while (descendingIterator.hasNext() && !this.mNewEventOccurred) {
                            Entry entry = (Entry) descendingIterator.next();
                            ObserverWithState observerWithState = (ObserverWithState) entry.getValue();
                            while (observerWithState.mState.compareTo(this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains(entry.getKey())) {
                                Event downFrom = Event.downFrom(observerWithState.mState);
                                if (downFrom != null) {
                                    this.mParentStates.add(downFrom.getTargetState());
                                    observerWithState.dispatchEvent(lifecycleOwner, downFrom);
                                    popParentState();
                                } else {
                                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("no event down from ");
                                    outline73.append(observerWithState.mState);
                                    throw new IllegalStateException(outline73.toString());
                                }
                            }
                        }
                    }
                    SafeIterableMap.Entry<K, V> entry2 = this.mObserverMap.mEnd;
                    if (!this.mNewEventOccurred && entry2 != null && this.mState.compareTo(((ObserverWithState) entry2.mValue).mState) > 0) {
                        IteratorWithAdditions iteratorWithAdditions = this.mObserverMap.iteratorWithAdditions();
                        while (iteratorWithAdditions.hasNext() && !this.mNewEventOccurred) {
                            Entry entry3 = (Entry) iteratorWithAdditions.next();
                            ObserverWithState observerWithState2 = (ObserverWithState) entry3.getValue();
                            while (observerWithState2.mState.compareTo(this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains(entry3.getKey())) {
                                this.mParentStates.add(observerWithState2.mState);
                                Event upFrom = Event.upFrom(observerWithState2.mState);
                                if (upFrom != null) {
                                    observerWithState2.dispatchEvent(lifecycleOwner, upFrom);
                                    popParentState();
                                } else {
                                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("no event up from ");
                                    outline732.append(observerWithState2.mState);
                                    throw new IllegalStateException(outline732.toString());
                                }
                            }
                        }
                    }
                } else {
                    this.mNewEventOccurred = false;
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }
}
