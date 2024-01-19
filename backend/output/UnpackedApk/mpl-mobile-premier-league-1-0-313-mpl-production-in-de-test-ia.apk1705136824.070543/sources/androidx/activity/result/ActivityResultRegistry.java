package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {
    public final transient Map<String, CallbackAndContract<?>> mKeyToCallback = new HashMap();
    public final Map<String, LifecycleContainer> mKeyToLifecycleContainers = new HashMap();
    public final Map<String, Integer> mKeyToRc = new HashMap();
    public ArrayList<String> mLaunchedKeys = new ArrayList<>();
    public final Map<String, Object> mParsedPendingResults = new HashMap();
    public final Bundle mPendingResults = new Bundle();
    public Random mRandom = new Random();
    public final Map<Integer, String> mRcToKey = new HashMap();

    public static class CallbackAndContract<O> {
        public final ActivityResultCallback<O> mCallback;
        public final ActivityResultContract<?, O> mContract;

        public CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.mCallback = activityResultCallback;
            this.mContract = activityResultContract;
        }
    }

    public static class LifecycleContainer {
        public final Lifecycle mLifecycle;
        public final ArrayList<LifecycleEventObserver> mObservers = new ArrayList<>();

        public LifecycleContainer(Lifecycle lifecycle) {
            this.mLifecycle = lifecycle;
        }
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = this.mRcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.mLaunchedKeys.remove(str);
        CallbackAndContract callbackAndContract = this.mKeyToCallback.get(str);
        if (callbackAndContract != null) {
            ActivityResultCallback<O> activityResultCallback = callbackAndContract.mCallback;
            if (activityResultCallback != null) {
                activityResultCallback.onActivityResult(callbackAndContract.mContract.parseResult(i2, intent));
                return true;
            }
        }
        this.mParsedPendingResults.remove(str);
        this.mPendingResults.putParcelable(str, new ActivityResult(i2, intent));
        return true;
    }

    public abstract <I, O> void onLaunch(int i, ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i2, ActivityOptionsCompat activityOptionsCompat);

    public final <I, O> ActivityResultLauncher<I> register(final String str, LifecycleOwner lifecycleOwner, final ActivityResultContract<I, O> activityResultContract, final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycle;
        if (!lifecycleRegistry.mState.isAtLeast(State.STARTED)) {
            final int registerKey = registerKey(str);
            LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            AnonymousClass1 r0 = new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Event event) {
                    if (Event.ON_START.equals(event)) {
                        ActivityResultRegistry.this.mKeyToCallback.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
                        if (ActivityResultRegistry.this.mParsedPendingResults.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.mParsedPendingResults.get(str);
                            ActivityResultRegistry.this.mParsedPendingResults.remove(str);
                            activityResultCallback.onActivityResult(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.mPendingResults.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.mPendingResults.remove(str);
                            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.mResultCode, activityResult.mData));
                        }
                    } else if (Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.mKeyToCallback.remove(str);
                    } else if (Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.unregister(str);
                    }
                }
            };
            lifecycleContainer.mLifecycle.addObserver(r0);
            lifecycleContainer.mObservers.add(r0);
            this.mKeyToLifecycleContainers.put(str, lifecycleContainer);
            return new ActivityResultLauncher<I>() {
                public ActivityResultContract<I, ?> getContract() {
                    return activityResultContract;
                }

                public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                    ActivityResultRegistry.this.mLaunchedKeys.add(str);
                    Integer num = ActivityResultRegistry.this.mKeyToRc.get(str);
                    ActivityResultRegistry.this.onLaunch(num != null ? num.intValue() : registerKey, activityResultContract, i, activityOptionsCompat);
                }

                public void unregister() {
                    ActivityResultRegistry.this.unregister(str);
                }
            };
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycleRegistry.mState + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final int registerKey(String str) {
        Integer num = this.mKeyToRc.get(str);
        if (num != null) {
            return num.intValue();
        }
        int nextInt = this.mRandom.nextInt(2147418112);
        while (true) {
            int i = nextInt + 65536;
            if (this.mRcToKey.containsKey(Integer.valueOf(i))) {
                nextInt = this.mRandom.nextInt(2147418112);
            } else {
                this.mRcToKey.put(Integer.valueOf(i), str);
                this.mKeyToRc.put(str, Integer.valueOf(i));
                return i;
            }
        }
    }

    public final void unregister(String str) {
        if (!this.mLaunchedKeys.contains(str)) {
            Integer remove = this.mKeyToRc.remove(str);
            if (remove != null) {
                this.mRcToKey.remove(remove);
            }
        }
        this.mKeyToCallback.remove(str);
        if (this.mParsedPendingResults.containsKey(str)) {
            StringBuilder outline80 = GeneratedOutlineSupport.outline80("Dropping pending result for request ", str, ": ");
            outline80.append(this.mParsedPendingResults.get(str));
            outline80.toString();
            this.mParsedPendingResults.remove(str);
        }
        if (this.mPendingResults.containsKey(str)) {
            StringBuilder outline802 = GeneratedOutlineSupport.outline80("Dropping pending result for request ", str, ": ");
            outline802.append(this.mPendingResults.getParcelable(str));
            outline802.toString();
            this.mPendingResults.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.mKeyToLifecycleContainers.get(str);
        if (lifecycleContainer != null) {
            Iterator<LifecycleEventObserver> it = lifecycleContainer.mObservers.iterator();
            while (it.hasNext()) {
                lifecycleContainer.mLifecycle.removeObserver(it.next());
            }
            lifecycleContainer.mObservers.clear();
            this.mKeyToLifecycleContainers.remove(str);
        }
    }

    public final <I, O> ActivityResultLauncher<I> register(final String str, final ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        final int registerKey = registerKey(str);
        this.mKeyToCallback.put(str, new CallbackAndContract(activityResultCallback, activityResultContract));
        if (this.mParsedPendingResults.containsKey(str)) {
            Object obj = this.mParsedPendingResults.get(str);
            this.mParsedPendingResults.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.mPendingResults.getParcelable(str);
        if (activityResult != null) {
            this.mPendingResults.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.mResultCode, activityResult.mData));
        }
        return new ActivityResultLauncher<I>() {
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }

            public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
                ActivityResultRegistry.this.mLaunchedKeys.add(str);
                Integer num = ActivityResultRegistry.this.mKeyToRc.get(str);
                ActivityResultRegistry.this.onLaunch(num != null ? num.intValue() : registerKey, activityResultContract, i, activityOptionsCompat);
            }

            public void unregister() {
                ActivityResultRegistry.this.unregister(str);
            }
        };
    }
}
