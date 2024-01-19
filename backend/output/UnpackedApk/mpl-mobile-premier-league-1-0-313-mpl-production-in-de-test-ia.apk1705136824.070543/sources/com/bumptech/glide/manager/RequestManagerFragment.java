package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {
    public final Set<RequestManagerFragment> childRequestManagerFragments = new HashSet();
    public final ActivityFragmentLifecycle lifecycle;
    public Fragment parentFragmentHint;
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode = new FragmentRequestManagerTreeNode();
    public RequestManagerFragment rootRequestManagerFragment;

    public class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public FragmentRequestManagerTreeNode() {
        }

        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> descendantRequestManagerFragments = RequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                RequestManager requestManager = requestManagerFragment.requestManager;
                if (requestManager != null) {
                    hashSet.add(requestManager);
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        ActivityFragmentLifecycle activityFragmentLifecycle = new ActivityFragmentLifecycle();
        this.lifecycle = activityFragmentLifecycle;
    }

    @TargetApi(17)
    public Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        boolean z;
        if (equals(this.rootRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment next : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            Fragment parentFragment = next.getParentFragment();
            Fragment parentFragment2 = getParentFragment();
            while (true) {
                Fragment parentFragment3 = parentFragment.getParentFragment();
                if (parentFragment3 == null) {
                    z = false;
                    break;
                } else if (parentFragment3.equals(parentFragment2)) {
                    z = true;
                    break;
                } else {
                    parentFragment = parentFragment.getParentFragment();
                }
            }
            if (z) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            registerFragmentWithRoot(activity);
        } catch (IllegalStateException unused) {
            boolean isLoggable = Log.isLoggable("RMFragment", 5);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    public void onDetach() {
        super.onDetach();
        unregisterFragmentWithRoot();
    }

    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public final void registerFragmentWithRoot(Activity activity) {
        unregisterFragmentWithRoot();
        RequestManagerRetriever requestManagerRetriever = Glide.get(activity).getRequestManagerRetriever();
        if (requestManagerRetriever != null) {
            RequestManagerFragment requestManagerFragment = requestManagerRetriever.getRequestManagerFragment(activity.getFragmentManager(), null, RequestManagerRetriever.isActivityVisible(activity));
            this.rootRequestManagerFragment = requestManagerFragment;
            if (!equals(requestManagerFragment)) {
                this.rootRequestManagerFragment.childRequestManagerFragments.add(this);
                return;
            }
            return;
        }
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.parentFragmentHint;
        }
        sb.append(parentFragment);
        sb.append("}");
        return sb.toString();
    }

    public final void unregisterFragmentWithRoot() {
        RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment != null) {
            requestManagerFragment.childRequestManagerFragments.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }
}
